package sample;

import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Олег on 22.02.2016.
 */
public class ChangStageThread extends Thread {
    private Stage appStage;
    private boolean flagReSize;

    public ChangStageThread(Stage appStage, boolean flagReSize) {
        this.appStage = appStage;
        this.flagReSize = flagReSize;
    }

    @Override
    public void run() {

        if (flagReSize) expansionOfWindow();
        else foldingOfWindow();
    }

    private void foldingOfWindow(){
        if (appStage.getWidth()<1) return;
        for(int i=0; i<205;i++){
            chang(-1);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void expansionOfWindow(){
        if (appStage.getWidth()>200) return;
        for(int i=0; i<205;i++){
            chang(1);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void chang(int index){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                appStage.setWidth(appStage.getWidth() + index);
                appStage.setX(appStage.getX() - index);
            }
        });

    }
}
