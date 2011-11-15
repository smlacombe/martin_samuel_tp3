package ets.log120.tp3.mains;

public class AnalyseurRangFactory {
    public static AbstractAnalyseurRang makeAnalyseurRang() {
	AbstractAnalyseurRang analyseur = null;
	AbstractAnalyseurRang debutAnalyseur = null;
	
	debutAnalyseur = analyseur = ajouterAnalyseur(analyseur, new Brelan());
	analyseur = ajouterAnalyseur(analyseur, new DeuxPaires());
	analyseur = ajouterAnalyseur(analyseur, new Paire());
	analyseur = ajouterAnalyseur(analyseur, new CarteSuperieure());
	
	return debutAnalyseur;
    }
    
    private static AbstractAnalyseurRang ajouterAnalyseur(AbstractAnalyseurRang analyseur, AbstractAnalyseurRang maillon) {
	if (analyseur != null)
	    analyseur.setSuivant(maillon);
	analyseur = maillon;
	return analyseur;
    }
}
