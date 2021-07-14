package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;
    public static Properties dataProperties;
    public static Properties envProperties;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static WebDriverWait wait;

    public TestBase() {
    try {
        envProperties = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/environment.properties");
        envProperties.load(ip);
    } catch (
    FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


    public static void initialization () {
        String browserName = envProperties.getProperty("browser");
        int windowWidth= Integer.parseInt(envProperties.getProperty("width"));
        int windowHeight=Integer.parseInt(envProperties.getProperty("height"));
        int pageLoadTimeout=Integer.parseInt(envProperties.getProperty("pageLoadTimeout"));
        int waitTimeout=Integer.parseInt(envProperties.getProperty("waitTimeout"));

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", envProperties.getProperty("chromeDriverPath") + "/" + envProperties.getProperty("chromeDriverName"));
            ChromeOptions options = getChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browserName.equals("FF")) {
            System.setProperty("My dummy String","My dummy String");
            driver = new FirefoxDriver();
        }

        setEventListener();

        wait = new WebDriverWait(driver, 60);
        Dimension dm = new Dimension(windowWidth, windowHeight);
        driver.manage().window().setSize(dm);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(waitTimeout, TimeUnit.SECONDS);
        driver.get(envProperties.getProperty("systemUnderTestUrl"));

    }

    private static void setEventListener() {
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
    }

    private static ChromeOptions getChromeOptions() {

        checkDownloadPath();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\" + envProperties.getProperty("chromeDownloadPath"));
        options.setExperimentalOption("prefs", prefs);
        if (envProperties.getProperty("headless").equalsIgnoreCase("true")) {options.addArguments("headless");}
        return options;
    }


    private static void checkDownloadPath() {
        if (envProperties.getProperty("browser").equals("chrome")) {
            File directoryLogs = new File(envProperties.getProperty("chromeDownloadPath"));
            if (!directoryLogs.exists())
                directoryLogs.mkdirs();
        }
    }

    public static void tearDownTestBase(){
        driver.close();
        driver.quit();
    }
}
