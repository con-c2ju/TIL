import java.util.Arrays;

public class Work3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 int num1[] = {1, 2, 3, 4, 5};
		 배열의 값에 *2배의 연산된 값이 산출되도록 메소드 입력
		 
		 int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		 주어진 배열에 담긴 값이 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다. Maht.random()
		 int[] result = shuffle(original);
		 
		 메소드명: isNumber
		 기능: 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
		 모두 숫자로만 이루어져 있으면 true, 아니면 false
		 */
	
		int num1[] = {1, 2, 3, 4, 5};
		num1 = numberDb(num1);
		for (int i : num1) {
			System.out.print(i + " ");
		}
		System.out.println(Arrays.toString(num1));
		
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] result = shuffle(original);
		System.out.println(Arrays.toString());
		
		String ex1 = "123456789";
		String ex2 = "1234우리나라";
		System.out.println(isNumber(ex1));
		System.out.println(isNumber(ex2));

	}
	
	static int[] numberDb (int arr1[]) {
		int duplicate[] = new int[arr1.length];
		for(int i = 0 ; i < arr1.length ; i++) {
			duplicate[i] = arr1[i] * 2; 
		}
		
		return duplicate;
	}
	
	static int[] shuffle(int arr2[]) {
		
		for (int i = 0 ; i < arr2.length ; i++) {
			int a = (int)(Math.random() * arr2.length);
			int temp = arr2[i];
			arr2[i] = arr2[a];
			arr2[a] = temp;
		}
		
		return arr2;
	}
	
	static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;}
	}
	
	/*
	 * 
	 static boolean isNumber(String str) {
	 	boolean b = true;
	 	
	 	for(int 1 = 0; i < str.length(); i++) {
	 		char c = str.charAt(i);
	 		System.out.println(c);
	 		
	 		int asc = (int)c;	<====문자를 아스키코드로 바꿔줌
	 		if(asc < 48 || asc > 57) {
	 			b = false;
	 		}
	 			
	 	}
	 	
	 	return b;
	 }
	 
	 */
}
