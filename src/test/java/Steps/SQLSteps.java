package Steps;

import io.qameta.allure.Step;

import static data.SQLHelper.getPurchaseStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLSteps {
    @Step("Проверили, что статус платежа в БД = {status}")
    public void checkPurchaseStatuInsDB(String status) {
        assertEquals(getPurchaseStatus(), status);
    }
}
