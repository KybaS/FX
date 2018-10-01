package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition transition;

    public Shake(Node node){
        transition = new TranslateTransition(Duration.millis(100), node);
        transition.setFromY(0f);
        transition.setFromX(0f);
        transition.setByX(12f);
        transition.setByY(12f);
        transition.setCycleCount(5);
        transition.setAutoReverse(true);
    }

    public void playAnimation(){
        transition.playFromStart();
    }
}
