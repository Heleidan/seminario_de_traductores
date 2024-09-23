package traductor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventanita {
    public static void main(String[] args) {
        Traductor traductor = new Traductor(); // Create Traductor instance
        JFrame frame = new JFrame("Traductor de Carlitos Avila MII");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel inputLabel = new JLabel(">>>: ");
        JLabel ETIQUETA1 = new JLabel("Pila:");
        JLabel ETIQUETA2 = new JLabel("Entrada:");
        JLabel ETIQUETA3 = new JLabel("Diccionario:");

        JTextArea cuadritoDePila = new JTextArea(10, 15);
        cuadritoDePila.setEditable(false);
        JScrollPane lrScrollPane = new JScrollPane(cuadritoDePila);
        lrScrollPane.setPreferredSize(new Dimension(200, 300));

        JTextArea cuadritoDeEntrada = new JTextArea(10, 15);
        cuadritoDeEntrada.setEditable(false);
        JScrollPane inputScrollPane = new JScrollPane(cuadritoDeEntrada);
        inputScrollPane.setPreferredSize(new Dimension(200, 300));

        JTextArea cuadritoDeDiccionario = new JTextArea(10, 15);
        cuadritoDeDiccionario.setEditable(false);
        JScrollPane diccionarioScrollPane = new JScrollPane(cuadritoDeDiccionario);
        diccionarioScrollPane.setPreferredSize(new Dimension(200, 300));

        JTextField inputField = new JTextField(15);
        JButton submitButton = new JButton("Enviar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    traductor.addInput(input); // Add input and process it
                    for(int i=0; i<=input.length(); i++){
                        traductor.callToAction();
                    }
                    cuadritoDeEntrada.setText(traductor.getEntradita()); // Show updated entrada
                    cuadritoDePila.setText(traductor.getPilita());
                    inputField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalido.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(submitButton);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.1;
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(panel, gbc);
        // Pila:
        gbc.weighty = 0.1;
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(ETIQUETA1, gbc);
        gbc.weighty = 1.0;
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(lrScrollPane, gbc);
        // Entrada:
        gbc.weighty = 0.1;
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(ETIQUETA2, gbc);
        gbc.weighty = 1.0;
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(inputScrollPane, gbc);
        // Diccionario:
        gbc.weighty = 0.1;
        gbc.gridx = 2; gbc.gridy = 1;
        frame.add(ETIQUETA3, gbc);
        gbc.weighty = 1.0;
        gbc.gridx = 2; gbc.gridy = 2;
        frame.add(diccionarioScrollPane, gbc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
