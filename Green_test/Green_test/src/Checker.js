
import React, { useState ,useEffect } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useLocation } from "react-router-dom";
import { Box, Typography } from '@mui/material';
import SearchBar from './components/SearchBar';
import { USE_MOCK_DATA, mockCheckerAccounts } from './mockDashboardData';



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
      if (USE_MOCK_DATA) {
        setAccounts(mockCheckerAccounts);
        setFilteredAccounts(mockCheckerAccounts);
        return;
      }
      try {
        const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetails`);
        console.log("Fetched Accounts:", response.data);
        if (response.status === 200) {
          setAccounts(response.data);
          setFilteredAccounts(response.data);
        }
      } catch (error) {
        console.error("Error fetching accounts, using mock data:", error);
        setAccounts(mockCheckerAccounts);
        setFilteredAccounts(mockCheckerAccounts);
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
    const accountNumber = rowData.accountNumber;
    if (USE_MOCK_DATA) {
      navigate("/Checker1", { state: { accountNumber: accountNumber } });
      return;
    }
    try {
      const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/${accountNumber}`);
      console.log("Fetched Account Details:", response.data);
      if (response.status === 200 && response.data) {
        navigate("/Checker1", { state: { accountNumber: accountNumber } });
      }
    } catch (error) {
      console.error("Error fetching account details:", error);
      navigate("/Checker1", { state: { accountNumber: accountNumber } });
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
          rowClassName={() => 'visible-row'}
        >
          <Column header="S.No" body={(rowData, { rowIndex }) => <span style={{ color: '#0f172a' }}>{rowIndex + 1}</span>} style={{ minWidth: "2rem" }} bodyStyle={{ color: '#0f172a' }} />
          <Column field="accountNumber" header="Account Number" sortable style={{ minWidth: "4rem" }} bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
          <Column field="borrowerName" header="Borrower Name" sortable style={{ minWidth: "4rem" }} bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
          <Column field="status" header="Status" sortable style={{ minWidth: "4rem" }} bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
        </DataTable>
      </div>
    </div>
  );
};

export default Checker;
