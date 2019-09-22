package com.dicksonkho.jpa.repository;

import com.dicksonkho.jpa.entity.DataFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataFeedRepository extends JpaRepository<DataFeed, Integer> {

    @Query("select df from DataFeed df where df.clientId = ?1")
    public DataFeed findByClientID(Integer clientId);

    @Query("select df from DataFeed df where df.clientId like %?1")
    public DataFeed findByClientNameEndWith(String name);

}
