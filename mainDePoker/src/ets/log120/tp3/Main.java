package ets.log120.tp3;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Main
	implements Comparable<Main>, Iterable<Carte> {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public Main() {
		listeCartes = new TreeSet<Carte>();
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
		return new RangPoker();
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	public Iterator<Carte> iterator() {
		return listeCartes.iterator();
	}

	// Retourne la première carte de la main
	public Carte first() {
		return listeCartes.first();
	}

	public Collection<Carte> getCartes() {
		return listeCartes;
	}
	
	//Qu'est-ce qu'une main valide?
	public boolean estValide() {
		assert false : "TODO: implémenter cette fonction";
		return false;
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
