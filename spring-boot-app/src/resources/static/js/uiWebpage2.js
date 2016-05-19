/**
 * This tutorial deals with working with multiple controllers. 
 */

var app2 = angular.module('app2',[]);

app2.controller('ctrl1', function($scope){
	
	/**
	 * Generate random number for (randomNum1 * 10) + 1
	 */
	$scope.randomNum1 = Math.floor((Math.random() * 10) + 1);
	
	/**
	 * Generate random number for randomNum2
	 */
	$scope.randomNum2 = Math.floor((Math.random() * 10) + 1);
	
	
});

/**
 * Bad feelings Controller
 */
app2.controller('badCtrl', function($scope){
	
	var badFeelings = ["Disregarded","Unimportant","Rejected","Powerless"];
	
	//generated bad feelings..
	$scope.bad = badFeelings[Math.floor((Math.random() * 4))];
});


/**
 * Good feelings Contoller
 */
app2.controller('goodCtrl', function($scope){
	
	var goodFeelings = ["Pleasure","Awesome","Loveable","Inner Peace"];
	
	//generated good feelings..
	$scope.good = goodFeelings[Math.floor((Math.random() * 4))];
});