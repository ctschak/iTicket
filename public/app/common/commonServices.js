mainApp.factory('commonServices', function () {	
	'use strict';
	return {
		isNotNull : function(data){
			return ((data !== undefined) && (data !== null));
		},
		getRandomNumber : function(){
			return Math.floor(Math.random()*899999+100000);
		}
	};
	
	
});