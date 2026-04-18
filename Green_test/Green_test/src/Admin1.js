import React, {  useState ,useEffect } from 'react';
import { Button } from 'primereact/button';
import './Maker.css';
import {  userRole, handleApprovalStatus } from './ProjectSpecificIndicator.js';
import { Toast } from 'primereact/toast';
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.min.css';
import axios from 'axios';
import {useRef} from'react';
// import './Checker1.css';

  import './Admin1.css';
import { Navigate, useParams } from "react-router-dom";
import {  useLocation } from "react-router-dom";
import { USE_MOCK_DATA, mockMakerAccountDetail, mockSusObjIndicators } from './mockDashboardData';


const Admin1 = () => {
    const toast = useRef(null);
    const location = useLocation();
    const [fileData, setFileData] = useState(null); // Store file as a Blob
    const [editableFields, setEditableFields] = useState({
        borrowerName: false,
        branchName: false,
        panNumber: false,
        cinNumber: false,
        schemeCode: false,
        activityCode: false,
        briefDtls: false,
        description: false,
        projName: false,
        sector: false,
        locationType: false,
        othersAdd:  false,
        susobj: false,
        longitude:false,
          latitude:false,
        stakeEng: false,
        reportReq: false,
        timeline: false,
        budget: false,
        pincode:false,
        eiacomments: false,
        legalVerificationComments: false,
        financialHealthComments: false,
        esgCompliance: false,
        vulnerability: false,
        sealevel: false,
        supplychain: false,
        carbonintensive: false,
        assetrisk: false,
        shifting: false,
        business: false,
        climate: false,
        borroweremission: false,
});
  // Stepper state
  const [activeIndex, setActiveIndex] = useState(0);
  const [selectedSUSObj, setSelectedSUSObj] = useState('');
  const [indicators, setIndicators] = useState([]);
  //const [susobjs, setSusobjs] = useState([]);
  const [isLoading, setIsLoading ] = useState([false]);
  const [userRole, setUserRole] = useState('');
  const [approvalStatus] = useState(null); // Define approvalStatus as state if needed
  const [file, setFile] = useState(null); // State to store the selected file
  const [remarks, setRemarks] = useState('');
  const [fileName,setFileName]=useState('');
  //const {accountNumber}=useParams();
  const [AccN, setAccN ] = useState ('');
  const [returnComment, setReturnComment] = useState('');
  const [isReturned, setIsReturned] = useState(false);
  const [accountDetails, setAccountDetails] = useState(null);
  const [eiaFile, setEiaFile] = useState({ name: "No valid file available", data: null });
  const [legalVerificationFile, setLegalVerificationFile] = useState({ name: "No valid file available", data: null });
  const [financialHealthFile, setFinancialHealthFile] = useState({ name: "No valid file available", data: null });
  const [esgFile, setEsgFile] = useState({ name: "No valid file available", data: null });
  const [selectedOption,setSelectedOption] = useState("");   //ch
  const [comment, setComment] = useState("");                //ch
  const [accountNumber, setaccountNumber] = useState({});
  const [SustainObj,setSustainObj]= useState({});
  const [susobj, setSusobjs] = useState([]);
  //const [updatedComments,setUpdatedComments]=useState([]);
  const [flags, setFlags] = useState({
    accountNumber: "",
    // borrowerFlag: "",
    // borrowerComment: "",
    // branchFlag: "",
    // branchcomment: "",
    // panFlag: "",
    // panComment: "",
    // cinFlag: "",
    // cinComment: "",
    // schemeFlag: "",
    // schemecomment: "",
    // activityFlag: "",
    // activitycomment: "",
    projFlag: "",
    projComment: "",
    sectorFlag: "",
    sectorcomment: "",
    locationFlag: "",
    locationComment: "",
    othersAddFlag: "",
    othersAddComment: "",
    descpFlag: "",
    descpComment: "",
    susobjFlag: "",
    susobjComment: "",
    longitudeFlag:"",
    longitudeComment:"",
    latitudeFlag:"",
    latitudeComment:"",
    stakeEngFlag: "",
    stakeEngComment: "",
    reportReqFlag: "",
    reportReqComment: "",
    timelineFlag: "",
    timelineComment: "",
    pincodeFlag: "",
    pincodeComment: "",
    budgetFlag: "",
    budgetComment: "", 
    legalverFlag: "",
    legalverComment: "",
    financialHealthFlag: "",
    financialHealthCmnt: "",
    esgCompFlag: "",
    esgCompComment: "",
    vulnerabilityFlag: "",
    vulnerabilityComment: "",
    carbonintFlag: "",
    carbonintComment: "",
    sealevelFlag: "",
    sealevelComment: "",
    assestriskFlag: "",
    assestriskComment: "",
    supplychainFlag: "",
    supplychainComment: "",
    shiftingFlag: "",
    shiftingComment: "",
    businessFlag: "",
    businessComment: "",
    climateFlag: "",
    climateComment: "",
    borrowermissionFlag: "",
    borrowermissionComment: "",
    eiacommComment: "",
    status: "",
    eiacommFlag: "",
    accStatusFlag: ""
  });

  //const [loading, setLoading] = useState(true);



  const handleSelectChange = (field,
    value) => {
       
        // setSelectedOption((prev) =>
        //   ({...prev, [field]: value}));

        console.log("Comment Change");
        console.log(field);
        console.log(value);
        setFlags((prev) =>
          ({...prev, [field]: value}));


    };                                                        //ch


    


  const handleCommentChange = (field,
    value) => {
      // setComment((prev) =>({...prev,
      //   [field]: value}));
      
      setFlags((prev) =>({...prev,
        [field]: value}));
      
    };                                                         //ch

  
//   const handleSelectChange = (field, value) => {
//     setFlags((prev) => ({
//         ...prev,
//         [field]: value
//     }));

//     // Smoothly expand comment box when reject is selected
//     if (value === "Reject") {
//         setTimeout(() => {
//             const commentBox = document.querySelector(`#${field}-comment`);
//             if (commentBox) {
// commentBox.style.display = "block";
//             }
//         }, 200);
//     }
// };
// const handleCommentChange = (field, value) => {
//   setFlags((prev) => ({
//       ...prev,
//       [field]: value
//   }));
// };

  
  const toggleEdit = (field) => {

    setEditableFields((prevState) => ({

      ...prevState,

      [field]: !prevState[field],

    }));

  };

  // useEffect(() => {
  //   if (!accountNumber) {
  //     // If no account is selected, fetch all accounts
  //     axios
  // .get("https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/accounts") // UPDATE API IF NEEDED
  //       .then((response) => {
  // console.log("Fetched Accounts:", response.data);
  // setAccounts(response.data);
  //         setLoading(false);
  //       })
  //       .catch((error) => {
  //         console.error("Error fetching accounts:", error);
  //         setLoading(false);
  //       });
  //   } else {
  //     // If an account is selected, fetch its details
  //     axios
  // .get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/${accountNumber}`) // Update API if needed
  //       .then((response) => {
  // console.log("Fetched Account Details:", response.data);
  // setAccountDetails(response.data);
  //         setLoading(false);
  //       })
  //       .catch((error) => {
  //         console.error("Error fetching account details:", error);
  //         setLoading(false);
  //       });
  //   }
  // }, [accountNumber]); // Run when accountNumber changes

  

useEffect(() => {
  if (location.state?.accountNumber) {
    const accountNumber = location.state?.accountNumber;
    console.log(accountNumber);
    setaccountNumber(accountNumber);
    setSustainObj(susobj);
    
    if (USE_MOCK_DATA) {
      const mockData = { ...mockMakerAccountDetail, accountNumber };
      setAccountDetails(mockData);
      setIndicators(mockSusObjIndicators);
      return;
    }

    try{
      axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/${accountNumber}`).then((response) =>{

        // setAccountDetails(response);
        console.log("Received Account Details:", response.data);  
        

        axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/pickdataSusObj/${response.data.susobj}`).then((response1)=>{
          console.log("Received Account Details:", response1.data);  

        setIndicators(response1.data);
        })
        setAccountDetails(response.data);
        // Base64 to Blob conversion function
        const convertBase64ToBlob = (base64String, mimeType) => {
          if (!base64String) return null;
        const byteCharacters = atob(base64String);
        const byteNumbers = new Array(byteCharacters.length)
          .fill(0)
          .map((_, i) => byteCharacters.charCodeAt(i));
        return new Blob([new Uint8Array(byteNumbers)], { type: mimeType || "application/pdf" });
    };
      setEiaFile({
      name: response.data.eiafileName || 'eia.pdf',
      data: convertBase64ToBlob(response.data.eiafile, "application/pdf"),
    });
    setLegalVerificationFile({
      name: response.data.legalVerificationFileName || "Legal.pdf",
      data: convertBase64ToBlob(response.data.legalVerificationFile, "application/pdf"),
    });
    setFinancialHealthFile({
      name: response.data.financialFileName || "finance.pdf",
      data: convertBase64ToBlob(response.data.financialHealthFile, "application/pdf"),
    });
    setEsgFile({
      name: response.data.esgfileName || "esg.pdf",
      data: convertBase64ToBlob(response.data.esgfile, "application/pdf"),
    });
        
      })
        
      
    }catch(error){
      console.log(error);
    }
    
  } else {
    console.warn("No account details received in location state");
  }
}, [location.state]);

// Handle file download

const downloadFile = (file) => {
  if (!file?.data) {
    alert("No file available for download");
    return;
  }
 console.log('download clicked');
  // Create a URL for the Blob data
  const url = window.URL.createObjectURL(file.data);
  // Create a temporary anchor element
  const a = document.createElement("a");
  a.href = url;
  a.download = file.name || "downloaded_file.pdf"; // Set file name
  // Append, trigger download, and clean up
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
  // Release memory
  window.URL.revokeObjectURL(url);
};


 

  
  
  // Move to the previous step
  const prevStep = () => {
    setActiveIndex(activeIndex - 1);
  };
  const nextStep = () => {
    setActiveIndex(activeIndex + 1);
  };
  //HANDLE SUBMIT
 const handleSubmit = async () => {
   // Ensure form is validated

    try {

      if (activeIndex === 0) {
       
     
      }
      console.log("flag and comment values");
      console.log(flags);
       alert("Data saved successfully!");
       nextStep(); // Move to the next step in the form or process
       console.log(selectedOption);
       console.log("selected options");

    } catch (error) {
      console.error("Error during form submission:", error);
      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save data: ' + error.message });
    }
  };
  // Function to send updated data to backend
  const handleSubmit1 = () => {
    if (USE_MOCK_DATA) {
      alert("Data saved successfully (Mock)");
      return;
    }
    axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/AdminDtls/{accountNumber}?accountNumb=${accountNumber}`,flags)
      .then((response)=>{
        console.log("Data saved successfully:", response.data);
        alert("Data saved successfully");
        Navigate();
      })
      .catch((error) =>{
         console.error("Error saving data:", error);
      });
  };


  


  // Steps configuration
const steps = [
  { label: 'General Information' },
  { label: 'Risk Assessment' },
  { label: 'Project-Specific Indicators' }, // Add this line
]; 
    const handleBack = () => {
      // Example: Go back to the previous page
      window.history.back();
    };

    return (
        <div className="container1">
                <Toast ref={toast} />
                {/* Step Navigation */}
                <div className="step-wrapper">
                  <div className="step-navigation">
                    {steps.map((step, index) => (
                      <div
                        type = 'radio'
                        key={index}
                        className={`step ${activeIndex === index ? 'active' : ''}`}
                        onClick={() => setActiveIndex(index)}
                      >
                    <span className="step-number">{index + 1}</span>
                  <span className="step-label">{step.label}</span>
                </div>
              ))}
          </div>
      </div>
               {activeIndex === 0 && (
        
         
          <div id="pdf-content">
          <div className="business-div">
            <h2 className="business-title">General Information (To be provided by Bank)</h2>
            <div className="vertical">
              <div className="vertical1">
                <div className="form-group2">
                  <label htmlFor="borrowerName">Name of The Borrower<span className="required-star">*</span> :</label>
                  <input
                    id="borrowerName"
                    type="text"
                    value={accountDetails?.borrowerName || ""}
                    readOnly={!editableFields.borrowerName}
                  />
                  {/* <button onClick={() => toggleEdit('borrowerName')}> */}

{/* {editableFields.borrowerName ? 'Save' : 'Edit'} */}
{/* </button> */}
                </div>
                <div className="form-group2">
                  <label htmlFor="branchName">Branch<span className="required-star">*</span> :</label>
                  <input
                    id="branchName"
                    type="text"
                    value={accountDetails?.branchName || "" }
                    readOnly={!editableFields.branchName}
                  />
                              
{/* <button onClick={() => toggleEdit('branchName')}>

                    {editableFields.branchName ? 'Save' : 'Edit'}
</button> */}
                </div>
                <div className="form-group2">
                  <label htmlFor="panNumber">PAN Number<span className="required-star">*</span> :</label>
                  <input
                    id="panNumber"
                    type="text"

                    value={accountDetails?.panNumber || "" }
                    readOnly={!editableFields.panNumber }
                  />
                  {/* <button onClick={() => toggleEdit('panNumber')}>

{editableFields. panNumber? 'Save' : 'Edit'}
</button> */}

                </div>
                <div className="form-group2">
                  <label htmlFor="cinNumber">CIN<span className="required-star">*</span> :</label>
                  <input
                    id="cinNumber"
                    type="text"
                    value={accountDetails?.cinNumber || "" }
                    readOnly={!editableFields.cinNumber }

                  />
                  {/* <button onClick={() => toggleEdit('cinNumber')}>

{editableFields.cinNumber? 'Save' : 'Edit'}
</button> */}
                </div>
              </div>
              <div className="vertical2">
                <div className="form-group2">
                  <label htmlFor="schemeCode">Scheme Code<span className="required-star">*</span> :</label>
                  <input
                    id="schemeCode"
                    type="text"
                    value={accountDetails?.schemeCode || "" }
                    readOnly={!editableFields.schemeCode}
                  />
                  {/* <button onClick={() => toggleEdit('schemeCode')}>

{editableFields. schemeCode? 'Save' : 'Edit'}
</button> */}
                </div>
                <div className="form-group2">
                  <label htmlFor="activityCode">Activity Code<span className="required-star">*</span> :</label>
                  <input
                    id="activityCode"
                    type="text"
                    value={accountDetails?.activityCode || "" }
                    readOnly={!editableFields.activityCode}
                  />
                  {/* <button onClick={() => toggleEdit('activityCode')}>

{editableFields. activityCode? 'Save' : 'Edit'}
</button> */}
                </div>
                <div className="form-group2">
  <label htmlFor="briefDtls">
    Brief Details of the Project
    <span className="required-star">*</span> :
  </label>
 <input
    id="briefDtls"
    value={accountDetails?.briefDtls || "" }
    readOnly={!editableFields.briefDtls }

  />
   {/* <button onClick={() => toggleEdit('description')}>

{editableFields.description? 'Save' : 'Edit'}
</button> */}
</div>
                <div className="form-group2">
                  <label htmlFor="projName">Name of the Project<span className="required-star">*</span> :</label>
                  <input
                  id="projName"
                  type="text"
                  value={accountDetails?.projName || "" }
                  readOnly={!editableFields.projName}

            />
 {/* <button onClick={() => toggleEdit('projName')}>

{editableFields. projName? 'Save' : 'Edit'}
</button> */}
                </div>
            </div>
        </div>
</div>
{/* General Information (To be provided by Borrower) */}
{/* <div id="pdf-content"> */}
<div className='business-div'>
   <h2 className='business-title'>General Information (To be provided by Borrower)</h2>
        <div className='vertical'>
            <div className='vertical1'>
            <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="sector">Sector<span className="required-star">*</span> :</label>
                    <input
                    id="sector"
                    type="text"
                    value={accountDetails?.sector|| "" }
                    readOnly={!editableFields.sector}
                    />
                    
                    <select onChange={(e) =>
                      handleSelectChange("sectorFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                      
                  </select>
                  </div>

                  

                  {flags["sectorFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["sectorcomment"] || ""} onChange={(e) => 
                                handleCommentChange("sectorcomment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
            {/* <button onClick={() => toggleEdit('sector')}>
{editableFields.sector ? 'Save' : 'Edit'}
</button> */}
                </div>

                <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="locationType">Location<span className="required-star">*</span> :</label>
                    <input
                    id="locationType"
                    type="text"
                    value={accountDetails?.locationType|| "" }
                    readOnly={!editableFields.locationType}

                  />
                 {accountDetails?.locationType === 'same' && ( 


<input
      type="text"
      value={accountDetails?.othersAdd}
      // onChange={(e) => handleChange(e, 'generalInfo', 'othersAdd')}
      // placeholder="Enter address"
    />
   )}
   {accountDetails?.locationType === 'other' && (

<input
      type="text"
      value={accountDetails?.othersAdd}
      // onChange={(e) => handleChange(e, 'generalInfo', 'othersAdd')}
      // placeholder="Enter address"
    />

  )} 
                   
   <select onChange={(e) =>
                      handleSelectChange("locationTypeFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                      
                  </select>
                  {/* <button onClick={() => toggleEdit('location')}>

{editableFields.location ? 'Save' : 'Edit'}
</button> */}
</div>

{flags["locationTypeFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["locationTypecomment"] || ""} onChange={(e) => 
                                handleCommentChange("locationTypecomment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
                </div>
                <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="projName">Project Description<span className="required-star">*</span> :</label>
                 <input
                    id="description"
                    type="text"
                    value={accountDetails?.description|| "" }
                    readOnly={!editableFields.description}

                />
                <select onChange={(e) =>
                    handleSelectChange("descpFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  </div>

                  {flags["descpFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["descpComment"] || ""} onChange={(e) => 
                                handleCommentChange("descpComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}

            
                </div>
                <div className='commentR'>
                <div className="form-group2">
                  <label htmlFor="susobj">Sustainability Objectives :</label>
                  <input
                    id="susobj"
                    type="text"
                    value={accountDetails?.susobj|| "" }
                    readOnly={!editableFields.susobj}
                  // readOnly
                  // className="readonly-input"
                  />
                  
                  <select onChange={(e) =>
                      handleSelectChange("susobjFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                      
                  </select>
                  </div>

                  

                  {flags["susobjFlag"] === 
                    "Reject" && (
                            <div className='form-group  comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["susobjcomment"] || ""} onChange={(e) => 
                                handleCommentChange("susobjcomment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
                    </div>
                    <div className='commentR'>
                    <div className="form-group2">
                    <label htmlFor="longitude">Longitude<span className="required-star">*</span> :</label>
                    <input
                    id="longitude"
                    type="text"
                    value={accountDetails?.longitude|| ""}
                    readOnly={!editableFields.longitude}
                    // onChange={(e) => setProjName(e.target.value)}
                    // onChange={(e) => handleValidation(e, 'generalInfo', 'longitude')}
                    
                />
                <select onChange={(e) =>
                    handleSelectChange("longitudeFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  </div>

                  {flags["longitudeFlag"] === 
                    "Reject" && (
                            <div className='form-group  comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags[" longitudeComment"] || ""} onChange={(e) => 
                                handleCommentChange(" longitudeComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}

                </div>
                <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="latitude">Latitude<span className="required-star">*</span> :</label>
                    <input
                    id="latitude"
                    type="text"
                    value={accountDetails?.latitude|| ""}
                    readOnly={!editableFields.latitude}
                    // onChange={(e) => setProjName(e.target.value)}
                    // onChange={(e) => handleValidation(e, 'generalInfo', 'latitude')}
                />
                
 <select onChange={(e) =>
                    handleSelectChange("latitudeFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  
                  </div>
                  {flags["latitudeFlag"] === 
                    "Reject" && (
                      
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["latitudeComment"] || ""} onChange={(e) => 
                                handleCommentChange("latitudeComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}

                </div>
                </div>
          
            <div className='vertical2'>
            <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="stakeEng">Stake Holder Engagement<span className="required-star">*</span> :</label>
                    <input
                    id="stakeEng"
                    type="text"
                    value={accountDetails?.stakeEng|| "" }
                    readOnly={!editableFields.stakeEng}

                    />
                    <select onChange={(e) =>
                    handleSelectChange("stakeEngFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  </div>

                  {flags["stakeEngFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["stakeEngComment"] || ""} onChange={(e) => 
                                handleCommentChange("stakeEngComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
  
              </div>
              <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="reportReq">Reporting Requirements<span className="required-star">*</span> :</label>
                    <input
                    id="reportReq"
                    type="text"
                    value={accountDetails?.reportReq|| "" }
                    readOnly={!editableFields.reportReq}

                />
                <select onChange={(e) =>
                    handleSelectChange("reportReqFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  </div>

                  {flags["reportReqFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["reportReqComment"] || ""} onChange={(e) => 
                                handleCommentChange("reportReqComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}

            {/* <button onClick={() => toggleEdit('reportReq')}>

{editableFields.reportReq? 'Save' : 'Edit'}
</button> */}
                </div>
                <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="timeline">Timeline<span className="required-star">*</span> :</label>
                    <input
                    id="timeline"
                    type="text"
                    value={accountDetails?.timeline|| "" }
                    readOnly={!editableFields.timeline}

                    />
                    <select onChange={(e) =>
                    handleSelectChange("timelineFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  </div>

                  {flags["timelineFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["timelineComment"] || ""} onChange={(e) => 
                                handleCommentChange("timelineComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
                     {/* <button onClick={() => toggleEdit('timeline')}>

{editableFields.timeline? 'Save' : 'Edit'}
</button> */}
                </div>
                <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="budget">Budget<span className="required-star">*</span> :</label>
                    <input
                    id="budget"
                    type="text"
                    value={accountDetails?.budget|| "" }
                    readOnly={!editableFields.budget}

            />
            <select onChange={(e) =>
                    handleSelectChange("budgetFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  
                  </div>
                  {flags["budgetFlag"] === 
                    "Reject" && (
                      
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["budgetComment"] || ""} onChange={(e) => 
                                handleCommentChange("budgetComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
        
                 {/* <button onClick={() => toggleEdit('budget')}>

{editableFields.budget? 'Save' : 'Edit'}
</button> */}
                </div>
                <div className='commentR'>
                <div className="form-group2">
                    <label htmlFor="pincode">Pincode<span className="required-star">*</span> :</label>
                    <input
                    id="pincode"
                    type="text"
                    value={accountDetails?.pincode||""}
                    readOnly={!editableFields.pincode}
            />
            <select onChange={(e) =>
                    handleSelectChange("pincodeFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  
                  </div>
                  {flags["pincodeFlag"] === 
                    "Reject" && (
                      
                            <div className='form-group comments'>
                              <label htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["pincodeComment"] || ""} onChange={(e) => 
                                handleCommentChange("pincodeComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
        
                 {/* <button onClick={() => toggleEdit('budget')}>

{editableFields.budget? 'Save' : 'Edit'}
</button> */}
                </div>
                </div>
            </div>
        </div>

 <div className="business-div">
    <h2 className="business-title">Project Evaluation Criteria (To be verified by the Checker)</h2>
    <div className="vertical">
        <div className="vertical1">
        <div className='commentS'>
            <div className="form-group2">
                <label htmlFor="eiacomments">EIA Comments<span className="required-star">*</span> :</label>
                <textarea
                    id="eiacomments"
                    value={accountDetails?.eiacomments|| "" }
                    readOnly={!editableFields.eiacomments}

                  
                />
                
                <select 
             
                onChange={(e) =>
                    handleSelectChange("eiacommFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                 
                  </div>

                  {flags["eiacommFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label  htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["eiacommComment"] || ""} onChange={(e) => 
                                handleCommentChange("eiacommComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
                 {/* <button onClick={() => toggleEdit('eiaComments')}>

{editableFields. eiaComments? 'Save' : 'Edit'}
</button> */}
            </div>
       
            <div className="form-group2">
                <label htmlFor="eiaFile">EIA Uploaded File <span className="required-star">*</span> :</label>
                <div className="file-input-container">

<label>{eiaFile.name}</label>

  <button
      className="download-btn"
      onClick={() => downloadFile(eiaFile)}
      disabled={!eiaFile.data}
  >
      Download
  </button>
</div>

        </div>
        <div className='commentS'>
            <div className="form-group2">
                <label legal-comments-label htmlFor="legalVerificationComments">Legal Verification Comments<span className="required-star">*</span>  :</label>
                <textarea
                    id="legalVerificationComments"
                    value={accountDetails?.legalVerificationComments|| "" }
                    readOnly={!editableFields.legalVerificationComments}
                />
                <select onChange={(e) =>
                    handleSelectChange("legalverFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  </div>

                  {flags["legalverFlag"] === 
                    "Reject" && (
                            <div className='form-group comments '>
                              <label  htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["legalverComment"] || ""} onChange={(e) => 
                                handleCommentChange("legalverComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
 {/* <button onClick={() => toggleEdit('legalVerificationComments')}>

{editableFields.legalVerificationComments ? 'Save' : 'Edit'}
</button> */}
            </div>
            <div className="form-group2">
                <label  htmlFor="legalVerificationFile">Legal Verification Uploaded File <span className="required-star">*</span> :</label>
                <div className="file-input-container">

                  <label>{legalVerificationFile.name}</label>

                    <button
                        className="download-btn"
                        onClick={() => downloadFile(legalVerificationFile)}
                        // disabled={!fileData}
                    >
                        Download
                    </button>
                </div>
        </div>
               </div>
        <div className="vertical2">
        <div className='commentS'>
            <div className="form-group2">
         
                <label htmlFor="financialHealthComments">Financial Health Comments<span className="required-star">*</span>  :</label>
                <textarea
                    id="financialHealthComments"
                    value={accountDetails?.financialHealthComments|| "" }
                    readOnly={!editableFields.financialHealthComments}

                
                />
                <select onChange={(e) =>
                    handleSelectChange("financialHealthFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                   </div>

                  {flags["financialHealthFlag"] === 
                    "Reject" && (
                            <div className='form-group comments'>
                              <label  htmlFor="commentBox" className="commentBox" >Comments:</label>
                              <textarea 
                              value={flags["financialHealthCmnt"] || ""} onChange={(e) => 
                                handleCommentChange("financialHealthCmnt",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
                 {/* <button onClick={() => toggleEdit('financialHealthComments')}>

{editableFields.financialHealthComments ? 'Save' : 'Edit'}
</button> */}
            </div>
         
            <div className="form-group2">
                <label htmlFor="financialHealthFile">Financial Health Uploaded File <span className="required-star">*</span> :</label>
                <div className="file-input-container">

                  <label>{financialHealthFile.name}</label>

                    <button
                        className="download-btn"
                        onClick={() => downloadFile(financialHealthFile)}
                        // disabled={!fileData}
                    >
                        Download
                    </button>
                </div>

        </div>
        <div className='commentS'>
            <div className="form-group2">
         
                <label htmlFor="esgCompliance">ESG Compliance Comments<span className="required-star">*</span>  :</label>
                <textarea
                    id="esgCompliance"
                    value={accountDetails?.esgCompliance|| "" }
                    readOnly={!editableFields.esgCompliance}
                   
                />
                <select onChange={(e) =>
                    handleSelectChange("esgCompFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
           
                  </div>
                  {flags["esgCompFlag"] === 
                    "Reject" && (
                            <div className='form-group comments '>
                              <label  htmlFor="commentBox" className="commentBox">Comments:</label>
                              <textarea 
                              value={flags["esgCompComment"] || ""} onChange={(e) => 
                                handleCommentChange("esgCompComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
                   {/* <button onClick={() => toggleEdit('esgCompliance')}>

{editableFields.esgCompliance ? 'Save' : 'Edit'}
</button> */}
            </div>
            <div className="form-group2">
                <label htmlFor="esgFile">ESG Uploaded File <span className="required-star">*</span> :</label>
                <div className="file-input-container">

                  <label>{esgFile.name}</label>

                    <button
                        className="download-btn"
                        onClick={() => downloadFile(esgFile)}
                        // disabled={!fileData}
                    >
                        Download
                    </button>
                </div>

        </div>
        </div>
    </div>
</div>

     </div>
     
)}
             {activeIndex === 1 && (
            <div className="business-div">
        <h2 className="business-title">Risk Assessment Criteria (To be filled by the Bank)</h2>
        {/* Physical Risk Section */}
        <div className="risk-container">
        <div className="risk-section">
          <h3 className="risk-category">Physical Risk</h3>
          <div className="form-group">
            <label htmlFor="locvul">Location Vulnerability<span className="required-star">*</span> :</label>
            <textarea
             type="text"
             value={accountDetails?.vulnerability|| "" }
             readOnly={!editableFields.vulnerability}

           />
                <select onChange={(e) =>
                    handleSelectChange("vulnerabilityFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["vulnerabilityFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["vulnerabilityComment"] || ""} onChange={(e) => 
                                handleCommentChange("vulnerabilityComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
            

            {/* <button onClick={() => toggleEdit('vulnerability')}>

{editableFields.vulnerability ? 'Save' : 'Edit'}
</button> */}
          </div>
          <div className="form-group">
            <label htmlFor='searise'>Sea-Level Rise (Coastal Properties Only)<span className="required-star">*</span> :</label>
            <textarea
             value={accountDetails?.sealevel || ""}
             readOnly={!editableFields.sealevel}

           />
           <select onChange={(e) =>
                    handleSelectChange("sealevelFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["sealevelFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["sealevelComment"] || ""} onChange={(e) => 
                                handleCommentChange("sealevelComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
            {/* <button onClick={() => toggleEdit('sealevel')}>

{editableFields.sealevel ? 'Save' : 'Edit'}
</button> */}
          </div>
          <div className="form-group">
            <label htmlFor='supplydisrup'>Supply Chain Disruptions<span className="required-star">*</span> :</label>
            <textarea
             type="text"
             value={accountDetails.supplychain || ""}
             readOnly={!editableFields.supplychain }

           />
           <select onChange={(e) =>
                    handleSelectChange("supplychainFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["supplychainFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["supplychainComment"] || ""} onChange={(e) => 
                                handleCommentChange("supplychainComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
           {/* <button onClick={() => toggleEdit('supplychain')}>

{editableFields. supplychain? 'Save' : 'Edit'}
</button> */}
          </div>
          </div>
          <div className="risk-section">
          <h3 className="risk-category">Transition Risk</h3>
          <div className="form-group">
          <label htmlFor='carbonsector'>Carbon-Intensive Sector<span className="required-star">*</span> :</label>
<textarea
    type="text"
    value={accountDetails.carbonintensive|| ""}
    readOnly={!editableFields.carbonintensive}

/>
<select onChange={(e) =>
                    handleSelectChange("carbonintFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["carbonintFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["carbonintComment"] || ""} onChange={(e) => 
                                handleCommentChange("carbonintComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
{/* <button onClick={() => toggleEdit('carbonintensive')}>

                    {editableFields. carbonintensive? 'Save' : 'Edit'}
</button> */}

          </div>

          <div className="form-group">
            <label htmlFor='strandedrisk'>Stranded Assets Risk<span className="required-star">*</span> :</label>
            <textarea
            type="text"
            value={accountDetails.assetrisk|| ""}
            readOnly={!editableFields.assetrisk}
            />
                <select onChange={(e) =>
                    handleSelectChange("assestriskFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["assestriskFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["assestriskComment"] || ""} onChange={(e) => 
                                handleCommentChange("assestriskComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
    {/* <button onClick={() => toggleEdit('assetrisk')}>

{editableFields.assetrisk? 'Save' : 'Edit'}
</button> */}
</div>
<div className="form-group">
<label htmlFor='shifconsumer'>Shifting Consumer Preferences<span className="required-star">*</span> :</label>
<textarea
  name="Shifting Consumer Preferences"  // Add a name attribute
  value={accountDetails.shifting|| ""}
  readOnly={!editableFields.shifting}

/>
<select onChange={(e) =>
                    handleSelectChange("shiftingFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["shiftingFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["shiftingComment"] || ""} onChange={(e) => 
                                handleCommentChange("shiftingComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
{/* <button onClick={() => toggleEdit('shifting')}>

                    {editableFields.shifting ? 'Save' : 'Edit'}
</button> */}
</div>
        </div>
  </div>
  {/* Operational Vulnerabilities Section */}
<div className="risk-container">
  <div className="risk-section">
    <h3 className="risk-category">Operational Vulnerabilities</h3>

    <div className="form-group">
      <label htmlFor='businessplans'>Business Continuity Plans<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails.business|| ""}
        readOnly={!editableFields.business}

      />
      <select onChange={(e) =>
                    handleSelectChange("businessFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["businessFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["businessComment"] || ""} onChange={(e) => 
                                handleCommentChange("businessComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
      {/* <button onClick={() => toggleEdit('business')}>

{editableFields.business? 'Save' : 'Edit'}
</button> */}
    </div>

    <div className="form-group">
      <label htmlFor='climateinfra'>Climate Resilience Infrastructure<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails.climate|| ""}
        readOnly={!editableFields.climate}

      />
      <select onChange={(e) =>
                    handleSelectChange("climateFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["climateFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["climateComment"] || ""} onChange={(e) => 
                                handleCommentChange("climateComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
      {/* <button onClick={() => toggleEdit('climate')}>

{editableFields.climate? 'Save' : 'Edit'}
</button> */}
    </div>
  </div>

  {/* Emission Data Section */}
  <div className="risk-section">
    <h3 className="risk-category">Emission Data</h3>

    <div className="form-group">
      <label htmlFor='borrowerfootprint'>Borrower’s Emission Footprint<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails.borroweremission|| ""}
        readOnly={!editableFields.borroweremission}

      />
      <select onChange={(e) =>
                    handleSelectChange("borrowermissionFlag",e.target.value)}>
                        <option value="Select an option">Select an option</option>
                      <option value="Accept">Accept</option>
                      <option value="Reject">Reject</option>
                  </select>
                  

                  {flags["borrowermissionFlag"] === 
                    "Reject" && (
                            <div className='form-group'>
                              <label>Comments:</label>
                              <textarea 
                              value={flags["borrowermissionComment"] || ""} onChange={(e) => 
                                handleCommentChange("borrowermissionComment",e.target.value)}
                                placeholder="Reason..."
                                rows="3"
                                cols="40"
                              />
                              </div>
                    )}
      {/* <button onClick={() => toggleEdit('borroweremission')}>

{editableFields. borroweremission? 'Save' : 'Edit'}
</button> */}
    </div>
  </div>
</div>
</div>
     )}
{activeIndex === 2 && (
  <div className="business-div">
    <h2 className="business-title">Project-Specific Indicators</h2>

    <div className="table-container">
      <div className="maker-datatable">
      <DataTable

        value={indicators} // Ensure formData.indicators is an array
        responsiveLayout="scroll"
        editMode="cell" // Enable cell editing
      >
        {/* Mandatory Indicator - non-editable */}
        <Column
          field="sector"
          header="Sector"
          sortable
          style={{ minWidth: '6rem' }}
          editorDisabled // Make this column non-editable
        />
        <Column
          field="mandatoryIndicator"
          header="Mandatory Indicator"
          sortable
          style={{ minWidth: '6rem' }}
          editorDisabled // Make this column non-editable
        />
        {/* Description - non-editable */}
        <Column
          field="description"
          header="Description"
          sortable
          style={{ minWidth: '6rem' }}
          editorDisabled // Make this column non-editable
        />
        {/* Type - non-editable */}
        <Column
          field="type"
          header="Type"
          sortable
          style={{ minWidth: '6rem' }}
          editorDisabled // Make this column non-editable
        />
        <Column
          field="methodology"
          header="Methodology"
          sortable
          style={{ minWidth: "10rem", whiteSpace: "pre-line" }}
          body={(rowData) => {
            if (!rowData.methodology) return null;

    
     

          // console.log("Raw Methodology Data:", rowData.methodology); // Debugging

          // Split by new lines and process each point
        const formattedMethodology = rowData.methodology
        .split(/\r?\n/) // Handle both Windows (`\r\n`) and Linux (`\n`) line breaks
        .map((point) => point.trim()) // Trim spaces
        .map((point) => point.replace(/^-\s*/, "")) // Remove only the leading "- " if it exists
        .filter((point) => point.length > 0); // Remove empty lines

        return (
          <ul style={{ paddingLeft: "20px", margin: 0, listStyleType: "disc" }}>
            {formattedMethodology.map((point, index) => (
          <li key={index} style={{ marginBottom: "5px", textAlign: "justify" }}>
            {point}
          </li>
        ))}
      </ul>
    );
  }}
  editorDisabled // Make this column non-editable
/>
<Column
  field="comment"
  header="Comment"
  sortable
  style={{ minWidth: '10rem' }} // Increase column width
  body={(rowData) => {
    // Match the comment from the first API response using the commentKey
    const matchedComment = accountDetails[rowData.commentKey] || "";
 
    return (
        <textarea
        type="text"
        className="datatable-input"
        value={matchedComment}
        onChange={(e) => {
          // Handle the change (if you need to update it in the state)
        }}
        style={{
          width: '100%', // Make input field take full column width
          height: '40px', // Increase input box height
          fontSize: '16px', // Increase text size
          padding: '8px' // Add spacing inside input
        }}
      />
    );
  }}
/>
         
      </DataTable>
    </div>
  </div>
 


  
  {/* <button onClick={handleDownloadPDF} className='download-button'>
    Download
  </button> */}
  </div>
)}
    <div className="button-container2">
  {/* <Button label="Previous" icon="pi pi-arrow-left" onClick={prevStep} disabled={activeIndex === 0} />  */}
  <Button label="Previous" icon="pi pi-arrow-left" className="saveNext" onClick={prevStep} disabled={activeIndex === 0} />
  {/* Add Back Button next to Previous */}
  {activeIndex < steps.length - 1 ? (
    <>
      {/* <Button label="Next" icon="pi pi-arrow-right" onClick={nextStep} /> */}
      <Button label="Next" icon="pi pi-arrow-right" className="saveNext" onClick={handleSubmit} />
      {/* <Button label="Back" className="backButton" onClick={handleBack} /> */}
    </>
  ) : (
    <Button label="Submit" icon="pi pi-check"  className="saveNext" onClick={handleSubmit1} />
  )}
</div>
  </div>
  );
};



export default Admin1;


