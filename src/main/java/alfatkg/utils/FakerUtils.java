package alfatkg.utils;

import com.github.javafaker.Faker;

import java.util.Map;

public class FakerUtils {

    private FakerUtils(){}

    private final static Faker faker = new Faker();

    public static Map<String, String> getFromDateAndToDate() {
        String year = String.valueOf(faker.number().numberBetween(2020, 2025));
        String month = String.valueOf(faker.number().numberBetween(1, 12));
        String fromDate = String.valueOf(faker.number().numberBetween(1, 14));
        String toDate = String.valueOf(faker.number().numberBetween(14, 28));
        return Map.of("fromDate", year + month + fromDate, "toDate", year + month + toDate);
    }

}
