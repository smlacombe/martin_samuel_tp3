package ets.log120.tp3.mains;

import java.util.LinkedList;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class AnalyseurUtilTest extends TestCase {
	
	public void testTrouverMeilleureDenomination() {
		LinkedList<Denomination> quinte = new LinkedList<Denomination>();
		
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.CINQ,CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS,CouleurCarte.CARREAU));
		
		quinte.add(Denomination.JOKER);
		quinte.add(Denomination.JOKER);
		quinte.add(Denomination.JOKER);
		quinte.add(Denomination.CINQ);
		quinte.add(Denomination.TROIS);
		
		assertEquals(Denomination.SEPT, AnalyseurUtil.trouverMeilleureDenominationQuinte(quinte,main));
	}
}
