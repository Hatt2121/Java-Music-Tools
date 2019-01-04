package scale;

import java.util.ArrayList;

import pitch.*;

public class Scale {
	
	public Pitch starting;
	public ArrayList<Interval> intervalset = new ArrayList<Interval>();
	public ArrayList<Pitch> list = new ArrayList<Pitch>();
	
	public Scale(Pitch starting, ArrayList<Interval> set) {
		this.starting = starting;
		intervalset = set;
		list.add(starting);
		
		for(int x = 0; x < intervalset.size(); x++) {
			Interval a  = intervalset.get(x);
			list.add(list.get(x).calculateNextPitch(a));
		}
	}
	
	public void printScale(boolean debug) {
		for(Pitch a : list) {
			a.printCharacter();
			if(debug) {
				a.printChrom();
				System.out.println(a.returnMidi());
				System.out.println(a.octave);
				System.out.println(a.acc.returnIndex());
				System.out.println();
			}
		}
	}
}
