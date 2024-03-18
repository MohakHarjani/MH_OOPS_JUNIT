package streams;
import java.util.*;
import java.util.stream.*;

public class StreamAccEx {
	public static void main(String[] args)
	{
		List<Account>accounts = new ArrayList();
		
		Account acc1 = new Account(1234, "Mohak Harjani", 1500, "Savings");
		Account acc2 = new Account(1235, "Kartik", 700, "Savings");
		Account acc3 = new Account(1236, "Kshitij", 500, "Savings");
		Account acc4 = new Account(1237, "Virat", 2000, "Savings");
		Account acc5 = new Account(1238, "Rohit", 1300, "Savings");
		Account acc6 = new Account(1239, "Hardik", 800, "Savings");
		
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		accounts.add(acc4);
		accounts.add(acc5);
		accounts.add(acc6);
		
		Stream<Account>accStr = accounts.stream();
		List<String>accHolders= accStr.filter((Account acc)->acc.getAccBalance() > 1000)
		      .map((Account acc)->acc.getAccHolderName())
		      .collect(Collectors.toList());
		
		System.out.println(accHolders);
		
		
		List<String>list = accounts.stream().sorted((Account a1, Account a2)->(int)(-a1.getAccBalance() + a2.getAccBalance()))
		                 .map((Account acc)->acc.getAccHolderName() + "=>" + acc.getAccBalance())
		                 .collect(Collectors.toList());
		System.out.println(list);
	}

}
