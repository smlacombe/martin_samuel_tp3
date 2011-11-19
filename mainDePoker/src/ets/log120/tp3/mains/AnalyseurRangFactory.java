package ets.log120.tp3.mains;

public class AnalyseurRangFactory {
    public static AbstractAnalyseurRang makeAnalyseurRang() {
	AbstractAnalyseurRang analyseur = null;
	AbstractAnalyseurRang debutAnalyseur = null;
	
	debutAnalyseur = analyseur = new QuinteRoyale();
	analyseur = ajouterAnalyseur(analyseur, new Quintuplet());
	analyseur = ajouterAnalyseur(analyseur, new QuinteCouleur());
	analyseur = ajouterAnalyseur(analyseur, new Carre());
	analyseur = ajouterAnalyseur(analyseur, new MainPleine());
	analyseur = ajouterAnalyseur(analyseur, new Couleur());
	analyseur = ajouterAnalyseur(analyseur, new Quinte());
	analyseur = ajouterAnalyseur(analyseur, new Brelan());
	analyseur = ajouterAnalyseur(analyseur, new DeuxPaires());
	analyseur = ajouterAnalyseur(analyseur, new Paire());
	analyseur = ajouterAnalyseur(analyseur, new CarteSuperieure());
	
	return debutAnalyseur;
    }
    
    private static AbstractAnalyseurRang ajouterAnalyseur(AbstractAnalyseurRang analyseur, AbstractAnalyseurRang maillon) {
		analyseur.setSuivant(maillon);
		analyseur = maillon;
		return analyseur;
    }
}
