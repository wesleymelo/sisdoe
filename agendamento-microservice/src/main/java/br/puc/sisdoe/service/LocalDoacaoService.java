package br.puc.sisdoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.puc.sisdoe.dto.LocalizacaoDTO;
import br.puc.sisdoe.model.LocalDoacao;
import br.puc.sisdoe.repository.LocalDoacaoRepository;
import br.puc.sisdoe.util.CollectionUtil;

@Service
public class LocalDoacaoService {
	
	@Autowired
	private LocalDoacaoRepository localDoacaoRepository;
	
	public List<LocalDoacao> findAll(){
        return CollectionUtil.iterableToList(localDoacaoRepository.findAll());
    }
 
    public LocalDoacao findById(Long id){
        return localDoacaoRepository.findOne(id);
    }
 
    public LocalDoacao save(LocalDoacao localDoacao){
        return localDoacaoRepository.save(localDoacao);
    }
    
    public void delete(LocalDoacao localDoacao){
    	localDoacaoRepository.delete(localDoacao);
    }
    
	public List<LocalizacaoDTO> buscaLocaisDoacaoProximosPorLatLng(Double latitude, Double longitude){
    	return localDoacaoRepository.buscaLocaisDoacaoProximosPorLatLng(latitude, longitude);
    }
	
	public LatLng buscaGeocodePorCep(String cep) {
		
		// Replace the API key below with a valid API key.
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBwttNkmTfhD2jYxhF-a5FYlIm0iVAI_gI");
		context.setQueryRateLimit(10);
		GeocodingResult[] results = null;
		try {
			results = GeocodingApi.geocode(context,
			    //"30 22 19 01 - Paranoá, Brasília - DF, 69874-458").await();
					//"QNJ 11, Lotes 01, 03 e 05 - Taguatinga Norte, Brasília - DF, 72140-110").await();
					cep).await();
			
			if (results.length == 0) {
				Client c = Client.create();
				WebResource wr = c.resource("http://viacep.com.br/ws/" + cep + "/json/");
				String json = wr.get(String.class);
				Gson gson = new Gson();
				Local local = gson.fromJson(json, new TypeToken<Local>() {}.getType());
				results = GeocodingApi.geocode(context, local.getLocalCompleto()).await();
				System.out.println(local);
			}			
			
			if(results.length == 0){
				return null;
			}
			
			return results[0].geometry.location;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public LatLng buscaGeocodePorEnderecoAPartirDoCep(String cep) {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBwttNkmTfhD2jYxhF-a5FYlIm0iVAI_gI");
		context.setQueryRateLimit(10);
		GeocodingResult[] results = null;
		try {
			Client c = Client.create();
			WebResource wr = c.resource("http://viacep.com.br/ws/" + cep + "/json/");
			String json = wr.get(String.class);
			Gson gson = new Gson();
			Local local = gson.fromJson(json, new TypeToken<Local>() {}.getType());
			results = GeocodingApi.geocode(context, local.getLocalCompleto()).await();
			if(results.length == 0){
				return null;
			}
			return results[0].geometry.location;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	public static void main(String[] args) {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBwttNkmTfhD2jYxhF-a5FYlIm0iVAI_gI");
		context.setQueryRateLimit(10);
		GeocodingResult[] results = null;

		String cep = "71917000";

		try {
			results = GeocodingApi.geocode(context,
					// "30 22 19 01 - Paranoá, Brasília - DF,
					// 69874-458").await();
					// "QNJ 11, Lotes 01, 03 e 05 - Taguatinga Norte, Brasília -
					// DF, 72140-110").await();
					cep).await();

			if (results.length == 0) {
				Client c = Client.create();
				WebResource wr = c.resource("http://viacep.com.br/ws/" + cep + "/json/");
				String json = wr.get(String.class);
				Gson gson = new Gson();
				Local local = gson.fromJson(json, new TypeToken<Local>() {
				}.getType());
				System.out.println(local);

			}

			// return results[0].geometry.location;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Tamanho: " + results.length);

		for (GeocodingResult geocodingResult : results) {

			System.out.println("FormatAddress: " + geocodingResult.formattedAddress);
			System.out.println("LongName: " + geocodingResult.geometry.location);

			for (AddressComponent address : geocodingResult.addressComponents) {

				System.out.println("LongName: " + address.longName);
				System.out.println("LongName: " + address.shortName);

				for (AddressComponentType addressType : address.types) {
					System.out.println("Adress Type Name: " + addressType.name());
					System.out.println("Adress Type Ordinal: " + addressType.ordinal());
				}
			}

		}
	}*/
	
	protected class Local{
		
		private String cep;
		private String logradouro;
		private String complemento;
		private String bairro;
		private String localidade;
		private String uf;
		private String unidade;
		private String ibge;
		private String gia;
		
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getLogradouro() {
			return logradouro;
		}
		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}
		public String getComplemento() {
			return complemento;
		}
		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getLocalidade() {
			return localidade;
		}
		public void setLocalidade(String localidade) {
			this.localidade = localidade;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		public String getUnidade() {
			return unidade;
		}
		public void setUnidade(String unidade) {
			this.unidade = unidade;
		}
		public String getIbge() {
			return ibge;
		}
		public void setIbge(String ibge) {
			this.ibge = ibge;
		}
		public String getGia() {
			return gia;
		}
		public void setGia(String gia) {
			this.gia = gia;
		}
		@Override
		public String toString() {
			return "Local [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
					+ bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
		}
		
		public String getLocalCompleto() {
			return logradouro + " "+ bairro + " "+ localidade +" "+ uf;  
		}
		
	}
	
}
