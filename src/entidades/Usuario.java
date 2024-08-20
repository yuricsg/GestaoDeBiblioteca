package entidades;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private String nome;
    private String email;
    private Map<Livro, LocalDate> livrosEmprestados;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.livrosEmprestados = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Livro, LocalDate> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void emprestarLivro(Livro livro, LocalDate dataDevolucao){
        if(livro.isDisponivel()){
            livrosEmprestados.put(livro, dataDevolucao);
            livro.setDisponivel(false);
        }else{
            System.out.println("O livro não está disponível.");
        }

    public void devolverLivro(Livro livro){
            if(livrosEmprestados.containsKey(livro)){
                livrosEmprestados.remove(livro);
                livro.setDisponivel(true);
            }else{
                System.out.println("O livro não foi emprestado pelo usuário");
            }
        }

    }


}
