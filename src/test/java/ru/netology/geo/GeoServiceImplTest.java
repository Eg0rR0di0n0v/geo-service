package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.HashMap;
import java.util.Map;

public class GeoServiceImplTest {

    @Test
    @DisplayName("Test DeterminesTheLocationByIp")
    public void testDeterminesTheLocationByIp() {

        Map<Object, Object> map = new HashMap<>();
        map.put("127.0.0.1", new Location(null, null, null, 0));
        map.put("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        map.put("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32));
        map.put("172.", new Location("Moscow", Country.RUSSIA, null, 0));
        map.put("96.", new Location("New York", Country.USA, null,  0));


        GeoServiceImpl geoServiceJUnit = new GeoServiceImpl();

        for (Object o : map.keySet()) {

            String key = o.toString();
            Object value = map.get(key);
            System.out.println("Key = ( " + key + " ) Value ( " + value + " )");

            Location locTest = geoServiceJUnit.byIp(key);
            Assertions.assertEquals(value.toString(), locTest.toString());

            System.out.println("Value = " + value);
            System.out.println("Test  = " + locTest);
            System.out.println();

        }
    }
}
