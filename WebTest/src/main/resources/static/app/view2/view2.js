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

.controller('view2Ctrl', function($scope, WlOrganize) {
	//query orgs via REST
	$scope.orgs = WlOrganize.query();
	
	//on selection
	$scope.orgSelection = function(node) {
		//clone an org from node.data
		$scope.org = angular.copy(node.data);
		$scope.clone = angular.copy($scope.org);
	};
		
});