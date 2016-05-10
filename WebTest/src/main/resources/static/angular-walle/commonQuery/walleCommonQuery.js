'use strict';

angular.module('walle')
.factory('walleCommonQuery', function($http) {
	return {
		query : function(queryInfo) {
			return $http.post('/api/walle/commonQuery', queryInfo);
		}
	};
});
