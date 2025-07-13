import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual seu ano de nascimento?");
        int anoNascimento = entrada.nextInt();

        System.out.println("Qual seu mês de nascimento?");
        int mesNascimento = entrada.nextInt();

        System.out.println("Qual seu dia de nascimento?");
        int diaNascimento = entrada.nextInt();

        int anoAtual = 2023;
        int mesAtual = 7;  // Julho
        int diaAtual = 13;

        int idadeAnos = anoAtual - anoNascimento;
        int idadeMeses = mesAtual - mesNascimento;
        int idadeDias = diaAtual - diaNascimento;

        // Ajuste para meses/dias negativos
        if (idadeDias < 0) {
            idadeMeses -= 1;
            idadeDias += 30; // Aproximação
        }
        if (idadeMeses < 0) {
            idadeAnos -= 1;
            idadeMeses += 12;
        }

        System.out.println("Você tem " + idadeAnos + " anos, " + idadeMeses + " meses, e " + idadeDias + " dias de vida.");

        entrada.close();
    }
}
