package com.college.e_commarce;


import com.college.e_commarce.entity.User;
import com.college.e_commarce.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RunTest {


    private final UserRepository userRepository;

    @Autowired
    RunTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void running() {
        User user = userRepository.findByEmail("ak@gmail.com").orElseThrow();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(user);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
