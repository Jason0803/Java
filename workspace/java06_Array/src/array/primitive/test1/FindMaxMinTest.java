package array.primitive.test1;

public class FindMaxMinTest {
	public static void main(String[] args){
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		// MAXIMUM
		for(int i = 0; i < score.length; i++)
			if (score[i] > max)
				max = score[i];
		
		// MINIMUM
		for(int i = 0; i < score.length; i++)
			if (score[i] > min)
				min = score[i];
		
		

		System.out.println("Largest value of score : " + max);
		System.out.println("Smallest value of score : " + min);
	}
}
