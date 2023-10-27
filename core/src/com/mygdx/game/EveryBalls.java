package com.mygdx.game;

import java.util.ArrayList;

public class EveryBalls {
	private  ArrayList<Ball2> balls1;
	private  ArrayList<Ball2> balls2;
	public EveryBalls () {
		balls1 = new ArrayList<>();
		balls2 = new ArrayList<>();
	}
	
	public void add(Ball2 bb) {
		balls1.add(bb);
		balls2.add(bb);
	}
	public void remove(int i) {
		balls1.remove(i);
		balls2.remove(i);
	}
	
	public Ball2 getB1(int i){
		return balls1.get(i);
	}
	
	public Ball2 getB2(int i){
		return balls2.get(i);
	}
	
	public int getsizeB1() {
		return balls1.size();
	}
	public int getsizeB2() {
		return balls1.size();
	}
}
