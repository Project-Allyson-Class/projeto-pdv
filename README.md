# Projeto

Este é um projeto desenvolvido em **Java 21** utilizando **PostgreSQL** como banco de dados e documentado com **Swagger**.

## 🛠 Tecnologias utilizadas
- Java 21
- Spring Boot
- PostgreSQL
- Flyway
- Swagger (OpenAPI)

## 🚀 Configuração e execução

### 📌 Banco de Dados
Caso não tenha um banco de dados PostgreSQL instalado, você pode utilizar um container Docker. Para subir um container com o PostgreSQL, execute:

```sh
docker run --name postgres-container -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=Password!123 -e POSTGRES_DB=pdv -p 5432:5432 -d postgres
```

Isso criará um banco chamado 'pdv' com usuário admin e senha e o tornará acessível na porta 5432.

### 🔄 Executando a migração
Para rodar as migrações do banco de dados, utilize o seguinte comando:

```sh
mvn flyway:migrate
```

Isso aplicará todas as migrações pendentes no banco configurado no projeto.

### Documentação

A documentação da API estará disponível em:

```
http://localhost:8080/swagger-ui.html
```
