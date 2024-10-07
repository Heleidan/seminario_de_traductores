package traductor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Ventanita extends JFrame {
    private JTextField inputField;
    private JTextArea pilaArea, entradaArea, diccionarioArea;
    private HashMap<Character, Integer> diccionario;
    private ArrayList<String> pila;
    private ArrayList<String> entrada;
    private ArrayList<String> entradaHistory;

    public Ventanita() {
        setTitle("Traductor Carlos Avila Mk.III");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new EnviarListener());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(enviarButton, BorderLayout.EAST);

        pila = new ArrayList<>();
        entrada = new ArrayList<>();
        entradaHistory = new ArrayList<>();
        diccionario = new HashMap<>();
        diccionario.put('a', 3);
        diccionario.put('d', 1);
        pila.add("$0");
        pilaArea = new JTextArea(10, 20);
        entradaArea = new JTextArea(10, 20);
        diccionarioArea = new JTextArea(5, 20);
        updateDiccionarioArea();
        updateAreas();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 3));

        JPanel pilaPanel = new JPanel(new BorderLayout());
        pilaPanel.add(new JLabel("Pila:"), BorderLayout.NORTH);
        pilaPanel.add(new JScrollPane(pilaArea), BorderLayout.CENTER);

        JPanel entradaPanel = new JPanel(new BorderLayout());
        entradaPanel.add(new JLabel("Historial de Entrada:"), BorderLayout.NORTH);
        entradaPanel.add(new JScrollPane(entradaArea), BorderLayout.CENTER);

        JPanel diccionarioPanel = new JPanel(new BorderLayout());
        diccionarioPanel.add(new JLabel("Diccionario:"), BorderLayout.NORTH);
        diccionarioPanel.add(new JScrollPane(diccionarioArea), BorderLayout.CENTER);

        centerPanel.add(pilaPanel);
        centerPanel.add(entradaPanel);
        centerPanel.add(diccionarioPanel);

        add(inputPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void updateDiccionarioArea() {
        StringBuilder sb = new StringBuilder();
        for (Character key : diccionario.keySet()) {
            sb.append(key).append(": ").append(diccionario.get(key)).append("\n");
        }
        diccionarioArea.setText(sb.toString());
    }

    private void updateAreas() {
        pilaArea.setText(String.join("\n", pila));
        entradaArea.setText(String.join("\n", entradaHistory));
    }

    private void runGame() {
        if (!entrada.isEmpty()) {
            String currentStr = entrada.remove(0);
            String lastPila = pila.get(pila.size() - 1);
            String newPilaEntry = lastPila + currentStr;
            pila.add(newPilaEntry);
            char firstChar = currentStr.charAt(0);
            if (diccionario.containsKey(firstChar)) {
                newPilaEntry += diccionario.get(firstChar);
                pila.add(newPilaEntry);
            }
            entradaHistory.add(String.join("", entrada));
        }
        updateAreas();
    }

    private class EnviarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText().trim();
            inputField.setText("");
            entrada.clear();
            entradaHistory.clear();
            for (char ch : input.toCharArray()) {
                entrada.add(String.valueOf(ch));
            }
            if (pila.isEmpty()) {
                pila.add("$0");
            }
            entradaHistory.add(String.join("", entrada));
            updateAreas();
            while (!entrada.isEmpty()) {
                runGame();
            }
            updateAreas();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ventanita::new);
    }
}
