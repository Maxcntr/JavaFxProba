package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;//нужен правильный импорт

public class Shake {

    private TranslateTransition tt;
    //нужен правильный импорт
    public Shake(Node node) {
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setFromY(0f);
        tt.setByY(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);//возврат в изночальное положение
        //после потряхивоней
    }

    public void playAnim() {
        tt.playFromStart();
    }
}
