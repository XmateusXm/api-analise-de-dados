import model.Municipio;
import service.Menu;
import service.ibgeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        ibgeService service = new ibgeService();
        

        // Escolha a UF que você quer buscar
        String uf = "RJ";

        List<Municipio> municipios = service.buscarMunicipios(uf);
        Menu menu = new Menu();
        menu.exibirMenu(municipios);

        System.out.println("Total de municípios de " + uf + ": " + municipios.size());
        System.out.println("--------------------------------");

        for (Municipio m : municipios) {
            System.out.println(m.getNome());
        }
    }
    public static void contarMunicipiosPorEstado(List<Municipio> municipios) {
        Map<String, Integer> contagem = new HashMap<>();

        for (Municipio m : municipios) {
            contagem.put(m.getUf(), contagem.getOrDefault(m.getUf(), 0) + 1);
        }

        System.out.println("\n=== Quantidade de Municipios por Estado ===");
        for (String uf : contagem.keySet()) {
            System.out.println(uf + ": " + contagem.get(uf));
        }
    }
}
