import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class BlogTerminal {

    private static List<Noticia> todasNoticias;
    private static Usuario usuario;
    private static final GerenciadorDados gerenciador = new GerenciadorDados();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            todasNoticias = gerenciador.carregarNoticias();
            usuario = gerenciador.carregarUsuario(scanner);
            if (usuario.getNoticiasFavoritas().isEmpty() &&
                usuario.getNoticiasLidas().isEmpty() &&
                usuario.getNoticiasParaLerDepois().isEmpty()) {
              
                if (todasNoticias != null && todasNoticias.size() >= 3) {
                    System.out.println("\nComo este é seu primeiro acesso, adicionamos algumas notícias em suas listas para você conhecer as funcionalidades!");
                    Noticia noticiaFavorita = todasNoticias.get(0);
                    usuario.adicionarFavorito(noticiaFavorita.getId());
                    Noticia noticiaLida = todasNoticias.get(1);
                    usuario.marcarComoLida(noticiaLida.getId());
                    Noticia noticiaParaLer = todasNoticias.get(2);
                    usuario.adicionarParaLerDepois(noticiaParaLer.getId());
                    gerenciador.salvarUsuario(usuario);
                }
            }
            System.out.println("\nBem-vindo ao Blog de Notícias do IBGE, " + usuario.getNome() + "!");
            loopPrincipal();
        } catch (IOException | InterruptedException e) {
            System.err.println("ERRO CRÍTICO: Não foi possível carregar os dados. Verifique sua conexão ou o arquivo local.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado. O programa será encerrado.");
            e.printStackTrace();
        } finally {
            scanner.close();
            System.out.println("\nObrigado por usar o Blog do IBGE!");
        }
    }

    private static void loopPrincipal() {
        boolean sair = false;
        while (!sair) {
            exibirMenuPrincipal();
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: buscarNoticias(); break;
                    case 2: gerenciarFavoritos(); break;
                    case 3: marcarComoLida(); break;
                    case 4: gerenciarLerDepois(); break;
                    case 5: exibirListasUsuario(); break;
                    case 0: sair = true; break;
                    default: System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
            } catch (Exception e) {
                System.err.println("Ocorreu um erro na operação: " + e.getMessage());
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Procurar Notícias");
        System.out.println("2. Gerenciar Favoritos");
        System.out.println("3. Marcar Notícia como 'Lida'");
        System.out.println("4. Gerenciar Lista 'Para Ler Depois'");
        System.out.println("5. Exibir Minhas Listas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void buscarNoticias() {
        System.out.println("\n--- Procurar Notícias ---");
        System.out.println("Buscar por (1) Título/Palavra-chave ou (2) Data (formato DD/MM/AAAA)?");
        System.out.print("Opção: ");
        String tipoBusca = scanner.nextLine();
        System.out.print("Digite o termo da busca: ");
        String termo = scanner.nextLine().toLowerCase();

        List<Noticia> resultados;
        if ("1".equals(tipoBusca)) {
            resultados = todasNoticias.stream()
                .filter(n -> n.getTitulo().toLowerCase().contains(termo) || n.getIntroducao().toLowerCase().contains(termo))
                .collect(Collectors.toList());
        } else if ("2".equals(tipoBusca)) {
            resultados = todasNoticias.stream()
                .filter(n -> n.getDataPublicacao().startsWith(termo))
                .collect(Collectors.toList());
        } else {
            System.out.println("Tipo de busca inválido.");
            return;
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhuma notícia encontrada com o termo '" + termo + "'.");
        } else {
            System.out.println("\nResultados da busca (" + resultados.size() + " encontrados):");
            imprimirListaOrdenada(resultados);
        }
    }

    private static void gerenciarFavoritos() {
        System.out.println("\n--- Gerenciar Favoritos ---");
        System.out.println("(1) Adicionar ou (2) Remover favorito?");
        System.out.print("Opção: ");
        String opcao = scanner.nextLine();
        System.out.print("Digite o ID da notícia: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (todasNoticias.stream().noneMatch(n -> n.getId() == id)) {
                System.out.println("ID de notícia inválido.");
                return;
            }

            if ("1".equals(opcao)) {
                usuario.adicionarFavorito(id);
                System.out.println("Notícia #" + id + " adicionada aos favoritos.");
            } else if ("2".equals(opcao)) {
                usuario.removerFavorito(id);
                System.out.println("Notícia #" + id + " removida dos favoritos.");
            } else {
                System.out.println("Opção inválida.");
                return;
            }
            gerenciador.salvarUsuario(usuario);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Digite um número.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os favoritos.");
        }
    }

    private static void marcarComoLida() {
        System.out.print("\nDigite o ID da notícia para marcar como 'Lida': ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
             if (todasNoticias.stream().noneMatch(n -> n.getId() == id)) {
                System.out.println("ID de notícia inválido.");
                return;
            }
            usuario.marcarComoLida(id);
            if (usuario.getNoticiasParaLerDepois().contains(id)) {
                usuario.removerParaLerDepois(id);
                System.out.println("Notícia #" + id + " também foi removida da lista 'Para Ler Depois'.");
            }
            System.out.println("Notícia #" + id + " marcada como lida.");
            gerenciador.salvarUsuario(usuario);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Digite um número.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a lista de lidas.");
        }
    }

    private static void gerenciarLerDepois() {
         System.out.println("\n--- Gerenciar 'Para Ler Depois' ---");
        System.out.println("(1) Adicionar ou (2) Remover da lista?");
        System.out.print("Opção: ");
        String opcao = scanner.nextLine();
        System.out.print("Digite o ID da notícia: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
             if (todasNoticias.stream().noneMatch(n -> n.getId() == id)) {
                System.out.println("ID de notícia inválido.");
                return;
            }

            if ("1".equals(opcao)) {
                usuario.adicionarParaLerDepois(id);
                System.out.println("Notícia #" + id + " adicionada à lista 'Para Ler Depois'.");
            } else if ("2".equals(opcao)) {
                usuario.removerParaLerDepois(id);
                System.out.println("Notícia #" + id + " removida da lista.");
            } else {
                System.out.println("Opção inválida.");
                return;
            }
            gerenciador.salvarUsuario(usuario);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Digite um número.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a lista 'Para Ler Depois'.");
        }
    }

    private static void exibirListasUsuario() {
        System.out.println("\n--- Exibir Minhas Listas ---");
        System.out.println("Qual lista deseja exibir?");
        System.out.println("1. Favoritos");
        System.out.println("2. Lidas");
        System.out.println("3. Para Ler Depois");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            Set<Integer> ids;
            String nomeLista;

            switch(opcao) {
                case 1: ids = usuario.getNoticiasFavoritas(); nomeLista = "Favoritos"; break;
                case 2: ids = usuario.getNoticiasLidas(); nomeLista = "Lidas"; break;
                case 3: ids = usuario.getNoticiasParaLerDepois(); nomeLista = "Para Ler Depois"; break;
                default: System.out.println("Opção inválida."); return;
            }

            if (ids.isEmpty()) {
                System.out.println("\nA lista '" + nomeLista + "' está vazia.");
                return;
            }

            List<Noticia> listaParaExibir = todasNoticias.stream()
                .filter(n -> ids.contains(n.getId()))
                .collect(Collectors.toList());

            System.out.println("\nExibindo lista: " + nomeLista);
            imprimirListaOrdenada(listaParaExibir);

        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Digite um número.");
        }
    }

    private static void imprimirListaOrdenada(List<Noticia> noticias) {
        if (noticias == null || noticias.isEmpty()) {
            return;
        }

        System.out.println("\nComo deseja ordenar a lista?");
        System.out.println("1. Ordem Alfabética (Título)");
        System.out.println("2. Data de Publicação (Mais recentes primeiro)");
        System.out.println("3. Tipo/Categoria");
        System.out.print("Opção de ordenação: ");

        try {
            int sortOption = Integer.parseInt(scanner.nextLine());
            switch (sortOption) {
                case 1: noticias.sort(Comparator.comparing(Noticia::getTitulo, String.CASE_INSENSITIVE_ORDER)); break;
                case 2: noticias.sort(Comparator.comparing(Noticia::getDataPublicacao).reversed()); break;
                case 3: noticias.sort(Comparator.comparing(Noticia::getTipo)); break;
                default: System.out.println("Opção de ordenação inválida. Exibindo na ordem padrão.");
            }
        } catch (NumberFormatException e) {
             System.out.println("Opção de ordenação inválida. Exibindo na ordem padrão.");
        }

        noticias.forEach(Noticia::exibir);
    }
}