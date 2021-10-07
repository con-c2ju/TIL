package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.StudentDto;

//DAO (Data Access Object) - CRUD (Create Read Update Delete)
public class StudentDao {
	
	Scanner scan = new Scanner(System.in);
	private List<StudentDto> list = new ArrayList<>();
	
	public StudentDao() {
		
		list.add(new StudentDto(1001, "홍길동", 90, 85, 100));
		list.add( new StudentDto(1002, "성춘향", 100, 90, 95));
		list.add(new StudentDto(1003, "일지매", 100, 80, 90));
	}
	
	// 정보 추가
	public void Create() {
		System.out.print("학생번호 = ");
		int number = scan.nextInt();
		
		System.out.print("학생이름 = ");
		String name = scan.next();
		
		System.out.print("국어 = ");
		int kor = scan.nextInt();
		
		System.out.print("영어 = ");
		int eng = scan.nextInt();
		
		System.out.print("수학 = ");
		int math = scan.nextInt();
		
		list.add(new StudentDto(number, name, kor, eng, math));
		
		System.out.println("추가 되었습니다.");
	}
	
	// 정보 삭제
	public void Delete() {	// 학생 정보 삭제 --→ 일단 검색해야함
		// 검색
		System.out.print("정보를 수정할 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		int findIndex = search(name);
		
		// 삭제
		if(findIndex == -1) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			StudentDto dto = list.get(findIndex);
			dto.setNumber(0);
			dto.setName("");
			dto.setKor(0);
			dto.setEng(0);
			dto.setMath(0);
			
			System.out.println("학생 명단에서 삭제했습니다.");
		}
		
		
	}
	
	// 정보 검색
	public void Read() {
		// 검색
		System.out.print("정보를 검색할 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		int findIndex = search(name);
		
		// 출력
		if(findIndex == -1) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			StudentDto dto = list.get(findIndex);
			System.out.println(dto.toString());
			System.out.println("해당하는 정보를 출력했습니다.");
		}
	}
	
	// 학생 정보 수정 --→ 일단 검색해야함
	public void Update() {	
		// 검색
		System.out.print("정보를 수정할 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		int findIndex = search(name);
		
		// 수정
		if(findIndex == -1) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			// 입력
			StudentDto dto = list.get(findIndex);
			
			while(true) {
				
				System.out.println("어떤 데이터를 수정하겠습니까? (국어/영어/수학) : ");
				String data = scan.next();
				
				switch(data) {
					case "국어":
						System.out.print("국어 = ");
						int kor = scan.nextInt();
						dto.setKor(kor);
						break;
					case "영어":
						System.out.print("영어 = ");
						int eng = scan.nextInt();
						dto.setEng(eng);
						break;
					case "수학":
						System.out.print("수학 = ");
						int math = scan.nextInt();
						dto.setMath(math);
						break;
				}
				
				System.out.print("수정을 계속하시겠습니까? (y/n) : ");
				String again = scan.next();
				
				if(again.equals("n")) {
					System.out.println("종료합니다.");
					break;
				}
				
			}
			
		}

	}
	
	// 출력
	public void allPrint() {
		
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);	// 객체임. 객체 값을 받아온거
			if(dto.getName().equals("") == false) {
				System.out.println(dto.toString());
			}
			else if(i == list.size() -1) {
				System.out.println("현재 입력된 정보를 모두 출력했습니다.");
				break;
			}
		}
	}
	
	// 파일 저장
	public void fileSave() throws IOException {
		// 파일 생성
		String filename = "StudentData.txt";
		File file = new File("c:\\Temp\\"+ filename);
		
		if(file.createNewFile()) {
			System.out.println(filename + "파일이 생성되었습니다.");
		}
		else {
			System.out.println("같은 이름의 파일이 존재합니다.");
		}
		
		//파일 저장
		PrintWriter pwriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		for(int i = 0 ; i < list.size() ; i++) {
			pwriter.println(list.get(i));
		}
		pwriter.close();
	}
	
	// 검색
	public int search(String name) {
		int findIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);	
			if(name.equals(dto.getName())) {
				findIndex = i;
				break;
			}		
		}
		
		return findIndex;
	}

}
