package array.primitive.test;

public class ScoreArrayTest_2 {

	public static void main(String[] args) {
		int sum = 0;
		int avg = 0;
		int[] score = {90, 50, 46, 88, 79};
		
		for(int i = 0; i < 5; i++){
			sum += score[i];
			avg++;
		}
		System.out.println("Sum of Score : " + sum );
		avg = (sum/avg);
		System.out.println("Average of Score : " + avg);

		int count = 0;
		for(int i = 0; i < score.length; i++){
			if(score[i] <= avg){
				System.out.println("-Lower than or equal to avg ! : " + score[i]);
				count++;
			}
		}
		System.out.println("-->Total count of lower than or equal to avg : " + count);
	}

}
