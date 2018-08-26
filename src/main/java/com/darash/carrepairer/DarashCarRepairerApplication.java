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
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@EnableReactiveCassandraRepositories(basePackages = {"com.darash.carrepairer.repositories"})
@ComponentScan
@EnableAutoConfiguration
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
            UserType userType = new UserType("Driver", "تعمیرکار ماشین");
            UserType userType2 = new UserType("Customer", "مشتری");
            userTypeRepository.save(userType).subscribe(System.out::println);
            userTypeRepository.save(userType2).subscribe(System.out::println);

            User user = new User("0082188815",
                    "Hamid Reza Darash", "123456", "Hamid.Darash@yahoo.com", "Tehran",
                    "09124240754", "02155212551", null, null, true,
                    true, "192.168.50.65", userType.getId());
            userRepository.save(user).subscribe(System.out::println);
            User user2 = new User("0082299915",
                    "Hamid Khalili", "123456", "Hamid@yahoo.com", "Tehran",
                    "09124658877", "02144193655", null, null, true,
                    true, "192.120.99.65", userType2.getId());
            userRepository.save(user2).subscribe(System.out::println);

            String locationTemp = "42.054441,34.52111";
            UserByLocation location = new UserByLocation(user.getId(), locationTemp);
            locationRepository.save(location).subscribe(System.out::println);

            String locationTemp2 = "42.154441,34.58511";
            UserByLocation location2 = new UserByLocation(user2.getId(), locationTemp2);
            locationRepository.save(location2).subscribe(System.out::println);

            String locationTemp3 = "10.154441,-34.58511";
            UserByLocation location3 = new UserByLocation(user.getId(), locationTemp3);
            locationRepository.save(location3).subscribe(System.out::println);

            String locationTemp4 = "10.153241,-34.0811";
            UserByLocation location4 = new UserByLocation(user2.getId(), locationTemp4);
            locationRepository.save(location4).subscribe(System.out::println);


            String locationTemp5 = "32.054441,50.52111";
            UserByLocation location5 = new UserByLocation(user.getId(), locationTemp5);
            locationRepository.save(location5).subscribe(System.out::println);

            String locationTemp6 = "29.154441,39.58511";
            UserByLocation location6 = new UserByLocation(user2.getId(), locationTemp6);
            locationRepository.save(location6).subscribe(System.out::println);

            String locationTemp7 = "37.090238,-95.71211";
            UserByLocation location7 = new UserByLocation(user.getId(), locationTemp7);
            locationRepository.save(location7).subscribe(System.out::println);

            String locationTemp8 = "37.111238,-95.70241";
            UserByLocation location8 = new UserByLocation(user2.getId(), locationTemp8);
            locationRepository.save(location8).subscribe(System.out::println);

        };
    }
}
