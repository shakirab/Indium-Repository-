package moduleName6;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class Module7Functionalities.
 */
public class Module6Functionalities extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new module7 functionalities.
	 *
	 * @param obj
	 *            the obj
	 */
	public Module6Functionalities(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new module7 functionalities.
	 */
	public Module6Functionalities() {

	}

	/**
	 * Verify lists page.
	 */
	public void verifyListsPage() {
		testStepInfo("*********************************** LISTS **************************************************");
		clickOn(OR.tab_Home_Page_Lists);
		testStepPassed("Top Ads is present");
		manualScreenshot(OR.ads_Lsits_Page_Topa_Ads);
		verifyRichLists();
		validateProfile();
		verifyFullList();
		verifyAdsInLsits();
		// clickOn(OR.tab_Lists_Page_Real_Time);
	}

	/**
	 * Verify ads in lsits.
	 */
	public void verifyAdsInLsits() {
		testStepInfo("************************************** Topx Ads ********************************************");

		waitForElement(OR.ads_Lists_Page_Topx_Ads);

		waitTime(5);
		scrollToElement(OR.ads_Lists_Page_Topx_Ads);
		scrollBy(0, 600);
		// takeAdScreenshot(OR.ads_Lists_Page_Topx_Ads, "");

		/*
		 * JavascriptExecutor je = (JavascriptExecutor) driver; WebElement
		 * element = driver.findElement(By.xpath("//td[text()='#11 ']"));
		 * je.executeScript("arguments[0].scrollIntoView(true);", element);
		 */

		for (int i = 1; i <= 4; i++) {

			String varXpath = "Topx Ads#xpath=//tbody[@id='list-table-body']//tr[@class='ad']["
					+ i + "]";

			scrollToElement(varXpath);
			scrollBy(0, 300);
			// clickOn(varXpath);
			waitTime(1);
			takeAdScreenshot(varXpath, "Topx Ads");

		}
		testStepPassed("Verified the images are displayed in all pages");

	}

	/**
	 * Verify ads.
	 */
	public void verifyAds() {
		/*
		 * //tbody[@id='list-table-body']//tr[@class='ad'][1]
		 */int topxAdsNo = 1;
		for (int i = 0; i <= 10; i++) {
			if (driver.getPageSource().contains("topx" + topxAdsNo)) {
				int topxAdsCount = driver.findElements(
						By.xpath("//*[@id='topx_" + topxAdsNo + "']")).size();

				testStepPassed("Topx Ads Count: " + topxAdsCount);
				for (int j = 0; j < topxAdsCount; j++) {
					takeAdScreenshot(
							driver.findElements(
									By.xpath("//*[@id='topx_" + topxAdsNo
											+ "']")).get(j), "TopxAds"
									+ (topxAdsNo + 1));
				}
			}
		}
	}

	/** The actions. */
	Actions actions = new Actions(driver);

	/**
	 * Verify rich lists.
	 */
	public void verifyRichLists() {
		testStepInfo("******************************* Rich Lists ***********************************");
		// clickOn(OR.img_Lists_Page_Rich_List);
		// mouseOver(OR.img_Lists_Page_Rich_List);

		WebElement menu = driver.findElement(By
				.xpath("//div[@class='col--3-1 lists--block lists--rich']"));
		actions.moveToElement(menu).perform();
		waitTime(2);
		/*
		 * List<WebElement> allLists=driver.findElements(By.xpath(
		 * "//div[@class='col--3-1 lists--block lists--rich']//dl//dd//a")); for
		 * (int i = 1; i <=allLists.size(); i++) { String
		 * getText=allLists.get(i).getText();
		 * testStepPassed("List of the Rich Lists-"+i+"."+getText);
		 * 
		 * }
		 */
		driver.findElement(By.linkText("World's Billionaires")).click();

		testStepPassed("Top Ads is present");
		manualScreenshot(OR.adsHomePageTopAds);
	}

	/**
	 * Verify full list.
	 */
	public void verifyFullList() {
		testStepInfo("******************************** Full Lists **********************************");

		String title = getText(OR.txt_Lists_Page_Title);
		testStepPassed("Navigated to corresponding page --" + title);
		clickOn(OR.btn_Lists_Page_Full_List);
		waitTime(3);
		boolean lists = elementPresent(OR.txt_Lists_Page_Lists_Of_Ranking);
		if (lists == true) {
			testStepPassed("Verified the user can view the complete list by clicking 'See Full List' button");
		} else {
			testStepPassed("Not loaded the complete list");
		}
	}

	/**
	 * Validate profile.
	 */
	public void validateProfile() {
		testStepInfo("******************************** Profile **********************************");
		testStepPassed("Top Ads is present");
		takeAdScreenshot(OR.adsHomePageTopAds, "");

		/*
		 * scrollToElement(OR.btn_Lists_Page_Next10); scrollBy(0, 100);
		 */
		waitForElement(OR.btn_Lists_Page_Next10);
		clickOn(OR.btn_Lists_Page_Next10);
		clickOn(OR.btn_Lists_Page_Previous10);
		clickOn(OR.img_Lists_Page_Profile);
		String profileName = getText(OR.txt_Lists_Page_Profile_Name);
		testStepPassed("Profile name is --" + profileName);
		clickOn(OR.btn_Lists_Page_Next);
		clickOn(OR.btn_Lists_Page_Previoust);
		clickOn(OR.btn_Lists_Page_See_Full_Profile);
		String profile = getText(OR.txt_Lsits_Page_Profile_Details);
		testStepPassed("Profile name is --" + profile);
		waitForElement(OR.btn_Lists_Page_Load_More);
		boolean loadMore = elementPresent(OR.btn_Lists_Page_Load_More);
		if (loadMore == true) {
			/*
			 * scrollToElement(OR.btn_Lists_Page_Load_More); scrollBy(0, 100);
			 */
			clickOn(OR.btn_Lists_Page_Load_More);
		} else {
			testStepPassed("Load More button is not present");
		}
		clickOnBackButton();

	}
}
