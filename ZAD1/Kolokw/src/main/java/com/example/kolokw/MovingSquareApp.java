package com.example.kolokw;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingSquareApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Rectangle square = new Rectangle(100, 100, Color.PURPLE);
        square.setX(0);
        square.setY(100);
        root.getChildren().add(square);

        // Ruch w kształcie litery S
        PathTransition pathTransition = new PathTransition();
        javafx.scene.shape.Path path = new javafx.scene.shape.Path();
        path.getElements().add(new javafx.scene.shape.MoveTo(25, 125));
        path.getElements().add(new javafx.scene.shape.CubicCurveTo(150, 0, 250, 250, 375, 125));

        pathTransition.setDuration(Duration.seconds(4));
        pathTransition.setPath(path);
        pathTransition.setNode(square);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);

        // Obracanie wokół osi
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), square);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        javafx.scene.control.Button startButton = new javafx.scene.control.Button("Start");
        startButton.setOnAction(e -> {
            pathTransition.play();
            rotateTransition.play();
        });

        startButton.setLayoutY(300);
        root.getChildren().add(startButton);

        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setTitle("Kwadrat na torze S");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
