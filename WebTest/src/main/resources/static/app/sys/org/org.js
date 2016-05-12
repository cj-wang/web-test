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
	
	//on selection change
	$scope.$watch('orgsTree.selectedData', function(selectedOrg) {
		//keep current org
		org = selectedOrg
		//clone to $scope.org for editing
		$scope.org = angular.copy(selectedOrg);
	});
	
	$scope.add = function() {
		//new $scope.org for adding
		$scope.org = new WlOrganize();
		$scope.org.parentOrganizeId = org ? org.organizeId : undefined;
	};
	
	$scope.remove = function() {
		if (confirm('Delete?')) {
			//remove org via REST
			org.$remove(function() {
				//remove org from orgs, tree gets updated automatically
				$scope.orgs.splice($scope.orgs.indexOf(org), 1);
				alert('Deleted!')
			}, function(error) {
				alert(error.data.message);
			});
		}
	};
	
	$scope.save = function() {
		//save org via REST
		$scope.org.$save(function(savedOrg) {
			if (org && (org.organizeId == savedOrg.organizeId)) {
				//update
				//copy returned org into current org, tree gets updated automatically
				angular.copy(savedOrg, org);
			} else {
				//new
				//add returned org into orgs, tree gets updated automatically
				$scope.orgs.push(savedOrg);
				//select the new org
				$scope.orgsTree.selectedData = savedOrg;
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
