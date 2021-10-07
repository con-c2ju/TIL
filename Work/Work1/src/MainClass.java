import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int price = 0;
		int money = 0;
		int change = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*CU 편의점*");
		System.out.print("지불할 금액 :: ");
		price = scanner.nextInt();
		System.out.print("소지한 금액 :: ");
		money = scanner.nextInt();
		
		change = money - price;
		System.out.println("거스름돈 => " + change + "\n");
		
		
		System.out.println("[거스름돈 교환 목록]");
		
		int change5000, change1000, change500, change100, change50, change10;
		
		change5000 = change / 5000;
		System.out.println("5000원 -> " + change5000 + "장");
		
		change1000 = (change % 5000) / 1000;
		System.out.println("1000원 -> " + change1000 + "장");
		
		change500 = (change % 1000) / 500;
		System.out.println("500원 -> " + change500 + "개");
		
		change100 = (change % 500) / 100;
		System.out.println("100원 -> " + change100 + "개");
		
		change50 = (change % 100) / 50;
		System.out.println("50원 -> " + change50 + "개");
		
		change10 = (change % 50) / 10;
		System.out.println("10원 -> " + change10 + "개");
		
		
		scanner.close();
		
		

	}

}
