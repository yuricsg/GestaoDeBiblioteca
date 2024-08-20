package entidades;

import enumeradores.Genero;

import java.time.LocalDate;

public class Livro {

    private String codigo;
    private String titulo;
    private Autor autor;
    private LocalDate dataPublicacao;
    private Genero genero;
    private boolean disponivel;

    public Livro(String codigo, String titulo, Autor autor, LocalDate dataPublicacao, Genero genero, boolean disponivel) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.genero = genero;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public void setDisponivel (boolean disponivel){
        this.disponivel = disponivel;
    }
}
