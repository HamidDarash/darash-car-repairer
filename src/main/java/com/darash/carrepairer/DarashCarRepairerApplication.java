package com.darash.carrepairer;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.entities.RepresentationService;
import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserByLocation;
import com.darash.carrepairer.services.PitShopServiceImpl;
import com.darash.carrepairer.services.UserByLocationServiceImpl;
import com.darash.carrepairer.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableReactiveCassandraRepositories(basePackages = {"com.darash.carrepairer.repositories"})

@ComponentScan
@EnableAutoConfiguration
public class DarashCarRepairerApplication {

    private final UserServiceImpl userService;
    private final PitShopServiceImpl pitShopService;
    private final UserByLocationServiceImpl userByLocationService;

    @Autowired
    public DarashCarRepairerApplication(UserServiceImpl userService, PitShopServiceImpl pitShopService, UserByLocationServiceImpl userByLocationService) {
        this.userService = userService;
        this.pitShopService = pitShopService;
        this.userByLocationService = userByLocationService;
    }


    public static void main(String[] args) {
        SpringApplication.run(DarashCarRepairerApplication.class, args);
//        SchemaSetup schemaSetup = new SchemaSetup("math.cql");
//        schemaSetup.runCQL();

    }

    // create random lat lng
    private String CreateLatLngRandomInRange(double latFrom, double latTo,
                                             double lngFrom, double lngTo) {
        double lat = getRandomInRange(latFrom, latTo);
        double lng = getRandomInRange(lngFrom, lngTo);
        return String.valueOf(lat) + "," + String.valueOf(lng);
    }

    private double getRandomInRange(double from, double to) {
        return (Math.random() * (to - from) + from);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            //35.7261,51.3304

//            User user = new User("0082188815", "حمیدرضا دارش", "onyxtv2018",
//                    "hamid.darash@yahoo.com", "کرج مهرشهر", "09124240754", "02144193657", null,
//                    null, true, true, "192.168.50.190");
//
//            User user2 = new User("0091588816", "سعید عبدالهی", "onyxtv2017",
//                    "s.abdollahi@yahoo.com", "شهریار", "09124423263", "02144203365", null,
//                    null, true, false, "209.116.205.10");
//
//            userService.save(user).subscribe(System.out::println);
//            userService.save(user2).subscribe(System.out::println);
//
//            UserByLocation userByLocation = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation2 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-60, 50, -70, 30));
//            UserByLocation userByLocation3 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-80, 40, -80, 40));
//            UserByLocation userByLocation4 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation5 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation6 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation7 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation8 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation9 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation10 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation11 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation12 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation13 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation14 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation15 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation16 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation17 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation18 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation19 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            UserByLocation userByLocation20 = new UserByLocation(user.getId(), CreateLatLngRandomInRange(-50, 50, -30, 30));
//            userByLocationService.save(userByLocation).subscribe(System.out::println);
//            userByLocationService.save(userByLocation2).subscribe(System.out::println);
//            userByLocationService.save(userByLocation3).subscribe(System.out::println);
//            userByLocationService.save(userByLocation4).subscribe(System.out::println);
//            userByLocationService.save(userByLocation5).subscribe(System.out::println);
//            userByLocationService.save(userByLocation6).subscribe(System.out::println);
//            userByLocationService.save(userByLocation7).subscribe(System.out::println);
//            userByLocationService.save(userByLocation8).subscribe(System.out::println);
//            userByLocationService.save(userByLocation9).subscribe(System.out::println);
//            userByLocationService.save(userByLocation10).subscribe(System.out::println);
//            userByLocationService.save(userByLocation11).subscribe(System.out::println);
//            userByLocationService.save(userByLocation12).subscribe(System.out::println);
//            userByLocationService.save(userByLocation13).subscribe(System.out::println);
//            userByLocationService.save(userByLocation14).subscribe(System.out::println);
//            userByLocationService.save(userByLocation15).subscribe(System.out::println);
//            userByLocationService.save(userByLocation16).subscribe(System.out::println);
//            userByLocationService.save(userByLocation17).subscribe(System.out::println);
//            userByLocationService.save(userByLocation18).subscribe(System.out::println);
//            userByLocationService.save(userByLocation19).subscribe(System.out::println);
//            userByLocationService.save(userByLocation20).subscribe(System.out::println);
//
//            RepresentationService representationService = new RepresentationService("تعمیر گیربکس", "تعمیر و تعویض گیربکس", "15000000");
//            RepresentationService representationService1 = new RepresentationService("تعمیر سیلندر", "تعمیر و تعویض سیلندر", "25000000");
//            RepresentationService representationService2 = new RepresentationService("تعمیر دیسک و صفحه", "تعمیر و تعویض دیسک و صفحه", "1500000");
//            RepresentationService representationService3 = new RepresentationService("تعمیر برق ماشین", "تعمیر و تعویض سیم کشی برق ماشین", "45000000");
//
//            List<RepresentationService> representationServiceList = new ArrayList<>();
//            representationServiceList.add(representationService);
//            representationServiceList.add(representationService1);
//            representationServiceList.add(representationService2);
//            representationServiceList.add(representationService3);
//
//            PitShop pitShop = new PitShop("امیر سعیدی", "نمایندگی شماره 8 سایپا یدک",
//                    "11558", "35.7261,51.3304", null, "به صورت شبانه روزی باز می باشد", true, representationServiceList);
//
//            pitShopService.save(pitShop).subscribe(System.out::println);


        };
    }
}
