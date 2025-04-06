import javax.swing.*;
import java.util.List;

public class InsertionSort {
    public static void insertionSort(List<Integer> lista) {
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 1; i < lista.size(); i++) {
            int key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > key) {
                comparisons++;
                lista.set(j + 1, lista.get(j));
                j = j - 1;
                swaps++;
            }
            lista.set(j + 1, key);
            swaps++;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        JOptionPane.showMessageDialog(null, "**** Insertion Sort ****\n\nTempo de execução: " + formatDuration(duration) + "\nComparações: " + comparisons + "\nQuantidade de trocas: " + swaps, "Insertion Sort", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String formatDuration(long duration) {
        long hours = duration / 3600000;
        long minutes = (duration % 3600000) / 60000;
        long seconds = (duration % 60000) / 1000;
        long milliseconds = duration % 1000;
        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds);
    }
}