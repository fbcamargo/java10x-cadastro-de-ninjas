package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Listar Ninjas (READ)
    @GetMapping("/todos")
    public String listarNinjas() {
        return "Ninjas listados";
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/todosID")
    public String procurarNinja() {
        return "Ninja obtido";
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja alterado";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinja() {
        return "Ninja removido";
    }
}
