import org.junit.After;
import org.junit.Test;
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

//Тестируем оформление при помощи верхней кнопки Заказать
public class ScooterOrderTest {
    private WebDriver driver;

    @Test
    public void testOrderByUpperButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ScooterMainPage objScooterMainPage = new ScooterMainPage(driver);
        objScooterMainPage.pressOrder(objScooterMainPage.getButtonOrderUp());
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        ScooterOrderFirstPage objScooterOrderFirstPage = new ScooterOrderFirstPage(driver);
        objScooterOrderFirstPage.waitForLoadScooterOrderFirstPage();
        objScooterOrderFirstPage.goToNextPage("Мария", "Вдовина", "Иванова, 1", objScooterOrderFirstPage.getStationUp(), "+79213389556");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Когда привезти самокат']")));
        ScooterOrderSecondPage objScooterOrderSecondPage = new ScooterOrderSecondPage(driver);
        objScooterOrderSecondPage.waitForLoadScooterOrderSecondPage();
        objScooterOrderSecondPage.finalizeOrder(objScooterOrderSecondPage.getDateUp(), objScooterOrderSecondPage.getPeriodUp(), objScooterOrderSecondPage.getColourUp(), "комментарий", objScooterOrderSecondPage.getButtonOrderUp());
        //Нажатие верхней кнопки заказа не работает
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Да']")));
        driver.findElement(By.xpath("//button[text()='Да']")).click();
    }

    @Test
    public void testOrderByBottomButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ScooterMainPage objScooterMainPage = new ScooterMainPage(driver);
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.pressOrder(objScooterMainPage.getButtonOrderBottom());
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        ScooterOrderFirstPage objScooterOrderFirstPage = new ScooterOrderFirstPage(driver);
        objScooterOrderFirstPage.waitForLoadScooterOrderFirstPage();
        objScooterOrderFirstPage.goToNextPage("Мария", "Вдовина", "Иванова, 1", objScooterOrderFirstPage.getStationBottom(), "+79213389556");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Когда привезти самокат']")));
        ScooterOrderSecondPage objScooterOrderSecondPage = new ScooterOrderSecondPage(driver);
        objScooterOrderSecondPage.waitForLoadScooterOrderSecondPage();
        objScooterOrderSecondPage.finalizeOrder(objScooterOrderSecondPage.getDateBottom(), objScooterOrderSecondPage.getPeriodBottom(), objScooterOrderSecondPage.getColourBottom(), "комментарий", objScooterOrderSecondPage.getButtonOrderBottom());
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Да']")));
        //Кнопка Да тоже не работает
        driver.findElement(By.xpath("//button[text()='Да']")).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
