package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(
        summary = "Mensagem de boas vindas",
        description = "Essa rota da uma mensagem de boas vindas"
    )
    public String boasVindas() {
        return "Essa é minha primeira rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    @Operation(
        summary = "Cria um novo ninja",
        description = "Rota cria um novo ninja e insere no banco de dados"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro na criaçao do ninja")
    })
    public ResponseEntity<NinjaDto> criarNinja(@RequestBody NinjaDto ninjaDto) {
        NinjaDto ninjaSalvo = ninjaService.criarNinja(ninjaDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ninjaSalvo);
    }

    // Listar Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDto>> listarNinjas() {
        List<NinjaDto> ninjas = this.ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/detalhes/{id}")
    @Operation(
            summary = "Lista ninja por ID",
            description = "Obtem detalhes de um Ninja"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontradop")
    })
    public ResponseEntity<?> procurarNinja(@PathVariable Long id) {
        if(this.ninjaService.procurarNinja(id) != null) {
            NinjaDto ninjaDto = this.ninjaService.procurarNinja(id);
            return ResponseEntity.ok(ninjaDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID " + id + " não encontrado");
    }

    // Alterar dados do Ninja (‘UPDATE’)
    @PutMapping("/alterar/{id}")
    @Operation(
        summary = "Altera o ninja por Id",
        description = "Rota altera um ninja pelo seu id"
    )
    @ApiResponses(value = {
    @ApiResponse(
        responseCode = "200",
        description = "Ninja alterado com sucesso"
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Ninja nao encontrado, nao foi possivel alterar"
    )
    })
    public ResponseEntity<?> alterarNinja(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisiçao")
            @RequestBody NinjaDto ninjaDto) {
        if(this.ninjaService.procurarNinja(id) != null) {
            NinjaDto ninjaEditado = this.ninjaService.atualizarNinja(id, ninjaDto);
            return ResponseEntity.ok(ninjaEditado);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja ID " + id + " não encontrado");
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if(this.ninjaService.procurarNinja(id) != null) {
            this.ninjaService.deletarNinja(id);
            return ResponseEntity
                    .ok("Ninja ID " + id + " deletado com sucesso!");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("O ninja com o id " + id + " não foi encontrado");
    }
}
