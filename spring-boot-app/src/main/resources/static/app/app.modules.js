'use strict';

var pictopage = angular.module('pictopage', ['ui.bootstrap','ngRoute','ui.router'])

.controller('home', function($http) {
		var self = this;
		
		alert("WELCOME HOME !!");
		
//		$http.get('resource/').then(function(response) {
//			self.greeting = response.data;
//		});
	});