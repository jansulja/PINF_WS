'use strict';

angular.module('naseljeno-mesto',['resource.naseljenoMesto'])

.controller('naseljeno-mestoCtrl', function(NaseljenoMesto,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.naseljenoMestoId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var naseljenoMestoId = $routeParams.naseljenoMestoId;

		if($rootScope.savedObject){

			$scope.naseljenoMesto = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			NaseljenoMesto.get({'naseljenoMestoId':naseljenoMestoId}).$promise.then(function (data) {
				$scope.naseljenoMesto = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.naseljenoMesto = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.naseljenoMesto = new NaseljenoMesto();
		}


	}


	$scope.save = function () {
		if($scope.naseljenoMesto.naseljenoMestoId){
			//zbog cega redirekcija ide na callback?
			$scope.naseljenoMesto.$update({naseljenoMestoId:$scope.naseljenoMesto.naseljenoMestoId},function () {
				$location.path('/naseljenoMesto-list');
			});
		}
		else{
			$scope.naseljenoMesto.$save(function () {

				$location.path('/naseljenoMesto-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}

	$scope.doZoom = function(){

		var pathToReturn;

		if($routeParams.naseljenoMestoId!='new'){
			pathToReturn = '/naseljenoMesto/' + $routeParams.naseljenoMestoId;
		}else{
			pathToReturn ='/naseljenoMesto/new';
		}


		$rootScope.genericZoom($rootScope.savedObject,'/drzava-list',pathToReturn)

	}


});