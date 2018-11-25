import com.sun.scenario.effect.impl.sw.java.JSWBlend_EXCLUSIONPeer;
import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<Ball> balls = new ArrayList<>();
    static PVector forcevector = new PVector(0,0);
    static Webserver server = new Webserver();

    public static void main(String[] args) {
        PApplet.main("Main");
        System.out.println("MAIN CLASS");
        try{
            server.main(new String[]{});
        }catch(Exception e){
            System.out.println("ERROR");
        }

    }

    public void settings() {
        size(900,900);
    }

    public void setup() {
        balls.add(new Ball(this, new PVector(30, 30), new PVector(450,450)));
    }

    public void draw() {

        background(230,230,250);

        for (Ball b : balls) {
            b.update();
            b.display();
            b.applyForce(forcevector);
        }
    }
}
