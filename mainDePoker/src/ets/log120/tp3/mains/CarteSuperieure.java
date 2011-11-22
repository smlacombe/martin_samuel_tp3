package ets.log120.tp3.mains;

/**
 * Classe chargée de reconnaître une carte supérieure.
 * 
 * Des cartes qui ne forment aucune combinaison. Voici la valeur des dénominations de cartes dans
 * l'ordre décroissant : l'as, le roi, la dame, le valet, le 10, le 9, le 8, le 7, le 6, le 5, le 4,
 * le 3 et le 2. Voir la classe Dénomination.java pour plus d'informations.
 * 
 * @author Martin Desharnais
 * @author Samuel Milette-Lacombe
 */
public class CarteSuperieure extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		contexte.setRangReconnu(new RangPokerCarteSuperieure(contexte.getMain().first().getDenomination()));
		return true;
	}
}
