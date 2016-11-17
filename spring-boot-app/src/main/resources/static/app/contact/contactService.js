'use strict';

pictopage.service('ContactService', ['$http', '$q', '$location', function($http, $q, $location){
	
	var httpAsPromise = function(options) {
        var deferred = $q.defer();
        $http(options).
            success(function (response, status, headers, config) {
                deferred.resolve(response);
            })
            .error(function (response, status, headers, config) {
                deferred.reject(response);
            });
        return deferred.promise;
    };
	
    this.tabActive = function() {

        return httpAsPromise(
            {
                method: 'GET',
                url: 'resource'
            }
        );
    };
    
}]);