
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total=0, x=0,y;
		while(x++<5){
		y=x*x;
		System.out.println(y);
		total +=y;
		}
		System.out.println("총합은 "+total);
		
		int out = 10;
		class Inner{
		public int count(){
		int cnt = 0;
		for ( int i = 0 ; i < out ; i++){
		cnt += i;
		}
		return cnt;
		}
		}
		Inner in = new Inner();
		System.out.println( in.count() );

	}

}
