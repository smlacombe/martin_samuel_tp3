package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de différencier deux RangPoker représentant deux paires.
 * 
 * Si les deux joueurs ont une meme paire, on considerera une troisieme carte. Par exemple,
 * Q-Q-K-4-3 bat Q-Q-9-3-2 puisque le roi est plus fort que le neuf. On appelera cette main : une
 * paire de Dames au Roi
 * 
 * En général, c'est la carte « kicker » qui départage les mains. Cette règle s'applique lorsque
 * deux mains ont la même paire, ou les mêmes deux paires. La carte « kicker » est la carte
 * supérieure succédant à la paire.
 * 
 * @author Samuel Milette Lacombe
 * @author Martin Desharnais
 */
public class RangPokerDeuxPaires extends RangPoker {

	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	public RangPokerDeuxPaires(Denomination autrePaire, Denomination meilleurePaire, Denomination kicker) {
		super(RANG_DEUX_PAIRES);
		this.autrePaire = autrePaire;
		this.meilleurePaire = meilleurePaire;
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

		RangPokerDeuxPaires other = (RangPokerDeuxPaires) obj;

		resultat = meilleurePaire.compareTo(meilleurePaire);
		
		if (resultat != 0)
			return resultat;
		
		resultat = autrePaire.compareTo(autrePaire);
		
		if (resultat != 0)
			return resultat;

		return kicker.compareTo(other.kicker);
	}

	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------

	private Denomination autrePaire;
	private Denomination meilleurePaire;
	private Denomination kicker;
	private final static int RANG_DEUX_PAIRES = 3;

}
