package cls;

import java.util.Arrays;

public class SortingClass {
	
	public int count;
	public int numArray[];
	public String updown;
	
	public String getOrder(int num1, int num2[], String str) {
		
		int temp = 0;
		
		for(int i = 0 ; i < num2.length -1 ; i++) {
			for(int j = i +1 ; j < num2.length ; j++) {
				if(str.equals("오름") && num2[i] > num2[j]) {
					temp = num2[i];
					num2[i] = num2[j];
					num2[j] = temp;
				}
				else if(str.equals("내림") && num2[i] < num2[j]) {
					temp = num2[i];
					num2[i] = num2[j];
					num2[j] = temp;
				}
			}
		}
		
		numArray = num2;
		
		return Arrays.toString(numArray);
	}
	
}
