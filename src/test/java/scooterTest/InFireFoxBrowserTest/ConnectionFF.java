package scooterTest.InFireFoxBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
//базовый класс для подключения драйвера FireFox
public class ConnectionFF {
    WebDriver driver;
    //подключение браузера и установление ожидания в 5 секунд
    public void open() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //закрываю браузер

    public void close() {
        driver.quit();
    }
}
