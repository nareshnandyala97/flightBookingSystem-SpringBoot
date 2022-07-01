package com.user.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.userDetails;

@Repository
public interface userDetailsRepository extends JpaRepository<userDetails,Integer>{

}
