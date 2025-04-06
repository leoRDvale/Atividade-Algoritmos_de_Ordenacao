import javax.swing.*;
import java.util.List;

public class ComboSort {
    public static void comboSort(List<Integer> list) {
        int gap = list.size();
        boolean swapped = true;
        double shrink = 1.3;
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.currentTimeMillis();

        while (gap > 1 || swapped) {
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            swapped = false;

            for (int i = 0; i < list.size() - gap; i++) {
                comparisons++;
                if (list.get(i) > list.get(i + gap)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + gap));
                    list.set(i + gap, temp);
                    swapped = true;
                    swaps++;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        JOptionPane.showMessageDialog(null, "**** Combo Sort ****\n\nTempo de execução: " + formatDuration(duration) + "\nComparações: " + comparisons + "\nQuantidade de trocas: " + swaps, "Combo Sort", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String formatDuration(long duration) {
        long hours = duration / 3600000;
        long minutes = (duration % 3600000) / 60000;
        long seconds = (duration % 60000) / 1000;
        long milliseconds = duration % 1000;
        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds);
    }
    }

