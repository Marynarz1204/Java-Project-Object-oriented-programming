import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 15;
    static final int DELAY = 10;
    boolean running = false;
    boolean gOver = false;
    boolean movingObstacle = false;
    int whichObstacle = -1;
    Timer timer;
    Random random;
    Dino dino = new Dino();
    Pterodactyl p1 = new Pterodactyl(UNIT_SIZE);
    Pterodactyl p2 = new Pterodactyl(UNIT_SIZE);
    Fence f1 = new Fence(UNIT_SIZE);
    Fence f2 = new Fence(UNIT_SIZE);
    Cactus c1 = new Cactus(UNIT_SIZE);
    Cactus c2 = new Cactus(UNIT_SIZE);
    Score s = new Score();
    Menu menu = new Menu();
    Scoreboard scoreboard = new Scoreboard();
    boolean displayScoreboard = false;
    boolean displayMenu = true;


    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(3, 16, 154));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame() {
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
        p1.appear();
        p2.appear();
        f1.appear();
        f2.appear();
        c1.appear();
        c2.appear();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void drawDino(Dino dino, Graphics g){
        g.setColor(new Color(14, 201, 3));
        g.fillRect(dino.getX()+UNIT_SIZE, dino.getY()-UNIT_SIZE, UNIT_SIZE,UNIT_SIZE*2);
        g.fillRect(dino.getX()+3*UNIT_SIZE, dino.getY()-UNIT_SIZE, UNIT_SIZE,UNIT_SIZE*2);
        g.fillRect(dino.getX(), dino.getY()-2*UNIT_SIZE, UNIT_SIZE*5,UNIT_SIZE);
        g.fillRect(dino.getX()-UNIT_SIZE, dino.getY()-3*UNIT_SIZE, UNIT_SIZE*6,UNIT_SIZE);
        g.fillRect(dino.getX()-UNIT_SIZE, dino.getY()-4*UNIT_SIZE, UNIT_SIZE,UNIT_SIZE);
        g.fillRect(dino.getX()+2*UNIT_SIZE, dino.getY()-4*UNIT_SIZE, UNIT_SIZE*4,UNIT_SIZE);
        g.fillRect(dino.getX()+4*UNIT_SIZE, dino.getY()-7*UNIT_SIZE, UNIT_SIZE*2,UNIT_SIZE*3);
        g.fillRect(dino.getX()+6*UNIT_SIZE, dino.getY()-7*UNIT_SIZE, UNIT_SIZE,UNIT_SIZE);
        g.fillRect(dino.getX()+6*UNIT_SIZE, dino.getY()-5*UNIT_SIZE, UNIT_SIZE,UNIT_SIZE);
    }
    public void drawObstacle(Obstacle o, Graphics g){
        o.draw(g);
    }
    public void draw(Graphics g){
        g.setColor(new Color(205, 181, 34));
        g.fillRect(0,511,1200,100);
        drawDino(dino,g);
        if(gOver)
            gameOver(g);
        else if(dino.getPause()==-1) {
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 75));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Pause", (SCREEN_WIDTH - metrics.stringWidth("Pause")) / 2, SCREEN_HEIGHT / 2);
        }
        if(!gOver){
            if(s.getColor())
                g.setColor(Color.black);
            else
                g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 60));
            g.drawString("Score:"+s.get(), 100, 100);
        }
        drawObstacle(p1,g);
        drawObstacle(p2,g);
        drawObstacle(f1,g);
        drawObstacle(f2,g);
        drawObstacle(c1,g);
        drawObstacle(c2,g);
        if(displayScoreboard)
            scoreboard.draw(g);
        if(displayMenu)
            menu.draw(g);
    }
    public void newObstacle(){
        switch (whichObstacle) {
            case 0:
                p1.appear();
                break;
            case 1:
                p2.appear();
                break;
            case 2:
                f1.appear();
                break;
            case 3:
                f2.appear();
                break;
            case 4:
                c1.appear();
                break;
            case 5:
                c2.appear();
                break;
        }

    }
    public void moveObstacle(){
        switch (whichObstacle){
            case 0:
                p1.update();
                if(p1.getX()<-200)
                {
                    movingObstacle=false;
                }
                break;
            case 1:
                p2.update();
                if(p2.getX()<-200)
                {
                    movingObstacle=false;
                }
                break;
            case 2:
                f1.update();
                if(f1.getX()<-200)
                {
                    movingObstacle=false;
                }
                break;
            case 3:
                f2.update();
                if(f2.getX()<-200)
                {
                    movingObstacle=false;
                }
                break;
            case 4:
                c1.update();
                if(c1.getX()<-200)
                {
                    movingObstacle=false;
                }
                break;
            case 5:
                c2.update();
                if(c2.getX()<-200)
                {
                    movingObstacle=false;
                }
                break;
        }
    }
    public void move() {
        if(!gOver)
        {
            dino.update();
            if(!movingObstacle){
                whichObstacle = new Random().nextInt(6);
                newObstacle();
                movingObstacle = true;
            }
            else{
                moveObstacle();
            }
            s.update();
        }


    }

    public void restart(){
        dino.reset();
        p1.appear();
        p2.appear();
        f1.appear();
        f2.appear();
        c1.appear();
        c2.appear();
        s.reset();
    }

    public void gameOver(Graphics g){
        scoreboard.newScore(s.get());
        s.reset();
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game over", (SCREEN_WIDTH-metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
    }
    public boolean checkCollision(){
        if(dino.collision(p1))
            return true;
        else if(dino.collision(p2))
            return true;
        else if(dino.collision(f1))
            return true;
        else if(dino.collision(f2))
            return true;
        else if(dino.collision(c1))
            return true;
        else return dino.collision(c2);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            if(dino.getPause()==1 && !displayMenu && !displayScoreboard){
                move();
                gOver=checkCollision();
            }
        }
        repaint();

    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    if(displayMenu)
                        menu.goUp();
                    if(dino.getY()==510&&!displayScoreboard&&!displayMenu)dino.jump();
                    break;
                case KeyEvent.VK_P:
                    dino.pause();
                    break;
                case KeyEvent.VK_R:
                    restart();
                    break;
                case KeyEvent.VK_DOWN:
                    if(displayMenu)
                        menu.goDown();
                    break;
                case KeyEvent.VK_ENTER:
                    if(displayMenu){
                        switch (menu.getSelected()){
                            case 0:
                                displayMenu=false;
                                displayScoreboard=false;
                                break;
                            case 1:
                                displayMenu=false;
                                displayScoreboard=true;
                                break;
                            case 2:
                                scoreboard.save();
                                System.exit(0);
                                break;
                        }
                    }
                    else if(displayScoreboard){
                        displayScoreboard=false;
                        displayMenu=true;
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    if(!displayMenu){
                        displayMenu=true;
                        if(gOver){
                            restart();
                            gOver=false;
                        }
                    }

            }

        }

    }

}
