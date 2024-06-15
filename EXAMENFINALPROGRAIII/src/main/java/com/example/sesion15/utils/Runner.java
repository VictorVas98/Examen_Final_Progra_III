package com.example.sesion15.utils;

import com.example.sesion15.entities.Authority;
import com.example.sesion15.entities.AuthorityName;
import com.example.sesion15.entities.User;
import com.example.sesion15.repositories.AuthorityRepository;
import com.example.sesion15.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository,
                  AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        this.authorityRepository.deleteAll();

        this.authorityRepository.saveAll(List.of(
                new Authority(AuthorityName.READ),
                new Authority(AuthorityName.WRITE),
                new Authority(AuthorityName.ADMIN),
                new Authority(AuthorityName.ROLE_USER),
                new Authority(AuthorityName.ROLE_ADMIN)
        ));

        this.userRepository.saveAll(List.of(
                new User("user",
                         new BCryptPasswordEncoder().encode("pass123"),
                          List.of(
                                  this.authorityRepository.findByName(
                                          AuthorityName.ROLE_ADMIN
                                  )
                          )
                        )
                ));
    }
}
