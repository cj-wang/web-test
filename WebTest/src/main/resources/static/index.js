'use strict';

angular.module('ngApp', ['ngRoute', 'ui.walle'])
.controller('indexCtrl', function($scope, $location) {
	$scope.params = $location.search();
});
