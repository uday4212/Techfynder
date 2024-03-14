package com.surveillance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.surveillance.utilitiy.GenericKeywordsWithPage;

public class techfindpostpage 
{

	public techfindpostpage(WebDriver driver)
	{

		PageFactory.initElements(driver, this);


	}
	public GenericKeywordsWithPage ky= new GenericKeywordsWithPage("PostNewJob");

	//login
	@FindBy(xpath="(//span[@class='mat-button-wrapper'])[3]")
	WebElement bisiness;

	@FindBy(xpath="//strong[text()='Sign in']")
	WebElement sign;

	@FindBy(xpath="//input[@name='email']")
	WebElement email;

	@FindBy(xpath="//input[@type='password']")
	WebElement pass;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;

	public void ClickonBusiness() throws Throwable 
	{
		Thread.sleep(3000);
		ky.jsClick(bisiness);
		Thread.sleep(3000);
		ky.click(sign);
	}
	public void LaginCreadtials(String e,String p) throws InterruptedException
	{
		ky.enterData(email, e);
		Thread.sleep(3000);
		ky.enterData(pass, p);
		ky.click(submit);
		Thread.sleep(8000);
	}

	//Job Postings

	@FindBy(xpath="//h4[text()='Job Postings']")
	WebElement jobposting;
	@FindBy(xpath="//span[text()='POST NEW JOB']")
	WebElement postnewjob;

	public void ClickJopsettings()
	{
		ky.click(jobposting);
	}
	public void ClickPostNewJob()
	{
		ky.click(postnewjob);
	}
	//PostNewJob

	//CompanyImformation

	@FindBy(xpath="//input[@formcontrolname='companyName']")
	WebElement companyname;
	@FindBy(xpath="//input[@placeholder='Job Title']")
	WebElement jobtitle;
	@FindBy(xpath="//input[@data-placeholder='Country']")
	WebElement county;

	@FindBy(xpath="//input[@placeholder='State/City']")
	WebElement state;
	@FindBy(xpath="//mat-select[@placeholder='Select Min Years']")
	WebElement minyesrs;

	@FindBy(xpath="//mat-select[@placeholder='Select Max Years']")
	WebElement maxye;
	@FindBy(xpath="//mat-select[@placeholder='Select job type']")
	WebElement jobtype;
	@FindBy(xpath="//input[@placeholder='Number of Openings']")
	WebElement numberofop;
	public void CickoncompanyNaame(String cn)
	{
		ky.enterData(companyname, cn);
	}
	public void JobTitleClick(String jt)
	{

		ky.click(jobtitle);
		ky.enterData(jobtitle, jt);       
		WebElement job=  ky.driver.findElement(By.xpath("//span[text()=' "+jt+" ']"));

		job.click();

	}
	public void ClickCountry(String country)
	{

		ky.click(county);
		WebElement c= ky.driver.findElement(By.xpath("//span[text()=' "+country+" ']"));
		c.click();

	}
	public void ClickonState(String st)
	{

		ky.click(state);
		ky.enterData(state, st);
		ky.driver.findElement(By.xpath("//span[text()=' "+st+" ']")).click();
	}
	public void ClickonMinYearsofExperience(String minye)
	{
		ky.click(minyesrs);
		ky.driver.findElement(By.xpath("//span[text()=' "+minye+" ']")).click();

	}
	public void ClickonMaxYearsofExperience(String maxyex)
	{

		ky.click(maxye);

		ky.driver.findElement(By.xpath("//span[text()=' "+maxyex+" ']")).click();
	}
	public void ClickonJobType(String jobtypes)
	{
		ky.click(jobtype);
		ky.driver.findElement(By.xpath("//strong[text()='"+jobtypes+"']")).click();
	}
	public void DatapassNumberofOpenings(String dpnofopenings)
	{

		ky.enterData(numberofop,dpnofopenings);

	}
	//Expected Salary Information

	//Negotiable
	@FindBy(xpath="//mat-checkbox[@formcontrolname='rateNegotiable']")
	WebElement negotiable;
	@FindBy(xpath="//input[@placeholder='Length of contract']")
	WebElement negotiablelofc;
	public void ClickNegotiable(String monthdays,String nelofc )
	{

		ky.click(negotiable);

		ky.driver.findElement(By.xpath("//span[text()='"+monthdays+"']/preceding-sibling::span")).click();

		ky.enterData(negotiablelofc,  nelofc);
	}

	public void Allfields(String ClickNegotiable ,String currency,String jobtypes)
	{
		// ClickonJobType(jobtypes);
		if(ClickNegotiable.equalsIgnoreCase("true"))
		{
			ClickPreferredCurrency(currency);
			if(jobtypes.equals("PERMANENT JOB"))
			{
				AnnualSalaryDetailsEnter("600000", "100000");}
			else if(jobtypes.equals("CONTRACT JOB"))
			{

				ContractSalaryDetailsEnter("Monthly");
				MinSalary("600000");  
				MaxSalary("1000000");
				Lengthofcontract("2");}

			else{
				{
					AnnualSalaryDetailsEnter("600000", "1000000");
					ContractSalaryDetailsEnter("Monthly");
					MinSalary("600000");  
					MaxSalary("100000");
					Lengthofcontract("2");



				}
			}

		}
	}
	//Not Negotiable Preferredcurrency

	@FindBy(xpath="(//mat-select[@role='combobox'])[4]")
	WebElement preferredcurrency;
	public void ClickPreferredCurrency(String currency)
	{
		ky.click(preferredcurrency);
		ky.driver.findElement(By.xpath("//strong[text()='"+currency+"']")).click();

	}

	//Annual Salary Details
	@FindBy(xpath="//input[@formcontrolname='minAnnualRate']")
	WebElement minannualrate;
	@FindBy(xpath="//input[@formcontrolname='maxAnnualRate']")
	WebElement maxannualrate;

	public void AnnualSalaryDetailsEnter(String min,String max)
	{

		ky.enterData(minannualrate, min);
		ky.enterData(maxannualrate, max);
	}

	//Contract Salary Details

	public void ContractSalaryDetailsEnter(String hourlydailymon)
	{

		ky.driver.findElement(By.xpath("//span[text()='"+hourlydailymon+"']/preceding-sibling::span")).click();    
	}
	public void JobDurationClick(String monthdays){
		ky.driver.findElement(By.xpath("//mat-radio-button[@value='"+monthdays+"']")).click();
	}
	@FindBy(xpath="//input[@formcontrolname='minDailyRate']")
	WebElement minsalary;
	@FindBy(xpath="//input[@formcontrolname='maxDailyRate']")
	WebElement maxsalary;
	@FindBy(xpath="//input[@formcontrolname='lengthOfContract']")
	WebElement leangthofcontact;

	public void MinSalary(String min)
	{
		ky.enterData(minsalary, min);
	}
	public void MaxSalary(String max)
	{
		ky.enterData(maxsalary, max);
	}
	public void Lengthofcontract(String lc)
	{
		ky.enterData(leangthofcontact, lc);
	}

	//Workmode

	@FindBy(xpath="//button[@aria-label='Open calendar']")
	WebElement calenderclick;
	@FindBy(xpath="(//span[@class='mdc-button__label'])[1]")
	WebElement calendertop;

	public void calenders(String year,String month,String date) throws InterruptedException
	{
		ky.click(calenderclick);
		Thread.sleep(4000);
		ky.click(calendertop);
		Thread.sleep(4000);
		WebElement year1=ky.driver.findElement(By.xpath("//span[text()=' "+year+" ']")); 
		year1.click();
		Thread.sleep(4000);
		WebElement month1=ky.driver.findElement(By.xpath("//span[text()=' "+month+" ']"));
		month1.click();
		Thread.sleep(4000);
		WebElement date1=ky.driver.findElement(By.xpath("//span[text()=' "+date+" ']"));
		date1.click();
	}

	public void ClickonRemoteorOnsite(String remoteonsite){
		WebElement Remoteclick=  ky.driver.findElement(By.xpath("//mat-checkbox[@formcontrolname='"+remoteonsite+"']"));
		Remoteclick.click();
	}
	public void ClickonYesareNo(String truearefalse)
	{
		ky.driver.findElement(By.xpath("//mat-radio-button[@value='"+truearefalse+"']")).click();

	}


	@FindBy(xpath="//span[text()='Sectors']")
	WebElement sector;

	public void ClickSectors(String sect)
	{

		ky.click(sector);
		ky.driver.findElement(By.xpath("//div[text()='"+sect+"']")).click();

	}
	@FindBy(xpath="//input[@data-placeholder='Spoken Languages']")
	WebElement spokenlan;
	public void SpokenLanguagesEnter(String Spokeneng)
	{
		ky.click(spokenlan);
		ky.enterData(spokenlan, Spokeneng);
		ky.driver.findElement(By.xpath("//span[text()=' "+Spokeneng+" ']")).click();

	}

	@FindBy(xpath="//span[text()='Shifts']")
	WebElement shits;
	public void ShiftsClick(String shifts)
	{
		ky.click(shits);


		ky.driver.findElement(By.xpath("//div[text()='"+shifts+"']")).click();

	}

	@FindBy(xpath="//input[@placeholder='Skills']")
	WebElement sk;
	public void Skills(String skill)
	{

		ky.enterData(sk, skill);   
	}

	public  void JobDescriptionEnter()
	{

		WebElement descriptionInput=ky.driver.findElement(By.xpath("//div[@aria-label='Editor editing area: main']"));

		String description= generateDescription(500);
		descriptionInput.sendKeys(description);

	}
	public static String generateDescription(int length) 
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append("a");
		}
		return sb.toString();
	}

	@FindBy(xpath="(//span[text()=' Job Preview '])[2]")
	WebElement joppriview;
	public void JobPriview()
	{

		ky.click(joppriview);	
	}
	@FindBy(xpath="//span[text()=' Yes ']")
	WebElement yes;
	public void Yesbuttonclick()
	{
		ky.click(yes);

	}

}




