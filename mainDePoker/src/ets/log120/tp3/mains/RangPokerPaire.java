package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker obtenus de deux Paire.
 * 
 * Si les deux joueurs ont une meme paire, on considerera une troisieme carte. Par exemple,
 * Q-Q-K-4-3 bat Q-Q-9-3-2 puisque le roi est plus fort que le neuf. On appelera cette main : une
 * paire de Dames au Roi
 * 
 * En général, c'est la carte « kicker » qui départage les mains. Cette règle s'applique lorsque
 * deux mains ont la même paire, ou les mêmes deux paires. La carte « kicker » est la carte
 * supérieure succédant à la paire.
 * 
 * @author Martin Desharnais
 */
public class RangPokerPaire extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerPaire(int rang, Denomination paire, Denomination kicker) {
		super(rang);
		this.paire = paire;
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

		RangPokerPaire other = (RangPokerPaire) obj;

		resultat = paire.compareTo(other.paire);
		if (resultat == 0)
			resultat = kicker.compareTo(other.kicker);

		return resultat;
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination paire;
	private Denomination kicker;

}
