package com.bob.app.api.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bob.app.bean.NcgtcMaster;
import com.bob.app.dao.jpa.AllBranchMasterRepository;
import com.bob.app.dao.jpa.NcgtcRepository;
import com.bob.app.dto.ZoneDTO;
import com.bob.app.service.NcgtcService;




@RestController
@RequestMapping("/api1")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class GeneralController1 {
	
	private static Logger log = LoggerFactory.getLogger(GeneralController.class);
	
	
	 
	 @Autowired
	 
	 private NcgtcService ncgtcService; 
	 
	 @Autowired
		private NcgtcRepository ncgtcRepository;
	 
	  @Autowired
	    private AllBranchMasterRepository allSolMasterRepository1;
	
	private final Map<String, String> emailOtpStore = new HashMap<>();
	private final Map<String, String> smsOtpStore = new HashMap<>();
	private final Map<String, String> captchaStore = new HashMap<>();
	
	
    
    @GetMapping("/ncgtc-all")
    public ResponseEntity<List<NcgtcMaster>> getAllNcgtc() {
        List<NcgtcMaster> ncgtc = ncgtcService.getAllNcgtc();
        return ResponseEntity.ok(ncgtc);
    }

//    @GetMapping("/ncgtc-filtered")
//    public ResponseEntity<List<NcgtcMaster>> getFilteredData(
//            @RequestParam(required = false) String zoneAlpha,
//            @RequestParam(required = false) String regionName,
//            @RequestParam(required = false) String branchName,
//            @RequestParam(required = false) String date) {
//
//        List<NcgtcMaster> filteredList = ncgtcService.getFilteredNcgtcData(zoneAlpha, regionName, branchName, date);
//        return ResponseEntity.ok(filteredList);
//    }


    @GetMapping("/ncgtc-by-date")
    public ResponseEntity<List<NcgtcMaster>> getByReportDate(@RequestParam String date) {
    List<NcgtcMaster> list = ncgtcService.getNcgtcByReportDate(date);
    return ResponseEntity.ok(list);
    }
    
    @GetMapping("/borrower-details/{refNo}")
    public NcgtcMaster getBorrowerDetails(@PathVariable String refNo) {
    return ncgtcService.getBorrowerDetailsByRefNo(refNo);
    }

    
    @PutMapping("/update-borrower-details/{refNo}")
    public ResponseEntity<String> updateBorrowerDetails(@PathVariable String refNo, @RequestBody NcgtcMaster updatedDetails) {
    NcgtcMaster existing = ncgtcService.getBorrowerDetailsByRefNo(refNo);
    if (existing == null) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Borrower not found with refNo: " + refNo);
    }

    // Update fields from updatedDetails to existing
    existing.setBorrowerName(updatedDetails.getBorrowerName());
    existing.setCoborrowerName(updatedDetails.getCoborrowerName());
    existing.setGender(updatedDetails.getGender());
    existing.setDob(updatedDetails.getDob());
    existing.setEmailBorrower(updatedDetails.getEmailBorrower());
    existing.setMobileNum(updatedDetails.getMobileNum());
    existing.setAdhaarNum(updatedDetails.getAdhaarNum());
    existing.setPanNum(updatedDetails.getPanNum());
    existing.setVoterId(updatedDetails.getVoterId());
    existing.setDrivingLicenseNum(updatedDetails.getDrivingLicenseNum());
    existing.setReligion(updatedDetails.getReligion());
    existing.setCasteCatg(updatedDetails.getCasteCatg());
    existing.setPresentAdd1(updatedDetails.getPresentAdd1());
    existing.setPresentCity(updatedDetails.getPresentCity());
    existing.setPresentDistrict(updatedDetails.getPresentDistrict());
    existing.setPresentState(updatedDetails.getPresentState());
    existing.setPresentPin(updatedDetails.getPresentPin());
    existing.setPermanentAddr2(updatedDetails.getPermanentAddr2());
    existing.setPermanentCity(updatedDetails.getPermanentCity());
    existing.setPermanentDistrict(updatedDetails.getPermanentDistrict());
    existing.setPermanentState(updatedDetails.getPermanentState());
    existing.setPermanentPin(updatedDetails.getPermanentPin());
    existing.setSanctAmt(updatedDetails.getSanctAmt());
    existing.setSanctDate(updatedDetails.getSanctDate());
    existing.setTenure(updatedDetails.getTenure());
    existing.setFgName(updatedDetails.getFgName());
    existing.setAgefgName(updatedDetails.getAgefgName());
    existing.setBorrowerReltnfg(updatedDetails.getBorrowerReltnfg());
    existing.setFgOccupation(updatedDetails.getFgOccupation());
    existing.setFgAddr(updatedDetails.getFgAddr());
    existing.setFgDistrict(updatedDetails.getFgDistrict());
    existing.setFgState(updatedDetails.getFgState());
    existing.setFgPin(updatedDetails.getFgPin());
    existing.setFgAnnualincome(updatedDetails.getFgAnnualincome());
    existing.setCourseName(updatedDetails.getCourseName());
    existing.setCourseType(updatedDetails.getCourseType());
    existing.setAbroadStudycourse(updatedDetails.getAbroadStudycourse());
    existing.setCourseCatg(updatedDetails.getCourseCatg());
    existing.setIfscCode(updatedDetails.getIfscCode());
    existing.setCustId(updatedDetails.getCustId());
    existing.setAcctExpdate(updatedDetails.getAcctExpdate());
    existing.setLoanAmtFirstDisb(updatedDetails.getLoanAmtFirstDisb());
    existing.setFirstDisbdate(updatedDetails.getFirstDisbdate());
    existing.setOutstandingBal(updatedDetails.getOutstandingBal());
    existing.setLoanMoratEnddate(updatedDetails.getLoanMoratEnddate());
    existing.setNpaStatus(updatedDetails.getNpaStatus());
    existing.setNpaDate(updatedDetails.getNpaDate());

    // Set status
    existing.setStatus("Pending at Checker");

    ncgtcService.saveBorrowerDetails(existing);

    return ResponseEntity.ok("Borrower details updated successfully!");
    }
    
    @GetMapping("/report-dates")
    public ResponseEntity<List<String>> getReportDates() {
        List<String> reportDates = ncgtcRepository.findByReportDate1();
        return ResponseEntity.ok(reportDates);
    }

    
    @GetMapping("/zones")
    public List<ZoneDTO> getZones() {
        return allSolMasterRepository1.findDistinctZones();
    }
    
    @GetMapping("/ros")
    public List<String> getRosByZone(@RequestParam String zoAlpha) {
        return allSolMasterRepository1.findRosByZone(zoAlpha);
    }

    @GetMapping("/branches")
    public List<String> getBranchesByRo(@RequestParam String roAlpha) {
        return allSolMasterRepository1.findBranchesByRo(roAlpha);
    }
    
    
    @GetMapping(value = "/ncgtc-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getNcgtcXml(@RequestParam String date) {
        List<NcgtcMaster> data = ncgtcService.getNcgtcByReportDate(date);
        

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        LocalDate reportDate = LocalDate.parse(date, inputFormat);
    String formattedDate = outputFormat.format(reportDate).toUpperCase();


        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<!-- XML LAYOUT FOR REQUESTING NEW CREDIT GUARANTEE \n");
        xmlBuilder.append("    TRUST: CREDIT GUARANTEE FUND FOR EDUCATIONAL LOANS \n");
        xmlBuilder.append("    SCHEME: CREDIT GUARANTEE FUND SCHEME FOR EDUCATIONAL LOANS \n");
        xmlBuilder.append("    VERSION: 1.0 \n");
        xmlBuilder.append("    DATE: ").append(formattedDate).append(" -->\n");
        xmlBuilder.append("<edu-borrowers>\n");

        for (NcgtcMaster item : data) {
            xmlBuilder.append("  <borrower>\n");

            xmlBuilder.append(xmlTag("name", item.getBorrowerName()));
            xmlBuilder.append(xmlTag("cborwname", item.getCoborrowerName()));
            xmlBuilder.append(xmlTag("gender", item.getGender()));
            xmlBuilder.append(xmlTag("dob", item.getDob()));
            xmlBuilder.append(xmlTag("eml", item.getEmailBorrower()));
            xmlBuilder.append(xmlTag("mbl", item.getMobileNum()));
            xmlBuilder.append(xmlTag("adhr", item.getAdhaarNum()));
            xmlBuilder.append(xmlTag("pan", item.getPanNum()));
            xmlBuilder.append(xmlTag("vtrid", item.getVoterId()));
            xmlBuilder.append(xmlTag("psprt", item.getPassportNum()));
            xmlBuilder.append(xmlTag("drvng", item.getDrivingLicenseNum()));
            xmlBuilder.append(xmlTag("rlgn", item.getReligion()));
            xmlBuilder.append(xmlTag("cstcat", item.getCasteCatg()));
            xmlBuilder.append(xmlTag("prsntadd", item.getPresentAdd1()));
            xmlBuilder.append(xmlTag("prsnttwn", item.getPresentCity()));
            xmlBuilder.append(xmlTag("prsntdist", item.getPresentDistrict()));
            xmlBuilder.append(xmlTag("prsntstate", item.getPresentState()));
            xmlBuilder.append(xmlTag("prsntpin", item.getPresentPin()));
            xmlBuilder.append(xmlTag("prmntadd", item.getPermanentAddr2()));
            xmlBuilder.append(xmlTag("prmnttwn", item.getPermanentCity()));
            xmlBuilder.append(xmlTag("prmntdist", item.getPermanentDistrict()));
            xmlBuilder.append(xmlTag("prmntstate", item.getPermanentState()));
            xmlBuilder.append(xmlTag("prmntpin", item.getPermanentPin()));
            xmlBuilder.append(xmlTag("ifscode", item.getIfscCode()));
            xmlBuilder.append(xmlTag("acctno", item.getLoanAcctnum()));
            xmlBuilder.append(xmlTag("sancamt", item.getSanctAmt()));
            xmlBuilder.append(xmlTag("sancdt", item.getSanctDate()));
            xmlBuilder.append(xmlTag("tenure", item.getTenure()));
            xmlBuilder.append(xmlTag("enddt", item.getAcctExpdate()));
            xmlBuilder.append(xmlTag("frstdisamt", item.getLoanAmtFirstDisb()));
            xmlBuilder.append(xmlTag("frstdisdt", item.getFirstDisbdate()));
            xmlBuilder.append(xmlTag("outamt", item.getOutstandingBal()));
            xmlBuilder.append(xmlTag("moraenddt", item.getLoanMoratEnddate()));
            xmlBuilder.append(xmlTag("custid", item.getCustId()));
            xmlBuilder.append(xmlTag("acctnpa", item.getNpaStatus()));
            xmlBuilder.append(xmlTag("npadt", item.getNpaDate()));
            xmlBuilder.append(xmlTag("fgname", item.getFgName()));
            xmlBuilder.append(xmlTag("fgage", item.getAgefgName()));
            xmlBuilder.append(xmlTag("fgrltn", item.getBorrowerReltnfg()));
            xmlBuilder.append(xmlTag("fgocc", item.getFgOccupation()));
            xmlBuilder.append(xmlTag("fgaddr", item.getFgAddr()));
            xmlBuilder.append(xmlTag("fgtwn", item.getFgCity()));
            xmlBuilder.append(xmlTag("fgdist", item.getFgDistrict()));
            xmlBuilder.append(xmlTag("fgstate", item.getFgState()));
            xmlBuilder.append(xmlTag("fgpin", item.getFgPin()));
            xmlBuilder.append(xmlTag("fgincome", item.getFgAnnualincome()));
            xmlBuilder.append(xmlTag("course", item.getCourseName()));
            xmlBuilder.append(xmlTag("coursetype", item.getCourseType()));
            xmlBuilder.append(xmlTag("courseabrd", item.getAbroadStudycourse()));
            xmlBuilder.append(xmlTag("coursecat", item.getCourseCatg()));

            xmlBuilder.append("  </borrower>\n");
        }

        xmlBuilder.append("</edu-borrowers>");

        return ResponseEntity.ok(xmlBuilder.toString());
    }


    private String xmlTag(String tagName, String value) {
        if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("null")) {
            return "    <" + tagName + "/>\n";
        } else {
            return "    <" + tagName + ">" + value + "</" + tagName + ">\n";
        }
    }


	
}