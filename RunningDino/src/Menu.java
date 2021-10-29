import java.awt.*;

public class Menu {
    private Button[] b = new Button[3];
    private int selected;
    public Menu(){
        b[0] = new Button(400,100,"Play", true);
        b[1] = new Button(400,250,"Scoreboard", false);
        b[2] = new Button(400,400,"Exit", false);
        selected = 0;
    }
    public void draw(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(300,50,600,450);
        b[0].draw(g);
        b[1].draw(g);
        b[2].draw(g);
    }
    public void goDown(){
        b[selected].select();
        selected+=1;
        selected=selected%3;
        b[selected].select();
    }
    public void goUp(){
        b[selected].select();
        selected-=1;
        if(selected==-1)
            selected=2;
        b[selected].select();
    }

    public int getSelected() {
        return selected;
    }
}
