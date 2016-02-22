package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.security.auth.callback.CallbackHandler;


public class Controller {

    @FXML
    private TreeView<Text> treeView;
    private Stage appStage;

    @FXML
    public Label labelResult;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox3;


    public Stage getAppStage() {
        return appStage;
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }


    public void onMouseEntered(Event event) {
        Thread changeStage=new ChangStageThread(appStage,true);
        changeStage.start();


    }

    public void onMouseExited(Event event) {
        Thread changeStage=new ChangStageThread(appStage,false);
        changeStage.start();
    }

    public void onClickCheckBox(ActionEvent actionEvent) {
        int result=0;
        if (checkBox1.isSelected())result+=parseString(checkBox1.getText());
        if (checkBox2.isSelected())result+=parseString(checkBox2.getText());
        if (checkBox3.isSelected())result+=parseString(checkBox3.getText());
        labelResult.setText(result + "");
    }

    private int parseString(String str){
        return Integer.parseInt(str);
    }

    public void onStart() {
        TreeItem<Text> rootNoode = new TreeItem<Text>(new MyText("I"));

        TreeItem<Text> treeItem=new TreeItem<Text>(new MyText("Father"));
        treeItem.getChildren().addAll(new TreeItem<Text>(new MyText("GrandFather")),new TreeItem<>(new MyText("GrandMother")));

        TreeItem<Text> treeItem1=new TreeItem<Text>(new MyText("Mother"));
        treeItem1.getChildren().addAll(new TreeItem<Text>(new MyText("GrandFather")),new TreeItem<>(new MyText("GrandMother")));

        rootNoode.getChildren().addAll(treeItem,treeItem1);
        treeView.setRoot(rootNoode);


    }

    public void onMouseClikced(Event event) {
        appStage.close();
    }
}
