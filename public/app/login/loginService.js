mainApp.factory('loginService', ['$http', function ($http) {	
	'use strict';
	return {
		 login: function (url,credentials) {
			  return $http.get(url, credentials);
		}
	};	
}]);
