package scooterTest.InChromeBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//базовый класс дял подключения драйвера Chrome
public class ConnectionChrome {
    WebDriver driver;
    //подключение драйвера браузера и установление ожидания в 5 секунд
    public void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //закрываю браузер

    public void close() {

        driver.quit();
    }
}
