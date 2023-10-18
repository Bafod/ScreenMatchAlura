package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculo.CalculaTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O Poderoso Chefão", 1970);
        filme1.setDuracaoEmMinutos(180);

        Filme filme2 = new Filme("Avatar", 2023);
        filme2.setDuracaoEmMinutos(200);

        filme1.exibeFichaTecnica();
        filme1.avalia(7.5);
        filme1.avalia(10);
        filme1.avalia(4);

        System.out.println("Total de Avaliações: " + filme1.getTotalDeAvaliacao());
        System.out.println("Media das Avaliações: " + filme1.mediaAvaliacao());

        Serie lost = new Serie("Lost", 2000);
        lost.setTemporadas(10);
        lost.setEpPorTemp(10);
        lost.setMinPorEp(60);
        System.out.println("Tempo para Maratonar: " + lost.getDuracaoEmMinutos());
        lost.exibeFichaTecnica();

        CalculaTempo calculadora = new CalculaTempo();
        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        Episodio primeiro = new Episodio();
        primeiro.setNumero(1);
        primeiro.setTotalVisualizacoes(300);
        primeiro.setSerie(lost);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(primeiro);
        filtro.filtrar(filme1);

        var filme3 = new Filme("Matrix", 1999);
        filme3.setDuracaoEmMinutos(180);
        filme3.avalia(9.5);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);

        System.out.println("Tamanho da Lista: "+ listaDeFilmes.size());
        System.out.println("Primeiro Filme: " + listaDeFilmes.get(0));
        System.out.println(listaDeFilmes);

    }
}


