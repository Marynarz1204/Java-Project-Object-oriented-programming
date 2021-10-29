import java.awt.*;

public abstract class Obstacle {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int velocity;
    protected int UNIT_SIZE;
    public Obstacle(int u){UNIT_SIZE=u;}
    abstract void appear();
    abstract void draw(Graphics g);
    public void update(){
        x+=velocity;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
