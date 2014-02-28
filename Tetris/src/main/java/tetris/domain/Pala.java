
package tetris.domain;

/**
 * Yksittäistä kuvion palaa kuvaava
 * luokka, joka tietää palan paikan ja sen värin.
 * 
 * @author Krista
 */

public class Pala {
    
    private int x;
    private int y;
    private int vari;
    
    public Pala (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setTyyppi(int tyyppi){
        this.vari = tyyppi;
    }
    
    public int getTyyppi(){
        return vari;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    /**
     * Siirtää palaa valittujen koordinaattien mukaisesti
     * 
     * @param x vaakakoordinaatti
     * @param y pystykoordinaatti
     */
    
    public void siirry(int x, int y){
         this.x += x;
         this.y += y;
    }
    
    /**
     * Valitsee Palalle uudet koordinaatit valittujen
     * perusteella kääntäen sitä 90 astetta
     * @param x
     * @param y 
     */
    public void kaanna(int x, int y){
        int vanhaX = this.x;
        this.x = x - this.y + y;
        this.y = y + vanhaX - x;
    }
    
    /**
     * Testaa, osuuko Pala toiseen vertaamalla niiden koordinaatteja toisiinsa.
     * @param toinenPala
     * @return false jos koordinaatit eivät ole samat, true jos ovat
     */
    public boolean osuuPalaan(Pala toinenPala){
        if(this.x == toinenPala.x && this.y == toinenPala.y) {
            return true;
        }
        return false;
    }
    
    /**
     * Testaa, osuuko pala valittuun vaakakoordinaattiin vertaamalla
     * 
     * @param x reunan valittu koordinaatti
     * @return false jos vaakakoordinaatit eivät ole samat, true jos ovat
     */
    public boolean osuuReunaan(int x){
        if (this.x == x){
            return true;
        }
        return false;
    }
    /**
     * Testaa, osuuko Pala pohjaan katsomalla onko sen pystykoordinaatti
     * pohjan kanssa sama
     * @return false jos ei ole, true jos on
     */
    public boolean osuuPohjaan(){
        if (this.y >= 570){
            return true;
        }
       return false;
    }
    
    /**
     * Määrittelee miten yksittäisen palan koordinaatit tulostuvat.
     * @return palan koordinaatit merkkijonona
     */
    public String toString(){
        return this.x + "," + this.y;
    }
}
