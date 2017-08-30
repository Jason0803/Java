package jason_HanoiTower;

public class HanoiTowerTest {
	static int totalMoves = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoiTower(3,'A','B','C');
		System.out.println("Total Moves : " + totalMoves);
	}
	public static void hanoiTower(int n, char from, char tmp, char to) {
		if(n == 1) {
			System.out.println("[1] : From [" + from + "] To [" + to + "]");
			totalMoves++;
		} else {
			hanoiTower(n-1, from, to, tmp);
			System.out.println("[" + n + "] : From [" + from + "] To : [" + to + "]");
			hanoiTower(n-1, tmp, from, to);
			totalMoves++;
		}
	}
}
