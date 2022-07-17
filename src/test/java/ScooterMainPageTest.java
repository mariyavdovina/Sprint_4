import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import scooter.pageobjects.ScooterMainPage;

@RunWith(Parameterized.class)
public class ScooterMainPageTest {
    private final By question;
    private final By answer;
    private final String expected;
    private static final String[] expecteds = new String[]{"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    private final WebDriver driver;
    private ScooterMainPage objScooterMainPage;
    /*    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objScooterMainPage = new ScooterMainPage(driver);
    }*/

    public ScooterMainPageTest(By question, By answer, String expected) {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objScooterMainPage = new ScooterMainPage(driver);
        this.question = question;
        this.answer = answer;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswerData() {

        return new Object[][]{
                {By.xpath(".//div[@aria-controls='accordion__panel-0']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-0']"), expecteds[0]},
                {By.xpath(".//div[@aria-controls='accordion__panel-1']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-1']"), expecteds[1]},
                {By.xpath(".//div[@aria-controls='accordion__panel-2']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-2']"), expecteds[2]},
                {By.xpath(".//div[@aria-controls='accordion__panel-3']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-3']"), expecteds[3]},
                {By.xpath(".//div[@aria-controls='accordion__panel-4']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-4']"), expecteds[4]},
                {By.xpath(".//div[@aria-controls='accordion__panel-5']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-5']"), expecteds[5]},
                {By.xpath(".//div[@aria-controls='accordion__panel-6']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-6']"), expecteds[6]},
                {By.xpath(".//div[@aria-controls='accordion__panel-7']"), By.xpath(".//div[@aria-labelledBy='accordion__heading-7']"), expecteds[7]},

        };
    }

    @Test
    public void shouldBeAnswer() {

        String actual = objScooterMainPage.checkQuestion(question, answer);
        Assert.assertEquals(expected, actual);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
