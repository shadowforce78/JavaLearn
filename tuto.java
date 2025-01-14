import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Une interface simple qui demande un chiffre à l'utilisateur et affiche le double de ce chiffre.

public class tuto extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public tuto() {
        super("Calculateur de double");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        
        // Configuration du thème sombre
        Color backgroundColor = new Color(43, 43, 43);
        Color foregroundColor = new Color(255, 255, 255);
        Color buttonColor = new Color(75, 110, 175);
        
        // Appliquer le thème sombre au fond
        getContentPane().setBackground(backgroundColor);
        
        // Création des composants avec style moderne
        inputField = new JTextField(10);
        inputField.setBackground(new Color(60, 60, 60));
        inputField.setForeground(foregroundColor);
        inputField.setCaretColor(foregroundColor);
        inputField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 70, 70)),
            new EmptyBorder(5, 5, 5, 5)));

        JButton calculateButton = new JButton("Calculer");
        calculateButton.setBackground(buttonColor);
        calculateButton.setForeground(foregroundColor);
        calculateButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        calculateButton.setFocusPainted(false);
        
        resultLabel = new JLabel("Entrez un nombre");
        resultLabel.setForeground(foregroundColor);
        
        JLabel promptLabel = new JLabel("Nombre : ");
        promptLabel.setForeground(foregroundColor);
        
        // Ajout des composants
        add(promptLabel);
        add(inputField);
        add(calculateButton);
        add(resultLabel);
        
        // Gestionnaire d'événements avec effet hover
        calculateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculateButton.setBackground(buttonColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calculateButton.setBackground(buttonColor);
            }
        });
        
        calculateButton.addActionListener(e -> {
            try {
                int nombre = Integer.parseInt(inputField.getText());
                resultLabel.setText("Le double de " + nombre + " est " + (nombre * 2));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Veuillez entrer un nombre valide");
            }
        });
        
        // Configuration de la fenêtre
        setSize(350, 150);
        setLocationRelativeTo(null);
        getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tuto().setVisible(true);
        });
    }
}