package sample;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by Олег on 22.02.2016.
 */
public class MyText extends Text{

    public MyText(String text) {
        super(text);
        super.setFont(new Font("festus",14));
    }
}
