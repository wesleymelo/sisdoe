'use strict';

appSisDoeAgendamentoOnline.factory('AcessoService', [ 	
	"$http", function ($http) {
	    
		var AcessoService = {
				obtainUser : function() {
				      return $http.get('/user').then(
				    		  function(response){
				    			  console.log("Sucess obtainUser: ", response);
				    			  return response;
				    		  },function(response){
				    			  console.log("Error obtainUser: ", response);
				    			  return response;
				    		  }
				      );
			    },
			    
			    logout : function() {
				      return $http.post('https://oauth-server-sisdoe.herokuapp.com/uaa/logout').then(
				    		  function(response){
				    			  console.log("Sucess obtainUser: ", response);
				    			  return response;
				    		  },function(response){
				    			  console.log("Error obtainUser: ", response);
				    			  return response;
				    		  }
				      );
			    }
			    
			    
		};
	    
	    return AcessoService;
}]);