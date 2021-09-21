import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class WebDriverTests {
    private WebDriver webDriver;
    private By firstname = By.id("firstName");
    private By lastname = By.id("lastName");
    private By email = By.id("userEmail");
    private By phone = By.id("userNumber");
    private By currentAddress = By.id("currentAddress");
    private By genderList = By.xpath("//*[@id='genterWrapper']//label");
    private By hobbiesList = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]//label");
    private By stateBtn = By.id("state");
    private By stateList = By.cssSelector(".css-11unzgr > div");
    private By cityBtn = By.id("city");
    private By cityList = By.cssSelector(".css-26l3qy-menu >div > div");
    private By submitBtn = By.id("submit");
    private By dateOfBirth = By.className("react-datepicker__input-container");
    private By yearSelect = By.className("react-datepicker__year-select");
    private By monthSelect = By.className("react-datepicker__month-select");
    private By daySelect = By.cssSelector(".react-datepicker__month>div>div");


    @Test
    public void webDriverTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Airis\\IdeaProjects\\WebDriver\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addExtensions(new File("C:\\Users\\Airis\\IdeaProjects\\WebDriver\\src\\main\\resources\\extension_4_35_0_0.crx"));
        chromeOptions.addArguments("–-load-extension=/Users/Airis/AppData/Local/Google/Chrome/User Data/Default/Extensions/cfhdojbkjhnklbpkdaibdccddilifddb/3.11.2_0");
        webDriver = new ChromeDriver(chromeOptions);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.get("https://demoqa.com/automation-practice-form");

//        js.executeScript("window.scrollBy(0,20000)");
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

//        WebElement firstName = webDriver.findElement(By.id("firstName"));
        webDriver.findElement(firstname).sendKeys("Igorrr");
        webDriver.findElement(lastname).sendKeys("Ivanovvv");
        webDriver.findElement(email).sendKeys("Ivanovvv@mail.ru");
        webDriver.findElement(phone).sendKeys("+79876543210");
        webDriver.findElement(currentAddress).sendKeys("Address");
        webDriver.findElements(genderList).get(1).click();
        webDriver.findElements(hobbiesList).get(0).click();
        webDriver.findElement(dateOfBirth).click();
        Select yearMenu = new Select(webDriver.findElement(yearSelect));
        yearMenu.selectByValue("1960");
        Select monthMenu = new Select(webDriver.findElement(monthSelect));
        monthMenu.selectByValue("1");
        js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(submitBtn));
        webDriver.findElements(daySelect).get(6).click();
        webDriver.findElement(stateBtn).click();
        webDriver.findElements(stateList).get(0).click();

        webDriver.findElement(cityBtn).click();
        webDriver.findElements(cityList).get(0).click();
        webDriver.findElement(submitBtn).click();
        Thread.sleep(5000);
//        System.out.println(firstName.getAttribute("placeholder"));
//        System.out.println(firstName.getCssValue("color"));
//        firstName.sendKeys("FFFFFFirst");
//        firstName.clear();
        webDriver.quit();
    }
}
