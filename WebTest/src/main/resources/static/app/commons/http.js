'use strict';

angular.module('ngApp')
.config(function($httpProvider) {

	$httpProvider.interceptors.push(function($q, Flash) {
		return {
			'responseError': function(rejection) {
				Flash.create('danger', rejection.data.message, 5000);
				return $q.reject(rejection);
			}
		};
	});

});
