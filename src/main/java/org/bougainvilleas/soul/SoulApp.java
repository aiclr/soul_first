package org.bougainvilleas.soul;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SoulApp extends Application
{
    public static void main(String[] args)
    {
        System.err.println("2333");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Circle circle=new Circle(40,40,30);
        Group group = new Group(circle);
        Scene scene = new Scene(group, 400, 300);
        primaryStage.setTitle("陈彩灵");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
