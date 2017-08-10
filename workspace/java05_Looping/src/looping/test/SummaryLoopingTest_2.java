package looping.test;

public class SummaryLoopingTest_2 {
	
	static void display(String text){
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		// local variable --> not stacked on heap !! : not autumatically initialised.
		
		display("\t===== For Statement =====");
		int sum_1= 0;
		for(int i = 1; i <= 10; i++)
			sum_1+=i;
		display("\t-Sum of 1~10 : " + sum_1);
		
		display("\t===== While Statement =====");
		int i = 1;
		int sum_2 = 0;
		while(i <= 10){
			sum_2 += i;
			i++;
		}
		display("\t-Sum of 1~10 : " + sum_2);
		
		display("\t===== Display within same spaces =====");
		for(int a = 0; a < 3; a++){
			for(int b = 1; b < 6; b++)
				System.out.print("\t" + b);
			System.out.println();
		}
		
	}
}
