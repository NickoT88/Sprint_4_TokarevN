package scooterTest.InFireFoxBrowserTest;

import org.junit.Test;
import ru.yandex.praktikum.HomePage;
import static org.junit.Assert.assertTrue;

public class ImpotantQuestionTest extends ConnectionFF {

    @Test
    public void IsVisibleTextWhenClickedButton() {
        //подключение драйвера браузера и установление ожидания
        open();
        //создаю объект класса главнйо страницы
        HomePage objHomePage = new HomePage(driver);
        //открываю саму главную страницу
        objHomePage.openScooterPage();

        for(int listIndex=0; listIndex<=7; listIndex++ ) {
            objHomePage.clickButtonsImpotantQuestions(listIndex);
            assertTrue(objHomePage.contentIsDisplayed(listIndex));
        }
        //закрываю браузер
        close();
    }

}
