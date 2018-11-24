import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(900,900);
    }

    public void setup() {
        Ball ball = new Ball(this);
    }

    public void draw() {

    }
}
