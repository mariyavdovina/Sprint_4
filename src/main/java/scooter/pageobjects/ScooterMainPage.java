package scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterMainPage {
    private WebDriver driver;

    //Верхняя кнопка Заказать
    private By buttonOrderUp = By.xpath("//button[@class='Button_Button__ra12g']");
    //Нижняя кнопка Заказать
    private By buttonOrderBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Вопросы о важном
    public By getButtonOrderUp() {
        return buttonOrderUp;
    }
    public By getButtonOrderBottom() {
        return buttonOrderBottom;
    }

    public ScooterMainPage(WebDriver driver){
        this.driver = driver;
    }
    //Нажатие кнопки Заказать, нижней или верхней
    public void pressOrder(By buttonOrder) {
        driver.findElement(buttonOrder).click();
    }

    //Метод для проверки корректного отображения текста ответов на Вопросы о важном
    public String checkQuestion(By question, By answer){
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(question).click();
        String answerText = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(answer)).getText();
        return answerText;
    }
}