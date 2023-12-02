package com.mygdx.game;

public class Singleton {
	private static Singleton instancia;
	private Jefe data;
	
	private Singleton () {
	}
	
	public Jefe getData() {
		return data;
	}
	public static Singleton getInstance() {
		if(instancia == null) {
			synchronized(Singleton.class) {
				if (instancia == null) {
					instancia = new Singleton();
				}
			}
		}
		return instancia;
	}
}
