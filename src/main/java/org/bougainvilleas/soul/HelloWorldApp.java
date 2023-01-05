package org.bougainvilleas.soul;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class HelloWorldApp extends GameApplication
{

    @Override
    protected void initSettings(GameSettings settings)
    {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Basic Game App");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
