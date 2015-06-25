
var mainApp = angular.module("mainApp",[
	'ngTable',
	'ngResource',
    'ui.router'
]);

mainApp.config(function ($stateProvider, $urlRouterProvider, $httpProvider ) {
    'use strict';

    
    //initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    //disable IE ajax request caching
    $httpProvider.defaults.headers.get['If-Modified-Since'] = '0';
	
    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'app/homepage/homepage.tpl.html',
            controller: 'homepageCtrl'
        })
        .state('login', {
            url: '/login',
            templateUrl: 'app/login/login.tpl.html',
            controller: 'loginCtrl'
        })
    	;

        //Re-directs
        $urlRouterProvider.otherwise('/login');

});
mainApp.run(function ($log, $rootScope, $state, $urlRouter,$location) { // Inject Service to load data
    $log.debug("mainApp.run");
    $state.transitionTo('home');
});
