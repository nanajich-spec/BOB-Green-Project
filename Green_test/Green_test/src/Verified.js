
import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import axios from 'axios';
import { Toast } from 'primereact/toast';
import { ProgressSpinner } from 'primereact/progressspinner';
 
const Verified = () => {
    const [verifiedData, setVerifiedData] = useState([]);
    const [loading, setLoading] = useState(false);
    const toast = React.useRef(null);
 
    useEffect(() => {
        fetchVerifiedData();
    }, []);
 
    const fetchVerifiedData = async () => {
        setLoading(true);
        try {
            const response = await axios.get('http://your-api-url/verified-records');
            setVerifiedData(response.data);
        } catch (error) {
            toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to fetch data' });
        } finally {
            setLoading(false);
        }
    };
 
    return (
        <div className="datatable-container">
            <Toast ref={toast} />
            <h2>Verified Records</h2>
            {loading ? (
                <ProgressSpinner />
            ) : (
                <DataTable value={verifiedData} paginator rows={10} responsiveLayout="scroll">
                    <Column field="accountNumber" header="Account Number" sortable />
                    <Column field="borrowerName" header="Borrower Name" sortable />
                    <Column field="status" header="Status" sortable />
                    <Column field="approvalDate" header="Approval Date" sortable />
                </DataTable>
            )}
        </div>
    );
};
 
export default Verified;
 