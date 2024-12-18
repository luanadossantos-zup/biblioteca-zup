import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Livro> livros = new ArrayList<>();//Lista de livros disponíveis na biblioteca
    ArrayList<Usuario> usuarios = new ArrayList<>();//Lista de usuarios cadastrados


    public void cadastrarLivro(Livro livro) {
        //Adiciona um livro à lista de livros
        livros.add(livro);
    }

    public void cadastrarUsuario (Usuario usuario) {
        //Adiciona um usuario à lista de usuarios
        usuarios.add(usuario);
    }

    public void realizarEmprestimo(String isbn, int idUsuario) {
        //Realiza o empréstimo de um livro para um usuário

    }

    public void realizarDevolucao(String isbn, int idUsuario) {
        //Realiza a devolução de um livro por um usuário
    }

    public void exibirLivrosDisponiveis() {
        //Exibe todos os livros disponíveis para empréstimo
    }
}
