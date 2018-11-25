import processing.core.PApplet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level {

    ArrayList<String[]> walls = new ArrayList<>();
    PApplet p;

    public Level(PApplet p, String filePath) {
        this.p = p;
        getStringFromTxt(filePath);
    }

    public void getStringFromTxt(String filePath) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

            String line;
            while((line = br.readLine()) != null) {
                walls.add(line.split("#"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display() {

        for (String[] wall : walls) {
            p.rect(Integer.parseInt(wall[0]),Integer.parseInt(wall[1]),Integer.parseInt(wall[2]),Integer.parseInt(wall[3]));
        }
    }
}
