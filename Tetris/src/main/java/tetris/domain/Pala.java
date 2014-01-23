
package tetris.domain;

public class Pala {
    
    private int x;
    private int y;
    
    public Pala (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void siirry(int x, int y){
         this.x += x;
         this.y += y;
    }
    
    public String toString(){
        return this.x + "," + this.y;
    }
    
    public void kaanna(int x, int y){
        int vanhaX = this.x;
        this.x = x - this.y + y;
        this.y = y - vanhaX + x;
    }
}
