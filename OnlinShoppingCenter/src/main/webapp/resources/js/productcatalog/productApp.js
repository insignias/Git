var app = angular.module("productApp", []);

app.controller("PanelController", function($scope,$http,$filter){

	this.tab = 'home';
	var url = 'http://localhost:8080/css/product';
	this.selectTab = function(setTab){
		this.tab = setTab;
		if(setTab == 'home'){
			url = 'http://localhost:8080/css/product';
		}
		else {
			url = 'http://localhost:8080/css/product/type/' + setTab;
		}
		$http.get(url).success(function(data){
			$scope.products = data;
		});
	};
	
	$http.get(url).success(function(data){
		$scope.products = data;
	});
	
	this.isSelected = function(checkTab){
		return this.tab === checkTab;
	};
});

