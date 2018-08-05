package com.darash.carrepairer;

import com.darash.carrepairer.configuration.SchemaSetup;
import com.darash.carrepairer.entities.LatLng;
import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserByLocation;
import com.darash.carrepairer.entities.UserType;
import com.darash.carrepairer.repositories.LocationRepository;
import com.darash.carrepairer.repositories.UserRepository;
import com.darash.carrepairer.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DarashCarRepairerApplication {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public DarashCarRepairerApplication(UserRepository userRepository, UserTypeRepository userTypeRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.locationRepository = locationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DarashCarRepairerApplication.class, args);

//        SchemaSetup schemaSetup = new SchemaSetup("math.cql");
//        schemaSetup.runCQL();

    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
//            UserType userType = new UserType("Driver", "تعمیرکار ماشین");
//            UserType userType2 = new UserType("Customer", "مشتری");
//            userTypeRepository.save(userType).subscribe(System.out::println);
//            userTypeRepository.save(userType2).subscribe(System.out::println);
//
//            User user = new User("0082188815",
//                    "Hamid Reza Darash", "123456", "Hamid.Darash@yahoo.com", "Tehran",
//                    "09124240754", "02155212551", null, null, true,
//                    true, "192.168.50.65", userType.getId());
//            userRepository.save(user).subscribe(System.out::println);
//            User user2 = new User("0082299915",
//                    "Hamid Khalili", "123456", "Hamid@yahoo.com", "Tehran",
//                    "09124658877", "02144193655", null, null, true,
//                    true, "192.120.99.65", userType2.getId());
//            userRepository.save(user2).subscribe(System.out::println);
//
//            LatLng latLng = new LatLng(42.054441, 34.52111);
//            UserByLocation location = new UserByLocation(user.getId(), latLng, latLng.getLat(), latLng.getLng());
//            locationRepository.save(location).subscribe(System.out::println);
//
//            LatLng latLng2 = new LatLng(42.154441, 34.58511);
//            UserByLocation location2 = new UserByLocation(user2.getId(), latLng2, latLng2.getLat(), latLng2.getLng());
//            locationRepository.save(location2).subscribe(System.out::println);
        };
    }
}
