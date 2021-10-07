package main;

import java.util.Scanner;

import dao.StudentDao;
import dto.StudentDto;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		
		StudentDto dto[] = new StudentDto[10];	// 객체를 생성한 게 아님! 배열만 생성(변수만 선언)한 상태. 객체는 동적할당을 해야 사용할 수 있다.
		
		dto[0] = new StudentDto(1, "홍길동", 90, 80, 100);
		
		StudentDto arrDto[] = new StudentDto[10];
		for (int i = 0; i < arrDto.length; i++) {
			arrDto[i] = new StudentDto();		// 배열 안에 객체를 생성
		}

		
		StudentDto dto1, dto2, dto3, dto4;
		
		dto1 = null;
		dto1.setNumber(1001);	NullPointerException 발생. 아직 객체가 동적할당 된 게 아닌 변수 설정만 되어있기 때문
		
		dto1 = new StudentDto();	이렇게 해줘야 객체로 쓸 수 있다.
		dto2 = new StudentDto();	객체는 무조건 동적할당 해야 쓸 수 있다.
		dto3 = new StudentDto();
		dto4 = new StudentDto();
		
		Student dto;	이대로 쓰는거 불가능
		
		*/
		
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
