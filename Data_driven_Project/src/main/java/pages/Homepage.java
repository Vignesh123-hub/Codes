package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.baseTest;
import waitUtility.waitutils;

public class Homepage extends baseTest {


	WebDriver driver;
	
	waitutils waitUtil;
	
	
	@FindBy(linkText = "Register")
	WebElement Regclick;
	
	
	@FindBy(id = "customer.firstName")
	WebElement RegFname;
	
	@FindBy(id = "customer.lastName")
	WebElement RegLname;
	
	@FindBy(id = "customer.address.street")
	WebElement RegAdd;
	
	@FindBy(id = "customer.address.city")
	WebElement RegCity;
	
	@FindBy(id = "customer.address.state")
	WebElement RegState;
	
	@FindBy(id = "customer.address.zipCode")
	WebElement RegZip;
	
	@FindBy(id = "customer.phoneNumber")
	WebElement RegPhone;
	
	@FindBy(id = "customer.ssn")
	WebElement RegSSN;
	
	@FindBy(id = "customer.username")
	WebElement RegUname;
	
	@FindBy(id = "customer.password")
	WebElement RegPW;
	
	@FindBy(id = "repeatedPassword")
	WebElement RegRepeatPW;
	
	@FindBy(xpath = "//input[@value='Register']")
	WebElement RegSubmit;

	
	@FindBy(xpath = "//h1[@class='title']/following-sibling::p[1]")
	WebElement RegSuccess;
	
	
	
	
	public Homepage(WebDriver driver) {
		
		
		 this.driver = driver;
		 this.waitUtil = new waitutils(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void Registerclick()
	{
		waitUtil.waitForClickability(Regclick);
		Regclick.click();
		
	}
	
	
	public void RegisterFname(String firstname)
	{
		waitUtil.waitForVisibility(RegFname);
		RegFname.sendKeys(firstname);
		
	}
	
	public void RegisterLname(String lastname)
	{
		waitUtil.waitForVisibility(RegLname);
		RegLname.sendKeys(lastname);
		
	}
	
	
	public void RegisterAdd(String address)
	{
		waitUtil.waitForVisibility(RegAdd);
		RegAdd.sendKeys(address);
		
	}
	
	
	public void RegisterCity(String city)
	{
		waitUtil.waitForVisibility(RegCity);
		RegCity.sendKeys(city);
		
	}
	
	
	public void RegisterState(String state)
	{
		waitUtil.waitForVisibility(RegState);
		RegState.sendKeys(state);
		
	}
	
	
	public void RegisterZip(String zip)
	{
		waitUtil.waitForVisibility(RegZip);
		RegZip.sendKeys(zip);
		
	}
	
	
	public void RegisterPhone(String phone)
	{
		waitUtil.waitForVisibility(RegPhone);
		RegPhone.sendKeys(phone);
		
	}
	
	
	public void RegisterSSn(String ssn)
	{
		waitUtil.waitForVisibility(RegSSN);
		RegSSN.sendKeys(ssn);
		
	}
	
	
	public void RegisterUsername(String username)
	{
		waitUtil.waitForVisibility(RegUname);
		RegUname.sendKeys(username);
		
	}
	
	
	public void RegisterPassword(String password)
	{
		waitUtil.waitForVisibility(RegPW);
		RegPW.sendKeys(password);
		
	}
	
	public void RegisterRepeat(String password1)
	{
		waitUtil.waitForVisibility(RegRepeatPW);
		RegRepeatPW.sendKeys(password1);
		
	}
	
	
	
	
	public void RegisterSubmit()
	{
		waitUtil.waitForClickability(RegSubmit);
		RegSubmit.click();
		
	}
	
	public String RegisterSuccess()
	{
		
		waitUtil.waitForVisibility(RegSuccess);
		
			return RegSuccess.getText();
			
		
		
		
		
		
	}
	
	
}
