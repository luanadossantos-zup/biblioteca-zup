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

        for (int i = 0; i < getLivros().size();i++) {

        }




        livros.remove(0);

    }

    public void realizarDevolucao(String isbn, int idUsuario) {
        //Realiza a devolução de um livro por um usuário
    }

    public void exibirLivrosDisponiveis() {
        //Exibe todos os livros disponíveis para empréstimo
    }
}
