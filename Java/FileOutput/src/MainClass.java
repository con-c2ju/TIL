import java.io.File;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("c:\\");	// c드라이브의 모든 정보를 산출
		
		// 파일조사
		String filelist[] = file.list();
		
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		
		// 파일과 폴더(dir)
		File filelist2[] = file.listFiles();
		for (int i = 0; i < filelist2.length; i++) {
			if(filelist2[i].isFile()) {
				System.out.println("[파일]" + filelist2[i].getName());
			}
			else if(filelist2[i].isDirectory()) {
				System.out.println("[폴더]" + filelist2[i].getName());
			}
			else {
				System.out.println("[?]" + filelist2[i].getName());
			}
		}
		
		//파일 생성
		File newfile = new File("c:\\Temp\\newfile.txt");
		
		try {
			if(newfile.createNewFile()) {	// createNewFile은 boolean 유형. 만드는 데 성공했으면 true를, 실패했으면 false를 출력
				System.out.println("파일 생성 성공!");
			}
			else {
				System.out.println("파일 생성 실패...");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// 폴더 생성
		File newdir = new File("c:\\Temp\\subdir\\one");
		if(newdir.mkdirs()) {	// mkdir은 폴더 하나만을, mkdirs는 폴더 여러개를 생성
			System.out.println("폴더생성 성공!");
		}
		else {
			System.out.println("폴더생성 실패...");
		}
		
		// 파일의 존재여부
		if(newfile.exists()) {
			System.out.println("newfile.txt가 존재합니다.");
		}
		else {
			System.out.println("newfile.txt가 존재하지 않습니다.");
		}
		
		// 파일의 읽기가능 여부
		if(newfile.canRead()) {
			System.out.println("이 파일은 읽기가 가능합니다.");
		}
		
		// 읽기 전용으로 만들기
		newfile.setReadOnly();
		
		// 파일의 쓰기가능 여부
		if(newfile.canWrite()) {
			System.out.println("이 파일은 쓰기가 가능합니다.");
		}
		else {
			System.out.println("이 파일은 쓰기가 불가능합니다.");
		}
		
		// 파일 삭제
		newfile.delete();
	}

}
