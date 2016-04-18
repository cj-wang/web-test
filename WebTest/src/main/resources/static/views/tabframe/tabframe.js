'use strict';

angular.module('ngApp')
.controller('ngCtrl', function($scope, $http) {
	
	var seq = 0;
	
	$scope.tabs = {};
	
	$scope.addTab = function(heading, url) {
		seq++;
		$scope.tabs['_' + seq] = {
			index: seq,
			heading: heading,
			url: url,
			active: true
		};
	};
	
	$scope.closeTab = function(index) {
		delete $scope.tabs['_' + index];
	}
	
});
