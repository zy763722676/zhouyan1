package com.zy.testmyjpa.dao;

import com.zy.testmyjpa.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    List<User> findByUsername(@Param("username") String username);
    List<User> findByUsernameLike(@Param("keyword") String keyword);
//    List<User> findByUsernameLikePage(@Param("keyword") String keyword, Pageable pageable);

}
