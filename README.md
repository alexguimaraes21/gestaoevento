# Gestão de Evento

## Stacks utilizadas:
 - Java 21+
 - Docker
 - Docker Compose
 - Banco de Dados - MariaDB
 - Migration de dados - Flyway
 - Spring Boot

## Ambiente de Desenvolvimento:

Ao executar a aplicação utilizando o comando do Maven:

`./mvnw spring-boot:run`

Automaticamente será baixado a imagem Docker do MariaDB e criado um container com o Banco de Dados que será consumido pela
Aplicação. Isso torna-se possível por causa da dependencia no pom.xml: `org.springframework.boot:spring-boot-docker-compose`.

## Ambiente de Produção

Para o ambiente de Produção, disponibilizamos um arquivo `docker-compose.yaml` para que automatize o processo de download
da imagem da aplicação assim como do banco de dados que será consumido pela aplicação.

## Geração de Imagem Docker

Visando a agilidade no desenvolvimento, geração de imagem docker, etc, foi adicionado um Shell Script na pasta raiz do
projeto chamado `atualiza-docker-image.sh` que contém todos os comandos necessários para geração e push da imagem docker.
Por ser um Shell Script, funciona apenas nos sistemas operacionais que contam com Shell "SH" como Linux, BSD, MacOS, etc.

Para gerar nova imagem docker, basta executar o script com o comando:

`./atualiza-docker-image.sh`

Ao executar o script, já será possível ver o retorno dos comandos. Caso erro de permissão de execução ocorra, será necessário
adicionar permissão de execução no script com o comando: `chmod +x ./atualiza-docker-image.sh`. Após o comando, tente executar
o script novamente.

## Arquivo de configuração

Disponibilizamos um arquivo de configuração de exemplo chamado application-env.example.yaml que contém as configurações básicas
porém, antes de inicializar a aplicação no ambiente de desenvolvimento, é necessário alterar o parâmetro abaixo (primeiro parâmetro da lista).

De:
`
spring:
  config:
    activate:
      on-profile: env
`

Para:
`
spring:
  config:
    activate:
      on-profile: dev
`

## Documentação dos Endpoints:

A aplicação possui Swagger que pode ser acessado através da URL `http://localhost:8080/swagger-ui/index.html`.

Caso prefira o ReDoc, a URL de acesso é a `http://localhost:8080/redoc`