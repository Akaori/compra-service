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
- OpenFeign (para comunicação REST com outros microservices)
- RabbitMQ
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

|

## Licença
Este projeto está licenciado sob a Licença MIT.

## Desenvolvedoras
Para qualquer dúvida ou sugestão, entre em contato com a equipe de desenvolvimento:
| [<img src="https://media.licdn.com/dms/image/D4D03AQE5y3lBKkJqMQ/profile-displayphoto-shrink_400_400/0/1702420057924?e=1714608000&v=beta&t=DhvcI0lbfslMew0eiLlgmUKvGIOtK1mHqmARbHQ3dmU" width=115><br><sub>Adilane Pereira</sub>](https://www.linkedin.com/in/adilane-borges/?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app) |  [<img src="https://media.licdn.com/dms/image/C4D03AQHZZ7hoeBMwxQ/profile-displayphoto-shrink_400_400/0/1611092925723?e=1714608000&v=beta&t=52PnMjX9L6DLh_L_jaaNIUzJrjexhQigGbTYqUZisTM" width=115><br><sub>Aline Werner</sub>](https://www.linkedin.com/in/alinewer/) |  [<img src="https://avatars.githubusercontent.com/u/45232866?v=4" width=115><br><sub>Ana Luiza Akiyama</sub>](https://github.com/Akaori) | [<img src="https://media.licdn.com/dms/image/C4D03AQF2yNZ3qZ3ZjQ/profile-displayphoto-shrink_400_400/0/1629249879532?e=1714608000&v=beta&t=nXzvMwaLOGbsMATomIbybI0IaHl3Gpxb8LoywvtaYkA" width=115><br><sub>Graziella Guedes</sub>](https://www.linkedin.com/in/graziellacosta/) | [<img src="https://media.licdn.com/dms/image/D4D35AQGgZcEVZlV8Iw/profile-framedphoto-shrink_800_800/0/1660592108061?e=1709438400&v=beta&t=Sf1mxxIOx7doSTSeDPgtgtYrbl_qYY5D5s8m7IrYAu8" width=115><br><sub>Nathalya Lucena</sub>](https://www.linkedin.com/in/nathalya-lucena-466773244/)
| :---: | :---: | :---: | :---: | :---: 


Atenciosamente,

Equipe de Desenvolvimento.
