package com.sb.crud.config;

import com.sb.crud.entity.User;
import com.sb.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    private User user;

    @Override
    public void run(String... args) throws Exception {

        User user1 = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .password("123456")
                .build();

        User user2 = User.builder()
                .firstName("sam")
                .lastName("tin")
                .email("sam@gmail.com")
                .password("123456")
                .build();

        User user3 = User.builder()
                .firstName("austin")
                .lastName("sua")
                .email("austin@gmail.com")
                .password("123456")
                .build();

        User user4 = User.builder()
                .firstName("paul")
                .lastName("p")
                .email("paul@gmail.com")
                .password("123456")
                .build();

        User user5 = User.builder()
                .firstName("mathew")
                .lastName("m")
                .email("mathew@gmail.com")
                .password("123456")
                .build();


        if (userRepository.count() == 0) {
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);
            System.out.println("Initial data seeded!");
        }
    }
}
