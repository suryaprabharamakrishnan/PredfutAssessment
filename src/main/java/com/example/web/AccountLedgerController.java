package com.example.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.AccountLedger;
import com.example.service.AccountLedgerService;
import com.example.web.datatransferobject.AccountLedgerRegistrationDTO;

@Controller
@RequestMapping("/ledger")
public class AccountLedgerController {
	private AccountLedgerService accountLedgerService;

	public AccountLedgerController(AccountLedgerService accountLedgerService) {
		super();
		this.accountLedgerService = accountLedgerService;

	}

	@PostMapping("/createAccountLedger")
	public ResponseEntity<AccountLedger> registerAccountLedger(
			@RequestBody AccountLedgerRegistrationDTO accountLedgerRegistrationDTO) {
		if (accountLedgerService.loadByAccountLedgerId(accountLedgerRegistrationDTO.getAccountLedgerId())) {
			return null;
		}
		AccountLedger acc = accountLedgerService.save(accountLedgerRegistrationDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(acc);
	}

	@PostMapping("/updateAccountLedger")
	public ResponseEntity<AccountLedger> updateAccountLedger(@RequestBody AccountLedger accountLedger) {
		AccountLedger accLedger = accountLedgerService.updateAccountLedger(accountLedger);
		return ResponseEntity.status(HttpStatus.OK).body(accLedger);
	}

	@GetMapping("/viewAccountLedgerById/{accountLedgerId}")
	public ResponseEntity<AccountLedger> viewAccountLedgerById(@PathVariable String accountLedgerId) {
		AccountLedger accountLedger = accountLedgerService.viewByAccountLedgerId(accountLedgerId);
		if (accountLedger != null) {
			return ResponseEntity.status(HttpStatus.OK).body(accountLedger);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/viewAllAccountLedger")
	public ResponseEntity<List<AccountLedger>> viewAllAccountLedger() {
		List<AccountLedger> accountLedger = accountLedgerService.viewAllAccountLedger();
		return ResponseEntity.ok(accountLedger);
	}

	@GetMapping("/filterByDate/{fromDate}/{toDate}")
	public ResponseEntity<List<AccountLedger>> getLedgerEntriesByFilterDate(@PathVariable LocalDate fromDate,
			@PathVariable LocalDate toDate) {
		return ResponseEntity.ok(accountLedgerService.filterByDate(fromDate, toDate));
	}

	@GetMapping("/filterByVoucherNumber/{voucherName}")
	public ResponseEntity<List<AccountLedger>> getLedgerEntriesByFilterVoucherName(@PathVariable String voucherName) {
		return ResponseEntity.ok(accountLedgerService.filterByVoucherName(voucherName));
	}

	@PostMapping("/deleteAccountLedger/{accountLedgerId}")
	public ResponseEntity<AccountLedger> deleteAccountLedger(@PathVariable String accountLedgerId) {
		AccountLedger accountLedger = accountLedgerService.viewByAccountLedgerId(accountLedgerId);
		if (accountLedger != null) {
			accountLedgerService.deleteById(accountLedgerId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
