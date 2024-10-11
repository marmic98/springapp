package projects.project.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import projects.project.model.User;
import projects.project.repository.UserRepository;

import java.util.Arrays;

@Component
public class DBManager implements CommandLineRunner, ApplicationListener<ContextClosedEvent> {
    private final UserRepository userRepository;

    User user1 = new User("Michele", "Martino", "michelmartino98.mm@gmai.com", "TiAmoArianna1!");
    User user2 = new User("Arianna", "Melone", "arayanna96@gmai.com", "SonoPiccola1!");

    public DBManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(user1);
        userRepository.save(user2);
        System.out.println("DB popolato!");
        //userRepository.saveAll(Arrays.asList(user1, user2))
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        userRepository.delete(user1);
        userRepository.delete(user2);
        System.out.println("DB svuotato!");
    }
}
