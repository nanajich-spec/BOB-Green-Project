package com.bob.app.api.rest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
//import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Calendar;
//import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bob.app.bean.ALL_SOL_MASTER;
import com.bob.app.bean.AccountStatement;
import com.bob.app.bean.AppConstant;
import com.bob.app.bean.DepositDetails;
import com.bob.app.bean.GreenFile;
import com.bob.app.bean.GreenSector;
import com.bob.app.bean.AccountNum;
import com.bob.app.bean.HrmsDataModel;
import com.bob.app.bean.LoanDetails;
import com.bob.app.bean.Student;
import com.bob.app.bean.User;
import com.bob.app.bean.AccountNum;
import com.bob.app.bean.UserMaster;
import com.bob.app.dao.jpa.AccountDetailsRepository;
import com.bob.app.dao.jpa.AccountNumRepository;
import com.bob.app.dao.jpa.AccountStatementRepository;
import com.bob.app.dao.jpa.AllSolMasterRepository;
import com.bob.app.dao.jpa.GreenFileRepository;
import com.bob.app.dao.jpa.LoanDetailsRepository;
import com.bob.app.dao.jpa.StudentRegRepository;
import com.bob.app.dao.jpa.UserMasterRepository;
import com.bob.app.dao.jpa.UserRepository;
import com.bob.app.domain.HrmsDataBean;
import com.bob.app.dto.AccountDTO;
import com.bob.app.dto.CheckerDTO;
import com.bob.app.dto.CmntDTO;
import com.bob.app.dto.DepositLoanLineChartDTO;
import com.bob.app.dto.FlagDTO;
import com.bob.app.dto.HistoryCmntDTO;
import com.bob.app.dto.LineChartDTO;
import com.bob.app.dto.LoanBarChartDTO;
import com.bob.app.dto.LoanBarChartDailyDTO;
import com.bob.app.dto.Phase1DTO;
import com.bob.app.dto.Phase1DTO2;
import com.bob.app.dto.Phase2DTO;
import com.bob.app.dto.PieChartDTO;
import com.bob.app.dto.BarChartDTO;
import com.bob.app.dto.BarChartDailyDTO;

import com.bob.app.dto.LoanChartDTO;
import com.bob.app.dto.SegmentChartDTO;
import com.bob.app.dto.SchemeActivityChartDTO;

import com.bob.app.dto.UserDTO;
import com.bob.app.exception.ResourceNotFoundException;
import com.bob.app.service.AccountNumService;
import com.bob.app.service.AccountStatementService;
import com.bob.app.service.AdidLogin;
import com.bob.app.service.ConfigurationService;
import com.bob.app.service.DepositDetailsService;
import com.bob.app.service.ReportService ;
import com.bob.app.service.GreenFileService;
import com.bob.app.service.GreenSectorService;
import com.bob.app.service.LoanDetailsService;
import com.bob.app.service.StudentService;
import com.bob.app.service.TribeMasterService;
import com.bob.app.service.UserService;
//import com.bob.app.utils.CommonUtils;
//import com.bob.app.utils.DataTypes;
//import com.bob.app.utils.UserLoginRespModel;
import com.bob.app.utils.CommonUtils;
import com.bob.app.utils.UserLoginRespModel;
import com.bob.app.utils.utils.DataTypes;


@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000"
public class GeneralController {
	private static Logger log = LoggerFactory.getLogger(GeneralController.class);

	
    private final ConfigurationService configService; 
  
    @Autowired
 	public GeneralController(ConfigurationService configService) {
 		this.configService = configService;
 	}
    
    
    @Autowired
    private AccountStatementService accountStatementService;
    
    
    @Autowired
    private AccountNumRepository accountNumRepository;
    

    @Autowired
    private TribeMasterService tribeMasterService;
    
    @Autowired
    private AdidLogin AdidLoginObj;
    
    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private AllSolMasterRepository allSolMasterRepository;
    
    @Autowired
    private StudentRegRepository studentRegRepository;
	
	@Autowired
	private GreenFileRepository greenFileRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AccountNumService accountNumService;
	
	@Autowired
	private GreenFileService greenFileService;
	
	@Autowired
	private GreenSectorService greenSectorService;
	

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Autowired
    private AccountStatementRepository accountStatementRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
	  private LoanDetailsRepository loanDetailsRepository;
    
    @Autowired
	  private LoanDetailsService loanDetailsService;
    
    @Autowired
	  private DepositDetailsService depositDetailsService;
    
    @Autowired
	  private ReportService reportService;
    
    private final Map<String, String> captchaStore = new HashMap<>(); // Stores CAPTCHA IDs and text

    // Endpoint to generate CAPTCHA image and return an ID
    @GetMapping("captcha/generate")
    public ResponseEntity<Map<String, String>> getCaptcha(HttpServletResponse response) throws IOException {
        String captchaText = generateCaptchaText(6);
        String captchaId = UUID.randomUUID().toString(); // Generate unique CAPTCHA ID

        //extra
        BufferedImage captchaImage = generateCaptchaImage(captchaText);
        
        String base64Image = convertImageToBase64(captchaImage);
        
        // Store the CAPTCHA text with its ID
        captchaStore.put(captchaId, captchaText);

        // Return the CAPTCHA ID to the front end
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("captchaId", captchaId);
        responseBody.put("image", base64Image);
//        responseBody.put("imageUrl", "https://noncbsuat.bankofbaroda.co.in/StockAudit/api/v1/image/" + captchaId);
//        responseBody.put("imageUrl", "https://noncbsdev.bankofbaroda.co.in/STOCKAUDITPORTALCA/" + captchaId);
        return ResponseEntity.ok(responseBody);
    }
    
  
    
    
    private String convertImageToBase64(BufferedImage image) throws IOException{
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	ImageIO.write(image, "png", baos);
    	byte[] imageBytes = baos.toByteArray();
    	return Base64.getEncoder().encodeToString(imageBytes);
    }

    // Endpoint to serve the CAPTCHA image by ID
    @GetMapping("/image/{captchaId}")
    public void getCaptchaImage(@PathVariable String captchaId, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");

        // Retrieve the CAPTCHA text using the ID
        String captchaText = captchaStore.get(captchaId);

        // Generate CAPTCHA image
        BufferedImage captchaImage = generateCaptchaImage(captchaText);

        // Write the image to the response output stream
        ImageIO.write(captchaImage, "png", response.getOutputStream());
    }

    // Endpoint to verify user input against the CAPTCHA
    @PostMapping("captcha/verify")
    public ResponseEntity<Boolean> verifyCaptcha(@RequestBody Map<String, String> requestBody) {
        String captchaId = requestBody.get("captchaId");
        String userInput = requestBody.get("captchaInput");

        // Retrieve the correct CAPTCHA text
        String correctCaptcha = captchaStore.get(captchaId);

        // Check if user input matches
        if (correctCaptcha != null && correctCaptcha.equals(userInput)) {
            captchaStore.remove(captchaId); // Remove after successful verification
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    // Helper methods (as before)

    private String generateCaptchaText(int length) {
//        Random random = new Random();
//        StringBuilder captchaText = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            captchaText.append(random.nextInt(10));
//        }
//        return captchaText.toString();
//    }
    	String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Alphanumeric characters
        Random random = new Random();
        StringBuilder captchaText = new StringBuilder();
        for (int i = 0; i < length; i++) {
            captchaText.append(alphanumeric.charAt(random.nextInt(alphanumeric.length()))); // Append random alphanumeric character
        }
        return captchaText.toString();
    }

    private BufferedImage generateCaptchaImage(String captchaText) {
        int width = 180;
        int height = 60;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        g2d.setColor(Color.BLACK);
        g2d.drawString(captchaText, 20, 45);
        g2d.setColor(Color.GRAY);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2d.drawLine(x1, y1, x2, y2);
        }
        g2d.dispose();
        return bufferedImage;
    }

 
    
	
	
    
    @RequestMapping(value = { "/sms/adidgetDetails" }, method = RequestMethod.POST)
    public ResponseEntity < ? > adidgetDetails(@RequestParam("username") String user_name,@RequestParam(value = "cred") String cred) {
		String username = "";
		UserLoginRespModel userDetail = null;
		

		if (user_name != null) {
			username = user_name.toUpperCase();
		} else {
			username = user_name;
		}
		if (!(username == null)) {

			if (!(cred == null)) {
				try {
					userDetail = AdidLoginObj.adidLoginInfo(username, CommonUtils.getEncryptedData(cred));

				} catch (UnsupportedEncodingException e) {
					
					log.info("Error : " + e);
				}

			}
		}
		if (userDetail != null && userDetail.getEcNo() != null) {
			log.info("response sent successfully");
			return new ResponseEntity<>(userDetail, HttpStatus.OK);
		} else {
			String errorMessage = "Error : Domain id does not exist";
			log.info(errorMessage);
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		}	
       
    }
    
    @RequestMapping(value = { "/sms/getHrmsUserData" }, method = RequestMethod.POST)
    public HrmsDataBean getHrmsuserData(@RequestParam("username") String userId) {
    	String username="";
    	HrmsDataBean userDetail = new HrmsDataBean();
    	
    	
		log.info("inside getHrnesuserData" + userId);
	
		String emp = "";
		if (userId.substring(2, 3).equalsIgnoreCase("0")) {
			emp = userId.substring(3);
		} else {
			emp = userId.substring(2);
		}

		//String URL_HRMS = "http://bankapps.bankofbaroda.co.in/HRMS_service/Service.asmx/GetEmpData";
		String URL_HRMS = "http://appstack.bankofbaroda.co.in/HRMS_service/Service.asmx/GetEmpData";
		String reqContent = "EmpCode=" + emp;
		String responseXML = "";

		try {
			responseXML = CommonUtils.callRestWS(URL_HRMS, "", DataTypes.contentTypes.URLe.toString(),
					DataTypes.contentTypes.XML.toString(), reqContent);
		} catch (NumberFormatException e) {

			
			log.info("Error : "+e);
		} catch (Exception e) {

			
			log.info("Error : "+e);
		}

		if (responseXML.contains("<string>")) {
			String searchStringBegin = "<string xmlns=\"http://tempuri.org/\">";
			String searchStringEnd = "</string>";
			responseXML = responseXML.substring(responseXML.indexOf(searchStringBegin) + searchStringBegin.length(),
					responseXML.indexOf(searchStringEnd));
		}

		String[] resArray = responseXML.split("\\|");
		Hashtable<String, String> ht = new Hashtable<String, String>();

		for (int i = 0; i < resArray.length; i++) {

			String k = resArray[i].split("\\^")[0];
			String v = null;

			if (resArray[i].split("\\^").length < 2) {
				v = "NO data fetched";

			} else {
				v = resArray[i].split("\\^")[1];
			}
			log.info(k + " its value " + v);
			ht.put(k, v);

		}
		
//		System.out.println("hrms data:"+ hr.ge);
		
		userDetail.setCurr_br_alpha(ht.get("CURRENT_BRANCH_ALPHA"));
		userDetail.setCurr_grade(ht.get("CURRENT_GRADE"));
		userDetail.setCurr_org(ht.get("CURRENT_ORGANIZATION"));
		userDetail.setCurr_position(ht.get("CURRENT_POSITION"));
		userDetail.setCurr_sol_id(ht.get("CURRENT_SOL_ID"));
		userDetail.setCurrent_designation(ht.get("CURRENT_GRADE"));
		userDetail.setCurrent_organization_type(ht.get("current_organization_type"));
		userDetail.setEmp_name(ht.get("EMPLOYEE_NAME"));
		userDetail.setPan_no(ht.get("PANNO"));
		userDetail.setUsername(ht.get("USER_NAME"));
		userDetail.setPhoneNo(ht.get("PHONE_NO"));
		
		userDetail.setCurr_br_alpha(ht.get("CURRENT_BRANCH_ALPHA"));
		
	
		log.info("returning the user details");
	
		return userDetail;

	}
    public HrmsDataBean getHrmsUserDataVal(@RequestParam("username") String userId) {
    	String username="";
    	HrmsDataBean userDetail = new HrmsDataBean();
    	
    	
		log.info("inside getHrnesuserData" + userId);
	
		String emp = "";
		if (userId.substring(2, 3).equalsIgnoreCase("0")) {
			emp = userId.substring(3);
		} else {
			emp = userId.substring(2);
		}

		//String URL_HRMS = "http://bankapps.bankofbaroda.co.in/HRMS_service/Service.asmx/GetEmpData";
		String URL_HRMS = "http://appstack.bankofbaroda.co.in/HRMS_service/Service.asmx/GetEmpData";
		String reqContent = "EmpCode=" + emp;
		String responseXML = "";

		try {
			responseXML = CommonUtils.callRestWS(URL_HRMS, "", DataTypes.contentTypes.URLe.toString(),
					DataTypes.contentTypes.XML.toString(), reqContent);
		} catch (NumberFormatException e) {

			
			log.info("Error : "+e);
		} catch (Exception e) {

			
			log.info("Error : "+e);
		}

		if (responseXML.contains("<string")) {
			String searchStringBegin = "<string xmlns=\"http://tempuri.org/\">";
			String searchStringEnd = "</string>";
			responseXML = responseXML.substring(responseXML.indexOf(searchStringBegin) + searchStringBegin.length(),
					responseXML.indexOf(searchStringEnd));
		}

		String[] resArray = responseXML.split("\\|");
		Hashtable<String, String> ht = new Hashtable<String, String>();

		for (int i = 0; i < resArray.length; i++) {

			String k = resArray[i].split("\\^")[0];
			String v = null;

			if (resArray[i].split("\\^").length < 2) {
				v = "NO data fetched";

			} else {
				v = resArray[i].split("\\^")[1];
			}
			log.info(k + " its value " + v);
			ht.put(k, v);

		}
		userDetail.setCurr_br_alpha(ht.get("CURRENT_BRANCH_ALPHA"));
		userDetail.setCurr_grade(ht.get("CURRENT_GRADE"));
		userDetail.setCurr_org(ht.get("CURRENT_ORGANIZATION"));
		userDetail.setCurr_position(ht.get("CURRENT_POSITION"));
		userDetail.setCurr_sol_id(ht.get("CURRENT_SOL_ID"));
		userDetail.setCurrent_designation(ht.get("CURRENT_GRADE"));
		userDetail.setCurrent_organization_type(ht.get("current_organization_type"));
		userDetail.setEmp_name(ht.get("EMPLOYEE_NAME"));
		userDetail.setPan_no(ht.get("PANNO"));
		userDetail.setUsername(ht.get("USER_NAME"));
		userDetail.setPhoneNo(ht.get("PHONE_NO"));
		
		userDetail.setCurr_br_alpha(ht.get("CURRENT_BRANCH_ALPHA"));
		
	
		log.info("returning the user details");
	
		return userDetail;

	}
   
    
   
    
    
    @RequestMapping(value="/sms/getAllSolMasterDataByBrAlpha", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity < ? > getAllSolMasterDataByBrAlpha(@RequestParam("alpha") String alpha, ModelMap model,
			HttpServletRequest req, HttpServletResponse res,
			RedirectAttributes ra) throws IOException {
    

    	log.info("calling for alpha id "+alpha);
    	ALL_SOL_MASTER all_sol_master = allSolMasterRepository.findByBrAlpha(alpha);
    	log.info("response for alpha id "+all_sol_master);
    	
    	if(all_sol_master!=null) {
    		log.info("response sent successfully");
    		return new ResponseEntity <>(all_sol_master,HttpStatus.OK);
    	}else {
    		String errorMessage = "Error : ALPHA  : "+alpha+" does not exists ";
    		log.info(errorMessage);
    		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    	}
          
    }
    
    @RequestMapping(value="/sms/getAllSolMasterDataByBrSolid", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity < ? > getAllSolMasterDataByBrSolid(@RequestParam("solid") String solid, ModelMap model,
			HttpServletRequest req, HttpServletResponse res,
			RedirectAttributes ra) throws IOException {

    	log.info("calling for SOL id "+solid);
    	ALL_SOL_MASTER all_sol_master = allSolMasterRepository.findByBrSolid(solid);
    	log.info("response for SOL id "+all_sol_master);
    	
    	if(all_sol_master!=null) {
    		log.info("response sent successfully");
    		return new ResponseEntity <>(all_sol_master,HttpStatus.OK);
    	}else {
    		String errorMessage = "Error : SOL id : "+solid+" does not exists ";
    		log.info(errorMessage);
    		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    	}
          
    }
    

    @RequestMapping(value="/sms/getAllSolMasterDataByRoAlpha", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity < ? > getAllSolMasterDataByRoAlpha(@RequestParam("alpha") String alpha, ModelMap model,
			HttpServletRequest req, HttpServletResponse res,
			RedirectAttributes ra) throws IOException {
    	
    	log.info("calling for alpha id "+alpha);
    	List<ALL_SOL_MASTER> all_sol_master = allSolMasterRepository.findByRoAlpha(alpha);
    	log.info("response for alpha id "+all_sol_master);
    	
    	if(all_sol_master!=null) {
    		log.info("response sent successfully");
    		return new ResponseEntity <>(all_sol_master,HttpStatus.OK);
    	}else {
    		String errorMessage = "Error : alpha : "+alpha+" does not exists ";
    		log.info(errorMessage);
    		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    	}
          
    }
    
    @RequestMapping(value="/sms/getAllSolMasterDataByZoAlpha", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity < ? > getAllSolMasterDataByZoAlpha(@RequestParam("alpha") String alpha, ModelMap model,
			HttpServletRequest req, HttpServletResponse res,
			RedirectAttributes ra) throws IOException {
    	
    	log.info("calling for alpha id "+alpha);
    	List<ALL_SOL_MASTER> all_sol_master = allSolMasterRepository.findByZoAlpha(alpha);
    	log.info("response for alpha id "+all_sol_master);
    	
    	if(all_sol_master!=null) {
    		log.info("response sent successfully");
    		return new ResponseEntity <>(all_sol_master,HttpStatus.OK);
    	}else {
    		String errorMessage = "Error : alpha : "+alpha+" does not exists ";
    		log.info(errorMessage);
    		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    	}
          
    }
    
    
    //hrsm data check
    @RequestMapping(value = "/emp/loginU", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> getAllSolMasterDataByRoAlpha(@RequestParam("username") String username,
                                                          @RequestParam("cred") String cred,
                                                          HttpServletRequest req,
                                                          HttpServletResponse res,
                                                          RedirectAttributes ra) throws IOException {
        String user_name = "";
        boolean loginCheck = false;
     
        // Sanitize and log the username
        user_name = (username != null) ? username.toUpperCase() : null;
        log.info("Receiving data for username: " + user_name);
     
        // Check for null username
        if (user_name == null) {
            return new ResponseEntity<>("Username cannot be null", HttpStatus.BAD_REQUEST);
        }
     
        // Check for null password/cred
        if (cred == null) {
            log.info("Password cannot be empty for User");
            return new ResponseEntity<>("Password cannot be empty for User !!", HttpStatus.NOT_ACCEPTABLE);
        }
     
        try {
            // Validate credentials
            loginCheck = AdidLoginObj.adidCheckerBoolean(user_name, CommonUtils.getEncryptedData(cred));
            log.info("Login check: " + loginCheck);
        } catch (UnsupportedEncodingException e) {
            log.error("Error during credential encryption: ", e);
            return new ResponseEntity<>("Error during authentication", HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
        // Check if login is successful
        if (!loginCheck) {
            log.info("User authentication failed");
            return new ResponseEntity<>("User authentication failed !!", HttpStatus.NOT_ACCEPTABLE);
        }
     
        // Fetch HRMS data
        HrmsDataBean hrmsBean = getHrmsUserDataVal(user_name);
     
        // If HrmsDataBean is null, return an error response
        if (hrmsBean == null) {
            log.info("User not found in HRMS data");
            return new ResponseEntity<>("Not a valid User !!", HttpStatus.NOT_ACCEPTABLE);
        }
     
        log.info("User is of type: " + hrmsBean.getCurrent_organization_type());
     
        // Normalize organization type and position strings
        String orgType = (hrmsBean.getCurrent_organization_type() != null) ? hrmsBean.getCurrent_organization_type().trim() : "";
        String currPosition = (hrmsBean.getCurr_position() != null) ? hrmsBean.getCurr_position().trim() : "";
        String currGrade = (hrmsBean.getCurr_grade() != null) ? hrmsBean.getCurr_grade().trim() : "";
     
        // Role assignment logic
        if ("Branch".equalsIgnoreCase(orgType) || "Regional Office".equalsIgnoreCase(orgType) || "Zonal Office".equalsIgnoreCase(orgType) || "Corporate Centre".equalsIgnoreCase(orgType)) {
            if ("RISK MANAGEMENT".equalsIgnoreCase(currPosition)) {
                log.info("User is in 'Risk Management'.");
     
                if (!"CLERK.CLERK.CL".equalsIgnoreCase(currGrade)) {
                    if ("OFFICER.SENIOR MANAGEMENT.IV".equalsIgnoreCase(currGrade) ||
                        "OFFICER.SENIOR MANAGEMENT.V".equalsIgnoreCase(currGrade) ||
                        "OFFICER.TOP.EXECUTIVE.VI".equalsIgnoreCase(currGrade)) {
                        log.info("User is 'authorized'. Assigning role 'Checker'.");
                        hrmsBean.setRole("checker");
                    } else {
                        log.info("User is 'not authorized'. Assigning role 'Maker'.");
                        hrmsBean.setRole("maker");
                    }
                    return new ResponseEntity<>(hrmsBean, HttpStatus.OK);
                }
            }
        } else {
            log.info("Invalid organization type: " + orgType);
            return new ResponseEntity<>("Invalid organization type: " + orgType, HttpStatus.BAD_REQUEST);
        }
     
        // If none of the conditions match, return a proper error response
        log.info("User is not authorized.");
        return new ResponseEntity<>("User is not authorized !!", HttpStatus.FORBIDDEN);
    }

    
    
    //hrsm data check
    @RequestMapping(value = "/emp/loginUser", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> getAllSolMasterDataByRoAlpha(@RequestParam("username") String username,
                                                        
                                                          HttpServletRequest req,
                                                          HttpServletResponse res,
                                                          RedirectAttributes ra) throws IOException {
        String user_name = "";
        boolean loginCheck = false;
     
        // Sanitize and log the username
        user_name = (username != null) ? username.toUpperCase() : null;
        log.info("Receiving data for username: " + user_name);
     
        // Check for null username
        if (user_name == null) {
            return new ResponseEntity<>("Username cannot be null", HttpStatus.BAD_REQUEST);
        }
     
        // Check for null password/cred
//        if (cred == null) {
//            log.info("Password cannot be empty for User");
//            return new ResponseEntity<>("Password cannot be empty for User !!", HttpStatus.NOT_ACCEPTABLE);
//        }
     
//        try {
//            // Validate credentials
//           // loginCheck = AdidLoginObj.adidCheckerBoolean(user_name, CommonUtils.getEncryptedData(cred));
//            log.info("Login check: " + loginCheck);
//        } catch (UnsupportedEncodingException e) {
//            log.error("Error during credential encryption: ", e);
//            return new ResponseEntity<>("Error during authentication", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//     
        // Check if login is successful
        if (!loginCheck) {
            log.info("User authentication failed");
            return new ResponseEntity<>("User authentication failed !!", HttpStatus.NOT_ACCEPTABLE);
        }
     
        // Fetch HRMS data
        HrmsDataBean hrmsBean = getHrmsUserDataVal(user_name);
     
        // If HrmsDataBean is null, return an error response
        if (hrmsBean == null) {
            log.info("User not found in HRMS data");
            return new ResponseEntity<>("Not a valid User !!", HttpStatus.NOT_ACCEPTABLE);
        }
     
        log.info("User is of type: " + hrmsBean.getCurrent_organization_type());
     
        // Normalize organization type and position strings
        String orgType = (hrmsBean.getCurrent_organization_type() != null) ? hrmsBean.getCurrent_organization_type().trim() : "";
        String currPosition = (hrmsBean.getCurr_position() != null) ? hrmsBean.getCurr_position().trim() : "";
        String currGrade = (hrmsBean.getCurr_grade() != null) ? hrmsBean.getCurr_grade().trim() : "";
     
        // Role assignment logic
        if ("Branch".equalsIgnoreCase(orgType) || "Regional Office".equalsIgnoreCase(orgType) || "Zonal Office".equalsIgnoreCase(orgType) || "Corporate Centre".equalsIgnoreCase(orgType)) {
            if ("RISK MANAGEMENT".equalsIgnoreCase(currPosition)) {
                log.info("User is in 'Risk Management'.");
     
                if (!"CLERK.CLERK.CL".equalsIgnoreCase(currGrade)) {
                    if ("OFFICER.SENIOR MANAGEMENT.IV".equalsIgnoreCase(currGrade) ||
                        "OFFICER.SENIOR MANAGEMENT.V".equalsIgnoreCase(currGrade) ||
                        "OFFICER.TOP.EXECUTIVE.VI".equalsIgnoreCase(currGrade)) {
                        log.info("User is 'authorized'. Assigning role 'Checker'.");
                        hrmsBean.setRole("Checker");
                    } else {
                        log.info("User is 'not authorized'. Assigning role 'Maker'.");
                        hrmsBean.setRole("Maker");
                    }
                    return new ResponseEntity<>(hrmsBean, HttpStatus.OK);
                }
            }
        } else {
            log.info("Invalid organization type: " + orgType);
            return new ResponseEntity<>("Invalid organization type: " + orgType, HttpStatus.BAD_REQUEST);
        }
     
        // If none of the conditions match, return a proper error response
        log.info("User is not authorized.");
        return new ResponseEntity<>("User is not authorized !!", HttpStatus.FORBIDDEN);
    }
    
//    @PostMapping("/saveOrUpdate")
//    public ResponseEntity<AccountNum> saveOrUpdateAccount(@RequestBody AccountDTO accountDTO) {
//         AccountNum savedAccount = accountNumService.getUserByAccount(accountDTO);
//        return ResponseEntity.ok(savedAccount);
//    }
//    @PostMapping("/updatePhase1/{accountNum}")
//    public ResponseEntity<AccountNum> saveOrUpdate(@RequestBody AccountNum accountNumRequest) {
//        Optional<AccountNum> existingAccount = accountNumService.findByAccountNumber(accountNumRequest);
//       if (existingAccount.isPresent()) {
//            // Update existing record
//            AccountNum accountToUpdate = existingAccount.get();
//            accountToUpdate.setAccStatus(accountNumRequest.getAccStatus()); // Update fields as needed
//            accountToUpdate.setAccStatusFlag(accountNumRequest.getAccStatusFlag());
//            accountToUpdate.setAssetrisk(accountNumRequest.getAssetrisk());
//            accountToUpdate.setActivityCode(accountNumRequest.getActivityCode());
//            accountToUpdate.setActivityFlag(accountNumRequest.getActivityFlag());
//            accountToUpdate.setAdminReject(accountNumRequest.getAdminReject());
//            accountToUpdate.setAdminRejectFlag(accountNumRequest.getAdminRejectFlag());
//            accountToUpdate.setAdminStatus(accountNumRequest.getAdminStatus());
//            accountToUpdate.setAdminStatusFlag(accountNumRequest.getAdminStatusFlag());
//            accountToUpdate.setAssestriskFlag(accountNumRequest.getAssestriskFlag());
//            accountToUpdate.setBorroweremission(accountNumRequest.getBorroweremission());
//            accountToUpdate.setBorrowerFlag(accountNumRequest.getBorrowerFlag());
//            accountToUpdate.setBorrowermissionFlag(accountNumRequest.getBorrowermissionFlag());
//            accountToUpdate.setBorrowerName(accountNumRequest.getBorrowerName());
//            accountToUpdate.setBranchFlag(accountNumRequest.getBranchFlag());
//            accountToUpdate.setBranchName(accountNumRequest.getBranchName());
//            accountToUpdate.setBudget(accountNumRequest.getBudget());
//            accountToUpdate.setBudgetFlag(accountNumRequest.getBudgetFlag());
//            accountToUpdate.setBusiness(accountNumRequest.getBusiness());
//     
//            AccountNum updatedAccount = accountNumService.saveOrUpdate(accountToUpdate);
//            return ResponseEntity.ok(updatedAccount);
//        } else {
//            // Save new record
//            AccountNum savedAccount = accountNumService.saveOrUpdate(accountNumRequest);
//            return ResponseEntity.ok(savedAccount);
//        }
//    }
    
    
    @PostMapping("/emp/login")
    
    public ResponseEntity<?> getAllSolMasterDataByRoAlpha(@RequestBody UserDTO loginRequest,
 
                                                          HttpServletRequest req,
 
                                                          HttpServletResponse res,
 
                                                          RedirectAttributes ra) throws IOException {
 
        String user_name = loginRequest.getUserid() != null ? loginRequest.getUserid().toUpperCase() : null;
 
        String cred = loginRequest.getPassword();

        log.info("Receiving data for username: " + user_name);

        if (user_name == null) {
 
            return new ResponseEntity<>("Username cannot be null", HttpStatus.BAD_REQUEST);
 
        }

        if (cred == null || cred.isEmpty()) {
 
            log.info("Password cannot be empty for User");
 
            return new ResponseEntity<>("Password cannot be empty for User !!", HttpStatus.NOT_ACCEPTABLE);
 
        }

        boolean loginCheck;
 
        try {
 
            loginCheck = AdidLoginObj.adidCheckerBoolean(user_name, CommonUtils.getEncryptedData(cred));
 
            log.info("Login check: " + loginCheck);
 
        } catch (UnsupportedEncodingException e) {
 
            log.error("Error during credential encryption: ", e);
 
            return new ResponseEntity<>("Error during authentication", HttpStatus.INTERNAL_SERVER_ERROR);
 
        }

        if (!loginCheck) {
 
            log.info("User authentication failed");
 
            return new ResponseEntity<>("User authentication failed !!", HttpStatus.NOT_ACCEPTABLE);
 
        }

        HrmsDataBean hrmsBean = getHrmsUserDataVal(user_name);
 
        if (hrmsBean != null) {
 
            String orgType = hrmsBean.getCurrent_organization_type() != null ? hrmsBean.getCurrent_organization_type().trim() : "";
 
            String currPosition = hrmsBean.getCurr_position() != null ? hrmsBean.getCurr_position().trim() : "";
 
            String currGrade = hrmsBean.getCurr_grade() != null ? hrmsBean.getCurr_grade().trim() : "";
 
            String solId = hrmsBean.getCurr_sol_id();

            if ("Branch".equalsIgnoreCase(orgType)) {
 
                User user = userRepository.findBybranchSol(solId);
 
                if (user != null && "Y".equalsIgnoreCase(user.getVerified())) {
 
                    if ("Branch Head".equalsIgnoreCase(currPosition)) {
 
                        hrmsBean.setRole("Checker");
 
                    } else {
 
                        hrmsBean.setRole("Maker");
 
                    }
 
                    hrmsBean.setLoginType("Branch");
 
                    return new ResponseEntity<>(hrmsBean, HttpStatus.OK);
 
                } else {
 
                    return new ResponseEntity<>("Barred", HttpStatus.FORBIDDEN);
 
                }
 
            } else {
 
                User user = userRepository.findByUserid(user_name);
 
                if (user != null) {
 
                	return new ResponseEntity<>(user, HttpStatus.OK);
 
                } else {
 
                    return new ResponseEntity<>("You are not authorized", HttpStatus.FORBIDDEN);
 
                }
 
            }
 
        } else {
 
            log.info("User not found in HRMS data.");
 
            return new ResponseEntity<>("Access Denied. User not found in HRMS data.", HttpStatus.FORBIDDEN);
 
        }
 
    }
 
     

  //hrsm data check
    @RequestMapping(value = "/test/login", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> getAllSolMasterDataByRoAlphaTest(@RequestParam("username") String username,
                                                 //        @RequestParam("cred") String cred,
                                                          HttpServletRequest req,
                                                          HttpServletResponse res,
                                                          RedirectAttributes ra) throws IOException {
        String user_name = "";
        boolean loginCheck = false;
 
        // Sanitize and log the username
        user_name = (username != null) ? username.toUpperCase() : null;
        log.info("Receiving data for username: " + user_name);
 
        // Check for null username
        if (user_name == null) {
            return new ResponseEntity<>("Username cannot be null", HttpStatus.BAD_REQUEST);
        }
 
//       //  Check for null password/cred
//        if (cred == null || cred == "") {
//            log.info("Password cannot be empty for User");
//            return new ResponseEntity<>("Password cannot be empty for User !!", HttpStatus.NOT_ACCEPTABLE);
//        }
//
//        try {
//            // Validate credentials
//           loginCheck = AdidLoginObj.adidCheckerBoolean(user_name, CommonUtils.getEncryptedData(cred));
//        	
//            log.info("Login check: " + loginCheck);
//        } catch (UnsupportedEncodingException e) {
//            log.error("Error during credential encryption: ", e);
//            return new ResponseEntity<>("Error during authentication", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        // Check if login is successful
//        if (!loginCheck) {
//            log.info("User authentication failed");
//            return new ResponseEntity<>("User authentication failed !!", HttpStatus.NOT_ACCEPTABLE);
//        }
// 
        // Check HrmsDataBean for the user data
        HrmsDataBean hrmsBean = getHrmsUserDataVal(user_name);
        if (hrmsBean != null) {
            log.info("User organization type: " + hrmsBean.getCurrent_organization_type());
 
            // Normalize organization type and position strings
            String orgType = hrmsBean.getCurrent_organization_type() != null ? hrmsBean.getCurrent_organization_type().trim() : "";
            String currPosition = hrmsBean.getCurr_position() != null ? hrmsBean.getCurr_position().trim() : "";
            String currGrade = hrmsBean.getCurr_grade() != null ? hrmsBean.getCurr_grade().trim() :"";
            // Branch Logic
            if ("Branch".equalsIgnoreCase(orgType)) {
                log.info("User is of type 'Branch'.");
             
                if ("CLERK.CLERK.CL".equalsIgnoreCase(currGrade)) {
//                    log.info("User is a 'Clerk'. Not authorized to log in.");
                    return new ResponseEntity<>("You are not authorized to login.", HttpStatus.UNAUTHORIZED);
                } else {
                    if ("OFFICER.SENIOR MANAGEMENT.IV".equalsIgnoreCase(currGrade)) {
//                        log.info("User scale is 4 or above. Assigning role 'Checker'.");
                        hrmsBean.setRole("Checker");
                    } else if ("OFFICER.JUNIOR MANAGEMENT.I".equalsIgnoreCase(currGrade) || "OFFICER.MIDDLE MANAGEMENT.II".equalsIgnoreCase(currGrade) || "OFFICER.MIDDLE MANAGEMENT.III".equalsIgnoreCase(currGrade) ) {
//                        log.info("User scale is between 1 and 3. Assigning role 'Maker'.");
                        hrmsBean.setRole("Maker");
                    } else {
//                        log.warn("Invalid scale value provided: " + currGrade);
                        return new ResponseEntity<>("Invalid employee scale.", HttpStatus.BAD_REQUEST);
                    }
                }
             
                return new ResponseEntity<>(hrmsBean, HttpStatus.OK);
            }
            // Regional Office and Zonal Office Logic
            else if ("Regional Office".equalsIgnoreCase(orgType) || "Zonal Office".equalsIgnoreCase(orgType)) {
                log.info("User is of type 'Regional Office' or 'Zonal Office'.");
                if ("Zonal Office".equalsIgnoreCase(orgType) && 
                        currPosition.toLowerCase().contains("credit monitoring") && 
                        "OFFICER.SENIOR MANAGEMENT.IV".equalsIgnoreCase(currGrade)) {
                        log.info("User is 'Credit Monitoring' in 'Zonal Office' with Grade IV. Assigning role 'Checker'.");
                        hrmsBean.setRole("Checker");
                        return new ResponseEntity<>(hrmsBean, HttpStatus.OK);
                    }
                if (currPosition.toLowerCase().contains("credit head") || currPosition.toLowerCase().contains("head credit") ) {
                    log.info("User is 'Credit Head'. Assigning role 'Checker'.");
                    hrmsBean.setRole("Checker");
                } else if (currPosition.toLowerCase().startsWith("credit")|| currPosition.toLowerCase().startsWith("recovery")) {
                    log.info("User position starts with 'Credit'. Assigning role 'Maker'.");
                    hrmsBean.setRole("Maker");
                } else {
                    log.info("User position does not match 'Credit Head' or start with 'Credit'. Access denied.");
                    return new ResponseEntity<>("Access Denied. User does not meet criteria.", HttpStatus.FORBIDDEN);
                }
                return new ResponseEntity<>(hrmsBean, HttpStatus.OK);
            }
            // Corporate Centre Logic
            else if ("Corporate Centre".equalsIgnoreCase(orgType)) {
                log.info("User is of type 'Corporate Centre'.");
                 
                	 
                    User user = userRepository.findByUserid(user_name);
     
                    if (user != null) {
                    	hrmsBean.setRole("Admin");
                    	return new ResponseEntity<>(user, HttpStatus.OK);
                    
     
                    } else {
     
                        return new ResponseEntity<>("You are not authorized", HttpStatus.FORBIDDEN);
     
                    }
            } 
            // If none of the organization types match
            else {
                log.info("User does not belong to a valid organization type.");
                return new ResponseEntity<>("Access Denied. User does not belong to a valid organization type.", HttpStatus.FORBIDDEN);
            }
        } else {
            // If HrmsDataBean is null
            log.info("User not found in HRMS data.");
            return new ResponseEntity<>("Access Denied. User not found in HRMS data.", HttpStatus.FORBIDDEN);
        }
    }
 

        
    @PostMapping("userDataSave")
    public String saveData(@RequestBody User saveModel) {
        try {
            // Check if userId already exists in the database
            boolean userExists = userRepository.existsByUserid(saveModel.getUserid());
            if (userExists) {
                return "User ID already exists in the database.";
            }
            
         // Set the addedOn timestamp to the current time
            saveModel.setAddedOn(LocalDateTime.now());
            saveModel.setVerified("N"); //Explicitly set verify to "N"
            saveModel.setUserLevel("A");
            
//            saveModel.setEnable("Y");
 
            // Save the new user data
            userRepository.save(saveModel);
            return "User data saved successfully.";
        } catch (Exception e) {
            return "Failed to save user data.";
        }
    }
 
 
//   @PostMapping("/deleteUser")
//    public String deleteUser(@RequestBody Map<String, String> request) {
//        String userid = request.get("userid");
//        String modifiedBy = request.get("modifiedBy");
//        return userService.deleteUser(userid, modifiedBy);
//    }
// 
//    @PostMapping("/enableUser")
//    public String enableUser(@RequestBody Map<String, String> request) {
//        String userid = request.get("userid");
//        String modifiedBy = request.get("modifiedBy");
//        return userService.enableUser(userid, modifiedBy);
//    }
// 
    
    // Endpoint to get users with verify status "N"
    @GetMapping("/users-to-verify")
    public List<User> getUsersToVerify() {
        return userService.getUsersToVerify();
    }
   
    
    @PostMapping("remove-user")
    public ResponseEntity<User> removeUser(@RequestBody User user){
    	User existingUser = userRepository.findByUserid(user.getUserid());

    	if (existingUser == null) {

    	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    	}
    	 
    	existingUser.setRemovedOn(user.getRemovedOn());
    	existingUser.setRemovedBy(user.getRemovedBy());
    	existingUser.setRemoveReason(user.getRemoveReason());
    	existingUser.setUserLevel("R");
    	 
    	User updatedUser = userRepository.save(existingUser);

    	return ResponseEntity.ok(updatedUser);

    	 
    }
    
    @PostMapping("remove-verify-user")
    public ResponseEntity<User> removeVerifyUser(@RequestBody User user){
    	User existingUser = userRepository.findByUserid(user.getUserid());    
    	if(existingUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    //	User userDetails = existingUser.get();

    	existingUser.setRemoveVerifiedBy(user.getRemoveVerifiedBy());
    	existingUser.setRemoveVerifiedOn(user.getRemoveVerifiedOn());
    	existingUser.setRemoved("Y");
    	existingUser.setUserLevel("RV");

    	User updatedUser = userRepository.save(existingUser);
    	return ResponseEntity.ok(updatedUser);
    }
    
    @PostMapping("enable-user")
    public ResponseEntity<User> enableUser(@RequestBody User user){
    	User existingUser = userRepository.findByUserid(user.getUserid());   
    	if(existingUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    //	User userDetails = existingUser.get();

    	existingUser.setEnableOn(user.getEnableOn());
    	existingUser.setEnableBy(user.getEnableBy());
    	existingUser.setEnableReason(user.getEnableReason());
    	existingUser.setUserLevel("E");

    	User updatedUser = userRepository.save(existingUser);
    	return ResponseEntity.ok(updatedUser);
    }
    @PostMapping("enable-verify-user")
    public ResponseEntity<User> enableVerifyUser(@RequestBody User user){
    	User existingUser = userRepository.findByUserid(user.getUserid());   
    	if(existingUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	//User userDetails = existingUser.get();

    	existingUser.setEnableVerifyBy(user.getEnableVerifyBy());
    	existingUser.setEnableVerifyOn(user.getEnableVerifyOn());
    	existingUser.setRemoved("N");
    	existingUser.setUserLevel("EV");
   
    	User updatedUser = userRepository.save(existingUser);
    	return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("verify-user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
    	User existingUser = userRepository.findByUserid(user.getUserid());   
    	if(existingUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	//User userDetails = existingUser.get();

    	existingUser.setVerifiedBy(user.getVerifiedBy());
    	existingUser.setVerifiedOn(user.getVerifiedOn());
    	existingUser.setVerifyRemark(user.getVerifyRemark());
    //	existingUser.setBusinessVerifiedOn(user.getBusinessVerifiedOn());
    //	if("Y".equalsIgnoreCase(user.getBusinessVerified())) {
    		existingUser.setVerified("Y");
   		existingUser.setUserLevel("AV");
//    		A -> Added
//    		AV -> Added-Verified
//    	}else {
//    		existingUser.setVerify("N");
//    	}
// exist
    	User updatedUser = userRepository.save(existingUser);
    	return ResponseEntity.ok(updatedUser);
    }
// Endpoint to verify a user by ID
    @PostMapping("/verify/{userId}")
    public String verifyUser(@PathVariable String userId, @RequestBody VerifyRequest request) {
        return userService.verifyUser(userId, request.getVerifiedBy(), request.getuserID(), request.getverifiedOn(), request.getVerifyRemark(), request.getEnable());
    }
    static class VerifyRequest {
        private String verifiedBy;
        private String userID;
        private String VerifyRemark;
        private String verifiedOn;
        private String Enable;
        
        public String getVerifiedBy() { return verifiedBy; }
        public void setVerifiedBy(String verifiedBy) { this.verifiedBy = verifiedBy; }
 
        public String getuserID() { return userID; }
        public void setuserID(String userID) { this.userID = userID; }
    
        public String getVerifyRemark() { return VerifyRemark; }
        public void setverifyRemarks(String VerifyRemark) { this.VerifyRemark = VerifyRemark; }
        
        public String getverifiedOn() { return verifiedOn; }
        public void setverifiedOn(String verifiedOn) { this.verifiedOn = verifiedOn; }
        
        public String getEnable() { return Enable; }
        public void setEnable(String Enable) { this.Enable = Enable; }
    
                
    }
    
    
//    @PostMapping("updatedPhase1/{accountNum}")
//	  public ResponseEntity<?> updateUserByAccountNum(@PathVariable String accountNum, @RequestBody Phase1DTO accountDTO) {
//	      try {
//	    	 // System.out.println("Received request to update user with accountnum: " + accountNum);
//	    	  AccountNum existingUser = accountNumRepository.findByaccountNumber(accountNum);
//	          if (existingUser == null) {
//	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with Account num " + accountDTO + " not found");
//	          }
//	          System.out.println("Existing user: " + existingUser);
//	          System.out.println("Updated user data: " + existingUser);
//	          // Update fields
//	          existingUser.setDescpFlag(accountDTO.getDescpFlag());
//	          existingUser.setDescription(accountDTO.getDescription());
//	          existingUser.setProjName(accountDTO.getProjName());
//	         // existingUser.setLocationType(accountDTO.getLocationType());
//	         // existingUser.setLocationFlag(accountDTO.getLocationFlag());
//	          existingUser.setPlantLocations(accountDTO.getPlantLocations());
//	          existingUser.setPlantLocationsFlag(accountDTO.getPlantLocationsFlag());
//	          existingUser.setSegment(accountDTO.getSegment());
//	          existingUser.setSector(accountDTO.getSector());
//	          existingUser.setSectorFlag(accountDTO.getSectorFlag());
//	          existingUser.setSusobj(accountDTO.getSusobj());
//	          existingUser.setSusobjFlag(accountDTO.getSusobjFlag());
//	          existingUser.setStakeEng(accountDTO.getStakeEng());
//	          existingUser.setStakeEngFlag(accountDTO.getStakeEngFlag());
//	          existingUser.setReportReq(accountDTO.getReportReq());
//	          existingUser.setReportReqFlag(accountDTO.getReportReqFlag());
//	          existingUser.setTimeline(accountDTO.getTimeline());
//	          existingUser.setTimelineFlag(accountDTO.getTimelineFlag());
//	          existingUser.setBudget(accountDTO.getBudget());
////	          existingUser.setEIAfile(accountDTO.getEIAfile());
////	          existingUser.setLegalVerificationFile(accountDTO.getLegalVerificationFile());
////	          existingUser.setFinancialHealthFile(accountDTO.getFinancialHealthFile());
////	          existingUser.setESGfile(accountDTO.getESGfile());
//	          existingUser.setEIAcomments(accountDTO.getEIAcomments());
//	          existingUser.setEIAcommFlag(accountDTO.getEIAcommFlag());
//	          existingUser.setBudgetFlag(accountDTO.getBudgetFlag());
//	          existingUser.setLegalVerificationComments(accountDTO.getLegalVerificationComments());
//	          existingUser.setFinancialHealthComments(accountDTO.getFinancialHealthComments());
//	          existingUser.setLegalverFlag(accountDTO.getLegalverFlag());
//	          existingUser.setFinancialHealthFlag(accountDTO.getFinancialHealthFlag());
//	          existingUser.setEsgCompliance(accountDTO.getEsgCompliance());
//	          existingUser.setEsgCompFlag(accountDTO.getEsgCompFlag());
//	          existingUser.setPincode(accountDTO.getPincode());
//	          existingUser.setLatitude(accountDTO.getLatitude());
//	          existingUser.setLongitude(accountDTO.getLongitude());
////	          existingUser.setOthersAdd(accountDTO.getOthersAdd());
//	          existingUser.setBriefDtls(accountDTO.getBriefDtls());
//	         // existingStudent.setStuFile(updatedStudent.getStuFile());
//	          accountNumRepository.save(existingUser);
//	          // System.out.println("User updated successfully: " + existingUser);
//	          return ResponseEntity.ok("User updated successfully");
//	      } catch (Exception e) {
//	    	 // System.err.println("Error updating user: " + e.getMessage());
//	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
//	      }
//	  }
////    
    
    
       
    
    @PostMapping("updatedPhase1/{accountNum}")
    public ResponseEntity<?> updateUserByAccountNum(@PathVariable String accountNum,
                                                    @RequestBody Phase1DTO2 accountDTO) {
        try {
            log.info("=== Incoming Request ===");
            log.info("Account Number (PathVariable): {}", accountNum);
            log.info("Payload (Phase1DTO): {}", accountDTO);

            // Find existing user
            AccountNum existingUser = accountNumRepository.findByaccountNumber(accountNum);
            if (existingUser == null) {
                log.warn("No user found with accountNumber: {}", accountNum);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("User with Account num " + accountNum + " not found");
            }

            log.info("Existing user before update: {}", existingUser);

            // Update fields
            existingUser.setDescpFlag(accountDTO.getDescpFlag());
            existingUser.setDescription(accountDTO.getDescription());
            existingUser.setProjName(accountDTO.getProjName());
            String joined ="";
            if(accountDTO.getPlantLocations()!=null) {
            	List<String> locations = accountDTO.getPlantLocations();
            	StringBuilder sb = new StringBuilder();
            	if (locations != null) {
            	    for (int i = 0; i < locations.size(); i++) {
            	        String loc = locations.get(i);
            	        if (loc != null) {
            	            loc = loc.trim();
            	            if (!loc.isEmpty()) {
            	                if (sb.length() > 0) sb.append(",");
            	                sb.append(loc);
            	            }
            	        }
            	    }
            	}
            	 joined = sb.toString();
            }
            
            existingUser.setPlantLocations(joined);
            existingUser.setPlantLocationsFlag(accountDTO.getPlantLocationsFlag());
            existingUser.setSegment(accountDTO.getSegment());
            existingUser.setSector(accountDTO.getSector());
            existingUser.setSectorFlag(accountDTO.getSectorFlag());
            existingUser.setSusobj(accountDTO.getSusobj());
            existingUser.setSusobjFlag(accountDTO.getSusobjFlag());
            existingUser.setStakeEng(accountDTO.getStakeEng());
            existingUser.setStakeEngFlag(accountDTO.getStakeEngFlag());
            existingUser.setReportReq(accountDTO.getReportReq());
            existingUser.setReportReqFlag(accountDTO.getReportReqFlag());
            existingUser.setTimeline(accountDTO.getTimeline());
            existingUser.setTimelineFlag(accountDTO.getTimelineFlag());
            existingUser.setBudget(accountDTO.getBudget());
            existingUser.setEIAcomments(accountDTO.getEIAcomments());
            existingUser.setEIAcommFlag(accountDTO.getEIAcommFlag());
            existingUser.setBudgetFlag(accountDTO.getBudgetFlag());
            existingUser.setLegalVerificationComments(accountDTO.getLegalVerificationComments());
            existingUser.setFinancialHealthComments(accountDTO.getFinancialHealthComments());
            existingUser.setLegalverFlag(accountDTO.getLegalverFlag());
            existingUser.setFinancialHealthFlag(accountDTO.getFinancialHealthFlag());
            existingUser.setEsgCompliance(accountDTO.getEsgCompliance());
            existingUser.setEsgCompFlag(accountDTO.getEsgCompFlag());
            existingUser.setPincode(accountDTO.getPincode());
            existingUser.setLatitude(accountDTO.getLatitude());
            existingUser.setLongitude(accountDTO.getLongitude());
            existingUser.setBriefDtls(accountDTO.getBriefDtls());

            log.info("Updated user data (before save): {}", existingUser);

            // Save updated user
            accountNumRepository.save(existingUser);

            log.info("User updated successfully: {}", existingUser);
            log.info("=== End of Request ===");

            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            log.info("Error updating user: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating user: " + e.getMessage());
        }
    }


  
//   @PostMapping("updatedCmnt3/{accountNum}")
//    
//    public ResponseEntity<?> updateUserByCmnt(@PathVariable String accountNum, @RequestBody CmntDTO cmntDTO) {
//	      try {
//	    	  System.out.println("Received request to update user with accountnum: " + accountNum);
//    	  AccountNum existingUser = accountNumRepository.findByaccountNumber(accountNum);
//	          if (existingUser == null) {
//	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with Account num " + cmntDTO + " not found");
//	          }
//	          System.out.println("Existing user: " + existingUser);
//	          System.out.println("Updated user data: " + existingUser);
//	          if(cmntDTO.getAnnGHGComment()==null) {
//	        	  existingUser.setAnnGHGComment("");
//				}
//				else
//				{
//					existingUser.setAnnGHGComment(cmntDTO.getAnnGHGComment());
//				}
//	       
//          existingUser.setCo2Comment(cmntDTO.getCo2Comment());
//	          existingUser.setCapPlantComment(cmntDTO.getCapPlantComment());
//	          existingUser.setInfoStakeComnt(cmntDTO.getInfoStakeComnt());
//	          existingUser.setAnnEnergyCmnt(cmntDTO.getAnnEnergyCmnt());
//          existingUser.setEnergyPrePostcmnt(cmntDTO.getEnergyPrePostcmnt());
//          existingUser.setCleanVehicleCmnt(cmntDTO.getCleanVehicleCmnt());
//	          existingUser.setEstReductionCmnt(cmntDTO.getEstReductionCmnt());
//	          existingUser.setPollContCmnt(cmntDTO.getPollContCmnt());
//	          existingUser.setWaterUseCmnt(cmntDTO.getWaterUseCmnt());
//	          existingUser.setAnnLevelCmnt(cmntDTO.getAnnLevelCmnt());
//	          existingUser.setWaterPolluCmnt(cmntDTO.getWaterPolluCmnt());
//	          existingUser.setReductionWatercmnt(cmntDTO.getReductionWatercmnt());
//	          existingUser.setAnnualWaterCmnt(cmntDTO.getAnnualWaterCmnt());
//	          existingUser.setAnnualAmountCmnt(cmntDTO.getAnnualAmountCmnt());
//	          existingUser.setAreaLandCmnt(cmntDTO.getAreaLandCmnt());
//	          existingUser.setAreaSustainCmnt(cmntDTO.getAreaSustainCmnt());
//	          existingUser.setSustainableComnt(cmntDTO.getSustainableComnt());
//	          existingUser.setRestorelandCmnt(cmntDTO.getRestorelandCmnt());
//	          existingUser.setRestorehabitCmnt(cmntDTO.getRestorehabitCmnt());
//	          existingUser.setProtectAreaComnt(cmntDTO.getProtectAreaComnt());
//	          existingUser.setNaturalLandCmnt(cmntDTO.getNaturalLandCmnt());
//	          existingUser.setNumberTrgtCmnt(cmntDTO.getNumberTrgtCmnt());
//	          existingUser.setStatus("pending");
//	       // existingUser.setCurrentStatus("pending at Checker");
//          accountNumRepository.save(existingUser);
//		         
//	          System.out.println("User updated successfully: " + existingUser);
//	          return ResponseEntity.ok("User updated successfully");
//	      } catch (Exception e) {
//	    	  System.err.println("Error updating user: " + e.getMessage());
//	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
//	      }
//	      
//	      }
   @PostMapping("updatedCmnt3/{accountNum}")
   public ResponseEntity<?> updateUserByCmnt(@PathVariable String accountNum,
                                             @RequestBody CmntDTO cmntDTO) {
       try {
           AccountNum existingUser = accountNumRepository.findByaccountNumber(accountNum);
           if (existingUser == null) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body("User with Account num " + accountNum + " not found");
           }

           // update fields
           existingUser.setAnnGHGComment(cmntDTO.getAnnGHGComment() == null ? "" : cmntDTO.getAnnGHGComment());
           existingUser.setCo2Comment(cmntDTO.getCo2Comment());
           existingUser.setCapPlantComment(cmntDTO.getCapPlantComment());
           existingUser.setInfoStakeComnt(cmntDTO.getInfoStakeComnt());
           existingUser.setAnnEnergyCmnt(cmntDTO.getAnnEnergyCmnt());
           existingUser.setEnergyPrePostcmnt(cmntDTO.getEnergyPrePostcmnt());
           existingUser.setCleanVehicleCmnt(cmntDTO.getCleanVehicleCmnt());
           existingUser.setEstReductionCmnt(cmntDTO.getEstReductionCmnt());
           existingUser.setPollContCmnt(cmntDTO.getPollContCmnt());
           existingUser.setWaterUseCmnt(cmntDTO.getWaterUseCmnt());
           existingUser.setAnnLevelCmnt(cmntDTO.getAnnLevelCmnt());
           existingUser.setWaterPolluCmnt(cmntDTO.getWaterPolluCmnt());
           existingUser.setReductionWatercmnt(cmntDTO.getReductionWatercmnt());
           existingUser.setAnnualWaterCmnt(cmntDTO.getAnnualWaterCmnt());
           existingUser.setAnnualAmountCmnt(cmntDTO.getAnnualAmountCmnt());
           existingUser.setAreaLandCmnt(cmntDTO.getAreaLandCmnt());
           existingUser.setAreaSustainCmnt(cmntDTO.getAreaSustainCmnt());
           existingUser.setSustainableComnt(cmntDTO.getSustainableComnt());
           existingUser.setRestorelandCmnt(cmntDTO.getRestorelandCmnt());
           existingUser.setRestorehabitCmnt(cmntDTO.getRestorehabitCmnt());
           existingUser.setProtectAreaComnt(cmntDTO.getProtectAreaComnt());
           existingUser.setNaturalLandCmnt(cmntDTO.getNaturalLandCmnt());
           existingUser.setNumberTrgtCmnt(cmntDTO.getNumberTrgtCmnt());
           existingUser.setStatus("pending");

           // ✅ no need to call save() if entity is managed
            accountNumRepository.save(existingUser);

           return ResponseEntity.ok("User updated successfully");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error updating user: " + e.getMessage());
       }
   }

    
    @PostMapping("updatedPhase2/{accountNum}")
        public ResponseEntity<?> updateUserByAccountNumber(@PathVariable String accountNum, @RequestBody Phase2DTO accountDTO) {
	      try {
	    	  System.out.println("Received request to update user with accountnum: " + accountNum);
	    	  AccountNum existingUser = accountNumRepository.findByaccountNumber(accountNum);
	          if (existingUser == null) {
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with Account num " + accountDTO + " not found");
	          }
	    	

	          System.out.println("Existing user: " + existingUser);
	          System.out.println("Updated user data: " + existingUser);
	          existingUser.setCarbonintensive(accountDTO.getCarbonintensive());
	          existingUser.setCarbonintFlag(accountDTO.getCarbonintFlag());
	          existingUser.setVulnerability(accountDTO.getVulnerability());
	          existingUser.setVulnerabilityFlag(accountDTO.getVulnerabilityFlag());
	          existingUser.setSealevel(accountDTO.getSealevel());
	          existingUser.setSealevelFlag(accountDTO.getSealevelFlag());
	          existingUser.setAssetrisk(accountDTO.getAssetrisk());
	          existingUser.setAssestriskFlag(accountDTO.getAssestriskFlag());
	          existingUser.setSupplychain(accountDTO.getSupplychain());
	          existingUser.setSupplychainFlag(accountDTO.getSupplychainFlag());
	          existingUser.setShifting(accountDTO.getShifting());
	          existingUser.setShiftingFlag(accountDTO.getShiftingFlag());
	          existingUser.setBusiness(accountDTO.getBusiness());
	          existingUser.setBusinessFlag(accountDTO.getBusinessFlag());
	          existingUser.setClimate(accountDTO.getClimate());
	          existingUser.setClimateFlag(accountDTO.getClimateFlag());
	          existingUser.setBorroweremission(accountDTO.getBorroweremission());
	          existingUser.setBorrowermissionFlag(accountDTO.getBorrowermissionFlag());
	          
	          accountNumRepository.save(existingUser);
		         
	          System.out.println("User updated successfully: " + existingUser);
	          return ResponseEntity.ok("User updated successfully");
	      } catch (Exception e) {
	    	  System.err.println("Error updating user: " + e.getMessage());
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
	      }
	  }
    
 


    @GetMapping("/ViewDetailsLoan")
    public List<LoanDetails> getAllRecordsLoan() {
        return loanDetailsService.getAllRecordsLoan();
    }
    
    @PostMapping("/disbursements/{acct}")
    public List<LoanDetails> disbursements(@PathVariable String acct) {
        return loanDetailsService.getDisbRecordsByAcc(acct);
    }
    
    @PostMapping("/ViewDetailsLoanZone/{zone}")
    public List<LoanDetails> getAllRecordsLoanByZone(@PathVariable String zone) { 
    	return loanDetailsService.getAllRecordsLoanByZone(zone); }
  
    @GetMapping("/ViewDetailsDeposit")
    public List<DepositDetails> getAllRecordsDeposit(){
    	return depositDetailsService.getAllRecordsDeposit();
    	        }
    
//    @GetMapping("/ViewDetailsDepositCharts")
//    public List<PieChartDTO> ViewDetailsDepositCharts(){
//    	
//    	return depositDetailsService.getAllRecordsDepositForCharts();
//    	        }
    
   
    @GetMapping("/ViewDetailsDepositCharts/{startYear}")
    public List<PieChartDTO> ViewDetailsDepositCharts(@PathVariable("startYear") String startYear) {
        return depositDetailsService.getAllRecordsDepositForCharts(startYear);
    }

    
//    @GetMapping("/monthly-deposit-loan-chart") 
//    public List<DepositLoanChartDTO> viewMonthlyDepositLoanChart() {
//    	return reportService.getMonthlyDepositLoanData();
//    	}
//    @GetMapping("/monthly-deposit-loan-chart")
//    public List<LoanBarChartDTO> viewMonthlyDepositLoanChart() {
//        return reportService.getMonthlyDepositLoanData();
//    }
    
    
    @GetMapping("/monthly-deposit-loan-chart/{startYear}")
    public List<LoanBarChartDTO> viewMonthlyDepositLoanChart(@PathVariable int startYear) {
        return reportService.getMonthlyDepositLoanData(startYear);
    }

    

    @GetMapping("/daily-deposit-loan-chart/{month}/{year}")
    public List<LoanBarChartDailyDTO> viewDailyDepositLoanChart(@PathVariable String month,
                                                                    @PathVariable String year) {
        return reportService.getDailyDepositLoanData(month, year);
    }


//    @GetMapping("/ViewDetailsDepositMonthlyChart")
//    public List<BarChartDTO> viewMonthlyDepositChart() { 
//    	return depositDetailsService.getMonthlyDepositData();
//    	}
    
    
    
    
    
    
    
    
    @GetMapping("/ViewDetailsDepositMonthlyChart/{startYear}")
    public List<BarChartDTO> viewMonthlyDepositChart(@PathVariable int startYear) {
        return depositDetailsService.getMonthlyDepositData(startYear);
    }


    
    
    
    
    
    
    
    @GetMapping("/ViewDetailsDepositDailyChart/{month}/{year}")
    public List<BarChartDailyDTO> ViewDetailsDepositDailyChart(@PathVariable String month,@PathVariable String year) { 
    	return depositDetailsService.getDailyDepositData(month,year);
    }
    
    //                  mar2-------------------------------
//    @GetMapping("/ViewDetailsDepositLineChart")
//    public List<LineChartDTO> viewCumulativeMonthlyDepositChart() {
//        return depositDetailsService.getCumulativeMonthlyDepositData();
//          
//    }
    
    @GetMapping("/ViewDetailsDepositLineChart/{startYear}")
    public List<LineChartDTO> viewCumulativeMonthlyDepositChart(@PathVariable int startYear) {
        return depositDetailsService.getCumulativeMonthlyDepositData(startYear);
    }

    
//    @GetMapping("/ViewDetailsLoanLineChart") 
//    public List<LineChartDTO> viewCumulativeMonthlyLoanChart() { 
//    	return loanDetailsService.getCumulativeMonthlyLoanData();
//    	}
    
    @GetMapping("/ViewDetailsLoanLineChart/{startYear}")
    public List<LineChartDTO> viewCumulativeMonthlyLoanChart(@PathVariable int startYear) {
        return loanDetailsService.getCumulativeMonthlyLoanData(startYear);
    }

    
    
    
    
    
    
    
    
//    @GetMapping("/ViewDetailsDepositVsLoanLineChart")
//    public List<DepositLoanLineChartDTO> viewCumulativeDepositVsLoanChart() {
//        return reportService.getCumulativeDepositVsLoanData();
//    }
//--------------------march-----------------------------------------
//    @GetMapping("/ViewDetailsDepositVsLoanLineChart")
//    public List<DepositLoanLineChartDTO> viewDepositVsLoanChart(@RequestParam String fromDate, @RequestParam String toDate) {
//    	return reportService.getDepositVsLoanData(fromDate, toDate);
//    	}
    
    @GetMapping("/ViewDetailsDepositVsLoanLineChart/{startYear}")
    public List<DepositLoanLineChartDTO> viewDepositVsLoanChart(@PathVariable int startYear) {
        return reportService.getDepositVsLoanData(startYear);
    }

    
    
    
    @PostMapping("/ViewDetailsDepositDatewise/{todate}/{fromdate}")
    public List<DepositDetails> getAllRecordsDepositDateWise(@PathVariable String todate,@PathVariable String fromdate){
    	
    	return depositDetailsService.getAllRecordsDepositDateWise(todate,fromdate);
    	        }
    
    
    
    @PostMapping("/ViewDetailsLoanDatewise/{todate}/{fromdate}")
    public List<LoanDetails> getAllRecordsLoanDateWise(@PathVariable String todate, @PathVariable String fromdate) {
        return loanDetailsService.getAllRecordsLoanDateWise(todate, fromdate);
    }

    
    
//    @GetMapping("/ViewDetailsLoanCharts")
//    public List<LoanChartDTO> ViewDetailsLoanCharts() {
//    	return loanDetailsService.getAllRecordsLoanForCharts();
//    	}
//    
    
    
    @GetMapping("/ViewDetailsLoanCharts/{startYear}")
    public List<LoanChartDTO> viewLoanChart(@PathVariable int startYear) {
        return loanDetailsService.getLoanData(startYear);
    }

//    @GetMapping("/ViewDetailsSegmentCharts")
//    public List<SegmentChartDTO> ViewDetailsSegmentCharts() {
//        return loanDetailsService.getAllRecordsSegmentForCharts();
//    }

    
    
    @GetMapping("/ViewDetailsSegmentCharts/{startYear}")
    public List<SegmentChartDTO> viewSegmentChart(@PathVariable int startYear) {
        return loanDetailsService.getSegmentData(startYear);
    }


//    @GetMapping("/ViewDetailsSchemeActivityCharts")
//    public List<SchemeActivityChartDTO> ViewDetailsSchemeActivityCharts() {
//        return loanDetailsService.getAllRecordsSchemeActivityForCharts();
//    }

    @GetMapping("/ViewDetailsSchemeActivityCharts/{startYear}")
    public List<SchemeActivityChartDTO> viewSchemeActivityChart(@PathVariable int startYear) {
        return loanDetailsService.getSchemeActivityData(startYear);
    }

    
    
    
    @GetMapping("ViewDetails")
    public List<AccountNum> getAllRecords(){
    	return accountNumService.getAllRecords();
    	        }
    
    
    @GetMapping("ViewDetailsAdmin")
    public List<AccountNum> getAllRecordsAdmin(){
    	return accountNumService.findAllrecordAdmin();
    	        }
    
    @GetMapping("ViewDetailsReport")
    public List<AccountNum> getAllRecordsReport(){
    	return accountNumService.findAllrecordReport();
    	        }
    
    @GetMapping("ViewDetailsReportQueriedAdmin")
    public List<AccountNum> getAllRecordsQueriedAdmin(){
    	return accountNumService.findAllrecordQueriedAdmin();
    	        }
    @GetMapping("ViewDetailsReturn")
    public List<AccountNum> getAllRecordsReturnMaker(){
    	return accountNumService.getAllRecordsReturn();
    	        }
    
    


    
//    @PostMapping("updatedChecker/{accountNum}")
//      public ResponseEntity<?>UpdateChecker(@PathVariable String accountNum, @RequestBody AccountDTO accountDTO) {
//	      try {
//	    	  System.out.println("accepted by maker: " + accountNum);
//	    	  AccountNum existingUser = accountNumRepository.findByaccountNumber(accountNum);
//	          if (existingUser == null) {
//	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with Account num " + accountDTO + " not found");
//	          }
//	      }
//	          catch (Exception e) {
//		    	  System.err.println("Error updating user: " + e.getMessage());
//		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
//		      }
//    }
//    
//    @PostMapping("/save/{accountNum}")
//    public ResponseEntity<AccountNum> saveOrUpdate(@RequestBody AccountNum accountNum) {
//    	
//    	
//    	AccountNum savedAccount = accountNumService .saveOrUpdateForm(accountNum);
//        return ResponseEntity.ok(savedAccount);
//    }
//    
//		try {
//			log.info("receiving data : "+ accountNum);
//			//    		saveModel.setCurrStatus(currStatus);
//			accountNumRepository.save(accountNum);
//			return ResponseEntity.ok(accountNum);   		
//		} catch (Exception e) {
//			return ResponseEntity.status(500).body(null);
//		}
	
//    @PostMapping("/uploading/{accountNum}")
//    public ResponseEntity<AccountNum> uploadFile(@RequestParam String AccountNumber, 
//  		  @RequestParam("EIAfile") MultipartFile EIAfile,@RequestParam("legalVerificationFile") MultipartFile legalVerificationFile,
//  		@RequestParam("financialHealthFile") MultipartFile financialHealthFile,
//  		@RequestParam("ESGfile") MultipartFile ESGfile) {
//  	  System.out.println("Api calling");
//        try {
//      	//  System.out.println("Api calling");
////      	  MultipartFile stuFile = Stufile.getStufile();
////      	  String email = Stufile.getEmail();
//            if (EIAfile.isEmpty() || legalVerificationFile.isEmpty()|| financialHealthFile.isEmpty()||ESGfile.isEmpty()||
//            		!EIAfile.getContentType().equals("application/pdf") || !legalVerificationFile.getContentType().equals("application/pdf")||
//            		!financialHealthFile.getContentType().equals("application/pdf")||!ESGfile.getContentType().equals("application/pdf")) {
//            	
//            	
////                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
//          	  return ResponseEntity.status(500).body(null);
//            }
//            
//            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
//			if(upload2.isPresent())
//			{
//				AccountNum accountNum=upload2.get();
//				System.out.println(EIAfile.getBytes());
//				
//			//	byte[] fileBytes = EIAfile.getBytes();
//				
//				
//			//	System.out.println("fileBytes : "+fileBytes);
//				
//	            // Store files as byte arrays
//				accountNum.setEIAfile(EIAfile.getBytes());
//				accountNum.setLegalVerificationFile(legalVerificationFile.getBytes());
//				accountNum.setFinancialHealthFile(financialHealthFile.getBytes());
//				accountNum.setESGfile(ESGfile.getBytes());
//				
//				// String fileName = EIAfile.getOriginalFilename();
//			       // Store file names
//				accountNum.setEIAFileName(EIAfile.getOriginalFilename());
//				accountNum.setLegalVerificationFileName(legalVerificationFile.getOriginalFilename());
//				accountNum.setFinancialFileName(financialHealthFile.getOriginalFilename());
//				accountNum.setESGFileName(ESGfile.getOriginalFilename());
//				 
//				
//			
//			//Student up = upload2.get();
//           
//            //studentService.uploadFile(email, Stufile);
//				 
//				// Save entity
//				accountNumRepository.save(accountNum);
//            
//            return ResponseEntity.ok(accountNum);
//			}} catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                                 .body("Error while uploading file: " + e.getMessage());
//      	  return ResponseEntity.status(500).body(null);
//        }
//		return null;
//		
//		
//
//    }
    



    
    //------------------------------deepali code/////////////////////////////////////////
//    @PostMapping("/uploadingEIA")
//    public ResponseEntity<?> uploadFileEIA(@RequestParam String AccountNumber,
//                                           @RequestParam("EIAfile") MultipartFile EIAfile) {
//        try {
//            if (EIAfile == null || EIAfile.isEmpty()) {
//                return ResponseEntity.badRequest().body("File is empty");
//            }
//
//            String contentType = EIAfile.getContentType();
//            String originalFilename = EIAfile.getOriginalFilename();
//            System.out.println("AccountNumber: " + AccountNumber);
//            System.out.println("Uploaded file name: " + originalFilename);
//            System.out.println("Uploaded file content type: " + contentType);
//
//            // accept if MIME type contains "pdf" OR filename ends with ".pdf"
//            if ((contentType == null || !contentType.toLowerCase().contains("pdf")) &&
//                (originalFilename == null || !originalFilename.toLowerCase().endsWith(".pdf"))) {
//                return ResponseEntity.badRequest().body("Please upload a valid PDF file");
//            }
//
//            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
//            if (upload2.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                     .body("Account number not found");
//            }
//
//            AccountNum accountNum = upload2.get();
//            accountNum.setEIAfile(EIAfile.getBytes());
//            accountNum.setEIAFileName(originalFilename);
//            accountNumRepository.save(accountNum);
//
//            return ResponseEntity.ok("File uploaded successfully for account " + AccountNumber);
//        } catch (Exception e) {
//            e.printStackTrace(); // log the real error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                 .body("Unexpected error while uploading file: " + e.getMessage());
//        }
//    }

//-------------------------------------------------------//
//--------------------------deeepali -----------------------------------------//
//    @PostMapping("/uploadingLegal")
//    public ResponseEntity<AccountNum> uploadFileLegal(@RequestParam String AccountNumber, 
//	  @RequestParam("legalVerificationFile") MultipartFile legalVerificationFile) {
//  	  System.out.println("Api calling");
//        try {
//      	//  System.out.println("Api calling");
////      	  MultipartFile stuFile = Stufile.getStufile();
////      	  String email = Stufile.getEmail();
//            if (legalVerificationFile.isEmpty() || !legalVerificationFile.getContentType().equals("application/pdf")) {
////                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
//          	  return ResponseEntity.status(500).body(null);
//            }
//            
//            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
//			if(upload2.isPresent())
//			{
//				AccountNum accountNum=upload2.get();
//				System.out.println(legalVerificationFile.getBytes());
//				
//				byte[] fileBytes = legalVerificationFile.getBytes();
//				System.out.println("fileBytes : "+fileBytes);
//				
//				accountNum.setLegalVerificationFile(fileBytes);
//				 String fileName = legalVerificationFile.getOriginalFilename();
//				 accountNum.setLegalVerificationFileName(fileName);
//				
//			
//			//	Student up = upload2.get();
//           
//            //studentService.uploadFile(email, Stufile);
//				 accountNumRepository.save(accountNum);
//            
//            return ResponseEntity.ok(accountNum);
//			}} catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                                 .body("Error while uploading file: " + e.getMessage());
//      	  return ResponseEntity.status(500).body(null);
//        }
//		return null;
//		
//		
//
//    }
//  @PostMapping("/uploadingFinancial")
//  public ResponseEntity<AccountNum> uploadFileFinancial(@RequestParam String AccountNumber, 
//	  @RequestParam("financialHealthFile") MultipartFile financialHealthFile) {
//	  System.out.println("Api calling");
//      try {
//    	//  System.out.println("Api calling");
////    	  MultipartFile stuFile = Stufile.getStufile();
////    	  String email = Stufile.getEmail();
//          if (financialHealthFile.isEmpty() || !financialHealthFile.getContentType().equals("application/pdf")) {
////              return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
//        	  return ResponseEntity.status(500).body(null);
//          }
//          
//          Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
//			if(upload2.isPresent())
//			{
//				AccountNum accountNum=upload2.get();
//				System.out.println(financialHealthFile.getBytes());
//				
//				byte[] fileBytes = financialHealthFile.getBytes();
//				System.out.println("fileBytes : "+fileBytes);
//				
//				accountNum.setFinancialHealthFile(fileBytes);
//				 String fileName = financialHealthFile.getOriginalFilename();
//				 accountNum.setFinancialFileName(fileName);
//				
//			
//			//	Student up = upload2.get();
//         
//          //studentService.uploadFile(email, Stufile);
//				 accountNumRepository.save(accountNum);
//          
//          return ResponseEntity.ok(accountNum);
//			}} catch (Exception e) {
////          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                               .body("Error while uploading file: " + e.getMessage());
//    	  return ResponseEntity.status(500).body(null);
//      }
//		return null;
//				
//  }
//----------------------------------------------------------------//
    
    
    
    @PostMapping("/uploadingEIA")
    public ResponseEntity<?> uploadFileEIA(@RequestParam String AccountNumber,
                                           @RequestParam("EIAfile") MultipartFile EIAfile) {
        try {
            if (EIAfile.isEmpty() || !EIAfile.getContentType().toLowerCase().contains("pdf")) {
                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
            }

            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
            if (upload2.isPresent()) {
                AccountNum accountNum = upload2.get();
                accountNum.setEIAfile(EIAfile.getBytes());
                accountNum.setEIAFileName(EIAfile.getOriginalFilename());

                // No need to call save() again — Hibernate will flush changes automatically
                return ResponseEntity.ok(accountNum);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while uploading file: " + e.getMessage());
        }
    }
    @PostMapping("/uploadingLegal")
    public ResponseEntity<?> uploadFileLegal(@RequestParam String AccountNumber,
                                             @RequestParam("legalVerificationFile") MultipartFile legalVerificationFile) {
        try {
            // Validate file
            if (legalVerificationFile.isEmpty() ||
                !legalVerificationFile.getContentType().toLowerCase().contains("pdf")) {
                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
            }

            // Find account by number
            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
            if (upload2.isPresent()) {
                AccountNum accountNum = upload2.get();

                // Update file fields
                accountNum.setLegalVerificationFile(legalVerificationFile.getBytes());
                accountNum.setLegalVerificationFileName(legalVerificationFile.getOriginalFilename());

                // No need to call save() again if entity is managed
                return ResponseEntity.ok(accountNum);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while uploading file: " + e.getMessage());
        }
    }
    @PostMapping("/uploadingFinancial")
    public ResponseEntity<?> uploadFileFinancial(@RequestParam String AccountNumber,
                                                 @RequestParam("financialHealthFile") MultipartFile financialHealthFile) {
        try {
            // Validate file
            if (financialHealthFile.isEmpty() ||
                !financialHealthFile.getContentType().toLowerCase().contains("pdf")) {
                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
            }

            // Find account by number
            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
            if (upload2.isPresent()) {
                AccountNum accountNum = upload2.get();

                // Update file fields
                accountNum.setFinancialHealthFile(financialHealthFile.getBytes());
                accountNum.setFinancialFileName(financialHealthFile.getOriginalFilename());

                // No need to call save() again if entity is managed
                return ResponseEntity.ok(accountNum);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while uploading file: " + e.getMessage());
        }
    }

    @PostMapping("/uploadingESG")
    public ResponseEntity<?> uploadFileESG(@RequestParam String AccountNumber,
                                           @RequestParam("ESGfile") MultipartFile ESGfile) {
        try {
            // Validate file
            if (ESGfile.isEmpty() || !ESGfile.getContentType().toLowerCase().contains("pdf")) {
                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
            }

            // Find account by number
            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
            if (upload2.isPresent()) {
                AccountNum accountNum = upload2.get();

                // Update file fields
                accountNum.setESGfile(ESGfile.getBytes());
                accountNum.setESGFileName(ESGfile.getOriginalFilename());

                // No need to call save() again if entity is managed
                return ResponseEntity.ok(accountNum);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while uploading file: " + e.getMessage());
        }
    }

    
//    @PostMapping("/uploadingESG")
//    public ResponseEntity<AccountNum> uploadFileESG(@RequestParam String AccountNumber, 
//	  @RequestParam("ESGfile") MultipartFile ESGfile) {
//  	  System.out.println("Api calling");
//        try {
//      	//  System.out.println("Api calling");
////      	  MultipartFile stuFile = Stufile.getStufile();
////      	  String email = Stufile.getEmail();
//            if (ESGfile.isEmpty() || !ESGfile.getContentType().equals("application/pdf")) {
////                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
//          	  return ResponseEntity.status(500).body(null);
//            }
//            
//            Optional<AccountNum> upload2 = accountNumRepository.findByAccountNumber(AccountNumber);
//			if(upload2.isPresent())
//			{
//				AccountNum accountNum=upload2.get();
//				System.out.println(ESGfile.getBytes());
//				
//				byte[] fileBytes = ESGfile.getBytes();
//				System.out.println("fileBytes : "+fileBytes);
//				
//				accountNum.setESGfile(fileBytes);
//				 String fileName = ESGfile.getOriginalFilename();
//				 accountNum.setESGFileName(fileName);
//				
//			
//			//	Student up = upload2.get();
//           
//            //studentService.uploadFile(email, Stufile);
//				 accountNumRepository.save(accountNum);
//            
//            return ResponseEntity.ok(accountNum);
//			}} catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                                 .body("Error while uploading file: " + e.getMessage());
//      	  return ResponseEntity.status(500).body(null);
//        }
//		return null;
//		
//		
//
//    }
    
//    @PutMapping("/{id}/cmnt")
//    public ResponseEntity<String>updateUserStatus(@PathVariable Long id, @RequestParam String Cmnt){
//    	int updated = greenSectorService.updateCmnt(id,Cmnt);
//    	if(updated > 0)
//    	{
//    		return ResponseEntity.ok("comment update successful");
//    	}
//    	else {
//    		return ResponseEntity.badRequest().body("user not found");
//    	}
//    }

//working code
//	  @PostMapping("/pickdata/{accountNum}")
//	    public AccountNum getUserByAccountNum(@PathVariable  String accountNum) {
//	        // Fetch user by email using the service
//		  //AccountNum user = accountNumService.getLoanUserByAccountNumber(accountNum);
//		  //List<AccountNum>
//		  AccountNum user = new AccountNum();
//		  try {
//		  
//	        LoanDetails loan = loanDetailsRepository.findLatestDisbursementByForacid(accountNum);
//	        
//	        System.out.println("loan : "+loan.toString());
//	       if(loan!=null) {
//	        user.setBorrowerName(loan.getAccountName());
//	        user.setBranchName(loan.getSolDesc());
//	        user.setPanNumber(loan.getPan());
//	        user.setCinNumber(loan.getCin());
//	        user.setSchemeCode(loan.getSchemeCode());
//	        user.setActivityCode(loan.getActivityCode());
//	       }
//		  }catch(Exception e) {
//			  log.error("error : "+e);
//		  }
//	        
//	         return user;
//	    }
	//working code  
    
    
//    @PostMapping("/pickdata/{accountNum}")
//    public AccountNum getUserByAccountNum(@PathVariable  String accountNum) {
//        // Fetch user by email using the service
//	  //AccountNum user = accountNumService.getLoanUserByAccountNumber(accountNum);
//	  //List<AccountNum>
//	  AccountNum user = new AccountNum();
//	  try {
//	  
//		  <Optional>AccountNum loan = accountNumRepository.findByAccountNumber(accountNum);
//        
//        System.out.println("loan : "+loan.toString());
//       if(loan!=null) {
//        user.setBorrowerName(loan.getBorrowerName());
//        user.setBranchName(loan.getBranchName());
//        user.setPanNumber(loan.getPanNumber());
//        user.setCinNumber(loan.getCinNumber());
//        user.setSchemeCode(loan.getSchemeCode());
//        user.setActivityCode(loan.getActivityCode());
//       }
//	  }catch(Exception e) {
//		  log.error("error : "+e);
// }
//        
//         return user;
//    }
    
    
    
    
    
  //  feb2 working---------------  
    @GetMapping("/pickdata/{accountNum}")
    public ResponseEntity<AccountNum> getUserByAccountNum(@PathVariable String accountNum) {
        try {
        	AccountNum loanOpt= new AccountNum();
        	System.out.println("accountNum.trim()"+accountNum.trim());
           // Optional<AccountNum> loanOpt = accountNumRepository.findByAccountNumber(accountNum.trim());
        	 loanOpt = accountNumRepository.fetchAccountDetails(accountNum.trim());
            if (loanOpt!=null) {
                
                System.out.println("fetching data : "+loanOpt);
                return ResponseEntity.ok(loanOpt); // return the actual entity
            } else {
                System.out.println("No record found for accountNum: " + accountNum);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("error : " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
 //----------------------------------------------------------------------------  
    
    
 

        // 2️⃣ New endpoint: fetch all account numbers (for dropdown)
//        @GetMapping("/accountNumbers")
//        public ResponseEntity<List<String>> getAccountNumbers() {
//            try {
//                List<String> accountNumbers = accountNumService.getAllAccountNumbers();
//                if (accountNumbers.isEmpty()) {
//                    return ResponseEntity.noContent().build();
//                }
//                return ResponseEntity.ok(accountNumbers);
//            } catch (Exception e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            }
//        }

      /////-------------------------------------------------------// 
//    @GetMapping("/accountNumbers")
//    public ResponseEntity<List<String>> getAccountNumbers(
//            @RequestParam String solId,
//            @RequestParam(defaultValue = "null") String status) {
//        try {
//            List<String> accountNumbers = accountNumService.getAccountNumbersBySolIdAndStatus(solId, status);
//            return ResponseEntity.ok(accountNumbers);  // 👈 always return 200 with list (empty if none)
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }



    @GetMapping("/accountNumbers")
    public ResponseEntity<List<String>> getAccountNumbers(
            @RequestParam String solId,
            @RequestParam(required = false) String status) {
        try {
            List<String> accountNumbers = accountNumService.getAccountNumbersBySolIdAndStatus(solId, status);
            return ResponseEntity.ok(accountNumbers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    
    
    

//	  @PostMapping("/fetchLoan/{accountNum}")
//	  	public Optional<LoanDetails>getUserByLoan(@PathVariable String accountNum){
//		  Optional<LoanDetails> user = loanDetailsService.getUserByLoan(accountNum);
//		  
//	        if (user==null) {
//	            try {
//					throw new ResourceNotFoundException("User with accountNumber " + accountNum + " not found");
//				} catch (ResourceNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	         return user;
//	  }
	  
//	  @PostMapping("/DepositLoan/{schemecode}")
//	  	public List<DepositDetails>getUserByDeposit(@PathVariable String schemecode){
//		  List<DepositDetails> user = depositDetailsService.getUserByDeposit(schemecode);
//		  
//	        if (user==null) {
//	            try {
//					throw new ResourceNotFoundException("User with accountNumber " + schemecode + " not found");
//				} catch (ResourceNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	         return user;
//	  }

	  @GetMapping("/download/{accountNumber}")
	    public Optional<AccountNum> getUserByAccountNumber(@PathVariable  String accountNumber) {
	        // Fetch user by email using the service
		  Optional<AccountNum> user = accountNumService.getUserByAccountNumber(accountNumber);
		  
	        if (user==null) {
	            try {
					throw new ResourceNotFoundException("User with accountNumber " + accountNumber + " not found");
				} catch (ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	         return user;
	    }
//	  @PostMapping("/pickdataChecker")
//	    public Optional<AccountNum> getUserByAccountNumChecker(@PathVariable  String accountNum) {
//	        // Fetch user by email using the service
//		  Optional<AccountNum> user = accountNumService.getUserByAccountNumber(accountNum);
//		  
//	        if (user==null) {
//	            try {
//					throw new ResourceNotFoundException("User with accountNumber " + accountNum + " not found");
//				} catch (ResourceNotFoundException e) {
//					// 

//					e.printStackTrace();
//				}
//	        }
//	 
//	        return user;
//	    }
	  
	 @GetMapping("/pending")
	 public List<AccountNum> getAllPendingDetails(){
		 return accountNumService.getPendingTransaction();
	 }
	 
		 @GetMapping("/verified")
	 public List<AccountNum> getAllVerifiedDetails(){
		 return accountNumService.getVerifiedTransaction();
	 }
	 
	 @PostMapping("/AdminCmnt")
	 public AccountNum AdminCmnt(@RequestBody HistoryCmntDTO historyCmntDTO) {
	 	 return accountNumService.AdminCmnt(historyCmntDTO);
	 }
	 
//	 @PostMapping("/submitMaker/{accountNumber}")
//	  public AccountNum submitMaker(@RequestBody CmntDTO cmntDTO) {
//		  return accountNumService.updateCmnts(cmntDTO);
//	  }
//	 
	  @GetMapping("/{accountNumber}")
	  public Optional<AccountNum> getRecordsByAccountNumber(@PathVariable String accountNumber){
		  return accountNumService.getRecordsByAccountNumber(accountNumber);
	  }
	  
	  
	  
	  
	  @GetMapping("/admin/{accountNumber}")
	  public Optional<AccountNum> getRecordsByAccountNumberAdmin(@PathVariable String accountNumber){
		  return accountNumService.getRecordsByAccountNumber(accountNumber);
	  }
	  
	 
//	  @PostMapping("/checker/{accountNumber}")
//	  public AccountNum updateCheckerDtls(@RequestBody CheckerDTO checkerDTO) {
//		  return accountNumService.updateChecker(checkerDTO);
//	  }
//	  
	  
	  @PostMapping("/checker/{accountNumber}")
	  public AccountNum updateCheckerDtls(@RequestBody CheckerDTO checkerDTO,@RequestParam String accountNumb,
			   @RequestParam String userRole) {
		  return accountNumService.updateChecker(checkerDTO, userRole);
	  }
	  
	  @PostMapping("/AdminDtls/{accountNumber}")
	  public AccountNum updateAdminDtls(@RequestBody FlagDTO accountNumber,@RequestParam String accountNumb,
			    @RequestParam String userRole) {
		  return accountNumService.UpdateAdmin(accountNumb, accountNumber,userRole);
	  }
	  
 		  	  
	@GetMapping("/pickdataSusObj/{SustainObj}")
	    public List<GreenSector> getUserBySector(@PathVariable  String SustainObj) {
	        // Fetch user by email using the service
		  List<GreenSector> user = greenSectorService.getUserBySector(SustainObj);
		  
	        if (user==null) {
	            try {
					throw new ResourceNotFoundException("User with sector " + SustainObj + " not found");
				} catch (ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	 
	        return user;
	        
	    }
	@GetMapping("/pickdataSustain/{susobj}")
    public List<GreenSector> getUserBySectordownload(@PathVariable  String susobj) {
        // Fetch user by email using the service
	  List<GreenSector> user = greenSectorService.getUserBySector(susobj);
	  
        if (user==null) {
            try {
				throw new ResourceNotFoundException("User with sector " + susobj + " not found");
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
 
        return user;
        
    }  

//	  
//	  @PostMapping("/downloadEIA/{accountNum}")
//	    public ResponseEntity<byte[]> downloadFileEIA(@PathVariable String accountNum) {
//	        try {
//	        	AccountNum file =accountNumService.getUserByAccountNum(accountNum);
//	        	
//	        	if (file == null || file.getEIAfile() == null) {
//	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	            }
//	 
//	            // Set headers for the response
//	            HttpHeaders headers = new HttpHeaders();
//	            headers.add("Content-Disposition", "attachment; filename=\"" + file.getEIAFileName() + "\"");
//	 
//	            return new ResponseEntity<>(file.getEIAfile(), headers, HttpStatus.OK);
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	        }
//	    }
//	    
//	   
//	    
//	    @PostMapping("/downloadLegal/{accountNum}")
//	    public ResponseEntity<byte[]> downloadFileLegal(@PathVariable String accountNum) {
//	        try {
//	        	AccountNum file =accountNumService.getUserByAccountNum(accountNum);
//	        	
//	        	if (file == null || file.getEIAfile() == null) {
//	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	            }
//	 
//	            // Set headers for the response
//	            HttpHeaders headers = new HttpHeaders();
//	            headers.add("Content-Disposition", "attachment; filename=\"" + file.getLegalVerificationFileName() + "\"");
//	 
//	            return new ResponseEntity<>(file.getLegalVerificationFile(), headers, HttpStatus.OK);
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	        }
//	    }
//	    
//	    
//	    @PostMapping("/downloadfinance/{accountNum}")
//	    public ResponseEntity<byte[]> downloadFilefinance(@PathVariable String accountNum) {
//	        try {
//	        	AccountNum file =accountNumService.getUserByAccountNum(accountNum);
//	        	
//	        	if (file == null || file.getEIAfile() == null) {
//	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	            }
//	 
//	            // Set headers for the response
//	            HttpHeaders headers = new HttpHeaders();
//	            headers.add("Content-Disposition", "attachment; filename=\"" + file.getFinancialHealthFile() + "\"");
//	 
//	            return new ResponseEntity<>(file.getFinancialHealthFile(), headers, HttpStatus.OK);
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	        }
//	    }
//	    
//	    @PostMapping("/downloadESG/{accountNum}")
//	    public ResponseEntity<byte[]> downloadFileESG(@PathVariable String accountNum) {
//	        try {
//	        	AccountNum file =accountNumService.getUserByAccountNum(accountNum);
//	        	
//	        	if (file == null || file.getEIAfile() == null) {
//	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	            }
//	 
//	            // Set headers for the response
//	            HttpHeaders headers = new HttpHeaders();
//	            headers.add("Content-Disposition", "attachment; filename=\"" + file.getESGFileName() + "\"");
//	 
//	            return new ResponseEntity<>(file.getESGfile(), headers, HttpStatus.OK);
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	        }
//	    }
//	    
	    
//	    @PostMapping("/AllDetails")
//	    public ResponseEntity<byte[]> UserByFinalFlag(@PathVariable String finalFlag){
//	    	 List<AccountNum> userDtls = accountNumRepository.findByFinalFlag(finalFlag);
//	    	 if (userDtls == null || userDtls.isEmpty() ) {
//		            throw new RuntimeException("Final Flag " + finalFlag + " not found");
//		        }
//	    	
//	    		 for(AccountNum user : userDtls) {
//	    			 
//	    		 
//	    		 userDtls.setfinalflag("completed");
//	    		 
//	    		 return accountNumRepository.saveAll(userDtls);
//	    	 }
//	    }	    
	    
//	    @PostMapping("/AllAccount")
//	    public List<String> getAllAccountNumber(){
//	    	return accountNumService.getAllAccountNumbers();
//	    }

	    
//	  @PostMapping("/pickfile/{accountNum}")
//	    public Optional<GreenFile> getUserByAccountNumber(@PathVariable  String AccountNum) {
//	        // Fetch user by email using the service
//		  Optional<GreenFile> user = greenFileService.getUserByAccountNumber(AccountNum);
//		  
//	        if (user==null) {
//	            try {
//					throw new ResourceNotFoundException("User with accountNumber " + AccountNum + " not found");
//				} catch (ResourceNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	 
//	        return user;
//	    }
	  
//    @PostMapping("/getdata/{accountNum}")
//    public AccountNum getUserByAccountNum(@RequestParam String accountNum) {
//        // Fetch user by account num using the service
//	  AccountNum user = accountNumService.getUserByAccountNumber(accountNum);
//        if (user==null) {
//            try {
//				throw new ResourceNotFoundException("User with email " + accountNum + " not found");
//			} catch (ResourceNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
// 
//        return user;
//  }
    
    @GetMapping("/cfs")
    public ResponseEntity<List<String>> getCFSZoneList(){
    	List<String> cfs = allSolMasterRepository.findByCategory();
    	return ResponseEntity.ok(cfs);
    }
    
    

    

    
    public boolean isValidMob(String mob) {
    	return mob!=null && mob.matches("^[6789]\\d{9}$");
    }

    
    private Long generateUniqueNumericId() {
    	return System.currentTimeMillis();
    }
    
    
    
    @PostMapping("/accountStatement")
    public ResponseEntity<String> processData(@RequestBody Map<String, String> request){
    	log.info("values recived "+request);
    	
    	
    	String response ="";
    	if(request != null) {
    		String startDate = request.get("startDate");
        	String endDate = request.get("endDate");
        	
        	
			CommonUtils.disableSslVerification();
			// Finacle Request Begin
			
			Long timeInMilliSeconds = Calendar.getInstance().getTimeInMillis();
			Long timeInMilliSecondsVal = Calendar.getInstance().getTimeInMillis();
			StringBuffer sb = new StringBuffer();
			sb.append("Req_");
			sb.append(timeInMilliSeconds);
			StringBuffer sb1 = new StringBuffer();
			sb1.append("Req_");
			sb1.append(timeInMilliSecondsVal);
			
			try {
				List<String> accountNumbers =  accountDetailsRepository.findAllAccountNumber();
				
				for (String accNo: accountNumbers) {
					String formattedRequest = "AADHAARSTMT|"+accNo+"|"+startDate+"|"+endDate+"|";
					String UID = accNo;
					String AccountNumber = accNo;
					
					response = cbsApi(formattedRequest, UID);
					
					log.info("getting response"+response);
					
					JSONObject responseJSON = new JSONObject(response);
					
					
					if("SUCCESS".equalsIgnoreCase(responseJSON.getString("RESPCODE"))) {
						
						String result = responseJSON.getString("RESULT");
						
						log.info("Getting data from cbs api "+result);
						
						String[] records = result.split("~");
						for(String record : records) {
							if(!record.isEmpty()) {
								saveRecordToDatabase(record.trim(), AccountNumber);
								log.info("Data saved successfully");
							}
						}
					}else {
						return ResponseEntity.status(500).body("Error : Invalid response code form the CBS API");
					}
					
				}
				return ResponseEntity.ok("Data Processed and saved successfully");
			} catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(500).body("Error processing data");
			}
			
			
    		
    	}
    	return null;
    	
    }
	
		
		
		private String cbsApi(String formattedRequest, String UID) {
			
			String response = "";
		try {
			CommonUtils.disableSslVerification();
		
			Long timeInMilliSeconds = Calendar.getInstance().getTimeInMillis();
			
			
			StringBuffer sb = new StringBuffer();
			sb.append("Req_");
			sb.append(timeInMilliSeconds);
			
			String finRequest = configService.getfiDedup();
			String fiDedupUrl = configService.getfiUrl();
			
			finRequest = finRequest.replace("PARAM_ACCT", formattedRequest);
			finRequest = finRequest.replace("PARAM_REQ_ID", sb.toString());
			finRequest = finRequest.replace("PARAM_UID", UID);
			
			System.out.println("Sending request to Finacle : "+finRequest);
			
			String responseXML = CommonUtils.callRestWS(fiDedupUrl, "", "application/xml", "application/xml", finRequest);
			
			  // Process Response
	        if (responseXML.contains(AppConstant.TAG_ERROR_DETAIL_BEGIN)) {
	            response = extractErrorDetails(responseXML);
	        } else if (responseXML.contains(AppConstant.SPLIT_FIN_RESP_ID_BEGIN)) {
	            response = extractSuccessDetails(responseXML);
	        } else {
	            response = "CBS Error in Account Validation.";
	        }
	    } catch (Exception e) {
	        log.error("Error while calling Finacle API", e);
	        response = "Error while processing request";
	    }
	    return response;
	}
			
		
    	
    	
		// Extract Error Details
		private String extractErrorDetails(String responseXML) {
		    String errorDetail = responseXML.substring(
		        responseXML.indexOf(AppConstant.TAG_ERROR_DETAIL_BEGIN) + AppConstant.TAG_ERROR_DETAIL_BEGIN.length(),
		        responseXML.indexOf(AppConstant.TAG_ERROR_DETAIL_END)
		    );
		    JSONObject jsonObject = XML.toJSONObject(errorDetail);
		    return jsonObject.optString("ErrorCode", "Unknown Error");
		}

		// Extract Success Details
		private String extractSuccessDetails(String responseXML) {
		    String successData = responseXML.substring(
		        responseXML.indexOf(AppConstant.SPLIT_FIN_RESP_ID_BEGIN) + AppConstant.SPLIT_FIN_RESP_ID_BEGIN.length(),
		        responseXML.indexOf(AppConstant.SPLIT_FIN_RESP_ID_END)
		    );
		    JSONObject responseJson = XML.toJSONObject(successData);
		    return responseJson.toString();
		}
    	
    private void saveRecordToDatabase(String record, String AccountNumber) {
    	
    	try {
    		String[] fields = record.split(";");
    		log.info("Record fetched by save record to database function :"+ fields);
    		
    		if(fields.length == 6) {
    		AccountStatement accountStatement = new AccountStatement();
    		
    		String transID = fields[0];
    		if(transID.startsWith("S^")) {
    			transID = transID.substring(2);
    		}
    		accountStatement.setTransID(transID);
    		accountStatement.setTransAmt(Double.parseDouble(fields[1]));
    		accountStatement.setTransType(fields[2]);
    		
//    		String remarks = fields[3];
//    		if(!remarks.startsWith("EMRS")) {
//    			log.info("Record skipped as remarks do not sttart with 'EMRS' :" +remarks);
//    			return;
//    		}
    		
    		accountStatement.setRemarks(fields[3]);
    		accountStatement.setTransDate(fields[4]);
    		accountStatement.setClosingBal(Double.parseDouble(fields[5]));
    		accountStatement.setAccountNumber(AccountNumber);
    		
    		accountStatementRepository.save(accountStatement);
    		log.info("Record saved Successfully :" + accountStatement);
    		
    		
    		}else {
    			System.out.println("Invalid record format : "+record);
    		}
    	}catch(Exception e) {
    		System.out.println("Failed to save record :"+record +". Error :"+e.getMessage());
    	}
    	
    	
    }
    
    
    @GetMapping("/TotalBudget/state")
    public ResponseEntity<List<Map<String, Object>>> getPhaseBudgetSumByState() {
        List<Map<String, Object>> data = tribeMasterService.getPhaseBudgetSumByState();
        return ResponseEntity.ok(data);
    }
    
    
    @GetMapping("/TotalBudget/SchoolID")
    public ResponseEntity<List<Map<String, Object>>> getPhaseBudgetSumBySchoolId() {
        List<Map<String, Object>> data = tribeMasterService.getPhaseBudgetSumBySchoolId();
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/debit-transactions-sum")
    public ResponseEntity<List<Map<String, Object>>> getDebitTransactionSums() {
        List<Map<String, Object>> response = accountStatementService.getDebitTransactionSums();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/state-wise-report")
    public ResponseEntity<List<Map<String, Object>>> getStateWiseReportData() {
        List<Map<String, Object>> response = tribeMasterService.getStateWiseReportData();
        return ResponseEntity.ok(response);
    }
    
//    @PostMapping("/uploading")
//    public ResponseEntity<Student> uploadFile(@RequestParam String email, 
//  		  @RequestBody MultipartFile Stufile) {
//  	  System.out.println("Api calling");
//        try {
//      	  System.out.println("Api calling");
//            if (Stufile.isEmpty() || !Stufile.getContentType().equals("application/pdf")) {
////                return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
//          	  return ResponseEntity.status(500).body(null);
//            }
//            
//            Optional<Student> upload2 = studentRegRepository.findByEmail(email);
//			
//				
//				Student up = upload2.get();
//           
//            //studentService.uploadFile(email, Stufile);
//            studentRegRepository.save(up);
//            
//            return ResponseEntity.ok(up);
//        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                                 .body("Error while uploading file: " + e.getMessage());
//      	  return ResponseEntity.status(500).body(null);
//        }
//
//    }
       
}