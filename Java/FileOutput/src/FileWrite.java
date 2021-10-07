import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

	public static void main(String[] args) throws IOException {
		
		
		File file = new File("c:\\Temp\\newfile.txt");
		
		/*
		try {
			FileWriter fwriter = new FileWriter(file);	// FileWriter는 자동적으로 파일을 생성해줌
			
			fwriter.write("안녕하세요" + "\n");
			fwriter.write("Hello");	// 주의: 파일 내용을 덮어쓸 위험이 있다.
			
			fwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 추가쓰기
		FileWriter fwriter = new FileWriter(file, true);
		fwriter.write("반갑습니다.");
		fwriter.close();
		*/
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);	// Buffer : 저장공간. 저장해둔다
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("안녕하세요");
		pw.print("Hello");
		pw.println("World");
		
		pw.close();	// 원래는 bw와 fw도 close 해줘야함
	}

}
