import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String nome;
    private Set<Integer> noticiasFavoritas;
    private Set<Integer> noticiasLidas;
    private Set<Integer> noticiasParaLerDepois;

    public Usuario(String nome) {
        this.nome = nome;
        this.noticiasFavoritas = new HashSet<>();
        this.noticiasLidas = new HashSet<>();
        this.noticiasParaLerDepois = new HashSet<>();
    }

    public String getNome() { return nome; }
    public Set<Integer> getNoticiasFavoritas() { return noticiasFavoritas; }
    public Set<Integer> getNoticiasLidas() { return noticiasLidas; }
    public Set<Integer> getNoticiasParaLerDepois() { return noticiasParaLerDepois; }

    public void adicionarFavorito(int id) { noticiasFavoritas.add(id); }
    public void removerFavorito(int id) { noticiasFavoritas.remove(id); }
    public void marcarComoLida(int id) { noticiasLidas.add(id); }
    public void adicionarParaLerDepois(int id) { noticiasParaLerDepois.add(id); }
    public void removerParaLerDepois(int id) { noticiasParaLerDepois.remove(id); }
}