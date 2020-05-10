package Com.UtilClass;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Com.Browser.Hook.driver;
import static org.junit.Assert.*;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertEquals;

    public class Util {

        public static void waitForWebPageLoad(String UrlContains){
            //driver().manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains(UrlContains));
        }

        public static WebDriverWait waitForElement(By elementSelector){
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
            return wait;
        }

        public static void doScroll(int x, int y) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            StringBuilder script = new StringBuilder("window.scrollBy(");
            script.append(x).append(",").append(y).append(")");
            js.executeScript(script.toString());
        }

        public static void assertPageUrlContains (String partUrl){
            assertTrue(driver.getCurrentUrl().contains(partUrl));
        }

        public static void clickWebElement (By identifier){
            waitForElement(identifier);
            driver.findElement(identifier).click();
        }

        public static void clickContinueButton (By ContinueButtonElement){
            clickWebElement(ContinueButtonElement);
        }

        public static void clickContinueBack (By BackButtonElement){
            clickWebElement(BackButtonElement);
        }

        public static void tabAwayFromWebElement (By identifier) {
            WebElement element = driver.findElement(identifier);
            element.sendKeys(Keys.TAB);
        }

        public static void enterKey (By identifier) {
            WebElement element = driver.findElement(identifier);
            element.sendKeys(Keys.ENTER);
        }


        public static void navigateForward(){
            driver.navigate().forward();
        }

        public static void navigateBack(){
            driver.navigate().back();
        }


        public static void selectSelect (By identifier, String option){
            Select sel = new Select((WebElement) driver);
            sel.selectByValue(option);
        }

        public static void selectOption (By identifier, String option){
            Select sel = new Select((WebElement) driver);
            sel.selectByVisibleText(option);
            sel.selectByIndex(1);
            sel.selectByValue(option);
        }

        public static void assertWebElementIsDisplayed (By identifier){
            waitForElement(identifier);
            assertTrue(driver.findElement(identifier).isDisplayed());
        }

        //MOUSEACTIONS
        public static void performMouseActionDropDownList(By identifier){
            Actions act = new Actions(driver);
            //act.
        }

        public static void assertWebElementIsNotDisplayed (By identifier){
            waitForElement(identifier);
            assertFalse(driver.findElement(identifier).isDisplayed());
        }

//    public static void assertWebElementIsNotPresent (By identifier){
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        assertTrue(driver().findElement(identifier).isEmpty());
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

        public static void assertWebElementIsEnabled (By identifier){
            waitForElement(identifier);
            assertTrue(driver.findElement(identifier).isEnabled());
        }

        public static void assertWebElementIsSelectedd (By identifier){
            waitForElement(identifier);
            assertTrue(driver.findElement(identifier).isSelected());
        }

        public static void assertWebElementIsNotSelected (By identifier){
            waitForElement(identifier);
            assertFalse(driver.findElement(identifier).isSelected());
        }


        public static void deleteFieldText (By identifier) {
            WebElement element = driver.findElement(identifier);
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        }

        public static void deleteFieldTextWithBackSpace(By identifier){
            WebElement element = driver.findElement(identifier);
            int numberOfCharacters = element.getAttribute("value").length();
            for (int i = 0; i < numberOfCharacters; i++);
            element.sendKeys(Keys.BACK_SPACE);
        }


        public static void enterFieldText(By identifier,String text){
            WebElement element = driver.findElement(identifier);
            element.sendKeys(text);
        }

        public static void enterFieldTextDoDeleteWithHighlightFirst (By identifier, String text){
            WebElement element = driver.findElement(identifier);
            deleteFieldText(identifier);
            element.sendKeys(text);
        }


        public static void enterFieldTextDoDeleteWithBackSpaceFirst (By identifier, String text){
            WebElement element = driver.findElement(identifier);
            deleteFieldTextWithBackSpace(identifier);
            element.sendKeys(text);
        }

        //#################################################################################################################

        private static LocalDate monthsAgo (int noOfMonths){
            //return LocalDate.now().minusMonths(noOfMonths);
            return java.time.LocalDate.now().minusMonths(noOfMonths);
        }

        private static LocalDate monthsInFuture(int noOfMonths) {
            //return LocalDate.now().plusMonths(noOfMonths);
            return java.time.LocalDate.now().plusMonths(noOfMonths);
        }

        public static void enterFutureDate(int monthsInFuture, By monthField, By yearField){
            LocalDate futureDate = monthsInFuture(monthsInFuture);
            enterFieldTextDoDeleteWithBackSpaceFirst(monthField, String.valueOf((futureDate.getMonth().getValue())));
            enterFieldTextDoDeleteWithBackSpaceFirst(yearField, String.valueOf((futureDate.getYear())));
        }

        public static void enterDateInThePast(int monthsInThePast, By monthField, By yearField){
            LocalDate dateInThePast = monthsAgo(monthsInThePast);
            enterFieldTextDoDeleteWithBackSpaceFirst(monthField, String.valueOf((dateInThePast.getMonth().getValue())));
            enterFieldTextDoDeleteWithBackSpaceFirst(yearField, String.valueOf((dateInThePast.getYear())));
        }



        //###############################################################################################################

        public static void assertWebElementText(By identifier, String webElementText) {
            assertEquals((webElementText), driver.findElement(identifier).getText());
        }


        public static void assertWebElementContains(By identifier, String textContained) {
            assertTrue("Moyo is a boy", driver.findElement(identifier).getText().contains(textContained));
        }

        public static void assertSelectOption(By identifier, String option) {
            Select sel = new Select(driver.findElement(identifier));
            assertEquals((option), driver.findElement(identifier).getText());
        }

        public static void assertWebElementAttribute(By identifier, String attribute, String attributeContent) {
            assertEquals(attributeContent, driver.findElement(identifier).getAttribute(attribute));
        }


        public static void assertFieldPopulatedCharacterLength (By identifier, int inputCharacterLength){
            assertEquals(inputCharacterLength, driver.findElement(identifier).getAttribute("value").length());
        }

        public static void assertBorderColor (By identifier, String borderColor) {
            assertEquals(borderColor, driver.findElement(identifier).getCssValue("CssValueName"));
        }

        public static void assertTheDropDownContains(By identifier){
            Select select = new Select(driver.findElement(identifier));
            List<WebElement> list = select.getOptions();
            assertFalse(list.isEmpty());
        }


        public static String getTextFromTextBox (By identifier) {
            return driver.findElement(identifier).getAttribute("value");
        }


    public static void assertDynamicTextData(String text, By identifier) {
       String [] arr = text.split(" ");
       for (int i = 0; i < arr.length; i++) {
            if(arr[i].matches("^.*(?=.*\\d)(?=.*[a-zA-Z]).*$")){
                String s = arr[i];
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(s);
                List <String> lst = new ArrayList<>();
                while(m.find()){
                    lst.add(m.group());
                }
                for (String str: lst) {
                    s = s.replace(str, "&");
                }
                String arrStr[]= s.split("&");
                for (int j = 0; j < arrStr.length; j++) {
                    arrStr[j] = String.format("(%S)", arrStr[j]);
                }
                arr[i] = String.join("\\d.*", arrStr);
            }
            else if(arr[i].matches(".*\\d.*"))
                arr[i] = "\\d*";
            else
                arr[i] = String.format("(%S)", arr[i]);
    }
    String regex = String.join("\\S", arr);
    System.out.println();
    System.out.println("generated regex:"+regex);
    String elementText = driver.findElement(identifier).getText();
    assertEquals(true, elementText.matches(regex));
    }

 //#####################################################################################################################


     public static void elementSelection(By elementSelector) {

         /**Code and what to do: First, find an elementSelector which will return all
          * value in the drop-down. Then using List, you can select any value.*/

            List<WebElement> myElements = driver.findElements(elementSelector);
            for (WebElement e : myElements) {
                if (e.getText().equalsIgnoreCase("Your_Desire_Value")) {
                    e.click();
                }
            }

          /**Note:- click on the drop-down first using simple click operation
           * and then use the above code. You may also need to apply focus
           * if the value is present deep below in the list.*/
     }

 //#####################################################################################################################
}
