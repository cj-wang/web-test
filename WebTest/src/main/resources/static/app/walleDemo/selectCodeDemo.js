'use strict';

angular.module('ngApp')
.config(function($stateProvider) {
	$stateProvider
	.state('app.selectCodeDemo', {
		url : 'walleDemo/selectCodeDemo',
		views : {
			'content@' : {
				templateUrl : 'app/walleDemo/selectCodeDemo.html',
				controller : 'selectCodeDemoCtrl'
			}
		}
	});
})

.controller('selectCodeDemoCtrl', function($scope, $http) {
	
});
