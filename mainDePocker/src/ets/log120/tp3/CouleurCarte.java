package ets.log120.tp3;

public class CouleurCarte
	implements Comparable<CouleurCarte> {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public CouleurCarte(String nom) {
		this.nom = nom;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	public String getNom() {
		return this.nom;
	}

	@Override
	public int compareTo(CouleurCarte obj) {
		return 1;
	}

	@Override
	public String toString() {
		return nom;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	String nom;
}
