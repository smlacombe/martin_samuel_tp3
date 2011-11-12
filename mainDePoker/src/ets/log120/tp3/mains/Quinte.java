package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître une quinte.
 * 
 * Une quinte est une séquence de cinq cartes, pas toutes de la même couleur. Bien que l'as ait la
 * dénomination supérieure, il peut être utilisé pour former une séquence as-2-3-4-5. Pourtant, il
 * doit être toujours au début ou à la fin d'une séquence.
 * 
 * @author Martin Desharnais
 */
public class Quinte extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		Denomination derniereDenomination = null;
		for(Carte carte : contexte.getMain()) {
			if (derniereDenomination == null)
				derniereDenomination = carte.getDenomination();
			else {
				int precedant = Denomination.DENOMINATIONS.indexOf(derniereDenomination);
				int courant   = Denomination.DENOMINATIONS.indexOf(carte.getDenomination());
				if (precedant != courant - 1
					&& !(derniereDenomination.equals(Denomination.CINQ) && carte.getDenomination().equals(Denomination.AS)))
					return false;
				derniereDenomination = carte.getDenomination();
			}
		}
		contexte.setRangReconnu(new RangPoker(5));
		return true;
	}
}
