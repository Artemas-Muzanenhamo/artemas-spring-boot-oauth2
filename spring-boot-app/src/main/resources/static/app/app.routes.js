'use strict';

pictopage.config(["$routeProvider", "$stateProvider", "$urlRouterProvider", "$httpProvider",
                  
  function($routeProvider, $stateProvider, $urlRouterProvider, $httpProvider){
	
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
	// route for the homepage
	.state('/login', {
		url: '/login',
		templateUrl : 'login.html',
		controller : 'login'
	}).state('/home', {
		url: '/home',
		templateUrl : '../app/home/home.html',
		controller : 'home',
		controllerAs: 'homeCtrl'
	// route for the calendar
	});
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
	
}]);