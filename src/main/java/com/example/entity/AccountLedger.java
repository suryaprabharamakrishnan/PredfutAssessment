package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "account_Ledger", uniqueConstraints = @UniqueConstraint(columnNames = "accLedgerNumber"))
public class AccountLedger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "accLedgerNumber")
	private String accountLedgerId;

	@Column(name = "voucher_name")
	private String voucherName;

	@Column(name = "entry_date")
	private LocalDate date;

	@Column(name = "narration")
	private String narration;

	@Column(name = "ref_no")
	private String refNum;

	@Column(name = "ref_date")
	private LocalDate refDate;

	@Column(name = "debit")
	private double debit;

	@Column(name = "credit")
	private double credit;

	@Column(name = "balance")
	private double balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountLedgerId() {
		return accountLedgerId;
	}

	public void setAccountLedgerId(String accountLedgerId) {
		this.accountLedgerId = accountLedgerId;
	}

	public String getVoucherName() {
		return voucherName;
	}

	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
	}

	public void setCreateddate(LocalDate date) {
		this.date = LocalDate.now();
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public LocalDate getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDate refDate) {
		this.refDate = refDate;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountLedger() {

	}

	public AccountLedger(String accountLedgerId, String voucherName, String narration, String refNum, LocalDate refDate,
			double debit, double credit, double balance) {
		super();
		this.accountLedgerId = accountLedgerId;
		this.date = LocalDate.now();
		this.voucherName = voucherName;
		this.narration = narration;
		this.refNum = refNum;
		this.refDate = refDate;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}

}
