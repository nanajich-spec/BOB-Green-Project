


import React, { useEffect, useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';

import { Column } from 'primereact/column';

import { Button } from 'primereact/button';

import { InputText } from 'primereact/inputtext';

import axios from 'axios';

import { useNavigate } from 'react-router-dom';
import { Box, Typography } from '@mui/material';
import SearchBar from './components/SearchBar';

 import './DepositData.css'; // Your styling file

import 'primereact/resources/themes/lara-light-indigo/theme.css';

import 'primereact/resources/primereact.css';
 
const DepositData = () => {

  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);

  const [globalFilter, setGlobalFilter] = useState('');
  const [formData, setFormData] = useState({});
  const navigate = useNavigate();

  const dt = useRef(null); // Ref for DataTable

 
  // Simulating the data structure

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

  useEffect(() => {

    // Example of data structure

    const fetchData = async () => {

      try {

        // Replace with actual API call
        // const response = await axios.get(`http://172.16.182.177:8080/green-project/api/v1/ViewDetailsDeposit`);
        const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetailsDeposit`);
        if (response.status === 200) {
          setData(response.data);
          setFilteredData(response.data);
        }
       

      } catch (error) {

        console.error('Error fetching green deposit data:', error);

      }

    };
 
    fetchData();

  }, []);
 
  const renderHeader = () => (
<div className="table-Header">
  
{/* <InputText

          style={{ width: '15rem' }}

          type="search"

          value={globalFilter}

          onInput={(e) => setGlobalFilter(e.target.value)}

          placeholder="Global Search"

        /> */}
<Button

          label="Export as CSV"

          icon="pi pi-file"

          className="p-button-help"

          style={{ padding: '15px 25px', fontSize: '16px' }}

          onClick={() => dt.current.exportCSV()}

        />
</div>

    );


 
  // Sample data assuming these regions are fetched from your backend

 
 
  // Sample data (you will replace it with actual data from API)

  // const sampleData = regions.map(region => ({

  //   zoneName: region,

  //   noOfAccountsOpened: Math.floor(Math.random() * 1000),

  //   noOfAccountsClosed: Math.floor(Math.random() * 1000),

  //   totalNumberOfAccounts: Math.floor(Math.random() * 1000),

  //   outstandingAmount: Math.floor(Math.random() * 1000000),

  // }));
 
  return (
<div className="green-deposit-container">
<div className="green-deposit-content">
        <Box sx={{ mb: 2 }}>
          <Typography variant="h5" sx={{ mb: 2, color: '#0d3520', fontWeight: 800 }}>
            Deposit Position
          </Typography>
          <SearchBar onSearch={handleSearch} placeholder="Search by Account Number" />
        </Box>
        <h1 className="green-deposit-title">Green Deposit Position (No in Actual & Amount in Rs)</h1>
 
        <DataTable
           className="custom-datatable"
          ref={dt}

          value={filteredData}
          dataKey="zoneName" // Unique identifier for rows

          paginator

          rows={10}

          rowsPerPageOptions={[5, 10, 25]}

          globalFilter={globalFilter}

          header={renderHeader()}

          exportFilename="Green_Deposit_Position"
>
<Column header="S.No" body={(rowData, { rowIndex }) => rowIndex + 1} style={{ minWidth: '5rem' }} />
<Column field="zoroname" header="Zone/Region Name" sortable style={{ minWidth: '15rem' }} />
<Column field="numberAccountOpened" header="No of Account Opened" sortable style={{ minWidth: '12rem' }} />
<Column field="numberAccountClosed" header="No of Account Closed" sortable style={{ minWidth: '12rem' }} />
<Column field="totalAccounts" header="Total Number of Accounts" sortable style={{ minWidth: '12rem' }} />
<Column field="outstandingAmount" header="Outstanding Amount (Rs)" sortable style={{ minWidth: '12rem' }} />
<Column field="solID" header="Sol ID" sortable style={{ minWidth: '12rem' }} />
<Column field="schemeCode" header="Scheme Code" sortable style={{ minWidth: '12rem' }} />

</DataTable>
</div>
</div>

  );

};
 
export default DepositData;

 