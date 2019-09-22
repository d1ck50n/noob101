package com.springboot.store.user;

import org.springframework.stereotype.Service;

/**
 *
 * @author dicksonk
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVO getUserByToken(String authToken) {
        // TODO: Get your user detail from any persistence store base on auth token
        // Sample fake user created below just to imitated
        UserVO fakeUser = new UserVO();
        fakeUser.setId("1");
        fakeUser.setUsername("superman");
        fakeUser.setPassword("password");
        fakeUser.setRoles(new String[]{"ROLE_ADMIN"});
        return fakeUser;
    }
}
