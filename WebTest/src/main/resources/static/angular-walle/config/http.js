'use strict';

angular.module('angularWalle')
.config(function($httpProvider) {

	$httpProvider.interceptors.push(function($q, Flash) {
		return {
			'responseError': function(rejection) {
				Flash.create('danger', rejection.data.message, 0);
				return $q.reject(rejection);
			}
		};
	});

});
