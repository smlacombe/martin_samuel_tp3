package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.Denomination;

public class Paire extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = compterDenominations(contexte.getMain());
		
		Denomination paire = null;
		Denomination kicker = null;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if (paire == null && entry.getValue() >= 2)
				paire = entry.getKey();
			else if (kicker == null)
				kicker = entry.getKey();
			
			if (paire != null && kicker != null) {
				contexte.setRangReconnu(new RangPokerPaire(2, paire, kicker));
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Retourne une map, trié par ordre décroissant, de dénominations et du nombre d'occurences de
	 * celles-ci dans la main reçue en paramètre.
	 */
	static public TreeMap<Denomination, Integer> compterDenominations(Main main) {
		TreeMap<Denomination, Integer> map = new TreeMap<Denomination, Integer>(
				new ets.util.functional.Greater<Denomination>());

		for (Carte carte : main) {
			Integer n = map.get(carte.getDenomination());
			map.put(carte.getDenomination(), (n == null) ? 1 : n + 1);
		}

		return map;
	}
}