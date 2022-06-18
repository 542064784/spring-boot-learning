package com.springboot.servletjsp.service;

import com.springboot.servletjsp.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen qi hui
 * @date 2022/06/18
 */
@Service
@Slf4j
public class UserService {

    private static final List<User> USER_LIST = new ArrayList<>();

    public void addUser(final User user) {
        if (null != user) {
            USER_LIST.add(user);
        }
    }

    public List<User> getUser() {
        return USER_LIST;
    }


}
