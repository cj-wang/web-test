'use strict';

angular.module('ngApp')
.config(function($routeProvider) {
	$routeProvider.when('/view1', {
		templateUrl: 'views/view1/view1.html',
		controller: 'view1Ctrl'
	});
})

.controller('view1Ctrl', function() {

});