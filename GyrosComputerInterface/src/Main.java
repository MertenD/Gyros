import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {

    Ball ball;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(900,900);
    }

    public void setup() {
        ball = new Ball(this);
        ball.display();
    }

    public void draw() {

        background(230,230,250);

        ball.update();
        ball.display();
    }
}
