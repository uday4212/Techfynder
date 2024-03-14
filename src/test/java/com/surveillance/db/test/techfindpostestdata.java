package com.surveillance.db.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.surveillance.Test.BaseTest;
import com.surveillance.pages.techfindpostpage;
import com.surveillance.utilitiy.GenericKeywordsWithPage;
import com.surveillance.utilitiy.PropertySingleton;

public class techfindpostestdata extends BaseTest
{
	techfindpostpage pnj;

	PropertySingleton _instance = null;
	SoftAssert s_assert = new SoftAssert();

	public  techfindpostestdata() throws Throwable
	{
		_instance = PropertySingleton.getInstance();
		pnj = new techfindpostpage(GenericKeywordsWithPage.driver);
	}
	@BeforeClass
	public void startReport()
	{
		beforeClassForChild(this);

	}
	@Test
	public void loginWithValidCredentials() throws Throwable 
	{

		extentLoggerECP = parentExtentLogger.createNode("login With Valid Credentials");
		s_assert = new SoftAssert();
		pnj = new techfindpostpage(GenericKeywordsWithPage.driver);

		pnj.ClickonBusiness();
		pnj.LaginCreadtials("venkatakalyan0034@mail.techfynder.com", "kal@9090");

		pnj.ClickJopsettings();

		pnj.ClickPostNewJob();
		pnj.CickoncompanyNaame("suresh");
		pnj.JobTitleClick("java");

		pnj.ClickCountry("India");
		pnj.ClickonState("Markapur, Andhra Pradesh");
		pnj.ClickonMinYearsofExperience("4 yrs");
		pnj.ClickonMaxYearsofExperience("6 yrs");
		pnj.DatapassNumberofOpenings("2");

		pnj.ClickonJobType("CONTRACT JOB");

		//pnj.ClickNegotiable("false","");

		/* pnj.ClickPreferredCurrency("INR");
		 pnj.AnnualSalaryDetailsEnter("400000", "1000000");
		 pnj.ContractSalaryDetailsEnter("Monthly");
		 pnj.MinSalary("600000");
		 pnj.MaxSalary("1000000");
		 pnj.Lengthofcontract("4");*/
		pnj.Allfields("true", "INR", "CONTRACT JOB");
		pnj.ClickonRemoteorOnsite("onSite");
		pnj.ClickonYesareNo("false");

		pnj.calenders("2024", "MAY", "26");

		pnj.ClickSectors("Banking");

		pnj.SpokenLanguagesEnter("English");

		pnj.ShiftsClick("Morning Shift");
		pnj.Skills("java");
		pnj.JobDescriptionEnter();
		pnj.JobPriview();
		pnj.Yesbuttonclick();
	}}




