package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class CouleurTest extends TestCase {
	public void testMainToutesPique()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.PIQUE));
		
		assertTrue(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testMainToutesCarreau()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
		
		assertTrue(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainToutesCoeur()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.COEUR));
		
		assertTrue(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainToutesTrefle()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		
		assertTrue(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainUneCarteDifferanteCouleur()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
		
		assertFalse(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainDeuxCarteDifferanteCouleur()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
		
		assertFalse(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainTroisCouleurs()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
		
		assertFalse(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainQuatreCouleurs()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
		
		assertFalse(new Couleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
