'use strict';

angular.module('racuni',['resource.racuni'])

.controller('racuniCtrl', function(Racuni,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.racuniId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var racuniId = $routeParams.racuniId;

		var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'racuni'){

			$scope.racuni = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{

			Racuni.get({'racuniId':racuniId}).$promise.then(function (data) {
				$scope.racuni = data;
			});
		}
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

			var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'racuni'){

			$scope.racuni = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{
			$scope.racuni = new Racuni();
		}


	}


	$scope.save = function () {
		if($scope.racuni.racuniId){
			//zbog cega redirekcija ide na callback?
			$scope.racuni.$update({racuniId:$scope.racuni.racuniId},function () {
				$location.path('/racuni-list');
			});
		}
		else{
			$scope.racuni.$save(function () {

				$location.path('/racuni-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}



	console.log($scope.racuni);
//	$scope.drzavaZoom = function(){
//		$rootScope.zoom = true;
//		$rootScope.racuniSaved = $scope.racuni;
//		$location.path('/drzava-list');
//
//	}


});