## 📝 Contexto (User Story)
**Como um** [perfil de usuário]
**Eu quero** [ação/funcionalidade]
**Para que** [valor de negócio gerado]

## ✅ Critérios de Aceite (Definition of Done)
- [ ] Cenário 1: (Descrever o fluxo de sucesso esperado)
- [ ] Cenário 2: (Descrever o fluxo de falha/exceção esperado)
- [ ] Cobertura de testes unitários mínima atendida.

## 🛠️ Detalhes Técnicos e Arquiteturais
* **Endpoints Afetados:** (Ex: `POST /api/v1/recurso`)
* **Padrões de Projeto / SOLID:** (Onde aplicar Inversão de Dependência, Strategy, etc. para manter baixo acoplamento)
* **Impacto de Persistência:** (Novas entidades JPA? Índices necessários para evitar Query N+1?)
* **Observabilidade:** (O que precisa ser monitorado via Logs?)

## 📋 Tarefas (Sub-tasks)
- [ ] Criar DTOs (Request/Response) imutáveis (Records no Java).
- [ ] Implementar regra de negócio na camada Service.
- [ ] Escrever testes unitários (JUnit + Mockito).
- [ ] Mapear endpoint no Controller.
- [ ] Atualizar documentação da API.