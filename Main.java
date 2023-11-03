package Garaj;
import javax.swing.*;

import java.awt.*;
public class Main {
    private static Garaj garaj;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginWindow();  
        });
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Garaj Auto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Ce doriti să faceti?");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        JButton openGarageButton = createStyledButton("Deschide Garajul");
        openGarageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(openGarageButton);

        JButton addButton = createStyledButton("Adaugă Mașină");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(addButton);

        JButton exitButton = createStyledButton("Ieșiți din program");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(exitButton);

        frame.add(mainPanel);

        openGarageButton.addActionListener(e -> showGaraj(frame));
        addButton.addActionListener(e -> afiseazaFereastraAdaugareMasina(frame));
        exitButton.addActionListener(e -> System.exit(0));

        frame.pack();
        frame.setVisible(true);
    }

    public static void showGaraj(JFrame frame) {
        if(garaj==null){
        garaj = Garaj.getInstance();
        }
        frame.getContentPane().removeAll();
        frame.repaint();
         
        JPanel garajPanel = new JPanel();
        garajPanel.setLayout(new BoxLayout(garajPanel, BoxLayout.Y_AXIS));
        if(garaj.getNumarMasini()==0){
            JLabel emptyGarageLabel = new JLabel("Garajul este gol.");
        emptyGarageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        emptyGarageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        garajPanel.add(emptyGarageLabel);
        }
        else{
        JLabel titleLabel = new JLabel("Mașinile din garaj:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        garajPanel.add(titleLabel);
        for (int i = 0; i < garaj.getNumarMasini(); i++) {
            Masina masina = garaj.selecteazaMasina(i);
            JButton carButton = createStyledButton(masina.getMarca() + " " + masina.getModel());
            carButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            carButton.addActionListener(e -> afiseazaDetaliiMasina(masina, frame));
            garajPanel.add(carButton);
        }
    }

        JButton backButton = createStyledButton("Inapoi");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> createAndShowGUI());

        garajPanel.add(backButton);
        frame.add(garajPanel);
        frame.pack();
    }

    public static void afiseazaDetaliiMasina(Masina masina, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        JPanel detaliiPanel = new JPanel();
        detaliiPanel.setLayout(new BoxLayout(detaliiPanel, BoxLayout.Y_AXIS));

        JLabel detaliiLabel = new JLabel("Ai selectat masina: " + masina.toString()); 
        detaliiLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        detaliiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detaliiPanel.add(detaliiLabel);

        JButton backButton = createStyledButton("Inapoi");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showGaraj(frame));

        JButton leaveGarageButton = createStyledButton("Părăsește Garajul");
        leaveGarageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaveGarageButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Esti sigur ca doresti sa parasesti garajul cu aceasta masina?","Confirmare",JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_OPTION) {
            paraseazaGarajul(masina, frame);
            }
        });
        detaliiPanel.add(backButton);
        detaliiPanel.add(leaveGarageButton);
        frame.add(detaliiPanel);
        frame.pack();
    }

    public static void paraseazaGarajul(Masina masina, JFrame frame) {
        garaj.stergeMasina(masina);
        JOptionPane.showMessageDialog(frame, "Vehiculul a fost scos cu succes din garaj");
        showGaraj(frame);
    }

    public static void afiseazaFereastraAdaugareMasina(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        JPanel addCarPanel = new JPanel();
        addCarPanel.setLayout(new BoxLayout(addCarPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Introduceti datele pentru noua masina:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCarPanel.add(titleLabel);

        JTextField marcaField = new JTextField(20);
        JTextField modelField = new JTextField(20);
        JTextField anFabricatieField = new JTextField(20);
        JTextField kmField = new JTextField(20);
        JTextField culoareField = new JTextField(20);

        addCarPanel.add(new JLabel("Marca:"));
        addCarPanel.add(marcaField);
        addCarPanel.add(new JLabel("Model:"));
        addCarPanel.add(modelField);
        addCarPanel.add(new JLabel("An de fabricatie:"));
        addCarPanel.add(anFabricatieField);
        addCarPanel.add(new JLabel("Numar de kilometrii:"));
        addCarPanel.add(kmField);
        addCarPanel.add(new JLabel("Culoare:"));
        addCarPanel.add(culoareField);

        JButton addButton = createStyledButton("Adaugă Mașină");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(e -> {
            String marca = marcaField.getText();
            String model = modelField.getText();
            int anFabricatie = Integer.parseInt(anFabricatieField.getText());
            int km = Integer.parseInt(kmField.getText());
            String culoare = culoareField.getText();
            if (marcaField.getText().isEmpty() || modelField.getText().isEmpty() || anFabricatieField.getText().isEmpty() || kmField.getText().isEmpty() || culoareField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Unul dintre campuri nu a fost completat!");
            } else {
                Masina masina = new Masina(marca, model, anFabricatie, km, culoare);
                garaj.adaugaMasina(masina);
                frame.getContentPane().removeAll();
                frame.repaint();
                showGaraj(frame);
                JOptionPane.showMessageDialog(frame, "Masina adaugata cu succes!");
            }
        });

        JButton backButton = createStyledButton("Inapoi");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> createAndShowGUI());

        addCarPanel.add(addButton);
        addCarPanel.add(backButton);
        frame.add(addCarPanel);
        frame.pack();
    }

    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setMargin(new Insets(10, 10, 10, 10));
        return button;
    }
}
