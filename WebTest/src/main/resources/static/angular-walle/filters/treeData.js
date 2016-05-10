'use strict';

angular.module('angularWalle')
.filter('treeData', function() {
	return function(data, keyField, parentField) {
		var nodes = [];
		var nodeMap = {};
		angular.forEach(data, function(item) {
			if (! nodeMap[item[keyField]]) {
				nodeMap[item[keyField]] = {
						data : item,
						children : []
				}
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
	};
});
