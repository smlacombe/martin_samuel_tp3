package ets.log120.tp3.cartes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classe représentant une couleur de carte.
 * 
 * C'est la sorte d'une carte. Les quatre couleurs sont : cœur, pique, carreau, trèfle. Au Poker, le
 * terme "couleur" ne représente jamais le noir ou le rouge.
 * 
 * @author Martin Desharnais
 */
public class CouleurCarte
		implements Comparable<CouleurCarte> {

	public static final CouleurCarte TREFLE  = new CouleurCarte("trèfle");
	public static final CouleurCarte CARREAU = new CouleurCarte("carreau");
	public static final CouleurCarte PIQUE   = new CouleurCarte("pique");
	public static final CouleurCarte COEUR   = new CouleurCarte("coeur");
	public static final CouleurCarte JOKER   = new CouleurCarte("joker");

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	/**
	 * Constructeur créant une couleur à partir de son nom.
	 */
	private CouleurCarte(String nom) {
		this.nom = nom;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	/**
	 * Retourne le nom de la couleur.
	 */
	public String getNom() {
		return this.nom;
	}

	@Override
	public int compareTo(CouleurCarte obj) {
		if (obj == null)
			throw new NullPointerException();

		return COULEURS.indexOf(this) - COULEURS.indexOf(obj);
	}

	@Override
	public String toString() {
		return nom;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	public static final List<CouleurCarte> COULEURS = Collections.unmodifiableList(Arrays.asList(
			new CouleurCarte[] { TREFLE, CARREAU, PIQUE, COEUR, JOKER }));

	private String nom;
}
