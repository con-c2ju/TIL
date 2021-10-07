package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magazine {

	Scanner scan = new Scanner(System.in);
	List<Book> list = new ArrayList<>();
	
	// 생성자 설정
	public Magazine() {
		list.add(new Book(21424, "Java Pro", "김하나", "Jaen.kr", 15000, "기본문법"));
		list.add(new Book(35355, "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000, ""));
		list.add(new Book(35535, "Java World", "편집부", "androidjava.com", 7000, "2013.2"));
	}

	// 자료 입력
	public void insert() {
		System.out.print("isbn >> ");
		int isbn = scan.nextInt();
		
		System.out.print("제목 >> ");
		String dummy = scan.nextLine();
		String title = scan.nextLine();
		
		System.out.print("작가 >> ");
		String author = scan.next();
		
		System.out.print("출판사 >> ");
		String publisher = scan.next();
		
		System.out.print("가격(숫자만 입력) >> ");
		int price = scan.nextInt();
		
		System.out.print("설명 >>");
		String desc = scan.next();
		
		Book dto = new Book(isbn, title, author, publisher, price, desc);
		list.add(dto);
	}

	// 자료 검색
	public void select() {
		System.out.print("찾을 도서의 이름을 입력해주세요. >> ");
		String title = scan.nextLine();
		
		int findIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			Book dto = list.get(i);
			if(title.equals(dto.getTitle())) {
				findIndex = i;
				break;
			}
		}
		
		if (findIndex == -1) {
			System.out.println("일치하는 정보가 없습니다.");
		}
		else {
			System.out.println(list.get(findIndex).toString());
		}
	}
	
	// 파일 저장
	public void filesave() throws IOException {
		System.out.print("저장할 파일명을 입력해주세요. (확장자 포함) >> ");
		String filename = scan.next();
		
		File file = new File("D:\\" + filename);
		
		if(file.createNewFile()) {
			System.out.println("파일이 D드라이브에 생성되었습니다.");
			System.out.println("파일 저장을 시작합니다.");
			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (Book book : list) {
				pw.println(book.toString());
			}
			pw.close();
			
			System.out.println("파일이 저장되었습니다.");
		}
		else {
			System.out.println("파일을 생성하지 못했습니다.");
			System.out.println("같은 이름의 파일이 존재하는지 확인해주세요.");
		}
	}
	
	// 파일 불러오기
	public void fileload() throws IOException {
		System.out.print("D드라이브에서 불러올 파일명을 입력해주세요. (확장자포함) >> ");
		String filename = scan.next();
		
		File file = new File("D:\\" + filename);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = "";
		List<Book> fileList = new ArrayList<>();
		Book dto = null;
		
		while((str = br.readLine()) != null) {
			String split[] = str.split("\\|");
			if(split[5].trim() != null) {
				dto = new Book(Integer.parseInt(split[0].trim()), split[1].trim(), split[2].trim(), split[3].trim(), Integer.parseInt(split[4].trim()), split[5].trim());
			}
			else {
				dto = new Book(Integer.parseInt(split[0].trim()), split[1].trim(), split[2].trim(), split[3].trim(), Integer.parseInt(split[4].trim()), "");
			}
			fileList.add(dto);
		}
		
		System.out.print("불러온 파일을 출력하시겠습니까? (y/n) >>");
		String answer = scan.next();
		if(answer.equals("y")) {
			this.main(fileList);
		}
		
		System.out.print("불러온 파일을 현재 목록에 추가하시겠습니까? (y/n) >>");
		String add = scan.next();
		if(add.equals("y")) {
			for (Book book : fileList) {
				list.add(book);
			}
			System.out.println("추가되었습니다.");
		}
	}
	
	// 도서 내용 호출
	public void main(List<Book> bList) {
		System.out.println("********************* 도서목록 *********************");
		for (Book book : bList) {
			System.out.println(book.toString());
		}
	}
	
	// list getter
	public List<Book> getList() {
		return list;
	}
}
