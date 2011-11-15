package ets.log120.tp3.mains;

import junit.framework.TestCase;

public class AnalyseurRangFactoryTest extends TestCase {
	public void testMakeAnalyseurRang() {
		AbstractAnalyseurRang analyseur = AnalyseurRangFactory.makeAnalyseurRang();
		/*
		assertTrue(analyseur instanceof QuinteRoyale);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof Quintuplet);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof QuinteCouleur);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof Carre);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof MainPleine);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof Couleur);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof Quinte);

		analyseur = analyseur.getSuivant();
		*/
		assertTrue(analyseur instanceof Brelan);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof DeuxPaires);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof Paire);

		analyseur = analyseur.getSuivant();
		assertTrue(analyseur instanceof CarteSuperieure);
	}
}
