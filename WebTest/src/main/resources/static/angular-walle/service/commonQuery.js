'use strict';

angular.module('angularWalle')
.factory('walleCommonQuery', function($http) {
	return {
		query : function(queryInfo) {
			if (queryInfo.queryFields && ! angular.isArray(queryInfo.queryFields)) {
				queryInfo = angular.copy(queryInfo);
				var queryFields = [];
				angular.forEach(queryInfo.queryFields, function(value, field) {
					if (typeof value == 'string' || typeof value == 'number' || value.getMonth) {
						queryFields.push({
							fieldName : field,
							fieldStringValue : value
						});
					} else {
						angular.forEach(value, function(subvalue, operator) {
							queryFields.push({
								fieldName : field,
								fieldStringValue : subvalue,
								operator : operator
							});
						});
					}
				});
				queryInfo.queryFields = queryFields;
			}
			return $http.post('/api/walle/commonQuery', queryInfo);
		}
	};
});
