package moduleName2;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class Module2Functionalities.
 */
public class Module2Functionalities extends ApplicationKeywords {

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
	 * Instantiates a new module2 functionalities.
	 *
	 * @param obj
	 *            the obj
	 */
	public Module2Functionalities(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify ads in article page.
	 */
	public void verifyAdsInArticlePage() {

		// String nextArticleInDesktop =
		// "Next Article#xpath=//article[@id='article-container-1']//header//h1";
		String nextArticleInMobile = "Next Article#xpath=//article[@id='article-container-1']//div[@class='article-text ng-scope']//h3";
		String articleText = null;
		String articleHeader = "Article Page#xpath=//article[@id='article-container-0']//header";
		try {

			if (currentExecutionMachineName.startsWith("Desktop")) {
				waitForText("Today's Top Stories");
				waitTime(2);
				clickOnMainArticle();
				validateAuthorDetails();
				validateShare();
				validateAds();
				/*
				 * verifyAdsInDesktopArticle();
				 * testStepPassed(" Scrolled down to Next Article");
				 * scrollToElement(nextArticleInDesktop);
				 * manualScreenshot("Next Article");
				 */

			} else {
				waitForText("Top Stories");
				clickOnMainArticle();
				verifyAdsInMobileArticle();
				scrollToElement(nextArticleInMobile);
				scrollBy(0, -60);
				articleText = getText(nextArticleInMobile);
				clickOn(nextArticleInMobile);
				testStepPassed("Article Text: " + getText(articleHeader));
				verifyPageShouldContainText(articleText);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validate share.
	 */
	public void validateShare() {
		testStepInfo("******************************* Share ****************************************");
		clickOn(OR.txt_Article_Page_Share);
		clickOn(OR.img_Article_Page_Social_Share);

		String winHandleBefore = driver.getWindowHandle();

		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			waitTime(2);
			driver.manage().window().maximize();

		}
		boolean email = elementPresent(OR.txt_Home_Page_Facebook_Email);
		if (email == true) {
			testStepPassed("Navigating to Facebook Page");
		} else {
			testStepPassed("Facebook is not available");
		}
		driver.close();

		driver.switchTo().window(winHandleBefore);

		clickOn(OR.txt_Article_Page_Share);
	}

	/**
	 * Validate author details.
	 */
	public void validateAuthorDetails() {
		testStepInfo("***************************Author Information*************************");
		String authorName = getText(OR.txt_Article_Page_Author_Name);
		testStepPassed("Author Name is ---" + authorName);
		boolean varContributor = elementPresent(OR.img_Article_Page_Contributor);
		if (varContributor == true) {
			testStepPassed("Image is displayed with Author Details");
		} else {
			testStepPassed("Image is not displayed");
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
	 * Validate ads.
	 */
	public void validateAds() {
		testStepInfo("***************************************Article Ads******************************");
		WebElement topAds = driver.findElement(By
				.xpath("//div[@id='top-fbs-ad-article-0']"));
		takeAdScreenshot(topAds, "Top Article");

		for (int i = 1; i <= 3; i++) {
			waitTime(3);
			String article = "Article#xpath=//article[@id='article-container-0']//div[@ng-repeat-start='ad_unit in ad_units']["
					+ i + "]";
			takeAdScreenshot(article, "article");
		}
		/*
		 * WebElement topAdsSec=driver.findElement(By.xpath(
		 * "//article[@id='article-container-1']//div[@id='top-fbs-ad-article-sticky-1']"
		 * )); takeAdScreenshot(topAdsSec, "Sec Top Ads");
		 */
	}

	/**
	 * Validate contributor page.
	 */
	public void validateContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		clickOnMainArticle();
		clickOn(OR.img_Article_Page_Contributor);
		String contributor = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);

		testStepPassed("Navigated to Contributor Page--" + contributor);
		clickOnBackButton();
		clickOn(OR.txt_Article_Page_Author_Name);
		String contributorName = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
		testStepPassed("Navigated to Contributor Page--" + contributorName);
		// clickOnBackButton();
		clickOn(OR.btn_Contributor_Page_Full_Bio);
		String fullBio = getText(OR.txt_Contributor_Page_Full_Bio_Details);
		testStepPassed(fullBio);
		clickOn(OR.btn_Contributor_Page_Full_Bio);
		mouseOver(OR.btn_Contributor_Page_Follow);

		manualScreenshot(OR.btn_Contributor_Page_Follow);
	}

}
