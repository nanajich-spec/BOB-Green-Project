
import React, { useEffect, useState } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import axios from 'axios'; // Assuming you're fetching data from an API
import { useNavigate } from 'react-router-dom'; // React Router for navigation
 



const ReturnFromChecker = () => {
  const [data, setData] = useState([]);
  const navigate = useNavigate(); // Using react-router for navigation
  const [globalFilter, setGlobalFilter] = useState("");
  const [accountNumber, setaccountNumber] = useState({});
  const [borrowerName, setBorrowerName] = useState({});
  const [returnReason, setreturnReason] = useState({});
  const [returnCheckerID, setreturnCheckerID] = useState({});
 
 useEffect(() => {
  const fetchData = async () => {
    
    try {
      
      const response = await axios.get(
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetailsReturn`,
        //  `http://172.16.182.177:8080/green-project/api/v1/ViewDetailsReturn`,
      )

      console.log(response.data);
      if (response.status === 200) {
        // ✅ Filter only rejected accounts
        const returnedAccounts = response.data.filter(
          (account) => account.status === "Queried By Checker"
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
            {/* <Header />
            <Sidebar /> */}
            {/* <div className='checker-container'> */}
            <div className="datatable">
            <h2>Return from Checker</h2>
     
          <DataTable className="app-table" value={data} responsiveLayout="scroll" onRowClick={(rowData) => clickRow(rowData)}
          
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
        <Column field="returnCheckerID" header="Checker Id" sortable style={{ minWidth: "8rem" }} />
        {/* <Column field="reasonForReturning" header="Reason for Returning" sortable style={{ minWidth: "8rem" }}/> */}
        <Column field="status" header="Status" sortable style={{ minWidth: "8rem" }}/>

      </DataTable>
 
      {/* Back and Submit buttons */}
      <div className="button-containerL">
        {/* <button className="p-button p-button-secondary3" onClick={handleBack}>
          Back
        </button> */}
     
      </div>
    </div>
    </div>
    </div>
  );
};
 
export default ReturnFromChecker;
