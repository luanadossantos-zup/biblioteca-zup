public class Livro {

    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }



    public void exibirDetalhes() {
        //Exibe informações do livro
    }

    public void emprestar() {
        //Marca o livro como indisponível
        setDisponivel(false);
    }

    public void devolver() {
        //Marca o livro como disponível
    }
}
