'use strict';

var pictopage = angular.module("pictopage", ["ngRoute","ui.router"])

  .controller('home', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
      $scope.greeting = data;
    })
  })
  
  /*
   * All the code in the `navigation` controller will be executed when the page loads because of the `ng-controller="navigation"`
   * */
  .controller('navigation',

  function($rootScope, $scope, $http, $location) {

  var authenticate = function(credentials, callback) {

    var headers = credentials ? {
    	//
    	authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).success(function(data) {
      if (data.name) {
        $rootScope.authenticated = true;
      } else {
        $rootScope.authenticated = false;
      }
      callback && callback();
    }).error(function() {
      $rootScope.authenticated = false;
      callback && callback();
    });

  }

  /**
   * 
   * In addition to initializing the credentials object, 
   * it defines 2 functions, the login() that we need in the form, 
   * and a local helper function authenticate() which tries to load 
   * a “user” resource from the backend. 
   * 
   * The authenticate() function is called when the controller is loaded 
   * to see if the user is actually already authenticated 
   * (e.g. if he had refreshed the browser in the middle of a session). 
   * 
   * We need the authenticate() function to make a remote call because 
   * the actual authentication is done by the server, and we don’t 
   * want to trust the browser to keep track of it.
   * ==============================================================================
   * 
   * ==============================================================================
   * The authenticate() function sets an application-wide flag called authenticated 
   * which we have already used in our “home.html” to control 
   * which parts of the page are rendered. 
   * We do this using $rootScope because it’s convenient and easy to follow, 
   * and we need to share the authenticated flag between the “navigation” 
   * and the “home” controllers. 
   * 
   * Angular experts might prefer to share data through a shared user-defined service 
   * (but it ends up being the same mechanism).
   * ==============================================================================
   * 
   * ==============================================================================
   * 
   * The authenticate() makes a GET to a relative resource 
   * (relative to the deployment root of your application) “/user”. 
   * When called from the login() function it adds the Base64-encoded credentials 
   * in the headers so on the server it does an authentication and accepts a cookie 
   * in return. 
   * 
   * The login() function also sets a local $scope.error flag accordingly when we get 
   * the result of the authentication, which is used to control the display of the 
   * error message above the login form.
   * 
   */
  authenticate();
  $scope.credentials = {};
  $scope.login = function() {
      authenticate($scope.credentials, function() {
        if ($rootScope.authenticated) {
          $location.path("/");
          $scope.error = false;
        } else {
          $location.path("/login");
          $scope.error = true;
        }
      });
  };
  
  

  $scope.logout = function() {
	$http.post('logout', {}).success(function() {
		$rootScope.authenticated = false;
		$location.path("/");
	}).error(function(data) {
		$rootScope.authenticated = false;
	});
  }

});