import processing.core.PApplet;
import processing.core.PVector;

public class Ball  {

    private PApplet p;

    private PVector size;
    public PVector pos;
    private PVector vel = new PVector(0,0);
    private PVector acc = new PVector(0,0);

    private final float VMAX = 5;
    private final float FRICTION_MULT = 0.95f;

    public Ball(PApplet p, PVector size, PVector pos) {
        this.p = p;
        this.size = size;
        this.pos = pos;
    }

    public void display() {
        p.ellipse(pos.x,pos.y,size.x,size.y);
    }

    public void update() {

        vel.add(acc);

        if (vel.x > VMAX) vel.x = VMAX;
        if (vel.y > VMAX) vel.y = VMAX;
        if (vel.x < -VMAX) vel.x = -VMAX;
        if (vel.y < -VMAX) vel.y = -VMAX;

        applyFriction();

        pos.add(vel);
        acc = new PVector(0,0);

        checkEdges();
    }

    public void applyForce(PVector force) {
        acc.add(force);
    }

    public void applyFriction() {
         vel.mult(FRICTION_MULT);
    }

    public void checkEdges() {

        if (pos.x < 0+size.x/2) {
            pos.x = size.x/2;
        }
        if (pos.x > p.width-size.x/2) {
            pos.x = p.width-size.x/2;
        }
        if (pos.y > p.height-size.y/2) {
            pos.y = p.height-size.y/2;
        }
        if (pos.y < 0+size.y/2) {
            pos.y = size.y/2;
        }
    }

    private void createNewBall() {
         //TODO Hier soll ein neues Ball Objekt in der Main Klasse erzeugt werden
    }
}
