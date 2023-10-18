package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excessoes.ErroConvercaoAnoException;
import br.com.alura.screenmatch.modelos.GeradorJson;
import br.com.alura.screenmatch.modelos.RequisicaoOmdb;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um Filme Para Busca: ");
        String nomeDoTitulo = "";
        List<Titulo> titulos = new ArrayList<>();


        while (!nomeDoTitulo.equalsIgnoreCase("sair")) {
            nomeDoTitulo = leitura.nextLine();

            if (nomeDoTitulo.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                RequisicaoOmdb requisicaoOmdb = new RequisicaoOmdb();

                Titulo novoTitulo = new Titulo(requisicaoOmdb.pesquisaTitulo(nomeDoTitulo));

                titulos.add(novoTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroConvercaoAnoException e) {
                throw new RuntimeException(e);
            }
        }
        GeradorJson gerador = new GeradorJson();
        gerador.gerarJson(titulos);

        System.out.println(titulos);
        System.out.println("Programa finalizou corretamente!");
    }

}