package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class CarteSuperieureTest extends TestCase {
	public void testEvalueMain()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.SEPT,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.COEUR));
		
		assertTrue(new CarteSuperieure().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
