package question2;

import java.awt.event.MouseEvent;
import java.awt.TextArea;

public class JMouseObserver { // à compléter

    private String nom;
    private TextArea contenu;

    /**
     * Constructeur d'objets de classe JButtonObserver
     */
    public JMouseObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    /**
     * affichage d'un message dans la zone de texte ce message est de la forme
     * observateur this.nom : souris entrée en (X,Y)
     * exemple :
     *      observateur jmo1 : souris entrée en (15,20)
     * 
     * @param
     */
    public void mouseEntered(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        String message = "observateur " + nom + " : souris entree en (" + x + "," + y + ")";
        contenu.append(message + "\n");
    }

    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
}