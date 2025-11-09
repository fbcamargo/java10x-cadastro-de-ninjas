package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaDto> listarNinjas() {
        List<NinjaModel> ninjas = this.ninjaRepository.findAll();
        return ninjas.stream()
            .map(ninjaMapper::map)
            .collect(Collectors.toList());
    }

    // Detalhes de um ninja
    public NinjaDto procurarNinja(Long id) {
        Optional<NinjaModel> ninjaModel = this.ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    // Criar um ninja
    public NinjaDto criarNinja(NinjaDto ninjaDto) {
        NinjaModel ninja = ninjaMapper.map(ninjaDto);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar o ninja - Tem que ser void
    public void deletarNinja(Long id) {
        this.ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja (PUT)
    public NinjaDto atualizarNinja(Long id, NinjaDto ninjaDto) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()) {
            NinjaModel ninjaModel = ninjaMapper.map(ninjaDto);
            ninjaModel.setId((id));
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(ninjaSalvo);
        }
        return  null;
    }
}
