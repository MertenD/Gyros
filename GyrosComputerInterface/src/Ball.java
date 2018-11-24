import processing.core.PApplet;
import processing.core.PVector;

public class Ball {

    PApplet p;
    PVector pos = new PVector(450,450);
    PVector vel = new PVector(0,0);
    PVector acc = new PVector(0,0);

    private float vMax = 5;

    public Ball(PApplet p) {
        this.p = p;
    }

    public void display() {
        p.ellipse(pos.x,pos.y,20,20);
    }

    public void update() {
        vel.add(acc);

        if (vel.x > vMax) vel.x = vMax;
        if (vel.y > vMax) vel.y = vMax;

        pos.add(vel);
        acc = new PVector(0,0);
    }

    public void applyForce(PVector force) {
        acc.add(force);
    }
}
