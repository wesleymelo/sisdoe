'use strict';

appSisDoeAgendamentoOnline.controller("AgendamentoCtrl", [
	"$http",
	"$scope",
	"$filter",
	"$cookies",
	"$timeout",
	"AlertService",
	"AgendamentoService",
	"LocalDoacaoService",
	"AcessoService", function ($http, $scope, $filter, $cookies, $timeout, AlertService, AgendamentoService, LocalDoacaoService, AcessoService) {
		
	var ctrl = this;
	
	ctrl.agendamento = {id: "", idDoador: "1", idLocalDoacao: "", data: "", hora: "", dataHora: ""};
	ctrl.agendamentoFound = {};
	ctrl.locaisDoacao = [];
	ctrl.localizacao = {lat: "", lng: "", cep: ""};
	ctrl.agendamentos = [];
    ctrl.selIdLocalDoacao = {};
    ctrl.selIndexLocalDoacao = {};
    ctrl.localDoacaoSelected = {};
    ctrl.showFormLocalizacao = true;
    
    ctrl.changeCEP = function($event) {
		var cep = angular.copy(ctrl.localizacao.cep);
		cep = cep.replace(".", "").replace("-", "");
		if(cep.length >= 0 && cep.length < 7){
			return;
		}
        $timeout(function() {
            angular.element($event.target.form).triggerHandler('submit');
        });
    };
	
	ctrl.buscarLocaisDoacao = function(){
		var cep = angular.copy(ctrl.localizacao.cep);
		var cepPadrao = "00000000";
		cep = cep.replace(".", "").replace("-", "");
		if(cep.length == 0){
			cep = cepPadrao;
		}
		if(cep.length > 0 && cep.length < 8){
			return;
		}
		console.log("Lat: ", ctrl.localizacao.lat);
		console.log("Lng: ", ctrl.localizacao.lng);
		console.log("cep: ", ctrl.localizacao.cep);
		
		if(cep !== cepPadrao){
			ctrl.locaisDoacao = LocalDoacaoService.queryPorCep({},{'cep': cep});
		}else{
			ctrl.locaisDoacao = LocalDoacaoService.queryPorLatLngAndCep({},{'cep': cep, 'lat': ctrl.localizacao.lat, 'lng': ctrl.localizacao.lng});			
		}
		
		
		console.log("Locais Doação: ", ctrl.locaisDoacao);
	}
	
    ctrl.selLocalDoacaoWithIndex=function(local,idLocalDoacao){
    	console.log("Local doação selecionado: ", local + " - "+ idLocalDoacao);
    	ctrl.localDoacaoSelected=local.localDoacao;
        ctrl.agendamento.idLocalDoacao=local.localDoacao.id;
        ctrl.selIndexLocalDoacao = idLocalDoacao;
    }
    
    ctrl.selLocalDoacao=function(local){
    	console.log("Local doação selecionado: ", local);
    	ctrl.localDoacaoSelected=local;
        ctrl.agendamento.idLocalDoacao=local.id;
        ctrl.selIndexLocalDoacao = ctrl.locaisDoacao.indexOf(local);
    }

    ctrl.isSelLocalDoacao=function(local){
        return ctrl.localDoacaoSelected===local.localDoacao;
    }
    	
	ctrl.listAll = function(){
		ctrl.agendamentos = AgendamentoService.query();
	}

	ctrl.create = function(){
		ctrl.agendamentoFound = AgendamentoService.save(
			  ctrl.agendamento,
			  function(data){
				  console.log('Agendamento salvo', data);
				  ctrl.agendamentoFound.localDoacao = LocalDoacaoService.get({id: data.idLocalDoacao});
				  ctrl.showForm = false;
				  ctrl.localizacao.cep = "";
				  AlertService.addInfo('success', 'Agendamento salvo com sucesso!', 5000);
			  },
			  function(error){
				  console.log('Problemas ao salvar o agendamento: ', error);
				  AlertService.addWarning('error', 'Houve um erro ao salvar o agendamento.', 5000);
			  }
	   );
    };

    ctrl.update = function() {
       ctrl.agendamentoFound = AgendamentoService.update(
    		  ctrl.agendamento,
    		  function(data){
    			  console.log('Agendamento atualizado', data);
    			  ctrl.agendamentoFound.localDoacao = LocalDoacaoService.get({id: data.idLocalDoacao});
    			  ctrl.showForm = false;
    			  ctrl.localizacao.cep = "";
    			  AlertService.addInfo('success', 'Agendamento atualizado com sucesso!', 5000);
    		  },
    		  function(error){
    			  console.log('Problemas ao atualizar o agendamento', error);
    			  AlertService.addWarning('error', 'Houve um erro ao atualizar o agendamento.', 5000);
    		  }
      );
    };
    
    ctrl.delete = function(){
       if(ctrl.confirmDelete(true)) {
    	   AgendamentoService.delete(
    		   	{id: ctrl.agendamentoFound.id},	  
    		   		function(data){
    		   			console.log('Deleting agendamento with id ', ctrl.agendamentoFound.id);
    		   			console.log('Deleting agendamento:  ', data);
    			   		AlertService.addInfo('success', 'Agendamento excluído com sucesso!', 5000);
    			   		ctrl.reset();
    		   		},
    		   		function(error){
    		   			console.log('Problemas ao deletar o agendamento', error);
    			   	    AlertService.addWarning('error', 'Houve um erro ao excluir o agendamento.', 5000);
    		   		}
    	   );	   
       }
   	   
    };
    
    ctrl.confirmDelete = function(confirmation){
        return confirmation ? confirm('Confirmação. Deseja realmente excluir o agendamento?') : true;
    };

        
    ctrl.edit = function(){
    	ctrl.agendamento = ctrl.agendamentoFound;
    	ctrl.selLocalDoacao(ctrl.agendamento.localDoacao);
    	ctrl.agendamentoFound = {};
    	ctrl.agendamento.data = $filter('date')(ctrl.agendamento.data, 'dd/MM/yyyy');
    	ctrl.agendamento.hora = $filter('date')(ctrl.agendamento.hora, 'HH:mm');
    	ctrl.showFormLocalizacao = false;
        console.log('Agendamento to be edited', ctrl.agendamento);
        console.log('AgendamentoFound is', ctrl.agendamentoFound);
    };
    
    ctrl.save = function(){
    	if(!ctrl.agendamento.idLocalDoacao){
    		AlertService.addWarning('error', 'Local de doação do agendamento é obrigatório. Por favor, selecione.', 5000);
    		return;
    	}
    	if(!ctrl.agendamento.data){
    		AlertService.addWarning('error', 'Data do agendamento é obrigatório. Por favor, informe.', 5000);
    		return;
    	}
    	if(!ctrl.agendamento.hora){
    		AlertService.addWarning('error', 'Hora do agendamento é obrigatório. Por favor, informe.', 5000);
    		return;
    	}
        ctrl.agendamento.dataHora = ctrl.agendamento.data + " " + ctrl.agendamento.hora; 	
        if(ctrl.agendamento.id == ""){
      	   console.log('Saving New Agendamento', ctrl.agendamento); 
    	   ctrl.create();
        } else {
           console.log('Upddating Agendamento', ctrl.agendamento); 
    	   ctrl.update();
    	   console.log('Agendamento updated', ctrl.agendamento);
        }
    };
    
    ctrl.reset = function(){
  		 ctrl.agendamento = {id: "", idDoador: "1", idLocalDoacao: "", data: "", hora: "", dataHora: ""};
   		 ctrl.agendamentoFound = {};
   		 ctrl.showForm = true;
   		 ctrl.showFormLocalizacao = true;
   		 ctrl.selIdLocalDoacao = {};
   		 ctrl.selIndexLocalDoacao = {};
   		 ctrl.localDoacaoSelected = {};
   		 ctrl.localizacao.cep = "";
         //ctrl.formAgendamento.$setPristine(); //reset Form
    };
    
    ctrl.localizacaoCompleta = function(){
    	if(typeof ctrl.agendamento.localDoacao !== "undefined" && ctrl.agendamento.localDoacao.nome != null){
    		return ctrl.agendamento.localDoacao.nome + " - " + ctrl.agendamento.localDoacao.endereco;     		
    	}
    };
    
    /**
     * Method for class initialization
     * @return {[type]} [description]
     */
    ctrl.initAccess = function(){
    	
	   AcessoService.obtainUser().then(function(response){
			$scope.user = response.data;
			console.log("Response Data User: ", response.data);
			ctrl.init();
	   }, function(error ){
	    	console.log("Erro ao obter o usuário autenticado: ", error);
	   });
    };
    
    /**
     * Method for class initialization
     * @return {[type]} [description]
     */
    ctrl.init = function(){
       ctrl.agendamentoFound = AgendamentoService.getByDoador({doador:"1"},
    	  function(data) {
    	   	  console.log('Consulta ao agendamento pelo doador realizada com sucesso ', ctrl.agendamentoFound);
    	   	  
    	   	  if( typeof ctrl.agendamentoFound.id !== 'undefined' && ctrl.agendamentoFound.id != '' && ctrl.agendamentoFound.id != null){
    	   		  ctrl.agendamentoFound.localDoacao = LocalDoacaoService.get({id: ctrl.agendamentoFound.idLocalDoacao},
    	   				  function (data){
    	   			  console.log('Consulta ao local de doação do agendamento realizada com sucesso ', data);
	    	   	      if( typeof data.id === 'undefined'){
	    	   	    	  ctrl.showForm = true;
	    	   	      }else{
	    	   	    	  ctrl.showForm = false;
	    	   	      }
    	   		  },
    	   		  function (e){
    	   			  console.log('Consulta ao local de doação do agendamento não realizada ', e);
    	   		  }
    	   		  );    	   		  
    	   	  }else{
    	   		  ctrl.showForm = true;
    	   		  console.log('Sem dados de agendamento e local doação');
    	   	  }
    	   	  
       	  },
       	  function(e) {
       		  console.log('Problemas ao realizar a consulta', e);
       		  AlertService.addWarning('error', 'Houve um erro ao consultar o agendamento realizado.', 5000);
     	  }
       );
       console.log("Agendamento Found: ", ctrl.agendamentoFound);
    };
    
    /*
    angular.element(document).ready(function () {
    	ctrl.locaisDoacao = LocalDoacaoService.query({},{'cep': '00000000', 'lat': ctrl.localizacao.lat, 'lng': ctrl.localizacao.lng});
    	console.log("consulta inicial realizada.", ctrl.locaisDoacao);
    });*/

    ctrl.initAccess();

}]);
