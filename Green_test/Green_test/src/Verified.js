
import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import axios from 'axios';
import { Toast } from 'primereact/toast';
import { ProgressSpinner } from 'primereact/progressspinner';
import { USE_MOCK_DATA, mockVerifiedAccounts } from './mockDashboardData';
 
const Verified = () => {
    const [verifiedData, setVerifiedData] = useState([]);
    const [loading, setLoading] = useState(false);
    const toast = React.useRef(null);
 
    useEffect(() => {
        fetchVerifiedData();
    }, []);
 
    const fetchVerifiedData = async () => {
        setLoading(true);
        if (USE_MOCK_DATA) {
            setVerifiedData(mockVerifiedAccounts);
            setLoading(false);
            return;
        }
        try {
            const response = await axios.get('https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/ViewDetailsReport');
            setVerifiedData(response.data);
        } catch (error) {
            console.error('Error fetching verified data, using mock:', error);
            setVerifiedData(mockVerifiedAccounts);
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
                <DataTable className="app-table" value={verifiedData} paginator rows={10} responsiveLayout="scroll">
                    <Column field="accountNumber" header="Account Number" sortable bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
                    <Column field="borrowerName" header="Borrower Name" sortable bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
                    <Column field="status" header="Status" sortable bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
                    <Column field="approvalDate" header="Approval Date" sortable bodyStyle={{ color: '#0f172a', fontWeight: 500 }} />
                </DataTable>
            )}
        </div>
    );
};
 
export default Verified;
 