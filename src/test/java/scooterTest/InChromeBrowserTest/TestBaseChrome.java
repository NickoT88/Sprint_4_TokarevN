package scooterTest.InChromeBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseChrome {
    WebDriver driver;
    //подключение браузера и установление ожидания в 5 секунд

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //закрываю браузер

    public void tearDowm() {
        driver.quit();
    }
}
