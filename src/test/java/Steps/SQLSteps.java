package Steps;

import io.qameta.allure.Step;

import static data.SQLHelper.getPurchaseStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLSteps {
    @Step("Проверили, что статус платежа в БД payment_entity = {status}")
    public void checkPurchaseStatusInPaymentEntity(String status) {
        assertEquals(status, getPurchaseStatus("payment_entity"));
    }

    @Step("Проверили, что статус платежа в БД credit_request_entity = {status}")
    public void checkPurchaseStatusInCreditRequestEntity(String status) {
        assertEquals(status, getPurchaseStatus("credit_request_entity"));
    }
}
