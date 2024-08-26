package programa;


import entidades.Autor;
import entidades.Biblioteca;
import entidades.Livro;
import entidades.Usuario;
import enumeradores.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Biblioteca biblioteca = new Biblioteca();

        // Adicionar autores
        System.out.println("Cadastro de Autores");
        System.out.print("Nome do Autor: ");
        String nomeAutor = scanner.nextLine();
        Autor autor = new Autor(nomeAutor);

        // Adicionar livros
        System.out.println("\nCadastro de Livros");
        System.out.print("Código do Livro: ");
        String codigoLivro = scanner.nextLine();
        System.out.print("Título do Livro: ");
        String tituloLivro = scanner.nextLine();
        System.out.print("Data de Publicação do Livro (dd-MM-yyyy): ");
        LocalDate dataPublicacaoLivro = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Gênero do Livro (FICCAO, NAO_FICCAO, MISTERIO, FANTASIA, HISTORIA): ");
        Genero generoLivro = Genero.valueOf(scanner.nextLine().toUpperCase());
        Livro livro = new Livro(codigoLivro, tituloLivro, autor, dataPublicacaoLivro, generoLivro);

        // Adicionar usuário
        System.out.println("\nCadastro de Usuários");
        System.out.print("Nome do Usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("E-mail do Usuário: ");
        String emailUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);

        // Adicionar objetos à biblioteca
        biblioteca.adicionarLivro(livro);
        biblioteca.adicionarUsuario(usuario);

        // Emprestar livros
        System.out.println("\nEmpréstimo de Livros");
        System.out.print("Código do Livro para Empréstimo: ");
        String codigoLivroEmprestimo = scanner.nextLine();
        System.out.print("E-mail do Usuário que Emprestará o Livro: ");
        String emailUsuarioEmprestimo = scanner.nextLine();
        System.out.print("Data de Devolução (dd-MM-yyyy): ");
        LocalDate dataDevolucao = LocalDate.parse(scanner.nextLine(), formatter);
        biblioteca.emprestarLivro(codigoLivroEmprestimo, emailUsuarioEmprestimo, dataDevolucao);

        // Relatórios
        System.out.println("\nLivros Disponíveis:");
        biblioteca.relatorioLivrosDisponiveis();

        System.out.println("\nLivros Emprestados:");
        biblioteca.relatorioLivrosEmprestados();

        // Devolver livro
        System.out.println("\nDevolução de Livros");
        System.out.print("Código do Livro para Devolução: ");
        String codigoLivroDevolucao = scanner.nextLine();
        System.out.print("E-mail do Usuário que Devolverá o Livro: ");
        String emailUsuarioDevolucao = scanner.nextLine();
        biblioteca.devolverLivro(codigoLivroDevolucao, emailUsuarioDevolucao);

        // Relatórios após devolução
        System.out.println("\nLivros Disponíveis após devolução:");
        biblioteca.relatorioLivrosDisponiveis();

        System.out.println("\nLivros Emprestados após devolução:");
        biblioteca.relatorioLivrosEmprestados();

        scanner.close();

    }
}