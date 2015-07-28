mainApp.factory('userpageService', ['$http', function ($http) {	
	'use strict';
	return {
		 
		 saveorupdate: function (url,data) {
			  return $http.post(url,data,{
				  headers: {
					   'Content-Type': 'application/json'
					 }
			  });
		 }
	};	
}]);
