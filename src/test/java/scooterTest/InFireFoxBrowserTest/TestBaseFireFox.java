package scooterTest.InFireFoxBrowserTest;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseFireFox {
    WebDriver driver;
    //подключение браузера и установление ожидания в 5 секунд
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "G:\\EDIprojects\\FireFoxTest\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //закрываю браузер
    @After
    public void tearDowm() {
        driver.quit();
    }
}
