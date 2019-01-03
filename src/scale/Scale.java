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
	}
	
	
	
	
}
