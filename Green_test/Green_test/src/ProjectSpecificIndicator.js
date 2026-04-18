import React, { useEffect, useState } from "react";
import { Button } from "primereact/button";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import axios from "axios";
import './Maker.css'; // Importing CSS for the component

const ProjectSpecificIndicator = () => {
  const [indicators, setIndicators] = useState([]);
  const [projectName, setProjectName] = useState('Sample Project');
  const [indicatorValue, setIndicatorValue] = useState('Sample Value');
 
  // Fetch data from backend
  useEffect(() => {
    axios
      .get("http://localhost:5000/api/indicators") // Change the URL as per your backend
      .then((response) => {
        setIndicators(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  // Handle input changes in DataTable
  const handleInputChange = (e, rowIndex, field) => {
    const updatedIndicators = [...indicators];
    updatedIndicators[rowIndex][field] = e.target.value;
    setIndicators(updatedIndicators);
  };

  // Input field inside DataTable
  const inputEditor = (options) => {
    return (
      <input
        type="text"
        value={options.value || ""}
        onChange={(e) => handleInputChange(e, options.rowIndex, options.field)}
        className="datatable-input"
      />
    );
  };

  // Save function to send updated data to backend
  const handleSave = () => {
    axios
      .post("http://localhost:5000/api/saveIndicators", indicators) // Change as per backend API
      .then((response) => {
        console.log("Data saved successfully:", response.data);
      })
      .catch((error) => {
        console.error("Error saving data:", error);
      });
  };

  return (
    <div className="container1">
      <h1 className="title2">BoB Green Finance Portal</h1>
      <div className="line-container1">
        <div className="line1"></div>
      </div>
      <div className="business-div1">
        <h2 className="business-title">Project-Specific Indicators</h2>

        {/* Project-specific indicator information */}
        <div className="project-indicator">
          <h2>{projectName}</h2>
          <p>Indicator Value: {indicatorValue}</p>
        </div>

        {/* DataTable Container */}
        <div className="table-container">
          <DataTable
            value={indicators}
            responsiveLayout="scroll"
            editMode="cell"
            className="custom-datatable"
          >
            <Column field="indicator" header="Mandatory Indicator" body={inputEditor} />
            <Column field="description" header="Description" body={inputEditor} />
            <Column field="comment" header="Comment" body={inputEditor} />
            <Column field="type" header="Type" body={inputEditor} />
            <Column field="methodology" header="Methodology" body={inputEditor} />
          </DataTable>
        </div>
      </div>

      {/* Save Button */}
      <div className="button-container1">
        <Button label="SUBMIT" onClick={handleSave} className="saveButton" />
      </div>
    </div>
  );
};

// Exporting indicators array, userRole, and handleApprovalStatus function
export const indicators = ['Indicator 1', 'Indicator 2', 'Indicator 3'];
export const userRole = 'admin';  // Example user role

export const handleApprovalStatus = (status) => {
  console.log(`Approval status: ${status}`);
};

export default ProjectSpecificIndicator;


