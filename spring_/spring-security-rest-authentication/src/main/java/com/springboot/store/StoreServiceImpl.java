package com.springboot.store;

import com.springboot.store.user.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author dicksonk
 */
@Service
public class StoreServiceImpl implements StoreService {

    private final Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);
    
    @Override
    public Object getStore() {
        //TODO: retrieve store object from anywhere
        log.debug("Current Role: {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities() );
        return "Fake Store Object, Where You Need To Override...";
    }

    @Override
    public boolean addStore(Object store) {
        //TODO: get the user object and persist your store object then return status
        UserVO user = (UserVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug("Current User: {}", user.getUsername() );
        log.debug("Current Role: {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities() );
        return true;
    }
}
