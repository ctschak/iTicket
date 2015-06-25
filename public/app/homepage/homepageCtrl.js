mainApp.controller('homepageCtrl', function ($scope, $rootScope, $log, $state, $stateParams, homepageService,commonServices) {

    'use strict';

    $log.info('+ homepageCtrl()');
    $scope.test="ANGULAR TEST";
    $scope.loginscreen= false;
    $scope.tickets;
    $scope.agents;
    $scope.viewTicket = {};
    $scope.fieldDisabled = true;
    $scope.error;
    
    
    $scope.getTicketDetails = function(){
    	var serviceURL = "/alltickets";
	    var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.tickets = data;
			$state.go("home");   
		}	
		homepageService.getTicketDetails(serviceURL).success(successFn).error(errorFn);   
    }
    
    $scope.saveorupdate = function(){
    	var serviceURL = "/saveorupdate";
    	var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.viewTicket = data;
			$scope.getTicketDetails();  
		}	
		homepageService.saveorupdate(serviceURL,$scope.viewTicket).success(successFn).error(errorFn);
    }
    $scope.viewTicketDetails = function(ticket){
    	$scope.viewTicket = ticket;
    }
    $scope.clearfields = function(){
    	$scope.viewTicket = {};
    }
    $scope.newTicket = function(){
    	$scope.viewTicket = {};
    	$scope.viewTicket.ticket_id = commonServices.getRandomNumber();
    	$scope.fieldDisabled = false;
    }
    $scope.getAgentInfo = function(){
    	var serviceURL = "/allagents";
	    var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.agents = data;
		}	
		homepageService.getAgentDetails(serviceURL).success(successFn).error(errorFn);
    }
    $scope.getAgentInfo();
    $scope.getTicketDetails();
   
   
});