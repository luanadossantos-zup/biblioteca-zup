import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Biblioteca {

    private ArrayList<Livro> livros = new ArrayList<>();//Lista de livros disponíveis na biblioteca
    private ArrayList<Usuario> usuarios = new ArrayList<>();//Lista de usuarios cadastrados



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
                livros.remove(livro);

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


        Livro livroDevolucao = null;
        Usuario usuarioDevolvendo = null;


        for (Usuario usuario: usuarios) {
            if (idUsuario == usuario.getId()) {
                usuarioDevolvendo = usuario;
                break;
            }

        }

        if (usuarioDevolvendo == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }


        if (usuarioDevolvendo.getLivrosEmprestados().size() == 3) {
            System.out.println("Usuário não pode retirar mais que 3 livros por vez!");


        } else {
            for (Livro livro: usuarioDevolvendo.getLivrosEmprestados()) {
                if (Objects.equals(livro.getIsbn(), isbn)) {
                    livroDevolucao = livro;
                    livros.add(livroDevolucao);
                    livroDevolucao.setDisponivel(true);
                    break;
                }
            }

            if (livroDevolucao == null || !livroDevolucao.isDisponivel()) {
                System.out.println("Livro não encontrado ou indisponível para empréstimo.");
                return;
            }

            livroDevolucao.devolver();
            usuarioDevolvendo.removerLivro(livroDevolucao);
        }


    }

    public void exibirLivrosDisponiveis() {
        //Exibe todos os livros disponíveis para empréstimo
        System.out.println("Abaixo segue livros disponíveis para empréstimo:");
        System.out.println(" ");

        boolean haLivrosDisponiveis = false;
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println(" ");
                haLivrosDisponiveis = true;
            }
        }

        if (!haLivrosDisponiveis) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public void salvarArraysEmTXT ()  {
        //Salva dados de livros e usuários em arquivos de texto na pasta raiz

        try {
            FileWriter writer = new FileWriter("livrosdisponiveis.txt");
            for(Livro livro: livros) {
                writer.write(livro.getTitulo() + System.lineSeparator() + livro.getIsbn() + System.lineSeparator());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar TXT de livros");
        }


        try {
            FileWriter writer = new FileWriter("usuarios.txt");
            for(Usuario usuario: usuarios) {
                writer.write(usuario.getNome() + System.lineSeparator() + usuario.getId() + System.lineSeparator());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar TXT de usuarios");
        }
    }
}
