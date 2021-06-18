package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Account;
public interface AccountService extends JpaRepository<Account, Long>{
	
}
