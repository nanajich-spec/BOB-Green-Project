
import React, { useEffect, useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { InputText } from 'primereact/inputtext';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { Box, Typography } from '@mui/material';
import './LoanData.css';
import SearchBar from './components/SearchBar';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
// import 'primeicons/primeicons.css'; // Ensure PrimeIcons is imported
 
const LoanData = () => {
  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [globalFilter, setGlobalFilter] = useState('');
  const navigate = useNavigate();
  const dt = useRef(null); // Ref for DataTable
 
  useEffect(() => {
    const fetchData = async () => {
      try {
        //const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/fetchLoan/{accountNum}`);
        // const response = await axios.get(`http://172.16.182.177:8080/green-project/api/v1/ViewDetailsLoan`);
        const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetailsLoan`);
        if (response.status === 200) {
          setData(response.data);
          setFilteredData(response.data);
        }
      } catch (error) {
        console.error('Error fetching loan accounts:', error);
      }
    };
 
    fetchData();
  }, []);

  const handleSearch = (query) => {
    if (query.trim() === '') {
      setFilteredData(data);
    } else {
      const filtered = data.filter(account =>
        account.accountNumber && account.accountNumber.toLowerCase().includes(query.toLowerCase())
      );
      setFilteredData(filtered);
    }
  };
 
  const renderHeader = () => {
    return (
      // <div className="table-header" style={{ padding: '1rem', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
      //   <span className="p-input-icon-left">
      //     <InputText
      //       style={{ width: '15rem', height: '2.5rem' }}
      //       type="search"
      //       value={globalFilter}
      //       onInput={(e) => setGlobalFilter(e.target.value)}
      //       placeholder="Global Search"
      //     />
      //   </span>
        <Button
          label="Export as CSV"
          icon="pi pi-file"
          className="p-button-help"
          // style={{marginLeft:'-20px'}}
          style={{ padding: '15px 25px', fontSize: '16px' }} // Increase size
          onClick={() => dt.current.exportCSV()}
        />
      // </div>
    );
  };
 
  return (
    <div className="loan-data-container">
      <div className="loan-data-content">
        <Box sx={{ mb: 2 }}>
          <Typography variant="h5" sx={{ mb: 2, color: '#0d3520', fontWeight: 800 }}>
            Loan Dashboard
          </Typography>
          <SearchBar onSearch={handleSearch} placeholder="Search by Account Number" />
        </Box>
        <h1 className="loan-data-title">Details of Loan Accounts as on date (All Values in Rs. Absolute Number)</h1>
 
        <DataTable
          ref={dt}
          value={filteredData}
          responsiveLayout="scroll"
          dataKey="accountNumber"
          paginator
          rows={10}
          rowsPerPageOptions={[5, 10, 25]}
          globalFilter={globalFilter}
          header={renderHeader()}
        >
          <Column header="S.No" body={(rowData, { rowIndex }) => rowIndex + 1} style={{ minWidth: '5rem' }} />
          <Column field="accountName" header="Name of the Account" sortable style={{ minWidth: '8rem' }} />
          <Column field="custId" header="Cust ID for Returning" sortable style={{ minWidth: '8rem' }} />
          <Column field="solID" header="Sol ID" sortable style={{ minWidth: '8rem' }} />
          <Column field="accountNumber" header="Account No." sortable style={{ minWidth: '8rem' }} />
          <Column field="schemeCode" header="Scheme Code" sortable style={{ minWidth: '8rem' }} />
          <Column field="activityCode" header="Activity Code" sortable style={{ minWidth: '8rem' }} />
          <Column field="activityDescription" header="Activity Description" sortable style={{ minWidth: '8rem' }} />
          <Column field="segment" header="Segment (Retail/ MSME/ Corporate/ Agri)" sortable style={{ minWidth: '8rem' }} />
          <Column field="accountOpeningDate" header="Account Opening Date" sortable style={{ minWidth: '8rem' }} />
          <Column field="dateOfDisbursement" header="Date of Disbursement" sortable style={{ minWidth: '8rem' }} />
          <Column field="amountSanctioned" header="Amount Sanctioned" sortable style={{ minWidth: '8rem' }} />
          <Column field="amountDisbursed" header="Amount Disbursed" sortable style={{ minWidth: '8rem' }} />
          <Column field="amountOutstanding" header="Amount Outstanding" sortable style={{ minWidth: '8rem' }} />
          <Column field="maturity" header="Maturity" sortable style={{ minWidth: '8rem' }} />
          <Column field="amountTransferred" header="Amount transferred in the Loan A/c through Unscheduled Payment" sortable style={{ minWidth: '8rem' }} />
          <Column field="dateOfTransfer" header="Date of transfer (Unscheduled Payment)" sortable style={{ minWidth: '8rem' }} />
          <Column field="instalmentStartDate" header="Instalment Start Date" sortable style={{ minWidth: '8rem' }} />
          <Column field="instalmentFrequency" header="Instalment Frequency" sortable style={{ minWidth: '8rem' }} />
          <Column field="instalmentAmount" header="Instalment Amount" sortable style={{ minWidth: '8rem' }} />
        </DataTable>
      </div>
    </div>
  );
};
 
export default LoanData;
 

