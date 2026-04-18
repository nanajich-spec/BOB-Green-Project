//import React from "react";
import { Page, Text, View, Document, StyleSheet } from "@react-pdf/renderer";
import { PDFDownloadLink } from "@react-pdf/renderer";
import axios from 'axios';
import React, {useEffect,useState} from "react";
import { useParams } from "react-router-dom";



// Define PDF styles
const styles = StyleSheet.create({
  page: { padding: 20 },
  section: { marginBottom: 10 },
  title: { fontSize: 18, fontWeight: "bold", marginBottom: 5 },
  text: { fontSize: 12 },

});

const commentsData = [
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
    { indicator: "Annual Pollution Level", commentKey: "annLevelCmnt" }];



// PDF Document Component
const PDFDocumentUser = ({ accountDetails }) => (
  <Document>
    <Page size="A4" style={styles.page}>
      {/* Title */}
      <Text style={styles.title}>Account Details for {accountDetails?.borrowerName}</Text>

      {/* General Information (Bank) */}
      <View style={styles.section}>
        <Text style={styles.title}>General Information (Bank)</Text>
        <Text style={styles.text}>Account Number: {accountDetails?.accountNumber}</Text>
        <Text style={styles.text}>Branch: {accountDetails?.branchName}</Text>
        <Text style={styles.text}>Name of the Borrower: {accountDetails?.borrowerName}</Text>
        <Text style={styles.text}>PAN Number: {accountDetails?.panNumber}</Text>
        <Text style={styles.text}>CIN Number: {accountDetails?.cinNumber}</Text>
        <Text style={styles.text}>Scheme Code: {accountDetails?.schemeCode}</Text>
        <Text style={styles.text}>Activity Code: {accountDetails?.activityCode}</Text>
        {/* <Text style={styles.text}>Brief Details of the Project: {accountDetails?.status}</Text> */}

      </View>

      {/* General Information (Borrower) */}
      <View style={styles.section}>
        <Text style={styles.title}>General Information (Borrower)</Text>
        <Text style={styles.text}>Sector: {accountDetails?.sector}</Text>
        <Text style={styles.text}>Location: {accountDetails?.location}</Text>
        <Text style={styles.text}>Project Description: {accountDetails?.projectDescription}</Text>
        <Text style={styles.text}>Sustainability Objectives: {accountDetails?.sustainabilityObjectives}</Text>
        <Text style={styles.text}>Stake Holder Engagement: {accountDetails?.stakeEng}</Text>
        <Text style={styles.text}>Reporting Requirements: {accountDetails?.reportReq}</Text>
        <Text style={styles.text}>Timeline: {accountDetails?.timeline}</Text>
        <Text style={styles.text}>Budget: {accountDetails?.budget}</Text>
      </View>

      

      {/* Project Evaluation */}
      <View style={styles.section}>

        <Text style={styles.title}>Project Evaluation</Text>
        <Text style={styles.text}>EIA Comments: {accountDetails?.eiacomments}</Text>
        <Text style={styles.text}>EIA Filename: {accountDetails?.eiafileName}</Text>

        <Text style={styles.text}>Legal Verification Comments: {accountDetails?.legalVerificationComments}</Text>
        <Text style={styles.text}>Legal Verification Filename: {accountDetails?.legalVerificationFileName}</Text>


      {/* Financial Health */}
        <Text style={styles.text}>Financial Health Comments: {accountDetails?.financialHealthComments}</Text>
        <Text style={styles.text}>Financial Health Filename:{accountDetails?.financialFileName}</Text>


      {/* ESG Compliance */}
      
        
        <Text style={styles.text}>ESG Compliance Comments: {accountDetails?.esgCompComment}</Text>
        <Text style={styles.text}>ESG Compliance Filename: {accountDetails?.esgfileName}</Text>

      </View>

      {/* Risk Assessment */}
      <View style={styles.section}>
        <Text style={styles.title}>Risk Assessment</Text>

        <Text style={styles.title}>Physical Risk:</Text>
        <Text style={styles.text}>Location Vulnerability: {accountDetails?.vulnerability}</Text>
        <Text style={styles.text}>Sea-Level Rise (Coastal Properties Only): {accountDetails?.sealevel}</Text>
        <Text style={styles.text}>Supply Chain Disruptions: {accountDetails?.supplychain}</Text>

        <Text style={styles.title}>Transition Risk: </Text>
        <Text style={styles.text}>Carbon-Intensive Sector: {accountDetails?.carbonintensive}</Text>
        <Text style={styles.text}>Stranded Assets Risk: {accountDetails?.assetrisk}</Text>
        <Text style={styles.text}>Shifting Consumer Preferences: {accountDetails?.shifting}</Text>

        <Text style={styles.title}>Operational Vulnerabilities: </Text>
        <Text style={styles.text}>Business Continuity Plans: {accountDetails?.business}</Text>
        <Text style={styles.text}>Climate Resilience Infrastructure: {accountDetails?.climate}</Text>

        <Text style={styles.title}>Emission Data: </Text>
        <Text style={styles.text}>Borrower’s Emission Footprint: {accountDetails?.borroweremission}</Text>

      </View>

      {/* Project Specific Indicators */}
      <View style={styles.section}>
        <Text style={styles.title}>Project Specific Indicators</Text>
        <Text style={styles.title}>Sector: </Text>
        <Text style={styles.title}>Mandatory Indicator: </Text>
        <Text style={styles.title}>Description: </Text>
        <Text style={styles.title}>Type: </Text>
        <Text style={styles.title}>Methodology: </Text>
        <Text style={styles.title}>Comment: </Text>
        {/* Loop through commentsData and display only mapped comments */}
        {commentsData.map((comment, index) => {
        const commentValue = accountDetails?.[comment.commentKey];
        return (
          commentValue && ( 
        <Text key={index} style={styles.text}>
              {comment.label}: {commentValue}
        </Text>
          )
        );
      })}



      </View>

      

    </Page>
  </Document>

);

const PDFDocument = () => {
  //const { formId } = useParams();
  const [accountDetails, setAccountDetails] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const {accountNumber}=useParams();
  const [indicators, setIndicators] = useState({});
  // const {susobj}= useParams();
    useEffect(() => {
    const fetchAccountNumber = async () => {
      try {
        const response = await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/download/${accountNumber}`);
       setAccountDetails(response.data);
       
       //sustain object
       const response1 =await axios.get(`https://noncbsuat.bankofbaroda.co.in/green-project/api/v1/pickdataSusObj/${response.data.susobj}`);
        console.log("Received Account Details:", response1.data);  

      setIndicators(response1.data);
        setLoading(false);
      } catch (err) {
        setError(err.message || 'Error fetching form data');
        setLoading(false);
      }
    };
 
    fetchAccountNumber();
  }, [accountNumber]);
 
  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
 
  return (
    <div>
      <h2 className="backButton">Download Report as PDF</h2>
 
      {/* Render the PDF download link */}
      <PDFDownloadLink document={<PDFDocumentUser accountDetails={accountDetails} />} fileName="full_report.pdf">
        {({ loading }) => (loading ? 'Preparing document...' : 'Download Full Report PDF')}
      </PDFDownloadLink>
    </div>
  );
};
 
 


// <PDFDownloadLink
//   document={<PDFDocument accountNumber={accountNumber} />}
//   fileName="account_details.pdf"
//   className="backButton"
// >
//   {({ loading }) => (loading ? "Preparing PDF..." : "Download PDF")}
// </PDFDownloadLink>


export default PDFDocument;