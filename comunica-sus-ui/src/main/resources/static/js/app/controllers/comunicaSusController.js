'use strict';

appSisDoeComunicaSUS.controller("ComunicaSusCtrl", [
	"$http",
	"$scope",
	"$filter",
	"$cookies",
	"$timeout",
	"AlertService",
	"ComunicaSusService", function ($http, $scope, $filter, $cookies, $timeout, AlertService, ComunicaSusService) {
		
	var ctrl = this;
	
	ctrl.resultadosExamesListados = [];
	ctrl.resultadosExames = [];
	ctrl.resultadosExamesSelecionados = [];
	ctrl.resultadoExameSelecionado = {};
	ctrl.itemByPage = 5;
	
    var getIndexResultadoExame = function(listaResultadosExames, element){
    	for(var i = 0; i < listaResultadosExames.length; i++ ){
    		if(listaResultadosExames[i].id == element.id){
    			return i;
    		}
    	}
    	return -1;
    }
    
    ctrl.selecionaResultadoExame=function(resultadoExame){
    	console.log('Resultado de exame selecionado para detalhamento: ', resultadoExame);
    	ctrl.resultadoExameSelecionado = angular.copy(resultadoExame);
    }

	ctrl.listAll = function(){
		ComunicaSusService.query(
				  function(data){
					  console.log('Resultados de exames consultados com sucesso!', data);
					  ctrl.resultadosExames = data;
					  ctrl.resultadosExamesSelecionados = angular.copy(ctrl.resultadosExames);
				  },
				  function(error){
					  ctrl.resultadosExames = [];
					  console.log('Problemas ao consultar os resultados de exames: ', error);
					  AlertService.addWarning('error', 'Houve um erro ao consultar os resultados de exames.', 5000);
				  }
		);
	}

	ctrl.enviar = function(){
		
		if(ctrl.resultadosExamesSelecionados.length == 0){
			AlertService.addWarning('error', 'É necessário selecionar algum resultado de exame.', 5000);
			return;
		}
		
		ComunicaSusService.enviar(
			  ctrl.resultadosExamesSelecionados,
			  function(data){
				  ctrl.atualizaResultadosExames();
				  ctrl.resultadosExamesSelecionados = [];
				  console.log('Resultados de exames enviados com sucesso!', data);
				  AlertService.addInfo('success', 'Resultados de exames enviados sucesso!', 5000);
			  },
			  function(error){
				  console.log('Problemas ao enviar os resultados de exames: ', error);
				  AlertService.addWarning('error', 'Houve um erro ao enviar os resultados de exames.', 5000);
			  }
	   );
    };
    
    ctrl.selResultadoExame=function($event, resultadoExameSelecionado){
    	if($event.currentTarget.checked){
    		ctrl.resultadosExamesSelecionados.push(resultadoExameSelecionado);
    	}else{
    		var index = getIndexResultadoExame(ctrl.resultadosExamesSelecionados, resultadoExameSelecionado);
    		if(index != -1){
    			ctrl.resultadosExamesSelecionados.splice(index, 1);    			
    		}
    	}
    	console.log("Resultado de exame selecionado: ", resultadoExameSelecionado);
    	console.log("Resultados de exames selecionados: ", ctrl.resultadosExamesSelecionados);
    }
    
    ctrl.selTodosResultadoExame=function($event){
    	if($event.currentTarget.checked){
    		ctrl.resultadosExamesSelecionados = angular.copy(ctrl.resultadosExames);
    	}else{
    		ctrl.resultadosExamesSelecionados = [];
    	}
    	console.log("Resultados de exames selecionados: ", ctrl.resultadosExamesSelecionados);
    }
    
    ctrl.atualizaResultadosExames=function(){
    	for(var i = 0; i < ctrl.resultadosExamesSelecionados.length; i++ ){
    		var indexResultado = getIndexResultadoExame(ctrl.resultadosExames,ctrl.resultadosExamesSelecionados[i]);
    		if(indexResultado != -1){
    			ctrl.resultadosExames.splice(indexResultado, 1);    			
    		}
    	}
    }
    
    ctrl.init = function(){
    	ctrl.listAll();
    };

    ctrl.init();

}]);
