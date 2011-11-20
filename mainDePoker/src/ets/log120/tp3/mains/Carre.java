package ets.log120.tp3.mains;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître un carré.
 * 
 * Un carré est composé de quatre cartes de même dénomination.
 * 
 * @author Martin Desharnais
 */
public class Carre extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());

		Integer nombreJoker = map.remove(Denomination.JOKER);
		if (nombreJoker == null)
			nombreJoker = 0;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if (entry.getValue() + nombreJoker >= 4) {
				contexte.setRangReconnu(new RangPokerCarre(entry.getKey()));
				return true;
			}
		}
		
		return false;
	}
}
