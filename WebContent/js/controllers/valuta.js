'use strict';

angular.module('valuta',['resource.valuta'])

.controller('valutaCtrl', function(Valuta,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.valutaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var valutaId = $routeParams.valutaId;

		var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'valuta'){

			$scope.valuta = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{

			Valuta.get({'valutaId':valutaId}).$promise.then(function (data) {
				$scope.valuta = data;
			});
		}
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

			var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'valuta'){

			$scope.valuta = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{
			$scope.valuta = new Valuta();
		}


	}


	$scope.save = function () {
		if($scope.valuta.valutaId){
			//zbog cega redirekcija ide na callback?
			$scope.valuta.$update({valutaId:$scope.valuta.valutaId},function () {
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



	console.log($scope.valuta);
//	$scope.drzavaZoom = function(){
//		$rootScope.zoom = true;
//		$rootScope.valutaSaved = $scope.valuta;
//		$location.path('/drzava-list');
//
//	}


});