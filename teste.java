import java.util.Scanner;
public class teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Scanner para ler a entrada do usuário
        // Usuario deve inserir informações

        // Qual sua idade
        System.out.print("Qual a sua idade? ");
        int idadeUsuario = scanner.nextInt();


        // Qual a idade da sua mae 
        System.out.print("Qual a idade da sua mãe? ");
        int idadeMae = scanner.nextInt();

        //imprime as informações inseridas pelo usuário
        

        // Informação idade usuario
        System.out.println("Sua idade eh: " + idadeUsuario);

        // Informação idade mãe usuario
        System.out.println("A idade de sua mae eh: " + idadeMae); 



        // Imprime a informação  " Minha mae e x anos mais velha que eu "
        int diferencaidade = 20 - 15; 
        System.out.println("Minha mãe é " + diferencaidade + " anos mais velha que eu.");

        // Fecha o scanner
        scanner.close();
}
}
