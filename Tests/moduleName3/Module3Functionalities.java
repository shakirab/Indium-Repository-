package moduleName3;

import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * The Class Module3Functionalities.
 */
public class Module3Functionalities extends ApplicationKeywords {

	/**
	 * Instantiates a new module3 functionalities.
	 *
	 * @param obj
	 *            the obj
	 */
	public Module3Functionalities(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify most popular page. Methods are written in mixed case with the
	 * first letter lower case, with the first letter of each internal word
	 * capitalized.
	 */
	public void verifyMostPopularPage() {
		testStepInfo("************************************MOST POPULAR PAGE******************************************");
		waitTime(10);
		clickOn(OR.tab_Most_Popular);
		verifySocialWeb();
		waitTime(3);
		verifyRealTimeAds();
		validateGallery();
		clickOnBackButton();
		refreshPage();

		validateSocialconnect();
		validateMostRead();
		/*
		 * validateGallery(); clickOnBackButton();
		 */

	}

	/**
	 * Validate socialconnect.
	 */
	public void validateSocialconnect() {

		testStepInfo("******************************** Social connection **************************************");
		waitTime(3);
		waitForElement(OR.img_Most_Popular_Social_Facebook);
		scrollToElement(OR.img_Most_Popular_Social_Facebook);
		scrollBy(0, -60);
		clickOn(OR.img_Most_Popular_Social_Facebook);
		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			waitTime(2);
			driver.manage().window().maximize();

		}

		driver.close();
		driver.switchTo().window(winHandleBefore);
		testStepPassed("Social Connects are available");
	}

	/**
	 * Validate gallery.
	 */
	public void validateGallery() {
		testStepInfo("*************************************** Trending Stories **************************");
		waitTime(5);
		scrollToElement(OR.txt_Most_Popular_links);
		scrollBy(0, -60);
		waitForElement(OR.txt_Most_Popular_links);
		clickOn(OR.txt_Most_Popular_links);
		/*
		 * String headingMostPopular =
		 * getText(OR.txt_Most_Popular_Page_Heading);
		 * 
		 * testStepPassed(headingMostPopular);
		 */
		testStepPassed("Verified the user is able to click on article link and navigates to respective URL/Article Page");

		try {
			elementPresent(OR.txt_Most_Popular_Gallery);
			String varGallery = getText(OR.txt_Most_Popular_Gallery);
			if (varGallery.contains("Gallery")) {
				scrollToElement(OR.txt_Most_Popular_Gallery);
				scrollBy(0, 200);
				clickOn(OR.txt_Most_Popular_Gallery);
				waitTime(3);
				clickOn(OR.btn_Most_Popular_Next);
				testStepPassed("Gallery is present for this article");
				clickOnBackButton();
				clickOnBackButton();
			} else {
				testStepPassed("Gallery is not present for this article");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitTime(2);

	}

	/**
	 * Validate most read.
	 */
	public void validateMostRead() {
		testStepInfo("********************************* Most Read **************************************");

		waitForElement(OR.txt_Most_Popular_Page_Most_Read);
		scrollToElement(OR.txt_Most_Popular_Page_Most_Read);
		scrollBy(0, -50);
		clickOn(OR.txt_Most_Popular_Page_Most_Read);
		clickOnBackButton();
		testStepPassed("Most Read are displayed");

	}

	/**
	 * Gets the most popular article text.
	 *
	 * @return the most popular article text
	 */
	public String getMostPopularArticleText() {
		String strXpath = "Most Popular Article heading#xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		return this.getText(strXpath);
	}

	/**
	 * Click on most popular article.
	 */
	Actions actions = new Actions(driver);

	/**
	 * Click on most popular article.
	 */
	public void clickOnMostPopularArticle() {
		String strXpath = "Most Popular Article #xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the contributor details.
	 *
	 * @return the contributor details
	 */
	public void getContributorDetails() {
		testStepInfo("************************Contributor Avatars**********************************");
		waitTime(2);
		int authorCount = getElementCount(OR.txt_Most_Popular_Page_Author);
		testStepPassed("Total Authors/contributors" + authorCount);
		waitTime(2);

		WebElement menu = driver
				.findElement(By
						.xpath("//section[@class='top_writers']//form//div[@class='leaderboard_holder']//ul//li//a"));
		actions.moveToElement(menu).perform();

		// mouseOver(OR.txt_Most_Popular_Page_Author);
		waitTime(2);
		// mouseOver(OR.txt_Most_Popular_Page_outerLayout);
		String contributorDetails = getText(OR.txt_Most_Popular_Page_Contributor_Details);
		testStepPassed("Contributor Details---" + contributorDetails);
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
	 * Verify ads in most popular.
	 */
	public void verifyAdsInMostPopular() {
		testStepInfo("*****************************Ads********************************");
		elementPresent(OR.adsHomePageTopAds);
		elementPresent(OR.adsHomePageRecAds);
		elementPresent(OR.ads_New_Posts_RailRec_Ads);

	}
}
