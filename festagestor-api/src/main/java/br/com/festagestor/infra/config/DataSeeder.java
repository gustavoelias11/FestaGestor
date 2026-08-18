package br.com.festagestor.infra.config;

import br.com.festagestor.domain.aluguel.dto.DadosCadastroAluguel;
import br.com.festagestor.domain.aluguel.dto.DadosCadastroAluguelItem;
import br.com.festagestor.domain.aluguel.model.Aluguel;
import br.com.festagestor.domain.aluguel.model.AluguelItem;
import br.com.festagestor.domain.aluguel.repository.AluguelRepository;
import br.com.festagestor.domain.cliente.dto.DadosCadastroCliente;
import br.com.festagestor.domain.cliente.model.Cliente;
import br.com.festagestor.domain.cliente.repository.ClienteRepository;
import br.com.festagestor.domain.item.model.Brinquedo;
import br.com.festagestor.domain.item.model.Decoracao;
import br.com.festagestor.domain.item.model.Item;
import br.com.festagestor.domain.item.model.Status;
import br.com.festagestor.domain.item.repository.ItemRepository;
import br.com.festagestor.domain.shared.endereco.DadosCadastroEndereco;
import br.com.festagestor.domain.shared.endereco.Endereco;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Configuration
public class DataSeeder implements CommandLineRunner {
    private final ClienteRepository clienteRepository;
    private final ItemRepository itemRepository;
    private final AluguelRepository aluguelRepository;

    public DataSeeder(ClienteRepository clienteRepository, ItemRepository itemRepository, AluguelRepository aluguelRepository) {
        this.clienteRepository = clienteRepository;
        this.itemRepository = itemRepository;
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        aluguelRepository.deleteAll();
        itemRepository.deleteAll();
        clienteRepository.deleteAll();

        Faker faker = new Faker(new Locale("pt-BR"));
        Random random = new Random();

        // CLIENTES

        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            DadosCadastroEndereco endereco = new DadosCadastroEndereco(
                    faker.address().streetAddress(),   // logradouro
                    faker.address().buildingNumber(),   // numero
                    faker.address().cityName(),         // bairro
                    null,                               // complemento
                    faker.address().city(),             // cidade
                    faker.address().stateAbbr(),       // uf
                    faker.address().zipCode()           // cep
            );

            DadosCadastroCliente dados = new DadosCadastroCliente(
                    faker.name().fullName(),
                    faker.idNumber().valid(),
                    faker.phoneNumber().cellPhone(),
                    endereco
            );

            clientes.add(new Cliente(dados));
        }
        clienteRepository.saveAll(clientes);

        List<Item> itens = new ArrayList<>();

        // BRINQUEDOS

        String[] brinquedos = {
                "Cama Elástica",
                "Piscina de Bolinhas",
                "Castelo Inflável",
                "Tobogã Inflável",
                "Pula-Pula Inflável",
                "Futebol de Sabão",
                "Guerra de Cotonetes",
                "Touro Mecânico",
                "Escorregador Inflável",
                "Multi Play"
        };

        for (String nome : brinquedos) {

            itens.add(new Brinquedo(
                    nome,
                    "Brinquedo para festas e eventos",
                    BigDecimal.valueOf(
                            faker.number().randomDouble(2, 80, 500)
                    ),
                    Status.DISPONIVEL,
                    faker.number().numberBetween(4, 15),
                    "3m x 3m"
            ));
        }


        // DECORAÇÕES

        String[] decoracoes = {
                "Kit Decoração Princesas",
                "Kit Decoração Mickey",
                "Kit Decoração Safari",
                "Kit Decoração Fazendinha",
                "Kit Decoração Patrulha Canina",
                "Kit Decoração Homem-Aranha",
                "Kit Decoração Frozen",
                "Kit Decoração Dinossauro",
                "Kit Decoração Unicórnio",
                "Kit Decoração Bailarina"
        };

        String[] temas = {
                "Princesas",
                "Mickey",
                "Safari",
                "Fazendinha",
                "Patrulha Canina",
                "Homem-Aranha",
                "Frozen",
                "Dinossauro",
                "Unicórnio",
                "Bailarina"
        };

        for (int i = 0; i < decoracoes.length; i++) {

            itens.add(new Decoracao(
                    decoracoes[i],
                    "Kit de decoração para festas",
                    BigDecimal.valueOf(
                            faker.number().randomDouble(2, 100, 800)
                    ),
                    Status.DISPONIVEL,
                    temas[i]
            ));
        }

        itemRepository.saveAll(itens);

        // ALUGUEIS

        List<Aluguel> alugueis = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Cliente cliente = clientes.get(
                    faker.random().nextInt(clientes.size())
            );

            LocalDateTime dataEntrega = LocalDateTime.now()
                    .plusDays(faker.number().numberBetween(1, 10));

            LocalDateTime dataRetirada = dataEntrega
                    .plusDays(faker.number().numberBetween(1, 3));

            DadosCadastroEndereco endereco = new DadosCadastroEndereco(
                    faker.address().streetAddress(),
                    faker.address().buildingNumber(),
                    faker.address().cityName(),
                    null,
                    faker.address().city(),
                    faker.address().stateAbbr(),
                    faker.address().zipCode()
            );

            DadosCadastroAluguel dados = new DadosCadastroAluguel(
                    cliente.getId(),
                    endereco,
                    dataEntrega,
                    dataRetirada,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    BigDecimal.valueOf(faker.number().numberBetween(0, 100)),
                    new ArrayList<>()
            );

            Aluguel aluguel = new Aluguel(
                    cliente,
                    dados,
                    new Endereco(endereco)
            );

            // Adiciona itens ao aluguel
            List<AluguelItem> aluguelItens = new ArrayList<>();

            for (int j = 0; j < faker.number().numberBetween(1, 4); j++) {

                Item item = itens.get(
                        faker.random().nextInt(itens.size())
                );

                DadosCadastroAluguelItem dadosItem =
                        new DadosCadastroAluguelItem(
                                item.getId(),
                                faker.number().numberBetween(1, 3)
                        );

                AluguelItem aluguelItem = new AluguelItem(
                        aluguel,
                        item,
                        dadosItem
                );

                aluguelItens.add(aluguelItem);
            }

            aluguel.setItens(aluguelItens);

            aluguel.calcularValorTotal();

            alugueis.add(aluguel);
        }

        aluguelRepository.saveAll(alugueis);
    }

}
