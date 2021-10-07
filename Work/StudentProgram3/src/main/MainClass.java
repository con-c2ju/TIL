package main;

import java.util.Scanner;

import dao.StudentDao;
import dto.StudentDto;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StudentDao dao = new StudentDao();
		
		while(true) {
			System.out.println("1. 학생정보 추가");
			System.out.println("2. 학생정보 삭제");
			System.out.println("3. 학생정보 검색");
			System.out.println("4. 학생정보 수정");
			System.out.println("5. 학생정보 모두 출력");
			
			System.out.println("어느 작업을 하시겠습니까?");
			System.out.print(">> ");
			
			int work = scan.nextInt();
			
			switch(work) {
				case 1:
					dao.Create();
					break;
				case 2:
					dao.Delete();
					break;
				case 3:
					dao.Read();
					break;
				case 4:
					dao.Update();
					break;
				case 5:
					dao.allPrint();
					break;
			}
		}
	}

}
