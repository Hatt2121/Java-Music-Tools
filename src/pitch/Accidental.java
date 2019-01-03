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
}
