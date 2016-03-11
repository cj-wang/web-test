'use strict';

angular.module('ngApp', ['ui.walle'])
.controller('ngCtrl', function($scope, $http) {
	
	$scope.query = function() {
		$http.post('/commonQuery', {
			queryType : 'WlUserModel',
			pagingInfo : $scope.pagingInfo || {}
		}).then(function(response) {
			$scope.users = response.data.dataList;
			$scope.pagingInfo = response.data.pagingInfo;
		}, function(response) {
			alert('Error loading data');
		});
	}
	
	$scope.query();
	
});
