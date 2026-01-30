import model.*;
import service.CadastraAluguelService;
import service.CadastraClienteService;
import service.CadastraItemService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestaGestorApplication {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        CadastraItemService serviceItem = new CadastraItemService();
        CadastraClienteService serviceCliente = new CadastraClienteService();
        CadastraAluguelService aluguelService = new CadastraAluguelService();

        int opcao = 0;

        do {
            System.out.println("---=== FESTA GESTOR ===---");
            System.out.println("1 - Cadastrar Brinquedo");
            System.out.println("2 - Cadastrar Decoração");
            System.out.println("3 - Listar Acervo");
            System.out.println("4 - Cadastrar Cliente");
            System.out.println("5 - Listar Clientes");
            System.out.println("6 - Novo Aluguel");
            System.out.println("7 - Listar Alugueis");
            System.out.println("8 - Devolver Aluguel");
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

                    leitura.nextLine();

                    Brinquedo brinquedo = new Brinquedo(quantidade, nome, valor, tipo, capacidade);
                    serviceItem.cadastrar(brinquedo);
                    break;
                case 2:
                    System.out.println("--- Cadastrando Decoração ---");

                    System.out.println("Digite o nome da Decoração");
                    String nomeD = leitura.nextLine();

                    System.out.println("Digite a quantidade de " + nomeD);
                    int quantidadeD = leitura.nextInt();

                    System.out.println("Digite o preço de " + nomeD);
                    double valorD = leitura.nextDouble();

                    leitura.nextLine();

                    System.out.println("Digite o tema de " + nomeD);
                    String tema = leitura.nextLine();

                    Decoracao decoracao = new Decoracao(quantidadeD, nomeD, valorD, tema);
                    serviceItem.cadastrar(decoracao);
                    break;
                case 3:
                    System.out.println("--- Acervo ---");
                    System.out.println("Filtrar por:");
                    System.out.println("1 - Brinquedos");
                    System.out.println("2 - Decoração");
                    System.out.println("3 - Todos");
                    int tipoFiltro = leitura.nextInt();
                    leitura.nextLine();

                    List<Item> lista = serviceItem.listarTodos();

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
                case 4:
                    System.out.println("--- Cadastrando Cliente ---");

                    System.out.println("Digite o nome do cliente: ");
                    String nomeC = leitura.nextLine();

                    System.out.println("Digite o número de telefone: ");
                    String telefone = leitura.nextLine();

                    System.out.println("Digite o endereço: ");
                    String endereco = leitura.nextLine();

                    Cliente cliente = new Cliente(nomeC, telefone, endereco);
                    serviceCliente.cadastrar(cliente);
                    break;
                case 5:
                    System.out.println("--- Clientes ---");

                    List<Cliente> listaCliente = serviceCliente.listarTodosClientes();

                    for (Cliente c : listaCliente) {
                        System.out.println(c);
                    }
                    break;
                case 6:
                    System.out.println("--- Cadastrando Aluguel ---");
                    List<Cliente> clientesDisponiveis = serviceCliente.listarTodosClientes();
                    List<Item> itensDisponiveis = serviceItem.listarTodos();
                    if(clientesDisponiveis.isEmpty()){
                        System.out.println("Erro: Não há clientes cadastrados!");
                        break;
                    }

                    System.out.println("Selecione o ciente (digite o número):");
                    for (int i = 0; i < clientesDisponiveis.size(); i++) {
                        System.out.println("[" + i + "]" + clientesDisponiveis.get(i).getNome());
                    }
                    int indiceCliente = leitura.nextInt();
                    Cliente clienteSelecionado = clientesDisponiveis.get(indiceCliente);


                    List<Item> carrinho = new ArrayList<>();
                    int opcaoItem = 0;

                    System.out.println("Selecione o item (digite o número):");
                    while (true) {
                        for (int i = 0; i < itensDisponiveis.size(); i++) {
                            System.out.println("[" + i + "]" + itensDisponiveis.get(i).getDescricao());
                        }
                        opcaoItem = leitura.nextInt();
                        if (opcaoItem == -1) {
                            break;
                        }

                        if (opcaoItem >= 0 && opcaoItem < itensDisponiveis.size()) {
                            Item itemEscolhido = itensDisponiveis.get(opcaoItem);
                            carrinho.add(itemEscolhido);
                            System.out.println(itemEscolhido.getDescricao() + " adicionado com sucesso!");
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                    leitura.nextLine();

                    System.out.println("Informe o dia da festa (dd/MM/yyyy)");
                    String data = leitura.nextLine();

                    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataFesta = LocalDate.parse(data, formatar);

                    Aluguel novoAluguel = new Aluguel(clienteSelecionado, carrinho, dataFesta);
                    aluguelService.cadastrar(novoAluguel);
                    break;
                case 7:
                    System.out.println("--- Aluguéis ---");

                    List<Aluguel> listaDeAluguel = aluguelService.listarTodosAlugueis();
                    if (!listaDeAluguel.isEmpty()) {
                        boolean encontrou = false;
                        for (Aluguel a : listaDeAluguel) {
                            if (a.getStatus().equals("Aberto")) {
                                encontrou = true;
                                System.out.println(a);
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Não consta aluguéis em aberto!");
                        }
                    } else {
                        System.out.println("Não consta aluguéis abertos!");
                    }
                    break;
                case 8:
                    System.out.println("--- Devolvendo Aluguel ---");
                    List<Aluguel> alugueisParaDevolver = aluguelService.listarTodosAlugueis();
                    if(alugueisParaDevolver.isEmpty()){
                        System.out.println("Erro: Não há aluguéis para devolver");
                    }

                    System.out.println("Selecione o aluguel da lista (digite o número):");
                    for (int i = 0; i < alugueisParaDevolver.size(); i++) {
                        System.out.println("[" + i + "]" + alugueisParaDevolver.get(i));
                    }
                    int idAluguel = leitura.nextInt();

                    leitura.nextLine();

                    if (idAluguel >= 0 && idAluguel < alugueisParaDevolver.size()) {
                        Aluguel devolveAluguel = alugueisParaDevolver.get(idAluguel);
                        aluguelService.devolver(devolveAluguel);

                        System.out.println("Devolução realizada com sucesso!");
                    } else {
                        System.out.println("Opção inválida!");
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
