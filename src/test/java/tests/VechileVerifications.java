package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flow.VehicleDetails;
import org.apache.commons.lang.UnhandledException;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.NavPage;
import pages.VechileConfirmPage;
import webUtility.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class VechileVerifications {

    private static List<VehicleDetails> listallVehicleDetails = new ArrayList<>();
    private static List<String> errors = new ArrayList<>();
    LogFileMessage logger = new LogFileMessage();
    private String dir_location = System.getProperty("user.dir") + "/src/test/resources/TestData/";
    private static WebDriver newdriver;
    private HomePage homepage = new HomePage();
    private NavPage navPage = new NavPage();
    private VechileConfirmPage vechileConfirmPage = new VechileConfirmPage();
    private FilesOperations filesOperations = new FilesOperations();
    private List<VehicleDetails> actualVehicleList = new ArrayList<>();
    private BaseTest baseTest = new BaseTest();
    private List<File> file;
    private  String[] file_types;

    @Given("^I scan the directory to retrieve the supported \"([^\"]*)\" files$")
    public void i_scan_the_directory_to_retrieve_the_supported_csv_xlsx_files(String filetype) throws Throwable {
        logger.displayMesage("Scan to Retreive the file type");
        assertTrue(filetype.equalsIgnoreCase("csv")||filetype.equalsIgnoreCase("xls")||filetype.equalsIgnoreCase("xlsx"));
        ReadFiles readFiles = new ReadFiles();
        file_types = new String[]{filetype};
        file = readFiles.readFilesFromDirectory(file_types, dir_location);
      //  Assert.assertFalse(file.size() > 0);
    }

    @Given("^I read vehicle reg numbers from one of the file$")
    public void i_read_vehicle_reg_numbers_from_one_of_the_file() throws Throwable {
        file.forEach(eachFile ->
        {
            List<VehicleDetails> vehicleDetailsFromAFile;
            if (file_types[0].equalsIgnoreCase("csv"))
                vehicleDetailsFromAFile = filesOperations.readCSVFile(eachFile);
            else
                vehicleDetailsFromAFile = filesOperations.getVechileDetailsFromExcellFile(eachFile);
            vehicleDetailsFromAFile.forEach(vehicle_Details -> this.listallVehicleDetails.add(vehicle_Details));
        });
        Assert.assertTrue("No car details have been found!", listallVehicleDetails.size() > 0);
    }

    @Given("^I launch dvla site$")
    public void i_launch_dvla_site() throws Throwable {
        logger.displayMesage("Initialising Chrome Driver:");
        newdriver = BaseTest.getInstance().setBrowser("chrome");
        baseTest.navigateToURL();
    }

    @When("^I search for vehicle info by reg number$")
    public void i_search_for_vehicle_info_by_reg_number() throws Throwable {

        this.homepage = PageFactory.initElements(newdriver, HomePage.class);
        this.navPage = PageFactory.initElements(newdriver, NavPage.class);
        this.vechileConfirmPage = PageFactory.initElements(newdriver, VechileConfirmPage.class);

        listallVehicleDetails.forEach(vehicle -> {
            try {
                homepage.click_start_button();
                navPage.sendRegistrationNumber(vehicle.getRegistrationNumber());
                navPage.submitContinueButton();
                String exp_Colour = vechileConfirmPage.getText_colour();
                String exp_registrationNumber = vechileConfirmPage.getlabel_Reg_number();
                String exp_Make = vechileConfirmPage.getText_make();
                logger.displayMesage("Check the Registration NUmber" + exp_registrationNumber);

                if ((vehicle.getRegistrationNumber()).equalsIgnoreCase(exp_registrationNumber)) {
                   try {
                       Assert.assertTrue("Failed: Vehicle make  matched", (vehicle.getMake()).contains(exp_Make));
                       Assert.assertTrue("Failed: Vehicle color matched", (vehicle.getColour()).contains(exp_Colour));
                   } catch(AssertionError e)
                {
                    logger.displayMesage("Exception found: " + e.getMessage()+":Failed");
                    logger.takeScreenShot();
                    errors.add("Exception found: " + e.getMessage()+":Failed");
                }


                } else {
                    System.out.println("Vehicle make not matched, Please check manually");
                    errors.add("registrationNumber" + ": " + exp_registrationNumber);
                    logger.displayMesage("Vehicle make not matched, Please check manually");
                    logger.takeScreenShot();
                }

                baseTest.navigateToURL();
            } catch (UnhandledException e) {
                logger.printStackTrace(e);
            } catch (InterruptedException e) {
                logger.printStackTrace(e);
            }
        });
    }


    @Then("^I should be able match the expected color and make from the given file$")
    public void i_should_be_able_match_the_expected_color_and_make_from_the_given_file() throws Throwable {
    //display the Failed tests after matching the registration number
            logger.displayMesage("Failed Number of Tests:" + errors.size());
    }

    @After
    public void cleanUp()
    {
        newdriver.quit();
        newdriver.close();
       baseTest.cleanUp();


    }


}
