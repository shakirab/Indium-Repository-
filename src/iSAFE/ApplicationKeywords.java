/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  AutomationFramework.APIKeywords
 *  baseClass.BaseClass
 *  org.openqa.selenium.By
 *  org.openqa.selenium.WebElement
 *  org.openqa.selenium.remote.RemoteWebDriver
 */
package iSAFE;

import java.util.List;

import AutomationFramework.APIKeywords;
import baseClass.BaseClass;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationKeywords.
 *
 * @author indium
 */

public class ApplicationKeywords extends APIKeywords {

	/**
	 * Instantiates a new application keywords.
	 *
	 * @param obj
	 *            the obj
	 */
	public ApplicationKeywords(BaseClass obj) {
		super(obj);
	}

	/**
	 * Instantiates a new application keywords.
	 */
	public ApplicationKeywords() {
	}

	/**
	 * Take ad screenshot.
	 *
	 * @param element
	 *            the element
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(WebElement element, String screenshotName) {
		try {
			this.driver.executeScript("arguments[0].scrollIntoView();",
					new Object[] { element });
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Take ad screenshot.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(String objLocator, String screenshotName) {
		try {
			this.scrollToElement(objLocator);
			this.scrollBy(0, -60);
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Scroll to element.
	 *
	 * @param objLocator
	 *            the obj locator
	 */
	public void scrollToElement(String objLocator) {
		this.waitForElement(objLocator);
		this.driver.executeScript("arguments[0].scrollIntoView();",
				new Object[] { this.webElement });
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) ("Scroll to " + this.locatorDescription));
	}

	/**
	 * Scroll by.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollBy(int x, int y) {
		this.driver.executeScript("window.scrollBy(" + x + "," + y + ")",
				new Object[0]);
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) "Scroll to location: ");
	}

	/**
	 * Verify ad.
	 *
	 * @param adNumber
	 *            the ad number
	 */
	public void verifyAd(int adNumber) {
		this.scrollToElement("Ad place holder#id=article-0-ad-" + adNumber);
		this.takeAdScreenshot("Ad " + adNumber + "#id=inline-article-0-ad-"
				+ adNumber, "Ad No:" + adNumber);
	}

	/**
	 * Test step info.
	 *
	 * @param message
	 *            the message
	 */
	public void testStepInfo(String message) {
		this.writeHtmlTestStepReport("<font style='color:blue'>stepNo"
				+ message + "</font><br/>", this.currentExecutionMachineName,
				this.currentTestCaseName);
	}

	/**
	 * Gets the article heading.
	 *
	 * @param articleNumber
	 *            the article number
	 * @return the article heading
	 */
	public String getArticleHeading(int articleNumber) {
		String strXpath = "Article(" + articleNumber
				+ ")#xpath=//article[@id='article-container-" + --articleNumber
				+ "']//h1[@class='article-headline ng-binding ng-scope']";
		return this.getText(strXpath);
	}

	/**
	 * Gets the main article text.
	 *
	 * @return the main article text
	 */
	public String getMainArticleText() {
		String strXpath = "Main Article heading#xpath=//article[@class='feature promostory promostory-1']/div[@class='feature-headline']/h3/a";
		return this.getText(strXpath);
	}

	/**
	 * Click on main article.
	 */
	public void clickOnMainArticle() {
		String strXpath = "Main Article #xpath=//article[@class='feature promostory promostory-1']";
		this.clickOn(strXpath);
	}

	/**
	 * Click on top stories.
	 *
	 * @param topStoryNumber
	 *            the top story number
	 * @return the string
	 */
	public String clickOnTopStories(int topStoryNumber) {
		String strXpath = "Top Stories (" + topStoryNumber
				+ ") #xpath=//li[@class='promostory promostory-"
				+ (topStoryNumber += 2) + " ']/h4/a";
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		strXpath = "Top Story - " + articleLinkText
				+ "#xpath=//li[@class='promostory promostory-" + topStoryNumber
				+ " ']/h4/a";
		this.clickOn(strXpath);
		return articleLinkText;
	}

	public String clickOnMostPopular(int mostPopularNumber) {
		String strXpath = "Top Stories ("
				+ mostPopularNumber
				+ ") #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3[mostPopularNumber]";

		// section[@class='popular_top_stories' or
		// @id='stackMostPopular']//ol//li//h3
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		/*
		 * strXpath = "Most Popular- " + articleLinkText +
		 * "#xpath=//li[@class='promostory promostory-" + mostPopularNumber +
		 * " ']/h4/a"; this.clickOn(strXpath);
		 */
		return articleLinkText;
	}

	/**
	 * Go to home page.
	 */
	public void goToHomePage() {
		String strXpath = "Forbes logo#xpath=//article[@id='article-container-0']//header[@class='article-header ng-scope']//a[@href='http://www.forbes.com/']/h1";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the element count.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @return the element count
	 */
	public int getElementCount(String objLocator) {
		int elementCount = 0;
		try {
			this.waitForElement(objLocator);
			elementCount = this.driver.findElements(
					By.xpath((String) this.locator)).size();
			ApplicationKeywords.writeToLogFile((String) "INFO",
					(String) ("Total Elements found for "
							+ this.locatorDescription + ": " + elementCount));
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
		return elementCount;
	}

	/**
	 * Verify ads in mobile article.
	 */
	public void verifyAdsInMobileArticle() {
		String adPlaceHolder = "Ad Placeholder#xpath=//div[@class='article-mobile-ad ng-scope ng-isolate-scope']";
		int adCount = getElementCount(adPlaceHolder);
		testStepPassed("Verifing (" + adCount + ") Ads in the Aritcle Page");
		for (int i = 1; i <= adCount; i++) {

			adCount = getElementCount(adPlaceHolder);
			verifyAd(i);
		}
	}

	/**
	 * Verify ads in desktop article.
	 */
	public void verifyAdsInDesktopArticle() {
		int topAdArticleNo = 0;
		int adRailArticleNo = 0;
		for (int i = 0; i <= 15; i++) {

			if (driver.getPageSource().contains(
					"top-ad-article-" + topAdArticleNo)
					|| driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
				if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)
						&& driver.getPageSource().contains(
								"ad-rail-article-" + adRailArticleNo)) {
					testStepPassed("Top Ad");
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1) + ","
									+ "SideAds" + (adRailArticleNo + 1));
					if (driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
						int railAdCount = driver
								.findElements(
										By.xpath("//*[@id='ad-rail-article-"
												+ adRailArticleNo
												+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
								.size();
						testStepPassed("Rail Ad Count: " + railAdCount);
						for (int j = 0; j < railAdCount; j++) {
							takeAdScreenshot(
									driver.findElements(
											By.xpath("//*[@id='ad-rail-article-"
													+ adRailArticleNo
													+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
											.get(j), "SideAds"
											+ (adRailArticleNo + 1));
						}
					}
					topAdArticleNo++;
					adRailArticleNo++;
				} else if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)) {
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1));
					topAdArticleNo++;

				}

			} else {
				((JavascriptExecutor) driver)
						.executeScript("window.scrollBy(0,100)");
			}
		}

	}

	/**
	 * Verify top stories links.
	 */
	public void verifyTopStoriesLinks() {
		testStepInfo("*********************************Top Stories***********************************************");
		int topStoriesCount = getElementCount(OR.lnkTopStories);
		testStepPassed("Total Top Stories: " + topStoriesCount);
		String articleLinkText = clickOnTopStories(1);
		String articleHeading = getArticleHeading(1);
		if (articleHeading.contains(articleLinkText)) {

			testStepPassed("Article Page (" + articleLinkText
					+ ") is displayed");
		} else {
			testStepPassed("Article page (" + articleLinkText
					+ ") is not displayed, instead " + articleHeading
					+ " is displayed");
		}
		clickOnBackButton();
		int articleNo = 0;
		for (int i = 1; i <= topStoriesCount; i++) {

			if (currentExecutionMachineName.startsWith("Desktop")) {
				articleNo = i + 1;

			} else {
				articleNo = i + 2;
			}

			String strXpath = "Top Stories (" + i
					+ ") #xpath=//li[@class='promostory promostory-"
					+ articleNo + " ']/h4/a";
			if (elementPresent(strXpath)) {
				articleLinkText = getText(strXpath);
				testStepPassed("Top Story :" + i + " - " + articleLinkText);
			}
		}

	}

	/**
	 * Gets the most popular links.
	 *
	 * @return the most popular links
	 */
	public void getMostPopularLinks() {
		testStepInfo("****************************Most Popular********************************************");
		List<WebElement> allMostLinks = driver
				.findElements(By
						.xpath("//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3"));
		for (int k = 0; k < allMostLinks.size(); k++) {

			String textMost = allMostLinks.get(k).getText();
			testStepPassed("Most Popular (Top Stories - " + k + 1 + ")"
					+ textMost);
			/*
			 * allMostLinks.get(k).click(); clickOnBackButton();
			 */

		}
	}

	/**
	 * Verify most popular links.
	 */
	public void verifyMostPopularLinks() {
		testStepInfo("*********************************Most Popular***********************************************");
		scrollToElement(OR.txt_Home_Most_Popular_Links);
		scrollBy(0, 300);
		for (int i = 1; i <= 1; i++) {
			String strXpath = "Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3]";
			clickOn(strXpath);
			String mostPopualrTitle1 = driver.getTitle();
			testStepPassed("Navigated to this page---" + mostPopualrTitle1);
			clickOnBackButton();
		}

	}

	/**
	 * Verify video on home page.
	 */
	public void verifyVideoOnHomePage() {

		testStepInfo("****************************Top Video***************************************");
		try {
			testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			waitTime(3);
			clickOn(OR.btn_Home_Page_Video_Play_button);
			waitTime(5);
			testStepPassed("Video Played for 5 seconds");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify ad displayed in home page.
	 */
	public void verifyAdDisplayedInHomePage() {

		if (elementPresent(OR.adsHomePageTopAds)) {
			testStepInfo("*********************************Top Ad***********************************************");
			waitForElement(OR.adsHomePageTopAds);
			takeAdScreenshot(webElement, "Top Ads");
		}

		if (elementPresent(OR.adsHomePageRecAds)) {
			testStepInfo("*********************************Rec Ad***********************************************");
			waitForElement(OR.adsHomePageRecAds);
			takeAdScreenshot(webElement, "Rec Ads");
		}

		if (elementPresent(OR.adsHomePageTopxAds)) {
			testStepInfo("*********************************Topx Ad***********************************************");
			waitForElement(OR.adsHomePageTopxAds);
			takeAdScreenshot(webElement, "Topx Ads");
		}

	}
	/**
	 * Verify real time ads.
	 */
	public void verifyRealTimeAds() {
		testStepInfo("*************************************Real Time Ads**********************************************");

		testStepPassed("Screenshot of Top Ads");
		takeAdScreenshot(OR.adsHomePageTopAds, "Top Ads");

		testStepPassed("Screenshot of Rec Ads");
		takeAdScreenshot(OR.adsHomePageRecAds, "Rec Ads");

		testStepPassed("Screenshot of RailRec Ads");
		takeAdScreenshot(OR.ads_New_Posts_RailRec_Ads, "RailRec Ads");

		testStepPassed("Screenshot of Text Blocker Ads");
		takeAdScreenshot(OR.ads_New_Posts_Text_Ads, "Blocker Ads");

		testStepPassed("Screenshot of Loge Ads");
		takeAdScreenshot(OR.ads_New_Posts_Loge_Ads, "Loge Ads");

	}

}