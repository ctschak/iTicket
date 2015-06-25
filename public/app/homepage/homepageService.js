mainApp.factory('homepageService', ['$http', function ($http) {	
	'use strict';
	return {
		 getTicketDetails: function (url) {
			  return $http.get(url);
		 },
		 getAgentDetails: function (url) {
			  return $http.get(url);
		 },  
		 saveorupdate: function (url,data) {
			  return $http.post(url,data,{
				  headers: {
					   'Content-Type': 'application/json'
					 }
			  });
		 }
	};	
}]);
