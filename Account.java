package com.nadan.java.balance;

//하나의 계정에 해당하는 데이터를 모아 만든 클래스
public class Account {
	
	//계좌번호, 계좌주, 잔액은 모두 외부에서 직접 접근해서 바꾸면 안 되는 변수이다.
	//따라서 private로 바꾼 후 getter와 setter를 사용해 원하는 값으로 처리해준다.
	private String accountNumber;
	private String owner;
	private int balance;
	
	//getter와 setter
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//예금 메소드
	public void addBalance(int input) {
		this.balance = this.balance + input;
	}
	
	//출금 메소드
	public void subBalance(int input) {
		balance = balance - input;
	}
	
	

}
