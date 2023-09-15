import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import test.java.questao_1.Questao1Test;
import test.java.questao_2.Questao2Test;
import test.java.questao_3.Questao3Test;
import test.java.questao_4.Questao4Test;
import test.java.questao_5.Questao5Test;
import test.java.questao_6.Questao6Test;
import test.java.questao_7.Questao7Test;
import test.java.questao_8.Questao8Test;
import test.java.questao_9.Questao9Test;
import test.java.questao_10.Questao10Test;
import test.java.questao_11.Questao11Test;

public class TestRunner {

    public static void main(String[] args) {
        Result result1 = JUnitCore.runClasses(Questao1Test.class);
        Result result2 = JUnitCore.runClasses(Questao2Test.class);
        Result result3 = JUnitCore.runClasses(Questao3Test.class);
        Result result4 = JUnitCore.runClasses(Questao4Test.class);
        Result result5 = JUnitCore.runClasses(Questao5Test.class);
        Result result6 = JUnitCore.runClasses(Questao6Test.class);
        Result result7 = JUnitCore.runClasses(Questao7Test.class);
        Result result8 = JUnitCore.runClasses(Questao8Test.class);
        Result result9 = JUnitCore.runClasses(Questao9Test.class);
        Result result10 = JUnitCore.runClasses(Questao10Test.class);
        Result result11 = JUnitCore.runClasses(Questao11Test.class);

        System.out.println();
        printTestResults("Questão 1", result1);
        printTestResults("Questão 2", result2);
        printTestResults("Questão 3", result3);
        printTestResults("Questão 4", result4);
        printTestResults("Questão 5", result5);
        printTestResults("Questão 6", result6);
        printTestResults("Questão 7", result7);
        printTestResults("Questão 8", result8);
        printTestResults("Questão 9", result9);
        printTestResults("Questão 10", result10);
        printTestResults("Questão 11", result11);

        boolean todosSucesso = result1.wasSuccessful() && result2.wasSuccessful() &&
                result3.wasSuccessful() && result4.wasSuccessful() &&
                result5.wasSuccessful() && result6.wasSuccessful() &&
                result7.wasSuccessful() && result8.wasSuccessful() &&
                result9.wasSuccessful() && result10.wasSuccessful() &&
                result11.wasSuccessful();

        String resultadoFinal = todosSucesso ? "\u001B[32msim\u001B[0m" : "\u001B[31mnão\u001B[0m";

        System.out.println();
        System.out.println("Resultado: Todos os testes foram bem-sucedidos? " + resultadoFinal);
        System.out.println();
    }

    private static void printTestResults(String testName, Result result) {
        if (result.getFailures().isEmpty()) {
            System.out.println("\u001B[32m[OK]\u001B[0m " + testName + ": " + result.getRunCount()
                    + " testes executados com sucesso.");
            return;
        }

        System.out.println("\u001B[31m[FALHA]\u001B[0m " + testName + ":");
        // for (Failure failure : result.getFailures()) {
        //     System.out.println("  " + failure.toString());
        // }
        for (Failure failure : result.getFailures()) {
            String methodName = failure.getDescription().getMethodName();
            System.out.println("    - (" + methodName + ") - " + failure.getMessage() + " ❌");
        }
    }
}
