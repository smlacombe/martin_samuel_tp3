package ets.log120.tp3.mains;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import ets.log120.tp3.cartes.Carte;

public class Main
	implements Comparable<Main>, Iterable<Carte> {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public Main() {
		listeCartes = new TreeSet<Carte>(new ets.util.functional.Greater<Carte>());
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	// Retourne le nombre de cartes dans la main
	public int size() {
		return listeCartes.size();
	}

	// Retourne le rang de la main courante
	public RangPoker getRangPoker() {
		assert false : "Pas implémenter";
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else
			return listeCartes.equals(((Main) obj).listeCartes);	
	}

	public Iterator<Carte> iterator() {
		return listeCartes.iterator();
	}

	/**
	 * Retourne la carte la plus forte.
	 */
	public Carte first() {
		return listeCartes.first();
	}

	public Collection<Carte> getCartes() {
		return listeCartes;
	}
	
	//Retourne si la main est valide
	//Une main valide est toute main ayant au moins une carte
	public boolean estValide() {
		return listeCartes.size() != 0;
	}

	@Override
	public int compareTo(Main obj) {
		assert false : "TODO: implémenter cette fonction";
		return 0;
	}

	// --------------------------------------------------
	// Mutateur(s)
	// --------------------------------------------------

	public boolean remove(Carte c) {
		return listeCartes.remove(c);
	}

	public boolean add(Carte c) {
		return listeCartes.add(c);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	private TreeSet<Carte> listeCartes;
}
