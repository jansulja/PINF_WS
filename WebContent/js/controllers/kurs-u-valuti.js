'use strict';

angular.module('kurs-u-valuti',['resource.kursUValuti'])

.controller('kurs-u-valutiCtrl', function(KursUValuti,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.kursUValutiId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var kursUValutiId = $routeParams.kursUValutiId;

		var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'kursUValuti'){

			$scope.kursUValuti = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{
			KursUValuti.get({'kursUValutiId':kursUValutiId}).$promise.then(function (data) {
				$scope.kursUValuti = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

			var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];
		if(zoomInfo && zoomInfo.savedObjectName == 'kursUValuti'){

			$scope.kursUValuti = zoomInfo.savedObject;
			$rootScope.activeZoom.splice(-1,1);

		}else{
			$scope.kursUValuti = new KursUValuti();
		}


	}


	$scope.save = function () {
		if($scope.kursUValuti.kursUValutiId){
			//zbog cega redirekcija ide na callback?
			$scope.kursUValuti.$update({kursUValutiId:$scope.kursUValuti.kursUValutiId},function () {
				$location.path('/kursUValuti-list');
			});
		}
		else{
			$scope.kursUValuti.$save(function () {

				$location.path('/kursUValuti-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}

	console.log($scope.kursUValuti);


});