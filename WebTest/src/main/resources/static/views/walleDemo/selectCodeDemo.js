'use strict';

angular.module('selectCodeDemoApp', ['walleApp'])
.controller('selectCodeDemoCtrl', function($scope, $http) {

	//set default value for walle-select-code in controller
	$scope.yesno1 = {
			key : 0
	};
	
	//set default value for walle-typeahead-code in controller
	$scope.user1 = {
			key : 'Admin'
	};
	
});
