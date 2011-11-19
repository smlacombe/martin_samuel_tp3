package ets.log120.tp3.mains;
import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerDeuxPairesTest extends TestCase {

		public void testPaireAsRoiSuperieureAsDame()
		{
			Main mainSuperieure = new Main();
			mainSuperieure.add(new Carte(Denomination.AS, CouleurCarte.CARREAU));
			mainSuperieure.add(new Carte(Denomination.AS, CouleurCarte.PIQUE));
			mainSuperieure.add(new Carte(Denomination.ROI,  CouleurCarte.COEUR));
			mainSuperieure.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));
			mainSuperieure.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
			
			Main mainInferieure = new Main();
			mainInferieure.add(new Carte(Denomination.AS,  CouleurCarte.CARREAU));
			mainInferieure.add(new Carte(Denomination.AS,  CouleurCarte.COEUR));
			mainInferieure.add(new Carte(Denomination.DAME,   CouleurCarte.TREFLE));
			mainInferieure.add(new Carte(Denomination.DAME,  CouleurCarte.PIQUE));
			mainInferieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
			
			ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
			ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
			
			assertTrue(new DeuxPaires().reconnaitreMain(requeteMainSuperieure));
			assertTrue(new DeuxPaires().reconnaitreMain(requeteMainInferieure));
			
			RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
			RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
			
			assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
			assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
		}
		
		public void testPairesMemeDeuxPaireDifferentKicker()
		{
			Main mainSuperieure = new Main();
			mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
			mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
			mainSuperieure.add(new Carte(Denomination.CINQ,  CouleurCarte.COEUR));
			mainSuperieure.add(new Carte(Denomination.CINQ,  CouleurCarte.PIQUE));
			mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
			
			Main mainInferieure = new Main();
			mainInferieure.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
			mainInferieure.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
			mainInferieure.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
			mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
			mainInferieure.add(new Carte(Denomination.HUIT,  CouleurCarte.PIQUE));
			
			ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
			ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
			
			assertTrue(new DeuxPaires().reconnaitreMain(requeteMainSuperieure));
			assertTrue(new DeuxPaires().reconnaitreMain(requeteMainInferieure));
			
			RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
			RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
			
			assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
			assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
		}
		
		public void testMemePaireMemeKicker()
		{
			Main main1 = new Main();
			main1.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
			main1.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
			main1.add(new Carte(Denomination.QUATRE,  CouleurCarte.COEUR));
			main1.add(new Carte(Denomination.QUATRE,  CouleurCarte.PIQUE));
			main1.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
			
			Main main2 = new Main();
			main2.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
			main2.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
			main2.add(new Carte(Denomination.QUATRE,  CouleurCarte.TREFLE));
			main2.add(new Carte(Denomination.DIX, CouleurCarte.CARREAU));
			main2.add(new Carte(Denomination.QUATRE,   CouleurCarte.PIQUE));
			
			ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
			ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
			
			assertTrue(new Paire().reconnaitreMain(requeteMain1));
			assertTrue(new Paire().reconnaitreMain(requeteMain2));
			
			RangPoker rangMain1 = requeteMain1.getRangReconnu();
			RangPoker rangMain2 = requeteMain2.getRangReconnu();
			
			assertTrue(rangMain1.compareTo(rangMain2) == 0);
			assertTrue(rangMain2.compareTo(rangMain1) == 0);
		}

}
