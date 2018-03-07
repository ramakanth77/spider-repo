var app = angular.module('app', []);

app.controller('SubController', function($scope,$http) {
		
	    $http.get("/stocks/top10")
	    .then(function(response) {
	        $scope.stockInfo = response.data.content;
	        
	    });
});

app.controller('MainController',function($scope,$http){
	$scope.saveStockData = function(){
		alert($scope.selectedStockInfo);
		var stocks = ( {	
						'StockId':'33333',
						'StockData':
							{'stockDate':$scope.stockDate, 'previousClose': $scope.previousClose, 'open':$scope.open, 'high':$scope.high,'low':$scope.low }
				
						});
	$http({
		method : 'POST',
		url:'/stocks/newdata',
		data:stocks
	})
	.then(function(response){
		alert(response.data);
	});
	};
});

/*app.controller('MainController', function($scope,$resource) {
			alert("inside controller");
			
			//alert("StockData is "+$scope.stocks)
			$scope.saveStockData = function() {
				
			$http({
				method : 'POST',
				url	   : '/stocks/newdata',
				data   : stocks
			})
				.success(function(data){
				if (data.errors) {
	              $scope.errorName = data.errors.name;
	              $scope.errorUserName = data.errors.username;
	              $scope.errorEmail = data.errors.email;
	            } else {
	              $scope.message = data.message;
	            }
	            });
			};
	});
*/