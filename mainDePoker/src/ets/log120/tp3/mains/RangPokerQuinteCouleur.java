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
    	rangQuinte = new RangPokerQuinte(meilleure);
    }

    // --------------------------------------------------
    // Accesseur(s)
    // --------------------------------------------------

    @Override
    public int compareTo(RangPoker obj) {
    	return rangQuinte.compareTo(obj);
    }

    // --------------------------------------------------
    // Attribut(s)
    // --------------------------------------------------

    RangPokerQuinte rangQuinte;
}
