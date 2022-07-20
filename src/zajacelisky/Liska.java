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
public class Liska extends Zviera{
    private static final int DOSPELOST = 6;
    private static final int PLNA_SYTOST = 6;
    private int sytost = PLNA_SYTOST/2;
    private static final int DLZKA_ZIVOTA = 8;

    protected int maxDlzkaZivota(){
        return DLZKA_ZIVOTA;
    }

    @Override
    public void pridajVek(){
        super.pridajVek();
        if(sytost <= 0){
            zomri();
        }
    }

    @Override
    public String opis() {
        return "L  ";
    }

    @Override
    public Zviera interaguj(Zviera z) {
        if(z instanceof Liska){
            if(this.vek >= DOSPELOST && z.vek >= DOSPELOST){
                Liska nova = new Liska();
                System.out.println("Vznikla nová líška.");
                return nova;
            }
        }
        if(z instanceof Zajac){
            if(sytost < PLNA_SYTOST){
                z.zomri();
                sytost++;
            }
        }
        return null;
    }
}
