import React, { useEffect, useState, useRef } from 'react';
import axios from 'axios';
import { Card } from 'primereact/card';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { Toast } from 'primereact/toast';
import { ConfirmDialog, confirmDialog } from 'primereact/confirmdialog';
import { Dialog } from 'primereact/dialog';
import { Tag } from 'primereact/tag';
import { Dropdown } from 'primereact/dropdown';
import './UserManagement.css';
import { USE_MOCK_DATA, mockUsers } from './mockDashboardData';

const UserManagement = () => {
  const [loginUser, setLoginUser] = useState([]);
  const [filteredUsers, setFilteredUsers] = useState([]);
  const [users, setUsers] = useState([]);
  const [userId, setUserId] = useState('');
  const [userData, setUserData] = useState({});
  const [showDialog, setShowDialog] = useState(false);
  const [searchName, setSearchName] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const toast = useRef(null);

  useEffect(() => {
    const userDet = JSON.parse(window.sessionStorage.getItem("userDet"));
    setLoginUser(userDet || { userid: 'ADMIN', empname: 'Admin User' });

    if (USE_MOCK_DATA) {
      setUsers(mockUsers);
      setFilteredUsers(mockUsers.filter(u => !u.deleted));
      return;
    }

    axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/users-to-verify`)
      .then((response) => {
        const activeUser = response.data.filter(user => !user.deleted);
        setUsers(response.data);
        setFilteredUsers(activeUser);
      })
      .catch(() => {
        console.error('Failed to fetch users, using mock data');
        setUsers(mockUsers);
        setFilteredUsers(mockUsers.filter(u => !u.deleted));
      });
  }, []);

  const handleAddUser = async () => {
    if (!userId.trim()) {
      setErrorMessage('Enter Domain ID');
      return;
    }
    setErrorMessage('');
    try {
      if (USE_MOCK_DATA) {
        const newUser = {
          userid: userId.toUpperCase(),
          empname: 'Mock Employee ' + userId,
          designation: 'Manager',
          branchAlpha: 'FORT',
          branchSol: '1001',
          addedBy: loginUser?.userid,
          addedOn: new Date().toISOString(),
          verify: '',
          enable: '',
          role: '',
          region: 'Mumbai',
          zone: 'Western Zone',
          regionAlpha: 'MUMB',
          zoneAlpha: 'WEST',
          currentOrg: 'BOB',
          currentOrgType: 'Bank',
        };
        setUserData(newUser);
        setShowDialog(true);
        return;
      }
      const hrmsData = await axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/sms/getHrmsUserData?username=${userId}`);
      const solMaster = await axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/sms/getAllSolMasterDataByBrSolid?solid=${hrmsData.data.curr_sol_id}`);

      const newUser = {
        userid: hrmsData.data.username,
        empname: hrmsData.data.emp_name,
        designation: hrmsData.current_designation,
        branchAlpha: solMaster.data.roAlpha,
        branchSol: hrmsData.data.curr_sol_id,
        addedBy: loginUser?.userid,
        addedOn: new Date().toISOString(),
        verify: "",
        enable: "",
        role: "",
        region: solMaster.data.roName,
        zone: solMaster.data.zoName,
        regionAlpha: solMaster.data.roAlpha,
        zoneAlpha: solMaster.data.zoAlpha,
        currentOrg: hrmsData.data.curr_org,
        currentOrgType: hrmsData.data.current_organization_type,
      };

      setUserData(newUser);
      setShowDialog(true);
    } catch (error) {
      alert('Failed to fetch user data');
    }
  };

  const handleSave = async () => {
    try {
      if (USE_MOCK_DATA) {
        const saved = { ...userData, role: userData.role || 'maker', enable: 'Y' };
        setUsers(prev => [...prev, saved]);
        setFilteredUsers(prev => [...prev, saved]);
        toast.current.show({ severity: 'success', summary: 'Success', detail: 'User added successfully (Mock)', life: 3000 });
        setUserId('');
        setShowDialog(false);
        return;
      }
      const response = await axios.post('https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/userDataSave', userData, {
        headers: { 'Content-Type': 'application/json' },
      });

      toast.current.show({ severity: 'success', summary: 'Success', detail: 'User added successfully', life: 3000 });
      setUserId('');
      setShowDialog(false);
    } catch (error) {
      alert('Failed to save data');
    }
  };

  const confirmDelete = (rowData) => {
    confirmDialog({
      message: 'Are you sure you want to remove this user?',
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      accept: () => handleRemove(rowData),
    });
  };

  const handleRemove = (rowData) => {
    if (USE_MOCK_DATA) {
      toast.current.show({ severity: 'success', summary: 'Success', detail: 'User deactivated successfully (Mock)' });
      updateUserStatus(rowData.userid, 'N');
      return;
    }
    const payload = {
      userid: rowData.userid,
      modifiedBy: loginUser.userid
    };

    axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/deleteUser`, payload)
      .then(() => {
        toast.current.show({ severity: 'success', summary: 'Success', detail: 'User deactivated successfully' });
        updateUserStatus(rowData.userid, 'N');
      })
      .catch(() => {
        toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to deactivate user' });
      });
  };

  const handleEnableUser = (rowData) => {
    if (USE_MOCK_DATA) {
      toast.current.show({ severity: 'success', summary: 'Success', detail: 'User enabled successfully (Mock)' });
      updateUserStatus(rowData.userid, 'Y');
      return;
    }
    const payload = {
      userid: rowData.userid,
      modifiedBy: loginUser.userid
    };

    axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/enableUser`, payload)
      .then(() => {
        toast.current.show({ severity: 'success', summary: 'Success', detail: 'User enabled successfully' });
        updateUserStatus(rowData.userid, 'Y');
      })
      .catch(() => {
        toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to enable user' });
      });
  };

  const updateUserStatus = (userid, status) => {
    const updatedUsers = users.map(user => {
      if (user.userid === userid) {
        return { ...user, enable: status };
      }
      return user;
    });
    setUsers(updatedUsers);
    setFilteredUsers(updatedUsers.filter(user => !user.deleted));
  };

  const handleSearch = (e) => {
    const value = e.target.value.toLowerCase();
    setSearchName(value);
    const filtered = users.filter((user) => user.empname?.toLowerCase().includes(value));
    setFilteredUsers(filtered);
  };

  const actionBodyTemplate = (rowData) => {
    return (
      <>
        {rowData.enable === 'Y' ? (
          <Button label="Remove" icon="pi pi-trash" className="p-button-danger p-button-sm" onClick={() => confirmDelete(rowData)} />
        ) : (
          <Button label="Enable User" icon="pi pi-check" className="p-button-success p-button-sm" onClick={() => handleEnableUser(rowData)} />
        )}
      </>
    );
  };

  const actionBodyUser = (rowData) => {
    return (
      <Tag
        value={rowData.enable === 'N' ? 'Deactive' : 'Active'}
        severity={rowData.enable === 'N' ? 'danger' : 'success'}
      />
    );
  };

  return (
    <div className="adminDash">
      <Toast ref={toast} />
      <Card>
        <div className="container">
          {errorMessage && <p className="error-message">{errorMessage}</p>}
          <input type="text" className="input-field" value={userId} onChange={(e) => setUserId(e.target.value)} placeholder="Domain ID" />
          <button className="button" onClick={handleAddUser}>Add User</button>
        </div>

        <div className="container-search">
          <label htmlFor="search">Search by Name:</label>
          <input type="text" className="input-field" value={searchName} onChange={handleSearch} placeholder="Enter Name" />
        </div>

        <DataTable value={filteredUsers} dataKey="userid" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}>
          <Column field="userid" header="EC Number" sortable />
          <Column field="empname" header="Name" sortable />
          <Column field="zone" header="Zone" sortable />
          <Column field="region" header="Region" sortable />
          <Column field="role" header="User Type" sortable />
          <Column header="User Status" body={actionBodyUser} sortable />
          <Column header="Actions" body={actionBodyTemplate} exportable={false} />
        </DataTable>
      </Card>

      <Dialog header="User Details" visible={showDialog} style={{ width: '50vw' }} onHide={() => setShowDialog(false)}>
        {userData && (
          <div className="dialog-content">
            <p><strong>EC Number:</strong> {userData.userid}</p>
            <p><strong>Name:</strong> {userData.empname}</p>
            <p><strong>Branch:</strong> {userData.branchAlpha}</p>
            <p><strong>Zone:</strong> {userData.zone}</p>

            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
              <label htmlFor="makerChecker">Role</label>
              <Dropdown
                id="makerChecker"
                value={userData.role}
                options={[
                  { label: 'Maker', value: 'maker' },
                  { label: 'Checker', value: 'checker' }
                ]}
                onChange={(e) => setUserData({ ...userData, role: e.value })}
                placeholder="Select role"
              />
            </div>
            <br />
            <button className="button" onClick={handleSave}>Save</button>
          </div>
        )}
      </Dialog>

      <ConfirmDialog />
    </div>
  );
};

export default UserManagement;

