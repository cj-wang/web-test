'use strict';

angular.module('ngApp')
.config(function($stateProvider) {
	$stateProvider
	.state('app.view1', {
		url : 'view1',
		views : {
			'content@' : {
				templateUrl : 'views/view1/view1.html',
				controller : 'view1Ctrl'
			}
		}
	});
})

.controller('view1Ctrl', function() {

});