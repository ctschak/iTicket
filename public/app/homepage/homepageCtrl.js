mainApp.controller('homepageCtrl', function ($scope, $rootScope, $log, $state, $stateParams, homepageService) {

    'use strict';

    $log.info('+ homepageCtrl()');
    $scope.test="ANGULAR TEST";
    $scope.started = false;
    $scope.named = false;
    $scope.option1 = false;
    $scope.username="";

    $scope.getAreas = function(){
	    var serviceURL = "/allarea";
	    var errorFn = function(data){				
			$scope.error = "No Data Found";
		}
		var successFn = function(data) {			
			$scope.allarea = data;
			$state.go("landing");
		}	
		homepageService.areaList(serviceURL).success(successFn).error(errorFn);
    }
});