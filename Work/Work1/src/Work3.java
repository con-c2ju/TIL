import java.util.Arrays;

public class Work3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 int num1[] = {1, 2, 3, 4, 5};
		 �迭�� ���� *2���� ����� ���� ����ǵ��� �޼ҵ� �Է�
		 
		 int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		 �־��� �迭�� ��� ���� ��ġ�� �ٲٴ� �۾��� �ݺ��Ͽ� �ڼ��̰� �Ѵ�. Maht.random()
		 int[] result = shuffle(original);
		 
		 �޼ҵ��: isNumber
		 ���: �־��� ���ڿ��� ��� ���ڷθ� �̷�����ִ��� Ȯ���Ѵ�.
		 ��� ���ڷθ� �̷���� ������ true, �ƴϸ� false
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
		String ex2 = "1234�츮����";
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
	 		
	 		int asc = (int)c;	<====���ڸ� �ƽ�Ű�ڵ�� �ٲ���
	 		if(asc < 48 || asc > 57) {
	 			b = false;
	 		}
	 			
	 	}
	 	
	 	return b;
	 }
	 
	 */
}
