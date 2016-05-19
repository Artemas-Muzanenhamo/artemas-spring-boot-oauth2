/**
 * **Modules are used to associate an angularJS app with the part of an HTML
 * document. Also they provide multiple to numerous AngularJS features and also
 * help with organisation.
 */

/**
 * angular.module('app1',[]);
 * The 'angular.module' here is going to accept a module name 'app1' as well as a list of modules inside '[]'.
 * Also it is going to accept some optional configuration for our modules which would come as angular.module('app1',[],*opt_module_config_here*);
 * 
 */
var app1 = angular.module('app1',[]);

app1.controller('ctrl1', function($scope){
	/**
	 * The Scope is going to link our HTML elements to variables in our scope 
	 * and the controller function in this situation is going to recieve the 
	 * controller name as well as the factory function (which is 'function($scope)').
	 * 
	 * The factory function is going to get the Controller ready to use. And we are saying 
	 * scope is a dependency by putting it in the attributes section of the Factory Function.
	 * And that is telling Angular to automatically pass in the Scope Object whenever the 
	 * function is called. AngularJS is smart enough to know what we want and it's going to 
	 * throw it all automatically for us.
	 * 
	 * THIS IS AN EXAMPLE OF WHAT WE CALL DI (Dependency Injection).
	 * AngularJS sees that my Factory Function contains a Scope component and it goes and gets it.
	 * And throws it into the function to be able to use for whatever we need automatically.
	 */
	
	$scope.first = 1;
	$scope.second = 1;
	
	$scope.updateValue = function(){
		$scope.calculation = $scope.first + ' + ' + $scope.second + ' = ' + (+$scope.first + $scope.second);
	}
})