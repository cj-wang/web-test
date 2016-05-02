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
	})
	.state('app.org.detail', {
		url : '/:organizeId',
		views : {
			'detail@app.org' : {
				templateUrl : 'app/sys/org/orgDetail.html',
				controller : 'orgDetailCtrl'
			}
		}
	});
})

.controller('orgCtrl', function($scope, $state, WlOrganize) {

	$scope.orgTreeDataMap = {};
	$scope.orgTreeData = [];
	$scope.orgTreeControl = {};
	
	//query orgs
	WlOrganize.query({
		orderBy : 'orgCode'
	}, function(orgs) {
		//setup tree data
		angular.forEach(orgs, function(org) {
			$scope.orgTreeDataMap[org.organizeId] = {
					label : org.name,
					data : org,
					children : []
			};
		});
		angular.forEach($scope.orgTreeDataMap, function(org) {
			if ($scope.orgTreeDataMap[org.data.parentOrganizeId]) {
				$scope.orgTreeDataMap[org.data.parentOrganizeId].children.push(org);
			} else {
				$scope.orgTreeData.push(org);
			}
		});
		
		$scope.orgTreeControl.expand_all();
		$scope.select($state.params.organizeId);
	});
	
	//select org
	$scope.select = function(organizeId) {
		$scope.orgTreeControl.select_branch($scope.orgTreeDataMap[organizeId]);
	};
	
	//org selected
	$scope.orgTreeSelect = function(branch) {
		$state.go('app.org.detail', {
			organizeId : branch.data.organizeId
		});
	};
	
})

.controller('orgDetailCtrl', function($scope, $stateParams, WlOrganize) {
	//get org
	$scope.org = WlOrganize.get({organizeId: $stateParams.organizeId});
	//set tree selection
	$scope.$parent.select($stateParams.organizeId);
	
	$scope.save = function() {
		$scope.org.$save(function() {
			alert('保存成功');
		});
	};
	
});
