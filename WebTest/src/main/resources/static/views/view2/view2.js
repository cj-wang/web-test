'use strict';

angular.module('ngApp')
.config(function($routeProvider) {
	$routeProvider.when('/view2', {
		templateUrl: 'views/view2/view2.html',
		controller: 'view2Ctrl'
	});
})

.controller('view2Ctrl', function() {

});