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
	WlOrganize.query({}, function(orgs) {
		$scope.orgs = orgs;
	});
	
	$scope.orgSelect = function(branch) {
		$state.go('app.org.detail', {
			organizeId : branch.data.organizeId,
			org : branch.data
		});
	};
	
	$scope.add = function() {
//		$state.go('app.org.detail', {
//			organizeId : 'new',
//			org : {
//				parentOrganizeId : $scope.orgTreeControl.get_selected_id()
//			}
//		});
	};
})

.controller('orgDetailCtrl', function($scope, $stateParams, WlOrganize) {
	$scope.org = angular.copy($stateParams.org);
	if ($stateParams.organizeId == 'new') {
		$scope.orgTreeControl.select(null);
	} else {
		$scope.orgTreeControl.select($stateParams.organizeId);
	}

	$scope.save = function() {
		alert('保存成功');
//		WlOrganize.save($scope.org, function(org) {
//			if ($stateParams.organizeId == 'new') {
//				$scope.orgs.push(org);
//				$scope.orgTreeControl.select(org.organizeId);
//			} else {
//				angular.copy(org, $stateParams.org);
//			}
//			alert('保存成功');
//		});
	};
	
	$scope.cancel = function() {
		if ($stateParams.organizeId == 'new') {
			$scope.orgTreeControl.select($stateParams.org.parentOrganizeId);
		} else {
			$scope.org = angular.copy($stateParams.org);
		}
	};
});
