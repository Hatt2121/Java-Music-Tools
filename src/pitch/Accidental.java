package pitch;

public enum Accidental {
	
	DFLAT("bb",-2),
	FLAT("b",-1),
	NATURAL("[]",0),
	SHARP("#",1),
	DSHARP("x",2);
	
	private String chara;
	private int index;
	
	Accidental(String chara, int index) {
		this.chara = chara;
		this.index = index;
	}
	
	public String returnCharacter() {
		return chara;
	}
	
	public int returnIndex() {
		return index;
	}
	
	public static Accidental returnFromIndex(int index) {
		for(Accidental a : Accidental.values()) {
			if(a.index == index) {
				return a;
			}
		}
		throw new IllegalArgumentException("Accidental Calculated Doesn't Exist");
	}
}
