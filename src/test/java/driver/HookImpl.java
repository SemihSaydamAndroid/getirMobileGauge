package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import selector.Selector;
import selector.SelectorFactory;
import selector.SelectorType;

import java.net.MalformedURLException;
import java.net.URL;

public class HookImpl {

    private static org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(HookImpl.class);

    public static boolean localAndroid = true;
    protected static Selector
            selector;

    protected static AppiumDriver appiumDriver;

    protected static IOSDriver<MobileElement> mobileElementIOSDriver;
    protected static FluentWait<AppiumDriver> appiumFluentWait;
    protected boolean localiOS = false;//turn off android


    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
        if (StringUtils.isEmpty(System.getenv("key"))) {
            if (localiOS) {

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities
                        .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                desiredCapabilities
                        .setCapability(MobileCapabilityType.UDID, "8cf88820750279d6cd49b48d5a079a9315598778");
                desiredCapabilities
                        .setCapability(IOSMobileCapabilityType.BUNDLE_ID, "trendyol.com.trendyol");
                desiredCapabilities
                        .setCapability(MobileCapabilityType.DEVICE_NAME, "sahaBT iPhone'u");
                desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4.2");
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new IOSDriver<>(url, desiredCapabilities);

            } else {
                logger.info("Android platformu seçildi. Android üzerinde proje kaldırılıyor.");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.VERSION, "10.0");
                capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.getir.casestudy.dev");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.getir.casestudy.modules.splash.ui.SplashActivity");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 250);
//
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AndroidDriver(url, capabilities);
                logger.info("Android üzerinde proje kaldırıldı");
            }
            selector = SelectorFactory
                    .createElementHelper(!localiOS ? SelectorType.ANDROID : SelectorType.IOS);
        }
    }

    @AfterScenario
    public void afterScenario() {

        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

}

