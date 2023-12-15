package org.CIEL.TEST;

import org.CIEL.TEST.core.EngineManager;
import org.CIEL.TEST.core.WindowManager;
import org.CIEL.TEST.core.utils.Constants;
// import org.lwjgl.Version;

public class Launcher {

    private static WindowManager window;
    private static EngineManager engine;


    public static void main(String[] args){
        window = new WindowManager(Constants.TITLE, 1920, 1080, false);
        System.out.println("WindowManager set 1920x1080 60fps fullscreen set false");
        engine = new EngineManager();
        System.out.println("EngineManager loading...");
        try{
            engine.start();
            System.out.println("Engine Starting...");
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("Error while starting the engine : " + e.getMessage());
        }
    }

    public static WindowManager getWindow() {
        return window;
    }
}
