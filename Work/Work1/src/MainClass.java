import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int price = 0;
		int money = 0;
		int change = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*CU ������*");
		System.out.print("������ �ݾ� :: ");
		price = scanner.nextInt();
		System.out.print("������ �ݾ� :: ");
		money = scanner.nextInt();
		
		change = money - price;
		System.out.println("�Ž����� => " + change + "\n");
		
		
		System.out.println("[�Ž����� ��ȯ ���]");
		
		int change5000, change1000, change500, change100, change50, change10;
		
		change5000 = change / 5000;
		System.out.println("5000�� -> " + change5000 + "��");
		
		change1000 = (change % 5000) / 1000;
		System.out.println("1000�� -> " + change1000 + "��");
		
		change500 = (change % 1000) / 500;
		System.out.println("500�� -> " + change500 + "��");
		
		change100 = (change % 500) / 100;
		System.out.println("100�� -> " + change100 + "��");
		
		change50 = (change % 100) / 50;
		System.out.println("50�� -> " + change50 + "��");
		
		change10 = (change % 50) / 10;
		System.out.println("10�� -> " + change10 + "��");
		
		
		scanner.close();
		
		

	}

}
