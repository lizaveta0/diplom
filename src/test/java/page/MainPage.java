package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private String payButton = "//span[text() = '%s']";

    @Step("Выбрали метод покупки - {method}")
    public void selectPurchaseMethod(String method) {
        $(By.xpath(String.format(payButton, method))).click();
    }
}
