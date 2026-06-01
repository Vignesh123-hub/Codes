package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	
	 private WebDriver driver;

	    // Locators
	    private By firstNameField = By.id("customer.firstName");
	    private By lastNameField = By.id("customer.lastName");
	    private By addressField = By.id("customer.address.street");
	    private By cityField = By.id("customer.address.city");
	    private By stateField = By.id("customer.address.state");
	    private By zipField = By.id("customer.address.zipCode");
	    private By phoneField = By.id("customer.phoneNumber");
	    private By ssnField = By.id("customer.ssn");
	    private By usernameField = By.id("customer.username");
	    private By passwordField = By.id("customer.password");
	    private By confirmField = By.id("repeatedPassword");
	    private By registerButton = By.cssSelector("input[value='Register']");
	    
	    
	    private By sucmsg = By.xpath("//h1[@class='title']/following-sibling::p[1]");

		private String text;  
	    
	    
	    

	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void enterFirstName(String firstname) {
	        driver.findElement(firstNameField).sendKeys(firstname);
	    }

	    public void enterLastName(String lastname) {
	        driver.findElement(lastNameField).sendKeys(lastname);
	    }

	    public void enterAddress(String address) {
	        driver.findElement(addressField).sendKeys(address);
	    }

	    public void enterCity(String city) {
	        driver.findElement(cityField).sendKeys(city);
	    }

	    public void enterState(String state) {
	        driver.findElement(stateField).sendKeys(state);
	    }

	    public void enterZipCode(String zip) {
	        driver.findElement(zipField).sendKeys(zip);
	    }

	    public void enterPhone(String phone) {
	        driver.findElement(phoneField).sendKeys(phone);
	    }

	    public void enterSSN(String ssn) {
	        driver.findElement(ssnField).sendKeys(ssn);
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void enterConfirm(String password) {
	        driver.findElement(confirmField).sendKeys(password);
	    }

	    public void clickRegister() {
	        driver.findElement(registerButton).click();
	    }
	    


	    public String successmsg() {
	        text = driver.findElement(sucmsg).getText();
	        return text;
	        
	    }
	    

}

