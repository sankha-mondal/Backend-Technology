package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{

}
