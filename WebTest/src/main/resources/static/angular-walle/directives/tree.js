'use strict';

//walle-tree
angular.module('angularWalle')
.directive('walleTree', function($compile, $parse) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : function($scope, $element, $attrs) {
			var options = {
					allowDeselect : false,
					multiSelection : angular.isDefined($attrs.multiSelection)
			};
			$parse($attrs.ngModel + '$treeOptions').assign($scope, options);
			var nodesMap = {};
			var nodes = [];
			var expandedNodes = [];
			$parse($attrs.ngModel + '$treeNodesMap').assign($scope, nodesMap);
			$parse($attrs.ngModel + '$treeNodes').assign($scope, nodes);
			$parse($attrs.ngModel + '$treeExpandedNodes').assign($scope, expandedNodes);
			$scope.$watch($attrs.ngModel, function(data) {
				angular.forEach(data, function(item) {
					if (! nodesMap[item[$attrs.keyField]]) {
						var node = angular.copy(item);
						node.data = item;
						node.children = [];
						nodesMap[item[$attrs.keyField]] = node;
					};
				});
				angular.forEach(nodesMap, function(node) {
					if (nodesMap[node.data[$attrs.parentField]]) {
						nodesMap[node.data[$attrs.parentField]].children.push(node);
					} else {
						nodes.push(node);
					}
				});
				//expand the 1st node
				if (expandedNodes.length == 0 && nodes.length > 0) {
					expandedNodes.push(nodes[0]);
				}
			}, true);
		},
		link : function(scope, element, attrs) {
			element.removeAttr('walle-tree');
			element.attr('treecontrol', '');
			element.attr('class', attrs.class || 'tree-classic');

			element.attr('options', attrs.treeModel || attrs.ngModel + '$treeOptions');
			element.attr('tree-model', attrs.treeModel || attrs.ngModel + '$treeNodes');
			element.attr('selected-node', attrs.selectedNode || attrs.ngModel + '$treeSelectedNode');
			element.attr('selected-nodes', attrs.selectedNodes || attrs.ngModel + '$treeSelectedNodes');
			element.attr('expanded-nodes', attrs.expandedNodes || attrs.ngModel + '$treeExpandedNodes');

			$parse(attrs.ngModel + '$treeOrderBy').assign(scope, attrs.orderBy);
			element.attr('order-by', attrs.ngModel + '$treeOrderBy');
			element.attr('reverse-order', attrs.reverseOrder || 'false');
			
			//compile
			$compile(element)(scope);
		}
	};
});
