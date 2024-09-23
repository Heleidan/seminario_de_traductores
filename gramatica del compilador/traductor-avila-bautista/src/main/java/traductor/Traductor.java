package traductor;

import java.util.ArrayList;

public class Traductor {
    private StringBuilder entrada;
    private ArrayList<String> entradita;
    private ArrayList<String> pilita;

    public Traductor() {
        entrada = new StringBuilder();
        pilita = new ArrayList<>();
        pilita.add("$0"); // Initialize with "$0"
    }

    public void addInput(String input) {
        entrada.append(input);
        
        processInput();
    }

    private void processInput() {
        while (entrada.length() > 0) {
            pop();
        }
    }

    public String getEntradita() {
        StringBuilder sb = new StringBuilder();
        for (String str : pilita) {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    public String getPilita() {
        StringBuilder sb = new StringBuilder();
        for (String str : pilita) {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    private void pop() {
        char firstChar = entrada.charAt(0); // Get the first character
        entrada.deleteCharAt(0); // Remove it from entrada
        pilita.add(pilita.get(pilita.size() - 1) + firstChar); // Update pilita
    }

    public void callToAction() {
        pop();
    }
}
