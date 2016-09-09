'use strict';

appSisDoeAgendamentoOnline.factory("AgendamentoService", [ "$resource", function($resource) {
	return $resource(
		"https://agendamento-microservice.herokuapp.com/agendamento/", 
		{},
		{
			get:    { method:"GET", url: "https://agendamento-microservice.herokuapp.com/agendamento/:id", params: {id:"@id"} },
			getByDoador:    { method:"GET", url: "https://agendamento-microservice.herokuapp.com/agendamento/doador/:doador", params: {doador:"@doador"} },
			save:   { method:"POST" },
			query:  { method:"GET", isArray:true },
			update: { method:"PUT", url: "https://agendamento-microservice.herokuapp.com/agendamento/" },
			delete: { method:"DELETE", url: "https://agendamento-microservice.herokuapp.com/agendamento/:id", params: {id:"@id"} }
		}
	);
}]);
