import React, { useEffect, useState } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import axios from 'axios'; // Assuming you're fetching data from an API
import { useNavigate } from 'react-router-dom'; // React Router for navigation
 
 
const ReturnFromAdminDataTable = () => {
  const [data, setData] = useState([]);
  const navigate = useNavigate(); // Using react-router for navigation
  const [globalFilter, setGlobalFilter] = useState("");
  // Fetching data from API
  useEffect(() => {
    const fetchData = async () => {
      try {
      
        const response = await axios.get(
          `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetailsAdmin`,
        )
        console.log(response.data);
        if (response.status === 200) {
          // ✅ Filter only rejected accounts
          const returnedAccounts = response.data.filter(
            (account) => account.status === "Queried By Admin"
          );
  
          console.log("accounts :" , returnedAccounts);
          setData(returnedAccounts);
        }
      } catch (error) {
        console.error("Error fetching returned accounts:", error);
      }
    };
 
    fetchData();
  }, []);
 
  // Handle the back button click
  const handleBack = () => {
    navigate(-1); // Goes back to the previous page
  };
  const clickRow = (rowData) => {
    console.log("Row clicked:", rowData);
  };
 
 
 
  return (
    <div className='checker-container page-container'>
    <div className="container1 page-container">
    {/* <Header /> */}
    {/* <h1 className="title2">BoB Green Finance Portal</h1>
    <div className="line-container1">
        <div className="line1"></div>
    </div> */}
    {/* <Sidebar /> */}

    <div className="datatable">
      <h2>Return from Admin</h2>
     
      <DataTable className="app-table" value={data} responsiveLayout="scroll"onRowClick={(rowData) => clickRow(rowData)}
          
          dataKey="accountNumber"
          paginator
          rows={10}
          rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} Accounts"
          globalFilter={globalFilter}
          header={
            <div className="table-header">
              
           
            
               
           
            </div>
          }
        >
          <Column
              header="S.No"
              body={(rowData, { rowIndex }) => rowIndex + 1}
              style={{ minWidth: "5rem" }}
            /> 
      
       
        <Column field="accountNumber" header="Account Number" sortable style={{ minWidth: "8rem" }}/>
        <Column field="borrowerName" header="Borrower Name" sortable style={{ minWidth: "8rem" }}/>
        <Column field="returnCheckerID" header="Admin Id" sortable style={{ minWidth: "8rem" }} />
        <Column field="status" header="Status" sortable style={{ minWidth: "8rem" }}/>
      </DataTable>
 
      {/* Back and Submit buttons */}
      <div className="button-containerL">
        {/* <button className="p-button p-button-secondary3" onClick={handleBack}> */}
          {/* Back
        </button> */}
       
      </div>
    </div>
    </div>
    </div>
  );
};
 
export default ReturnFromAdminDataTable;

