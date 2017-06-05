package TestCases;

import homePage.Module1Functionalities;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import moduleName2.Module2Functionalities;
import moduleName3.Module3Functionalities;
import moduleName4.Module4Functionalities;
import moduleName5.Module5Functionalities;
import moduleName6.Module6Functionalities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import welcomePage.WelcomePageValidation;
import AutomationFramework.GenericKeywords;
import baseClass.BaseClass;

@Listeners({ Utilities.HtmlReport.class })
public class TestCases {
	String machineName = "";
	BaseClass obj;
	WelcomePageValidation welcomePageValidation;
	Module1Functionalities module1functionalities;
	Module2Functionalities module2functionalities;
	Module3Functionalities module3functionalities;
	Module4Functionalities module4functionalities;
	Module5Functionalities module5functionalities;
	Module6Functionalities module6functionalities;
	//Module7Functionalities module7functionalities;
	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	public void TestStart(String testCaseDescription, String hostName,
			String testCaseName) {

		obj.currentTestCaseName = testCaseName;
		obj.setEnvironmentTimeouts();
		obj.reportStart(testCaseDescription, hostName);
		obj.iterationCount.clear();
		obj.iterationCountInTextData();

	}

	@BeforeClass
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port",
			"selenium.browser", "selenium.os", "selenium.browserVersion",
			"selenium.osVersion", "TestData.SheetNumber" })
	public void precondition(String machineName, String host, String port,
			String browser, String os, String browserVersion, String osVersion,
			String sheetNo) {

		// module2functionalities.udid="ZX1D64HN6H";
		obj = new BaseClass();
		obj.udid = "3208570d95be519f";
		if (os.contains("Android")) {
			// obj.startServer(host,port);
			// obj.waitTime(10);
		}
		obj.setup(machineName, host, port, browser, os, browserVersion,
				osVersion, sheetNo);
	}

	
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void MR_DT_001(String machineName, Method method)
			throws MalformedURLException {

		TestStart("Home page Validations", machineName, method.getName());
		welcomePageValidation = new WelcomePageValidation(obj);
		for (int i = 0; i < welcomePageValidation.iterationCount.size(); i++) {

			welcomePageValidation.dataRowNo = Integer
					.parseInt(welcomePageValidation.iterationCount.get(i)
							.toString());
			welcomePageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							welcomePageValidation.currentExecutionMachineName,
							welcomePageValidation.currentTestCaseName);
			//module1functionalities.navigateTo("http://www.forbes.com/");
			welcomePageValidation.verifyWelcomePage();
		}
		obj.testCaseExecutionStatus = welcomePageValidation.testCaseExecutionStatus;
		TestEnd();
	}
	
	
	@AfterClass
	public void closeSessions() {
		obj.closeAllSessions();
	}
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC1(String machineName, Method method)
			throws MalformedURLException {

		TestStart("Home page Validations", machineName, method.getName());
		module1functionalities = new Module1Functionalities(obj);
		for (int i = 0; i < module1functionalities.iterationCount.size(); i++) {

			module1functionalities.dataRowNo = Integer
					.parseInt(module1functionalities.iterationCount.get(i)
							.toString());
			module1functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
					module1functionalities.currentExecutionMachineName,
					module1functionalities.currentTestCaseName);
			//module1functionalities.navigateTo("http://www.forbes.com/");
			module1functionalities.verifyLinksInHomePage();
		}
		obj.testCaseExecutionStatus = module1functionalities.testCaseExecutionStatus;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC2(String machineName, Method method) {
		TestStart("Article Page Validations", machineName, method.getName());
		module2functionalities = new Module2Functionalities(obj);
		for (int i = 0; i < module2functionalities.iterationCount.size(); i++) {
			module2functionalities.dataRowNo = Integer
					.parseInt(module2functionalities.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ module2functionalities.dataRowNo);
			module2functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
					module2functionalities.currentExecutionMachineName,
					module2functionalities.currentTestCaseName);
			 module2functionalities.navigateTo("http://www.forbes.com/");
			module2functionalities.verifyAdsInArticlePage();
		}
		obj.testCaseExecutionStatus = module2functionalities.testCaseExecutionStatus;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC3(String machineName, Method method) {
		TestStart("Most Popular validation", machineName, method.getName());
		module3functionalities = new Module3Functionalities(obj);
		for (int i = 0; i < module3functionalities.iterationCount.size(); i++) {
			module3functionalities.dataRowNo = Integer
					.parseInt(module3functionalities.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ module3functionalities.dataRowNo);
			module3functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
					module3functionalities.currentExecutionMachineName,
					module3functionalities.currentTestCaseName);
			module3functionalities.navigateTo("http://www.forbes.com/");
			module3functionalities.verifyMostPopularPage();
		}
		obj.testCaseExecutionStatus = module3functionalities.testCaseExecutionStatus;
		TestEnd();

	}

	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC4(String machineName, Method method) {
		TestStart("New Posts Page Validations", machineName, method.getName());
		module4functionalities = new Module4Functionalities(obj);
		for (int i = 0; i < module4functionalities.iterationCount.size(); i++) {
			module4functionalities.dataRowNo = Integer
					.parseInt(module4functionalities.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ module4functionalities.dataRowNo);
			module4functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							module4functionalities.currentExecutionMachineName,
							module4functionalities.currentTestCaseName);
			module4functionalities.navigateTo("http://www.forbes.com/");
			module4functionalities.verifyNewPostsPage();
			}
		obj.testCaseExecutionStatus = module4functionalities.testCaseExecutionStatus;
		TestEnd();

	}
	
	

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC5(String machineName, Method method) {
		TestStart("Video Page Validations", machineName, method.getName());
		module5functionalities = new Module5Functionalities(obj);
		for (int i = 0; i < module5functionalities.iterationCount.size(); i++) {
			module5functionalities.dataRowNo = Integer
					.parseInt(module5functionalities.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ module5functionalities.dataRowNo);
			module5functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							module5functionalities.currentExecutionMachineName,
							module5functionalities.currentTestCaseName);
			module5functionalities.navigateTo("http://www.forbes.com/");
			module5functionalities.verifyVideoPage();
			}
		obj.testCaseExecutionStatus = module5functionalities.testCaseExecutionStatus;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC6(String machineName, Method method) {
		TestStart("Contributor Page Validations", machineName, method.getName());
		module2functionalities = new Module2Functionalities(obj);
		for (int i = 0; i < module2functionalities.iterationCount.size(); i++) {
			module2functionalities.dataRowNo = Integer
					.parseInt(module2functionalities.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ module2functionalities.dataRowNo);
			module2functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
					module2functionalities.currentExecutionMachineName,
					module2functionalities.currentTestCaseName);
			 module2functionalities.navigateTo("http://www.forbes.com/");
			module2functionalities.validateContributorPage();
		}
		obj.testCaseExecutionStatus = module2functionalities.testCaseExecutionStatus;
		TestEnd();


	}
	

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC7(String machineName, Method method) {
		TestStart("Lists Page Validations", machineName, method.getName());
		module6functionalities = new Module6Functionalities(obj);
		for (int i = 0; i < module6functionalities.iterationCount.size(); i++) {
			module6functionalities.dataRowNo = Integer
					.parseInt(module6functionalities.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ module6functionalities.dataRowNo);
			module6functionalities.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							module6functionalities.currentExecutionMachineName,
							module6functionalities.currentTestCaseName);
			module6functionalities.navigateTo("http://www.forbes.com/");
			module6functionalities.verifyListsPage();
		}
		obj.testCaseExecutionStatus = module6functionalities.testCaseExecutionStatus;
		TestEnd();


	}
	
	public void TestEnd() {
		obj.waitTime(1);
		if (obj.testCaseExecutionStatus) {
			GenericKeywords.testFailed();
		}
	}

	@BeforeMethod
	public void before() {
		obj.testFailure = false;
	}

}
