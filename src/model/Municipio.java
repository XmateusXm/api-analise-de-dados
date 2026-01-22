package model;

public class Municipio {
    private String nome;
    private String uf;

    public Municipio(String nome,  String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString(){
        return String.format("%-30s | %-2s", nome, uf);
    }
}
