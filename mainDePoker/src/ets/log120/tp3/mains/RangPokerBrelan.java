package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

public class RangPokerBrelan extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------
	
	public RangPokerBrelan(Denomination brelan, Denomination kicker) {
		super(4);
		rangPoker = new RangPokerPaire(brelan, kicker);
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	@Override
	public int compareTo(RangPoker obj) {
		return rangPoker.compareTo(obj);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	RangPokerPaire rangPoker;
}
