package pitch;

public enum Naturals {
	
	C(0,"C",0),
	D(2,"D",1),
	E(4,"E",2),
	F(5,"F",3),
	G(7,"G",4),
	A(9,"A",5),
	B(11,"B",6);
	
	public boolean octaveflag = false;
	private int chrom;
	private int mod;
	private String chara;
	
	Naturals(int chrom, String chara, int mod) {
		this.chrom = chrom;
		this.chara = chara;
		this.mod = mod;
	}
	
	public int returnChrom() {
		return chrom;
	}
	
	public String returnCharacter() {
		return chara;
	}
	
	public int calcQuantity(Naturals b) {
		int diff = mod-b.mod+1;
		return diff;
	}
	
	public Naturals calculateNextNote(int quantity) {
		octaveflag = false;
		int index = mod + quantity-1;
		int wrap = index - 7;
		for(Naturals a : Naturals.values() ) {
			if(a.mod == index) {
				return a;
			} else if (a.mod == wrap) {
				octaveflag = true;
				return a;
			}
		}
		throw new IllegalArgumentException("Pitch not Found");
	}
	
	public Naturals returnFromChromatic(int chrom) {
		for(Naturals a : Naturals.values()) {
			if(chrom == a.chrom) {
				return a;
			}
		}
		throw new IllegalArgumentException("IndexOutOfBounds");
	}
	
	public static boolean hasChrom(int chrom) {
		boolean b = false;
		for(Naturals a : Naturals.values()) {
			if(a.chrom == chrom) {
				b = true;
			}
		}
		return b;
	}
}
