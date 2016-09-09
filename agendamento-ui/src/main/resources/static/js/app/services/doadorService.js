'use strict';

appSisDoeAgendamentoOnline.factory("doadorService", [ "$resource", function($resource) {
	return $resource("https://agendamento-microservice.herokuapp.com/doador", {}, {
		query : {
			method : "GET",
			isArray : true
		},
		create : {
			method : "POST"
		},
		get : {
			method : "GET",
			url : "https://agendamento-microservice.herokuapp.com/doador/:id"
		},
		remove : {
			method : "DELETE",
			url : "https://agendamento-microservice.herokuapp.com/doador/:id"
		},
		update : {
			method : "PUT"
		}
	});
}]);