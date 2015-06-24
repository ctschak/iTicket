mainApp.controller('homepageCtrl', function ($scope, $rootScope, $log, $state, $stateParams, homepageService,commonServices) {

    'use strict';

    $log.info('+ homepageCtrl()');
    $scope.test="ANGULAR TEST";
    $scope.loginscreen= false;
    $scope.tickets;
    $scope.viewTicket;
    $scope.fieldDisabled = true;
    
    $scope.getTicketDetails = function(){
    	var serviceURL = "/alltickets";
	    var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.tickets = data;
			$state.go("home");   
		}	
		homepageService.areaList(serviceURL).success(successFn).error(errorFn);
    }
    
    $scope.saveorupdate = function(){
    	var serviceURL = "/saveorupdate"
    	var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.tickets = data;
			$state.go("home");   
		}	
		homepageService.saveorupdate(serviceURL).success(successFn).error(errorFn);
    }
    
    $scope.clearfields = function(){
    	$scope.viewTicket = null;
    }
    $scope.newTicket = function(){
    	$scope.viewTicket = null;
    	$scope.viewTicket.ticket_id = commonServices.getRandomNumber();
    	$scope.fieldDisabled = false;
    }
    $scope.getTicketDetails();
   
});