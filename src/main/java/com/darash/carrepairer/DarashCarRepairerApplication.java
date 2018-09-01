package com.darash.carrepairer;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.entities.RepresentationService;
import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.services.PitShopServiceImpl;
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

    @Autowired
    public DarashCarRepairerApplication(UserServiceImpl userService, PitShopServiceImpl pitShopService) {
        this.userService = userService;
        this.pitShopService = pitShopService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DarashCarRepairerApplication.class, args);

//        SchemaSetup schemaSetup = new SchemaSetup("math.cql");
//        schemaSetup.runCQL();

    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            //35.7261,51.3304

            User user = new User("0082188815", "حمیدرضا دارش", "onyxtv2018",
                    "hamid.darash@yahoo.com", "کرج مهرشهر", "09124240754", "02144193657", null,
                    null, true, true, "192.168.50.190");
            userService.saveOrUpdate(user).subscribe(System.out::println);

            List<RepresentationService> representationServices = new ArrayList<>();
            RepresentationService representationService = new RepresentationService("تعمیر جعبه دنده" , "در صورت کارت طلایی رایگان می باشد" , "2500000");
            representationServices.add(representationService);
            PitShop pitShop = new PitShop("علیرضا قربانی","نمایندگی کد 112 سایپا یدک","00112","42.33,43.55",null,
                    "",true,representationServices);

            pitShopService.saveOrUpdate(pitShop).subscribe();



        };
    }
}
