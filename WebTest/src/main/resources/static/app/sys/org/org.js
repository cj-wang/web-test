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
		params : {
			org : undefined
		},
		views : {
			'detail@app.org' : {
				templateUrl : 'app/sys/org/orgDetail.html',
				controller : 'orgDetailCtrl'
			}
		}
	});
})

.controller('orgCtrl', function($scope, $state, WlOrganize) {
	$scope.orgs = WlOrganize.query({
		orderBy : 'orgCode'
	});
	
	$scope.orgTreeSelect = function(branch) {
		$state.go('app.org.detail', {
			organizeId : branch.data.organizeId,
			org : branch.data
		});
	};
	
	$scope.add = function() {
		$state.go('app.org.detail', {
			organizeId : 'new',
			org : {
				parentOrganizeId : $scope.orgTreeControl.get_selected_id()
			}
		});
	};
})

.controller('orgDetailCtrl', function($scope, $stateParams, WlOrganize) {
	$scope.org = angular.copy($stateParams.org);
	$scope.orgTreeControl.select($stateParams.organizeId);

	$scope.save = function() {
		WlOrganize.save($scope.org, function(org) {
			if ($stateParams.organizeId == 'new') {
				$scope.orgs.push(org);
				$scope.orgTreeControl.select(org.organizeId);
			} else {
				angular.copy(org, $stateParams.org);
			}
			alert('保存成功');
		});
	};
	
	$scope.cancel = function() {
		$scope.org = angular.copy($stateParams.org);
	};
});
