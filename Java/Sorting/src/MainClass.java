
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numbers[] = { 5, 1, 10, 2, 9, 3, 8, 4, 6, 7};
		int temp;
		
		//오름차순 정렬
		for (int i =0 ; i < numbers.length - 1 ; i++) {
			
			for (int j = i +1 ; j < numbers.length ; j++) {
				if (numbers[i] > numbers [j]) {	// 여기서 부등호 방향을 바꾸면 내림차순
					//교환
					temp = numbers[i]; 
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
			
		}
		
		for(int i = 0 ; i < numbers.length ; i++) {
			System.out.print(numbers[i] + " ");
		}
		
	}

}
