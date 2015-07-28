mainApp.controller('userpageCtrl', function ($scope, $rootScope, $log, $state, $stateParams) {

    'use strict';

    $log.info('+ userpageCtrl()');
    $scope.userDetail ={};
    $scope.loginscreen= false;
    
    $scope.saveorupdate = function(){
    var serviceURL = "/saveorupdateuser";
    
    var errorFn = function(){				
			$scope.error = "No Data Found";
		}
    }
    
     $scope.clearfields = function(){
    	$scope.userDetail = {};
    }
    
   
   
});