import java.util.ArrayList;

public class Usuario {

    private String nome;
    private int id;
    ArrayList<Livro> livrosEmprestados = new ArrayList<>();



    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(ArrayList<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void exibirDetalhes() {
        //Exibe as informações do Usuário
    }

    public void adicionarLivro(Livro livro) {
        //Adiciona um livro a lista de livros emprestados
        livrosEmprestados.add(livro);
    }

    public void removerLivro(Livro livro) {
        //Remove um livro da lista de livros emprestados
        livrosEmprestados.remove(livro);
    }
}
