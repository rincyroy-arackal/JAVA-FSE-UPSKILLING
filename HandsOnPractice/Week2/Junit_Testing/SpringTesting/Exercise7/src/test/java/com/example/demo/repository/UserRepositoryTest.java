package com.example.demo.repository;

import com.example.demo.model.User; // ✅ Import it, don’t define it here
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        userRepository.save(new User(null, "Alice"));
        userRepository.save(new User(null, "Bob"));
        userRepository.save(new User(null, "Alice"));

        List<User> result = userRepository.findByName("Alice");

        assertThat(result).hasSize(2);
        assertThat(result).extracting(User::getName).containsOnly("Alice");
    }
}
