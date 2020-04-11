package com.ada.secured;

import com.ada.secured.model.User;
import com.ada.secured.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableWebSecurity
@SpringBootApplication
public class SpringSecurityDemoApplication {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        List<User> users = Stream.of(
                new User(101, "ada", passwordEncoder.encode("1234"), "ROLE_USER", "ada@gmail.com"),
                new User(102, "sup", passwordEncoder.encode("5678"), "ROLE_CLIENT", "sup@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
