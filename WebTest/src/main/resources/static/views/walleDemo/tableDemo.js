'use strict';

angular.module('ngApp')
.config(function($routeProvider) {
	$routeProvider.when('/walleDemo/tableDemo', {
		templateUrl: 'views/walleDemo/tableDemo.html',
		controller: 'tableDemoCtrl'
	});
})

.controller('tableDemoCtrl', function($scope, $http) {
	
});
