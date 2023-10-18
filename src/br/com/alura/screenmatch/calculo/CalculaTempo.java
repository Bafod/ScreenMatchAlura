package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculaTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }
      public void inclui(Titulo t){
          System.out.println("Adicionando Duração em Minutos de: " + t);
        tempoTotal += t.getDuracaoEmMinutos();
      }
//    public void inclui(Filme f){
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void inclui(Serie s){
//        tempoTotal += s.getDuracaoEmMinutos();
//    }
}
