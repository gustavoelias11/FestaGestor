import model.Brinquedo;
import model.Decoracao;
import model.Item;
import repository.ItemRepository;
import service.CadastraItemService;

import java.util.List;
import java.util.Scanner;

public class FestaGestorApplication {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        CadastraItemService service = new CadastraItemService();

        int opcao = 0;

        do {
            System.out.println("---=== FESTA GESTOR ===---");
            System.out.println("1 - Cadastrar Brinquedo");
            System.out.println("2 - Cadastrar Decoração");
            System.out.println("3 - Listar Acervo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("--- Cadastrando Brinquedo ---");

                    System.out.println("Digite o nome do Brinquedo: ");
                    String nome = leitura.nextLine();

                    System.out.println("Digite a quantidade de " + nome);
                    int quantidade = leitura.nextInt();

                    System.out.println("Digite o preço de " + nome);
                    double valor = leitura.nextDouble();

                    leitura.nextLine();

                    System.out.println("Digite o tipo de " + nome);
                    String tipo = leitura.nextLine();

                    System.out.println("Digite a capacidade máxima de " + nome);
                    int capacidade = leitura.nextInt();

                    Brinquedo brinquedo = new Brinquedo(quantidade, nome, valor, tipo, capacidade);
                    service.cadastrar(brinquedo);
                    break;
                case 2:
                    System.out.println("--- Cadastrando Decoração ---");

                    System.out.println("Digite o nome da Decoração");
                    String nomeD = leitura.nextLine();

                    System.out.println("Digite a quantidade de" + nomeD);
                    int quantidadeD = leitura.nextInt();

                    System.out.println("Digite o preço de " + nomeD);
                    double valorD = leitura.nextDouble();

                    leitura.nextLine();

                    System.out.println("Digite o tema de " + nomeD);
                    String tema = leitura.nextLine();

                    Decoracao decoracao = new Decoracao(quantidadeD, nomeD, valorD, tema);
                    service.cadastrar(decoracao);
                    break;
                case 3:
                    System.out.println("--- Acervo ---");
                    System.out.println("Filtrar por:");
                    System.out.println("1 - Brinquedos");
                    System.out.println("2 - Decoração");
                    System.out.println("3 - Todos");
                    int tipoFiltro = leitura.nextInt();
                    leitura.nextLine();

                    List<Item> lista = service.listarTodos();

                    if (lista.isEmpty()){
                        System.out.println("O estoque está vazio!");
                    } else {
                        System.out.println("--- Lista de Itens ---");
                        for (Item item : lista) {
                            boolean deveImprimir = false;

                            if (tipoFiltro == 1 && item instanceof Brinquedo) {
                                deveImprimir = true;
                            } else if (tipoFiltro == 2 && item instanceof Decoracao) {
                                deveImprimir = true;
                            } else if (tipoFiltro == 3) {
                                deveImprimir = true;
                            }
                            if (deveImprimir) {
                                System.out.println(item);
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
