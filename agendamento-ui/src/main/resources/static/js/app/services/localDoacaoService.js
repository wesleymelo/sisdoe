'use strict';

appSisDoeAgendamentoOnline.factory("LocalDoacaoService", [ "$resource", function($resource) {
	return $resource(
		"https://agendamento-microservice.herokuapp.com/localDoacao/:id", 
		{id: "@id"}, 
		{
			queryPorLatLngAndCep: { method : "GET", url: "https://agendamento-microservice.herokuapp.com/localDoacao/lat/:lat/lng/:lng/cep/:cep", params: {cep: "@cep", lat: "@lat", lng: "@lng"}, isArray : true},
			get:   { method : "GET" },
			queryPorCep:   { method : "GET", url: "https://agendamento-microservice.herokuapp.com/localDoacao/cep/:cep", params: {cep: "@cep"}, isArray: true }
		}
	);
}]);