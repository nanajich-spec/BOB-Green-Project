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
import './Checker1.css';
import { useParams } from "react-router-dom";
import {  useLocation } from "react-router-dom";
import PDFDocument from './PDFDocument.js';
import { Link } from 'react-router-dom';

const Admin2 = () => {
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
        description: false,
        projName: false,
        sector: false,
        location: false,
        susobj: false,
        stakeEng: false,
        reportReq: false,
        timeline: false,
        budget: false,
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
  const [susobj, setSusobjs] = useState([]);
  const [isLoading, setIsLoading ] = useState([false]);
  const [userRole, setUserRole] = useState('');
  const [approvalStatus] = useState(null); // Define approvalStatus as state if needed
  const [file, setFile] = useState(null); // State to store the selected file
  const [remarks, setRemarks] = useState('');
  const [fileName,setFileName]=useState('');
  const [AccN, setAccN ] = useState ('');
  const [returnComment, setReturnComment] = useState('');
  const [isReturned, setIsReturned] = useState(false);
  const [accountDetails, setAccountDetails] = useState(null);
  const [eiaFile, setEiaFile] = useState({ name: "No valid file available", data: null });
  const [legalVerificationFile, setLegalVerificationFile] = useState({ name: "No valid file available", data: null });
  const [financialHealthFile, setFinancialHealthFile] = useState({ name: "No valid file available", data: null });
  const [esgFile, setEsgFile] = useState({ name: "No valid file available", data: null });
  const [selectedOption,setSelectedOption] = useState("");   //ch
  const [comment, setComment] = useState("");      
  const [accountNumber, setaccountNumber] = useState({});
  const [SustainObj,setSustainObj]= useState({});              //ch
  
  //const [loading, setLoading] = useState(true);



  const handleSelectChange = (field,
    value) => {
        setSelectedOption((prev) =>
        ({...prev, [field]: value}));
    };                                                        //ch
  const handleCommentChange = (field,
    value) => {
      setComment((prev) =>({...prev,
        [field]: value}));
    };                                                         //ch
    
    // const handleDownloadPDF = () => {
    //   const input =
    //     document.getElementById("account-details-section");

    //   if(!input) {
    //       console.error("Element not found!");
    //       return;
    //   }

    //   html2canvas(input,{scale:2}).then((canvas) => {
    //     const imgData = canvas.toDataURL("image/png");
    //     const pdf = new jsPDF("p","mm","a4");
    //     const imgWidth= 190;
    //     const imgHeight=(canvas.height*imgWidth)/canvas.width;
    //     pdf.addImage(imgData, "PNG",10,10,imgWidth, imgHeight);
    //     pdf.save("Account_Details.pdf");
    //   });
    // };                                                            //ch

  
const toggleEdit = (field) => {

    setEditableFields((prevState) => ({

      ...prevState,

      [field]: !prevState[field],

    }));

  };

  
  

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
      //  alert("Data saved successfully!");
       nextStep(); // Move to the next step in the form or process

    } catch (error) {
      console.error("Error during form submission:", error);
      toast.current.show({ severity: 'error', summary: 'Error', detail: 'Failed to save data: ' + error.message });
    }
  };
  // Function to send updated data to backend
  const handleSubmit1 = () => {
  axios.post(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/updatedCmnt${accountNumber}`)
  .then((response)=>{
        console.log("Data saved successfully:", response.data);
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
      {/* <div className="step-wrapper">
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
      </div> */}
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
                  
                </div>
                <div className="form-group2">
                  <label htmlFor="branchName">Branch<span className="required-star">*</span> :</label>
                  <input
                    id="branchName"
                    type="text"
                    value={accountDetails?.branchName || "" }
                    readOnly={!editableFields.branchName}
                  />
                              

                </div>
                <div className="form-group2">
                  <label htmlFor="panNumber">PAN Number<span className="required-star">*</span> :</label>
                  <input
                    id="panNumber"
                    type="text"

                    value={accountDetails?.panNumber || "" }
                    readOnly={!editableFields.panNumber }
                  />
                  

                </div>
                <div className="form-group2">
                  <label htmlFor="cinNumber">CIN<span className="required-star">*</span> :</label>
                  <input
                    id="cinNumber"
                    type="text"
                    value={accountDetails?.cinNumber || "" }
                    readOnly={!editableFields.cinNumber }

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
                    readOnly={!editableFields.schemeCode}
                  />
                  
                </div>
                <div className="form-group2">
                  <label htmlFor="activityCode">Activity Code<span className="required-star">*</span> :</label>
                  <input
                    id="activityCode"
                    type="text"
                    value={accountDetails?.activityCode || "" }
                    readOnly={!editableFields.activityCode}
                  />
                  
                </div>
                <div className="form-group2">
  <label htmlFor="description">
    Brief Details of the Project
    <span className="required-star">*</span> :
  </label>
  <textarea
    id="description"
    value={accountDetails?.description || "" }
    readOnly={!editableFields.description }

  />
   
</div>
                <div className="form-group2">
                  <label htmlFor="projName">Name of the Project<span className="required-star">*</span> :</label>
                  <input
                  id="projName"
                  type="text"
                  value={accountDetails?.projName || "" }
                  readOnly={!editableFields.projName}

            />
 
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
                <div className="form-group2">
                    <label htmlFor="sector">Sector<span className="required-star">*</span> :</label>
                    <input
                    id="sector"
                    type="text"
                    value={accountDetails?.sector|| "" }
                    readOnly={!editableFields.sector}
                    />
                    
                    
                </div>


                <div className="form-group2">
                    <label htmlFor="location">Location<span className="required-star">*</span> :</label>
                    <input
                    id="location"
                    type="text"
                    value={accountDetails?.location|| "" }
                    readOnly={!editableFields.location}

                  />
                  
                </div>

                <div className="form-group2">
                    <label htmlFor="projName">Project Description<span className="required-star">*</span> :</label>
                    <textarea
                    id="description"
                    type="text"
                    value={accountDetails?.description|| "" }
                    readOnly={!editableFields.description}

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
            </div>
            <div className='vertical2'>
                <div className="form-group2">
                    <label htmlFor="stakeEng">Stake Holder Engagement<span className="required-star">*</span> :</label>
                    <input
                    id="stakeEng"
                    type="text"
                    value={accountDetails?.stakeEng|| "" }
                    readOnly={!editableFields.stakeEng}

                    />
                    

                </div>
                <div className="form-group2">
                    <label htmlFor="reportReq">Reporting Requirements<span className="required-star">*</span> :</label>
                    <input
                    id="reportReq"
                    type="text"
                    value={accountDetails?.reportReq|| "" }
                    readOnly={!editableFields.reportReq}

                />
                
                </div>
                <div className="form-group2">
                    <label htmlFor="timeline">Timeline<span className="required-star">*</span> :</label>
                    <input
                    id="timeline"
                    type="text"
                    value={accountDetails?.timeline|| "" }
                    readOnly={!editableFields.timeline}

                    />
                    
                </div>
                <div className="form-group2">
                    <label htmlFor="budget">Budget<span className="required-star">*</span> :</label>
                    <input
                    id="budget"
                    type="text"
                    value={accountDetails?.budget|| "" }
                    readOnly={!editableFields.budget}

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
                    readOnly={!editableFields.eiacomments}

                  
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
                    readOnly={!editableFields.legalVerificationComments}
                />
                
            </div>
            <div className="form-group2">
                <label htmlFor="legalVerificationFile"> Legal Verification Uploaded File:</label>
                <div className="file-input-container">

<label>{legalVerificationFile.name}</label>

  <button
      className="download-btn"
      onClick={() => downloadFile(legalVerificationFile)}
      disabled={!legalVerificationFile.data}
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
                    readOnly={!editableFields.financialHealthComments}

                
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
                    readOnly={!editableFields.esgCompliance}
                   
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

     </div>
     
  )}
             {activeIndex === 0 && (
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
                
          </div>
          <div className="form-group">
            <label htmlFor='searise'>Sea-Level Rise (Coastal Properties Only)<span className="required-star">*</span> :</label>
            <textarea
             value={accountDetails?.sealevel || ""}
             readOnly={!editableFields.sealevel}

           />
           
          </div>
          <div className="form-group">
            <label htmlFor='supplydisrup'>Supply Chain Disruptions<span className="required-star">*</span> :</label>
            <textarea
             type="text"
             value={accountDetails?.supplychain || ""}
             readOnly={!editableFields.supplychain }

           />
           
          </div>
          </div>
          <div className="risk-section">
          <h3 className="risk-category">Transition Risk</h3>
          <div className="form-group">
          <label htmlFor='carbonsector'>Carbon-Intensive Sector<span className="required-star">*</span> :</label>
<textarea
    type="text"
    value={accountDetails?.carbonintensive|| ""}
    readOnly={!editableFields.carbonintensive}

/>


          </div>

          <div className="form-group">
    <label htmlFor='strandedrisk'>Stranded Assets Risk<span className="required-star">*</span> :</label>
    <textarea
        type="text"
        value={accountDetails?.assetrisk|| ""}
        readOnly={!editableFields.assetrisk}

      
    />
    
</div>
<div className="form-group">
<label htmlFor='shifconsumer'>ShiftingConsumerPreferences<span className="required-star">*</span> :</label>
<textarea
  name="shiftingConsumerPreferences"  // Add a name attribute
  value={accountDetails?.shifting|| ""}
  readOnly={!editableFields.shifting}

/>

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
        value={accountDetails?.business|| ""}
        readOnly={!editableFields.business}

      />
      
    </div>

    <div className="form-group">
      <label htmlFor='climateinfra'>Climate Resilience Infrastructure<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails?.climate|| ""}
        readOnly={!editableFields.climate}

      />
      
    </div>
  </div>

  {/* Emission Data Section */}
  <div className="risk-section">
    <h3 className="risk-category">Emission Data</h3>

    <div className="form-group">
      <label htmlFor='borrowerfootprint'>Borrower’s Emission Footprint<span className="required-star">*</span> :</label>
      <textarea
        type="text"
        value={accountDetails?.borroweremission|| ""}
        readOnly={!editableFields.borroweremission}

      />
      
    </div>
  </div>
</div>
</div>
     )}
{activeIndex === 0 && ( 
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

    
     

    console.log("Raw Methodology Data:", rowData.methodology); // Debugging

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
    <div className="button-container2">
    <Link to={`/pdfdownload/${accountNumber}`}>
        <button>Download Report as PDF</button>
     </Link>
    </div>
  </div>
  );
};




export default Admin2;