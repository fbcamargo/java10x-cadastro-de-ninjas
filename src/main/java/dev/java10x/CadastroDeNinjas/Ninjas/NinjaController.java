package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
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
    public ResponseEntity<?> procurarNinja(@PathVariable Long id) {
        if(this.ninjaService.procurarNinja(id) != null) {
            NinjaDto ninjaDto = this.ninjaService.procurarNinja(id);
            return ResponseEntity.ok(ninjaDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID " + id + " não encontrado");
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDto ninjaDto) {
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
