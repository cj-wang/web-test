'use strict';

angular.module('ngApp')
.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/walleDemo/selectCodeDemo', {
		templateUrl: 'views/walleDemo/selectCodeDemo.html',
		controller: 'selectCodeDemoCtrl'
	});
}])

.controller('selectCodeDemoCtrl', function($scope, $http) {
	
});
