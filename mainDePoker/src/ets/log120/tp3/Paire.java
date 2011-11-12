package ets.log120.tp3;

import java.util.Iterator;
import java.util.TreeMap;

public class Paire extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		if (getNombreDePaire(contexte.getMain()) >= 1) {
			contexte.setRangReconnu(new RangPoker(2));
			return true;
		}
		
		return false;
	}
		
	static public int getNombreDePaire(Main main) {
		int nombreDePaire = 0;
			
		TreeMap<Denomination, Integer> nbDenominations = new TreeMap<Denomination, Integer>();
		
		for(Carte carte1 : main) {
			Integer compteur = nbDenominations.get(carte1.getDenomination());
			nbDenominations.put(carte1.getDenomination(), (compteur == null) ? 0 : compteur+1);	
		}
		
		for (Iterator<Integer> i = nbDenominations.values().iterator() ; i.hasNext();)
			nombreDePaire += (i.next() / 2);

		return nombreDePaire;
	}
}