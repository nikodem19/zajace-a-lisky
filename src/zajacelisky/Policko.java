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
public class Policko {
    private Zviera z;

    public void pridajZviera(Zviera z){
        this.z = z;
    }

    public String opis(){
        if(z!=null){
            return z.opis();
        }
        return "_  ";
    }

    public boolean obsahujeZviera(){
        return z!=null;
    }

    public void zrusZviera(){
        z = null;
    }

    public Zviera getZviera(){
        return z;
    }
}
