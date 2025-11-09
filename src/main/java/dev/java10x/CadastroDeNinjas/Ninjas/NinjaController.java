package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public NinjaDto criarNinja(@RequestBody NinjaDto ninjaDto) {
        return ninjaService.criarNinja(ninjaDto);
    }

    // Listar Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return this.ninjaService.listarNinjas();
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/detalhes/{id}")
    public NinjaModel procurarNinja(@PathVariable Long id) {
        return this.ninjaService.procurarNinja(id);
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaModel) {
        return this.ninjaService.atualizarNinja(id, ninjaModel);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deletarNinja(@PathVariable Long id) {
        this.ninjaService.deletarNinja(id);
    }
}
