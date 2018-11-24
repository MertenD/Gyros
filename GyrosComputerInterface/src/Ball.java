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
    private float mass;

    public Ball(PApplet p, PVector size, PVector pos, float mass) {
        this.p = p;
        this.size = size;
        this.pos = pos;
        this.mass = mass;
    }

    public void display() {
        p.ellipse(pos.x,pos.y,size.x,size.y);
    }

    public void update() {

        vel.add(acc);

        if (vel.x > VMAX) vel.x = VMAX;
        if (vel.y > VMAX) vel.y = VMAX;

        applyFriction();

        pos.add(vel);
        acc = new PVector(0,0);
    }

    public void applyForce(PVector force) {
        //acc.add(force.div(force,mass));
        acc.add(force);
    }

    public void applyFriction() {
         vel.mult(FRICTION_MULT);
    }
}
