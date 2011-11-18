package ets.log120.tp3.mains;

import java.util.Iterator;
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
		Denomination precedante = null;
		int n = 0;
		
		Iterator<Carte> it = contexte.getMain().iterator();
		while (it.hasNext() && n < 4) {
			Denomination courante = it.next().getDenomination();
			
			if (precedante == null || !precedante.equals(courante)) {
				precedante = courante;
				n = 1;
			} else {
				++n;
			}
		}
		
		if (n == 4) {
			contexte.setRangReconnu(new RangPokerCarre(precedante));
			return true;
		} else {
			return false;
		}
	}
}
