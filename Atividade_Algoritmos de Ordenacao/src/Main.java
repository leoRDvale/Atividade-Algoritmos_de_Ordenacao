import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 100 mil números a serem ordenados
        //Utilizando Insertion Sort, Selection Sort, Bubble Sort, Combo Sort, Shell Sort.

        /*Utilizando o Arquivo VI da Aula 2 (100 Mil números a serem ordenados). Compare o desempenho dos algoritmos de Ordenação Implementados em JAVA estudados até o momento. O programa deve apresentar o tempo de execução de cada algoritmo em HH:MM:SS:mmm, contar a quantidade de comparações que cada algoritmo faz e a quantidade de trocas que cada algoritmo faz. */

        //******Edite para o caminho do arquivo txt com a lista de números ******

        String caminhoDoArquivo = "/Users/leonardvale/Downloads/dados100_mil.txt";
        List<Integer> numeros = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] numerosArray = linha.split(",");
                for (String numeroStr : numerosArray) {
                    try {
                        numeros.add(Integer.parseInt(numeroStr.trim()));
                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Erro ");
                    }
                }
            }

            //Caso o caminho do arquivo esteja errado, ele vai apresentar uma mensagem de erro.

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + caminhoDoArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
        }

        // Exibe os números lidos do arquivo, caso ache necessário remova o comentário
        //System.out.println("Números lidos do arquivo: " + numeros);

        

            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "**** Escolha o Algoritmo De Ordenação ****\n\n1 - Insertion Sort\n2 - Selection Sort\n3 - Bubble Sort\n4 - Combo Sort\n5 - Shell Sort\n6 - Sair"));

            switch (opcao) {
                case 1:
                    InsertionSort.insertionSort(numeros);
                    break;
                case 2:
                    SelectionSort.selectionSort(numeros);
                    break;
                case 3:
                    BubbleSort.bubbleSort(numeros);
                    break;
                case 4:
                    ComboSort.comboSort(numeros);
                    break;
                case 5:
                    ShellSort.shellSort(numeros);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha inválida.");
                    break;
            }


            //Cria o arquivo TXT com os numeros ordenados.
            //******Edite para o caminho do arquivo txt que deseja salvar os números ordenados ******


            String caminhoArquivoResultado = "/Users/leonardvale/Downloads/resultado.txt";
            String resultado = numeros.toString();

            try {

                FileWriter fileWriter = new FileWriter(caminhoArquivoResultado);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(resultado);
                bufferedWriter.close();

                JOptionPane.showMessageDialog(null, "Arquivo ordenado criado em: " + caminhoArquivoResultado);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage());
            }
        }

    }


