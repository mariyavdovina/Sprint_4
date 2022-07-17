package scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderSecondPage {
    private WebDriver driver;
    //Поля для заполнения данных на второй страничке оформления заказа
    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By periodField = By.xpath("//div[text()='* Срок аренды']");
    private By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Сразу задаем селекторы для оформления заказа при помощи нижней и верхней кнопок Заказать
    private By colour = By.id("black");
    private By date = By.xpath("//div[@aria-label='Choose воскресенье, 31-е июля 2022 г.']");
    private By period = By.xpath("//div[text()='сутки']");

    //Сами верхняя и нижняя кнопки Заказать
    private By buttonOrderUp = By.xpath("//button[@class='Button_Button__ra12g']");
    private By buttonOrderBottom = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public By getComment() {
        return comment;
    }

    public By getDate() {
        return date;
    }

    public By getPeriod() {
        return period;
    }

    public By getColour() {
        return colour;
    }

    public By getButtonOrderUp() {
        return buttonOrderUp;
    }

    public By getButtonOrderBottom() {
        return buttonOrderBottom;
    }

    public ScooterOrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидание рендера второй страницы заказа
    public void waitForLoadScooterOrderSecondPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Когда привезти самокат']")));
    }

    //Заполняем поля второй страницы заказа
    public void setDate(By date) {
        driver.findElement(dateField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__header")));
        driver.findElement(date).click();
    }

    public void setPeriod(By period) {
        driver.findElement(periodField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));
        driver.findElement(period).click();
    }

    public void setColour(By colour) {
        driver.findElement(colour).click();
    }

    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    //Жмем кнопку Заказать, верхнюю или нижнюю
    public void pressOrder(By buttonOrder) {
        driver.findElement(buttonOrder).click();
    }

    //Оформляем заказ
    public void finalizeOrder(By date, By period, By colour, String comment, By buttonOrder) {
        setDate(date);
        setPeriod(period);
        setColour(colour);
        setComment(comment);
        pressOrder(buttonOrder);
    }

}
