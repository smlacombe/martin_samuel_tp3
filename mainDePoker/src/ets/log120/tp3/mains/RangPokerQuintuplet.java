package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentant un quintuplet.
 *  
 * @author Samuel Milette-Lacombe
 */
public class RangPokerQuintuplet extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerQuintuplet(Denomination quintuplet) {
		super(10);
		this.quintuplet = quintuplet;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	@Override
	public int compareTo(RangPoker obj) {
		int resultat = super.compareTo(obj);
		if (resultat != 0)
			return resultat;

		RangPokerQuintuplet other = (RangPokerQuintuplet) obj;
		resultat = quintuplet.compareTo(other.quintuplet);
	
		return resultat;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination quintuplet;
}
