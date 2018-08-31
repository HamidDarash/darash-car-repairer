package com.darash.carrepairer;

import com.darash.carrepairer.repositories.UserByLocationRepository;
import com.darash.carrepairer.repositories.UserRepository;
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
    private final UserByLocationRepository userByLocationRepository;

    @Autowired
    public DarashCarRepairerApplication(UserRepository userRepository, UserByLocationRepository userByLocationRepository) {
        this.userRepository = userRepository;
        this.userByLocationRepository = userByLocationRepository;
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
