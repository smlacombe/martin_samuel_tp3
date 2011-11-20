package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import java.util.Iterator;
import junit.framework.*;

/**
 * Classe de test pour la classe main.
 * @author Samuel Milette Lacombe
 */
public class MainTest extends TestCase {

	public MainTest(String name) {
		super(name);
	}
	
    protected void setUp() {
       
    }
    
    public static Test suite() {        
        return new TestSuite(MainTest.class);
    }
	
    public void testCompareToDeuxQuintes() {
    	Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareToQuinteQuinteCouleur() {
    	Main mainSuperieure = new Main();
    	mainSuperieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareToQuinteRoyaleQuinteCouleur() {
    	Main mainSuperieure = new Main();
    	mainSuperieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.ROI,   CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.VALET, CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareToQuintupletQuinteRoyale() {
    	Main mainSuperieure = new Main();
    	mainSuperieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.ROI,   CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.VALET, CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.AS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.AS, CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		
		assertTrue(new QuinteRoyale().reconnaitreMain(new ReqAnalyseMain(mainSuperieure)));
		assertTrue(new Quintuplet().reconnaitreMain(new ReqAnalyseMain(mainInferieure)));
		
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareToCarteSuperieurePaire() {
    	Main mainSuperieure = new Main();
    	mainSuperieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DAME,  CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.VALET, CouleurCarte.CARREAU));
    	mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,     CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.VALET,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DIX,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.NEUF, CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareTo3() {
    	Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareTo44() {
    	Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareTo6() {
    	Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testCompareTo8() {
    	Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
					
		assertTrue(mainSuperieure.compareTo(mainInferieure) > 0);
		assertTrue(mainInferieure.compareTo(mainSuperieure) < 0);
    }
    
    public void testSize() {
    	Main main = new Main();
        Carte maCarte = new Carte(Denomination.SEPT, CouleurCarte.COEUR);
        assertEquals(0, main.size());
        main.add(maCarte);
        assertEquals(1, main.size());
        main.remove(maCarte);
        assertEquals(0, main.size());
    }
    
    public void testAdd() {
    	Main main = new Main();
    	
        Carte maCarte1 = new Carte(Denomination.DIX, CouleurCarte.COEUR);
        Carte maCarte2 = new Carte(Denomination.NEUF, CouleurCarte.COEUR);
        Carte maCarte3 = new Carte(Denomination.HUIT, CouleurCarte.COEUR);
        Carte maCarte4 = new Carte(Denomination.SEPT, CouleurCarte.COEUR);
        Carte maCarte5 = new Carte(Denomination.SIX, CouleurCarte.COEUR);
        
        main.add(maCarte1);
        main.add(maCarte2);
        main.add(maCarte3);
        main.add(maCarte4);
        main.add(maCarte5);
        
        Iterator<Carte> monIterator = main.iterator();
        assertEquals(maCarte1, monIterator.next());
        assertEquals(maCarte2, monIterator.next());
        assertEquals(maCarte3, monIterator.next());
        assertEquals(maCarte4, monIterator.next());
        assertEquals(maCarte5, monIterator.next());
    }
    
    public void testRemove() {
    	Main main = new Main();
    	
        Carte maCarte1 = new Carte(Denomination.DIX, CouleurCarte.COEUR);
        Carte maCarte2 = new Carte(Denomination.NEUF, CouleurCarte.COEUR);
        Carte maCarte3 = new Carte(Denomination.HUIT, CouleurCarte.COEUR);
        Carte maCarte4 = new Carte(Denomination.SEPT, CouleurCarte.COEUR);
        Carte maCarte5 = new Carte(Denomination.SIX, CouleurCarte.COEUR);
        
        main.add(maCarte1);
        main.add(maCarte2);
        main.add(maCarte3);
        main.add(maCarte4);
        main.add(maCarte5);
        
        assertEquals(main.size(), 5);
        main.remove(maCarte1);
        assertEquals(main.size(), 4);
    }
    
    public void testFirst() {
    	Main main = new Main();
    	
    	Carte maCarte1 = new Carte(Denomination.DIX, CouleurCarte.COEUR);
        Carte maCarte2 = new Carte(Denomination.NEUF, CouleurCarte.COEUR);
        Carte maCarte3 = new Carte(Denomination.HUIT, CouleurCarte.COEUR);
        Carte maCarte4 = new Carte(Denomination.SEPT, CouleurCarte.COEUR);
        Carte maCarte5 = new Carte(Denomination.SIX, CouleurCarte.COEUR);
        
        //Insertion en ordre différent, devrait rien changer
        main.add(maCarte5);
        main.add(maCarte2);
        main.add(maCarte4);
        main.add(maCarte3);
        main.add(maCarte1);
        
        assertEquals(maCarte1, main.first());
    }
    
    public void testEstValide() {
    	Main main = new Main();
    	assertFalse(main.estValide());
    	
    	main.add(new Carte(Denomination.SIX, CouleurCarte.COEUR));
    	assertTrue(main.estValide());
    }
    
    public void testEquals() {
    	Main main1 = new Main();
    	Main main2 = new Main();
    	
    	Carte maCarte1 = new Carte(Denomination.DIX, CouleurCarte.COEUR);
        Carte maCarte2 = new Carte(Denomination.NEUF, CouleurCarte.COEUR);
        Carte maCarte3 = new Carte(Denomination.HUIT, CouleurCarte.COEUR);
        Carte maCarte4 = new Carte(Denomination.SEPT, CouleurCarte.COEUR);
        Carte maCarte5 = new Carte(Denomination.SIX, CouleurCarte.COEUR);
        
        main1.add(maCarte1);
        main1.add(maCarte2);
        main1.add(maCarte3);
        main1.add(maCarte4);
        main1.add(maCarte5);
        
        //Insertion en ordre différent, devrait rien changer
        main2.add(maCarte5);
        main2.add(maCarte2);
        main2.add(maCarte3);
        main2.add(maCarte4);
        main2.add(maCarte1);
        
        assertTrue(main1.equals(main2));
    }

}
