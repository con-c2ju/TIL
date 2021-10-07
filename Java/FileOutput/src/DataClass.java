import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class DataClass {

	public static void main(String[] args) throws Exception {
		// 이렇게 여러명의 데이터를 보관하고 있을때는 한 명의 데이터를 한 줄에 보관하는 게 편리.
		String human[][] = {
				{ "성춘향", "16", "남원시", "156.0" },		// 성춘향16남원시156.0
				{ "홍길동", "24", "서울시", "172.0" },
				{ "임정", "27", "부산특별시", "180.1" },		// 임정27부산특별시180.1  <===== 이름 등의 길이가 달라서 일정하게 잘랐다간 잘못된 자료가 저장될 수 있음 : 토큰으로 구분하자! 
		};
		
		String datas[] = new String[human.length];	// nul == 빈칸 != null
		
		for (int i = 0; i < datas.length; i++) {	// datas.length == human.length
			datas[i] = human[i][0] + "-" + human[i][1] + "-" + human[i][2] + "-" + human[i][3];
		}	// 각 문자열 사이에 토큰을 넣어줌
		
		// 파일 생성
		String filename = "humans.txt";
		File file = new File("c:\\Temp\\" + filename);
		
		if(file.createNewFile()) {
			System.out.println(filename + "파일이 생성되었습니다.");
		}
		else {
			System.out.println(filename + "과 같은 이름의 파일이 있습니다.");
		}
		
		// 파일 저장
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		for (int i = 0; i < datas.length; i++) {
			pw.println(datas[i]);
		}
		pw.close();
		
		// =====================================================================================
		
		// 파일 불러오기
		BufferedReader br = new BufferedReader(new FileReader(file));	// 불러오기 위해 필요
		
		String arrStr[] = new String[datas.length];
		
		String str = "";
		int count = 0;
		while( (str = br.readLine()) != null) {
			arrStr[count] = str;
			count++;
		}
		
		for (String s : arrStr) {
			System.out.println(s);
		}
		
		String member[][] = new String[arrStr.length][4]; // 뒤의 4는 생략가능
		
		/*
		String firstMem = arrStr[0];
		String split[] = firstMem.split("-");
		
		member[0][0] = split[0];
		member[0][1] = split[1];
		member[0][2] = split[2];
		member[0][3] = split[3];
		*/
		
		for (int i = 0; i < arrStr.length; i++) {
			String split[] = arrStr[i].split("-");
			member[i][0] = split[0];
			member[i][1] = split[1];
			member[i][2] = split[2];
			member[i][3] = split[3];
		}
		
		for (int i = 0; i < member.length; i++) {
			for (int j = 0 ; j < member[i].length ; j++) {
				System.out.print(member[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
