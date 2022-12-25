package scooterTest.InFireFoxBrowserTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.*;
import scooterTest.InChromeBrowserTest.TestBaseChrome;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


//Класс с автотестами
@RunWith(Parameterized.class)
public class OrderStatusTest extends TestBaseFireFox {
    WebDriver driver;
    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;
    //конструктор тест-класса
    public OrderStatusTest(String buttonLocation, String name, String surname, String address, String telephone, String newDate,int days, String newColor, String newComment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.newDate = newDate;
        this.days = days;
        this.newColor = newColor;
        this.newComment = newComment;
    }
    //подключение драйвера браузера и установление ожидания в 5 секунд. Для FireFox нужно прописать путь до файла geckodriver.exe
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "G:\\EDIprojects\\FireFoxTest\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { "up", "Василий", "Петров", "Московская", "89001144666", "31.12.2022", 1, "black", "Скорее везите, уже не могу!"},
                { "down", "Петр", "Васильев", "Ленинградская", "89001166444", "30.12.2022", 5, "grey", "Мне самый безысходный из всех"},

        };
    }

    //тест ввода данных в поля на странице Для кого самокат
    @Test
    public void enterOrderAllDataTest() {


        //создаю объект главной страницы
        HomePage objHomePage = new HomePage(driver);
        //обращаюсь к сайту Самоката
        objHomePage.openScooterPage();
        //выбираю кнопку Заказать для клика
        objHomePage.chooseOrderButtonAndClick(buttonLocation);

        //создаю объект страницы Для кого самокат
        new OrderDataPage(driver)
                //вызываю метод для ввода данных на странице Для кого самокат
                .enterOrderAllData(name,surname,address,telephone);
        //создаю объект страницы Про аренду
        new RentOrderPage(driver)
                //вызываю метод для ввода данных на странице Про аренду
                .enterAllDataRentOrder(newDate, days, newColor, newComment);
        //создаю объект страницы Хотите оформить заказ?
        new WishOrder(driver)
                //нажимаю кнопку Да в окне Хотите оформить заказ?
                .clickOkButton();
        //создаю объект страницы Заказ оформлен
        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        //проверяю отображается ли сообщение, что заказ оформлен
        assertTrue("Текст страницы Заказа не соответствует полученному  ", objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }

    //закрываю браузер
    @After
    public void tearDowm() {
        driver.quit();
    }
}
