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
import java.util.Random;

public class Plocha {
    private int sirka;
    private int vyska;
    private int pocetZvierat=0;
    private int zajkovia=0;
    private int listicky=0;
    private Policko[][] policka;

    public Plocha(int sirka, int vyska) {
        this.vytvorPlochu(sirka,vyska);
    }
    private void vytvorPlochu(int sirka, int vyska){
        this.sirka = sirka;
        this.vyska = vyska;
        this.policka = new Policko[sirka][vyska];
        for(int y=0; y<vyska; y++){
            for (int x=0; x<sirka; x++){
                this.policka[x][y] = new Policko();
            }
        }
    }

    public void pridajZvieraNahodne(Zviera z){
        Random rnd = new Random();
        int x = rnd.nextInt(sirka);
        int y = rnd.nextInt(vyska);
        
        while(this.policka[x][y].obsahujeZviera()){
            x = rnd.nextInt(sirka);
            y = rnd.nextInt(vyska);
        }
            this.policka[x][y].pridajZviera(z);
            pocetZvierat++;
            //System.out.println(pocetZvierat);
        
    }

    public int getListicky() {
        return listicky;
    }

    public int getZajkovia() {
        return zajkovia;
    }
    
    public void pripocitajZajka(){
        zajkovia++;
    }
    
    public void pripocitajLisky(){
        listicky++;
    }
    
    
    public void zobraz(){
        for(int y=0; y<vyska; y++){
            for (int x=0; x<sirka; x++){
                System.out.print(this.policka[x][y].opis());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void spravPohyb(){
        for(int y=0; y<vyska; y++){
            for (int x=0; x<sirka; x++){
                if (policka[x][y].obsahujeZviera() && !policka[x][y].getZviera().posunuty) {
                    Random rnd = new Random();
                    int noveX = x, noveY = y;
                    switch (rnd.nextInt(4)) {
                        case 0:
                            if (y > 0) {
                                noveY--;
                            }
                            break;
                        case 1:
                            if (y < vyska - 1) {
                                noveY++;
                            }
                            break;
                        case 2:
                            if (x > 0) {
                                noveX--;
                            }
                            break;
                        case 3:
                            if (x < sirka - 1) {
                                noveX++;
                            }
                            break;
                    }
                    if (noveX != x || noveY != y) {
                        Zviera z = policka[x][y].getZviera();
                        if (policka[noveX][noveY].obsahujeZviera()) {
                            Zviera nove = z.interaguj(policka[noveX][noveY].getZviera());
                            if (nove != null){
                                this.pridajZvieraNahodne(nove);
                                if(nove instanceof Zajac) {
                                    zajkovia++;
                                }
                                else {
                                    listicky++;
                                }
                            }
                        } else {
                            policka[x][y].zrusZviera();
                            policka[noveX][noveY].pridajZviera(z);
                            z.posunuty = true;
                        }
                    }
                }
            }
        }
        for(int y=0; y<vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                if(policka[x][y].obsahujeZviera()){
                    policka[x][y].getZviera().posunuty = false;
                }
            }
        }
    }

    public void pridajVekVsetkym(){
        for(int y=0; y<vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                if(policka[x][y].obsahujeZviera()){
                    policka[x][y].getZviera().pridajVek();
                }
            }
        }
    }

    public int getPocetZvierat() {
        return pocetZvierat;
    }
    
    
    public void odstranMrtve(){
        for(int y=0; y<vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                if(policka[x][y].obsahujeZviera() && policka[x][y].getZviera().jeMrtve()){
                    pocetZvierat--;
                    if(policka[x][y].getZviera() instanceof Liska) {
                        listicky--;
                    }
                    else{
                        zajkovia--;
                    }      
                    //System.out.println(pocetZvierat);
                    policka[x][y].zrusZviera();
                }
            }
        }
    }
}
