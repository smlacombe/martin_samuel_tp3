package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
 * Classe chargée de reconnaître un brelan.
 * 
 * Un brelan est constitué de trois cartes de même dénomination.
 * 
 * @author Martin Desharnais
 * @see ets.log120.tp3.Quinte
 */
public class Brelan extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		
		Denomination brelan = null;
		Denomination kicker = null;
		
		Integer nombreJoker = map.remove(Denomination.JOKER);
		if (nombreJoker == null)
			nombreJoker = 0;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if (brelan == null && (entry.getValue() + nombreJoker >= 3)) {
				brelan = entry.getKey();
				if (entry.getValue() < 3)
					nombreJoker -= 3 - entry.getValue();
			} else if (kicker == null) {
				kicker = entry.getKey();
			}
			
			if (brelan != null && kicker != null) {
				contexte.setRangReconnu(new RangPokerBrelan(brelan, kicker));
				return true;
			}
		}
		
		return false;
	}
}
