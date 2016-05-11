'use strict';

angular.module('angularWalle')
.factory('treeData', function() {
	return {
		get : function(data, keyField, parentField) {
			var nodes = [];
			var nodeMap = {};
			angular.forEach(data, function(item) {
				if (! nodeMap[item[keyField]]) {
					var node = angular.copy(item);
					node.data = item;
					node.children = [];
					nodeMap[item[keyField]] = node;
				};
			});
			angular.forEach(nodeMap, function(node) {
				if (nodeMap[node.data[parentField]]) {
					nodeMap[node.data[parentField]].children.push(node);
				} else {
					nodes.push(node);
				}
			});
			return nodes;
		}
	};
});
