package br.com.alura.screenmatch.excessoes;

public class ErroConvercaoAnoException extends RuntimeException {
    private String mensagem;

    public ErroConvercaoAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }
}
