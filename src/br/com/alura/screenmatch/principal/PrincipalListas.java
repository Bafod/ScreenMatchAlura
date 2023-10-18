package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PrincipalListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O Poderoso Chefão", 1970);
        filme1.avalia(8);
        Filme filme2 = new Filme("Avatar", 2023);
        filme2.avalia(6);
        var filme3 = new Filme("Matrix", 1999);
        filme3.avalia(9.5);
        Serie lost = new Serie("Lost", 2000);

        List<Titulo> lista = new LinkedList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(lost);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 3){
                System.out.println("Classificacao: "+ filme.getClassificacao());
            }
        }
        Collections.sort(lista);
        System.out.println(lista);


    }
}
