package entidades;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    private Map<String, Livro> livros;
    private Map<String, Usuario> usuarios;

    public Biblioteca() {
        this.livros = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.put(livro.getCodigo(), livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }

    public void emprestarLivro(String codigoLivro, String emailUsuario, LocalDate dataDevolucao) {
        Livro livro = livros.get(codigoLivro);
        Usuario usuario = usuarios.get(emailUsuario);
        if (livro != null && usuario != null) {
            usuario.emprestarLivro(livro, dataDevolucao);
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public void devolverLivro(String codigoLivro, String emailUsuario) {
        Livro livro = livros.get(codigoLivro);
        Usuario usuario = usuarios.get(emailUsuario);
        if (livro != null && usuario != null) {
            usuario.devolverLivro(livro);
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public void relatorioLivrosDisponiveis(){
        for(Livro livro : livros.values()){
            if(livro.isDisponivel()){
                System.out.println(livro.getTitulo() + " - " + livro.getAutor().getNome());
            }
        }
    }

    public void relatorioLivrosEmprestados() {
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            Usuario usuario = entry.getValue();
            for (Map.Entry<Livro, LocalDate> emprestimo : usuario.getLivrosEmprestados().entrySet()) {
                Livro livro = emprestimo.getKey();
                LocalDate dataDevolucao = emprestimo.getValue();
                System.out.println(livro.getTitulo() + " emprestado para " + usuario.getNome() +
                        " até " + dataDevolucao);
            }
        }
    }
}
