package ets.log120.tp3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

	private Denomination(String nom, String caractere) {
		this.nom = nom;
		this.caractere = caractere;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	public String getNom() {
		return nom;
	}

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
		if (obj instanceof Denomination)
			return compareTo((Denomination) obj) == 0;
		else
			return false;
	}

	@Override
	public String toString() {
		return caractere + ' ' + nom;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	public static final List<Denomination> DENOMINATIONS = Collections.unmodifiableList(Arrays.asList(
		new Denomination[] { DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS }));
	
	private String nom;
	private String caractere;
}
