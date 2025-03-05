package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public String generateRandomString(int length){
       return RandomString.make(length);
    }

    @Given("I access the WebDriver University - Contact Us Page")
    public void i_access_the_web_driver_university_contact_us_page() {
        driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
        System.out.println("I access the WebDriver University - Contact Us Page");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Auto FN"+generateRandomString(3));
        System.out.println("I enter a unique first name");
    }

    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Auto LN"+generateRandomString(3));
        System.out.println("I enter a unique last name");
    }

    @When("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys("AutoMail"+generateRandomString(10)+"@mail.com");
        System.out.println("I enter a unique email address");
    }

    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.cssSelector("textarea[placeholder='Comments']")).sendKeys("Auto Comment"+generateRandomString(3));
        System.out.println("I enter a unique comment");
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
        System.out.println("I click on the submit button");
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement message = driver.findElement(By.cssSelector("#contact_reply h1"));
        Assert.assertEquals(message.getText(), "Thank You for your Message!");
        System.out.println("I should be presented with a successful contact us submission message");
    }

    @Then("I should be able to write on the CSV file")
    public void i_should_be_able_to_write_on_the_CSV_file() throws Exception {
        String 
		folder = "./",
        csvFilePath = folder + "TestData.csv";

         try (CSVWriter writer = new CSVWriter(new FileWriter(folder+csvFilePath, true))) {
            if (!fileExists) {
                String[] header = {"Column1"};
                writer.writeNext(header);
            }
            String[] newRow = {"Test Data"};
            writer.writeNext(newRow);
        }
    }
}
