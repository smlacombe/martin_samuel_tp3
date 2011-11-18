package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentant un carre.
 * 
 * @author Martin Desharnais
 * @see ets.log120.tp3.mains.Carre
 */
public class RangPokerCarre extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerCarre(Denomination carre) {
		super(RANG_CARRE);
		this.carre = carre;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	@Override
	public int compareTo(RangPoker obj) {
		int resultat = super.compareTo(obj);
		if (resultat != 0)
			return resultat;

		RangPokerCarre other = (RangPokerCarre) obj;

		return carre.compareTo(other.carre);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination carre;
	private final static int RANG_CARRE = 2;
}
