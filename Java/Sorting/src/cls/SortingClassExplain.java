package cls;

import java.util.Arrays;
import java.util.Scanner;

public class SortingClassExplain {
	
	private int numbers[];
	private String updown;
	
	// 1. 입력
	public void input() {
		Scanner scan = new Scanner(System.in);
		int count;	// 적어도 두개 이상의 처리에서 사용되는 변수가 아니라면 멤버변수로 선언하지 않는 게 좋음
		
		// 수의 갯수
		System.out.print("정렬하려는 숫자의 갯수를 입력해주세요. :: ");
		count = scan.nextInt();
		
		// 수의 갯수를 배열에 할당
		numbers = new int[count];
		
		// 수 입력
		System.out.print("정렬할 숫자를 입력해 주세요. (띄어쓰기로 구분) :: ");
		for(int i = 0 ; i < numbers.length ; i++) {
			numbers[i] = scan.nextInt();
			}
		
		// 오름/내림
		System.out.print("오름/내림 :: ");
		updown = scan.next();
		
	}
	
	// 2. 정렬
	public void sorting() {
		
		int temp = 0;
		
		for(int i = 0 ; i < numbers.length -1 ; i++) {
			for(int j = i +1 ; j < numbers.length ; j++) {
				if(updown.equals("오름") && numbers[i] > numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
				else if(updown.equals("내림") && numbers[i] < numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
	}
	
	// 3. 출력
	public void print() {
		System.out.println(Arrays.toString(numbers));
	}

}
