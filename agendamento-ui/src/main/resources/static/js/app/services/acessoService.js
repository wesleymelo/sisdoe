'use strict';

appSisDoeAgendamentoOnline.factory('AcessoService', [ 	
	"$http", "$cookies", "$rootScope", function ($http, $cookies, $rootScope) {
	    
		var AcessoService = {
				obtainUser : function() {
				      return $http.get('/user').then(
				    		  function(response){
				    			  console.log("Sucess obtainUser: ", response);
				    			  if(typeof(response.data.details.tokenValue) != 'undefined'){
				    			     $cookies.put("TOKEN-ACCESS", response.data.details.tokenValue);
				    			     console.log("COOKIE TOKEN_ACESS", $cookies.get("TOKEN-ACCESS"));
				    				 $rootScope.authenticated = true;
				    			  }else{
				    				 $rootScope.authenticated = false;
				    			  }
				    			  return response;
				    		  },function(response){
				    			  console.log("Error obtainUser: ", response);
				    			  $rootScope.authenticated = false;
				    			  return response;
				    		  }
				      );
			    },
			    
			    logout : function() {
				      return $http.post('https://oauth-server-sisdoe.herokuapp.com/uaa/logout').then(
				    		  function(response){
				    			  console.log("Sucess obtainUser: ", response);
				    			  $rootScope.authenticated = false;
					    		  $cookies.remove("JSESSIONID");
				    			  $cookies.remove("TOKEN-ACCESS");
				    			  window.location = "https://oauth-server-sisdoe.herokuapp.com/uaa/login"
				    			  return response;
				    		  },function(response){
				    			  $cookies.remove("JSESSIONID");
				    			  $cookies.remove("TOKEN-ACCESS");
				    			  console.log("Error obtainUser: ", response);
				    			  window.location = "https://oauth-server-sisdoe.herokuapp.com/uaa/login"
				    			  return response;
				    		  }
				      );
			    }
			    
			    
		};
	    
	    return AcessoService;
}]);