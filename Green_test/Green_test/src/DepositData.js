import React, { useEffect, useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import axios from 'axios';
import { Box, Typography, TextField } from '@mui/material';
import './DepositData.css';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
import { USE_MOCK_DATA, mockDepositTableData } from './mockDashboardData';

const BASE_URL = 'https://noncbsuat.bankofbaroda.co.in/green-project/api/v1';

const DepositData = () => {
  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [loading, setLoading] = useState(false);
  const dt = useRef(null);

  useEffect(() => {
    fetchAllData();
  }, []);

  const fetchAllData = async () => {
    setLoading(true);
    if (USE_MOCK_DATA) {
      setTimeout(() => {
        setData(mockDepositTableData);
        setFilteredData(mockDepositTableData);
        setLoading(false);
      }, 400);
      return;
    }
    try {
      const response = await axios.get(`${BASE_URL}/ViewDetailsDeposit`);
      if (response.status === 200) {
        setData(response.data);
        setFilteredData(response.data);
      }
    } catch (error) {
      console.error('Error fetching deposit data, using mock data:', error);
      setData(mockDepositTableData);
      setFilteredData(mockDepositTableData);
    } finally {
      setLoading(false);
    }
  };

  const handleDateFilter = async () => {
    if (!startDate || !endDate) return;
    setLoading(true);
    try {
      if (USE_MOCK_DATA) {
        const filtered = data.filter(item => {
          if (!item.accountopeningdate) return false;
          const itemDate = parseDate(item.accountopeningdate);
          const start = new Date(startDate);
          const end = new Date(endDate);
          return itemDate >= start && itemDate <= end;
        });
        setFilteredData(filtered.length > 0 ? filtered : data);
        setLoading(false);
        return;
      }
      const from = formatDateForApi(startDate);
      const to = formatDateForApi(endDate);
      const response = await axios.post(`${BASE_URL}/ViewDetailsDepositDatewise/${to}/${from}`);
      if (response.status === 200) {
        setFilteredData(response.data);
      }
    } catch (error) {
      console.error('Error fetching date-filtered deposit data:', error);
      const filtered = data.filter(item => {
        if (!item.accountopeningdate) return false;
        const itemDate = parseDate(item.accountopeningdate);
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
    const [y, m, d] = dateStr.split('-');
    return `${d}-${m}-${y}`;
  };

  const parseDate = (dateStr) => {
    if (!dateStr) return new Date(0);
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
    <div className="green-deposit-container">
      <div className="green-deposit-content">
        <Box sx={{ mb: 2 }}>
          <Typography variant="h5" sx={{ mb: 2, color: '#0d3520', fontWeight: 800 }}>
            Deposit Position
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

        <h1 className="green-deposit-title">Green Deposit Position (No in Actual & Amount in Rs)</h1>

        <DataTable
          className="custom-datatable"
          ref={dt}
          value={filteredData}
          dataKey="accountno"
          paginator
          rows={10}
          rowsPerPageOptions={[5, 10, 25]}
          header={renderHeader()}
          loading={loading}
          emptyMessage="No deposit records found."
          exportFilename="Green_Deposit_Position"
          responsiveLayout="scroll"
        >
          <Column header="S.No" body={(rowData, { rowIndex }) => rowIndex + 1} style={{ minWidth: '4rem' }} />
          <Column field="zone" header="Zone Name" sortable style={{ minWidth: '8rem' }} />
          <Column field="region" header="Region Name" sortable style={{ minWidth: '8rem' }} />
          <Column field="solid" header="Sol ID" sortable style={{ minWidth: '6rem' }} />
          <Column field="branchcode" header="Branch Code" sortable style={{ minWidth: '8rem' }} />
          <Column field="custid" header="CustomerId" sortable style={{ minWidth: '8rem' }} />
          <Column field="accountno" header="Account Number" sortable style={{ minWidth: '10rem' }} />
          <Column field="accountname" header="Account Name" sortable style={{ minWidth: '12rem' }} />
          <Column field="accountopeningdate" header="Account Opening Date" sortable style={{ minWidth: '10rem' }} />
          <Column field="schemecode" header="Scheme Code" sortable style={{ minWidth: '8rem' }} />
          <Column field="schemedescription" header="Scheme Description" sortable style={{ minWidth: '12rem' }} />
          <Column field="netIntRate" header="Net Interest Rate" sortable style={{ minWidth: '8rem' }} />
          <Column field="totalperiodinmonths" header="Total Period in Months" sortable style={{ minWidth: '8rem' }} />
          <Column field="totalperiodindays" header="Total Period in Days" sortable style={{ minWidth: '8rem' }} />
          <Column field="facevalue" header="Face Value" sortable style={{ minWidth: '8rem' }} />
          <Column field="currentbalance" header="Current Balance" sortable style={{ minWidth: '10rem' }} />
        </DataTable>
      </div>
    </div>
  );
};

export default DepositData;
