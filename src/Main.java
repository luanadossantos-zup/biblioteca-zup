import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


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


        return escolhaUsuarioMenu;

    }


    public static void exibeProgramaEscolhidoMenu(int escolhaUsuario) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario();
        Livro livro = new Livro();
        String nomeDoLivro;
        String autorDoLivro;
        String isbnCadastro;
        String nomeDoUsuario;
        int idCadastroDoUsuario;
        int idEmprestimoUsuario;
        String isbnEmprestimo;

        switch (escolhaUsuario) {

            case 1 :
                //Cadastro de livro
                System.out.println("Digite o título do livro:");
                nomeDoLivro = scanner.nextLine();
                System.out.println("Digite o autor do livro:");
                autorDoLivro = scanner.nextLine();
                System.out.println("Digite o ISBN do livro:");
                isbnCadastro = scanner.nextLine();

                livro.setTitulo(nomeDoLivro);
                livro.setAutor(autorDoLivro);
                livro.setIsbn(isbnCadastro);
                livro.setDisponivel(true);

                biblioteca.cadastrarLivro(livro);
                scanner.close();


                break;

            case 2 :
                //Cadastro de usuário
                System.out.println("Digite o nome do usuário:");
                nomeDoUsuario = scanner.nextLine();
                System.out.println("Digite ID do usuário:");
                idCadastroDoUsuario = scanner.nextInt();
                usuario.setNome(nomeDoUsuario);
                usuario.setId(idCadastroDoUsuario);

                biblioteca.cadastrarUsuario(usuario);
                scanner.close();
                break;

            case 3:
                //Realizar empréstimo de livro
                System.out.println("Digite o ISBN do livro:");
                isbnEmprestimo = scanner.nextLine();
                System.out.println("Digite o ID do usuario");
                idEmprestimoUsuario = scanner.nextInt();



                for (int i = 0; i < biblioteca.getLivros().size();i++) {
                    if (biblioteca.getLivros().get(i).getIsbn().equals(isbnEmprestimo)) {

                        biblioteca.realizarEmprestimo(isbnEmprestimo, idEmprestimoUsuario);



                    }
                }



            case 4:
                //Realiza devolução do livro


            case 5:
                //Exibe livros disponíveis


            case 6:
                System.exit(0);


        }
    }
}


