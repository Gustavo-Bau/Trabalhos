public class Mecanico {
    private String nome;
    private boolean disponivel;

    public Mecanico(String nome) {
        this.nome = nome;
        this.disponivel = true;
    }

    // Getters e Setters
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    // ... outros getters e setters
}