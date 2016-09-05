'use strict';

appSisDoeComunicaSUS.factory("ComunicaSusService", [ "$resource", function($resource) {
	return $resource(
		"https://comunica-sus-microservice.herokuapp.com/resultadoExame", 
		{},
		{
			enviar: { method:"POST", url: "https://comunica-sus-microservice.herokuapp.com/resultadoExame/enviaResultadosExamesSUS", isArray: true },
			query:  { method:"GET", isArray:true },
		}
	);
}]);
