import java.awt.*;
import java.util.Random;

public class Pterodactyl extends Obstacle{
    public Pterodactyl(int u) {
        super(u);
        width=14*u;
        height=-3*u;

    }

    @Override
    public void appear(){
        y=new Random().nextInt(200)+300;
        x=1300;
        velocity=-10;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(new Color(241, 226, 23));
        g.fillRect(x, y-UNIT_SIZE, UNIT_SIZE,UNIT_SIZE);
        g.fillRect(x+UNIT_SIZE, y-UNIT_SIZE*2, UNIT_SIZE*5,UNIT_SIZE);
        g.fillRect(x+UNIT_SIZE*8, y-UNIT_SIZE*2, UNIT_SIZE*5,UNIT_SIZE);
        g.fillRect(x+UNIT_SIZE*13, y-UNIT_SIZE, UNIT_SIZE,UNIT_SIZE);
        g.fillRect(x+UNIT_SIZE*5, y-UNIT_SIZE, UNIT_SIZE*4,UNIT_SIZE);
        g.fillRect(x+UNIT_SIZE*6, y, UNIT_SIZE*2,UNIT_SIZE);
    }
}
