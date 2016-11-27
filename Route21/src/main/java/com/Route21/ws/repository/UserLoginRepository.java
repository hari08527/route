package com.Route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Route21.ws.bean.UserLogin;


public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{

	@Query(value="SELECT ul FROM UserLogin ul WHERE ul.loginId=:loginId and ul.loginPassword=:loginPass")
	public UserLogin findUserLogin(@Param("loginId")String loginId,@Param("loginPass")String loginPass);

}
