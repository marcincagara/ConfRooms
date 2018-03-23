package hello;

import hello.model.ConfRoomModel;
import hello.model.User;
import hello.model.UserRole;
import hello.repository.ConfRoomRepository;
import hello.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, ConfRoomRepository confRoomRepository){
        return (String ... args)->{
            User  user = new User();
            user.setUserName("admin");
            user.setPassword("admin");

            UserRole adminRole = new UserRole();
            adminRole.setRole("ROLE_ADMIN");

            UserRole userRole = new UserRole();
            userRole.setRole("ROLE_USER");

            user.setUserRoles(Arrays.asList(adminRole,userRole));


            userRepository.save(user);



            //CONF room

            ConfRoomModel confRoomModel = ConfRoomModel.builder().floor(1).name("Kraków").hdmi(true).skypeVc(true).lan(true).labels(true).remotes(true).instruction(true).comments("comment").build();

            confRoomRepository.save(confRoomModel);
        };
    }

}
