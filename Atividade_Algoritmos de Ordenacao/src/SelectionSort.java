import javax.swing.*;
import java.util.List;

public class SelectionSort {
    public static void selectionSort(List<Integer> list) {

        long comparisons = 0;
        long swaps = 0;
        long startTime = System.currentTimeMillis();


        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                comparisons++;
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
                swaps++;
            }
        }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            JOptionPane.showMessageDialog(null, "**** Selection Sort ****\n\nTempo de execução: " + formatDuration(duration) + "\nComparações: " + comparisons + "\nQuantidade de trocas: " + swaps, "Insertion Sort", JOptionPane.INFORMATION_MESSAGE);
        }

        private static String formatDuration ( long duration){
            long hours = duration / 3600000;
            long minutes = (duration % 3600000) / 60000;
            long seconds = (duration % 60000) / 1000;
            long milliseconds = duration % 1000;
            return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds);
        }
    }


