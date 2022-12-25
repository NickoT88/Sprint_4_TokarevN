package scooterTest.InChromeBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.HomePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImpotantQuestionTest extends TestBaseChrome {

    WebDriver driver;
    private static int listIndex;
    private static boolean correspondence;
    //конструктор тест-класса Вопросы о важном с 2 параметрами
    public ImpotantQuestionTest(int listIndex, boolean correspondence) {
        this.listIndex=listIndex;
        this.correspondence=correspondence;
    }
    //подключение драйвера браузера и установление ожидания в 5 секунд
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {0, true},
                {1, true},
                {2, true},
                {3, true},
                {4, true},
                {5, true},
                {6, true},
                {7, true},
        };
    }

    @Test
    public void IsVisibleTextWhenClickedButton() {
        //создаю объект класса главнйо страницы
        HomePage objHomePage = new HomePage(driver);
        //открываю саму главную страницу
        objHomePage.openScooterPage();
        //кликаю по кнопке с вопросом в зависимости от индекса
        objHomePage.clickButtonsImpotantQuestions(listIndex);
        //сравниваю результаты
        assertEquals(correspondence,objHomePage.contentIsDisplayed(listIndex));
    }
    //закрываю браузер
    @After
    public void tearDowm() {
        driver.quit();
    }


}