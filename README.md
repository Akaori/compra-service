# Projeto Final do Curso Devª da B3 com a Ada Tech - Compra Service

## Descrição

Este projeto final do curso Devª da B3 com a Ada Tech consiste em um microsserviço de realização de compras, integrado a outros microsserviços como pagamento, carrinho, update de compra e comunicação REST com queues de erro.

O Compra Service é responsável por processar solicitações de compra, interagindo com outros microservices para completar o fluxo de compra:

- **Carrinho Service**: Consulta o carrinho do cliente para recuperar os itens da compra.
- **Pagamento Service**: Processa o pagamento da compra.
- **Update Compra Queue**: Envia uma mensagem para uma fila (queue) para atualizar o status da compra em outro sistema.
- **Error Topic**: Envia mensagens de erro para um tópico (topic) para monitoramento e tratamento.

A comunicação entre este microservice e os demais ocorre por meio de chamadas RESTful API.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring WebClient (para comunicação REST com outros microservices)
- OpenAPI (para documentação da API)

## Estrutura do Projeto

- **src/main/java/tech.ada.compraservice**: Código-fonte do microservice, contendo classes como `RealizarCompraService`, `CompraRepository`, `CompraRequest`, e `CompraResponse`.
- **src/main/java/tech.ada.compraservice.config**: Classes de configuração do Spring, incluindo `CarrinhoWebClientConfig`, `PagamentoWebClientConfig`, e `OpenApiConfig`.

## Instruções de Instalação e Execução

### Pré-requisitos:

- Java 11 ou superior
- Maven (ou outro gerenciador de dependências)

1. Clone o repositório do projeto.
2. Configure as URLs dos serviços de carrinho e pagamento no arquivo `application.properties`.
3. Execute o projeto usando sua IDE preferida ou por linha de comando.

## Documentação da API

Para acessar a documentação da API (Swagger), visite: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Contribuição

.
