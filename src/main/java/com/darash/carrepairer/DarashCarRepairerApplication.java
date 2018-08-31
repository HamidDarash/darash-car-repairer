package com.darash.carrepairer;

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

        };
    }
}
