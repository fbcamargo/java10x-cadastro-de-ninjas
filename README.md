// Classe principal Spring

@SpringBootApplication


// Comando para iniciar aplicativo

mvn spring-boot:run

// Mapa de rotas

Controller -> Controlador de rotas

@RestController

// Mapeamento de rotas

@RequestMapping

@GetMapping -> GET

@PostMapping -> POST

@PutMapping -> PUT

@DeleteMapping -> DELETE

Entidades e algo fisico no banco de dados

@Entity

//Git Amend
```
git status
git add .
git log --oneline
git commit --amend
git push
git log --oneline
```

// JPA
@Table(name = "<table-name>")
@Id
@GeneratedValue(strategy = GenerationType.<type>)
@ManyToOne
@JoinColumn(name= "<column-name>")
@Column()
@Column(unique = true)

// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Data

// Commits

Em linguagem inglês

Mensagem sempre indica o que o commit fez
O commit "Coloca ..."
O commit "Remove ..."
O commit "Altera ..."

feat: Adicionando nova feature
fix: Correções feitas

Repositorys
- Sempre interfaces
- extende JpaRepository
- ORM (Mapeia a classe e relaciona com uma tabela no DB)

H2
http://localhost:8080/h2-console

application.properties
.env

- Banco de dados
Querys

SELECT * FROM <tabela>
SELECT * FROM WHRE <coluna> = <valor>

INSERT INTO <tabela>
(<colunas>...)
VALUES (<dados>...)

Update count: 1

UPDATE <tabela>
SET <coluna> = <valor>

ALTER TABLE <tabela>
ADD COLUMN <coluna> = <valor>

DELETE FROM <table> WHERE <coluna> = <valor>

H2 vale apenas para o ciclo de mémoria

- Migrations
Hibernates
Versionamento do banco de dados
LiquiBase
Flyway
resources/db/migrations
Semple informar a versão para tablea
V2__<operacao>_<tabela>.sql
Após migrado, não se pode alterar o arquivo

- Serializar
Transferir dados de um sistema para outro ou um dado para outro tipo de dado
JSON

- Injeção de dependencia
@Autowired
Via controller <- recomendado

- JPA
listAll() <- SELECT * FROM ...
save() <- INSERT INTO ...

- Erro de serialização
Quando um model relacionado entra em loop
serialization loop
Para corrigir, a relação deve conter:
@JsonIgnore

- Optional
pode receber o valor do objeto ou um null

/detalhes/{id}
@PathVariable

@RequestBody
Serializa um json do cliente para o sistema