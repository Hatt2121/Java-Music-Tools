package pitch;

public enum Interval {

	P1(0,1,0),
	
	W(0,2,2),
	H(-1,2,1),
	
	d2(-2,2,0),
	m2(-1,2,1), 
	M2(0,2,2),
	A2(1,2,3),
	
	d3(-2,3,2),
	m3(-1,3,3),
	M3(0,3,4),
	A3(1,3,5),
	
	d4(-1,4,4),
	P4(0,4,5),
	A4(1,4,6),
	
	d5(-1,5,6),
	P5(0,5,7),
	A5(1,5,8),
	
	d6(-2,6,7),
	m6(-1,6,8),
	M6(0,6,9),
	A6(1,6,10),
	
	d7(-2,7,9),
	m7(-1,7,10),
	M7(0,7,11),
	A7(1,7,12),
	
	d8(-1,8,11),
	P8(0,8,12),
	A8(1,8,13);
	
	private int qualdiff;
	private int quantdiff;
	private int tondiff;
	
	
	Interval(int diff, int quantdiff,int tondiff) {
		this.qualdiff = diff;
		this.quantdiff = quantdiff;
		this.tondiff = tondiff;
	}
	
	public int returnQuality() {
		return qualdiff;
	}
	
	public int returnQuantity() {
		return quantdiff;
	}
	
	public int returnTonicDifference() {
		return tondiff;
	}
}
