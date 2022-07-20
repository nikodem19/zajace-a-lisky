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
public class Hlavna {
        
        public static void main(String[] args) throws InterruptedException {
        Simulacia sim = new Simulacia(5,5);
        sim.generujZvierata(4,4);
        sim.zobraz();
        int pocetKrokov=1;
        while ((sim.pocetZajkov()>0) && (sim.pocetLisok()>0)){
            //System.out.println(sim.pocetZajkov());
            //System.out.println(sim.pocetLisok());
            pocetKrokov++;
            Thread.sleep(500);
            sim.vykonajKrok();
            sim.zobraz();
        }
        System.out.println(pocetKrokov+" krokov.");
    }
}
