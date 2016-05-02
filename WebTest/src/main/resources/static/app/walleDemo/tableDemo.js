'use strict';

angular.module('ngApp')
.config(function($stateProvider) {
	$stateProvider
	.state('app.tableDemo', {
		url : 'walleDemo/tableDemo',
		views : {
			'content@' : {
				templateUrl : 'app/walleDemo/tableDemo.html',
				controller : 'tableDemoCtrl'
			}
		}
	});
})

.controller('tableDemoCtrl', function($scope, $http) {
	
});
