package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentants deux brelans.
 * @author Samuel Milette Lacombe
 */
public class RangPokerMainPleine extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerMainPleine(Denomination brelan, Denomination paire, Denomination kicker) {
		super(RANG_MAIN_PLEINE);
		this.brelan = brelan;
		this.paire = paire;
		this.kicker = kicker;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	@Override
	public int compareTo(RangPoker obj) {
		int resultat = super.compareTo(obj);
		if (resultat != 0)
			return resultat;

		RangPokerMainPleine other = (RangPokerMainPleine) obj;

		resultat = brelan.compareTo(other.brelan);
		
		if (resultat != 0)
			return resultat;
		
		resultat = paire.compareTo(other.paire);
		
		if (resultat != 0)
			return resultat;

		return kicker.compareTo(other.kicker);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination brelan;
	private Denomination paire;
	private Denomination kicker;
	private final static int RANG_MAIN_PLEINE = 7;
}
