mainApp.controller('landingCtrl', function ($scope, $rootScope, $log, $state, $stateParams, landingService) {

    'use strict';

    $log.info('+ landingCtrl()');
    $scope.test="ANGULAR TEST";
    $scope.started = false;
    $scope.named = false;
    $scope.option1 = false;
    $scope.username="";

    /*$scope.showOptions = function(){
    	$state.go("Search");
    }*/
    $scope.getAreas = function(){
	    var serviceURL = "/allarea";
	    var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.allarea = data;
			$state.go("landing");
		}	
		landingService.areaList(serviceURL).success(successFn).error(errorFn);
    }
});