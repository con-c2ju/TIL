package cls;

import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {
		
		String again;
		
		Scanner scan = new Scanner(System.in);
		SortingClassExplain sort = new SortingClassExplain();
		
		while (true) {
			
			sort.input();
			sort.sorting();
			sort.print();
			
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

}
