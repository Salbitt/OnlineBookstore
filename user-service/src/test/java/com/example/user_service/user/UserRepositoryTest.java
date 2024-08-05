package com.example.user_service.user;


import com.example.user_service.entity.User;
import com.example.user_service.payload.UserRole;
import com.example.user_service.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // <.>
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository; // <.>

    @Test
    public void testStoreUser() { // <.>
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.CUSTOMER);
        User u = new User();
        u.setId(1L);
        u.setEmail("mary-sue@gmail.com");
        u.setPassword("abc123");
        u.setRoles(roles);

        User user = repository.save(u);

        assertThat(roles).isNotNull();
        assertThat(user).isNotNull(); // <.>

        assertThat(repository.count()).isEqualTo(1L); // <.>
    }
}