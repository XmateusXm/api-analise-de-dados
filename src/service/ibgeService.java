package service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Municipio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ibgeService {

    public List<Municipio> buscarMunicipios(String uf) {
        List<Municipio> lista = new ArrayList<>();

        try {
            String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + uf + "/municipios";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonArray array = JsonParser.parseString(response.body()).getAsJsonArray();

            for (int i = 0; i < array.size(); i++) {
                JsonObject obj = array.get(i).getAsJsonObject();
                String nome = obj.get("nome").getAsString();

                Municipio m = new Municipio(nome, uf);
                lista.add(m);


            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public List<Municipio> buscarMunicipios() {

        return List.of();
    }
}
