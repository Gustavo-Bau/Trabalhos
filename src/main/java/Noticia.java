import com.google.gson.annotations.SerializedName;

public class Noticia {
    private int id;
    private String tipo;
    private String titulo;
    private String introducao;
    @SerializedName("data_publicacao")
    private String dataPublicacao;
    private String link;

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getTitulo() { return titulo; }
    public String getIntroducao() { return introducao; }
    public String getDataPublicacao() { return dataPublicacao; }
    public String getLink() { return link; }

    public void exibir() {
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Publicação: " + dataPublicacao);
        System.out.println("Introdução: " + introducao);
        System.out.println("Link: " + link);
        System.out.println("Fonte: IBGE");
        System.out.println("--------------------------------------------------");
    }
}