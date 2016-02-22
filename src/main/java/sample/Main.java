package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(new Scene(root));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        primaryStage.setHeight(dim.getHeight());
        primaryStage.setX(dim.getWidth() - 20);
        primaryStage.setY(0);
        primaryStage.setWidth(20);
        Controller controller=fxmlLoader.getController();
        controller.setAppStage(primaryStage);
        controller.onStart();


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
