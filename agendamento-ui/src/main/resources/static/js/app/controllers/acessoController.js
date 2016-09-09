'use strict';

appSisDoeAgendamentoOnline.controller("AcessoCtrl", [
	"$scope",
	"AcessoService", 
	"AlertService", function ($scope, AcessoService, AlertService) {
 
	$scope.user = {};
	
	$scope.getUser = function(){
		AcessoService.obtainUser().then(function(response){
			$scope.user = response.data;
			console.log("Response Data User: ", response.data);
	    }, function(error ){
	    	console.log("Erro ao obter o usuário autenticado: ", error);
	    });
	}
								
	$scope.logout = function() {
		AcessoService.logout().then(function() {
			console.log("Logout realizado com sucesso!");
			AlertService.addWarning('success', 'Logout realizado com sucesso.', 5000);
		}).error(function(data) {
			console.log("Logout não realizado.");
			AlertService.addWarning('error', 'Logout não pode ser realizado.', 5000);
		});
	}
	
	$scope.getUser();
}]);
