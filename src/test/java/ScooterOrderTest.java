import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scooter.pageobjects.ScooterMainPage;
import scooter.pageobjects.ScooterOrderFirstPage;
import scooter.pageobjects.ScooterOrderSecondPage;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private final WebDriver driver;
    private final By orderButtonFirst;
    private final By orderButtonSecond;
    private ScooterMainPage objScooterMainPage;

    public ScooterOrderTest(By orderButtonFirst, By orderButtonSecond) {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objScooterMainPage = new ScooterMainPage(driver);
        this.orderButtonFirst = orderButtonFirst;
        this.orderButtonSecond = orderButtonSecond;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderButtonData() {

        return new Object[][]{
                {By.xpath("//button[@class='Button_Button__ra12g']"), By.xpath("//button[@class='Button_Button__ra12g']")},
                {By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"), By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")}

        };
    }
    @Test
    public void shouldBeOrderButton() {
        if (orderButtonFirst.equals(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"))) {
            WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }
        objScooterMainPage.pressOrder(orderButtonFirst);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        ScooterOrderFirstPage objScooterOrderFirstPage = new ScooterOrderFirstPage(driver);
        objScooterOrderFirstPage.waitForLoadScooterOrderFirstPage();
        objScooterOrderFirstPage.goToNextPage("Мария", "Вдовина", "Иванова, 1", objScooterOrderFirstPage.getStation(), "+79213389556");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Когда привезти самокат']")));
        ScooterOrderSecondPage objScooterOrderSecondPage = new ScooterOrderSecondPage(driver);
        objScooterOrderSecondPage.waitForLoadScooterOrderSecondPage();
        objScooterOrderSecondPage.finalizeOrder(objScooterOrderSecondPage.getDate(), objScooterOrderSecondPage.getPeriod(), objScooterOrderSecondPage.getColour(), "комментарий", orderButtonSecond);
        //Нажатие верхней кнопки заказа не работает
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Да']")));
        //Нажатие кнопки Да тоже не работает
        // driver.findElement(By.xpath("//button[text()='Да']")).click();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}

