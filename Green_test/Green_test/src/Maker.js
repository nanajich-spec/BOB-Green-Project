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
import { useParams } from "react-router-dom";
import { } from 'react-router-dom';



const Maker = () => {
    const toast = useRef(null);
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
        
         eiacomments : '',
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
  

        const [indicators, setIndicators] = useState([
          { indicator: "Pollution Control", commentKey: "pollContCmnt" },
          { indicator: "Water Pollution", commentKey: "waterPolluCmnt" },
          { indicator: "Protected Areas", commentKey: "protectAreaComnt" },
          { indicator: "Stakeholder Information", commentKey: "infoStakeComnt" },
          { indicator: "Clean Vehicles", commentKey: "cleanVehicleCmnt" },
          { indicator: "Capacity of Renewable Energy Plants", commentKey: "capPlantComment" },
          { indicator: "Energy Pre & Post Assessment", commentKey: "energyPrePostcmnt" },
          { indicator: "Estimated Reduction", commentKey: "estReductionCmnt" },
          { indicator: "Sustainable Area", commentKey: "areaSustainCmnt" },
          { indicator: "Habitat Restoration", commentKey: "restorehabitCmnt" },
          { indicator: "Annual Amount", commentKey: "annualAmountCmnt" },
          { indicator: "Restoration of Land", commentKey: "restorelandCmnt" },
          { indicator: "Natural Land Conservation", commentKey: "naturalLandCmnt" },
          { indicator: "Sustainable Practices", commentKey: "sustainableComnt" },
          { indicator: "Annual Water Consumption", commentKey: "annualWaterCmnt" },
          { indicator: "Reduction in Water Usage", commentKey: "reductionWatercmnt" },
          { indicator: "Number of Targets", commentKey: "numberTrgtCmnt" },
          { indicator: "Water Use Efficiency", commentKey: "waterUseCmnt" },
          { indicator: "Land Area Management", commentKey: "areaLandCmnt" },
          { indicator: "Annual GHG Emissions", commentKey: "annGHGComment" },
          { indicator: "CO2 Reduction", commentKey: "co2Comment" },
          { indicator: "Annual Energy Savings", commentKey: "annEnergyCmnt" },
          { indicator: "Annual Pollution Level", commentKey: "annLevelCmnt" }
      ]);                                                                                 //CH2



  const [susobjs, setSusobjs] = useState([]);
  const [isLoading, setIsLoading ] = useState([false]);
  const [userRole,] = useState('');
  const [approvalStatus] = useState(null); // Define approvalStatus as state if needed
  const [file, setFile] = useState(null); // State to store the selected file
  const [remarks, setRemarks] = useState('');
  //  const[accountNumber,setAccountNumber]=useState('');
  const[fileName,setFileName]=useState('');
  const{accountNumber}=useParams();
  const [AccN, setAccN ] = useState ('');
  const [comments, setComments] = useState({});
  //const [accountDetails, setAccountDetails] = useState([]);

 
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
    locationType: formData.generalInfo?.locationType,             // Location
    locationTypeFlag: formData.generalInfo?.locationTypeFlag,  
    // othersAdd: formData.generalInfo?.othersAdd,   // Location Flag
    othersAdd: formData.generalInfo?.othersAdd,  
    description: formData.generalInfo?.description,    // Description
    descpFlag: formData.generalInfo?.descpFlag,           // Description Flag
    susobj: formData.generalInfo?.susobj,                 // Sustainable Objective
    susobjFlag: formData.generalInfo?.susobjFlag, 
    longitude: formData.generalInfo?.longitude,
    longitudeFlag: formData.generalInfo?.longitudeFlag, 
    latitude: formData.generalInfo?.latitude,
    latitudeFlag: formData.generalInfo?.latitudeFlag,    // Sustainable Objective Flag
    stakeEng: formData.generalInfo?.stakeEng,             // Stakeholder Engagement
    stakeEngFlag: formData.generalInfo?.stakeEngFlag,     // Stakeholder Engagement Flag
    reportReq: formData.generalInfo?.reportReq,           // Report Requirement
    reportReqFlag: formData.generalInfo?.reportReqFlag,   // Report Requirement Flag
    timeline: formData.generalInfo?.timeline,             // Timeline
    timelineFlag: formData.generalInfo?.timelineFlag,     // Timeline Flag
    budget: formData.generalInfo?.budget,                 // Budget
    budgetFlag: formData.generalInfo?.budgetFlag, 
    pincode: formData.generalInfo?.pincode, 
    pincodeFlag: formData.generalInfo?.pincodeFlag,   // Budget Flag
    legalVerificationComments: formData.generalInfo?.legalVerificationComments,  // Legal Verification Comments
    legalverFlag: formData.generalInfo?.legalverFlag,     // Legal Verification Flag
    financialHealthComments: formData.generalInfo?.financialHealthComments,      // Financial Health Comments
    financialHealthFlag: formData.generalInfo?.financialHealthFlag, // Financial Health Flag
    esgCompliance: formData.generalInfo?.esgCompliance,     // ESG Compliance
    esgCompFlag: formData.generalInfo?.esgCompFlag,         // ESG Compliance Flag
    eiacomments: formData.generalInfo?.eiacomments,         // EIA Comments
    
  };
 
  const riskAssessmentData ={
 
    vulnerability: formData.riskAssessmentData?.vulnerability,     // Vulnerability Assessment
    //  vulnerabilityFlag: formData.riskAssessmentData?.vulnerabilityFlag,  // Vulnerability Flag
    carbonintensive: formData.riskAssessmentData?.carbonintensive, // Carbon Intensity
    //  carbonintFlag: formData.riskAssessmentData?.carbonintFlag,     // Carbon Intensity Flag
    sealevel: formData.riskAssessmentData?.sealevel,               // Sea Level Impact
    //   sealevelFlag: formData.riskAssessmentData?.sealevelFlag,       // Sea Level Flag
    assetrisk: formData.riskAssessmentData?.assetrisk,             // Asset Risk
    //  assestriskFlag: formData.riskAssessmentData?.assestriskFlag,   // Asset Risk Flag
    supplychain: formData.riskAssessmentData?.supplychain,         // Supply Chain Risk
    //  supplychainFlag: formData.riskAssessmentData?.supplychainFlag, // Supply Chain Flag
    shifting: formData.riskAssessmentData?.shifting,               // Shifting Risk (e.g., climate-related)
    //   shiftingFlag: formData.riskAssessmentData?.shiftingFlag,       // Shifting Risk Flag
    business: formData.riskAssessmentData?.business,               // Business Risk
    // businessFlag: formData.riskAssessmentData?.businessFlag,       // Business Flag
    climate: formData.riskAssessmentData?.climate,                 // Climate-related Risk
    // climateFlag: formData.riskAssessmentData?.climateFlag,         // Climate Flag
    borroweremission: formData.riskAssessmentData?.borroweremission, // Borrower's Emissions
    // borrowermissionFlag: formData.riskAssessmentData?.borrowermissionFlag, // Borrower's Emission Flag
  };
 
 
  const saveGeneralInfo = async (accountNum) => {
    console.log(generalInfo);
    // console.log("form data");
    // console.log(formData.generalInfo);
    try {
      console.log("inside general info");
      console.log("General info :",generalInfo);
      const response = await axios.post(
        // `http://172.16.182.177:8080/green-project/api/v1/updatedPhase1/${accountNum}`,
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/updatedPhase1/${accountNum}`,
        generalInfo,
        { headers: 
          { "Content-Type": "application/json" ,
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
      console.error("Error saving general info:", error);
      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save general info: ' + error.message });
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
        // "https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/saveRiskAssessment",
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
      console.error("Error saving risk assessment:", error);
      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save risk assessment: ' + error.message });
    }
  };
 
// Form validation
 
    const validateForm = () => {
      if (activeIndex === 0) {
        // Validate General Info
        if (!formData.generalInfo.accountNumber || !formData.generalInfo.borrowerName  || !formData.generalInfo.branchName || !formData.generalInfo.panNumber|| !formData.generalInfo. cinNumber || !formData.generalInfo.schemeCode || !formData.generalInfo.activityCode || !formData.generalInfo.briefDtls|| !formData.generalInfo.description
          || !formData.generalInfo.projName|| !formData.generalInfo.sector|| !formData.generalInfo.locationType|| !formData.generalInfo.susobj || !formData.generalInfo.longitude || !formData.generalInfo.latitude|| !formData.generalInfo.stakeEng|| !formData.generalInfo.reportReq|| !formData.generalInfo.timeline|| !formData.generalInfo.budget || !formData.generalInfo.pincode|| !formData.generalInfo.eiacomments
          || !formData.generalInfo.legalVerificationComments  || !formData.generalInfo.financialHealthComments  || !formData.generalInfo.esgCompliance
         ) {
         
          toast.current.show({ severity: 'warn', summary: 'Validation', detail: 'Please fill in all required fields' });
          return false;
        }
      } else if (activeIndex === 1) {
        // Validate Risk Assessment
        if (!formData.riskAssessmentData?.vulnerability ||!formData.riskAssessmentData?. carbonintensive||!formData.riskAssessmentData?. sealevel ||!formData.riskAssessmentData?. assetrisk ||!formData.riskAssessmentData?.supplychain||!formData.riskAssessmentData?.  shifting||!formData.riskAssessmentData?.  borroweremission||!formData.riskAssessmentData?. business||!formData.riskAssessmentData?.climate ) {
          toast.current.show({ severity: 'warn', summary: 'Validation', detail: 'Please fill in all required fields for Risk Assessment' });
          return false;
        }
      }
      return true;
    };
 
    const handleValidation = (e, section, field) => {
      const { value } = e.target;
      const regex = /^-?\d+(\.\d{0,6})?$/; // Allows numbers with up to 6 decimal places
    
      if (!regex.test(value)) {
        toast.current.show({
                    severity: 'error',
                    summary: 'Validation Error',
                    detail: 'Only up to 6 decimal places are allowed.'
                });
                return;
            }
      // if (value === '' || regex.test(value)) {
           handleChange(e, section, field); // Update state only if valid

      // }
  };
 
//HANDLE CHANGE
  const handleChange = async (e, section, field) => {
    // console.log("handleChange triggered", e.target.value, section, field);
 
    const { value } = e.target;
 
    // Ensure the value is defined
    if (value !== undefined) {
      // console.log(`Updating ${section} for field: ${field} with value:`, value);
 
      if (section === 'riskAssessmentData') {
        // Updating riskAssessmentData field
        setFormData({
          ...formData,
          [section]: {
            ...formData[section],
            [field]: value, // Update the specific field
          },
        });
      } else if (section === 'generalInfo') {
        // Updating generalInfo field
        setFormData({
          ...formData,
          [section]: {
            ...formData[section],
            [field]: value, // Update the specific field
          },
        });
        console.log("Genenral info -> esgCompliance");
        // console.log(field);
        // console.log(value);
        if(field === 'susobj'){
          fetchIndicators(value);
        }
      } else if (section === 'sustainability' && field === 'susobj' && value) 
        {
          fetchIndicators(value);
        console.log('Entering sustainability section, field: susobj, with value:', value);
        // Update the selected sustainability object (susobj)
        setSelectedSUSObj(value); // Set the selected Susobj
        setIsLoading(true); // Set loading state to true
 
        try {
          // Fetch the indicators based on the selected Susobj
          const response = await fetch(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/pickdataSec/${value}`);
         
          console.log('API Response:', response);
 
          if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
          }
 
          const data = await response.json();
 
          console.log('Fetched Data:', data); // Log the fetched data for inspection
 
          // Check if the response contains the 'indicators' field
          if (data && data.indicators) {
            setIndicators(data.indicators); // Update the state with the fetched indicators
          } else {
            console.warn('No indicators found for the selected Susobj.');
            alert('No indicators found'); // Show alert if no indicators are found
            setIndicators([]); // Reset the indicators if no data is found
          }
        } catch (error) {
          console.error("Error fetching indicators:", error);
          alert('Error fetching indicators: ' + error.message); // Show error message if fetch fails
        } finally {
          setIsLoading(false); // Set loading state to false once the request is complete
        }
      }
    } else {
      console.warn('Value is undefined');
    }
 
  };
 
 
// Handle account number change and trigger API call
 
   const handleAccountNumberChange = async () => {
    const accountNumber = formData.generalInfo.accountNumber; // Get the value from state
    setAccN(formData.generalInfo.accountNumber);
    // Only call the API if the account number is provided
    if (accountNumber) {
 
      try {
 
        const response = await axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/pickdata/${accountNumber}`);
        console.log(response);
        if (response.status === 200) {
        //   throw new Error('Failed to fetch account details');
        // }
 
        const data =  response.data;
        // console.log("sus object selected :", data.susobj);

        if(data.susobj === ""){
          return;
        }else (
          fetchIndicators(data.susobj)
        );
       console.log(data);
        // Update state with the fetched account details
        setFormData(prevState => ({
          ...prevState,
          generalInfo: {
            ...prevState.generalInfo,
            borrowerName: data.borrowerName || '',
            branchName: data.branchName || '',
            panNumber: data.panNumber || '',
            cinNumber: data.cinNumber || '',
            schemeCode: data.schemeCode || '',
            activityCode: data.activityCode || '',
            briefDtls: data.briefDtls || '',
          
            projName: data.projName || '',
            sector: data.sector || '',
            locationType: data.locationType || '',
            othersAdd: data.othersAdd || '',
            description: data.description ||'',
            susobj:data.susobj || '',
            longitude:data.longitude || '',
            latitude:data.latitude || '',
            reportReq:data.reportReq || '',
            stakeEng:data.stakeEng || '',
            timeline:data.timeline || '',
            budget:data.budget || '',
            pincode:data.pincode || '',
            legalVerificationComments:data.legalVerificationComments || '',
            financialHealthComments:data.financialHealthComments || '',
            esgCompliance:data.esgCompliance || '',
            vulnerability:data.vulnerability || '',
            carbonintensive:data.carbonintensive || '',
            sealevel:data.sealevel || '',
            assetrisk:data.assetrisk || '',
            supplychain:data.supplychain || '',
            shifting:data.shifting || '',
            business:data.business || '',
            climate:data.climate || '',
            borroweremission:data.borroweremission || '',
            climate:data.climate || '',
            esgfileName:data.esgfileName || '',
            eiacomments:data.eiacomments || '',
            legalVerificationFileName:data.legalVerificationFileName || '',
            financialFileName:data.financialFileName || '',
            
          },
          riskAssessmentData:{
            ...prevState.riskAssessmentData,
            vulnerability:data.vulnerability ||'',
            carbonintensive:data.carbonintensive ||'',
            sealevel:data.sealevel ||'',
            assetrisk:data.assetrisk ||'',
            supplychain:data.supplychain ||'',
            shifting:data.shifting ||'',
            business:data.business ||'',
            climate:data.climate ||'',
            borroweremission:data.borroweremission ||''
          },
        }));
 
 
      } else {
      throw new Error('Failed to fetch account details');
    }
} catch (err) {
toast.current.show({ severity: 'error', summary: 'Error', detail: err.message });
}
} else {
toast.current.show({ severity: 'warn', summary: 'Validation', detail: 'Account Number is required.' });
}
};
 
 
// Handle file input change
 
  const handleFileChange1 = (e) => {
    const selectedFile = e.target.files[0]; // Get the selected file
    if (selectedFile) {
      setFile(selectedFile); // Set the selected file in the state
    }
  };
 
  const handleFileChange2 = (e) => {
    const selectedFile = e.target.files[0]; // Get the selected file
    if (selectedFile) {
      setFile(selectedFile); // Set the selected file in the state
    }
  };
  const handleFileChange3 = (e) => {
    const selectedFile = e.target.files[0]; // Get the selected file
    if (selectedFile) {
      setFile(selectedFile); // Set the selected file in the state
    }
  };
  const handleFileChange4 = (e) => {
    const selectedFile = e.target.files[0]; // Get the selected file
    if (selectedFile) {
      setFile(selectedFile); // Set the selected file in the state
    }
  };

 
  // Handle file upload
 
  const handleFileUpload1 = async () => {
    console.log('file ',file);
    if (!file) {
      alert('Please select a file to upload.');
      return;
    }
 
    const formData = new FormData();
    formData.append('EIAfile', file); // Append the file to FormData
    formData.append('fileName', fileName);
    // formData.append('accountNumber',formData.generalInfo.accountNumber );
    try {
      setIsLoading(true); // Set loading state
 
      // Send the file to the backend using axios
      const response = await axios.post(
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/uploadingEIA?AccountNumber=${AccN}`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/file",
          },
            
          }
        
      );
      console.log('response',response);
 
      // Check if the response indicates success
      if (response.status == 200) {
        alert('File uploaded successfully!'); // Alert for successful upload
      } else {
        alert('File upload failed. Please try again.'); // If upload failed
      }
 
      setIsLoading(false); // Reset loading state
 
    } catch (error) {
      console.error('Error uploading file:', error);
      alert('Error uploading file. Please try again.'); // Alert in case of error
      setIsLoading(false); // Reset loading state
    }
  };
// Handle file upload
 
  const handleFileUpload2 = async () => {
    console.log('file ',file);
    if (!file) {
      alert('Please select a file to upload.');
      return;
    }
 
    const formData = new FormData();
    formData.append('legalVerificationFile', file); // Append the file to FormData
    formData.append('fileName', fileName);
 
 
    try {
      setIsLoading(true); // Set loading state
 
      // Send the file to the backend using axios
      const response = await axios.post(
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/uploadingLegal?AccountNumber=${AccN}`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/file",
          },
            
          }
      );
      console.log('response',response);
      // Check if the response indicates success
      if (response.status == 200) {
        alert('File uploaded successfully!'); // Alert for successful upload
      } else {
        alert('File upload failed. Please try again.'); // If upload failed
      }
 
      setIsLoading(false); // Reset loading state
 
    } catch (error) {
      console.error('Error uploading file:', error);
      alert('Error uploading file. Please try again.'); // Alert in case of error
      setIsLoading(false); // Reset loading state
    }
  };
// Handle file upload
 
  const handleFileUpload3= async () => {
    if (!file) {
      alert('Please select a file to upload.');
      return;
    }
 
    const formData = new FormData();
    formData.append('financialHealthFile', file);
    formData.append('fileName', fileName); // Append the file to FormData
 
    try {
      setIsLoading(true); // Set loading state
 
      // Send the file to the backend using axios
      const response = await axios.post(
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/uploadingFinancial?AccountNumber=${AccN}`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/file",
          },
            
          }
      );
      console.log('response',response);
      // Check if the response indicates success
      if (response.status == 200) {
        alert('File uploaded successfully!'); // Alert for successful upload
      } else {
        alert('File upload failed. Please try again.'); // If upload failed
      }
 
      setIsLoading(false); // Reset loading state
 
    } catch (error) {
      console.error('Error uploading file:', error);
      alert('Error uploading file. Please try again.'); // Alert in case of error
      setIsLoading(false); // Reset loading state
    }
  };
// Handle file upload
 
  const handleFileUpload4 = async () => {
    if (!file) {
      alert('Please select a file to upload.');
      return;
    }
 
    const formData = new FormData();
    formData.append('ESGfile', file);
    formData.append('fileName', fileName); // Append the file to FormData
 
    try {
      setIsLoading(true); // Set loading state
 
      // Send the file to the backend using axios
      const response = await axios.post(
        `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/uploadingESG?AccountNumber=${AccN}`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/file",
          },
            
          }
      );
      console.log('response',response);
      // Check if the response indicates success
      if (response.status == 200) {
        alert('File uploaded successfully!'); // Alert for successful upload
      } else {
        alert('File upload failed. Please try again.'); // If upload failed
      }
 
      setIsLoading(false); // Reset loading state
 
    } catch (error) {
      console.error('Error uploading file:', error);
      alert('Error uploading file. Please try again.'); // Alert in case of error
      setIsLoading(false); // Reset loading state
    }
  };
 

  useEffect(() => {
    if (accountNumber) {
  axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/getComments/${accountNumber}`)
        .then(response => {
  console.log("✅ Received comments from API:", response.data);
          
          // ✅ Update indicators with fetched comments
          
  const updatedIndicators = indicators.map(indicator => ({
            ...indicator,
  [indicator.commentKey]: response.data[indicator.commentKey] || ""
          }));
   
          setIndicators(updatedIndicators);
        })
        .catch(error => {
          console.error("❌ Error fetching comments:", error);
        });
    }
  }, [accountNumber]);  // ✅ Only run when account number changes
  //ch



  
useEffect(() => {
  const fetchSUSObjs = async () => {
    

    const fetchedSUSObjs = [
      'Renewable Energy',
      'Energy Efficiency',
      'Green Buildings',
      'Climate Adaptation',
      'Clean Transportation',
      'Pollution Prevention and Control',
      'Sustainable Water and Waste Management',
      'Sustainable Management of Living Natural Resources',
      'Terrestrial and Aquatic Biodiversity',
    ];
    setSusobjs(fetchedSUSObjs);
    console.log(selectedSUSObj); // Setting static list of SUSObjs for testing
  };
  fetchSUSObjs();
 
}, []);
 

  


  const fetchIndicators = async (value) => {
    if (!value) {
        console.warn("⚠️ fetchIndicators called with an empty value.");
        return;
    }

    console.log(`Fetching indicators for: ${value}`);

    setIsLoading(true); // ✅ Show loading indicator

    try {
        const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/pickdataSusObj/${value}`);
       
        console.log("API Response:", response.data); // ✅ Debugging

        if (response.status === 200 && Array.isArray(response.data)) {
            setIndicators(response.data);
            console.log("Indicators updated successfully.");
        } else {
            setIndicators([]); // ✅ Prevents `.map()` error
            console.warn("API response is not an array. Resetting indicators.");
        }

    } catch (error) {
        console.error("❌ Error fetching indicators:", error);
        setIndicators([]); // ✅ Ensures app doesn’t break

        toast.current.show({
            severity: 'error',
            summary: 'Error',
            detail: 'Failed to fetch indicators. Please try again later.'
        });
    } finally {
        setIsLoading(false); // ✅ Hide loading indicator after fetch
    }
};                                                                                //CH2

        
          
  
 
 
 
 
const handleIndicatorChange = (e) => {
  const { field, newValue,  rowIndex } = e;  // Destructure the event object
 
  setFormData((prevFormData) => {
    const updatedIndicators = [...prevFormData.indicators]; // Create a copy of the indicators array
    updatedIndicators[rowIndex][field] = newValue; // Update the specific field at the correct row
   
    return {
      ...prevFormData,
      indicators: updatedIndicators, // Update the formData with the modified indicators array
    };
  });
};
 
 
// Handle SUSObj change
const handleSUSObjChange = (e) => {
  setSelectedSUSObj(e.target.value); // Update the selected SUSObj
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
    if (!validateForm()) return; // Ensure form is validated
 
    try {
 
      if (activeIndex === 0) {
        await saveGeneralInfo(formData.generalInfo.accountNumber);
      } else if (activeIndex === 1) {
        await saveRiskAssessment(formData.generalInfo.accountNumber );
      }
        alert("Data saved successfully!");
       nextStep(); // Move to the next step in the form or process
 
    } catch (error) {
      console.error("Error during form submission:", error);
      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save data: ' + error.message });
    }
  };
 
  //Handle input change for the "comment" field
  // const handleCommentChange = (e, rowIndex) => {
  //   const updatedIndicators = [...indicators];
  //   updatedIndicators[rowIndex].comment = e.target.value;
  //   setIndicators(updatedIndicators);
  // };

  // const handleCommentChange = (e,
  //   rowIndex, field) => {
  //     const updatedIndicators =
  //     [...indicators];
  //     updatedIndicators[rowIndex]
  //     [field] = e.target.value;
  //     setIndicators(updatedIndicators);
      
  //   };                                            


  // const handleCommentChange = (e,rowIndex,field) => {
  //   const{value} = e.target;
  //   const updatedIndicators = 
  //   [...indicators];
  //   updatedIndicators[rowIndex]={
  //     ...updatedIndicators[rowIndex],
  //     [field]:value
  //   };
  //   setIndicators(updatedIndicators);
  //   console.log(`Updated Comment for ${field}`, value);
  // };                                                      

  const handleCommentChange = (e,rowIndex,field) => {
    const{value} = e.target;
    if (!Array.isArray(indicators))
      return;
    const updatedIndicators = 
    [...indicators];
    updatedIndicators[rowIndex]={
      ...updatedIndicators[rowIndex],
      [field]:value
    };
    setIndicators(updatedIndicators);
    console.log(`Updated Comment for ${field}`, value);
  };                                                          //CH2

  



    

    const handleSubmit1 = async () => {
      const requestData = {
        accountNumber: accountNumber, // Ensure account number is included
      };
     
      // ✅ Map each indicator comment to the correct field
      indicators.forEach((indicator) => {
        if (indicator.commentKey) {
          requestData[indicator.commentKey] = indicator[indicator.commentKey] || "";
        }
      });
     
      console.log("📌 Final Request Sent to API:", JSON.stringify(requestData, null, 2)); // Debugging
     
      try {
        const response = await axios.post(
          `https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/updatedCmnt3/${formData.generalInfo?.accountNumber}`,
          requestData,
          { headers: { "Content-Type": "application/json" } }
        );
     
        console.log("✅ Backend Response:", response.data);
        toast.current.show({
          severity: 'success',
          summary: 'Success',
          detail: 'Comments saved successfully!'
        });
     
      } catch (error) {
        console.error("❌ Error saving data:", error.response?.data || error.message);
        toast.current.show({
          severity: 'error',
          summary: 'Error',
          detail: `Failed to save comments: ${error.response?.data?.message || error.message}`
        });
      }
    };                                                                           //ch
                                                                        



 
// Reset form data
  const resetForm = () => {
    setFormData({
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
        eiacomments: '',
        eiaFile: null,
        legalVerificationComments: '',
        legalVerificationFile:null,
        financialHealthComments: '',
        financialHealthFile:null,
        esgCompliance: '',
        esgFile:null,
      },
      RiskAssesment:
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
          borrowermissionFlag: '',
        },
     
      indicators: [
        { indicator: '',
          description: '',
          comment: '',
          type: '',
          methodology: ''
        },
      ],
    });
  };
 
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
 
 
 
 
    return (
        <div className="container1">
             {/* <h1 className="title2">BoB Green Finance Portal</h1> */}
              {/* <div className="line-container1">
                <div className="line1">
                </div>
              </div>  */}
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
          <h2>General Information</h2>
          <div className="container2">
          <div className="form-group1">
        <label htmlFor="accountNumber">
          ACCOUNT NUMBER <span className="required-star">*</span> :
        </label>
        <input
          id="accountNumber"
          type="text"
          value={formData.generalInfo.accountNumber || ""} // Ensure it is controlled
          onChange={(e) => handleChange(e, 'generalInfo', 'accountNumber')}
        />
      </div>
 
 
        <Button icon="pi pi-arrow-right" className="NextC" label='Fetch'
        onClick={handleAccountNumberChange}
      />
            {/* {isLoading && <p>Loading...</p>} */}
            {error && <p style={{ color: 'red' }}>{error}</p>}
          </div>
 
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
                    value={formData.generalInfo.borrowerName}
                    onChange={(e) => handleChange(e, 'generalInfo', 'borrowerName')}
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="branchName">Branch<span className="required-star">*</span> :</label>
                  <input
                    id="branchName"
                    type="text"
                    value={formData.generalInfo.branchName}
                    onChange={(e) => handleChange(e, 'generalInfo', 'branchName')}
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="panNumber">PAN Number<span className="required-star">*</span> :</label>
                  <input
                    id="panNumber"
                    type="text"
                    value={formData.generalInfo.panNumber}
                    onChange={(e) => handleChange(e, 'generalInfo', 'panNumber')}
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="cinNumber">CIN<span className="required-star">*</span> :</label>
                  <input
                    id="cinNumber"
                    type="text"
                    value={formData.generalInfo.cinNumber}
                    onChange={(e) => handleChange(e, 'generalInfo', 'cinNumber')}
                  />
                </div>
              </div>
 
              <div className="vertical2">
                <div className="form-group2">
                  <label htmlFor="schemeCode">Scheme Code<span className="required-star">*</span> :</label>
                  <input
                    id="schemeCode"
                    type="text"
                    value={formData.generalInfo.schemeCode}
                    onChange={(e) => handleChange(e, 'generalInfo', 'schemeCode')}
                  />
                </div>
                <div className="form-group2">
                  <label htmlFor="activityCode">Activity Code<span className="required-star">*</span> :</label>
                  <input
                    id="activityCode"
                    type="text"
                    value={formData.generalInfo.activityCode}
                    onChange={(e) => handleChange(e, 'generalInfo', 'activityCode')}
                  />
                </div>
                <div className="form-group2">
  <label htmlFor="briefDtls">
    Brief Details of the Project
    <span className="required-star">*</span> :
  </label>
  <input
    id="briefDtls"
    value={formData.generalInfo.briefDtls}
    onChange={(e) => handleChange(e, 'generalInfo', 'briefDtls')}
  />
</div>
 
 
                <div className="form-group2">
                  <label htmlFor="projName">Name of the Project<span className="required-star">*</span> :</label>
                  <input
                  id="projName"
                  type="text"
                  value={formData.generalInfo.projName}
                  onChange={(e) => handleChange(e, 'generalInfo', 'projName')}
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
                    value={formData.generalInfo.sector}
              onChange={(e) => handleChange(e, 'generalInfo', 'sector')}
            />
                </div>
               
                <div className="form-group2">
<label htmlFor="locationType">Location<span className="required-star">*</span> :</label>
<select
    id="locationType"
    value={formData.generalInfo.locationType}
    onChange={(e) => handleChange(e, 'generalInfo', 'locationType')}
>
<option value="">Select Location</option>
<option value="same">Location same as Borrower address</option>
<option value="other">Other</option>
</select>

 {formData.generalInfo.locationType === 'same' && ( 


<input
      type="text"
      value={formData.generalInfo.othersAdd}
      onChange={(e) => handleChange(e, 'generalInfo', 'othersAdd')}
      placeholder="Enter address"
    />
   )}
   {formData.generalInfo.locationType === 'other' && (

<input
      type="text"
      value={formData.generalInfo.othersAdd}
      onChange={(e) => handleChange(e, 'generalInfo', 'othersAdd')}
      placeholder="Enter address"
    />
  )} 

</div>
                
                <div className="form-group2">
                    <label htmlFor="description">Project Description<span className="required-star">*</span> :</label>
                    <input
                    id="description"
                    type="text"
                    value={formData.generalInfo.description}
                    // onChange={(e) => setProjName(e.target.value)}
                    onChange={(e) => handleChange(e, 'generalInfo', 'description')}
            />
                </div>
 
                <div className="form-group2">
  <label htmlFor="susobj">Sustainability Objectives<span className="required-star">*</span> :</label>
  <select
    id="susobj"
    value={formData.generalInfo.susobj}
    onChange={(e) => handleChange(e, 'generalInfo', 'susobj')}
  >
    <option value="">Select a Type</option>
    {susobjs.map((type, index) => (
      <option key={index} value={type}>
        {type}
      </option>
    ))}
  </select>
</div>
<div className="form-group2">
                    <label htmlFor="longitude">Longitude<span className="required-star">*</span> :</label>
                    <input
                    id="longitude"
                    type="number"
                    value={formData.generalInfo.longitude}
                    // onChange={(e) => setProjName(e.target.value)}
                    onChange={(e) => handleValidation(e, 'generalInfo', 'longitude')}
                    
                />
                </div>
                <div className="form-group2">
                    <label htmlFor="latitude">Latitude<span className="required-star">*</span> :</label>
                    <input
                    id="latitude"
                    type="number"
                    value={formData.generalInfo.latitude}
                    // onChange={(e) => setProjName(e.target.value)}
                    onChange={(e) => handleValidation(e, 'generalInfo', 'latitude')}
                />


                
                </div> 
               
              </div>
           
 
            <div className='vertical2'>
                <div className="form-group2">
                    <label htmlFor="stakeEng">Stake Holder Engagement<span className="required-star">*</span> :</label>
                    <input
                    id="stakeEng"
                    type="text"
                    value={formData.generalInfo.stakeEng}
                    onChange={(e) => handleChange(e, 'generalInfo', 'stakeEng')}
                    />
                </div>
 
                <div className="form-group2">
                    <label htmlFor="reportReq">Reporting Requirements<span className="required-star">*</span> :</label>
                    <input
                    id="reportReq"
                    type="text"
                    value={formData.generalInfo.reportReq}
                    onChange={(e) => handleChange(e, 'generalInfo', 'reportReq')}
            />
                </div>
 
                <div className="form-group2">
                    <label htmlFor="timeline">Timeline<span className="required-star">*</span> :</label>
                    <input
                    id="timeline"
                    type="text"
                    value={formData.generalInfo.timeline}
                    onChange={(e) => handleChange(e, 'generalInfo', 'timeline')}
                    />
                </div>
 
                <div className="form-group2">
                    <label htmlFor="budget">Budget<span className="required-star">*</span> :</label>
                    <input
                    id="budget"
                    type="text"
                    value={formData.generalInfo.budget}
                    onChange={(e) => handleChange(e, 'generalInfo', 'budget')}
            />
                </div>

 <div className="form-group2">
                    <label htmlFor="pincode">Pincode<span className="required-star">*</span> :</label>
                    <input
                    id="pincode"
                    type="number"
                    value={formData.generalInfo.pincode}
                    onChange={(e) => handleChange(e, 'generalInfo', 'pincode')}
            />
                </div>
            </div>
 
        </div>
 </div>
 
 
<div className="business-div">
                <h2 className="business-title">Project Evaluation Criteria (To be filled by the Bank)</h2>
                <div className="vertical">
                    <div className="vertical1">
                        <div className="form-group2">
                            <label htmlFor="EIAcomments">EIA Comments<span className="required-star">*</span> :</label>
                            <textarea
                                id="eiacomments"
                                value={formData.generalInfo.eiacomments}
              onChange={(e) => handleChange(e, 'generalInfo', 'eiacomments')}
            />
 
                        </div>
                        <div className="form-group2">
      <label htmlFor="eiaFile">EIA Upload File<span className="required-star">*</span> :</label>
     
      {/* File input field */}
      <input
        id="eiaFile"
        type="file"
        onChange={handleFileChange1} // Handle file selection
        className="file-input"
      />
        {/* Upload Button */}
        <button type="button"   className="upload-button" onClick={handleFileUpload1}>
          Upload 
        </button>
      </div>
 
 
                        <div className="form-group2">
                            <label htmlFor="legalVerificationComments">Legal Verification Comments<span className="required-star">*</span> :</label>
                            <textarea
                                id="legalVerificationComments"
                                value={formData.generalInfo.legalVerificationComments}
                                onChange={(e) => handleChange(e, 'generalInfo', 'legalVerificationComments')}
                                />
                        </div>
                        <div className="form-group2">
                            <label htmlFor="legalVerificationFile">Legal Verification Upload File<span className="required-star">*</span> :</label>
                            <input
        id="legalVerificationFile"
        type="file"
        onChange={handleFileChange2} // Handle file selection
        className="file-input"
      />
        {/* Upload Button */}
        <button type="button" className="upload-button"  onClick={handleFileUpload2}>
          Upload
        </button>
 
                        </div>
                    </div>
 
                    <div className="vertical2">
                        <div className="form-group2">
                            <label htmlFor="financialHealthComments">Financial Health Comments<span className="required-star">*</span> :</label>
                            <textarea
                                id="financialHealthComments"
                                value={formData.generalInfo.financialHealthComments}
                              //  onChange={(e) => FinancialHealthComments(e.target.value)}
                                onChange={(e) => handleChange(e, 'generalInfo', 'financialHealthComments')}
                                />
                        </div>
                        <div className="form-group2">
                            <label htmlFor="financialHealthFile">Financial Health Upload File<span className="required-star">*</span> :</label>
 
 
                            <input
        id="financialHealthFile"
        type="file"
        onChange={handleFileChange3} // Handle file selection
        className="file-input"
      />
        {/* Upload Button */}
        <button type="button" className="upload-button" onClick={handleFileUpload3}>
          Upload 
        </button>
 
                        </div>
 
                        <div className="form-group2">
                            <label htmlFor="esgCompliance">ESG Compliance Comments<span className="required-star">*</span> :</label>
                            <textarea
                                id="esgCompliance"
                                value={formData.generalInfo.esgCompliance}
                                onChange={(e) => handleChange(e, 'generalInfo', 'esgCompliance')}
                              />
                        </div>
                        <div className="form-group2">
                            <label htmlFor="ESGFile">ESG Upload File<span className="required-star">*</span> :</label>
                            <input
        id="ESGFile"
        type="file"
        onChange={handleFileChange4} // Handle file selection
        className="file-input"
      />
        {/* Upload Button */}
        <button type="button"  className="upload-button"  onClick={handleFileUpload4}>
          Upload 
        </button>
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
             value={formData.riskAssessmentData.vulnerability || ''}
             onChange={(e) => handleChange(e, 'riskAssessmentData', 'vulnerability',0)}
              
           />
          </div>
 
          <div className="form-group">
            <label>Sea-Level Rise (Coastal Properties Only)<span className="required-star">*</span> :</label>
            <textarea
             value={formData.riskAssessmentData?.sealevel || ''}
             onChange={(e) => handleChange(e, 'riskAssessmentData', 'sealevel',0)}
           />
 
          </div>
          <div className="form-group">
            <label>Supply Chain Disruptions<span className="required-star">*</span> :</label>
            <textarea
             type="text"
             value={formData.riskAssessmentData?.supplychain || ''}
             onChange={(e) => handleChange(e, 'riskAssessmentData', 'supplychain',0)}
           />
          </div>
          </div>
          <div className="risk-section">
          <h3 className="risk-category">Transition Risk</h3>
 
          <div className="form-group">
          <label>Carbon-Intensive Sector<span className="required-star">*</span> :</label>
<textarea
    type="text"
    value={formData.riskAssessmentData?.carbonintensive || ''}
    onChange={(e) => handleChange(e, 'riskAssessmentData', 'carbonintensive', 0)}
/>
 
 
          </div>
 
          <div className="form-group">
    <label>Stranded Assets Risk<span className="required-star">*</span> :</label>
    <textarea
        type="text"
        value={formData.riskAssessmentData?.assetrisk || ''}
        onChange={(e) => handleChange(e, 'riskAssessmentData', 'assetrisk', 0)}
    />
</div>
<div className="form-group">
<label>Shifting Consumer Preferences<span className="required-star">*</span> :</label>
<textarea
  name="shiftingConsumerPreferences"  // Add a name attribute
  value={formData.riskAssessmentData?.shifting || ''}
  onChange={(e) => handleChange(e, 'riskAssessmentData', 'shifting', 0)}
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
        value={formData.riskAssessmentData?.business || ''}
        onChange={(e) => handleChange(e, 'riskAssessmentData', 'business', 0)}
      />
    </div>
 
    <div className="form-group">
      <label>Climate Resilience Infrastructure<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={formData.riskAssessmentData?.climate || ''}
        onChange={(e) => handleChange(e, 'riskAssessmentData', 'climate', 0)}
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
        value={formData.riskAssessmentData?.borroweremission || ''}
        onChange={(e) => handleChange(e, 'riskAssessmentData', 'borroweremission', 0)}
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
        value={Array.isArray(indicators)? indicators : []}                          //CH2 
        
        responsiveLayout="scroll"
        editMode="cell" // Enable cell editing
        onCellEditCommit={handleIndicatorChange} // Triggered when a cell is edited
      >
         {/* Mandatory Indicator - non-editable  */}
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
       
        {/* Comment - editable */}
        
       
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
 
          
 
          // Split by new lines and process each point
          const formattedMethodology = rowData.methodology
          .split(/\r?\n/) 
          .map((point) => point.trim()) // Trim spaces
          .map((point) => point.replace(/^-\s*/, "")) 
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
  body={(rowData,options) => {
    
    const commentKey=rowData?.commentKey?? "";                    //CH2
    



    return(
      <textarea
      type="text"
      
      value={rowData?.[commentKey] ?? ""}                         //CH2
      
      onChange={(e) =>{
        if (indicators && Array.isArray(indicators)){
          handleCommentChange(e,options.rowIndex,commentKey);
          }
      }}                                                            //CH2
     
      className="datatable-input"
      style={{
        width: '100%', // Make the input field take full column width
        height: '40px', // Increase input box height
        fontSize: '16px', // Increase text size
        padding: '8px'
          }}
        />
        );
      }}
      />                                                             
      {/* /ch */}

    
      </DataTable>  
      
    </div>
  </div>
  </div>
)}
 
 
 
    {userRole === "Checker" && (
      <div className="checker-section">
        <h2 className="decision-title">Decision:</h2>
        <div className="radio-group">
          <label className={`radio-label ${approvalStatus === "approve" ? "selected-approve" : ""}`}>
            <input
              type="radio"
              name="decision"
              value="approve"
              checked={approvalStatus === "approve"}
              onChange={() => handleApprovalStatus("approve")}
            />
            Approve
          </label>
          <label className={`radio-label ${approvalStatus === "reject" ? "selected-reject" : ""}`}>
            <input
              type="radio"
              name="decision"
              value="reject"
              checked={approvalStatus === "reject"}
              onChange={() => handleApprovalStatus("reject")}
            />
            Reject
          </label>
        </div>
 
        {approvalStatus === "reject" && (
          <div className="remarks-section">
            <label htmlFor="remarks">Reason for Rejection:</label>
            <textarea
              id="remarks"
              value={remarks}
              onChange={(e) => setRemarks(e.target.value)}
              className="remarks-input"
              placeholder="Enter rejection reason"
            />
          </div>
        )}
 
        {userRole === "Maker" && (
          <div className="button-container2">
            {/* <Button label="Submit" onClick={() => alert("Submitted to Checker")} className="submit-button2" /> */}
          </div>
        )}
 
       
      </div>
    )}
 
    <div className='button-container2'>
      {/* <Button label="Save & Next" className="saveNext" onClick={handleSave} /> */}
    </div>
 
 
 
 
    <Toast ref={toast} />
    <div className="button-container2">
    {/* <Button label="Previous" icon="pi pi-arrow-left" onClick={prevStep} disabled={activeIndex === 0} />  */}
      <Button label="Previous" icon="pi pi-arrow-left" className="saveNext" onClick={prevStep} disabled={activeIndex === 0} />
    {/* Add Back Button next to Previous */}
    {activeIndex < steps.length - 1 ? (
    <>
      {/* <Button label="Next" icon="pi pi-arrow-right" onClick={nextStep} /> */}
      <Button label="Save & Next" icon="pi pi-arrow-right" className="saveNext" onClick={handleSubmit} />
      {/* <Button label="Back" className="backButton" onClick={handleBack} /> */}
    </>
  ) : (
    <Button label="Submit" icon="pi pi-check"  className="saveNext" onClick={handleSubmit1} />
  )}
</div>
 
 
  </div>
  );
};
 
export default Maker;
 