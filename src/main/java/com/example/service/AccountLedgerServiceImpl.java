package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.AccountLedger;
import com.example.repository.AccountLedgerRepository;
import com.example.web.datatransferobject.AccountLedgerRegistrationDTO;

@Service
public class AccountLedgerServiceImpl implements AccountLedgerService {

	private AccountLedgerRepository accountLedgerRepository;

	public AccountLedgerServiceImpl(AccountLedgerRepository accountLedgerRepository) {
		super();
		this.accountLedgerRepository = accountLedgerRepository;
	}

	@Override
	public AccountLedger save(AccountLedgerRegistrationDTO accountLedgerRegistrationDTO) {
		AccountLedger accLedger = new AccountLedger(accountLedgerRegistrationDTO.getAccountLedgerId(),
				accountLedgerRegistrationDTO.getVoucherName(), accountLedgerRegistrationDTO.getNarration(),
				accountLedgerRegistrationDTO.getRefNum(), accountLedgerRegistrationDTO.getRefDate(),
				accountLedgerRegistrationDTO.getDebit(), accountLedgerRegistrationDTO.getCredit(),
				accountLedgerRegistrationDTO.getBalance());
		return accountLedgerRepository.save(accLedger);
	}

	@Override
	public boolean loadByAccountLedgerId(String accountLedgerId) {
		AccountLedger accLedger = accountLedgerRepository.findByAccountLedgerId(accountLedgerId);
		if (accLedger != null) {
			return true;
		}
		return false;
	}

	@Override
	public String deleteById(String accountLedgerId) {
		AccountLedger accLedger = accountLedgerRepository.findByAccountLedgerId(accountLedgerId);
		accountLedgerRepository.delete(accLedger);
		return "success";
	}

	@Override
	public AccountLedger viewByAccountLedgerId(String accountLedgerId) {
		AccountLedger accLedger = accountLedgerRepository.findByAccountLedgerId(accountLedgerId);
		return accLedger;
	}

	@Override
	public AccountLedger updateAccountLedger(AccountLedger accountLedger) {

		AccountLedger accLedger = accountLedgerRepository.findByAccountLedgerId(accountLedger.getAccountLedgerId());
		if (accLedger != null) {
			accLedger.setVoucherName(accountLedger.getVoucherName());
			accLedger.setNarration(accountLedger.getNarration());
			accLedger.setRefNum(accountLedger.getRefNum());
			accLedger.setRefDate(accountLedger.getRefDate());
			accLedger.setDebit(accountLedger.getDebit());
			accLedger.setCredit(accountLedger.getCredit());
			accLedger.setBalance(accountLedger.getBalance());
			accountLedgerRepository.save(accLedger);
		}
		return accLedger;
	}

	@Override
	public List<AccountLedger> viewAllAccountLedger() {
		return accountLedgerRepository.findAll();
	}

	@Override
	public List<AccountLedger> filterByVoucherName(String voucherName) {
		return accountLedgerRepository.findByVoucherName(voucherName);
	}

	@Override
	public List<AccountLedger> filterByDate(LocalDate fromDate, LocalDate toDate) {
		return accountLedgerRepository.findByRefDateBetween(fromDate, toDate);

	}

}
