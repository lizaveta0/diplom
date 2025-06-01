package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    public static final String APPROVED_CARD_NUMBER = "4444 4444 4444 4441";
    public static final String DECLINED_CARD_NUMBER = "4444 4444 4444 4442";


    public DataHelper() {
    }

    public static String generateNumber(String locale) {
        return new Faker(new Locale(locale)).finance().creditCard().replaceAll("-", "");
    }

    public static String generateMonth(String locale) {
        return String.format("%02d", new Faker(new Locale(locale)).number().numberBetween(1, 13));
    }

    public static String generateYear() {
        return String.format("%02d", (java.time.LocalDate.now().getYear() % 100) + 3);
    }

    public static String generateOwner(String locale) {
        return new Faker(new Locale(locale)).name().fullName().toUpperCase();
    }

    public static String generateCVC_CVV(String locale) {
        return new Faker(new Locale(locale)).number().digits(3);
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String owner;
        String CVC_CVV;
    }

    public static CardInfo getCardInfo(String locale) {
        return new CardInfo(generateNumber(locale), generateMonth(locale), generateYear(), generateOwner(locale), generateCVC_CVV(locale));
    }
}
