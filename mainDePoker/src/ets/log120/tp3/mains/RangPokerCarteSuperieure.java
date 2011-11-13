package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;

public class RangPokerCarteSuperieure extends RangPoker {
	
	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------
	
	public RangPokerCarteSuperieure(int rang, Carte meilleure) {
		super(rang);
		this.meilleure = meilleure;
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------
	
	@Override
	public int compareTo(RangPoker obj) {
		int resultat = super.compareTo(obj);
		if (resultat != 0)
			return resultat;
		
		return meilleure.getDenomination().compareTo(
				((RangPokerCarteSuperieure) obj).meilleure.getDenomination());
	}
	
	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	private Carte meilleure;
}
