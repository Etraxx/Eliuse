package org.CIEL.Developpeur.coeur;

import org.CIEL.Developpeur.coeur.entite.Modele;
import org.CIEL.Developpeur.coeur.utilitaires.Utilitaires;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class ChargeurObjet {

    private List<Integer> vaos = new ArrayList<>();
    private List<Integer> vbos = new ArrayList<>();

    public Modele chargerModele(float[] sommets){

    }

    private int creeVAO(){
        int id = GL30.glGenVertexArrays();
        vaos.add(id);
        GL30.glBindVertexArray(id);
        return id;
    }

    private void stockerLesDonneesDansLaListeAttributs(int nombreAttributs, int nombreDeSommets, float[] donnees){
        int vbo = GL15.glGenBuffers();
        vbos.add(vbo);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        FloatBuffer buffer = Utilitaires.stockerLesDonneesDansUnTamponFlottant(donnees);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(nombreAttributs, nombreDeSommets, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    private void delier(){
        GL30.glBindVertexArray(0);
    }

    private void nettoyer(){
        for(int vao : vaos){
            GL30.glDeleteVertexArrays(vao);
        }
        for(int vbo : vbos){
            GL30.glDeleteBuffers(vbo);
        }
    }
}
