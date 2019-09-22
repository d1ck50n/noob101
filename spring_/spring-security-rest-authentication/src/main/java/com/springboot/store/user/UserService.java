package com.springboot.store.user;

/**
 *
 * @author dicksonk
 */
public interface UserService {

    public UserVO getUserByToken(String authToken);
}
