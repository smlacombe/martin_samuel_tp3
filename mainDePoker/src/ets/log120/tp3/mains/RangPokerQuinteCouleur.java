package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentant une quinte couleur.
 * @author Samuel Milette-Lacombe
 */
public class RangPokerQuinteCouleur extends RangPoker {

    // --------------------------------------------------
    // Constructeur(s)
    // --------------------------------------------------

    public RangPokerQuinteCouleur(Denomination meilleure) {
    	super(9);
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

		RangPokerQuinteCouleur other = (RangPokerQuinteCouleur) obj;
		return meilleure.compareTo(other.meilleure);
    }

    // --------------------------------------------------
    // Attribut(s)
    // --------------------------------------------------

    private Denomination meilleure;
}
