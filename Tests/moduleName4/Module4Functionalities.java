package moduleName4;

import org.openqa.selenium.By;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class Module4Functionalities.
 */
public class Module4Functionalities extends ApplicationKeywords {
	
	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new module4 functionalities.
	 *
	 * @param obj the obj
	 */
	public Module4Functionalities(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new module4 functionalities.
	 */
	public Module4Functionalities() {

	}

	/**
	 * Verify new posts page.
	 */
	public void verifyNewPostsPage() {
		clickOn(OR.tab_Header_Navigation_New_Posts);
		String varRealPost = getText(OR.txt_Header_Navigation_New_Post);
		testStepPassed("Navigated to this page--" + varRealPost);
		waitTime(2);
		verifyGraph();
		verifyRealTimeChannelTabs();

		testStepInfo("**************Newly Posted Events*******************");
		waitForElement(OR.txt_New_Posts_link);
		clickOn(OR.txt_New_Posts_link);
		String headingNewPosts = getText(OR.txt_Most_Popular_Page_Heading);
		testStepPassed(headingNewPosts);
		clickOnBackButton();
		verifyRealTimeAds();
		validateLoadMore();

	}

	/**
	 * Verify graph.
	 */
	public void verifyGraph() {
		String varGraph = null;
		testStepInfo("************************************* Graph *******************************************");
		for (int i = 1; i <= 3; i++) {

			waitTime(3);
			varGraph = "Graph#xpath=//div[@class='visualStats']//dd[" + i
					+ "]//canvas";
			// boolean graph=elementPresent(varGraph);

		}
		manualScreenshot(varGraph);
		// takeAdScreenshot(varGraph, "");
		for (int j = 1; j <= 3; j++) {
			String label = "Label#xpath=//div[@class='visualStats']//dt[" + j
					+ "]";
			String textLabel = getText(label);
			testStepPassed("Graph is present with Labels--" + textLabel);
		}
	}

	/**
	 * Validate load more.
	 */
	public void validateLoadMore() {
		testStepInfo("**************************Load More*******************");
		try {
			boolean loadMore = elementPresent(OR.txt_New_Posts_Load_More);
			if (loadMore == true) {
				clickOn(OR.txt_New_Posts_Load_More);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// clickOn(OR.txt_New_Posts_link);
		driver.findElement(
				By.xpath("//div[@id='realtimechanneltabs']/div[2]/div/ul[1]/li[28]/div/article/h2/a"))
				.click();
		String headingNewEvents = getText(OR.txt_Most_Popular_Page_Heading);
		testStepPassed(headingNewEvents);
		clickOnBackButton();
	}

	/**
	 * Verify real time channel tabs.
	 */
	public void verifyRealTimeChannelTabs() {
		int countImages = 0;
		testStepInfo("*************************************Real Time Channel Tabs********************************************");
		for (int i = 1; i <= 8; i++) {

			String varXpath = "Real time Channel Tabs#xpath=//div[@id='realtimechanneltabs']//ul//li[@data-channel-mapping='channel_"
					+ i + "']";

			clickOn(varXpath);
			waitTime(2);
			String varChannel = getText(varXpath);

			testStepPassed("Real time channel is --" + varChannel);
			boolean image = elementPresent(OR.img_New_Posts_Images);
			if (image == true) {
				countImages = getElementCount(OR.img_New_Posts_Images);
				manualScreenshot(OR.img_New_Posts_Images);
				testStepPassed("Total images are dispalyed --" + countImages);
				// testStepPassed("Images are Displayed");

			} else {
				testStepPassed("Images are not Displayed");
			}

		}

		clickOn(OR.txt_New_Posts_Channel_Tab10);
		String varChannel = getText(OR.txt_New_Posts_Channel_Tab10);
		testStepPassed("Real time channel is --" + varChannel);

		clickOn(OR.txt_New_Posts_Channel_Tab);
		String varChannel1 = getText(OR.txt_New_Posts_Channel_Tab);
		testStepPassed("Real time channel is --" + varChannel1);
	}

}
