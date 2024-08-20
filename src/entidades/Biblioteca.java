package entidades;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    private final HashMap<Object, Object> usuarios;
    private Map<String, Livro> livros;
    private Map<String, Usuario> usuarios;

    public Biblioteca() {
        this.livros = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void adicionarLivro(Livro livro){
        livros.put(livro.getCodigo(), livro);
    }

    public void adicionarUsuario(Usuario usuario){
        usuarios.put(usuario.getEmail(), usuario);
    }

    public void

}
