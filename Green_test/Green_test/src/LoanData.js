import React, { useEffect, useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import axios from 'axios';
import { Box, Typography, TextField } from '@mui/material';
import './LoanData.css';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
import { USE_MOCK_DATA, mockLoanTableData } from './mockDashboardData';

const BASE_URL = 'https://noncbsuat.bankofbaroda.co.in/green-project/api/v1';

const LoanData = () => {
  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [loading, setLoading] = useState(false);
  const dt = useRef(null);

  // Load all data on mount
  useEffect(() => {
    fetchAllData();
  }, []);

  const fetchAllData = async () => {
    setLoading(true);
    if (USE_MOCK_DATA) {
      setTimeout(() => {
        setData(mockLoanTableData);
        setFilteredData(mockLoanTableData);
        setLoading(false);
      }, 400);
      return;
    }
    try {
      const response = await axios.get(`${BASE_URL}/ViewDetailsLoan`);
      if (response.status === 200) {
        setData(response.data);
        setFilteredData(response.data);
      }
    } catch (error) {
      console.error('Error fetching loan accounts, using mock data:', error);
      setData(mockLoanTableData);
      setFilteredData(mockLoanTableData);
    } finally {
      setLoading(false);
    }
  };

  const handleDateFilter = async () => {
    if (!startDate || !endDate) return;
    setLoading(true);
    try {
      if (USE_MOCK_DATA) {
        // Use local filtering on mock data
        const filtered = data.filter(item => {
          if (!item.AccountOpenedDate) return false;
          const itemDate = parseDate(item.AccountOpenedDate);
          const start = new Date(startDate);
          const end = new Date(endDate);
          return itemDate >= start && itemDate <= end;
        });
        setFilteredData(filtered.length > 0 ? filtered : data);
        setLoading(false);
        return;
      }
      // API expects dd-mm-yyyy format
      const from = formatDateForApi(startDate);
      const to = formatDateForApi(endDate);
      const response = await axios.post(`${BASE_URL}/ViewDetailsLoanDatewise/${to}/${from}`);
      if (response.status === 200) {
        setFilteredData(response.data);
      }
    } catch (error) {
      console.error('Error fetching date-filtered loan data, filtering locally:', error);
      const filtered = data.filter(item => {
        if (!item.AccountOpenedDate) return false;
        const itemDate = parseDate(item.AccountOpenedDate);
        const start = new Date(startDate);
        const end = new Date(endDate);
        return itemDate >= start && itemDate <= end;
      });
      setFilteredData(filtered);
    } finally {
      setLoading(false);
    }
  };

  const formatDateForApi = (dateStr) => {
    // Input: yyyy-mm-dd (from HTML date input), Output: dd-mm-yyyy
    const [y, m, d] = dateStr.split('-');
    return `${d}-${m}-${y}`;
  };

  const parseDate = (dateStr) => {
    if (!dateStr) return new Date(0);
    // Try dd-mm-yyyy
    const parts = dateStr.split('-');
    if (parts.length === 3 && parts[0].length <= 2) {
      return new Date(parts[2], parts[1] - 1, parts[0]);
    }
    return new Date(dateStr);
  };

  const renderHeader = () => (
    <Box sx={{ display: 'flex', justifyContent: 'flex-end', p: 1 }}>
      <Button
        label="Export as CSV"
        icon="pi pi-file"
        className="p-button-help"
        style={{ padding: '12px 24px', fontSize: '15px' }}
        onClick={() => dt.current.exportCSV()}
      />
    </Box>
  );

  return (
    <div className="loan-data-container">
      <div className="loan-data-content">
        <Box sx={{ mb: 2 }}>
          <Typography variant="h5" sx={{ mb: 2, color: '#0d3520', fontWeight: 800 }}>
            Loan Dashboard
          </Typography>
        </Box>

        {/* Date Range Filter */}
        <Box sx={{
          display: 'flex', alignItems: 'center', gap: 2, mb: 3, p: 2,
          background: 'linear-gradient(135deg, #ecfdf3 0%, #dcfce7 100%)',
          borderRadius: 2, border: '1px solid rgba(34, 197, 94, 0.2)',
          boxShadow: '0 4px 12px rgba(13, 53, 32, 0.08)',
          flexWrap: 'wrap',
        }}>
          <Typography sx={{ fontWeight: 600, color: '#0d3520', minWidth: 'fit-content' }}>
            Account Opened Date:
          </Typography>
          <TextField
            label="Start Date"
            type="date"
            size="small"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
            InputLabelProps={{ shrink: true }}
            sx={{ backgroundColor: '#fff', borderRadius: 1, minWidth: 170 }}
          />
          <TextField
            label="End Date"
            type="date"
            size="small"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
            InputLabelProps={{ shrink: true }}
            sx={{ backgroundColor: '#fff', borderRadius: 1, minWidth: 170 }}
          />
          <Button
            label="Submit"
            icon="pi pi-search"
            className="p-button-success"
            style={{ padding: '10px 24px', fontSize: '14px', backgroundColor: '#134B2A', border: 'none', borderRadius: '6px' }}
            onClick={handleDateFilter}
          />
        </Box>

        <h1 className="loan-data-title">Details of Loan Accounts as on date (All Values in Rs. Absolute Number)</h1>

        <DataTable
          ref={dt}
          value={filteredData}
          responsiveLayout="scroll"
          dataKey="AccountNumber"
          paginator
          rows={10}
          rowsPerPageOptions={[5, 10, 25]}
          header={renderHeader()}
          loading={loading}
          emptyMessage="No loan records found."
          className="custom-datatable"
          exportFilename="Loan_Dashboard"
        >
          <Column header="S.No" body={(rowData, { rowIndex }) => rowIndex + 1} style={{ minWidth: '4rem' }} />
          <Column field="zone" header="Zone" sortable style={{ minWidth: '8rem' }} />
          <Column field="Region" header="Region" sortable style={{ minWidth: '8rem' }} />
          <Column field="SolDesc" header="Sol Description" sortable style={{ minWidth: '10rem' }} />
          <Column field="SolID" header="Sol ID" sortable style={{ minWidth: '6rem' }} />
          <Column field="CustId" header="Cust ID" sortable style={{ minWidth: '8rem' }} />
          <Column field="AccountNumber" header="AccountNumber" sortable style={{ minWidth: '10rem' }} />
          <Column field="AccountName" header="Name of the Account" sortable style={{ minWidth: '12rem' }} />
          <Column field="AccountOpenedDate" header="Account Opened Date" sortable style={{ minWidth: '10rem' }} />
          <Column field="SantionLimitDate" header="Limit Sanction Date" sortable style={{ minWidth: '10rem' }} />
          <Column field="AggregateDisbursementAmount" header="Aggregate Disbursement Amount" sortable style={{ minWidth: '12rem' }} />
          <Column field="OutstandingAmount" header="Outstanding Amount" sortable style={{ minWidth: '10rem' }} />
          <Column field="Maturity" header="Maturity" sortable style={{ minWidth: '8rem' }} />
          <Column field="AccountSegment" header="Account Segment" sortable style={{ minWidth: '10rem' }} />
        </DataTable>
      </div>
    </div>
  );
};

export default LoanData;
