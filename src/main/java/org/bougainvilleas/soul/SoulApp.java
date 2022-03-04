package org.bougainvilleas.soul;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SoulApp extends Application
{

    public static int add(int x, int y)
    {
        return x + y;
    }

    public static void main(String[] args)
    {
        int result = add(5, 6);
        System.err.println("x+y= " + result);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Circle circle = new Circle(40, 40, 30);
        Group group = new Group(circle);
        Scene scene = new Scene(group, 400, 300);
        primaryStage.setTitle("嘿嘿");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    public static void main(String[] args)
//    {
//        Application.launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception
//    {
//        primaryStage.setTitle("sos");
//        primaryStage.show();
//    }
}