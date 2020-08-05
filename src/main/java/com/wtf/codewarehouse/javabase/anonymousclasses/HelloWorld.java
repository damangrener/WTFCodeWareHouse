package com.wtf.codewarehouse.javabase.anonymousclasses;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author wangtengfei
 * @since 2020/8/3 15:01
 */
public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage){
        Button btn=new Button();
        btn.setText("Hello world");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("!!!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1300, 1250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
