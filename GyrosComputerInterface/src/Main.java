import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<Ball> balls = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(900,900);
    }

    public void setup() {
        balls.add(new Ball(this, new PVector(30, 30), new PVector(450,450), 10));
    }

    public void draw() {

        background(230,230,250);

        for (Ball b : balls) {
            b.update();
            b.display();
        }
    }

    public void mousePressed() {
        balls.get(0).applyForce(new PVector(5,0));
    }
}
