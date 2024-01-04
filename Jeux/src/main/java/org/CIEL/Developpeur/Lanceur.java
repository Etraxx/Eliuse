package org.CIEL.Developpeur;

import org.CIEL.Developpeur.coeur.GestionnaireDuMoteur;
import org.CIEL.Developpeur.coeur.GestionnaireDeFenetres;
import org.CIEL.Developpeur.coeur.utilitaires.Constantes;
import org.lwjgl.Version;

public class Lanceur {

    private static GestionnaireDeFenetres fenetres;
    private static GestionnaireDuMoteur moteur;
    private static TestJeu jeu;


    public static void main(String[] args){
        System.out.println(Version.getVersion());
        fenetres = new GestionnaireDeFenetres(Constantes.TITRE, 1080, 720, false);
        System.out.println("Gestionnaire de fenetres défini sur 1080x720 144fps plein écran défini sur false");
        jeu = new TestJeu();
        System.out.println("TestJeu Chargé !");
        moteur = new GestionnaireDuMoteur();
        System.out.println("Chargement du GestionnaireDeMoteur...");
        try{
            moteur.start();
            System.out.println("Le moteur est fermé.");
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("Erreur au démarrage du moteur : " + e.getMessage());
        }
    }

    public static GestionnaireDeFenetres getWindow() {
        return fenetres;
    }

    public static TestJeu getJeu() {
        return jeu;
    }
}
