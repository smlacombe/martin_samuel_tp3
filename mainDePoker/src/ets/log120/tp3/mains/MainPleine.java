package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
* Classe chargée de reconnaître dans une main, une main pleine (full house)
* Une main pleine (full house) est constitué d'un brelan et une paire. Le rang de la main pleine est déterminé par le triple et, dans un cas d'égalité des
* triples, par la paire.
* @author Samuel Milette-Lacombe
**/
public class MainPleine extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		
		Denomination brelan = null;
		Denomination paire = null;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if (brelan == null && entry.getValue() >= 3)
				brelan = entry.getKey();
			else if (paire == null && entry.getValue() >= 2)
				paire = entry.getKey();
			
			if (brelan != null && paire != null) {
				contexte.setRangReconnu(new RangPokerMainPleine(brelan, paire));
				return true;
			}
		}
		
		return false;
	}
	
}
