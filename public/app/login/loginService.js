mainApp.factory('loginService', ['$http', function ($http) {	
	'use strict';
	return {
		 login: function (url,data) {
			  return $http.get(url);    
		}
	};	
}]);
