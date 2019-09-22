package com.springboot.store;

import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author dicksonk
 */
public interface StoreService {

    @Secured("ROLE_ANONYMOUS")
    public Object getStore();
    
    @Secured("ROLE_ADMIN")
    public boolean addStore(Object store);
}
