package question2;

import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class JButtonObserver {
    
    private String nom;
    private TextArea contenu;

    /**
     * Constructeur d'objets de classe JButtonObserver
     * 
     * @param nom
     *            le nom du bouton, jbo1, jbo2, jbo3, jmo1, jmo2, jmo3
     * @param contenu
     *            la zone de texte de l'applette
     */
    public JButtonObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    /**
     * affichage d'un message dans la zone de texte ce message est de la forme
     * observateur this.nom : clic du bouton nom_du_bouton exemple : observateur
     * jbo1 : clic du bouton A, voir la méthode getActionCommand()
     * 
     * @param à
     *            compléter
     */
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        String message = "observateur " + nom + " : clic du bouton " + ac;
        contenu.append(message + "\n");
    }
}