package ets.log120.tp3.cartes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classe représentant une dénomination.
 * 
 * C'est la valeur d'une carte, parmi 13 valeurs possibles, p. ex.: deux, trois, ..., dix, valet, dame, roi, as.
 * 
 * @author Martin Desharnais
 */
public class Denomination
	implements Comparable<Denomination> {

	public static final Denomination AS     = new Denomination("AS",     "A");
	public static final Denomination DEUX   = new Denomination("DEUX",   "2");
	public static final Denomination TROIS  = new Denomination("TROIS",  "3");
	public static final Denomination QUATRE = new Denomination("QUATRE", "4");
	public static final Denomination CINQ   = new Denomination("CINQ",   "5");
	public static final Denomination SIX    = new Denomination("SIX",    "6");
	public static final Denomination SEPT   = new Denomination("SEPT",   "7");
	public static final Denomination HUIT   = new Denomination("HUIT",   "8");
	public static final Denomination NEUF   = new Denomination("NEUF",   "9");
	public static final Denomination DIX    = new Denomination("DIX",    "10");
	public static final Denomination VALET  = new Denomination("VALET",  "V");
	public static final Denomination DAME   = new Denomination("DAME",   "D");
	public static final Denomination ROI    = new Denomination("ROI",    "R");
	public static final Denomination JOKER  = new Denomination("JOKER",  "J");

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	/**
	 * Constructeur créant une dénomination à partir de son nom et du caractère la représentant.
	 */
	private Denomination(String nom, String caractere) {
		this.nom = nom;
		this.caractere = caractere;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	/**
	 * Retourne le nom de la dénomination.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne le caractère représentant la dénomination.
	 */
	public String caractereSurCarte() {
		return caractere;
	}

	@Override
	public int compareTo(Denomination obj) {
		if (obj == null)
			throw new NullPointerException();

		return DENOMINATIONS.indexOf(this) - DENOMINATIONS.indexOf(obj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Denomination))
			return false;
		Denomination other = (Denomination) obj;
		if (caractere == null) {
			if (other.caractere != null)
				return false;
		} else if (!caractere.equals(other.caractere))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return caractere + ' ' + nom;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	public static final List<Denomination> DENOMINATIONS = Collections.unmodifiableList(Arrays.asList(
		new Denomination[] { DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS, JOKER }));
	
	private String nom;
	private String caractere;
}
