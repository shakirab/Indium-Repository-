package welcomePage;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class WelcomePageValidation.
 */
public class WelcomePageValidation extends ApplicationKeywords {

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
	public WelcomePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new module1 functionalities.
	 */
	public WelcomePageValidation() {

		// TODO Auto-generated constructor st ub
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

}
