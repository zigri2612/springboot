package com.rk.testinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.rk.testinggo.entity.UserEntity;


@Component
public interface UserRepository extends JpaRepository<UserEntity,String>{

	
}
