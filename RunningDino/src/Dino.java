public class Dino {
    private int x;
    private int y;
    private double velocity;
    private int pause;

    public Dino(){x=195;y=510;velocity=0;pause=1;}
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void jump(){
        velocity=-13;
    }
    public void update() {
        velocity+=.3;
        y+=(int) velocity;
        if(y>510)
        {
            velocity=0;
            y=510;
        }
    }
    public boolean collision(Obstacle o){
        int x11=x;
        int x12=x+7*15;
        int y11=y-7*15;
        int y12=y-15;
        int x21=o.getX();
        int x22=o.getX()+o.getWidth();
        int y21=o.getY();
        int y22=o.getY()+o.getHeight();
        if( (x11<=x21 && x12>=x21) || (x11<=x22 && x12>=x22) || (x21<=x12 && x22>=x12) || (x21<=x12 && x22>=x12)){
            if((y11<=y21 && y12>=y21) || (y11<=y22 && y12>=y22) || (y21<=y12 && y22>=y12) || (y21<=y12 && y22>=y12))
                return true;
        }
        return false;
    }
    public void pause(){
        pause*=-1;
    }
    public void reset(){
        x=195;y=510;velocity=0;pause=1;
    }

    public int getPause() {
        return pause;
    }
}
