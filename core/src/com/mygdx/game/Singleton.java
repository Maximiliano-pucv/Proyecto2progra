package com.mygdx.game;

public class Singleton {
	private static Singleton instancia;
	private Jefe data;
	
	private Singleton (Jefe data) {
		this.data = data;
	}
	
	public Jefe getData() {
		return data;
	}
	public static Singleton getData(Jefe data) {
		if(instancia == null) {
			synchronized(Singleton.class) {
				if (instancia == null) {
					instancia = new Singleton(data);
				}
			}
		}
		return instancia;
	}
}
