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
	//current org
	var org;
	
	//on selection
	$scope.orgSelection = function(node) {
		//keep current org
		org = node.data
		//clone to $scope.org for editing
		$scope.org = angular.copy(node.data);
	};
	
	$scope.add = function() {
		//new $scope.org for adding
		$scope.org = new WlOrganize();
		$scope.org.parentOrganizeId = org ? org.organizeId : undefined;
	};
	
	$scope.remove = function() {
		//remove org via REST
		org.$remove(function() {
			//remove org from orgs, tree gets updated automatically
			$scope.orgs.splice($scope.orgs.indexOf(org), 1);
			alert('Deleted!')
		}, function(error) {
			alert(error.data.message);
		});
	};
	
	$scope.save = function() {
		//save org via REST
		$scope.org.$save(function(orgSaved) {
			if (org && (org.organizeId == orgSaved.organizeId)) {
				//copy returned org into current org, tree gets updated automatically
				angular.copy(orgSaved, org);
			} else {
				org = angular.copy(orgSaved);
				//add returned org into orgs, tree gets updated automatically
				$scope.orgs.push(org);
				//expand current node and select the new one
				$scope.orgsTree.expandedNodes.push($scope.orgsTree.selectedNode);
				$scope.orgsTree.selectedData = org;
			}
			alert('Saved!')
		}, function(error) {
			alert(error.data.message);
		});
	};
	
	$scope.cancel = function() {
		angular.copy(org, $scope.org);
	};
	
});
