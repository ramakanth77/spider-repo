var app = angular.module('app', []);

app.controller('SubController', function($scope,$http) {
	$scope.GetValue = function(stockInfo){
		stockId = $scope.selectedStockInfo;
		companyName =  $.grep($scope.stockInfo, function (stock) {
	        return stock.stockId == stockId;
	    })[0].companyName;
	};
	
    $http.get("/stocks/top10")
    .then(function(response) {
        $scope.stockInfo = response.data.content;
        
    });
});


var stockId='';
var companyName='';

app.controller('MainController',function($scope,$http){
	
	$scope.saveStockData = function(){
		
		
		var stocks = ({ stockId:stockId,
						date:$scope.stockDate, 
						previousClose:$scope.previousClose, 
						open:$scope.open, 
						high:$scope.high,
						low:$scope.low 
						});
	$http({
		method : 'POST',
		url:'/stocks/newdata',
		data:stocks
	})
	.then(function(response){
		$scope.stockData = response.data.content;
	});
	};
});

