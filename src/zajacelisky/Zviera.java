/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zajacelisky;

/**
 *
 * @author Nikodém Babirád
 */
public abstract class Zviera {
    protected int vek;
    protected boolean zije = true;
    public boolean posunuty = false;
    public abstract String opis();

    public abstract Zviera interaguj(Zviera z);

    public void pridajVek(){
        vek++;
        if(vek > maxDlzkaZivota()){
            zomri();
        }
    }
    protected abstract int maxDlzkaZivota();

    public void zomri(){
        zije = false;
        System.out.println("Zviera umrelo.");
    }
    public boolean jeMrtve(){
        return !zije;
    }
}
