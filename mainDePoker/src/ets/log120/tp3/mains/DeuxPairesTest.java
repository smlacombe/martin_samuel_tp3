package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class DeuxPairesTest extends TestCase {
	public void testUnePaire() {
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));

		assertFalse(new DeuxPaires().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testPasDePaire() {
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.NEUF, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));

		assertFalse(new DeuxPaires().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testUnePaireUnJoker() {
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));

		assertTrue(new DeuxPaires().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testPasDePaireDeuxJokers() {
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.NEUF, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));

		assertTrue(new DeuxPaires().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testDeuxPairesAsRoi() {
		Main main = new Main();
		main.add(new Carte(Denomination.ROI, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.ROI, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));

		assertTrue(new DeuxPaires().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testDeuxPairesRoiValet() {
		Main main = new Main();
		main.add(new Carte(Denomination.ROI, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.VALET, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.ROI, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.VALET, CouleurCarte.PIQUE));

		assertTrue(new DeuxPaires().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
