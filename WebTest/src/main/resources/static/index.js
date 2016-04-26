'use strict';

angular.module('ngApp', ['ngRoute', 'ngAnimate', 'ui.walle', 'angularBootstrapNavTree'])
.controller('indexCtrl', function($scope, $location) {
	$scope.params = $location.search();
});
