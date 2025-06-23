import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

class ApiResponse {
    List<Noticia> items;
}

public class GerenciadorDados {
    private static final Path NOTICIAS_PATH = Paths.get("noticias.json");
    private static final Path USUARIO_PATH = Paths.get("usuario.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Noticia> carregarNoticias() throws IOException, InterruptedException {
        if (!Files.exists(NOTICIAS_PATH)) {
            System.out.println("Primeira execução: Baixando notícias do IBGE para pré-carregamento...");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://servicodados.ibge.gov.br/api/v3/noticias/?qtd=100"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
            
            try (FileWriter writer = new FileWriter(NOTICIAS_PATH.toFile())) {
                gson.toJson(apiResponse.items, writer);
            }
            System.out.println("Notícias salvas localmente em 'noticias.json'.");
            return apiResponse.items;
        } else {
            System.out.println("Carregando notícias do arquivo local 'noticias.json'...");
            try (FileReader reader = new FileReader(NOTICIAS_PATH.toFile())) {
                Type tipoListaNoticias = new TypeToken<List<Noticia>>() {}.getType();
                return gson.fromJson(reader, tipoListaNoticias);
            }
        }
    }

    public Usuario carregarUsuario(Scanner scanner) throws IOException {
        if (Files.exists(USUARIO_PATH)) {
            try (FileReader reader = new FileReader(USUARIO_PATH.toFile())) {
                return gson.fromJson(reader, Usuario.class);
            }
        } else {
            System.out.print("Bem-vindo! Parece ser seu primeiro acesso. Digite seu nome ou apelido: ");
            String nome = scanner.nextLine();
            Usuario novoUsuario = new Usuario(nome);
            salvarUsuario(novoUsuario);
            return novoUsuario;
        }
    }

    public void salvarUsuario(Usuario usuario) throws IOException {
        try (FileWriter writer = new FileWriter(USUARIO_PATH.toFile())) {
            gson.toJson(usuario, writer);
        }
    }
}