import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> livros = new ArrayList<>();//Lista de livros disponíveis na biblioteca
    private ArrayList<Usuario> usuarios = new ArrayList<>();//Lista de usuarios cadastrados

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

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

        // Encontrar o livro pelo ISBN
        Livro livroEmprestimo = null;


        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                livroEmprestimo = livro;
                break;
            }
        }

        if (livroEmprestimo == null || !livroEmprestimo.isDisponivel()) {
            System.out.println("Livro não encontrado ou indisponível para empréstimo.");
            return;
        }

        // Encontrar o usuário pelo ID
        Usuario usuarioEmprestimo = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                usuarioEmprestimo = usuario;
                break;
            }
        }

        if (usuarioEmprestimo == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }


        livroEmprestimo.emprestar();
        usuarioEmprestimo.adicionarLivro(livroEmprestimo);
        System.out.println("Empréstimo realizado com sucesso!");


    }

    public void realizarDevolucao(String isbn, int idUsuario) {
        //Realiza a devolução de um livro por um usuário


    }

    public void exibirLivrosDisponiveis() {
        //Exibe todos os livros disponíveis para empréstimo
    }
}
