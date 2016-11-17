'use strict';

pictopage.config(["$routeProvider", "$stateProvider", "$urlRouterProvider", "$httpProvider",
                  
  function($routeProvider, $stateProvider, $urlRouterProvider, $httpProvider){
	
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
	// route for the homepage
	.state('/', {
		url: '/',
		templateUrl : '../app/home/home.html',
		controller : 'navigation'
	}).state('/home', {
		url: '/home',
		templateUrl : '../app/home/home.html',
		controller : 'home',
		controllerAs: 'homeCtrl'
	// route for the calendar
	}).state('/about', {
		url: '/about',
		templateUrl: '../app/about/about.html',
		controller: 'aboutCtrl',
		controllerAs: 'aboutCtrl'
	}).state('/contact', {
		url: '/contact',
		templateUrl: '../app/contact/contact.html',
		controller: 'ContactController',
		controllerAs: 'ContactController'
	});
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
	
}]);