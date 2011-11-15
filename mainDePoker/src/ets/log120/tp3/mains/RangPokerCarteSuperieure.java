package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker obtenus de deux CarteSuperieure.
 * 
 * Si vous n'avez absolument aucune combinaison, alors la valeur de votre main correspond à la carte
 * la plus forte en votre possession (dans votre jeu ou bien sur les cartes communes de la table).
 * Par exemple, un As si vous avez un as en main et que les cartes communes sont toutes inférieures.
 * 
 * Voici la valeur des dénominations de cartes dans l'ordre décroissant : l'as, le roi, la dame, le
 * valet, le 10, le 9, le 8, le 7, le 6, le 5, le 4, le 3 et le 2.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 */
public class RangPokerCarteSuperieure extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerCarteSuperieure(int rang, Denomination meilleure) {
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

		return meilleure.compareTo(((RangPokerCarteSuperieure) obj).meilleure);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination meilleure;
}
