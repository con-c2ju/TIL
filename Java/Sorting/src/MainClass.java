
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numbers[] = { 5, 1, 10, 2, 9, 3, 8, 4, 6, 7};
		int temp;
		
		//�������� ����
		for (int i =0 ; i < numbers.length - 1 ; i++) {
			
			for (int j = i +1 ; j < numbers.length ; j++) {
				if (numbers[i] > numbers [j]) {	// ���⼭ �ε�ȣ ������ �ٲٸ� ��������
					//��ȯ
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
