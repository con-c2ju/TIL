package main;

import java.util.Scanner;

import data.AccountDAO;

public class AccountMain {
	public static void main(String[] args) {
		/*
		 * 	가계부 만들기
		 * - 날짜 2021/09/07 (형식. 가능하면 calendar에서 시간까지 잡아보기)
		 * 		수정해주는 부분을 제외하고는 오늘날짜 넣어주기
		 * - 금액 설정하는 부분
		 * - 수입/지출 구분
		 * - 제목
		 * - 내용
		 * 
		 * 	추가
		 * 	삭제
		 * 	검색 (가능하면 제목으로 검색 / 날짜로 검색 구현. 둘 중 하나는 구현)
		 * 	수정
		 * 	모두출력
		 * 
		 * 	DTO, DAO, 메뉴 필수
		 * 	가능하면 파일 저장 및 불러오기 까지
		 * 
		 * 	가능한 한 List 사용 권장
		 */
		
		Scanner scan = new Scanner(System.in);
		AccountDAO dao = new AccountDAO();
		
		System.out.println("**[가계부]**");
		
		Menu:
		while(true) {
			
			// 메뉴 구현
			System.out.println("1. 기록 추가");
			System.out.println("2. 기록 검색");
			System.out.println("3. 기록 수정");
			System.out.println("4. 기록 삭제");
			System.out.println("5. 기록 출력");
			
			// 입력 받기
			System.out.print("수행할 작업의 번호를 입력해주세요. (0을 입력하면 종료합니다.) >> ");
			int work = scan.nextInt();
			
			switch(work) {
			
				case 0:
					System.out.println("가계부 프로그램을 종료합니다...");
					break Menu;
				case 1:
					dao.add();
					break;
				case 2:
					dao.read();
					break;
				case 3:
					dao.update();
					break;
				case 4:
					dao.delete();
					break;
				case 5:
					dao.allPrint();
					break;
					
			}
		
		}
		
	}

}
