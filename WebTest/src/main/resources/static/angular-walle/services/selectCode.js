'use strict';

angular.module('angularWalle')
.factory('walleSelectCode', function($http) {
	return {
		getAll : function(codeType) {
			return $http.get('/api/walle/selectCode/' + codeType);
		},
		
		get : function(codeType, key) {
			return $http.get('/api/walle/selectCode/' + codeType + '/' + key);
		},
		
		query : function(codeType, q, limit) {
			return $http.get('/api/walle/selectCode/' + codeType + '?q=' + q + '&limit=' + (limit || 100));
		}
	};
});
