package org.CIEL.Developpeur.coeur.utilitaires;

import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public class Utilitaires {

    public static FloatBuffer stockerLesDonneesDansUnTamponFlottant(float[] donnees){
        FloatBuffer buffer = MemoryUtil.memAllocFloat(donnees.length);
        buffer.put(donnees).flip();
        return buffer;
    }
}
