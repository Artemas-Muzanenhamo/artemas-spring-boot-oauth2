pictopage.controller('ContactController', ['$scope', 'ContactService', function($scope, ContactService){
	
	
	$scope.isActive = function(route){
		return route === $location.$$path;
	};
	
	ContactService.tabActive().then(function(result){
		$scope.newValue = result;
	});
}]);