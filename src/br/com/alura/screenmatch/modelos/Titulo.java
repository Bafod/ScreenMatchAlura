package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excessoes.ErroConvercaoAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;
    private boolean incluiNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOMDB novoTituloOMDB) {
        this.nome = novoTituloOMDB.title();

        if(novoTituloOMDB.year().length() >4){
            throw new ErroConvercaoAnoException("Não consegui converter o Ano, "+
                    "Porque tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(novoTituloOMDB.year());
        this.duracaoEmMinutos = Integer.valueOf(novoTituloOMDB.runtime().substring(0,3));
    }

    @Override
    public String toString() {
        return "Titulo: " + nome + '\'' +
                ", Ano De Lancamento: " + anoDeLancamento +
                ", Duracao Em Minutos: " + duracaoEmMinutos;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIncluiNoPlano(boolean incluiNoPlano) {
        this.incluiNoPlano = incluiNoPlano;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
    //Getters
    public int getTotalDeAvaliacao(){
        return totalDeAvaliacao;
    }
    public String getNome() {
        return nome;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public boolean isIncluiNoPlano() {
        return incluiNoPlano;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome Do Titulo: " + nome);
        System.out.println("Ano De Lançamento: " + anoDeLancamento);
        System.out.println("Duração em Minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no planp : " + incluiNoPlano);

    }
    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacao++;
    }
    public double mediaAvaliacao(){
        return somaDasAvaliacoes / totalDeAvaliacao;

    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
