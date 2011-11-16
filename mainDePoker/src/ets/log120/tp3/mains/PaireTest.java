package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class PaireTest extends TestCase {
	public void testPasDePaire()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));
		
		assertFalse(new Paire().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testPaireAs()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		assertTrue(new Paire().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testPaireRoi()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.ROI, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.ROI,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		assertTrue(new Paire().reconnaitreMain(new ReqAnalyseMain(main)));
	}

}
