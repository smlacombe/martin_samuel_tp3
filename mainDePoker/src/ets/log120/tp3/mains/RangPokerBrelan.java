package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentant un brelan.
 * 
 * En général, c'est la carte « kicker » qui départage les mains. Cette règle s'applique lorsque
 * deux mains ont la même paire, ou les mêmes deux paires. La carte « kicker » est la carte
 * supérieure succédant à la paire.
 * 
 * @author Martin Desharnais
 */
public class RangPokerBrelan extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------
	
	public RangPokerBrelan(Denomination brelan, Denomination kicker) {
		super(4);
		this.brelan = brelan;
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

		RangPokerBrelan other = (RangPokerBrelan) obj;

		resultat = brelan.compareTo(other.brelan);
		if (resultat == 0)
			resultat = kicker.compareTo(other.kicker);

		return resultat;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination brelan;
	private Denomination kicker;
	RangPokerPaire rangPoker;
}
