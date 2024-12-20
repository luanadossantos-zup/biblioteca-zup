import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        menuDeBoasVindas();


    }


    public static void menuDeBoasVindas() {
        Scanner scanner = new Scanner(System.in);
        int escolhaUsuarioMenu = 0;
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario();
        Livro livro = new Livro();


        do {
            System.out.println(" ");
            System.out.println("--------------------------------------------------------");
            System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca Zup!");
            System.out.println("--------------------------------------------------------");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Realizar empréstimo");
            System.out.println("4 - Realizar devolução");
            System.out.println("5 - Exibir livros disponíveis");
            System.out.println("6 - Sair");
            System.out.println("--------------------------------------------------------");

            try {
                escolhaUsuarioMenu = scanner.nextInt();
                scanner.nextLine();

                if (escolhaUsuarioMenu > 6 || escolhaUsuarioMenu < 0) {
                    System.out.println("-------------------------------------");
                    System.out.println("Por favor, apenas números de 1 a 6!");
                    System.out.println("-------------------------------------");
                    continue;
                }

            } catch (Exception e) {
                System.out.println("-------------------------------------");
                System.out.println("Por favor, apenas números de 1 a 6!");
                System.out.println("-------------------------------------");
                scanner.next();
                continue;
            }

            switch (escolhaUsuarioMenu) {

                case 1:
                    //Cadastro de livro
                    cadastroDeLivro(scanner, livro, biblioteca);
                    break;

                case 2:
                    //Cadastro de usuário
                    cadastroDeUsuario(scanner, usuario, biblioteca);
                    break;

                case 3:
                    //Realizar empréstimo de livro
                    emprestimoDeLivro(scanner,biblioteca);
                    break;

                case 4:
                    //Realiza devolução do livro
                    devolucaoDeLivro(scanner,biblioteca);
                    break;

                case 5:
                    //Exibe livros disponíveis
                    biblioteca.exibirLivrosDisponiveis();
                    break;

                case 6:
                    biblioteca.salvarArraysEmTXT();
                    System.exit(0);

            }

        } while (true);
    }


    public static void cadastroDeLivro (Scanner scanner, Livro livro, Biblioteca biblioteca){
        System.out.println("Digite o título do livro:");
        String nomeDoLivro = scanner.nextLine();

        System.out.println("Digite o autor do livro:");
        String autorDoLivro = scanner.nextLine();

        System.out.println("Digite o ISBN do livro:");
        String isbnCadastro = scanner.nextLine();


        livro.setTitulo(nomeDoLivro);
        livro.setAutor(autorDoLivro);
        livro.setIsbn(isbnCadastro);
        livro.setDisponivel(true);

        biblioteca.cadastrarLivro(livro);
    }

    public static void cadastroDeUsuario (Scanner scanner, Usuario usuario, Biblioteca biblioteca) {
        System.out.println("Digite o nome do usuário:");
        String nomeDoUsuario = scanner.nextLine();
        usuario.setNome(nomeDoUsuario);

        System.out.println("Digite ID do usuário:");
        int idCadastroDoUsuario = scanner.nextInt();
        usuario.setId(idCadastroDoUsuario);

        biblioteca.cadastrarUsuario(usuario);
    }

    public static void emprestimoDeLivro (Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Digite o ISBN do livro:");
        String isbnEmprestimo = scanner.nextLine();
        System.out.println("Digite o ID do usuario:");
        int idEmprestimoUsuario = scanner.nextInt();
        scanner.nextLine();

        biblioteca.realizarEmprestimo(isbnEmprestimo, idEmprestimoUsuario);
    }

    public static void devolucaoDeLivro (Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Digite o ISBN do livro:");
        String isbnDevolucao = scanner.nextLine();
        System.out.println("Digite o ID do usuario:");
        int idUsuarioDevolucao = scanner.nextInt();

        biblioteca.realizarDevolucao(isbnDevolucao,idUsuarioDevolucao);
    }
}




