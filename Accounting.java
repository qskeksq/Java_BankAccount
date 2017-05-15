package com.nadan.java.balance;

import java.util.ArrayList;
import java.util.Scanner;

public class Accounting {
	
	//Account객체를 배열로 삼는 리스트이다. 이 리스트에서 객체를 꺼내고 getter, setter로 원하는 데이터를 처리한다.
	ArrayList<Account> list = new ArrayList<>();
	//scanner를 통해 번호와 값을 입력받는다.
	Scanner scanner = new Scanner(System.in);
	
	public void accounting(){
		
		//while문을 돌리기 위한 true값이다. 나중에 종료될 경우 false값으로 지정해 주어 순환문을 빠져나온다.
		boolean run = true;
		//if값에 들어가 맞는 값이 있으면 처리를 하고 다시 위로 올라와 어떤 처리를 할 것인지 묻는 순환문이다
		while(run){
			System.out.println("------------------------------------------");
			System.out.println("| 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 |");
			System.out.println("------------------------------------------");
			
			//scanner를 통해 번호를 입력받고 if문으로 어떤 처리와 연결될 것인지 처리한다.
			System.out.print("선택>");
			String select = scanner.nextLine();
			
			//입력된 값은 String이기 때문에 숫자로 바꿔서 비교한다
			//각 처리가 복잡하기 때문에 따로 메소드로 빼서 처리한다.
			//계좌 생성
			if(Integer.parseInt(select)==1){
				createAccount();
			//계좌 리스트
			} else if(Integer.parseInt(select)==2){
				accountList();	
			//예금
			} else if(Integer.parseInt(select)==3){
				deposit();
			//출금
			} else if(Integer.parseInt(select)==4){
				withdraw();
			//종료
			} else if(Integer.parseInt(select)==5){
				System.out.println("프로그램 종료");
				run = false;	
			}
			
		}
		scanner.close();
	}
	
	//계좌 생성 메소드
	public void createAccount(){
		System.out.println("계좌생성");
		System.out.println("----------");
		//새로운 계좌가 생성되어야 하기 때문에 새로운 Account 객체를 생성한다.
		Account newAccount = new Account();
		//계좌번호에 필수적으로 필요한 정보를 넣어준다.
		System.out.print("계좌번호 입력 : "); //계좌번호 입력
		String accountNumber = scanner.nextLine();
		//setter를 통해 입력받는 값을 계좌번호에 넣어준다.
		newAccount.setAccountNumber(accountNumber);
		
		System.out.print("계좌주 입력 : "); //계좌주 입력
		String owner = scanner.nextLine();
		//setter를 통해 입력받는 값을 계좌주에 넣어준다.
		newAccount.setOwner(owner);
		
		System.out.print("입금액 입력 : "); //입금액 입력
		String deposit = scanner.nextLine();
		//setter를 통해 입력받는 값을 초기값에 넣어준다.
		newAccount.setBalance(Integer.parseInt(deposit));
		
		//Accout객체를 리스트에 넣어준다.
		list.add(newAccount);
		
		System.out.println("계좌가 생성되었습니다");
		System.out.println();
	}
	
	//리스트에 들어 있는 계좌를 요약해서 출력해준다.
	public void accountList(){
		
		System.out.println("계좌목록");
		System.out.println("----------");
		int length = list.size();
		//리스트에 들어 있는 배열의 개수만큼 처리한다.
		for(int i=0; i<length; i++){
			//get을 통해 객체를 얻어온 후  getter를 통해 값을 불러온다
			String an = list.get(i).getAccountNumber();
			String ow = list.get(i).getOwner();
			int bl = list.get(i).getBalance();
			//정리해서 세 값을 요약 출력한다
			System.out.println(an+"\t"+ow+"\t"+bl);
		}
		System.out.println();
	}

	//예금
	public void deposit(){
		Account account = new Account();
		System.out.println("예금");
		System.out.println("----------");
		//예금에서 중요한 것은 일단 내 계좌를 찾아와야 한다는 것이다. 
		//따라서 입력받은 계좌번호와 리스트에 들어 있는 계좌번호를 비교하면서 일치하는 객체를 가져온다.
		System.out.print("계좌번호 : ");
		String an = scanner.nextLine();
		for(Account a : list){
			if(a.getAccountNumber().equals(an)){
				account = a;
			}
		}
		System.out.print("예금액 : ");
		//한 번 생성한 scanner는 같은 타입으로 계속 써야 하는군. nextInt로 했다가 꾀나 힘들었다
		String deposit = scanner.nextLine();
		//여기서는 setter로 balance를 처리하면 안 된다. 초기값이 바뀌어 버리기 때문이다.
		//따라서 초기값에 더해주는 메소드를 불러와서 예금액을 매개 변수로 넣어준다.
		account.addBalance(Integer.parseInt(deposit));  
		System.out.println("입금이 완료되었습니다");
		//입금이 완료될 경우 현재 통장잔고를 보여준다
		System.out.println("잔액 : "+account.getBalance());
		System.out.println();
	}

	//출금
	public void withdraw(){
		Account account = new Account();
		System.out.println("출금");
		System.out.println("----------");
		//예금과 마찬가지로 출금에서 중요한 것은 내 계좌를 찾아야 하는 것이다
		//입력받은 계좌번호와 리스트에 들어 있는 계좌번호를 비교하면서 일치하는 객체를 가져온다.
		System.out.print("계좌번호 : ");
		String an = scanner.nextLine();
		for(Account a : list){
			if(a.getAccountNumber().equals(an)){
				account = a;
			}
		}
		System.out.print("출금액 : ");
		String withdraw = scanner.nextLine();
		//여기서도 setter로 balance를 처리하면 안 된다. 초기값이 바뀌어 버리기 때문이다.
		//따라서 기존 값에서 뺴주는 메소드를 불러와서 예금액을 매개 변수로 넣어준다.
		account.subBalance(Integer.parseInt(withdraw));
		System.out.println("출금이 완료되었습니다");
		//출금 완료 후 잔액을 보여준다.
		System.out.println("잔액 : "+account.getBalance());
		System.out.println();
	}


}
