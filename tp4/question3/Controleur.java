package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;
    private Vue vue;

    public Controleur(PileModele<Integer> pile, Vue vue) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);
        this.vue = vue;

        this.push = new JButton("PUSH");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valeur = operande();
                    pile.empiler(valeur);
                    actualiserInterface();
                } catch (Exception ex) { ex.printStackTrace(); System.out.println(ex); }
            }
        });
        
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);
        push.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valeur = operande();
                    pile.empiler(valeur);
                    actualiserInterface();
                } catch (Exception ex) { ex.printStackTrace(); System.out.println(ex); }
            }
        });
        
        boutons.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int resultat = pile.depiler() + pile.depiler();
                    pile.empiler(resultat);
                    actualiserInterface();
                } catch (Exception ex) { ex.printStackTrace(); System.out.println(ex); }
            }
        });
        
        boutons.add(sub);
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int resultat = pile.depiler() - pile.depiler();
                    pile.empiler(resultat);
                    actualiserInterface();
                } catch (Exception ex) { ex.printStackTrace(); System.out.println(ex); }
            }
        });
        
        boutons.add(mul);
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int resultat = pile.depiler() * pile.depiler();
                    pile.empiler(resultat);
                    actualiserInterface();
                } catch (Exception ex) { ex.printStackTrace(); System.out.println(ex); }
            }
        });
        
        boutons.add(div);
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int op2 = pile.depiler();
                    int op1 = pile.depiler();
                    if (op2 == 0) {
                        JOptionPane.showMessageDialog(null, "Division by zero is not allowed!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int resultat = op1 / op2;
                        pile.empiler(resultat);
                        actualiserInterface();
                    }
                } catch (Exception ex) { ex.printStackTrace(); System.out.println(ex); }
            }
        });
        
        boutons.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pile.vider();
                actualiserInterface();
            }
        });
        
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }
    
    // à compléter
    public void actualiserInterface() {
        String pileText = "Pile: " + pile.toString();
        donnee.setText("");
        vue.update(pile, pileText);
    }
    
    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
}