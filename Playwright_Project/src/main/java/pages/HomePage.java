package pages;



import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import base.basetest;

public class HomePage extends basetest{

	  Page newPage ;
	
	
	
	
	
		
		  public HomePage(Page newPage) {
		  
		  
		  this.newPage = newPage;
		  
		  }
		 
	
	public void Registerclick()
	{
	
		newPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Register")).click();
		
	}
	
	
	public void RegisterFname(String firstname)
	{
		
		newPage.locator("[name='customer.firstName']").fill(firstname);
	}
	
	public void RegisterLname(String lastname)
	{
		newPage.locator("[name='customer.lastName']").fill(lastname);
		
	}
	
	
	public void RegisterAdd(String address)
	{
		newPage.locator("[name='customer.address.street']").fill(address);
		
	}
	
	
	public void RegisterCity(String city)
	{
		newPage.locator("[name='customer.address.city']").fill(city);
		
	}
	
	
	public void RegisterState(String state)
	{
		newPage.locator("[name='customer.address.state']").fill(state);
	}
	
	
	public void RegisterZip(String zip)
	{
		
		newPage.locator("[name='customer.address.zipCode']").fill(zip);
	}
	
	
	public void RegisterPhone(String phone)
	{
		newPage.locator("[name='customer.phoneNumber']").fill(phone);
		
	}
	
	
	public void RegisterSSn(String ssn)
	{
		newPage.locator("[name='customer.ssn']").fill(ssn);
		
	}
	
	
	public void RegisterUsername(String username)
	{
	
		newPage.locator("[name='customer.username']").fill(username);
	}
	
	
	public void RegisterPassword(String password)
	{
		
		newPage.locator("[name='customer.password']").fill(password);
	}
	
	public void RegisterRepeat(String password)
	{
	
		newPage.locator("#repeatedPassword").fill(password);
	}
	
	
	
	
	public void RegisterSubmit()
	{
		newPage.locator("//input[@value='Register']").click();
	}
	
	public String RegisterSuccess()
	{
		String innerText = newPage.locator("//h1[@class='title']/following-sibling::p[1]").innerText();
		
		return innerText;
		
	}
	
		
		
			
		
		
		
		
		
	}
	
	
	
	
	
	

