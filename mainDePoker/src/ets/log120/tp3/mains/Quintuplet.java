package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

public class Quintuplet extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		
		Denomination quintuplet = null;

		Integer nombreJoker = map.remove(Denomination.JOKER);
		if (nombreJoker == null)
			nombreJoker = 0;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			
			if (quintuplet == null && (entry.getValue() + nombreJoker >= 5))
				quintuplet = entry.getKey();
					
			if (quintuplet != null) {
				contexte.setRangReconnu(new RangPokerQuintuplet(quintuplet));
				return true;
			}
		}
		
		return false;
	}
}
