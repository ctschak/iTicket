mainApp.controller('userpageCtrl', function ($scope, $rootScope, $log, $state, $stateParams,userpageService) {

    'use strict';
    $log.info('+ userpageCtrl()');
    $scope.userDetail ={};
    $scope.loginscreen= false;    
    $scope.saveorupdate = function(){
   // console.log('i am in save method');
    var serviceURL = "/saveorupdateuser";    
    var errorFn = function(){
    	//console.log('i am in error method');
			$scope.error = "No Data Found";
		}
    var successFn = function(data) {
    	//console.log('i am in sucess method');
		$scope.viewTicket = data;
		
	} 
   // console.log('i am in before method');
	userpageService.saveorupdate(serviceURL,$scope.userDetail).success(successFn).error(errorFn);
    }  
     $scope.clearfields = function(){
    	$scope.userDetail = {};
    }   
});