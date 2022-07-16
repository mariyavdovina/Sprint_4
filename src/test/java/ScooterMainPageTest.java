import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import scooter.pageobjects.ScooterMainPage;

import static org.junit.Assert.assertEquals;

public class ScooterMainPageTest {
    private final String[] expected = new String[]{"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
    private WebDriver driver;
    private ScooterMainPage objScooterMainPage;
    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objScooterMainPage = new ScooterMainPage(driver);
        objScooterMainPage.setQuestions();
        objScooterMainPage.setAnswers();
    }

    @Test
    public void testQuestionFirst() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[0], objScooterMainPage.getAnswers()[0]), expected[0]);
    }

    @Test
    public void testQuestionSecond() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[1], objScooterMainPage.getAnswers()[1]), expected[1]);
    }
    @Test
    public void testQuestionThird() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[2], objScooterMainPage.getAnswers()[2]), expected[2]);
    }
    @Test
    public void testQuestionForth() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[3], objScooterMainPage.getAnswers()[3]), expected[3]);
    }
    @Test
    public void testQuestionFifth() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[4], objScooterMainPage.getAnswers()[4]), expected[4]);
    }
    @Test
    public void testQuestionSixth() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[5], objScooterMainPage.getAnswers()[5]), expected[5]);
    }
    @Test
    public void testQuestionSeventh() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[6], objScooterMainPage.getAnswers()[6]), expected[6]);
    }
    @Test
    public void testQuestionEights() {
        assertEquals(objScooterMainPage.checkQuestion(objScooterMainPage.getQuestions()[7], objScooterMainPage.getAnswers()[7]), expected[7]);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
