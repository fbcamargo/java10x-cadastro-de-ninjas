package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDto ninjaDto) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDto.getId());
        ninjaModel.setNome(ninjaDto.getNome());
        ninjaModel.setEmail(ninjaDto.getEmail());
        ninjaModel.setIdade(ninjaDto.getIdade());
        ninjaModel.setImpUrl(ninjaDto.getImpUrl());
        ninjaModel.setRank(ninjaDto.getRank());
        ninjaModel.setMissoes(ninjaDto.getMissoes());
        return ninjaModel;
    }

    public NinjaDto map(NinjaModel ninjaModel) {
        NinjaDto ninjaDto = new NinjaDto();
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setNome(ninjaModel.getNome());
        ninjaDto.setEmail(ninjaModel.getEmail());
        ninjaDto.setRank(ninjaModel.getRank());
        ninjaDto.setIdade(ninjaModel.getIdade());
        ninjaDto.setImpUrl(ninjaModel.getImpUrl());
        ninjaDto.setMissoes(ninjaModel.getMissoes());
        return ninjaDto;
    }
}
