package org.CIEL.Developpeur;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // Paramètres d'écran
    final int originalTitleSize = 16; // Taille des Pixel **
    final int scale = 3; // Multiplier les piexel

    final int tileSize = originalTitleSize * scale;
    final int maxScreenCol = 25; // Pour calculer la largeur de la fenêtre
    final int maxScreenRow = 15; // Pour calculer la longueur de la fenêtre
    final int screenWidth = tileSize * maxScreenCol; // 1200 Pixels
    final int screenHeight = tileSize * maxScreenRow; // 720 Pixels

    // FPS
    int FPS = 144;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread; // Variable pour ne pas l'utiliser à chaque fois

// Position par défaut du joueur
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Taille de la fenêtre
        this.setBackground(Color.BLACK); // Couleur de l'arrière plan de la fenêtre (merci de ne pas mettre une couleur trop vive comme le blanc car si on programme de nuit ça peut faire très mal)
        this.setDoubleBuffered(true); // 2D **
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){ // Pour quand le jeu ce lance
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // 0,0069444 secondes
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){
            // Première partie mettre à jour les information comme la positon des personnage
            // Sleep Methode
            update();
            // Deuxième partie Dessiner l'écran avec l'information mis à jour
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){ remainingTime = 0; }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(){
        if(keyHandler.upPressed == true){
            playerY -= playerSpeed;
            playerY = playerY - playerSpeed;
        }else if(keyHandler.downPressed == true){
            playerY += playerSpeed;
        }else if(keyHandler.leftPressed == true){
            playerX -= playerSpeed;
        }else if(keyHandler.rightPressed == true){
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // 2D **
        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
