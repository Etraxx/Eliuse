package org.CIEL.Developpeur;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // Paramètres d'écran
    final int originalTitleSize = 16; // Taille des Pixel **
    final int scale = 3; // Multiplier les piexel

    final int tileSize = originalTitleSize * scale;
    final int maxScreenCol = 16; // Pour calculer la largeur de la fenêtre
    final int maxScreenRow = 12; // Pour calculer la longueur de la fenêtre
    final int screenWidth = tileSize * maxScreenCol; // 768 Pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 Pixels

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Taille de la fenêtre
        this.setBackground(Color.BLACK); // Couleur de l'arrière plan de la fenêtre (merci de ne pas mettre une couleur trop vive comme le blanc car si on programme de nuit ça peut faire très mal)
        this.setDoubleBuffered(true); // 2D **
    }
}
