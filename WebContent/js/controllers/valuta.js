'use strict';

angular.module('valuta',['resource.valuta'])

.controller('valutaCtrl', function(Valuta,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.idValute!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var idValute = $routeParams.idValute;

		Valuta.get({'valutaId':idValute}).$promise.then(function (data) {
			$scope.valuta = data;
		});
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.valutaSaved){

			$scope.valuta = $rootScope.valutaSaved
		}else{
			$scope.valuta = new Valuta();
		}


	}


	$scope.save = function () {
		if($scope.valuta.idValute){
			//zbog cega redirekcija ide na callback?
			$scope.valuta.$update({valutaId:$scope.valuta.idValute},function () {
				$location.path('/valuta-list');
			});
		}
		else{
			$scope.valuta.$save(function () {

				$location.path('/valuta-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}

	$scope.drzavaZoom = function(){
		$rootScope.zoom = true;
		$rootScope.valutaSaved = $scope.valuta;
		$location.path('/drzava-list');

	}


});