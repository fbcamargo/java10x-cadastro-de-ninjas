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

// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Data

// Commits

Em linguagem inglês

feat: Adicionando nova feature