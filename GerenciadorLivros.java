package SistemaDeLivraria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorLivros {
    private List<Livro> listaLivros = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Adicionar livro
    public void adicionarLivro(Livro livroRecebido) {
        listaLivros.add(livroRecebido);
    }

    // Listar livros disponíveis
    public void listarLivrosDisponiveis() {
        boolean encontrou = false;
        for (Livro livro : listaLivros) {
            if (livro.getDisponivel()) {
                livro.exibirInformacoes();
                System.out.println("--------------------------");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    // Realizar empréstimo
    public void realizarEmprestimo() {
        System.out.println("\nLivros disponíveis para empréstimo:");
        for (Livro livro : listaLivros) {
            if (livro.getDisponivel()) {
                System.out.println("Título: " + livro.getTituloLivro() + " | ID: " + livro.getId());
            }
        }

        System.out.println("\nEscolha uma opção para realizar o empréstimo: 1 - ID | 2 - Nome do Livro");
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpa buffer

        boolean livroEncontrado = false;

        if (opcao == 1) {
            System.out.println("Informe o ID do livro:");
            int idLivro = sc.nextInt();

            for (Livro livro : listaLivros) {
                if (livro.getId() == idLivro) {
                    if (livro.getDisponivel()) {
                        livro.setDisponivel(false);
                        livro.setDataAtualizacao(LocalDate.now());
                        System.out.println("Empréstimo realizado com sucesso do livro: " + livro.getTituloLivro());
                    } else {
                        System.out.println("Este livro já está emprestado.");
                    }
                    livroEncontrado = true;
                    break;
                }
            }

            if (!livroEncontrado) {
                System.out.println("Livro com ID " + idLivro + " não encontrado.");
            }

        } else if (opcao == 2) {
            System.out.println("Informe o título do livro:");
            String nomeLivro = sc.nextLine();

            for (Livro livro : listaLivros) {
                if (livro.getTituloLivro().equalsIgnoreCase(nomeLivro)) {
                    if (livro.getDisponivel()) {
                        livro.setDisponivel(false);
                        livro.setDataAtualizacao(LocalDate.now());
                        System.out.println("Empréstimo realizado com sucesso do livro: " + livro.getTituloLivro());
                    } else {
                        System.out.println("Este livro já está emprestado.");
                    }
                    livroEncontrado = true;
                    break;
                }
            }

            if (!livroEncontrado) {
                System.out.println("Livro com título '" + nomeLivro + "' não encontrado.");
            }

        } else {
            System.out.println("Opção inválida.");
        }
    }

    // Realizar devolução
    public void realizarDevolucao() {
        System.out.println("\nInforme o ID do livro que deseja devolver:");
        int idLivro = sc.nextInt();

        boolean livroEncontrado = false;

        for (Livro livro : listaLivros) {
            if (livro.getId() == idLivro) {
                if (!livro.getDisponivel()) {
                    livro.setDisponivel(true);
                    livro.setDataAtualizacao(LocalDate.now());
                    System.out.println("Devolução realizada com sucesso do livro: " + livro.getTituloLivro());
                } else {
                    System.out.println("Este livro já estava disponível.");
                }
                livroEncontrado = true;
                break;
            }
        }

        if (!livroEncontrado) {
            System.out.println("Livro com ID " + idLivro + " não encontrado.");
        }
    }

    // Menu
    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== Sistema de Livraria =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros Disponíveis");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Realizar Devolução");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivrosDisponiveis();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    realizarDevolucao();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);
    }

    // Método auxiliar para cadastrar livro
    private void cadastrarLivro() {
        System.out.println("\n=== Cadastro de Livro ===");

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        LocalDate dataHoje = LocalDate.now();

        Livro novoLivro = new Livro(
                id,
                titulo,
                autor,
                true, // sempre disponível ao cadastrar
                dataHoje,
                dataHoje
        );

        adicionarLivro(novoLivro);
        System.out.println("Livro cadastrado com sucesso!");
    }
}
