package scooterTest.InChromeBrowserTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.HomePage;
import static org.junit.Assert.assertTrue;
@RunWith(Parameterized.class)
public class ImpotantQuestionTest extends ConnectionChrome {

    private static int listIndex;
    
    public ImpotantQuestionTest(int listIndex) {
        this.listIndex=listIndex;
    }

    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
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
        assertTrue(objHomePage.contentIsDisplayed(listIndex));
    }


}
