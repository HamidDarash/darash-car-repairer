package com.darash.carrepairer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DarashCarRepairerApplicationTests {

    @Test
    public void contextLoads() {


    }

    @Test
    public void testLatLng() {
        int i;
        for (i = 0; i <= 50; i++) {
            System.out.println(CreateLatLngRandomInRange(i, -i, i, -i));
        }
    }

    private String CreateLatLngRandomInRange(double latFrom, double latTo,
                                             double lngFrom, double lngTo) {
        double lat = getRandomInRange(latFrom, latTo);
        double lng = getRandomInRange(lngFrom, lngTo);
        return String.valueOf(lat) + "," + String.valueOf(lng);
    }

    private double getRandomInRange(double from, double to) {
        return (Math.random() * (to - from) + from);
    }


}
