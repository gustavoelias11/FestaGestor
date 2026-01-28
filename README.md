# 🎉 FestaGestor

> Sistema de gestão para aluguel de brinquedos e decorações de festas.

## 📖 Sobre o Projeto
O **FestaGestor** é uma aplicação em Java desenvolvida para gerenciar o acervo de uma empresa de aluguel para festas. A ideia nasceu de uma necessidade real (inspirada no negócio da minha família), visando controlar o inventário de brinquedos e kits de decoração.

Este projeto foi criado com o objetivo principal de **praticar e consolidar conceitos de Orientação a Objetos e Arquitetura de Software** em Java puro (Core Java), servindo como base sólida para uma futura migração para o framework Spring Boot.

## 🚀 Funcionalidades Atuais
Atualmente, o sistema opera via Terminal (Console) e permite:

- [x] **Gestão de Acervo**:
    - Cadastro de **Brinquedos** (com atributos específicos como capacidade e voltagem).
    - Cadastro de **Decorações** (com definição de temas).
    - Listagem geral ou filtrada (Polimorfismo).
- [x] **Gestão de Clientes**:
    - Cadastro de clientes com dados de contato.
    - Listagem de clientes ativos.
- [x] **Arquitetura em Camadas**: Separação clara de responsabilidades.
- [x] **Persistência em Memória**: Utilização de `Collections` (Listas) para simular um banco de dados temporário.

## 🛠️ Tecnologias e Conceitos Aplicados
O projeto foi estruturado seguindo as melhores práticas de desenvolvimento:

- **Linguagem:** Java (JDK)
- **Paradigma:** Orientação a Objetos (POO)
    - **Herança:** (`Item` -> `Brinquedo`, `Decoracao`)
    - **Polimorfismo:** (Sobrescrita de métodos `toString`, uso de `instanceof`)
    - **Encapsulamento:** (Getters, Setters e modificadores de acesso)
- **Arquitetura:** Layered Architecture (Camadas)
    - `Model`: Entidades do domínio.
    - `Repository`: Persistência de dados (Simulação de DAO).
    - `Service`: Regras de negócio.
    - `View`: Interação com o usuário (Console).

## 📂 Estrutura do Projeto
```text
src/br/com/festagestor
│
├── model          # Classes: Item, Brinquedo, Decoracao, Cliente
├── repository     # Classes: ItemRepository, ClienteRepository
├── service        # Classes: CadastraItemService, CadastraClienteService
└── FestaGestorApplication.java  # Classe Main (Menu e Execução)
```

## 📦 Como Executar
1. Clone o repositório:
```
git clone [https://github.com/gustavoelias11/FestaGestor.git]
```
2. Abra o projeto: Utilize sua IDE de preferência (IntelliJ, Eclipse, VS Code).
3. Execute: Procure pela classe FestaGestorApplication.java na pasta src e execute o método main.

## 🔮 Roadmap (Próximos Passos)
O projeto está em evolução constante. As próximas metas são:

[ ] Módulo de Aluguel: Lógica para vincular Clientes a Itens em uma Data específica.

[ ] Validação de Estoque: Impedir aluguel se o item já estiver reservado na data.

[ ] Banco de Dados: Substituir as Listas em memória por MySQL/PostgreSQL.

[ ] API Rest: Migrar o backend para Spring Boot.

<div align="center"> Desenvolvido por <a href="https://www.google.com/search?q=https://github.com/gustavoelias11">Gustavo Elias</a> </div>