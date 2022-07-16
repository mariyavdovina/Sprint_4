package scooter.pageobjects;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterMainPage {
    private WebDriver driver;

    //Верхняя кнопка Заказать
    private By buttonOrderUp = By.xpath("//button[@class='Button_Button__ra12g']");
    //Нижняя кнопка Заказать
    private By buttonOrderBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Вопросы о важном
    private By[] questions = new By[8];
    //Щтветы на вопросы
    private By[] answers = new By[8];

    public By[] getAnswers() {
        return answers;
    }
    public By[] getQuestions() {
        return questions;
    }
    public By getButtonOrderUp() {
        return buttonOrderUp;
    }
    public By getButtonOrderBottom() {
        return buttonOrderBottom;
    }

    public ScooterMainPage(WebDriver driver){
        this.driver = driver;
    }

    public By [] setQuestions(){
        questions[0]=By.xpath(".//div[@aria-controls='accordion__panel-0']");
        questions[1]=By.xpath(".//div[@aria-controls='accordion__panel-1']");
        questions[2]=By.xpath(".//div[@aria-controls='accordion__panel-2']");
        questions[3]=By.xpath(".//div[@aria-controls='accordion__panel-3']");
        questions[4]=By.xpath(".//div[@aria-controls='accordion__panel-4']");
        questions[5]=By.xpath(".//div[@aria-controls='accordion__panel-5']");
        questions[6]=By.xpath(".//div[@aria-controls='accordion__panel-6']");
        questions[7]=By.xpath(".//div[@aria-controls='accordion__panel-7']");
        return questions;
    }
    public By [] setAnswers(){
        answers[0] = By.xpath(".//div[@aria-labelledBy='accordion__heading-0']");
        answers[1] = By.xpath(".//div[@aria-labelledBy='accordion__heading-1']");
        answers[2] = By.xpath(".//div[@aria-labelledBy='accordion__heading-2']");
        answers[3] = By.xpath(".//div[@aria-labelledBy='accordion__heading-3']");
        answers[4] = By.xpath(".//div[@aria-labelledBy='accordion__heading-4']");
        answers[5] = By.xpath(".//div[@aria-labelledBy='accordion__heading-5']");
        answers[6] = By.xpath(".//div[@aria-labelledBy='accordion__heading-6']");
        answers[7] = By.xpath(".//div[@aria-labelledBy='accordion__heading-7']");
        return answers;
    }
    //Нажатие кнопки Заказать, нижней или верхней
    public void pressOrder(By buttonOrder) {
        driver.findElement(buttonOrder).click();
    }
    //Метод для проверки корректного отобрпажения текста ответов на Вопросы о важном
    public String checkQuestion(By question, By answer){
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(question).click();
        String answerText = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(answer)).getText();
        return answerText;
    }
}