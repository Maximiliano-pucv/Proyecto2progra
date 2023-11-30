package com.mygdx.game;

public class Singleton {
	private static Singleton instancia;
	private Jefe data;
	
	private Singleton (String data) {
		this.data = data;
	}
	
	public static Singleton getData(String data) {
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
