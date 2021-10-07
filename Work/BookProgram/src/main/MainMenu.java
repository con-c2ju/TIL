package main;

import java.io.IOException;
import java.util.Scanner;

import data.Magazine;

public class MainMenu {

	public static void main(String[] args) throws IOException {
		Magazine dao = new Magazine();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 도서내용 추가");
			System.out.println("2. 도서내용 검색");
			System.out.println("3. 도서내용 파일로 저장");
			System.out.println("4. 도서내용 파일 불러오기");
			System.out.println("5. 도서내용 전체 출력");
			
			System.out.println("어느 작업을 하시겠습니까?");
			System.out.print(">> ");
			
			int work = scan.nextInt();
			
			switch(work) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.select();
					break;
				case 3:
					dao.filesave();
					break;
				case 4:
					dao.fileload();
					break;
				case 5:
					dao.main(dao.getList());
					break;
			}
		}

	}

}
