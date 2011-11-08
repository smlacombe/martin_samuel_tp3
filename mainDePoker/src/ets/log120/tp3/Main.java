package ets.log120.tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main implements Comparable {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public Main() {
		
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------
		
	//Retourne le nombre de cartes dans la main
	public int size() {
		return listeCartes.size();
	}
	
	//Retourne le rang de la main courante
	public RangPoker getRangPoker() {
		return new RangPoker();
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	public Iterator iterator() {
		return listeCartes.iterator();
	}
	
	//Retourne la première carte de la main
	public void first() {
		assert false : "TODO: implémenter cette fonction";
	}
	
	public ArrayList getCartes() {
		return listeCartes;
	}
	
	public boolean estValide() {
		assert false;
		//Todo: implémenter cette fonction
		return false;
	}
	
	@Override
	public int compareTo(Object arg0) {
		assert false : "TODO: implémenter cette fonction";
		return 0;
	}
	// --------------------------------------------------
	// Mutateur(s)
	// --------------------------------------------------
	
	public void remove() {
		assert false : "TODO: implémenter cette fonction";
	}
	
	public void add() {
		assert false : "TODO: implémenter cette fonction";
	}
	

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	private ArrayList<Carte> listeCartes;
}
