mainApp.factory('landingService', ['$http', function ($http) {	
	'use strict';
	return {
		 areaList: function (url) {
			  return $http.get(url);
		 },
		 locationList: function (url) {
			  return $http.get(url);
		 }
	};	
}]);
