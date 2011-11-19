package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Denomination;

/**
* Classe chargée de reconnaître dans une main, une main pleine (full house)
* 
* Une main pleine (full house) est constituée d'un brelan et d'une paire. Le rang de la main pleine
* est déterminé par le triple et, dans un cas d'égalité des triples, par la paire.
* 
* Dans le cas de deux mains avec deux paires, c'est la paire supérieure qui l'emporte, ou bien la
* paire inférieure en cas d'égalité pour la paire supérieure. 
* 
* @author Samuel Milette-Lacombe
**/
public class MainPleine extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		
		Integer nombreJoker = map.remove(Denomination.JOKER);
		
		if (nombreJoker == null)
			nombreJoker = 0;
		
		Denomination brelan = null;
		Denomination paire = null;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			if ((brelan == null) 
			&& ((entry.getValue() >= 3) || ((entry.getValue() == 2) && (nombreJoker >= 1)))) {
				brelan = entry.getKey();
				nombreJoker--;
			}
			else if ((paire == null)
			&& ((entry.getValue() >= 2) || ((entry.getValue() == 1) && (nombreJoker >= 1)))) {
				paire = entry.getKey();
				nombreJoker--;
			}
			
			if (brelan != null && paire != null) {
				contexte.setRangReconnu(new RangPokerMainPleine(brelan, paire));
				return true;
			}
		}
		
		return false;
	}
	
}
