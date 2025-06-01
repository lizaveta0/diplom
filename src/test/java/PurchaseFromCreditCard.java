import Steps.SQLSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.DataHelper.CardInfo;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.APPROVED_CARD_NUMBER;
import static data.DataHelper.DECLINED_CARD_NUMBER;

public class PurchaseFromCreditCard {
    private MainPage mainPage;
    private PurchasePage purchasePage;
    private DataHelper dataHelper;
    private SQLSteps sqlSteps;

    String locale = "en";
    String number;
    String month;
    String year;
    String owner;
    String CVC_CVV;


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.reportsFolder = "target/selenide/reports";
        open("http://localhost:8080/");
        mainPage = new MainPage();

        CardInfo cardInfo = DataHelper.getCardInfo(locale);
        number = cardInfo.getCardNumber();
        month = cardInfo.getMonth();
        year = cardInfo.getYear();
        owner = cardInfo.getOwner();
        CVC_CVV = cardInfo.getCVC_CVV();

        mainPage.selectPurchaseMethod("Купить в кредит");
    }

    @Test
    public void testPurchasePositive() {
        purchasePage = new PurchasePage();
        number = APPROVED_CARD_NUMBER;
        purchasePage.fillForm(number, month, year, owner, CVC_CVV);
        purchasePage.submitPurchase();
        purchasePage.checkMessageForPurchase("Операция одобрена Банком.");
        sqlSteps = new SQLSteps();
        sqlSteps.checkPurchaseStatuInsDB("APPROVED");
    }

    @Test
    public void testPurchaseNegative() {
        purchasePage = new PurchasePage();
        number = DECLINED_CARD_NUMBER;
        purchasePage.fillForm(number, month, year, owner, CVC_CVV);
        purchasePage.submitPurchase();
        purchasePage.checkMessageForPurchase("Ошибка! Банк отказал в проведении операции.");
        sqlSteps = new SQLSteps();
        sqlSteps.checkPurchaseStatuInsDB("DECLINED");
    }
}
