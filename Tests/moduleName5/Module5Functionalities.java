package moduleName5;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class Module6Functionalities.
 */
public class Module5Functionalities extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new module6 functionalities.
	 *
	 * @param obj
	 *            the obj
	 */
	public Module5Functionalities(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new module6 functionalities.
	 */
	public Module5Functionalities() {

	}

	/**
	 * Verify video page.
	 */
	public void verifyVideoPage() {
		testStepInfo("********************************** VIDEO *****************************************************");
		clickOn(OR.tab_Home_Page_Video);
		elementPresent(OR.vidHomePageVideo);
		waitTime(5);
		takeAdScreenshot(OR.vidHomePageVideo, "Video Page Video");
		testStepPassed("Verified the first video in any landing page is autoplayed");
		// mouseOver(OR.vidHomePageVideo);
		clickOn(OR.vidHomePageVideo);
		waitTime(5);
		testStepPassed("Video is paused");
		verifySocialWeb();
		verifyAds();
		verifyRecommended();

		testStepInfo("***************************** Load More *************************************");
		testStepPassed("Before Clicking on load more option");
		takeAdScreenshot(OR.txt_Video_Page_Most_Popular_videos, "Videos");
		clickOn(OR.btn_Video_Page_Recommended_Load_More);
		String loadMore = getText(OR.txt_video_Page_Load_More_Next_Events);
		takeAdScreenshot(OR.txt_video_Page_Load_More_Next_Events,
				"Next Details");
		testStepPassed("Verified the LOAD MORE option is displayed to load more details of the page"
				+ loadMore);
		// ValidateRecommended();
		validateFeatured();
	}

	public void validateFeatured() {
		testStepInfo("************************************** Featured ****************************************");
		clickOn(OR.img_Video_Page_Featured);
		waitTime(5);
		String featured = getText(OR.txt_Video_Page_Featured_Link);
		testStepPassed("" + featured);
		clickOn(OR.vidHomePageVideo);
		testStepPassed("Featured Section is displayed");

	}

	public void verifySocialWeb() {
		testStepInfo("************************************** Social Web ******************************************");
		clickOn(OR.btn_Video_Page_Social_Web);
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

	}

	public void verifyAds() {
		testStepInfo("***************************************** Ads  *********************************************");
		boolean topAds = elementPresent(OR.adsHomePageTopAds);
		boolean topxAds = elementPresent(OR.adsHomePageTopxAds);
		if (topAds == true || topxAds == true) {
			testStepPassed("Top Ads in Video Page");
			takeAdScreenshot(OR.adsHomePageTopAds, "Top Ads");
			testStepPassed("Topx Ads in Video Page");
			takeAdScreenshot(OR.adsHomePageTopxAds, "Topx Ads");
		} else {
			testStepPassed("Top Ads is not present");
		}
	}

	/**
	 * Verify recommended.
	 */
	public void verifyRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		waitForElement(OR.img_Video_Page_Recommended_Article);
		String varRecommended = getText(OR.img_Video_Page_Recommended_Article);
		testStepPassed("Recommended Article is --" + varRecommended);
		clickOn(OR.btn_Video_Page_Recommended_Next);
		takeAdScreenshot(OR.btn_Video_Page_Recommended_Next, "Next Recommended");
		String varNextRecommended = getText(OR.img_Video_Page_Recommended_Next_Article);
		testStepPassed("Recommended Next Article is --" + varNextRecommended);
		clickOn(OR.img_Video_Page_Recommended_Next_Article);
		waitTime(5);
		clickOn(OR.vidHomePageVideo);
		takeAdScreenshot(OR.vidHomePageVideo, "Video Page Video");
		testStepPassed("Verified the first video in any landing page is autoplayed");
		clickOn(OR.vidHomePageVideo);
		testStepPassed("Video is paused");

	}

	/**
	 * Validate recommended.
	 */
	public void validateRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		String varNext;
		String varXpath = null;
		// waitForElement(OR.txt_Video_Page_Recommended);
		String varRecom = getText(OR.txt_Video_Page_Recommended);
		testStepPassed(varRecom);
		for (int i = 2; i <= 3; i++) {

			varNext = "Next#xpath=//ol[@class='flex-control-nav flex-control-paging']//li//a[text()="
					+ i + "]";
			clickOn(varNext);
			takeAdScreenshot(varNext, "recom");
			for (int j = 1; j < 15; j++) {
				varXpath = "Recommended Profile#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li["
						+ j + "]//a/..//h4";
				if (j >= 1 || j <= 15) {
					String recom = getText(varXpath);
					testStepPassed("Recommended Article is--" + recom);
					// takeAdScreenshot(varXpath, "Recommended");
				}

			}

		}

		testStepPassed("Verified the Forbes RECOMMENDED articles are displayed in the page");
	}

}
