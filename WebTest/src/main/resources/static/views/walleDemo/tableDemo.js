'use strict';

angular.module('ngApp')
.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/walleDemo/tableDemo', {
		templateUrl: 'views/walleDemo/tableDemo.html',
		controller: 'tableDemoCtrl'
	});
}])

.controller('tableDemoCtrl', function($scope, $http) {
	
});
