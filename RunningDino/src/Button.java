import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;

public class Button {
    private int x;
    private int y;
    private int width;
    private int height;
    private String string;
    private boolean selected;
    public Button(int x,int y,String str, boolean s){
        this.x=x;
        this.y=y;
        selected=s;
        width = 400;
        height = 50;
        string=str;
    }
    public void select(){
        selected=!selected;
    }
    public void draw(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(x, y, width,height);
        g.setColor(Color.BLACK);
        if(selected)
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        g.drawString(string, x+20, y+40);
    }
}
