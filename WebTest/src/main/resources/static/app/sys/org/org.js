'use strict';

angular.module('ngApp')
.config(function($stateProvider) {
	$stateProvider
	.state('app.org', {
		url : 'org',
		views : {
			'content@' : {
				templateUrl : 'app/sys/org/org.html',
				controller : 'orgCtrl'
			}
		}
	});
})

.controller('orgCtrl', function($scope, WlOrganize) {
	//query orgs via REST
	$scope.orgs = WlOrganize.query();
	$scope.nodes = [];
	$scope.nodeMap = {};
	
	//TODO put this watcher into directive
	var keyField = 'organizeId';
	var parentField = 'parentOrganizeId';
	$scope.$watchCollection('orgs', function(data) {
		angular.forEach(data, function(item) {
			if (! $scope.nodeMap[item[keyField]]) {
				var node = angular.copy(item);
				node.data = item;
				node.children = [];
				$scope.nodeMap[item[keyField]] = node;
			};
		});
		angular.forEach($scope.nodeMap, function(node) {
			if ($scope.nodeMap[node.data[parentField]]) {
				$scope.nodeMap[node.data[parentField]].children.push(node);
			} else {
				$scope.nodes.push(node);
			}
		});
	});
	
	//on selection
	$scope.orgSelection = function(node) {
		//clone an org from node.data
		$scope.org = angular.copy(node.data);
		$scope.clone = angular.copy($scope.org);
	};
	
	$scope.add = function() {
		//new org
		$scope.org = {
				organizeId : 'new',
				parentOrganizedId : $scope.org ? $scope.org.organizeId : undefined
		};
	};
	
	$scope.remove = function() {
		alert('remove');
		return;
		//remove org via REST
		$scope.org.$remove(function() {
			//remove org from orgs, tree gets updated automatically
			$scope.orgs.splice($scope.orgs.indexOf($scope.org), 1);
		}, function(error) {
			alert(error.data.message);
		});
	};
	
	$scope.save = function() {
		alert('save');
		return;
		//save org via REST
		$scope.org.$save(function(org) {
			//do nothing here, as org gets updated by itself and tree gets updated automatically
		}, function(error) {
			alert(error.data.message);
		});
	};
	
	$scope.cancel = function() {
		angular.copy($scope.clone, $scope.org);
	};
});
