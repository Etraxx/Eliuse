package org.CIEL.TEST;

import org.CIEL.TEST.core.EngineManager;
import org.CIEL.TEST.core.WindowManager;
import org.CIEL.TEST.core.utils.Constants;
import org.lwjgl.Version;

public class Launcher {

    private static WindowManager window;
    private static EngineManager engine;


    public static void main(String[] args){
        window = new WindowManager(Constants.TITLE, 1920, 1080, false);
        engine = new EngineManager();
        try{
            engine.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static WindowManager getWindow() {
        return window;
    }
    
}
