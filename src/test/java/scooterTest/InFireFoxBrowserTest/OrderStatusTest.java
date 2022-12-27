package scooterTest.InFireFoxBrowserTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.*;

import static org.junit.Assert.assertTrue;


//Класс с автотестами
@RunWith(Parameterized.class)
public class OrderStatusTest extends ConnectionFF {

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
    //подключение драйвера браузера и установление ожидания в 5 секунд через
    public void setUp() {
        open();
    }
    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { "up", "Василий", "Петров", "Московская", "89001144666", "31.12.2022", 1, "black", "Скорее везите, уже не могу!"},
                { "down", "Петр", "Васильев", "Ленинградская", "89001166444", "30.12.2022", 5, "grey", "Мне самый безысходный из всех"},

        };
    }

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
        //проверяю, что поле "Заказ оформлен" отображается
        assertTrue(objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }
    //закрываю браузер
    public void tearDowm() {
        close();
    }

}
