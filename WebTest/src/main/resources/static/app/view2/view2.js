'use strict';

angular.module('ngApp')
.config(function($stateProvider) {
	$stateProvider
	.state('app.view2', {
		url : 'view2',
		views : {
			'content@' : {
				templateUrl : 'app/view2/view2.html',
				controller : 'view2Ctrl'
			}
		}
	});
})

.controller('view2Ctrl', function($scope, Flash, WlOrganize) {
	//query orgs via REST
	$scope.orgs = WlOrganize.query();
	//current org, different than $scope.org, which is bound to the form
	var org;
	
	//on selection change
	$scope.$watch('orgsTree.selectedData', function(selectedOrg) {
		//keep current org
		org = selectedOrg
		//clone to $scope.org for editing
		$scope.org = angular.copy(selectedOrg);
		$scope.state = 'view';
	});
	
	$scope.add = function() {
		//new $scope.org for adding
		$scope.org = new WlOrganize();
		$scope.org.parentOrganizeId = org ? org.organizeId : undefined;
		$scope.state = 'new';
	};
	
	$scope.edit = function() {
		$scope.state = 'edit';
	};
	
	$scope.remove = function() {
		//remove org via REST
		org.$remove(function() {
			//remove org from orgs, tree gets updated automatically
			$scope.orgs.splice($scope.orgs.indexOf(org), 1);
			Flash.create('success', '删除成功！');
		});
	};
	
	$scope.save = function() {
		//save org via REST
		$scope.org.$save(function(savedOrg) {
			if ($scope.state == 'new') {
				//add returned org into orgs, tree gets updated automatically
				$scope.orgs.push(savedOrg);
				//select the new org
				$scope.orgsTree.selectedData = savedOrg;
			} else {
				//edit
				//copy returned org into current org, tree gets updated automatically
				angular.copy(savedOrg, org);
			}
			Flash.create('success', '保存成功！');
			$scope.state = 'view';
		});
	};
	
	$scope.cancel = function() {
		$scope.org = angular.copy(org);
		$scope.state = 'view';
	};
	
});