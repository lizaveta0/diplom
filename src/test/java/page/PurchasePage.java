package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PurchasePage {
    private SelenideElement submitButton = $x("//span[text() = 'Продолжить']/../..");
    private SelenideElement cardNumberField = $x("//span[text() = 'Номер карты']/following::input[1]");
    private SelenideElement cardMonthField = $x("//span[text() = 'Месяц']/following::input[1]");
    private SelenideElement cardYearField = $x("//span[text() = 'Год']/following::input[1]");
    private SelenideElement cardOwnerField = $x("//span[text() = 'Владелец']/following::input[1]");
    private SelenideElement cardCVCAndCVVField = $x("//span[text() = 'CVC/CVV']/following::input[1]");
    private String checkErrorInField = "//span[text()='%s']/..//span[contains(@class, 'input__sub')]";
    private SelenideElement notificationText = $(".notification__content");

    @Step("Заполнили форму покупки")
    public void fillForm(String number, String month,
                         String year, String owner,
                         String CVC_CVV) {
        cardNumberField.setValue(number);
        cardMonthField.setValue(month);
        cardYearField.setValue(year);
        cardOwnerField.setValue(owner);
        cardCVCAndCVVField.setValue(CVC_CVV);
    }

    @Step("Подтвердили покупку")
    public void submitPurchase() {
        submitButton.click();
    }

    @Step("Проверили, что сообщение содержит текст {error}")
    public void checkMessageForPurchase(String message) {
        notificationText.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(text(message));
    }

    @Step("Проверили, сообщение об ошибке в поле {fieldName} содержит текст {error}")
    public void checkErrorMessageFromField(String fieldName, String error) {
        $x(String.format(checkErrorInField, fieldName)).shouldBe(visible, text(error));
    }
}
