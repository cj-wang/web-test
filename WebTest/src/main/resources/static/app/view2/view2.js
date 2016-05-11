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

.controller('view2Ctrl', function($scope, WlOrganize, treeData) {
	$scope.orgs = WlOrganize.query();
	
	$scope.$watchCollection('orgs', function(orgs) {
		$scope.orgNodes = treeData.get(orgs, 'organizeId', 'parentOrganizeId');
	});
	
	
	$scope.orgSelect = function(branch) {
	};
	
});