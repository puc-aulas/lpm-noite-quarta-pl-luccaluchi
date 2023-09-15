import main.java.utils.FileReader;
import main.java.utils.Utils;

import java.io.FileNotFoundException;

import main.java.questao_1.Questao1;
import main.java.questao_2.Questao2;
import main.java.questao_3.Questao3;
import main.java.questao_4.Questao4;
import main.java.questao_5.Questao5;
import main.java.questao_6.Questao6;
import main.java.questao_7.Questao7;
import main.java.questao_8.Questao8;
import main.java.questao_9.Questao9;
import main.java.questao_10.Questao10;
import main.java.questao_11.Questao11;
import main.java.questao_12.Questao12;

public class App {
    // windows path
    // private static final String QUESTION10_FILE_NAME =
    // "C:\\coding\\modular-programming\\teoria\\revisao-1\\src\\mock\\questao10.txt";
    // private static final String QUESTION11_FILE_NAME =
    // "C:\\coding\\modular-programming\\teoria\\revisao-1\\src\\mock\\questao11.txt";
    // private static final String QUESTION12_FILE_NAME =
    // "C:\\coding\\modular-programming\\teoria\\revisao-1\\src\\mock\\questao12.txt";

    // linux path
    private static final String QUESTION10_FILE_NAME = "/home/jose/coding/modular-programming/teoria/revisao-1/src/mock/questao10.txt";
    private static final String QUESTION11_FILE_NAME = "/home/jose/coding/modular-programming/teoria/revisao-1/src/mock/questao11.txt";
    private static final String QUESTION12_FILE_NAME = "/home/jose/coding/modular-programming/teoria/revisao-1/src/mock/questao12.txt";

    private static int CREATED_CLASSES = 12;

    public static void main(String[] args) throws Exception {
        while (true) {
            showMenuHeader();
            int userOption = Utils.readInt();
            userOption = checkUserOption(userOption);
            if (userOption >= 0) {
                executeQuestion(userOption);
            }
        }
    }

    private static int checkUserOption(int userOption) {
        if (userOption == CREATED_CLASSES + 1) {
            System.exit(0);
        } else if (userOption > CREATED_CLASSES + 1 || userOption < 0) {
            System.out.println("Opcao invalida!");
            return -1;
        }
        return userOption;
    }

    private static void showMenuHeader() {
        System.out.println("Exercicios de revisão");
        System.out.println("Escolha uma das opcoes abaixo:");
        // System.out.println(0 + " - Rodar todos os testes");

        for (int i = 0; i < CREATED_CLASSES; i++) {
            System.out.println((i + 1) + " - Questao " + (i + 1));
        }
        System.out.println(CREATED_CLASSES + 1 + " - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void executeQuestion(int userOption) {
        switch (userOption) {
            // case 0:
            // TestRunner.main(null);
            // break;
            case 1:
                Questao1.enunciado();
                int[] entry1 = Utils.readIntArray();
                int[] result1 = Questao1.execute(entry1);
                System.out.print("[");
                for (int i = 0; i < result1.length; i++) {
                    if (i != result1.length - 1) {
                        System.out.print(result1[i] + ", ");
                        continue;
                    }
                    System.out.println(result1[i] + "]");
                }
                break;
            case 2:
                Questao2.enunciado();
                int[] entry2 = Utils.readIntArray();
                int[] result2 = Questao2.execute(entry2);
                System.out.print("[");
                for (int i = 0; i < result2.length; i++) {
                    if (i != result2.length - 1) {
                        System.out.print(result2[i] + ", ");
                        continue;
                    }
                    System.out.println(result2[i] + "]");
                }
                break;
            case 3:
                Questao3.enunciado();
                System.out.print("Digite o tamanho horizontal: ");
                int x = Utils.readInt();
                System.out.print("Digite o tamanho vertical: ");
                int y = Utils.readInt();

                System.out.println(Questao3.execute(x, y));
                break;

            case 4:
                Questao4.enunciado();
                String input = "";
                Boolean hasLine = false;
                while (true) {
                    System.out.print("Digite uma frase: ");
                    input = Utils.readString();
                    Questao4 questao_4 = new Questao4();
                    hasLine = questao_4.execute(input);
                    if (!hasLine) {
                        break;
                    }
                }
            case 5:
                int inputClasses;
                int inputHours;
                int inputMinutes;
                Questao5.enunciado();
                System.out.print("Digite a quantidade de disciplinas: ");
                try {
                    inputClasses = Integer.parseInt(Utils.readString());
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece [ERROR: " + e.getMessage() + "]");
                    break;
                }

                System.out.print("Digite a quantidade de horas disponíveis: ");
                try {
                    inputHours = Integer.parseInt(Utils.readString());
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece [ERROR: " + e.getMessage() + "]");
                    break;
                }

                System.out.print("Digite a quantidade de minutos disponíveis: ");
                try {
                    inputMinutes = Integer.parseInt(Utils.readString());
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece [ERROR: " + e.getMessage() + "]");
                    break;
                }

                Questao5 questao5 = new Questao5();
                try {
                    String result = questao5.execute(inputHours, inputMinutes, inputClasses);
                    System.out.println(result);
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece. ERROR[" + e.getMessage() + "]");
                    break;
                }
                break;
            case 6:
                int input1;
                int input2;

                Questao6.enunciado();

                System.out.print("Digite o número do primeiro prêmio: ");
                try {
                    input1 = Integer.parseInt(Utils.readString());
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece");
                    break;
                }

                System.out.print("Digite o número do segundo prêmio: ");
                try {
                    input2 = Integer.parseInt(Utils.readString());
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece");
                    break;
                }

                Questao6 questao6 = new Questao6(input1, input2);
                int resultQuestao6 = questao6.execute();

                System.out.println("Código do ganhador: " + resultQuestao6);
                break;
            case 7:
                int numberInput;
                Questao7.enunciado();

                System.out.print("Digite um número de 2 dígitos: ");
                try {
                    numberInput = Integer.parseInt(Utils.readString());
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece\n ERROR[" + e.getMessage() + "]");
                    break;
                }

                try {
                    int resultQuestao7 = Questao7.execute(numberInput);
                    System.out.println("Resultado da multiplicação: " + resultQuestao7);
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece - ERROR[" + e.getMessage() + "]");
                    break;
                }
                break;
            case 8:
                String inputDate = "";
                Questao8.enunciado();

                System.out.print("Digite uma data no formato DD/MM/AAAA: ");
                try {
                    inputDate = Utils.readString();
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece\n ERROR[" + e.getMessage() + "]");
                    break;
                }

                Questao8 resultQuestao8 = Questao8.isValid(inputDate);

                if (resultQuestao8.valid()) {
                    System.out.println("Data válida!");
                } else {
                    System.out.println("Data inválida, ERROR[" + resultQuestao8.error() + "]");
                }
                break;
            case 9:
                String inputDateQuestao9 = "";
                Questao9.enunciado();

                System.out.print("Digite uma data no formato DD/MM/AAAA: ");
                try {
                    inputDateQuestao9 = Utils.readString();
                } catch (Exception e) {
                    System.out.println("Valor inválido, recomece\n ERROR[" + e.getMessage() + "]");
                    break;
                }

                Questao9 resultQuestao9 = Questao9.validate(inputDateQuestao9);

                if (resultQuestao9.errorDayString().length() == 0) {
                    System.out.println("Data válida!");
                } else {
                    System.out.println("Data inválida, ERROR[" + resultQuestao9.errorDayString() + "]");
                }
                break;
            case 10:
                Questao10.enunciado();
                System.out.println("Lendo o arquivo: " + QUESTION10_FILE_NAME);

                FileReader file10 = new FileReader(QUESTION10_FILE_NAME);
                Questao10 questao10 = new Questao10(file10);
                try {
                    questao10.run();
                } catch (FileNotFoundException e) {
                    System.out.println("Erro ao executar o arquivo, ERROR[" + e.getMessage() + "]");
                    break;
                }
                questao10.showReadingResult();
                break;
            case 11:
                Questao11.enunciado();
                System.out.println("Lendo o arquivo: " + QUESTION11_FILE_NAME);

                FileReader file11 = new FileReader(QUESTION11_FILE_NAME);
                Questao11 questao11 = new Questao11(file11);
                try {
                    questao11.run();
                } catch (FileNotFoundException e) {
                    System.out.println("Erro ao executar o arquivo, ERROR[" + e.getMessage() + "]");
                    break;
                }
                questao11.showReadingResult();
                break;

            case 12:
                Questao12.enunciado();
                System.out.println("Lendo o arquivo: " + QUESTION12_FILE_NAME);

                FileReader file12 = new FileReader(QUESTION12_FILE_NAME);
                Questao12 questao12 = new Questao12(file12);
                try {
                    questao12.run();
                } catch (FileNotFoundException e) {
                    System.out.println("Erro ao executar o arquivo, ERROR[" + e.getMessage() + "]");
                    break;
                }
                questao12.showReadingResult();
                break;
            default:
                break;
        }
    }
}
