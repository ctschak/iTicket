mainApp.factory('homepageService', ['$http', function ($http) {	
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
