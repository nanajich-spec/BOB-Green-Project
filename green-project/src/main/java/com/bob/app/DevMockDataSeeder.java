package com.bob.app;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bob.app.bean.DepositDetails;
import com.bob.app.bean.LoanDetails;
import com.bob.app.bean.User;
import com.bob.app.bean.UserMaster;
import com.bob.app.dao.jpa.DepositDetailsRepository;
import com.bob.app.dao.jpa.LoanDetailsRepository;
import com.bob.app.dao.jpa.UserMasterRepository;
import com.bob.app.dao.jpa.UserRepository;

@Component
@Profile("local")
@ConditionalOnProperty(name = "app.mock.seed.enabled", havingValue = "true")
public class DevMockDataSeeder implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DevMockDataSeeder.class);

    private final UserMasterRepository userMasterRepository;
    private final UserRepository userRepository;
    private final LoanDetailsRepository loanDetailsRepository;
    private final DepositDetailsRepository depositDetailsRepository;

    public DevMockDataSeeder(
            UserMasterRepository userMasterRepository,
            UserRepository userRepository,
            LoanDetailsRepository loanDetailsRepository,
            DepositDetailsRepository depositDetailsRepository) {
        this.userMasterRepository = userMasterRepository;
        this.userRepository = userRepository;
        this.loanDetailsRepository = loanDetailsRepository;
        this.depositDetailsRepository = depositDetailsRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        seedUserMaster();
        seedUser();
        seedLoanDetails();
        seedDepositDetails();
        LOGGER.info("Local mock data seeding complete.");
    }

    private void seedUserMaster() {
        if (userMasterRepository.count() > 0) {
            return;
        }

        UserMaster maker = new UserMaster();
        maker.setEcNumber("MKR1001");
        maker.setEmpName("Maker User");
        maker.setRegion("West");
        maker.setRegionAlpha("W");
        maker.setZone("Mumbai");
        maker.setZoneAlpha("MU");
        maker.setBranchsolId("1001");
        maker.setRole("Maker");
        maker.setCur_org("Main Branch");
        maker.setCurr_org_type("BRANCH");
        maker.setDeleted(false);

        UserMaster checker = new UserMaster();
        checker.setEcNumber("CHK2001");
        checker.setEmpName("Checker User");
        checker.setRegion("West");
        checker.setRegionAlpha("W");
        checker.setZone("Mumbai");
        checker.setZoneAlpha("MU");
        checker.setBranchsolId("1001");
        checker.setRole("Checker");
        checker.setCur_org("Main Branch");
        checker.setCurr_org_type("BRANCH");
        checker.setDeleted(false);

        UserMaster admin = new UserMaster();
        admin.setEcNumber("ADM3001");
        admin.setEmpName("Admin User");
        admin.setRegion("West");
        admin.setRegionAlpha("W");
        admin.setZone("Mumbai");
        admin.setZoneAlpha("MU");
        admin.setBranchsolId("1001");
        admin.setRole("Admin");
        admin.setCur_org("HO");
        admin.setCurr_org_type("ADMIN");
        admin.setDeleted(false);

        userMasterRepository.save(maker);
        userMasterRepository.save(checker);
        userMasterRepository.save(admin);
    }

    private void seedUser() {
        if (userRepository.existsByUserid("MKR1001")) {
            return;
        }

        User maker = new User();
        maker.setUserid("MKR1001");
        maker.setEmpname("Maker User");
        maker.setRole("Maker");
        maker.setRegion("West");
        maker.setRegionAlpha("W");
        maker.setZone("Mumbai");
        maker.setZoneAlpha("MU");
        maker.setBranchSol("1001");
        maker.setCurrentOrg("Main Branch");
        maker.setCurrentOrgType("BRANCH");
        maker.setAddedBy("SYSTEM");
        maker.setAddedOn(LocalDateTime.now().minusDays(2));
        maker.setVerified("Y");
        maker.setEnableUser("Y");

        userRepository.save(maker);
    }

    private void seedLoanDetails() {
        if (loanDetailsRepository.count() > 0) {
            return;
        }

        LoanDetails loan = new LoanDetails();
        loan.setBusinessDate("2026-04-01");
        loan.setUploadDate("2026-04-01");
        loan.setAccountOpenedDate("2025-06-15");
        loan.setAccountNumber("40590600001108");
        loan.setRecordType("LIVE");
        loan.setAccountName("Mock Green Infra Ltd");
        loan.setCustId("CUST1001");
        loan.setSolID("1001");
        loan.setZone("Mumbai");
        loan.setRegion("West");
        loan.setSchemeCode("GRN001");
        loan.setSchemeName("Green Infra Term Loan");
        loan.setActivityCode("SOLAR");
        loan.setActivityGroup("RENEWABLE");
        loan.setAccountSegment("MSME");
        loan.setOutstandingAmount("-4500000");
        loan.setAmountDisbursed("5000000");
        loan.setMaturity("2030-06-15");

        loanDetailsRepository.save(loan);
    }

    private void seedDepositDetails() {
        if (depositDetailsRepository.count() > 0) {
            return;
        }

        DepositDetails deposit = new DepositDetails();
        deposit.setAccountno("500123456789");
        deposit.setZone("Mumbai");
        deposit.setRegion("West");
        deposit.setSolid("1001");
        deposit.setBranchcode("B001");
        deposit.setCustid("CUST1001");
        deposit.setAccountname("Mock Green Infra Ltd");
        deposit.setAccountopeningdate(LocalDate.of(2025, 1, 10));
        deposit.setSchemecode("FDGRN");
        deposit.setSchemedescription("Green Deposit");
        deposit.setNetIntRate(6.75);
        deposit.setTotalperiodinmonths(24.0);
        deposit.setTotalperiodindays(0.0);
        deposit.setFacevalue(5000000.0);
        deposit.setCurrentbalance(5200000.0);
        deposit.setMaturityamount(5600000.0);
        deposit.setMaturitydate(LocalDate.of(2027, 1, 10));
        deposit.setBusinessDate(LocalDate.of(2026, 4, 1));
        deposit.setUploadDate(LocalDate.of(2026, 4, 1));

        depositDetailsRepository.save(deposit);
    }
}
