import java.awt.*;

public class Cactus extends Obstacle{
    public Cactus(int u) {
        super(u);
        width=6*u;
        height=-8*u;
    }

    @Override
    public void appear(){
        y=525;
        x=1300;
        velocity=-10;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(new Color(37, 140,25));
        g.fillRect(x+UNIT_SIZE*2, y-UNIT_SIZE*8, UNIT_SIZE*2,UNIT_SIZE*8);
        g.fillRect(x, y-UNIT_SIZE*5, UNIT_SIZE*2,UNIT_SIZE);
        g.fillRect(x, y-UNIT_SIZE*7, UNIT_SIZE,UNIT_SIZE*2);
        g.fillRect(x+UNIT_SIZE*5, y-UNIT_SIZE*7, UNIT_SIZE,UNIT_SIZE*2);
        g.fillRect(x+UNIT_SIZE*4, y-UNIT_SIZE*6, UNIT_SIZE,UNIT_SIZE);
    }
}
