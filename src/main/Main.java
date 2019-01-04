package main;

import java.util.ArrayList;

import pitch.*;
import scale.*;

public class Main {
	public static void main(String[] args) {
		Pitch a = new Pitch(Naturals.B,4,Accidental.SHARP);
		Pitch b = a.calculateNextPitch(Interval.H);
		b.printCharacter();
		
		Pitch g = new Pitch(Naturals.A,4,Accidental.NATURAL);
		ArrayList<Interval> major = new ArrayList<Interval>();
		major.add(Interval.W);
		major.add(Interval.W);
		major.add(Interval.H);
		major.add(Interval.W);
		major.add(Interval.W);
		major.add(Interval.W);
		major.add(Interval.H);
		
		Scale majorscale = new Scale(g,major);
		majorscale.printScale(true);
	}
}
