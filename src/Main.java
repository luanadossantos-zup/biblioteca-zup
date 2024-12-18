import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        int escolhaUsuarioMenu;

        escolhaUsuarioMenu = menuDeBoasVindas();
        exibeProgramaEscolhidoMenu(escolhaUsuarioMenu);



    }


    public static int  menuDeBoasVindas() {
        Scanner scanner = new Scanner(System.in);
        int escolhaUsuarioMenu = 0;

        do {
            System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca Zup!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Realizar empréstimo");
            System.out.println("4 - Realizar devolução");
            System.out.println("5 - Exibir livros disponíveis");
            System.out.println("6 - Sair");

            try {
                escolhaUsuarioMenu = scanner.nextInt();

                if (escolhaUsuarioMenu > 6 || escolhaUsuarioMenu <0) {
                    System.out.println("-------------------------------------");
                    System.out.println("Por favor, apenas números de 1 a 6!");
                    System.out.println("-------------------------------------");
                }

            } catch (Exception e) {
                System.out.println("-------------------------------------");
                System.out.println("Por favor, apenas números de 1 a 6!");
                System.out.println("-------------------------------------");
                scanner.next();
            }
        } while (escolhaUsuarioMenu > 6 || escolhaUsuarioMenu < 0);

        scanner.close();
        return escolhaUsuarioMenu;

    }


    public static void exibeProgramaEscolhidoMenu(int escolhaUsuario) {
        Scanner scanner = new Scanner(System.in);
        String nomeDoLivro;
        String autorDoLivro;
        int isbn;
        switch (escolhaUsuario) {

            case 1 :
                System.out.println("Por favor, digite os dados que pede a seguir:");
                System.out.println("Digite o título do livro: ");
                nomeDoLivro = scanner.next();
                System.out.println("Digite ");

        }
    }
}


