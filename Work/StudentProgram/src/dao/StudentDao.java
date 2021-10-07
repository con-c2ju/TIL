package dao;

import java.util.Arrays;
import java.util.Scanner;

import dto.StudentDto;

//DAO (Data Access Object) - CRUD (Create Read Update Delete)
public class StudentDao {
	
	Scanner scan = new Scanner(System.in);
	private StudentDto stArray[] = new StudentDto[10];
	int count;
	
	public StudentDao() {
		count = 0;
		
		stArray[0] = new StudentDto(1001, "홍길동", 90, 85, 100);
		stArray[1] = new StudentDto(1002, "성춘향", 100, 90, 95);
		stArray[2] = new StudentDto(1003, "일지매", 100, 80, 90);
	}
	
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
		
		stArray[count] = new StudentDto(number, name, kor, eng, math);
		
		count++;
		
		System.out.println("추가 되었습니다.");
	}
	
	public void Delete() {	// 학생 정보 삭제 --→ 일단 검색해야함
		System.out.print("정보를 삭제할 학생 이름을 입력해주세요. : ");
		String name = scan.next();
		
		// 검색
		int findIndex = -1;
		for (int i = 0; i < stArray.length; i++) {
			StudentDto dto = stArray[i];	// stArray 그대로 안쓰고 dto 쓰는 이유는?
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}		
		}
		
		// 삭제
		if(findIndex == -1) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			StudentDto dto = stArray[findIndex];
			dto.setNumber(0);
			dto.setName("");
			dto.setKor(0);
			dto.setEng(0);
			dto.setMath(0);
			
			System.out.println("학생 명단에서 삭제했습니다.");
		}
		
		
	}
	
	public void Read() {	// 학생 정보 검색
		System.out.print("정보를 찾으려는 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		// 검색
		int findIndex = -1;
		for (int i = 0; i < stArray.length; i++) {
			StudentDto dto = stArray[i];	// stArray 그대로 안쓰고 dto 쓰는 이유는?
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}
		}
		
		// 출력
		if(findIndex == -1) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			StudentDto dto = stArray[findIndex];
			System.out.println(dto.toString());
			System.out.println("해당하는 정보를 출력했습니다.");
		}
	}
	
	public void Update() {	// 학생 정보 수정 --→ 일단 검색해야함
		System.out.print("정보를 수정할 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		// 검색
		int findIndex = -1;
		for (int i = 0; i < stArray.length; i++) {
			StudentDto dto = stArray[i];	// stArray 그대로 안쓰고 dto 쓰는 이유는?
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}
		}
		
		// 수정
		if(findIndex == -1) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			// 입력
			StudentDto dto = stArray[findIndex];
			
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
	
	public void allPrint() {
		for (int i = 0; i < stArray.length; i++) {
			StudentDto dto = stArray[i];	// 객체임. 객체 값을 받아온거
			if(dto != null && dto.getName().equals("") == false) {
				System.out.println(dto.toString());
			}
			else if(i == stArray.length -1) {
				System.out.println("현재 입력된 정보를 모두 출력했습니다.");
				break;
			}
		}
	}

}
