package br.puc.sisdoe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.puc.sisdoe.dto.LocalizacaoDTO;

public class LocalDoacaoRepositoryImpl implements LocalDoacaoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
	
	@Override
	public List<LocalizacaoDTO> buscaLocaisDoacaoProximosPorLatLng(Double latitude, Double longitude) {
		
		String sql = " SELECT new br.puc.sisdoe.dto.LocalizacaoDTO(l,  " +
						" (6371 * acos( " +
							 "cos( radians( :latitude ) ) "+
							 "* cos( radians( l.latitude) ) "+
							 "* cos( radians( l.longitude ) - radians( :longitude ) ) "+
							 "+ sin( radians( :latitude ) ) "+
							 "* sin( radians( l.latitude ) ) "+
							 ") "+
							") AS distancia ) "+
					" FROM LocalDoacao l "+
					//" HAVING distancia < 100 "+
					" ORDER BY distancia ASC ";
					//" LIMIT 5 ";
		
		 Query query = em.createQuery(sql);
		 query.setParameter("latitude", latitude);
		 query.setParameter("longitude", longitude);
		 
		 @SuppressWarnings("unchecked")
		 List<LocalizacaoDTO> localizacoesDTO = query.setMaxResults(5).getResultList();
		 
		 return localizacoesDTO;
	}

}
