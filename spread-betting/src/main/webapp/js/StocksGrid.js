var app = angular.module('app', ['ui.grid','ui.grid.pagination']);
app.controller('StocksCtrl', ['$scope','StocksService', 
    function ($scope, StocksService) {
        var paginationOptions = {
            pageNumber: 1,
            pageSize: 5,
        sort: null
        };
 
    StocksService.getStocks(
      paginationOptions.pageNumber,
      paginationOptions.pageSize).success(function(data){
        $scope.gridOptions.data = data.content;
        $scope.gridOptions.totalItems = data.totalElements;
      });
    $scope.gridOptions = {
        paginationPageSizes: [5, 10, 20],
        paginationPageSize: paginationOptions.pageSize,
        enableColumnMenus:false,
    useExternalPagination: true,
        columnDefs: [
           { name: 'stockId' },
           { name: 'companyName' }
        ],
        onRegisterApi: function(gridApi) {
           $scope.gridApi = gridApi;
           gridApi.pagination.on.paginationChanged(
             $scope, 
             function (newPage, pageSize) {
               paginationOptions.pageNumber = newPage;
               paginationOptions.pageSize = pageSize;
               StocksService.getStocks(newPage,pageSize)
                 .success(function(data){
                   $scope.gridOptions.data = data.content;
                   $scope.gridOptions.totalItems = data.totalElements;
                 });
            });
        }
    };
}]);
app.service('StocksService',['$http', function ($http) {
	 
    function getStocks(pageNumber,size) {
        pageNumber = pageNumber > 0?pageNumber - 1:0;
        return $http({
          method: 'GET',
            url: 'stocks/get?page='+pageNumber+'&size='+size
        });
    }
    return {
        getStocks: getStocks
    };
}]);
