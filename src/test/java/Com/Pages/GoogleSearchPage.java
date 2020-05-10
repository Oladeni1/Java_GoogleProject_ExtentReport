package Com.Pages;

import Com.UtilClass.Util;
import org.openqa.selenium.By;

public class GoogleSearchPage {
    private static final By SEARCH_BOX = By.name("q");//#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.RNNXgb > div > div.a4bIc > input
    private static final By SEARCH_BUTTON = By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf > div.FPdoLc.tfB0Bf > center > input.gNO89b");
    //private static final By SEARCH_BUTTON = By.name("btnK");
    //private static final By SEARCH_BUTTON = By.name("btnI");

    public static void enterSearchDetail() {
        Util.enterFieldText(SEARCH_BOX, "Olatunde Oladeni");
        Util.tabAwayFromWebElement(SEARCH_BOX);
    }

    public static void clickSearchButton() {
        Util.waitForElement(SEARCH_BUTTON);
        Util.clickWebElement(SEARCH_BUTTON);
    }

    public static void assertResultReturn() {

    }



}
