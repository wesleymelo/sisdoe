'use strict';

appSisDoeAgendamentoOnline.factory("userService", [ "$resource", function($resource) {
	return $resource("/uaa/user", {}, {
		query : {
			method : "GET",
			isArray : true
		}
	});
}]);