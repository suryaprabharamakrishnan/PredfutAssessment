package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.entity.AccountLedger;
import com.example.web.datatransferobject.AccountLedgerRegistrationDTO;

public interface AccountLedgerService {
	public AccountLedger save(AccountLedgerRegistrationDTO accountLedgerRegistrationDTO);

	public boolean loadByAccountLedgerId(String accountLedgerId);

	public String deleteById(String accountLedgerId);

	public AccountLedger viewByAccountLedgerId(String accountLedgerId);

	public AccountLedger updateAccountLedger(AccountLedger accountLedger);

	public List<AccountLedger> viewAllAccountLedger();

	public List<AccountLedger> filterByDate(LocalDate fromDate, LocalDate toDate);

	public List<AccountLedger> filterByVoucherName(String voucherName);

}
