'use strict';

angular.module('ukidanje',['resource.ukidanje'])

.controller('ukidanjeCtrl', function(Ukidanje,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.ukidanjeId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var ukidanjeId = $routeParams.ukidanjeId;

		var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'ukidanje'){

			$scope.ukidanje = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{

			Ukidanje.get({'ukidanjeId':ukidanjeId}).$promise.then(function (data) {
				$scope.ukidanje = data;
			});
		}
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

			var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'ukidanje'){

			$scope.ukidanje = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{
			$scope.ukidanje = new Ukidanje();
		}


	}


	$scope.save = function () {
		if($scope.ukidanje.ukidanjeId){
			//zbog cega redirekcija ide na callback?
			$scope.ukidanje.$update({ukidanjeId:$scope.ukidanje.ukidanjeId},function () {
				$location.path('/ukidanje-list');
			});
		}
		else{
			$scope.ukidanje.$save(function () {

				$location.path('/ukidanje-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}



	console.log($scope.ukidanje);
//	$scope.drzavaZoom = function(){
//		$rootScope.zoom = true;
//		$rootScope.ukidanjeSaved = $scope.ukidanje;
//		$location.path('/drzava-list');
//
//	}


});