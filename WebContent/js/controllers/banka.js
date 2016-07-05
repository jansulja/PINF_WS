'use strict';

angular.module('banka',['resource.banka'])

.controller('bankaCtrl', function(Banka,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.bankaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var bankaId = $routeParams.bankaId;

		if($rootScope.savedObject){

			$scope.banka = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{

			Banka.get({'bankaId':bankaId}).$promise.then(function (data) {
				$scope.banka = data;
			});
		}
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.banka = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.banka = new Banka();
		}


	}


	$scope.save = function () {
		if($scope.banka.bankaId){
			//zbog cega redirekcija ide na callback?
			$scope.banka.$update({bankaId:$scope.banka.bankaId},function () {
				$location.path('/banka-list');
			});
		}
		else{
			$scope.banka.$save(function () {

				$location.path('/banka-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}



	console.log($scope.banka);
//	$scope.drzavaZoom = function(){
//		$rootScope.zoom = true;
//		$rootScope.bankaSaved = $scope.banka;
//		$location.path('/drzava-list');
//
//	}


});