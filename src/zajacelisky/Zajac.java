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
public class Zajac extends Zviera{
    private static final int DOSPELOST = 4;
    private static final int DLZKA_ZIVOTA = 10;

    protected int maxDlzkaZivota(){
        return DLZKA_ZIVOTA;
    }

    @Override
    public String opis() {
        return "Z  ";
    }

    @Override
    public Zviera interaguj(Zviera z) {
        if(z instanceof Zajac){
            if(this.vek >= DOSPELOST && z.vek >= DOSPELOST){
                Zajac novyZajac = new Zajac();
                System.out.println("Vznikol nový zajac.");
                return novyZajac;
            }
        }
        return null;
    }
}
