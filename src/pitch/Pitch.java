package pitch;

public class Pitch {
	
	public int octave;
	public int chrom;
	private int midi;
	
	private double freq;
	
	private String chara;
	Naturals nat;
	public Accidental acc;
	
	public Pitch(Naturals nat, int octave, Accidental acc) {
		this.nat = nat;
		chrom = nat.returnChrom()+acc.returnIndex();
		chara = nat.returnCharacter()+acc.returnCharacter();
		
		this.octave = octave;
		this.acc = acc;
		
		midi = nat.returnChrom()+(octave+1)*12+acc.returnIndex();		
	}
	
	public Pitch(Naturals nat, int octave, Accidental acc, int chrom, int midi) {
		this.nat = nat;
		this.octave = octave;
		this.acc = acc;
		this.chrom = chrom;
		this.midi = midi;
		
		chara = nat.returnCharacter() + acc.returnCharacter();
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
		chara = chara.replace(acc.returnCharacter(), "");
		acc = Accidental.returnFromIndex(acc.returnIndex()-1);
		chara  = chara + acc.returnCharacter();

	}
	
	public void raise() {
		chrom = chrom+ 1;
		midi = midi +1;
		chara = chara.replace(acc.returnCharacter(), "");
		acc = Accidental.returnFromIndex(acc.returnIndex()+1);
		chara = chara + acc.returnCharacter();
	}
	
	public double returnFreq() {
		double q = (midi-69);
		double p = q/12;
		freq = 440*Math.pow(2,p);
		return freq;
	}
	
	public Pitch calculateNextPitch(Interval interval) {
		int mid = midi +interval.returnTonicDifference();
		Naturals na = nat.calculateNextNote(interval.returnQuantity());
		Accidental ac;
		int chro = chrom + interval.returnTonicDifference();
		int oct = octave;
		if(na.returnChrom() != chro) {
			int b = chro - na.returnChrom();
			if(chro>=12) {
				b=b-13;
			}
			ac = Accidental.returnFromIndex(b);
		} else {
			ac = Accidental.NATURAL;
		}
		
		if(nat.octaveflag) {
			chro = chro - 12;
			oct = octave + 1;
		}
		
		return new Pitch(na,oct,ac,chro,mid);
	}
}
