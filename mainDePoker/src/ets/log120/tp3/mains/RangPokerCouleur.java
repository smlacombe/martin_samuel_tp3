package ets.log120.tp3.mains;

import java.util.ArrayList;
import java.util.Iterator;

import ets.log120.tp3.cartes.Denomination;

public class RangPokerCouleur extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerCouleur(ArrayList<Denomination> flush) {
		super(RANG_COULER);
		this.flush = flush;
	}

	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	@Override
	public int compareTo(RangPoker obj) {
		int resultat = super.compareTo(obj);
		if (resultat != 0)
			return resultat;

		RangPokerCouleur other = (RangPokerCouleur) obj;
		Iterator<Denomination> it = flush.iterator();
		Iterator<Denomination> otherIt = other.flush.iterator();
		
		assert flush.size() == other.flush.size();
		
		while (resultat == 0 && it.hasNext() && otherIt.hasNext())
			resultat = it.next().compareTo(otherIt.next());

		return resultat;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	ArrayList<Denomination> flush;
	private final static int RANG_COULER = 6;
}
