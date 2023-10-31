import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Garaj garaj;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
            garaj = new Garaj();
        });
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Garaj Auto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Ce doriti să faceti?");
        mainPanel.add(titleLabel);

        JButton openGarageButton = new JButton("Deschide Garajul");
        mainPanel.add(openGarageButton);

        JButton addButton = new JButton("Adaugă Mașină");
        mainPanel.add(addButton);

        JButton exitButton = new JButton("Iesiti din program");
        mainPanel.add(exitButton);

        frame.add(mainPanel);

        openGarageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                showGaraj(frame);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                afiseazaFereastraAdaugareMasina(frame);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void showGaraj(JFrame frame) {
        JPanel garajPanel = new JPanel();
        garajPanel.setLayout(new BoxLayout(garajPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Mașinile din garaj:");
        garajPanel.add(titleLabel);

        for (int i = 0; i < garaj.getNumarMasini(); i++) {
            Masina masina = garaj.selecteazaMasina(i);
            JButton carButton = new JButton(masina.getMarca() + " " + masina.getModel());
            carButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    afiseazaDetaliiMasina(masina, frame);
                }
            });
            garajPanel.add(carButton);
        }

        JButton backButton = new JButton("Inapoi");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                createAndShowGUI();
            }
        });

        garajPanel.add(backButton);
        frame.add(garajPanel);
        frame.pack();
    }

    public static void afiseazaDetaliiMasina(Masina masina, JFrame frame) {
        JPanel detaliiPanel = new JPanel();
        detaliiPanel.setLayout(new BoxLayout(detaliiPanel, BoxLayout.Y_AXIS));

        JLabel detaliiLabel = new JLabel("Ai selectat masina: " + masina.getMarca() + " " + masina.getModel() + ", An de fabricatie: " +
                masina.getAnFabricatie() + " Numar de kilometrii " + masina.numarKilometrii() + " Culoarea: " + masina.culoareMasina() + ".");
        detaliiPanel.add(detaliiLabel);

        JButton backButton = new JButton("Inapoi");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                showGaraj(frame);
            }
        });

        detaliiPanel.add(backButton);
        frame.add(detaliiPanel);
        frame.pack();
    }

    public static void afiseazaFereastraAdaugareMasina(JFrame frame) {
        JPanel addCarPanel = new JPanel();
        addCarPanel.setLayout(new BoxLayout(addCarPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Introduceti datele pentru noua masina:");
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
        
        JButton addButton = new JButton("Adaugă Masină");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = marcaField.getText();
                String model = modelField.getText();
                int anFabricatie = Integer.parseInt(anFabricatieField.getText());
                int km = Integer.parseInt(kmField.getText());
                String culoare = culoareField.getText();
                if(marcaField.getText().isEmpty()||modelField.getText().isEmpty()||anFabricatieField.getText().isEmpty()||kmField.getText().isEmpty()||culoareField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Unul dintre campuri nu au fost completate!");
                }
                else
                {
                Masina masina = new Masina(marca, model, anFabricatie, km, culoare);
                garaj.adaugaMasina(masina);
                frame.getContentPane().removeAll();
                frame.repaint();
                showGaraj(frame);
                 JOptionPane.showMessageDialog(null,"Masina adaugata cu succes!");
            }
        }
        });

        JButton backButton = new JButton("Inapoi");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                createAndShowGUI();
            }
        });

        addCarPanel.add(addButton);
        addCarPanel.add(backButton);
        frame.add(addCarPanel);
        frame.pack();
    }
}
