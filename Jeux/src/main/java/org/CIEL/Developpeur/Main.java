package org.CIEL.Developpeur;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Début du Chargement...");
        JFrame window = new JFrame(); // Variable pour ne pas avoir à l'écrire à chaque fois
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pour pouvoir la fermer en cliquant sur la croix en haut à gauche
        window.setResizable(false); // Pour pouvoir la redimentionner
        window.setTitle("Game_FPS"); // Pour le titre de la fenêtre

        GamePanel gamePanel = new GamePanel(); // Pour importer le fichier GamePanel.java
        window.add(gamePanel);
        System.out.println("GamePanel Chargé.");

        window.pack();

        window.setLocationRelativeTo(null); // Pour faire apparaître la fenêtre au centre de l'écran
        window.setVisible(true); // Pour qu'on puisse voir la fenêtre

        gamePanel.startGameThread(); // Pour démarrer l'option startGameThread dans GamePanel.java

        System.out.println("Fin du Chargement.");
    }
}