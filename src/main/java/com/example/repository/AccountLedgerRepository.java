package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.AccountLedger;

@Repository
public interface AccountLedgerRepository extends JpaRepository<AccountLedger, Long> {
	AccountLedger findByAccountLedgerId(String accountLedgerId);

	List<AccountLedger> findByVoucherName(String voucherName);

	List<AccountLedger> findByRefDateBetween(LocalDate fromDate, LocalDate toDate);
}
