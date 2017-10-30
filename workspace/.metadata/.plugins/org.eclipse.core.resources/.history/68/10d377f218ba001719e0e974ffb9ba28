package util;
/*
 * 대수 비교용 custom 클래스
 * IntegerRange.betweenExclusive(input, min, max) --> true | false
 * IntegerRange.betweenInclusive(input, min, max) --> true | false
 * --> CocoaDate.compareDate() 에서 응용 ! (#00157)
 * 
 * by Jason Choi.
 */
// #00099 : IntegerRange
public class IntegerRange {
	private IntegerRange ir = new IntegerRange();
	private IntegerRange() {}
	public IntegerRange getInstance() {
		return ir;
	}
	public static boolean betweenExclusive(int input, int min, int max) {
	       return input > min && input < max;    
	}
	public static boolean betweenInclusive(int input, int min, int max) {
		return input >= min && input <= max;
	}
}
