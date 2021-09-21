package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseSteps {
    @И("^открыли страницу$")
    public void openPage() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
        Selenide.open("https://demoqa.com/automation-practice-form");
    }
    @И("^ввели в поле имени \"([^\"]*)\"$")
    public void inputKeysInField(String keys) {
        $(By.id("firstName")).sendKeys(keys);
    }
}
