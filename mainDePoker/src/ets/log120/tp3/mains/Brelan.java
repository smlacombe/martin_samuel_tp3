package ets.log120.tp3.mains;

import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître un brelan.
 * 
 * Un brelan est constitué de trois carte de même dénomination.
 * 
 * @author Martin Desharnais
 * @see ets.log120.tp3.Quinte
 */
public class Brelan extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> nombreDenominations = new TreeMap<Denomination, Integer>();
		
		for (Carte carte : contexte.getMain()) {
			Integer nombre = nombreDenominations.get(carte.getDenomination());
			nombre = (nombre == null) ? 1 : nombre + 1;

			if (nombre == 3) {
				contexte.setRangReconnu(new RangPoker(4));
				return true;
			} else {
				nombreDenominations.put(carte.getDenomination(), nombre);
			}
		}
		
		return false;
	}
}
