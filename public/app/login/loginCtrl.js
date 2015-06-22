mainApp.controller('loginCtrl',
	['$scope', '$rootScope', '$log', '$state', '$stateParams','loginService', 
	function ($scope, $rootScope, $log, $state, $stateParams,loginService) {
    'use strict';

    $log.info('+ loginCtrl()');
    $scope.test="ANGULAR TEST";
    $scope.newui= true;

    $scope.login = function ( username, password ) {
		// Simulate post request to server for authentication //
		
		var credentials = {username:$scope.username,pass:$scope.password};
		var authServiceURL = "app/test/status.json"; // used json file instead of web service url.
		
		var errorFn = function(data){				
			$rootScope.isAuthenticated = false;	
			$rootScope.username = "";
			$scope.loginError = "Invalid username/password combination";
		}
		
		var successFn = function(data) {			
			
			if (data.server_response.success == "true"){// validate response from server if required.
			
				$rootScope.isAuthenticated = true;
				$rootScope.username = credentials.username;
			//	$cookieStore.put('username',credentials.username);
			//	$cookieStore.put('isAuthenticated',"true");
				
				// $location.url("/");
				
				$state.go("landing");
				
				/*if (checkIfLoggedIn()){

											
				}else{
					LocalStore.set('loggedIn','1');																
				}*/
				
			}else{
				errorFn(data);
			}
			
		}
		
		/*function checkIfLoggedIn() {
			if (LocalStore.get('loggedIn') == '1'){
				return true;
			}else{
				return false;
			}
		}*/
		
		loginService.login(authServiceURL, credentials).success(successFn).error(errorFn);
		
  	};
	
  	$scope.register = function(){
  		$state.go("register");
  	};
  	
  	$scope.gotoLogin = function(){
  		$state.go("login");
  	};

}]);