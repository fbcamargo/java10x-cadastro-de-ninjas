# 🥷 Sistema de Cadastro de Ninjas

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?style=flat-square&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=flat-square&logo=apache-maven)
![H2](https://img.shields.io/badge/H2-Database-yellow?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)

> **Bem-vindo ao Sistema de Cadastro de Ninjas!**

Este projeto é uma aplicação de arquitetura em camadas desenvolvida com Spring Boot, projetada para cadastrar ninjas e suas respectivas missões. O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no GitHub

**Projeto referente ao Java10x**

---

## 📑 Tabela de Conteúdos

- [Visão Geral](#-visão-geral)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Arquitetura / Estrutura de Pastas](#-arquitetura--estrutura-de-pastas)
- [Instalação](#-instalação)
- [Uso / Exemplos de Execução](#-uso--exemplos-de-execução)
- [Ambiente e Configurações](#-ambiente-e-configurações)
- [Conceitos Aprendidos](#-conceitos-aprendidos)
- [Licença](#-licença)
- [Agradecimentos](#-agradecimentos)

---

## 🎯 Visão Geral

O **Sistema de Cadastro de Ninjas** é uma aplicação web completa que permite gerenciar ninjas e suas missões. A aplicação foi desenvolvida seguindo os princípios de arquitetura em camadas, separando responsabilidades entre Controller, Service, Repository e Model.

### Objetivos do Projeto

- Demonstrar o uso de Spring Boot em uma aplicação web completa
- Implementar arquitetura em camadas (Layered Architecture)
- Gerenciar relacionamentos entre entidades (Ninjas e Missões)
- Utilizar migrações de banco de dados com Flyway
- Aplicar boas práticas de desenvolvimento Java

### Funcionalidades Principais

- ✅ Cadastro de ninjas com informações pessoais
- ✅ Cadastro de missões com níveis de dificuldade
- ✅ Relacionamento entre ninjas e missões
- ✅ Interface web com Thymeleaf
- ✅ API REST para integração
- ✅ Documentação automática com OpenAPI/Swagger

---

## 🛠 Tecnologias Utilizadas

### Backend

- **Spring Boot 3.5.7** - Framework principal para criação da aplicação web e gerenciamento de dependências
- **Spring Data JPA** - Para interação com o banco de dados e mapeamento objeto-relacional
- **JPA (Java Persistence API)** - Para mapeamento objeto-relacional (ORM)
- **Lombok** - Para reduzir boilerplate code com anotações

### Banco de Dados

- **H2 Database** - Banco de dados em memória para desenvolvimento e testes
- **Flyway** - Para gerenciamento de migrações do banco de dados

### Frontend

- **Thymeleaf** - Engine de templates para renderização de páginas HTML

### Build e Ferramentas

- **Maven** - Para build e gerenciamento de dependências do projeto
- **Git** - Controle de versão para gerenciamento de mudanças no código
- **GitHub** - Hospedagem do repositório para controle de versão
- **Docker** - Para build externo do banco de dados

### Documentação

- **SpringDoc OpenAPI** - Documentação automática da API REST

### Linguagens e SQL

- **Java 21** - Linguagem de programação principal
- **SQL** - Para manipulação e consultas no banco de dados

---

## 🏗 Arquitetura / Estrutura de Pastas

O projeto segue uma arquitetura em camadas (Layered Architecture), separando as responsabilidades de forma clara:

```
CadastroDeNinjas/
│
├── src/
│   ├── main/
│   │   ├── java/dev/java10x/CadastroDeNinjas/
│   │   │   ├── CadastroDeNinjasApplication.java    # Classe principal
│   │   │   │
│   │   │   ├── Ninjas/                              # Módulo de Ninjas
│   │   │   │   ├── NinjaModel.java                  # Entidade JPA
│   │   │   │   ├── NinjaRepository.java             # Interface de acesso a dados
│   │   │   │   ├── NinjaService.java                # Lógica de negócio
│   │   │   │   ├── NinjaController.java             # Controller REST API
│   │   │   │   ├── NinjaControllerUi.java           # Controller para UI
│   │   │   │   ├── NinjaDto.java                    # Data Transfer Object
│   │   │   │   └── NinjaMapper.java                 # Mapper DTO <-> Model
│   │   │   │
│   │   │   └── Missoes/                             # Módulo de Missões
│   │   │       ├── MissoesModel.java                # Entidade JPA
│   │   │       ├── MissoesRepository.java           # Interface de acesso a dados
│   │   │       ├── MissoesService.java              # Lógica de negócio
│   │   │       ├── MissoesController.java           # Controller REST API
│   │   │       └── DificuldadeEnum.java             # Enum de dificuldade
│   │   │
│   │   └── resources/
│   │       ├── application.properties                # Configurações da aplicação
│   │       ├── db/
│   │       │   └── migrations/                      # Migrações Flyway
│   │       │       └── V2__Add_rank_tb_cadastro.sql
│   │       └── templates/                           # Templates Thymeleaf
│   │           ├── adicionarNinja.html
│   │           ├── detalhesNinja.html
│   │           └── listarNinjas.html
│   │
│   └── test/                                        # Testes unitários e de integração
│
├── pom.xml                                          # Configuração Maven
└── README.md                                        # Este arquivo
```

### Camadas da Aplicação

1. **Controller** - Recebe requisições HTTP e retorna respostas

   - `@RestController` - Para APIs REST
   - `@Controller` - Para renderização de views
   - Anotações de mapeamento: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`

2. **Service** - Contém a lógica de negócio da aplicação

   - Validações
   - Transformações de dados
   - Orquestração de operações

3. **Repository** - Interface de acesso a dados

   - Estende `JpaRepository`
   - Métodos automáticos: `save()`, `findAll()`, `findById()`, etc.

4. **Model** - Entidades JPA que representam tabelas no banco

   - `@Entity` - Marca a classe como entidade
   - `@Table` - Define o nome da tabela
   - Relacionamentos: `@ManyToOne`, `@OneToMany`

5. **DTO (Data Transfer Object)** - Objetos de transferência de dados

   - Abstração das entidades
   - Reduz acoplamento entre camadas

6. **Mapper** - Converte entre DTO e Model
   - `@Component` - Componente gerenciado pelo Spring

---

## 📥 Instalação

### Pré-requisitos

- **Java 21** ou superior
- **Maven 3.8+**
- **Git** (opcional, para clonar o repositório)
- **Docker** (opcional, para banco de dados externo)

### Passo a Passo

1. **Clone o repositório** (ou baixe o projeto)

   ```bash
   git clone https://github.com/fbcamargo/java10x-cadastro-de-ninjas.git
   cd CadastroDeNinjas
   ```

2. **Configure as variáveis de ambiente**

   Crie um arquivo `.env` na raiz do projeto ou configure as variáveis de ambiente:

   ```bash
   DATABASE_URL=jdbc:h2:mem:CadastroDeNinjaDb
   DATABASE_USERNAME=sa
   DATABASE_PASSWORD=
   ```

3. **Compile o projeto**

   ```bash
   mvn clean install
   ```

4. **Execute a aplicação**

   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a aplicação**
   - Interface Web: http://localhost:8080
   - Console H2: http://localhost:8080/h2-console
   - API Swagger: http://localhost:8080/swagger-ui.html

---

## 🚀 Uso / Exemplos de Execução

### Interface Web

A aplicação possui uma interface web completa para gerenciar ninjas:

- **Listar Ninjas**: `GET /` ou `GET /listar`
- **Adicionar Ninja**: `GET /adicionar` (formulário) → `POST /adicionar`
- **Detalhes do Ninja**: `GET /detalhes/{id}`

### API REST

#### Endpoints de Ninjas

**Listar todos os ninjas**

```bash
GET http://localhost:8080/ninjas
```

**Buscar ninja por ID**

```bash
GET http://localhost:8080/ninjas/{id}
```

**Criar novo ninja**

```bash
POST http://localhost:8080/ninjas
Content-Type: application/json

{
  "nome": "Naruto Uzumaki",
  "email": "naruto@konoha.com",
  "idade": 17,
  "imgUrl": "https://example.com/naruto.jpg",
  "rank": "Genin",
  "missoesId": 1
}
```

**Atualizar ninja**

```bash
PUT http://localhost:8080/ninjas/{id}
Content-Type: application/json

{
  "nome": "Naruto Uzumaki",
  "email": "naruto@konoha.com",
  "idade": 18,
  "rank": "Chunin"
}
```

**Deletar ninja**

```bash
DELETE http://localhost:8080/ninjas/{id}
```

#### Endpoints de Missões

**Listar todas as missões**

```bash
GET http://localhost:8080/missoes
```

**Criar nova missão**

```bash
POST http://localhost:8080/missoes
Content-Type: application/json

{
  "nome": "Resgate do Kazekage",
  "dificuldade": "S"
}
```

### Console H2

Para acessar o console do H2 e executar queries SQL diretamente:

1. Acesse: http://localhost:8080/h2-console
2. Configure a conexão:
   - **JDBC URL**: `jdbc:h2:mem:CadastroDeNinjaDb`
   - **User Name**: `sa`
   - **Password**: (deixe vazio)
3. Clique em "Connect"

**Exemplos de Queries SQL:**

```sql
-- Listar todos os ninjas
SELECT * FROM tb_cadastro;

-- Buscar ninja por email
SELECT * FROM tb_cadastro WHERE email = 'naruto@konoha.com';

-- Inserir novo ninja
INSERT INTO tb_cadastro (nome, email, idade, img_url, rank, missoes_id)
VALUES ('Sasuke Uchiha', 'sasuke@konoha.com', 17, 'https://example.com/sasuke.jpg', 'Genin', 1);

-- Atualizar ninja
UPDATE tb_cadastro
SET idade = 18
WHERE id = 1;

-- Deletar ninja
DELETE FROM tb_cadastro WHERE id = 1;
```

---

## ⚙️ Ambiente e Configurações

### Variáveis de Ambiente

O projeto utiliza variáveis de ambiente para configuração do banco de dados:

| Variável            | Descrição                  | Valor Padrão                    |
| ------------------- | -------------------------- | ------------------------------- |
| `DATABASE_URL`      | URL de conexão com o banco | `jdbc:h2:mem:CadastroDeNinjaDb` |
| `DATABASE_USERNAME` | Usuário do banco           | `sa`                            |
| `DATABASE_PASSWORD` | Senha do banco             | (vazio)                         |

### Arquivo `application.properties`

```properties
# Nome da aplicação
spring.application.name=CadastroDeNinjas

# Configurações H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configurações de DataSource
spring.datasource.url=${DATABASE_URL}
spring.datasource.driver=org.h2.Driver
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}

# Configurações JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configurações Flyway
spring.flyway.enable=true
spring.flyway.locations=classpath:db/migrations
spring.flyway.baseline-on-migrate=true
```

### Migrações Flyway

As migrações estão localizadas em `src/main/resources/db/migrations/` e seguem o padrão:

- `V{versão}__{descrição}.sql`
- Exemplo: `V2__Add_rank_tb_cadastro.sql`

⚠️ **Importante**: Após uma migração ser executada, o arquivo não pode ser alterado. Para novas mudanças, crie uma nova migração.

---

## 📚 Conceitos Aprendidos

Este projeto foi desenvolvido como parte do curso **Java10x** e aborda os seguintes conceitos:

### Spring Boot

- **`@SpringBootApplication`**: Anotação principal que marca a classe de inicialização
- **Injeção de Dependência**: Uso de `@Autowired` para injeção de dependências
- **Arquitetura em Camadas**: Separação clara entre Controller, Service, Repository e Model

### JPA (Java Persistence API)

- **`@Entity`**: Transforma uma classe em uma entidade do banco de dados
- **`@Table(name = "...")`**: Define o nome da tabela no banco
- **`@Id`**: Marca o campo como chave primária
- **`@GeneratedValue`**: Define a estratégia de geração de IDs
- **`@Column`**: Personaliza o mapeamento de colunas
- **`@ManyToOne`**: Relacionamento muitos-para-um
- **`@OneToMany`**: Relacionamento um-para-muitos
- **`@JoinColumn`**: Define a coluna de junção em relacionamentos

### Lombok

- **`@Data`**: Gera getters, setters, toString, equals e hashCode
- **`@NoArgsConstructor`**: Gera construtor sem argumentos
- **`@AllArgsConstructor`**: Gera construtor com todos os argumentos

### Controllers e Mapeamento de Rotas

- **`@RestController`**: Controller para APIs REST
- **`@Controller`**: Controller para renderização de views
- **`@RequestMapping`**: Mapeamento base de rotas
- **`@GetMapping`**: Mapeia requisições GET
- **`@PostMapping`**: Mapeia requisições POST
- **`@PutMapping`**: Mapeia requisições PUT
- **`@DeleteMapping`**: Mapeia requisições DELETE
- **`@PathVariable`**: Captura variáveis da URL (ex: `/detalhes/{id}`)
- **`@RequestBody`**: Deserializa JSON do cliente para objeto Java

### Spring Data JPA

- **Repository**: Interface que estende `JpaRepository`
- **Métodos automáticos**: `save()`, `findAll()`, `findById()`, `delete()`
- **`save()`**: Equivale a `INSERT INTO` ou `UPDATE`
- **`findAll()`**: Equivale a `SELECT * FROM`

### DTO e Mapper

- **DTO (Data Transfer Object)**: Abstração de entidades, reduz acoplamento
- **Mapper**: Componente (`@Component`) que converte entre DTO e Model
- **Vantagens**: Separa responsabilidades e protege a camada de modelo

### Serialização JSON

- **`@JsonIgnore`**: Previne serialização de campos específicos
- **Resolve problemas de loop**: Evita loops infinitos em relacionamentos bidirecionais

### Flyway e Migrações

- **Versionamento de Banco**: Controle de versão do schema do banco
- **Padrão de nomenclatura**: `V{versão}__{descrição}.sql`
- **Localização**: `resources/db/migrations/`
- **Imutabilidade**: Migrações executadas não podem ser alteradas

### Git e Controle de Versão

- **Commits em inglês**: Padrão de mensagens de commit
- **Convenções de commit**:
  - `feat:` - Nova funcionalidade
  - `fix:` - Correção de bugs
- **Git Amend**: `git commit --amend` para corrigir último commit
- **Branches**: Trabalho paralelo em features (`git checkout -b <nome-branch>`)

### H2 Database

- **Banco em memória**: Dados persistem apenas durante a execução
- **Console H2**: Acesso via http://localhost:8080/h2-console
- **SQL padrão**: Suporta SQL padrão para desenvolvimento

### Thymeleaf

- **Template Engine**: Renderização de páginas HTML no servidor
- **Integração Spring**: Integração nativa com Spring Boot

### ResponseEntity

- **Respostas HTTP personalizadas**: Controle de status, cabeçalhos e corpo
- **Padronização**: Padroniza retornos da API

### Optional

- **Tratamento de null**: Wrapper para valores que podem ser nulos
- **Segurança**: Evita `NullPointerException`

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License**.

---

## 🙏 Agradecimentos

Este projeto foi desenvolvido como parte do curso **Java10x**, focado em ensinar desenvolvimento Java moderno com Spring Boot, arquitetura em camadas e boas práticas de desenvolvimento de software.

---

<div align="center">

⭐ Se este projeto foi útil, considere dar uma estrela!

</div>
