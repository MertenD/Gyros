import processing.core.PApplet;
import processing.core.PVector;

public class Ball {

    PApplet p;
    PVector pos = new PVector(0,0);

    public Ball(PApplet p) {
        this.p = p;
    }

    public void display() {
        p.ellipse();
    }
}
