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
	//query orgs
	$scope.orgs = WlOrganize.query({
		orderBy : 'orgCode'
	});
	
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
	$scope.orgTreeControl.select($stateParams.organizeId);
	
	$scope.save = function() {
		$scope.org.$save(function() {
			alert('保存成功');
		});
	};
});
