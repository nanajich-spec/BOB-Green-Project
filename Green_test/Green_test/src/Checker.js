
import React, { useState ,useEffect } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useLocation } from "react-router-dom";
import { Box, Typography } from '@mui/material';
import SearchBar from './components/SearchBar';



const Checker = () => {
  const [accounts, setAccounts] = useState([]);
  const [filteredAccounts,setFilteredAccounts]= useState([]);
  const [selectedAccount, setSelectedAccount] = useState(null);
  const [globalFilter, setGlobalFilter] = useState("");
  const navigate = useNavigate();
  const location = useLocation();
  // Fetch accounts added by the maker

  useEffect(() => {
    const fetchAccounts = async () => {
      try {
        // Assuming the backend API returns accounts created by the maker
        const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetails`)
        // console.log(response);
        console.log("Fetched Accounts:", response.data);
        if (response.status === 200) {
        setAccounts(response.data);
        setFilteredAccounts(response.data);
        // Set the data to state
        
      }} catch (error) {
        console.error("Error fetching accounts:", error);
      }
    };

    fetchAccounts();
  }, []);

  // Handle search filtering
  const handleSearch = (query) => {
    if (query.trim() === '') {
      setFilteredAccounts(accounts);
    } else {
      const filtered = accounts.filter(account =>
        account.accountNumber && account.accountNumber.toLowerCase().includes(query.toLowerCase())
      );
      setFilteredAccounts(filtered);
    }
  };


  const handleRowClick = async (rowData) => {
   // Extract account number from clicked row
    try {
      const accountNumber = rowData.accountNumber;
      const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/${accountNumber}`);
      // console.log(response.data);

      console.log("Fetched Account Details:", response.data);
      if (response.status === 200 && response.data) {
      navigate("/Checker1", { state: { accountNumber: accountNumber } }); // ✅ Pass API response to next page
      }
        

      } catch (error) {
      console.error("Error fetching account details:", error);
      }
    };
  
  //ch
  const handleFilterChange=(status)=>{
    const filtered =accounts.filter(account => account.status === status);
    setFilteredAccounts(filtered);
  }

  return (
    <div className="checker-container">
      <Box sx={{ px: 2, pt: 2 }}>
        <Typography variant="h5" sx={{ mb: 2, color: '#0d3520', fontWeight: 800 }}>
          Pending Verification
        </Typography>
        <SearchBar onSearch={handleSearch} placeholder="Search by Account Number" />
      </Box>
      <div className="table-containerr">
   
        <DataTable
          className="app-table"
          value={filteredAccounts}
          selectionMode="single"
          onRowSelect={(event)=>handleRowClick(event.data)}
          dataKey="accountNumber"
          paginator
          rows={10}
          rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} Accounts"
          globalFilter={globalFilter}
        >
          <Column header="S.No" body={(rowData, { rowIndex }) => rowIndex + 1} style={{ minWidth: "2rem" }} />
          <Column field="accountNumber" header="Account Number" sortable style={{ minWidth: "4rem" }} />
          <Column field="borrowerName" header="BorrowerName" sortable style={{ minWidth: "4rem" }} />
          <Column field="status" header="Status" sortable style={{ minWidth: "4rem" }} />
        </DataTable>
      </div>
    </div>
  );
};

export default Checker;
