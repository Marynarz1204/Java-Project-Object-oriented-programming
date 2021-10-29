public class Score {
    private int s;
    private int mile;
    private boolean color;

    Score(){s=0;mile=0;}
    public void update(){
        s+=1;
        if(s%1000==0)
        {
            mile=100;
        }
        if(mile>0){
            if(mile%10==0)
                milestone();
            mile-=1;
        }
    }
    public int get(){
        if(mile>0){
            return 10*(s/100);
        }
        return s/10;
    }
    public void milestone(){
        color= !color;
    }
    public boolean getColor(){
        return color;
    }
    public void reset(){
        s=0;
        mile=0;
    }
}
