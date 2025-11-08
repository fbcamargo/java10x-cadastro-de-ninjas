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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
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
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja alterado";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/delete")
    public String deletarNinja() {
        return "Ninja removido";
    }
}
