mainApp.factory('userpageService', ['$http', function ($http) {	
	'use strict';
	return {
		 
		 saveorupdate: function (url,data) {
			 console.log('i am in userservicemethod method'+data);
			  return $http.post(url,data,{
				  headers: {
					   'Content-Type': 'application/json'
					 }
			  });
		 }
	};	
}]);
