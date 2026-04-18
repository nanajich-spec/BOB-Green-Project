








import React, { useState } from 'react';
import { Button } from 'primereact/button';
import { useNavigate } from 'react-router-dom';
import './RiskAssessment.css'; // Ensure you have styling for the component
// import axios from 'axios';//added new step
 
const RiskAssessment = () => {
  const [physicalRisk, setPhysicalRisk] = useState({
    locationVulnerability: '',
    seaLevelRise: '',
    supplyChainDisruptions: '',
  });
 
  const [transitionRisk, setTransitionRisk] = useState({
    carbonIntensiveSector: '',
    strandedAssetsRisk: '',
    shiftingConsumerPreferences: '',
  });
 
  const [operationalVulnerabilities, setOperationalVulnerabilities] = useState({
    businessContinuityPlans: '',
    climateResilienceInfrastructure: '',
  });
 
  const [emissionData, setEmissionData] = useState({
    borrowersEmissionFootprint: '',
  });
 
  const [submitted, setSubmitted] = useState(false);
  const navigate = useNavigate();
 
  // Handle Save Button Click
  const handleSave = async () => {   //here only async word added
    setSubmitted(true); // Trigger validation


 
    console.log({
      PhysicalRisk: physicalRisk,
      TransitionRisk: transitionRisk,
      OperationalVulnerabilities: operationalVulnerabilities,
      EmissionData: emissionData,
    });
 
    // Navigate to the next page
    navigate('/ProjectSpecificIndicator'); // Replace with actual route
  };
 
  
  const handleBack = () => {
    navigate(-1);
};

  return (
    <div className="container1">
      <h1 className="title2">BoB Green Finance Portal</h1>
      <div className="line-container1">
        <div className="line1"></div>
      </div>
 
      <div className="business-div">
        <h2 className="business-title">Risk Assessment Criteria (To be filled by the Bank)</h2>
       
        {/* Physical Risk Section */}
        <div className="risk-container">
        <div className="risk-section">
          <h3 className="risk-category">Physical Risk</h3>
          
          <div className="form-group">
            <label>Location Vulnerability<span className="required-star">*</span> :</label>
            <textarea
              value={physicalRisk.locationVulnerability}
              onChange={(e) => setPhysicalRisk({ ...physicalRisk, locationVulnerability: e.target.value })}
              className={submitted && !physicalRisk.locationVulnerability ? 'error' : ''}
              required
            />
          </div>
 
          <div className="form-group">
            <label>Sea-Level Rise (Coastal Properties Only)<span className="required-star">*</span> :</label>
            <textarea
              value={physicalRisk.seaLevelRise}
              onChange={(e) => setPhysicalRisk({ ...physicalRisk, seaLevelRise: e.target.value })}
              className={submitted && !physicalRisk.seaLevelRise ? 'error' : ''}
              required
            />
          </div>
 
          <div className="form-group">
            <label>Supply Chain Disruptions<span className="required-star">*</span> :</label>
            <textarea
              value={physicalRisk.supplyChainDisruptions}
              onChange={(e) => setPhysicalRisk({ ...physicalRisk, supplyChainDisruptions: e.target.value })}
              className={submitted && !physicalRisk.supplyChainDisruptions ? 'error' : ''}
              required
            />
          </div>
        </div>
 
        {/* Transition Risk Section */}
        <div className="risk-section">
          <h3 className="risk-category">Transition Risk</h3>
 
          <div className="form-group">
            <label>Carbon-Intensive Sector<span className="required-star">*</span> :</label>
            <textarea
              value={transitionRisk.carbonIntensiveSector}
              onChange={(e) => setTransitionRisk({ ...transitionRisk, carbonIntensiveSector: e.target.value })}
              className={submitted && !transitionRisk.carbonIntensiveSector ? 'error' : ''}
              required
            />
          </div>
 
          <div className="form-group">
            <label>Stranded Assets Risk<span className="required-star">*</span> :</label>
            <textarea
              value={transitionRisk.strandedAssetsRisk}
              onChange={(e) => setTransitionRisk({ ...transitionRisk, strandedAssetsRisk: e.target.value })}
              className={submitted && !transitionRisk.strandedAssetsRisk ? 'error' : ''}
              required
            />
          </div>
 
          <div className="form-group">
            <label>Shifting Consumer Preferences<span className="required-star">*</span> :</label>
            <textarea
              value={transitionRisk.shiftingConsumerPreferences}
              onChange={(e) => setTransitionRisk({ ...transitionRisk, shiftingConsumerPreferences: e.target.value })}
              className={submitted && !transitionRisk.shiftingConsumerPreferences ? 'error' : ''}
              required
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
              value={operationalVulnerabilities.businessContinuityPlans}
              onChange={(e) => setOperationalVulnerabilities({ ...operationalVulnerabilities, businessContinuityPlans: e.target.value })}
              className={submitted && !operationalVulnerabilities.businessContinuityPlans ? 'error' : ''}
              required
            />
          </div>
 
          <div className="form-group">
            <label>Climate Resilience Infrastructure<span className="required-star">*</span> :</label>
            <textarea
              value={operationalVulnerabilities.climateResilienceInfrastructure}
              onChange={(e) => setOperationalVulnerabilities({ ...operationalVulnerabilities, climateResilienceInfrastructure: e.target.value })}
              className={submitted && !operationalVulnerabilities.climateResilienceInfrastructure ? 'error' : ''}
              required
            />
          </div>
        </div>
 
        {/* Emission Data Section */}
        <div className="risk-section">
          <h3 className="risk-category">Emission Data</h3>
 
          <div className="form-group">
            <label>Borrower’s Emission Footprint<span className="required-star">*</span> :</label>
            <textarea
              value={emissionData.borrowersEmissionFootprint}
              onChange={(e) => setEmissionData({ ...emissionData, borrowersEmissionFootprint: e.target.value })}
              className={submitted && !emissionData.borrowersEmissionFootprint ? 'error' : ''}
              required
            />
          </div>
        </div>
        </div>
        </div>
        {/* Save & Next Button */}
        <div className="button-container2">
          <Button label="Save & Next" className="saveNext" onClick={handleSave} />
        </div>
        <div className='button-container3'> 
                <Button label="Back" className="backButton" onClick={handleBack} />
            </div>
     
    </div>
  );
};
 
export default RiskAssessment;
