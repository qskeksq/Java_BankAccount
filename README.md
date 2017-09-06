# BankAccount

### 계좌 생성, 계좌 리스트, 예금, 출금, 종료 기능 계좌 프로그램  

- 여러 공통된 속성 값을 클래스로 저장
- 캡슐화로 데이터 보호하기, getter setter를 통해 간접적으로 값 변화하기의 이해
- POJO 데이터 클래스
- 새로운 데이터 생성, 임시 저장, 원하는 값 출력, 업데이트의 이해

> 기본 흐름

```java
// 계좌 생성
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
```
> 계좌 생성

```java
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
```
> 계좌 정보 출력

```java
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
```
> 예금

```java
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
```
> 출금

```java
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
	//따라서 기존 값에서 弧獵 메소드를 불러와서 예금액을 매개 변수로 넣어준다.
	account.subBalance(Integer.parseInt(withdraw));
	System.out.println("출금이 완료되었습니다");
	//출금 완료 후 잔액을 보여준다.
	System.out.println("잔액 : "+account.getBalance());
	System.out.println();
}
```
