import java.awt.*;

public class Fence extends Obstacle{
    public Fence(int u) {
        super(u);
        width=6*u;
        height=-5*u;

    }

    @Override
    public void appear(){
        y=510;
        x=1300;
        velocity=-10;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(new Color(140,100,25));
        g.fillRect(x, y-UNIT_SIZE*4, UNIT_SIZE,UNIT_SIZE*5);
        g.fillRect(x+UNIT_SIZE*5, y-UNIT_SIZE*4, UNIT_SIZE,UNIT_SIZE*5);
        g.fillRect(x+UNIT_SIZE, y-UNIT_SIZE*1, UNIT_SIZE*4,UNIT_SIZE);
        g.fillRect(x+UNIT_SIZE, y-UNIT_SIZE*3, UNIT_SIZE*4,UNIT_SIZE);
    }
}
