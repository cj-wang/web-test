'use strict';

angular.module('ngApp')
.config(function($routeProvider) {
	$routeProvider.when('/tabframe', {
		templateUrl: 'views/tabframe/tabframe.html',
		controller: 'tabframeCtrl'
	});
})

.directive('ngDynamicController', function($compile, $parse) {
	return {
		restrict: 'A',
		terminal: true,
		priority: 100000,
		link: function(scope, element, attrs) {
			element.attr('ng-controller', $parse(attrs.ngDynamicController)(scope));
			element.removeAttr('ng-dynamic-controller');
			$compile(element)(scope);
		}
	};
})

.controller('tabframeCtrl', function($scope, $timeout) {
	
	var seq = 0;
	
	$scope.tabs = {};
	
	$scope.addTab = function(heading, url, controller) {
		seq++;
		$scope.tabs['_' + seq] = {
			index: seq,
			heading: heading,
			url: url,
			controller: controller
		};
		$timeout(function() {
			$scope.activeSeq = seq;
		});
	};
	
	$scope.closeTab = function(index) {
		delete $scope.tabs['_' + index];
	}
	
});
