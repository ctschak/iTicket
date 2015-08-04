mainApp.controller('userpageCtrl', function ($scope, $rootScope, $log, $state, $stateParams,userpageService) {

    'use strict';
    $log.info('+ userpageCtrl()');
    $scope.userDetail ={};
    $scope.error;
    $scope.loginscreen= false; 
    $scope.validationResult =true;
    $scope.userDetail.first_name = 'Hi' ;
    $scope.saveorupdate = function(){
    console.log( $scope.error);
    var serviceURL = "/saveorupdateuser";    
    var errorFn = function(){
    	    console.log('i am in error method');
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
     
     $scope.validateFormField= function(){
    	 if($scope.userDetail!==null && $scope.userDetail.first_name.$error && $scope.userDetail.first_name.$error  && $scope.userDetail.first_name.$dirty && $scope.userDetail.first_name.$invalid ){
    		 console.log('i am in validateFormField  method');
    		 $scope.validationResult = false; 
    	 }
    	 return $scope.validationResult;
     }
});