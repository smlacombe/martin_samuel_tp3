package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class CarreTest extends TestCase {
	public void testMainVide()
	{
		Main main = new Main();
		
		assertFalse(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreAs()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.AS,   CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.PIQUE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreDeux()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreTrois()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.PIQUE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreIncomplet()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.QUATRE,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.PIQUE));
		
		assertFalse(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreIncompletAvecUnJoker()
	{
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.PIQUE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreIncompletAvecDeuxJokers()
	{
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.PIQUE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreIncompletAvecTroisJokers()
	{
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.PIQUE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testCarreIncompletAvecQuatreJokers()
	{
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		
		assertTrue(new Carre().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
