package pitch;

public class Pitch {
	
	public int octave;
	public int chrom;
	private int midi;
	
	private double freq;
	
	private String chara;
	Naturals nat;
	Accidental acc;
	
	public Pitch(Naturals nat, int octave, Accidental acc) {
		this.nat = nat;
		chrom = nat.returnChrom();
		chara = nat.returnCharacter()+acc.returnCharacter();
		
		this.octave = octave;
		this.acc = acc;
		
		midi = nat.returnChrom()+(octave+1)*12;		
	}
	
	public void printChrom() {
		System.out.println(chrom);
	}
	
	public void printCharacter() {
		System.out.println(chara);
	}
	
	public int returnMidi() {
		return midi;
	}
	
	public void lower() {
		chrom = chrom -1;
		midi = midi -1;
		if(chara.endsWith("#")) {
			chara = chara.replace("#","");
		} else if(chara.endsWith("x")) {
			chara = chara.replace("x","#");
		} else if(chara.endsWith("b")) {
			chara = chara.replace("b", "%");
		} else {
			chara = chara+"b";
		}
	}
	
	public void raise() {
		chrom = chrom+ 1;
		midi = midi +1;
		if(chara.endsWith("#")) {
			chara = chara.replace("#","x");
		} else if(chara.endsWith("b")) {
			chara = chara.replace("b", "");
		} else if(chara.endsWith("%")) {
			chara = chara.replace("%", "b");
		} else {
			chara  = chara + "#";
		}
	}
	
	public double returnFreq() {
		double q = (midi-69);
		double p = q/12;
		freq = 440*Math.pow(2,p);
		return freq;
	}
}
