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
			org : null
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
	//query orgs
	$scope.orgs = WlOrganize.query({
		orderBy : 'orgCode'
	});
	
	//org selected
	$scope.orgTreeSelect = function(branch) {
		$state.go('app.org.detail', {
			organizeId : branch.data.organizeId,
			org : branch.data
		});
	};
})

.controller('orgDetailCtrl', function($scope, $stateParams, WlOrganize) {
	//get org
	$scope.org = $stateParams.org;
	//set tree selection when refresh
	$scope.orgTreeControl.select($stateParams.organizeId);

	$scope.save = function() {
		$scope.org.$save(function(org) {
			alert('保存成功');
		});
	};
	
	$scope.cancel = function() {
		//$scope.org = WlOrganize.get({organizeId: $stateParams.organizeId});
	};
});
