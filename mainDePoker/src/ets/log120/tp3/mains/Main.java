package ets.log120.tp3.mains;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import com.google.common.collect.TreeMultiset;

import ets.log120.tp3.cartes.Carte;

public class Main
	implements Comparable<Main>, Iterable<Carte> {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public Main() {
		listeCartes = TreeMultiset.create(new ets.util.functional.Greater<Carte>());
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
		AbstractAnalyseurRang analyseur = AnalyseurRangFactory.makeAnalyseurRang();
		ReqAnalyseMain requeteMain = new ReqAnalyseMain(this);
		analyseur.traiterDemande(requeteMain);
		return requeteMain.getRangReconnu();
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
		return listeCartes.entrySet().iterator().next().getElement();
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
		return getRangPoker().compareTo(obj.getRangPoker());
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
	
	private TreeMultiset<Carte> listeCartes;
}
