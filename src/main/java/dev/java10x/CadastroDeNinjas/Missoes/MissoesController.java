package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    // GET -- Mandar uma requisição para listar missões
    @GetMapping("/listar")
    public String listarMissao() {
        return "Missão listadas com sucesso!";
    }

    // POST -- Mandar uma requisição para criar missões
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso!";
    }

    // PUT -- Mandar uma requisição para alterar missões
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso!";
    }

    // DELETE -- Mandar uma requisição para deletar missões
    @DeleteMapping("/delete")
    public String deletarMissao() {
        return "Missão deletar com sucesso!";
    }
}
