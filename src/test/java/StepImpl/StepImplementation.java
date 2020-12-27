package StepImpl;

import com.oracle.tools.packager.Log;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.BaseMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Semih Saydam
 * @version 1.0.0
 */
public class StepImplementation extends BaseMethods {

    private static org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(StepImplementation.class);


    @Step("<key> butonuna tıkla")
    public void implementation1(String key) {

        clickToElement(selector.getElementInfoToBy(key));

    }


    @Step("<key> elementinin görünür olduğunu kontrol eder.")
    public void apperanceAssert(String key) {
        Assert.assertTrue(findElement(selector.getElementInfoToBy(key)).isDisplayed());
    }

    @Step("<key> elementine <text> degeri yazılır Yazılabildiği kontrol edilir.")
    public void setObjectById(String key, String value) {
        sendKeysToElement(selector.getElementInfoToBy(key), value);
    }

    @Step("Bu adımda rapora <key> yaz ve screenShot al")
    public void takeScreenShot(String key) {
        Gauge.captureScreenshot();
        Gauge.writeMessage(key);
        logger.info("gauge raporuna bu adımda " + key + " mesajı eklendi");
    }

    @Step("Bu adımda rapora <key> yaz")
    public void reportStepLog(String key) {
        Gauge.writeMessage(key);
        logger.info("gauge raporuna bu adımda " + key + " mesajı eklendi");
    }

    @Step("<key> elementinin yazısının <text> olduğunu kontrol eder")
    public void textControl(String key, String text) {
        Assert.assertEquals(getText(selector.getElementInfoToBy(key)), text);
    }

    @Step("<key> listesiden herhangi bir elemana tıkla.")
    public void randomClick(String key) {
        List<MobileElement> products = findElements(selector.getElementInfoToBy(key));
        int rnd = randomNumber(0, products.size());
        System.out.println(products.size());
        products.get(rnd).click();
    }


    @Step("<key> elementinin yazısı <text> görünene kadar sepetteki tüm ürünler <key2> elementiyle silinir.")
    public void deleteItemsBasket(String key, String text, String key2) {

        logger.info("sepetteki ürünler hiç ürün kalmayana kadar silinecektir.");
        MobileElement noResultText = findElement(selector.getElementInfoToBy(key));
        List<MobileElement> basketItemList = findElements(selector.getElementInfoToBy(key2));
        if (basketItemList.size() > 0){
            while (true){
                if (basketItemList.get(0).isDisplayed()){
                    basketItemList.get(0).click();
                        if (noResultText.getText().equals(text)){
                            break;
                        }
                    continue;
                }else {
                    break;
                }
            }
        }
        logger.info("sepetteki ürünler silindi.");
    }


    @Step("<adet> tane ürün <key> elementinin yazısı <text> görünene kadar sepetteki tüm ürünler <key2> elementiyle silinir. <key3> bilgisiyle ürünün sayısı kadar tıklanır.")
    public void deleteAllBasketItems(int adet, String key, String text, String key2, String key3) throws InterruptedException {


            int clickCount = adet-1;
            for(int x = 0; x<=clickCount-1; x++){
                logger.info("sepetteki ürünler hiç ürün kalmayana kadar silinecektir.");
                List<MobileElement> basketNegativeButtonList = findElements(selector.getElementInfoToBy(key2));

                ArrayList<MobileElement> productList = new ArrayList<>();

                for (int f=0; f<=basketNegativeButtonList.size()-1; f++){
                    productList.add(basketNegativeButtonList.get(f));
                }
                if (productList.get(0).isEnabled()){
                    logger.info("döngüye girildi, silme işlemi yapılıyor.");
                    List<MobileElement> productCountList = findElements(selector.getElementInfoToBy(key3));
                    ArrayList<MobileElement> productCount = new ArrayList<>();

                    for (int l=0; l<=productCountList.size()-1; l++){
                        productCount.add(productCountList.get(l));
                    }

                    System.out.println("productListsize: " + productList.size());
                    for (int c=0; c<=productList.size()-1; c++){
                        if (c==clickCount){
                            System.out.println("breaka girdi");
                            break;
                        }
                        System.out.println("Tıklama yapılıyor");
                        if (priceParseInt(productCountList.get(c).getText())==3){
                            System.out.println("tıklama başladı");
                            basketNegativeButtonList.get(c).click();
                            basketNegativeButtonList.get(c).click();
                            basketNegativeButtonList.get(c).click();
                            System.out.println("tıklama bitti");

                            System.out.println("productListsize: " + productList.size());
                        }


                    }
                    logger.info("ürünün silme işlemi tamamlandı");
                    if (x==clickCount){
                        logger.info("ürünün silme işlemi tamamlandı...Döngüden çıkılıyor");
                        break;
                    }
                    Thread.sleep(1000);
                }


            }

        logger.info("Sepetteki ürünler Başarıyla silindi.");
        }



    @Step("sepetteki tüm ürünleri <key> ile bulduktan sonra adedini <adet> tane yap")
    public void increaseProductsPiece(String key, int adet) {

        int clickCount = adet-1;
        logger.info("Sepetteki ürünlerin adedi " + adet + " olarak güncellenmeye başlanmıştır.");

        Dimension size = appiumDriver.manage().window().getSize();
        int x = size.getWidth() - 1;
        int starty = (int) (size.getHeight() * 0.65);
        int endy = (int) (size.getHeight() * 0.15);

        new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                .moveTo(PointOption.point(x, endy))
                .release().perform();

        List<MobileElement> basketItemIncreaseButtonLıst = findElements(selector.getElementInfoToBy(key));

        ArrayList<MobileElement> productList = new ArrayList<>();

        for (int f=0; f<=basketItemIncreaseButtonLıst.size()-1; f++){
            productList.add(basketItemIncreaseButtonLıst.get(f));
        }
        System.out.println("size " + productList.size());
        for (int i=0; i<=productList.size()-1; i ++){
           if (i==0){
               if (clickCount==1){
                   productList.get(i).click();
               }else if (clickCount==2){
                   productList.get(i).click();
                   productList.get(i).click();
               }else if (clickCount==3){
                   productList.get(i).click();
                   productList.get(i).click();
                   productList.get(i).click();
               }
           }else if (i==1){
               if (clickCount==1){
                   productList.get(i).click();
               }else if (clickCount==2){
                   productList.get(i).click();
                   productList.get(i).click();
               }else if (clickCount==3){
                   productList.get(i).click();
                   productList.get(i).click();
                   productList.get(i).click();
               }
           }else if (i==2){
               if (clickCount==1){
                   productList.get(i).click();
               }else if (clickCount==2){
                   productList.get(i).click();
                   productList.get(i).click();
               }else if (clickCount==3){
                   productList.get(i).click();
                   productList.get(i).click();
                   productList.get(i).click();
               }
           }else {
               if (clickCount==1){
                   productList.get(i).click();
               }else if (clickCount==2){
                   productList.get(i).click();
                   productList.get(i).click();
               }else if (clickCount==3){
                   productList.get(i).click();
                   productList.get(i).click();
                   productList.get(i).click();
               }
           }
        }


        logger.info("sepetteki ürünlerin adedi " + adet + " olarak güncellenmiştir.");
    }

    @Step("sepetteki tüm ürünlerin fiyatları <key> ile bulduktan <key2> toplam fiyatla eşit olduğu kontrol edilir. Bu işlem yapılırken ürün sayıları <key3> bilgisiyle alınır.")
    public void controlProductTotal(String key, String key2, String key3) {

        Dimension size = appiumDriver.manage().window().getSize();
        int x = size.getWidth() - 1;
        int starty = (int) (size.getHeight() * 0.65);
        int endy = (int) (size.getHeight() * 0.15);

        new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                .moveTo(PointOption.point(x, endy))
                .release().perform();

        List<MobileElement> productPriceInfoList = findElements(selector.getElementInfoToBy(key));
        List<MobileElement> productCountList = findElements(selector.getElementInfoToBy(key3));


        ArrayList<MobileElement> productPrices = new ArrayList<>();
        ArrayList<MobileElement> productCount = new ArrayList<>();

        for (int f=0; f<=productPriceInfoList.size()-1; f++){
            productPrices.add(productPriceInfoList.get(f));
        }
        for (int l=0; l<=productCountList.size()-1; l++){
            productCount.add(productCountList.get(l));
        }

        int totalPrice=0;
        for (int c=0; c<=productPriceInfoList.size()-1; c++){
             totalPrice += priceParseInt(productCountList.get(c).getText()) * priceParseInt(productPriceInfoList.get(c).getText());
        }
        System.out.println("toplam para =" + totalPrice + "dır");

        logger.info("ürün fiyatlarının toplamı sepet toplamıyla karşılaştırılıyor.");
        MobileElement totalAmount = findElement(selector.getElementInfoToBy(key2));

        Assert.assertEquals(totalPrice,priceParseInt(totalAmount.getText()));

        logger.info("Ürün fiyatlarıyla Sepet toplamı aynı");
    }

    @Step("<key> sepet sayfasından ürünlerin değeri ile <key2> payment amount değeri karşılaştırılır. <key3> butonuna tıklanarak sepetten ödeme adımına geçilir.")
    public void compareTotalPrices(String key,String key2, String key3){
        logger.info("Sepetteki ürün fiyatıyla ödeme adımındaki ürün fiyatı karşılaştırması başladı");
        MobileElement totalAmount = findElement(selector.getElementInfoToBy(key));
        int totalPriceBasket = priceParseInt(totalAmount.getText());
        logger.info("Sepetteki toplam ücret = " + totalPriceBasket + " TL dir.");

        MobileElement paymentButton = findElement(selector.getElementInfoToBy(key3));
        paymentButton.click();

        MobileElement paymentAmount = findElement(selector.getElementInfoToBy(key2));
        int totalPricePayment = priceParseInt(paymentAmount.getText());
        logger.info("Sepetteki toplam ücret = " + totalPricePayment + " TL dir.");

        Assert.assertEquals(totalPriceBasket,totalPricePayment);

        logger.info("Sepetteki ürün fiyatıyla ödeme adımındaki ürün fiyatı aynıdır");
    }

    @Step("Eğer ürün bulunamadıysa swipe et")
    public void basicSwipe() {
        Dimension size = appiumDriver.manage().window().getSize();
        int x = size.getWidth() - 1;
        int starty = (int) (size.getHeight() * 0.65);
        int endy = (int) (size.getHeight() * 0.15);
        new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                .moveTo(PointOption.point(x, endy))
                .release().perform();
    }


    @Step("<key> listesindeki tüm elemanları almak için swipe et <key2> listesindekiyle tıkla")
    public void swipeMethod(String key, String key2) throws InterruptedException {
        if (appiumDriver instanceof IOSDriver) {
            Dimension size = appiumDriver.manage().window().getSize();
            int x = size.getWidth() - 1;
            int starty = (int) (size.getHeight() * 0.10);
            int endy = (int) (size.getHeight() * 0.90);

            new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                    .moveTo(PointOption.point(x, endy))
                    .release().perform();
            System.out.println("ios swipe çalıştı");
        } else {

            Dimension size = appiumDriver.manage().window().getSize();
            int x = size.getWidth() - 1;
            int starty = (int) (size.getHeight() * 0.65);
            int endy = (int) (size.getHeight() * 0.15);

            ArrayList<MobileElement> productList = new ArrayList<>();

            while (true) {
                List<MobileElement> products1 = findElements(selector.getElementInfoToBy(key));
                logger.info(products1.get(0).getText());
                logger.info(products1.get(1).getText());

                productList.add(products1.get(0));
                productList.add(products1.get(1));


                new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                        .moveTo(PointOption.point(x, endy))
                        .release().perform();
                logger.info("Kaydırma işlemi y düzleminde y: " + starty + " den başlanarak y: " + endy + " ye kadar yapıldı");
                if (productList.size() != 8) {
                    continue;
                } else {
                    //Her findElements'te 4 eleman bulur. Sayfada gördüğü ilk 2 yi alarak ilerlenir. Sayfa sonunda tekrar ilk 2 yi ekleyeceğinden son 4 eleman duplicated olur
                    //Buna çözüm olarak ekranın sonuna gelindiğinde(size=8 oldu) duplicate olanlar silinerek bulunan 4 elementten son 2si alınır.
                    productList.remove(products1.get(0));
                    productList.remove(products1.get(1));
                    productList.add(products1.get(2));
                    productList.add(products1.get(3));
                    logger.info(" Duplicate olan " + products1.get(0).getText() +  " silindi yerine " + products1.get(2).getText() + " eklendi." );
                    logger.info(" Duplicate olan " + products1.get(1).getText() +  " silindi yerine " + products1.get(3).getText() + " eklendi." );
                    break;
                }
            }

            logger.info("Aşağı kaydırma işlemi tamamlandı, Ürünler bir listeye alındı");

            Thread.sleep(2000);

            MobileElement randomSelectedElement = productList.get(randomNumber(2, productList.size() - 1));
            logger.info("Rastgele ürün listeden seçildi , yukarı kaydırıp rastgele itemi bulma işlemi başlıyor.");

            while (true) {
                List<MobileElement> products3 = findElements(selector.getElementInfoToBy(key));
                logger.info("döngüye giriliyor");
                new TouchAction(appiumDriver)
                        .longPress(PointOption.point(x, endy))
                        .moveTo(PointOption.point(x, starty))
                        .release().perform();

                logger.info("kaydırma yapıldı");


                boolean bool = randomSelectedElement.getText().equals(products3.get(2).getText()) ^ randomSelectedElement.getText().equals(products3.get(3).getText());
                boolean bool2 = randomSelectedElement.getText().equals(products3.get(0).getText()) ^ randomSelectedElement.getText().equals(products3.get(1).getText());
                if (bool) {
                    if (randomSelectedElement.getText().equals(products3.get(2).getText())) {
                        logger.info("element bulundu. " + products3.get(2).getText());
                    } else {
                        logger.info("element bulundu. " + products3.get(3).getText());
                    }
                    break;
                } else if (bool2) {
                    if (randomSelectedElement.getText().equals(products3.get(0).getText())) {
                        logger.info("element bulundu. " + products3.get(0).getText());
                    } else {
                        logger.info("element bulundu. " + products3.get(0).getText());
                    }
                    break;
                } else {
                    continue;
                }

            }

            List<MobileElement> addButtonList = findElements(selector.getElementInfoToBy(key2));
            //Bu döngü rastgele itemin olduğu kısıma swipe edildikten sonra eğer 4 itemin de + butonu aynı anda gelmeme durumu için tasarlandı
            if ((addButtonList.get(0).isDisplayed()) && (addButtonList.get(1).isDisplayed()) && addButtonList.get(2).isDisplayed() && addButtonList.get(3).isDisplayed()){
                addButtonList.get(randomNumber(0,5)).click();
                logger.info("Rastgele itemin olduğu sayfada tekrar 4 ürün arasından Rastgele tıklandı");
            }
            else if ((addButtonList.get(0).isDisplayed()) && (addButtonList.get(1).isDisplayed())) {
                logger.info("Rastgele itemin olduğu sayfada ilk 2 ürün arasından Rastgele tıklandı");
                addButtonList.get(randomNumber(0,3)).click();
            } else if ((addButtonList.get(2).isDisplayed()) && (addButtonList.get(3).isDisplayed())) {
                logger.info("Rastgele itemin olduğu sayfada son 2 ürün arasından Rastgele tıklandı");
                addButtonList.get(randomNumber(2,3)).click();
            } else {
                logger.info("Rastgele itemin olduğu sayfada ilk ürün tıklandı");
                addButtonList.get(0).click();
            }

            logger.info("Android swipe çalıştı, ürünler listeye eklenip rastgele tıklandı");

        }
    }
}







