var app = angular.module('app',[]);

app.controller("myctrl",['$scope','$filter','logger','dashboardservice','$rootScope',function($scope,$filter,logger,dashboardservice,$rootScope)
{
	$scope.idSelected=null;
$rootScope.mainurl="http://localhost:8080/Onlineshop";
localStorage.setItem("mainUrl", $rootScope.mainurl);
$scope.order={};
$scope.product={};
var array=[{y:'2001',a:2300,b:600},
{y:'2002',a:4000,b:3000},
{y:'2003',a:5000,b:4000},
{y:'2004',a:2500,b:6000},
{y:'2005',a:6700,b:2500},
{y:'2006',a:5500,b:3000},
{y:'2007',a:4900,b:1000},
{y:'2008',a:3800,b:900}];
var mor1 = Morris.Line({
  element: 'Sales',
  data: array,
  xkey: 'y',
  ykeys: ['a','b'],
  labels: ['Sales','Clients'],
  lineColors: ["Red","Blue"],
  parseTime: false
});


var original= angular.copy($scope.product); $scope.revert = function () {
      return $scope.clinic = angular.copy(original);
	  $scope.form_constraints.$setPristine()
    }; $scope.canRevert = function () {
      return !angular.equals($scope.clinic, original) || !$scope.form_constraints.$pristine
    }; $scope.canSubmitClinics = function () {
	////alert("in clinics table can submit");
     return $scope.form_constraints.$valid && !angular.equals($scope.form, original)
    };
	
$scope.getsales=function()
{
	if($scope.date==undefined)
		logger.logError("Date cannot be empty!! Enter a date.");
	else
	{
	dashboardservice.getsales($scope.date).success(function(response)
	{
	$scope.orders=response;
	})
	}
	
}
$scope.edit=function(productid)
{
	$scope.idSelected=productid;	
	for(var i=0;i<$scope.currentPageStores.length;i++)
	{
		if($scope.currentPageStores[i].id==productid)
		{
			$scope.product=JSON.parse(JSON.stringify($scope.currentPageStores[i]));
			
			
		}
	}
	
}

			$scope.createproduct = function() {
				if (angular.isUndefined($scope.product.id)) {
					dashboardservice.insertproduct($scope.product).success(
							function(response) {
								logger.logSuccess("Saved Successfully!!!");
							})
				} else {
					dashboardservice.updateproduct($scope.product,$scope.product.id).success(
							function(response) {
								logger.logSuccess("Updated Successfully!!!");
							})
				}
			};
    dashboardservice.getproducts().success(function(response)
	{
	$scope.filteredStores=response;
	$scope.stores=response;
	$scope.currentPageStores = $scope.filteredStores.slice(0, 10);
	});
$scope.deleteproduct=function(productid)
{

	dashboardservice.deleteproduct(productid).success(function(response)
	{
		
	 for(var i=0;i<$scope.filteredStores.length;i++)
	{
		if($scope.filteredStores[i].id==productid)
		{
			$scope.filteredStores.splice(i,1);
			$scope.currentPageStores=$scope.filteredStores.slice(0, 10);
			$scope.product=null;
			logger.logSuccess("Product Successfully Deleted!!!");
			
			
		}
	}	
	})
	
	
}

$scope.addNewButton=function()
{
	$scope.product=null;
	
}	
var init;
return $scope.stores = 	[]
,	   
  $scope.searchKeywords = "", $scope.filteredStores = [], $scope.row = "", $scope.select = function (page) {
      var end, start;
      return start = (page - 1) * $scope.numPerPage, end = start + $scope.numPerPage, $scope.currentPageStores = $scope.filteredStores.slice(start, end)
    }
	
	, $scope.onFilterChange = function () {
      return $scope.select(1), $scope.currentPage = 1, $scope.row = ""
    }
	
	, $scope.onNumPerPageChange = function () {
      return $scope.select(1), $scope.currentPage = 1
    }
	
	, $scope.onOrderChange = function () {
      return $scope.select(1), $scope.currentPage = 1
    }
	
	, $scope.search = function () {
      return $scope.filteredStores = $filter("filter")($scope.stores, $scope.searchKeywords), $scope.onFilterChange()
    }
	
	, $scope.order = function (rowName) {
      return $scope.row !== rowName ? ($scope.row = rowName, $scope.filteredStores = $filter("orderBy")($scope.stores, rowName), $scope.onOrderChange()) : void 0
    }
	, $scope.numPerPageOpt = [3, 5, 10, 20], $scope.numPerPage = $scope.numPerPageOpt[2], $scope.currentPage = 1, $scope.currentPageStores = [], 
	(init = function () {
      return $scope.search(), $scope.select($scope.currentPage)
    })()							
			


}])
app.factory("logger", [function () {
    var logIt;
    return toastr.options = {
      closeButton: !0,
      positionClass: "toast-bottom-right",
      timeOut: "3000"
    }, logIt = function (message, type) {
      return toastr[type](message)
    }, {
      log: function (message) {
        logIt(message, "info")
      },
      logWarning: function (message) {
        logIt(message, "warning")
      },
      logSuccess: function (message) {
        logIt(message, "success")
      },
      logError: function (message) {
        logIt(message, "error")
      }
    }
  }])
app.service("dashboardservice",['$http',function($http)
{	var mainurl=localStorage.getItem("mainUrl");
	this.getsales=function(date)
	{	//return $http.get(mainurl +'/combo2.json');
		return $http.get(mainurl +'/order?orderDate='+date);
	};
	this.getproducts=function()
	{	//return $http.get(mainurl +'/combo.json');
		return $http.get(mainurl +'/products');
	};
	this.deleteproduct=function(id)
	{	//return $http.get(mainurl +'/combo2.json');
		return $http.delete(mainurl +'/products?id='+id);
	};
	this.insertproduct=function(product)
	{	//return $http.post(mainurl +'/combo.json');
	alert(angular.toJson(product));
		return $http.post(mainurl +'/products',product);
	};
	this.updateproduct=function(product,productid)
	{	//return $http.put(mainurl +'/combo.json');
		return $http.put(mainurl +'/products?id='+productid,product);
	};
}]);

