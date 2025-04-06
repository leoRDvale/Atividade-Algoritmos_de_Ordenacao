import javax.swing.*;
import java.awt.*;

public class Ordenacao {
    private int[] numeros;

    public Ordenacao(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        int i, j, aux;
        for (i = 0; i < numeros.length - 1; i++) {
            for (j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Troca os elementos de posição
                    aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }
    }

    public void mostrar() {
        StringBuilder mensagem = new StringBuilder("Vetor ordenado: ");
        for (int i = 0; i < numeros.length; i++) {
            mensagem.append(numeros[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

}
