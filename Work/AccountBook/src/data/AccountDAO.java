package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AccountDAO {
	
	Calendar today = Calendar.getInstance();
	Scanner scan = new Scanner(System.in);
	
	private List<AccountDTO> accList = new ArrayList<AccountDTO>();
	private List<AccountDTO> searchList = new ArrayList<AccountDTO>();
	
	// 더미데이터 심기
	public AccountDAO() {
		
		accList.add(new AccountDTO("2020/3/8", "5000", "수입", "용돈", "안마해주고 용돈받음"));
		
	}
	
	// 1. 기록 추가
	public void add() {
		// 날짜 기록
		System.out.println("날짜");
		System.out.print("(년/월/일 형태로 기록. 0만 입력한 경우 오늘 날짜가 기록됩니다.) :: ");
		String cal = scan.next();
		
		if(cal.equals("0")) {
			int year = today.get(Calendar.YEAR);
			int month = today.get(Calendar.MONTH) + 1;
			int day = today.get(Calendar.DATE);
			
			cal = "" + year + "/" + month + "/" + day;
			System.out.println("자동으로 오늘 날짜를 기록했습니다.");
		}
		
		// 내용 기록
		System.out.print("금액 :: ");
		String money = scan.next();
		
		System.out.print("수입/지출 :: ");
		String category = scan.next();
		
		System.out.print("제목 :: ");
		String title = scan.next();
		
		System.out.print("내용 :: ");
		String content = scan.next();
		
		accList.add(new AccountDTO(cal, money, category, title, content));
	}
	
	// 2. 기록 검색
	public void read() {
		
		// 검색
		System.out.print("무엇을 기준으로 검색하시겠습니까? (제목/날짜) :: ");
		String str = scan.next();
		
		searchList = searchAsk(str);
		
		// 검색결과 출력
		for(AccountDTO l : searchList) {
			System.out.println(l);
		}
		if(searchList == null) {
			System.out.println("검색결과가 없습니다.");
		}
		System.out.println("**검색이 완료되었습니다.**");
		
	}
	
	// 3. 기록 수정
	public void update() {
		// 검색
		System.out.print("무엇을 기준으로 검색하시겠습니까? (제목/날짜) :: ");
		String str = scan.next();
		
		searchList = searchAsk(str);
		
		// 검색결과 출력
		for(AccountDTO l : searchList) {
			System.out.println(l);
		}
		if(searchList == null) {
			System.out.println("검색결과가 없습니다.");
		}
		
		// 수정
		System.out.println();
		System.out.print("몇번째 항목을 수정하시겠습니까? 숫자를 입력해주세요. ::");
		int index = scan.nextInt();
		
		for(int i = 0 ; i < accList.size() ; i++) {
			if(searchList.get(index - 1) == accList.get(i)) {
				System.out.println("무엇을 수정하시겠습니까? :: ");
				String modify = scan.next();
				
				switch(modify) {
				case "날짜":
					System.out.print("수정할 내용을 입력해주세요. (년/월/일) :: ");
					String cal = scan.next();
					accList.get(i).setCal(cal);
					break;
					
				case "금액":
					System.out.print("수정할 금액을 입력해주세요. :: ");
					String money = scan.next();
					accList.get(i).setMoney(money);
					break;
					
				case "수입/지출":
					System.out.print("수정할 내용을 입력해주세요. :: ");
					String category = scan.next();
					accList.get(i).setCategory(category);
					break;
				
				case "제목":
					System.out.print("수정할 내용을 입력해주세요. :: ");
					String title = scan.next();
					accList.get(i).setTitle(title);
					break;
					
				case "내용":
					System.out.print("수정할 내용을 입력해주세요. :: ");
					String content = scan.next();
					accList.get(i).setContent(content);
					break;	
				}
				System.out.println("**수정되었습니다.**");
			}
		}
	}
	
	// 4. 기록 삭제
	public void delete() {
		// 검색
		System.out.print("무엇을 기준으로 검색하시겠습니까? (제목/날짜) :: ");
		String str = scan.next();
		
		searchList = searchAsk(str);
		
		// 검색결과 출력
		for(AccountDTO l : searchList) {
			System.out.println(l);
		}
		if(searchList == null) {
			System.out.println("검색결과가 없습니다.");
		}
		
		// 삭제
		System.out.println();
		System.out.print("몇번째 항목을 삭제하시겠습니까? 숫자를 입력해주세요. ::");
		int index = scan.nextInt();
		
		for(int i = 0 ; i < accList.size() ; i++) {
			if(searchList.get(index - 1) == accList.get(i)) {
				accList.remove(i);
				System.out.println("**삭제되었습니다.**");
			}
		}		
	}
	
	// 5. 기록 출력
	public void allPrint() {
		for (int i = 0; i < accList.size(); i++) {
			System.out.println(accList.get(i).toString());
		}
		System.out.println("**출력이 완료되었습니다.**");
	}
	
	
	// 검색 질문
	public List<AccountDTO> searchAsk(String str) {
		List<AccountDTO> list = new ArrayList<>();
		if (str.equals("제목")) {		// 제목으로 검색
			System.out.print("검색할 제목을 입력해주세요. :: ");
			String title = scan.next();
			list = searchTitle(title);
		}
		else if (str.equals("날짜")) {	// 날짜로 검색
			System.out.print("검색할 날짜을 입력해주세요. (년/월/일) :: ");
			String cal = scan.next();
			list = searchDate(cal);
		}
		
		return list;
	}
	
	// 제목으로 검색
	public List<AccountDTO> searchTitle(String title) {
		List<AccountDTO> list = new ArrayList<>();
		for(int i = 0 ; i < accList.size() ; i++) {
			AccountDTO dto = accList.get(i);
			if(dto.getTitle().contains(title)) {
				list.add(dto);
			}
		}
		return list;
	}
	
	// 날짜로 검색
	public List<AccountDTO> searchDate(String cal) {
		List<AccountDTO> list = new ArrayList<>();
		for(int i = 0 ; i < accList.size() ; i++) {
			AccountDTO dto = accList.get(i);
			if(dto.getCal().contains(cal)) {
				list.add(dto);
			}
		}
		return list;
	}
}
