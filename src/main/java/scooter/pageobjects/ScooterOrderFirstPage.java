package scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Первая страница оформления заказа
public class ScooterOrderFirstPage {

    private WebDriver driver;
    //Селекторы полей заказа
    private By firstName = By.xpath("//input[@placeholder='* Имя']");
    private By secondName = By.xpath("//input[@placeholder='* Фамилия']");
    private By adress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By stationField = By.className("select-search__value");
    private By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By next = By.xpath("//button[text()='Далее']");

    //Выбор станций для заказа с помощью верхней и нижней кнопок Заказать
    private By stationUp = By.xpath("//div[text()='Черкизовская']");
    private By stationBottom = By.xpath("//div[text()='Сокольники']");

    public By getStationUp() {
        return stationUp;
    }

    public By getStationBottom() {
        return stationBottom;
    }

    public ScooterOrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполняем поля заказа
    public void setFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setSecondName(String secondName) {
        driver.findElement(this.secondName).sendKeys(secondName);
    }

    public void setAdress(String adress) {
        driver.findElement(this.adress).sendKeys(adress);
    }

    public void setStation(By station) {
        driver.findElement(stationField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("select-search__input")));
        driver.findElement(station).click();
    }

    public void setPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }

    //Нажимаем Далее для перехода ко второй странице заказа
    public void pressNext() {
        driver.findElement(next).click();
    }

    //Переход ко второй странице заказа в одном методе
    public void goToNextPage(String firstName, String secondName, String adress, By station, String phone) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAdress(adress);
        setStation(station);
        setPhone(phone);
        pressNext();
    }

    //Ожидание рендера первой страницы заказа
    public void waitForLoadScooterOrderFirstPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Header__214zg")));
    }


}
