import java.awt.*;
import javax.swing.*;

// Une interface simple qui demande un chiffre à l'utilisateur et affiche le double de ce chiffre.

public class tuto extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public tuto() {
        super("Calculateur de double");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // Création des composants
        inputField = new JTextField(10);
        JButton calculateButton = new JButton("Calculer");
        resultLabel = new JLabel("Entrez un nombre");
        
        // Ajout des composants
        add(new JLabel("Nombre : "));
        add(inputField);
        add(calculateButton);
        add(resultLabel);
        
        // Gestionnaire d'événements
        calculateButton.addActionListener(e -> {
            try {
                int nombre = Integer.parseInt(inputField.getText());
                resultLabel.setText("Le double de " + nombre + " est " + (nombre * 2));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Veuillez entrer un nombre valide");
            }
        });
        
        // Configuration de la fenêtre
        setSize(300, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tuto().setVisible(true);
        });
    }
}