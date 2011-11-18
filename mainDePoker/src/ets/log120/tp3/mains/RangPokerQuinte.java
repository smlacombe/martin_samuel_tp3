package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentant une quinte.
 * 
 * Pour tous les autres cas, par exemple, une carte supérieure qui est égale pour deux mains, deux
 * séquences avec la même dénomination supérieure, deux couleurs (flushes) avec les mêmes valeurs,
 * etc., c'est égalité.
 * 
 * @author Martin Desharnais
 */
public class RangPokerQuinte extends RangPoker {

    // --------------------------------------------------
    // Constructeur(s)
    // --------------------------------------------------

    public RangPokerQuinte(Denomination meilleure) {
    	super(5);
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

		RangPokerQuinte other = (RangPokerQuinte) obj;

		return meilleure.compareTo(other.meilleure);
    }

    // --------------------------------------------------
    // Attribut(s)
    // --------------------------------------------------

    private Denomination meilleure;

}
