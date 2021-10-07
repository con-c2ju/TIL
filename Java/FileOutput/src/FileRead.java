import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("c:\\Temp\\newfile.txt");
		
		
		try {
			// 한 글자씩 읽기
			
			FileReader fr = new FileReader(file);
			int ch;	// 파일 내용을 읽어오는 자료형은 char이 아니라 int임
			while((ch = fr.read()) != -1) {	// .read()는 더이상 읽을 글자가 없으면 -1를 반환함
				System.out.println((char)ch);
			}
			fr.close();
			
			// 한 문장씩 읽기
			FileReader fr2 = new FileReader(file);
			BufferedReader br = new BufferedReader(fr2);
			
			String str = "";
			while ( (str = br.readLine()) != null) {	// 줄이 공란이 아닐때 까지 계속 돌려라
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
