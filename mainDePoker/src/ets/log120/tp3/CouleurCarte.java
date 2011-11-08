package ets.log120.tp3;

public class CouleurCarte
	implements Comparable<CouleurCarte> {
	
	public static final CouleurCarte TREFLE  = new CouleurCarte("trèfle");
    public static final CouleurCarte CARREAU = new CouleurCarte("carreau");
    public static final CouleurCarte PIQUE   = new CouleurCarte("pique");
    public static final CouleurCarte COEUR   = new CouleurCarte("coeur");

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	private CouleurCarte(String nom) {
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
		if (obj == null)
			throw new NullPointerException();
		
		return getNom().compareTo(obj.getNom());
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
