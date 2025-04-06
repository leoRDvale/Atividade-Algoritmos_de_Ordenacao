import javax.swing.*;
import java.util.List;

public class ShellSort {
    public static void shellSort(List<Integer> list) {
        int n = list.size();
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.currentTimeMillis();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = list.get(i);
                int j;
                for (j = i; j >= gap; j -= gap) {
                    comparisons++;
                    if (list.get(j - gap) > temp) {
                        list.set(j, list.get(j - gap));
                        swaps++;
                    } else {
                        break;
                    }
                }
                list.set(j, temp);
                swaps++;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        JOptionPane.showMessageDialog(null, "**** Shell Sort ****\n\nTempo de execução: " + formatDuration(duration) + "\nComparações: " + comparisons + "\nQuantidade de trocas: " + swaps, "Shell Sort", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String formatDuration(long duration) {
        long hours = duration / 3600000;
        long minutes = (duration % 3600000) / 60000;
        long seconds = (duration % 60000) / 1000;
        long milliseconds = duration % 1000;
        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds);
    }
}


