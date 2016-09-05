'use strict';

appSisDoeComunicaSUS.controller("AcessoCtrl", [
	"$rootScope",
	"$scope",
	"$cookies",
	"AcessoService", 
	"AlertService", function ($rootScope, $scope, $cookies, AcessoService, AlertService) {
 
	$scope.user = {};
	
	$scope.getUser = function(){
		AcessoService.obtainUser().then(function(response){
			$scope.user = response.data;
			
			if(typeof(response.data.details.tokenValue) != 'undefined'){
				$cookies.put("TOKEN-ACCESS", response.data.details.tokenValue);				
				console.log("TOKEN-ACCESS", response.data.details.tokenValue);
				$rootScope.authenticated = true;
			}else{
				$rootScope.authenticated = false;
			}
	    }, function(error ){
	    	console.log("Erro ao obter o usuário autenticado: ", error);
	    	$rootScope.authenticated = false;
	    });
	}
								
	$scope.logout = function() {
		AcessoService.logout().then(function() {
			$rootScope.authenticated = false;
			$cookies.remove("TOKEN-ACCESS");
		}, function(error) {
			$rootScope.authenticated = false;
			AlertService.addWarning('error', 'Logout não pode ser realizado.', 5000);
		});
	}
	
	$scope.getUser();
}]);
