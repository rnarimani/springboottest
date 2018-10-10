package com.rqbank.testspringboot.testspringboot.repository;

import com.rqbank.testspringboot.testspringboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther Behnam Safari
 * date 10/10/18.
 * description
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);

    @Query("select u from User u where u.username like CONCAT(?1, '%')")
    List<User> findLikeUsername(String username);
}
