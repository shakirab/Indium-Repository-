package homePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectsRepository.OR;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * The Class Module1Functionalities.
 */
public class Module1Functionalities extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new module1 functionalities.
	 *
	 * @param obj
	 *            the obj
	 */
	public Module1Functionalities(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new module1 functionalities.
	 */
	public Module1Functionalities() {

		// TODO Auto-generated constructor st ub
	}

	/**
	 * Verify links in home page.
	 */
	public void verifyLinksInHomePage() {
		//verifyWelcomePage();
		/*String articleLink = null;
		String articleHeading = null;

		waitTime(5);
		articleLink = getMainArticleText();
		clickOnMainArticle();
		articleHeading = getArticleHeading(1);
		if (articleHeading.contains(articleLink)) {
			testStepPassed("Main Article Page (" + articleLink
					+ ") is displayed");
		} else {
			testStepFailed("Main Article page (" + articleLink
					+ ") is not displayed, instead " + articleHeading
					+ " is displayed");
		}
		clickOnBackButton();
		if (currentExecutionMachineName.startsWith("Desktop")) {
			verifyAdDisplayedInHomePage();
		}*/
		verifyTopStoriesLinks();
		verifyVideoOnHomePage();
		getMostPopularLinks();
		// verifyMostPopularLinks();
		verifySocialWeb();

		// clickOnBackButton();
		// verifySearch();
		verifyForbesList();
		verifyFooter();
		verfiyLogin();
		verifyLogout();
		switchTowindowForFacebook();
		switchTowindowForGoogle();

	}

	/**
	 * Verify welcome page.
	 */
	public void verifyWelcomePage() {
		testStepInfo("******************************Welcome Page**************************************");
		String quote = getText(OR.txt_Home_Forbes_Quote);
		testStepPassed("Forbes Quote of the Day-" + quote);
		manualScreenshot(OR.txt_Welcome_Page);
		String button = getText(OR.txt_Home_Forbes_Continue_site);
		testStepPassed("CONTINUE TO SITE-" + button);

		clickOn(OR.txt_Home_Forbes_Continue_site);
		testStepPassed("Clicked on Continue to site button");

		String title = driver.getTitle();
		testStepPassed("Redirected to home page " + title);
	}

	/**
	 * Verify social web.
	 */
	public void verifySocialWeb() {
		testStepInfo("*************************** Social Web ******************************************");
		clickOn(OR.icon_Most_Popular_Social_Web_Twitter);
		int twitterCount = getElementCount(OR.txt_Most_Popular_Twitter);
		testStepPassed("Total Links Present on Twitter--" + twitterCount);
		String twitter = getText(OR.txt_Most_Popular_Twitter);
		testStepPassed(twitter);
		clickOn(OR.icon_Most_Popular_Social_Web_Facebook);
		int facebookCount = getElementCount(OR.txt_Most_Popular_Social_Web_Facebook);
		testStepPassed("Total Links Present on Facebook--" + facebookCount);
		String facebook = getText(OR.txt_Most_Popular_Social_Web_Facebook);
		testStepPassed(facebook);
		clickOn(OR.icon_Most_Popular_Social_Web_LinkedIn);
		int linkedInCount = getElementCount(OR.txt_Most_Popular_Social_Web_LinkedIn);
		testStepPassed("Total Links Present on LinkedIn--" + linkedInCount);
		String linkedIn = getText(OR.txt_Most_Popular_Social_Web_LinkedIn);
		testStepPassed(linkedIn);

	}

	/**
	 * Verify forbes list.
	 */
	public void verifyForbesList() {
		testStepInfo("****************************Forbes List********************************************");
		elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
		boolean varForbesList = isTextPresent(OR.txt_Home_Page_Forbes_List);
		testStepPassed("Verified the Forbes list is displayed" + varForbesList);
		clickOn(OR.arw_Home_Page_Forbes_List_Prev);
		List<WebElement> allForbesLists = driver
				.findElements(By
						.xpath("//div[@class='bx-wrapper']//div//a//span[@class='name']"));
		int count = allForbesLists.size();
		testStepPassed("Total List of Forbes lists is--" + count);
		for (int k = 0; k < allForbesLists.size(); k++) {

			// String textLists = allForbesLists.get(k).getText();

			// testStepPassed("Forbes Lists " + k + 1 + ")" + textMost);

		}
		clickOn(OR.arw_Home_Page_Forbes_List_Next);
		testStepPassed("Forbes Lists ticker is working");
	}

	/**
	 * Verify footer.
	 */
	public void verifyFooter() {
		testStepInfo("******************************Footer**************************************");
		testStepPassed("--Verified the gobal Footer is displayed--");
		List<WebElement> allFooterLists = driver
				.findElements(By
						.xpath("//section[@class='lower-footer-links clearfix']//div//a"));
		for (int i = 0; i < allFooterLists.size(); i++) {
			String getFooter = allFooterLists.get(i).getText();

			testStepPassed(getFooter);

		}
		String mediallc = driver.findElement(
				By.xpath("//section[@class='legalese clearfix']//small"))
				.getText();
		testStepPassed("" + mediallc);

	}

	/**
	 * Verfiy login.
	 */
	public void verfiyLogin() {
		testStepInfo("*******************************Login************************************************");
		clickOn(OR.img_Home_Page_Login);

		typeIn(OR.txt_Home_Page_Login_User_Name, retrieve("txtUserName"));
		typeIn(OR.txt_Home_Page_Login_Password, retrieve("txtPassword"));
		clickOn(OR.btn_Home_Page_Login_Button);
		boolean loginError = elementPresent(OR.txt_Home_Page_Login_Error);
		if (loginError == true) {
			String loginErrorMessage = getText(OR.txt_Home_Page_Login_Error);
			testStepPassed(loginErrorMessage);
		} else {
			testStepPassed("Verified login successfully");
		}

	}

	/**
	 * Verify logout.
	 */
	public void verifyLogout() {
		testStepInfo("*******************************Logout************************************************");
		clickOn(OR.btn_Home_Page_Logout);
		testStepPassed("Verified Logout Successfully");
	}

	/**
	 * Switch towindow for facebook.
	 */
	public void switchTowindowForFacebook() {
		// clickOn(OR.img_Home_Page_Login);
		testStepInfo("***************************************Facebook************************************************");
		clickOn(OR.img_home_Page_Facebook_Login);
		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			waitTime(2);
			driver.manage().window().maximize();

		}

		typeIn(OR.txt_Home_Page_Facebook_Email, retrieve("txtFacebookUserName"));
		typeIn(OR.txt_Home_Page_Login_Password, retrieve("txtFacebookPassword"));
		waitTime(3);
		clickOn(OR.btn_Home_Page_Facebook_Login);

		boolean errorMessage = elementPresent(OR.txt_Home_Page_Facebook_Error_Message);
		if (errorMessage == true) {
			String facebookError = getText(OR.txt_Home_Page_Facebook_Error_Message);
			testStepPassed("Verified Error message is" + facebookError);
		} else {
			clickOn(OR.btn_Home_Page_Facebook_Switch_User);
			clickOn(OR.btn_Home_Page_Facebook_Switch_User1);
			testStepPassed("Secondary Window");
		}
		driver.close();
		testStepPassed("Secondary Window closed");

		driver.switchTo().window(winHandleBefore);
		testStepPassed("Main Window");
	}

	/**
	 * Switch towindow for google.
	 */
	public void switchTowindowForGoogle() {
		// clickOn(OR.img_Home_Page_Login);
		testStepInfo("***************************************Google************************************************");
		clickOn(OR.img_home_Page_Google_Login);
		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			waitTime(2);
			driver.manage().window().maximize();

		}

		typeIn(OR.txt_Home_Page_Google_Email, retrieve("txtGoogleEmail"));
		clickOn(OR.btn_Home_Page_Google_Next);
		typeIn(OR.txt_Home_Page_Google_Password, retrieve("txtGooglePassword"));
		waitTime(3);
		clickOn(OR.btn_Home_Page_Google_Signin);
		boolean errorMessage = elementPresent(OR.txt_Home_Page_Google_Error_Message);
		if (errorMessage == true) {
			String googleError = getText(OR.txt_Home_Page_Google_Error_Message);
			testStepPassed("Verified Google Login Error Message is --"
					+ googleError);
		} else {
			clickOn(OR.btn_Home_Page_Google_EmailLogout);
			clickOn(OR.btn_Home_Page_Google_Signout);
			testStepPassed(" Secondary Google Window");
		}

		driver.close();
		testStepPassed("Secondary Google Window closed");

		driver.switchTo().window(winHandleBefore);
		testStepPassed("Main Window");
	}

}
