package ets.log120.tp3;

public class Denomination
	implements Comparable<Denomination> {

	public static final Denomination AS    = new Denomination("AS",    'A');
	public static final Denomination JOKER = new Denomination("JOKER", 'J');

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	private Denomination(String nom, char caractere) {
		this.nom = nom;
		this.caractere = caractere;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	public String getNom() {
		return nom;
	}

	public char caractereSurCarte() {
		return caractere;
	}

	@Override
	public int compareTo(Denomination obj) {
		assert false : "TODO : Implement this function.";
		return 1;
	}

	@Override
	public String toString() {
		return caractere + ' ' + nom;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private String nom;
	private char caractere;
}
