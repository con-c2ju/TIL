import java.util.Arrays;
import java.util.Scanner;

public class SortingTest {

	public static void main(String[] args) {
		// sorting
			// 1. 사용자로부터 입력
				// 정렬할 숫자의 갯수			: 5
				// 정렬할 수만큼 배열을 할당	: 배열을 5개
				// 숫자들을 입력			: 5개의 숫자를 차례로 입력
				// 오름/내림				: 오름/내림
			// 2. 정렬 처리
				// 오름/내림
			// 3. 결과 출력
		
		Scanner scan = new Scanner(System.in);
		int num, temp;
		String sort;
		String again;
		
		while(true) {
			
			System.out.print("정렬하려는 숫자의 갯수를 입력해주세요. :: ");
			num = scan.nextInt();
			int numbers[] = new int[num];
			
			System.out.print("정렬할 숫자를 입력해 주세요. (띄어쓰기로 구분) :: ");
			for(int i = 0 ; i < numbers.length ; i++) {
				numbers[i] = scan.nextInt();
				}
			
			System.out.print("오름/내림 :: ");
			sort = scan.next();
			
			/*
			for(int i = 0 ; i < numbers.length -1 ; i++) {
				for(int j = i +1 ; j < numbers.length ; j++) {
					if(sort.equals("오름") && numbers[i] > numbers[j]) {
						temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
					else if(sort.equals("내림") && numbers[i] < numbers[j]) {
						temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
			*/
			
			numbers = sort(numbers, sort);
			
			System.out.println( Arrays.toString(numbers) );
		
			System.out.println();
			
			System.out.print("정렬을 계속 하시겠습니까? (y/n) :: ");
			again = scan.next();
			
			if (again.equals("n")) {
				System.out.println("안녕히 계세요.");
				break;
			}
			else {
				System.out.println("정렬을 계속 진행합니다...");
			}
		}

	}
	
	static int[] sort(int arr[], String str) {
		
		if (str.equals("오름")) {
			for(int i = 0 ; i < arr.length -1 ; i++) {
				for(int j = i +1 ; j < arr.length ; j++) {
					if(arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		
		else if (str.equals("내림")) {
			for(int i = 0 ; i < arr.length -1 ; i++) {
				for(int j = i +1 ; j < arr.length ; j++) {
					if(arr[i] < arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		
		return arr;
	}
	
}
