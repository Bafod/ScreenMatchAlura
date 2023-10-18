package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excessoes.ErroConvercaoAnoException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RequisicaoOmdb {
    public TituloOMDB pesquisaTitulo(String nomeDoTitulo) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                setPrettyPrinting().
                create();
        TituloOMDB novoTituloOMDB;

        String endereco = "http://www.omdbapi.com/?t=" + nomeDoTitulo.replace(" ", "+") + "&apikey=1948892b";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        novoTituloOMDB = gson.fromJson(json, TituloOMDB.class);

        return novoTituloOMDB;

    }
}

