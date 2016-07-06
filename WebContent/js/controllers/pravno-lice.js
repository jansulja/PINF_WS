'use strict';

angular.module('pravno-lice',['resource.pravnoLice'])

.controller('pravno-liceCtrl', function(PravnoLice,$scope, $rootScope, $routeParams, $log, $location, $q, $http){



	if($routeParams.pravnoLiceId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var pravnoLiceId = $routeParams.pravnoLiceId;

		if($rootScope.savedObject){

			$scope.pravnoLice = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			PravnoLice.get({'pravnoLiceId':pravnoLiceId}).$promise.then(function (data) {
				$scope.pravnoLice = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.pravnoLice = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.pravnoLice = new PravnoLice();
		}


	}


	$scope.save = function () {
		if($scope.pravnoLice.klijentId){
			//zbog cega redirekcija ide na callback?
			$scope.pravnoLice.$update({pravnoLiceId:$scope.pravnoLice.klijentId},function () {
				$location.path('/pravnoLice-list');
			});
		}
		else{
			$scope.pravnoLice.$save(function () {

				$location.path('/pravnoLice-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}


	//funkcija koja otvara datepicker
	$scope.openDatepicker = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope[opened] = true;
	};

});