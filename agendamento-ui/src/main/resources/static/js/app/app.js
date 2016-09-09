'use strict';

var appSisDoeAgendamentoOnline =  angular.module('appSisDoeAgendamentoOnline', [
    'ngRoute',
    "ngResource",
    "ngCookies",
    "angular-jwt"
  ]);

appSisDoeAgendamentoOnline.factory('httpRequestInterceptor', function ($cookies) {
	  return {
	    request: function (config) {
	      var token_xsrf = $cookies.get("XSRF-TOKEN");
	      var token_access = $cookies.get("TOKEN-ACCESS");
	      
	      if (token_xsrf) {
	    	  //config.headers['X-XSRF-TOKEN'] = token_xsrf;
	    	  //console.log("X-XSRF-TOKEN: " + token_xsrf);
	      }
	      
	      if(token_access){
	    	  //config.headers['Authorization'] = 'Bearer ' + token_access;
	    	  config.headers.authorization = 'Bearer ' + token_access;
	    	  //console.log("TOKEN-ACCESS: " + token_access);
	      }
	      
	      console.log("Request: ", config);
	      return config;
	    }
	  };
});

appSisDoeAgendamentoOnline.config(function ($httpProvider) {
	  $httpProvider.defaults.headers.common['X-Requested-With'];
	  //$httpProvider.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8';
	  //$httpProvider.defaults.headers.post['Accept'] = 'application/json';
	  $httpProvider.interceptors.push('httpRequestInterceptor');
});