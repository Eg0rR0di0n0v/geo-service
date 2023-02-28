package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


public class LocalizationServiceImplTest {

    @Test
    @DisplayName("Test, Method public String locale(Country country)")
    void localeShouldReturnCorrectMessage() {

        Country[] countries = {Country.RUSSIA, Country.GERMANY, Country.USA, Country.BRAZIL};

        var localizationService = new LocalizationServiceImpl();

        for (Country cp: countries) {
            String expectedText = "Welcome";
            if (cp.equals(Country.RUSSIA)){expectedText = "Добро пожаловать";}
            Assertions.assertEquals(expectedText, localizationService.locale(cp));
            System.out.println("Country = { " + cp + " } Answer = " + localizationService.locale(cp));
        }

    }

}
