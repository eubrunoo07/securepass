
# SecurePass

O projeto **SecurePass** é uma API de gerenciamento de senhas seguras. Ele permite criar, armazenar e consultar senhas para diferentes serviços de maneira eficiente e segura. Utilizando criptografia robusta e autenticação, a aplicação garante a integridade e confidencialidade dos dados.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **PostgreSQL**
- **Spring Data JPA**
- **Docker**
- **Swagger** (para documentação da API)

## Funcionalidades

- **Criação e Armazenamento de Senhas**: Gere e armazene senhas seguras para diferentes serviços.
- **Consultas**: Busque as senhas armazenadas associadas a diferentes serviços.
- **Integração com PostgreSQL**: Banco de dados relacional utilizado para armazenar informações de usuários e senhas.
- **Segurança**: Proteção dos dados com criptografia e autenticação JWT.
- **Docker**: Suporte completo para containerização da aplicação.
- **Documentação da API**: Swagger para visualização e testes da API.

## Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter instalado:

- **Java 17+**
- **Maven**
- **PostgreSQL**
- **Docker** (caso deseje rodar a aplicação em containers)

### Executando o Projeto Localmente

1. Clone o repositório:

   ```bash
   git clone https://github.com/eubrunoo07/securepass.git
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd securepass
   ```

3. Configure as credenciais do PostgreSQL no arquivo `application.yml`.

4. Execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

### Executando com Docker

Se preferir usar Docker, siga os passos:

1. Certifique-se de que o Docker está instalado e em execução.

2. Construa a imagem Docker:

   ```bash
   docker build -t securepass .
   ```

3. Execute o container:

   ```bash
   docker run -p 8080:8080 securepass
   ```

### Documentação da API

A documentação da API pode ser acessada após a execução do projeto:

```
http://localhost:8080/swagger-ui.html
```

## Estrutura do Projeto

- `src/main/java`: Contém o código-fonte principal.
- `src/main/resources`: Contém arquivos de configuração, como `application.yml`.
- `docker/docker-compose.yml`: Arquivo para construção da imagem Docker da aplicação.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais informações.
