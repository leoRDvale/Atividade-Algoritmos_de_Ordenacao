import javax.swing.*;
import java.util.List;

public class BubbleSort {

    public static void bubbleSort(List<Integer> list) {
        boolean swapped;
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                comparisons++;
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        JOptionPane.showMessageDialog(null, "**** Bubble Sort ****\n\nTempo de execução: " + formatDuration(duration) + "\nComparações: " + comparisons + "\nQuantidade de trocas: " + swaps, "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String formatDuration(long duration) {
        long hours = duration / 3600000;
        long minutes = (duration % 3600000) / 60000;
        long seconds = (duration % 60000) / 1000;
        long milliseconds = duration % 1000;
        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds);
    }
}



