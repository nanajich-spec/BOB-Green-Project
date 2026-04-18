import React, {  useState ,useEffect } from 'react';
import { Button } from 'primereact/button';
import './Maker.css';
import {  userRole, handleApprovalStatus } from './ProjectSpecificIndicator.js';
import { Toast } from 'primereact/toast';
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.min.css';
import axios from 'axios'
import {useRef} from'react';
import './Checker1.css';
import { useParams } from "react-router-dom";
import { useLocation } from "react-router-dom";

const Checker1 = () => {
    const toast = useRef(null);
  
    const location = useLocation();
    const [fileData, setFileData] = useState(null); // Store file as a Blob
    const [formData, setFormData] = useState({
        generalInfo: {
          accountNumber: '',
          borrowerName: '',
          branchName: '',
          panNumber: '',
          cinNumber: '',
          schemeCode: '',
          activityCode: '',
          briefDtls:'',
          description: '',
          projName: '',
          sector: '',
          locationType: '',
          othersAdd: '',
          susobj: '',
          longitude:'',
          latitude:'',
          stakeEng: '',
          reportReq: '',
          timeline: '',
          budget: '',
          pincode: '',
          eiaComments: '',
          eiaFile: null,
          legalVerificationComments: '',
          legalVerificationFile:null,
          financialHealthComments: '',
          financialHealthFile:null,
          esgCompliance: '',
          esgFile: null,
        },
        riskAssessmentData:
          {
            vulnerability: '',
            vulnerabilityFlag: '',
            carbonintensive: '',
            carbonintFlag: '',
            sealevel:'',
            sealevelFlag: '',
            assetrisk: '',
            assestriskFlag: '',
            supplychain: '',
            supplychainFlag: '',
            shifting: '',
            shiftingFlag: '',
            business:'',
            businessFlag: '',
            climate: '',
            climateFlag: '',
            borroweremission: '',
            borroweremissionFlag: '',
},
  indicators:
  [{ indicator: "", description: "", comment: "", type: "", methodology: "" }],
  });
  // Stepper state
  const [activeIndex, setActiveIndex] = useState(0);
  const [selectedSUSObj, setSelectedSUSObj] = useState('');
  const [indicators, setIndicators] = useState();
  //const [susobjs, setSusobjs] = useState([]);
  const [isLoading, setIsLoading ] = useState([false]);
  const [userRole, setUserRole] = useState('');
  // const [approvalStatus] = useState(null);  Define approvalStatus as state if needed
  const [file, setFile] = useState(null); // State to store the selected file
  const [remarks, setRemarks] = useState('');
  const[fileName,setFileName]=useState('');
//  const{accountNumber}=useParams();
  const [AccN, setAccN ] = useState ('');
  // const [returnComment, setReturnComment] = useState('');

  const [isApproved, setIsApproved] = useState(false);
  const [status, isStatus] = useState();
  const [isReturned, setIsReturned] = useState(false);
  const [returnComment, setReturnComment] = useState("");
  const [loading, setLoading] = useState(false);
  // const toast = React.useRef(null);
  // const [isReturned, setIsReturned] = useState(false);
  const [accountDetails, setAccountDetails] = useState(null);
  const [eiaFile, setEiaFile] = useState({ name: "No valid file available", data: null });
  const [legalVerificationFile, setLegalVerificationFile] = useState({ name: "No valid file available", data: null });
  const [financialHealthFile, setFinancialHealthFile] = useState({ name: "No valid file available", data: null });
  const [esgFile, setEsgFile] = useState({ name: "No valid file available", data: null });
  const [accountNumber, setaccountNumber] = useState({});
  const [SustainObj,setSustainObj]= useState({}); 
  const [susobj, setSusobjs] = useState([]);
  


useEffect(() => {
  if (location.state?.accountNumber) {
    const accountNumber = location.state?.accountNumber;
    console.log(accountNumber);
    setaccountNumber(accountNumber);
    setSustainObj(susobj);
    
    try{
      axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/${accountNumber}`).then((response) =>{

        // setAccountDetails(response);
        console.log("Received Account Details:", response.data);  
        setAccountDetails(response.data);

        axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/pickdataSusObj/${response.data.susobj}`).then((response1)=>{
          console.log("Received Account Details:", response1.data);  

        setIndicators(response1.data);
        })
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

  const generalInfo = {
    accountNumber: formData.generalInfo?.accountNumber,   // Account Number
    borrowerName: formData.generalInfo?.borrowerName,     // Borrower's Name
    borrowerFlag: formData.generalInfo?.borrowerFlag,     // Borrower Flag
    branchName: formData.generalInfo?.branchName,         // Branch Name
    branchFlag: formData.generalInfo?.branchFlag,         // Branch Flag
    panNumber: formData.generalInfo?.panNumber,           // PAN Number
    panFlag: formData.generalInfo?.panFlag,               // PAN Flag
    cinNumber: formData.generalInfo?.cinNumber,           // CIN Number
    cinFlag: formData.generalInfo?.cinFlag,               // CIN Flag
    schemeCode: formData.generalInfo?.schemeCode,         // Scheme Code
    schemeFlag: formData.generalInfo?.schemeFlag,         // Scheme Flag
    activityCode: formData.generalInfo?.activityCode,     // Activity Code
    activityFlag: formData.generalInfo?.activityFlag, 
    briefDtls: formData.generalInfo?.briefDtls,    // Activity Flag
    projName: formData.generalInfo?.projName,             // Project Name
    projFlag: formData.generalInfo?.projFlag,             // Project Flag
    sector: formData.generalInfo?.sector,                 // Sector
    sectorFlag: formData.generalInfo?.sectorFlag,         // Sector Flag
    location: formData.generalInfo?.locationType,             // Location
    locationFlag: formData.generalInfo?.locationTypeFlag, 
    othersAdd: formData.generalInfo?.othersAdd, 
    longitude: formData.generalInfo?.longitude,
    longitudeFlag: formData.generalInfo?.longitudeFlag, 
    latitude: formData.generalInfo?.latitude,
    latitudeFlag: formData.generalInfo?.latitudeFlag,        // Location Flag
    description: formData.generalInfo?.description,       // Description
    descpFlag: formData.generalInfo?.descpFlag,           // Description Flag
    susobj: formData.generalInfo?.susobj,                 // Sustainable Objective
    susobjFlag: formData.generalInfo?.susobjFlag,         // Sustainable Objective Flag
    stakeEng: formData.generalInfo?.stakeEng,             // Stakeholder Engagement
    stakeEngFlag: formData.generalInfo?.stakeEngFlag,     // Stakeholder Engagement Flag
    reportReq: formData.generalInfo?.reportReq,           // Report Requirement
    reportReqFlag: formData.generalInfo?.reportReqFlag,   // Report Requirement Flag
    timeline: formData.generalInfo?.timeline,             // Timeline
    timelineFlag: formData.generalInfo?.timelineFlag,     // Timeline Flag
    budget: formData.generalInfo?.budget,                 // Budget
    budgetFlag: formData.generalInfo?.budgetFlag,   
    pincode: formData.generalInfo?.pincode, 
    pincodeFlag: formData.generalInfo?.pincodeFlag,      // Budget Flag
    legalVerificationComments: formData.generalInfo?.legalVerificationComments,  // Legal Verification Comments
    legalverFlag: formData.generalInfo?.legalverFlag,     // Legal Verification Flag
    financialHealthComments: formData.generalInfo?.financialHealthComments,      // Financial Health Comments
    financialHealthFlag: formData.generalInfo?.financialHealthFlag, // Financial Health Flag
    esgCompliance: formData.gerenalInfo?.esgCompliance,     // ESG Compliance
    esgCompFlag: formData.generalInfo?.esgCompFlag,         // ESG Compliance Flag
  };
  const riskAssessmentData ={
    vulnerability: formData.riskAssessmentData?.vulnerability,     // Vulnerability Assessment
    carbonintensive: formData.riskAssessmentData?.carbonintensive, // Carbon Intensity
    sealevel: formData.riskAssessmentData?.sealevel,               // Sea Level Impact
    assetrisk: formData.riskAssessmentData?.assetrisk,             // Asset Risk
    supplychain: formData.riskAssessmentData?.supplychain,         // Supply Chain Risk
    shifting: formData.riskAssessmentData?.shifting,               // Shifting Risk (e.g., climate-related)
    business: formData.riskAssessmentData?.business,               // Business Risk
    climate: formData.riskAssessmentData?.climate,                 // Climate-related Risk
    borroweremission: formData.riskAssessmentData?.borroweremission, // Borrower's Emissions
  };
  const saveGeneralInfo = async (accountNum) => {
    console.log(generalInfo);
    try {
      console.log("inside general info");
      const response = await axios.post(
        // `http://172.16.182.177:8080/green-project/api/v1/updatedPhase1/${accountNum}`,
         `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/updatedPhase1/${accountNum}`,
        generalInfo,
        { headers: { "Content-Type": "application/json" ,

        } ,
      }
      );
      console.log(response);
      if (response.status === 200) {
        toast.current.show({ severity: 'success', summary: 'Success', detail: 'General info saved successfully!' });
      } else {
        throw new Error("Unexpected response from server");
      }
    } catch (error) {
      // console.error("Error saving general info:", error);
      // toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save general info: ' + error.message });
    }
  };
  const saveRiskAssessment = async (accountNum) => {
    try {
      console.log("risk assessment");
      console.log(riskAssessmentData);
      console.log(formData.riskAssessmentData);
      //  console.log("Saving RiskAssessment")
      const response = await axios.post(
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/updatedPhase2/${accountNum}`,
      
        riskAssessmentData,
        { headers: { "Content-Type": "application/json" ,

        } ,
      }
      );
      if (response.status === 200) {
        toast.current.show({ severity: 'success', summary: 'Success', detail: 'Risk assessment saved successfully!' });
      } else {
        throw new Error("Unexpected response from server");
      }
    } catch (error) {
      // console.error("Error saving risk assessment:", error);
      // toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save risk assessment: ' + error.message });
    }
  };

// Form validation
    // const validateForm = () => {
    //   if (activeIndex === 0) {
    //     // Validate General Info
    //     if (!formData.generalInfo.accountNumber || !formData.generalInfo.borrowerName) {
    //       toast.current.show({ severity: 'warn', summary: 'Validation', detail: 'Please fill in all required fields' });
    //       return false;
    //     }
    //   } else if (activeIndex === 1) {
    //     // Validate Risk Assessment
    //     if (!formData.riskAssessmentData?.vulnerability ) {
    //       toast.current.show({ severity: 'warn', summary: 'Validation', detail: 'Please fill in all required fields for Risk Assessment' });
    //       return false;
    //     }
    //   }
    //   return true;
    // };
  
  // Move to the previous step
  const prevStep = () => {
    setActiveIndex(activeIndex - 1);
  };
  const nextStep = () => {
    setActiveIndex(activeIndex + 1);
  };
  //HANDLE SUBMIT
 const handleSubmit = async () => {
    // if (!validateForm()) return; // Ensure form is validated

    try {

      if (activeIndex === 0) {
        await saveGeneralInfo(formData.generalInfo.accountNumber);
      } else if (activeIndex === 1) {
        await saveRiskAssessment(formData.generalInfo.accountNumber );
      }
      //  alert("Data saved successfully!");
       nextStep(); // Move to the next step in the form or process

    } catch (error) {
      console.error("Error during form submission:", error);
      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save data: ' + error.message });
    }
  };

  //Handle input change for the "comment" field
  const handleCommentChange = (e, rowIndex) => {
    const updatedIndicators = [...indicators];
    updatedIndicators[rowIndex].comment = e.target.value;
    setIndicators(updatedIndicators);
  };

  // const handleValidation = (e, section, field) => {
  //     const { value } = e.target;
  //     const regex = /^-?\d+(\.\d{0,6})?$/; // Allows numbers with up to 6 decimal places
    
  //     if (!regex.test(value)) {
  //       toast.current.show({
  //                   severity: 'error',
  //                   summary: 'Validation Error',
  //                   detail: 'Only up to 6 decimal places are allowed.'
  //               });
  //               return;
  //           }
      // if (value === '' || regex.test(value)) {
          //  handleChange(e, section, field); // Update state only if valid

      // }
  // };
  // Steps configuration
const steps = [
  { label: 'General Information' },
  { label: 'Risk Assessment' },
  { label: 'Project-Specific Indicators' }, // Add this line
];

     // Error handling function
   const error = (message) => {
    // Handle errors (e.g., displaying an error message)
    console.error(message);
  };
    const handleBack = () => {
      // Example: Go back to the previous page
      window.history.back();
    };

    // const handleApprove = () => {
    //     toast.current.show({ severity: 'success', summary: 'Approved', detail: 'The project has been approved.' });
    //             setIsReturned(false); // Hide comment box if previously rejected
    //         };

    //         const handleReturn = () => {
    //             setIsReturned(true);  Show comment box when rejected
    //         };

 
            const handleSubmit1 = async (decisionstr) => {
             
              
              setLoading(true);
              try {
                  const requestData = {
                      accountNumber: accountNumber,
                      decision: decisionstr === "approve" ? "approve" : "return", // Decision is either approve or return
                      returnReason: returnComment, // Reason for return
                      status: '',
                      checkerId:'',
                  };
                  console.log("AccountNumber:",accountNumber);
                  console.log("RequestData:",requestData);
                  
                  // Make API call to submit the decision
                  const response = await axios.post(
                    `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/checker/${accountNumber}`,
      
                    
                  requestData,
                      { headers: { "Content-Type": "application/json"}}
                    
                  );
                
                  console.log(response);
                
                  if (response.status === 200) {
                      toast.current.show({ severity: 'success', summary: 'Success', detail: 'Decision submitted successfully!' });
                      // Reset form or navigate to another page if needed
                      resetForm();
                  } else {
                      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Something went wrong!' });
                  }
              } catch (error) {
                  toast.current.show({ severity: 'error', summary: 'Error', detail: 'An error occurred!' });
              } finally {
                  setLoading(false);
              }
          };
       
          const resetForm = () => {
              setIsApproved(false);
              setIsReturned(false);
              setReturnComment('');
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
        <>
          {/* Business Information */}
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

                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="branchName">Branch<span className="required-star">*</span> :</label>
                  <input
                    id="branchName"
                    type="text"
                    value={accountDetails?.branchName || "" }
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="panNumber">PAN Number<span className="required-star">*</span> :</label>
                  <input
                    id="panNumber"
                    type="text"

                    value={accountDetails?.panNumber || "" }
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="cinNumber">CIN<span className="required-star">*</span> :</label>
                  <input
                    id="cinNumber"
                    type="text"
                    value={accountDetails?.cinNumber || "" }

                  />
                </div>
              </div>
              <div className="vertical2">
                <div className="form-group2">
                  <label htmlFor="schemeCode">Scheme Code<span className="required-star">*</span> :</label>
                  <input
                    id="schemeCode"
                    type="text"
                    value={accountDetails?.schemeCode || "" }
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="activityCode">Activity Code<span className="required-star">*</span> :</label>
                  <input
                    id="activityCode"
                    type="text"
                    value={accountDetails?.activityCode || "" }
                  />
                </div>
                <div className="form-group2">
  <label htmlFor="briefDtls">
    Brief Details of the Project
    <span className="required-star">*</span> :
  </label>
<input
    id="briefDtls"
    value={accountDetails?.briefDtls || "" }
  />
</div>
                <div className="form-group2">
                  <label htmlFor="projName">Name of the Project<span className="required-star">*</span> :</label>
                  <input
                  id="projName"
                  type="text"
                  value={accountDetails?.projName || "" }
            />
                </div>
            </div>
        </div>
</div>
{/* General Information (To be provided by Borrower) */}
<div className='business-div'>
   <h2 className='business-title'>General Information (To be provided by Borrower)</h2>
        <div className='vertical'>
            <div className='vertical1'>
                <div className="form-group2">
                    <label htmlFor="sector">Sector<span className="required-star">*</span> :</label>
                    <input
                    id="sector"
                    type="text"
                    value={accountDetails?.sector|| "" }
            />
                </div>
                <div className="form-group2">
                    <label htmlFor="locationType">Location<span className="required-star">*</span> :</label>
                    <input
                    id="locationType"
                    type="text"
                    value={accountDetails?.locationType|| "" }
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
                </div>
                <div className="form-group2">
                    <label htmlFor="projName">Project Description<span className="required-star">*</span> :</label>
                   <input
                    id="description"
                    type="text"
                    value={accountDetails?.description|| "" }
            />
                </div>
                <div className="form-group2">
    <label htmlFor="susobj">Sustainability Objectives :</label>
    <input
        id="susobj"
        type="text"
        value={accountDetails?.susobj|| "" }
        readOnly
        className="readonly-input"
    />
</div>
<div className="form-group2">
                    <label htmlFor="longitude">Longitude<span className="required-star">*</span> :</label>
                    <input
                    id="longitude"
                    type="text"
                    value={accountDetails?.longitude|| ""}
                    // onChange={(e) => setProjName(e.target.value)}
                    // onChange={(e) => handleValidation(e, 'generalInfo', 'longitude')}
                    
                />
                </div>
                <div className="form-group2">
                    <label htmlFor="latitude">Latitude<span className="required-star">*</span> :</label>
                    <input
                    id="latitude"
                    type="text"
                    value={accountDetails?.latitude|| ""}
                    // onChange={(e) => setProjName(e.target.value)}
                    // onChange={(e) => handleValidation(e, 'generalInfo', 'latitude')}
                />


                
                </div> 
               
            </div>
            <div className='vertical2'>
                <div className="form-group2">
                    <label htmlFor="stakeEng">Stake Holder Engagement<span className="required-star">*</span> :</label>
                    <input
                    id="stakeEng"
                    type="text"
                    value={accountDetails?.stakeEng|| "" }
                    />
                </div>
                <div className="form-group2">
                    <label htmlFor="reportReq">Reporting Requirements<span className="required-star">*</span> :</label>
                    <input
                    id="reportReq"
                    type="text"
                    value={accountDetails?.reportReq|| "" }
            />
                </div>
                <div className="form-group2">
                    <label htmlFor="timeline">Timeline<span className="required-star">*</span> :</label>
                    <input
                    id="timeline"
                    type="text"
                    value={accountDetails?.timeline|| "" }
                    />
                </div>
                <div className="form-group2">
                    <label htmlFor="budget">Budget<span className="required-star">*</span> :</label>
                    <input
                    id="budget"
                    type="text"
                    value={accountDetails?.budget|| "" }
            />
                </div>
                <div className="form-group2">
                    <label htmlFor="pincode">Pincode<span className="required-star">*</span> :</label>
                    <input
                    id="pincode"
                    type="text"
                    value={accountDetails?.pincode||""}
                  
            />
                </div>
            </div>
        </div>
 </div>
 <div className="business-div">
    <h2 className="business-title">Project Evaluation Criteria (To be verified by the Checker)</h2>
    <div className="vertical">
        <div className="vertical1">
            <div className="form-group2">
                <label htmlFor="eiacomments">EIA Comments :</label>
                <textarea
                    id="eiacomments"
                    value={accountDetails?.eiacomments|| "" }
                    readOnly
                />
            </div>
            <div className="form-group2">
                <label htmlFor="eiaFile">EIA Uploaded File :</label>
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
            <div className="form-group2">
                <label htmlFor="legalVerificationComments">Legal Verification Comments :</label>
                <textarea
                    id="legalVerificationComments"
                    value={accountDetails?.legalVerificationComments|| "" }
                    readOnly
                />
            </div>
            <div className="form-group2">
                <label htmlFor="legalVerificationFile">Legal Verification Uploaded File :</label>
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
            <div className="form-group2">
                <label htmlFor="financialHealthComments">Financial Health Comments :</label>
                <textarea
                    id="financialHealthComments"
                    value={accountDetails?.financialHealthComments|| "" }
                    readOnly
                />
            </div>
            <div className="form-group2">
                <label htmlFor="financialHealthFile">Financial Health Uploaded File :</label>
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
            <div className="form-group2">
                <label htmlFor="esgCompliance">ESG Compliance Comments :</label>
                <textarea
                    id="esgCompliance"
                    value={accountDetails?.esgCompliance|| "" }
                    readOnly
                />
            </div>
            <div className="form-group2">
                <label htmlFor="esgFile">ESG Uploaded File :</label>
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

     </>
)}
             {activeIndex === 1 && (
            <div className="business-div">
        <h2 className="business-title">Risk Assessment Criteria (To be filled by the Bank)</h2>
        {/* Physical Risk Section */}
        <div className="risk-container">
        <div className="risk-section">
          <h3 className="risk-category">Physical Risk</h3>
          <div className="form-group">
            <label>Location Vulnerability<span className="required-star">*</span> :</label>
            <textarea
             type="text"
             value={accountDetails?.vulnerability|| "" }

           />
          </div>
          <div className="form-group">
            <label>Sea-Level Rise (Coastal Properties Only)<span className="required-star">*</span> :</label>
            <textarea
             value={accountDetails?.sealevel || ""}

           />
          </div>
          <div className="form-group">
            <label>Supply Chain Disruptions<span className="required-star">*</span> :</label>
            <textarea
             type="text"
             value={accountDetails.supplychain || ""}

           />
          </div>
          </div>
          <div className="risk-section">
          <h3 className="risk-category">Transition Risk</h3>
          <div className="form-group">
          <label>Carbon-Intensive Sector<span className="required-star">*</span> :</label>
<textarea
    type="text"
    value={accountDetails.carbonintensive|| ""}

/>
          </div>

          <div className="form-group">
    <label>Stranded Assets Risk<span className="required-star">*</span> :</label>
    <textarea
        type="text"
        value={accountDetails.assetrisk|| ""}

    />
</div>
<div className="form-group">
<label>Shifting Consumer Preferences<span className="required-star">*</span> :</label>
<textarea
  name="shiftingConsumerPreferences"  // Add a name attribute
  value={accountDetails.shifting|| ""}

/>
</div>
        </div>
  </div>
  {/* Operational Vulnerabilities Section */}
<div className="risk-container">
  <div className="risk-section">
    <h3 className="risk-category">Operational Vulnerabilities</h3>

    <div className="form-group">
      <label>Business Continuity Plans<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails.business|| ""}

      />
    </div>

    <div className="form-group">
      <label>Climate Resilience Infrastructure<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails.climate|| ""}

      />
    </div>
  </div>

  {/* Emission Data Section */}
  <div className="risk-section">
    <h3 className="risk-category">Emission Data</h3>

    <div className="form-group">
      <label>Borrower’s Emission Footprint<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails.borroweremission|| ""}

      />
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

    // console.log("Raw Methodology Data:", rowData.methodology); 

    // Split by new lines and process each point
    const formattedMethodology = rowData.methodology
      .split(/\r?\n/) 
      .map((point) => point.trim()) 
      .map((point) => point.replace(/^-\s*/, "")) 
      .filter((point) => point.length > 0); 

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
  </div>
)}
    <Toast ref={toast} />
     {/* Approve & Reject Buttons */}
     {
        activeIndex===steps.length -1&&(

            <>
            <div className="decision-container">
            <div className="decision-title">Decision</div>

            <div className="button-container">
                <Button label="Approve" className="approveButton" onClick={() => { setIsApproved(true); setIsReturned(false); handleSubmit1("approve"); }}
                        disabled={loading}/>
                <Button label="Return" className="returnButton"    onClick={() => { setIsApproved(false); setIsReturned(true); }}
                        disabled={loading}/>
            </div>

            {/* Show comment box only when rejected */}
            {isReturned && (
                <div className="return-comment">
                    <label htmlFor="returnReason">Return Reason:</label>
                    <textarea
                        id="returnReason"
                        value={returnComment}
                        onChange={(e) => setReturnComment(e.target.value)}
                        placeholder="Enter return comments..."
                        className="return-textarea"
                    />
                </div>
            )}
           </div>
            </>

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


export default Checker1;










