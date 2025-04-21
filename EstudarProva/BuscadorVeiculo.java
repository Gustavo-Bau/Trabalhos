import java.util.List;

public class BuscadorVeiculos {
    
    public static Veiculo buscarPorModelo(String modelo, List<Veiculo> veiculos) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                return veiculo;
            }
        }
        return null;
    }

    public static Veiculo buscarPorMarca(String marca, List<Veiculo> veiculos) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMarca().equalsIgnoreCase(marca)) {
                return veiculo;
            }
        }
        return null;
    }
}