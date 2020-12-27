package driver;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * @author Semih Saydam
 * @version 1.0.0
 * */
public class BaseMethods extends HookImpl {
    private static org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(BaseMethods.class);

    /**
     * findElement methodu element'i bulma işlemini kısaltmak için kullanılır.
     * */
    public MobileElement findElement(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 20);
        MobileElement mobileElement = (MobileElement) webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return mobileElement;
    }


//    /**
//     * findElements methodu elementlerin listesini bulmayı kısaltır.
//     * */
//    public List<MobileElement> findElements(By by) {
//        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 20);
//        List<MobileElement> mobileElements = (MobileElement) webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
//        return mobileElements;
//    }

    public List<MobileElement> findElements(By by){
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 20);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return  appiumDriver.findElements(by);
    }

    /**
     * sendKeysToElement methodu sendKeys işlemini kısaltır.
     * */
    public void sendKeysToElement(By by, String text) {
        MobileElement element = findElement(by);
        findElement(by).sendKeys(text);
        logger.info(element + "e +" + text + "değeri yazıldı");
        Assert.assertEquals(text,element.getText());
        Assert.assertNotNull(element.getText());
        logger.info("Değerin yazılabildiği kontrol edildi.");
    }

    /**
     * clickToElement methodu click işlemini kısaltır.
     * */
    public void clickToElement(By by) {
        findElement(by).click();
    }

    /**
     * getText methodu getText işlemini kısaltır.
     * */
    public String getText(By by) {
        return findElement(by).getText();
    }


    /**
     * getAttribute methodu getAttribute işlemini kısaltır.
     * */
    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    /**
     * randomNumber methodu random sayı üretir
     * */
    public static int randomNumber(int start, int end) {
        Random rn = new Random();
        int randomNumber = rn.nextInt(end - 1) + start;
        return randomNumber;
    }

    /**
     * priceParseInt methodu para birimini sayıya çevirir
     * */
    public static int priceParseInt(String text){
        String str = text;
        String replaced2 = str.replaceAll("Total Amount : ","");
        String finalString = replaced2.replaceAll(" ₺","");
        int intValue = Integer.parseInt(finalString);
        return intValue;
    }


}
