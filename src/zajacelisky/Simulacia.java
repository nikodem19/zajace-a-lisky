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
public class Simulacia {
    private Plocha plocha;


    public Simulacia(int sirka, int vyska){
        this.plocha = new Plocha(sirka, vyska);
    }

    public void generujZvierata(int pocetZajacov, int pocetLisok){
        for (int i=0; i<pocetZajacov; i++){
            Zajac z = new Zajac();
            plocha.pridajZvieraNahodne(z);
            plocha.pripocitajZajka();
        }

        for (int i=0; i<pocetLisok; i++){
            Liska l = new Liska();
            plocha.pridajZvieraNahodne(l);
            plocha.pripocitajLisky();
        }
    }

    public void zobraz(){
        plocha.zobraz();
    }
    
   public int zistiPocetZvierat() {
       return plocha.getPocetZvierat();
   }
   
   public int pocetZajkov() {
       return plocha.getZajkovia();
   }
   
   public int pocetLisok() {
       return plocha.getListicky();
   }
    
    public void vykonajKrok(){
        plocha.spravPohyb();
        plocha.pridajVekVsetkym();
        plocha.odstranMrtve();
    }
}
