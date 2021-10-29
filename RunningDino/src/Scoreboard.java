import java.awt.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class Scoreboard {
    private File file = new File("scores.dat");
    private int first;
    private int second;
    private int third;

    Scoreboard() {
        try {
            if(file.length()==0)
            {
                first=0;
                second=0;
                third=0;
            }
            else
            {
                Scanner input = new Scanner(file);
                first = input.nextInt();
                second = input.nextInt();
                third = input.nextInt();
                input.close();
            }
        } catch (IOException ex) {
            System.err.println("ERROR");
        }
    }

    public void save() {
        try {
            PrintWriter output = new PrintWriter(file);
            output.println(first);
            output.println(second);
            output.println(third);
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(300,50,600,525);
        g.setColor(Color.black);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        g.drawString("First:"+first, 350, 150);
        g.drawString("Second:"+second, 350, 300);
        g.drawString("Third:"+third, 350, 450);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("Hit Esc to go back",400,550);
    }
    public void newScore(int x){
        if(x>first){
            third=second;
            second=first;
            first=x;
        }
        else if(x>second){
            third=second;
            second=x;
        }
        else if(x>third){
            third=x;
        }
    }
}