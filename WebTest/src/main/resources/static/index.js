'use strict';

angular.module('ngApp', ['ngRoute', 'ui.walle', 'angularBootstrapNavTree'])
.controller('indexCtrl', function($scope, $location) {
	$scope.params = $location.search();
});
