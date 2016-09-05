package br.puc.sisdoe.repository;

import java.util.List;

import javax.transaction.Transactional;

import br.puc.sisdoe.dto.LocalizacaoDTO;

@Transactional
public interface LocalDoacaoRepositoryCustom{
	
	List<LocalizacaoDTO> buscaLocaisDoacaoProximosPorLatLng(Double latitude, Double longitude);

}
