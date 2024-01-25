package question3;

import question3.tp3.*;

import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class IHMCalculette extends JFrame {
    public IHMCalculette() {
        super("IHM Calculette");
        PileModele<Integer> modele = new PileModele<Integer>(new Pile2<Integer>(5));
        Vue vue = new Vue(modele);
        
        // Nouveau model
       // Vue2 vue2 = new Vue2(modele);
        
        Controleur controle = new Controleur(modele, vue);
       //  Controleur controle = new Controleur(modele, vue2);

        setLayout(new GridLayout(2, 1));
        add(vue);
        add(controle);
        pack();
        setLocation(200,200);
        setVisible(true);
    }

    public static void main(String[] args){
        new IHMCalculette();
    }
}