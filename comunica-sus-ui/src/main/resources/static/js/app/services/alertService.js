'use strict';

appSisDoeComunicaSUS.factory('AlertService', ['$rootScope', '$timeout', function($rootScope, $timeout) {
    var alertService = {};

    // create an array of alerts available globally
    $rootScope.alertsInfo = [];
    $rootScope.alertsWarning = [];

    alertService.addWarning = function(type, msg, timeout) {
    	alertService.closeAllAlert();
    	$rootScope.alertsWarning.push({'type': type, 'msg': msg});   
    	
    	$timeout(function(){
             alertService.closeAlertWarning(this);
        }, timeout);
    	
    };
    
    alertService.addInfo = function(type, msg, timeout) {
    	alertService.closeAllAlert();
    	$rootScope.alertsInfo.push({'type': type, 'msg': msg});

    	$timeout(function(){
            alertService.closeAlertInfo(this);
    	}, timeout);
    };
    
    alertService.closeAlertInfo = function(index) {
    	$rootScope.alertsInfo.splice(index, 1);
    };
    
    alertService.closeAlertWarning = function(index) {
        $rootScope.alertsWarning.splice(index, 1);
    };
    
    alertService.closeAlertInfoObj = function (alert) {
        this.closeAlertInfo($rootScope.alertsInfo.indexOf(alert));
    };
    
    alertService.closeAlertWarningObj = function (alert) {
        this.closeAlertWarning($rootScope.alertsWarning.indexOf(alert));
    };
    
    alertService.closeAllAlert = function () {
        $rootScope.alertsInfo = [];
        $rootScope.alertsWarning = [];
    };

    return alertService;
}]);