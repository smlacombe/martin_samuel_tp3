package ets.log120.tp3.mains;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.TreeMultiset;

import ets.log120.tp3.cartes.Carte;

/**
 * Classe représentant une main constitué d'un nombre arbritaire de cartes.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 */
public class Main
	implements Comparable<Main>, Iterable<Carte> {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	/**
	 * Construit une main vide.
	 */
	public Main() {
		listeCartes = TreeMultiset.create(new ets.util.functional.Greater<Carte>());
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	/**
	 *  Retourne le nombre de cartes dans la main.
	 */
	public int size() {
		return listeCartes.size();
	}

	/**
	 *  Retourne le rang de la main courante.
	 */
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

	/**
	 * Retourne un itérateur permettant de parcourir les cartes.
	 */
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
	
	/**
	 * Retourne si la main est valide.
	 * 
	 * Une main valide est toute main ayant au moins une carte.
	 */
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

	/**
	 * Ajoute une carte dans la main.
	 */
	public boolean add(Carte c) {
		return listeCartes.add(c);
	}
	
	/**
	 * Suprime une occurence de la carte demandée de la main.
	 */
	public boolean remove(Carte c) {
		return listeCartes.remove(c);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	private TreeMultiset<Carte> listeCartes;
}
