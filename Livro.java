package SistemaDeLivraria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livro {
    private int id;
    private String tituloLivro;
    private String autor;
    private boolean disponivel = true;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(int id, String tituloLivro, String autor, boolean disponivel, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        setId(id);
        setTituloLivro(tituloLivro);
        setAutor(autor);
        setDisponivel(disponivel);
        setDataCadastro(dataCadastro);
        setDataAtualizacao(dataAtualizacao);
    }

    // Getter e Setter para ID
    public int getId() {
        return this.id;
    }

    public void setId(int idLivro) {
        if (idLivro <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo.");
        }
        this.id = idLivro;
    }

    // Getter e Setter para Título
    public String getTituloLivro() {
        return this.tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        if (tituloLivro == null || tituloLivro.isEmpty()) {
            throw new IllegalArgumentException("O título do livro não deve ser nulo ou vazio.");
        }
        this.tituloLivro = tituloLivro;
    }

    // Getter e Setter para Autor
    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autorLivro) {
        if (autorLivro == null || autorLivro.isEmpty()) {
            throw new IllegalArgumentException("O nome do autor não deve ser nulo ou vazio.");
        }
        this.autor = autorLivro;
    }

    // Getter e Setter para Disponível
    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Getter e Setter para Data de Cadastro
    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        if (dataCadastro == null) {
            throw new IllegalArgumentException("A data de cadastro não pode ser nula.");
        }
        this.dataCadastro = dataCadastro;
    }

    // Getter e Setter para Data de Atualização
    public LocalDate getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        if (dataAtualizacao == null) {
            throw new IllegalArgumentException("A data de atualização não pode ser nula.");
        }
        this.dataAtualizacao = dataAtualizacao;
    }

    // Método para exibir os dados do livro
    public void exibirInformacoes() {
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("ID: " + id);
        System.out.println("Título: " + tituloLivro);
        System.out.println("Autor: " + autor);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("Data de Cadastro: " + dataCadastro.format(formatoBR));
        System.out.println("Data de Atualização: " + dataAtualizacao.format(formatoBR));
    }
}
