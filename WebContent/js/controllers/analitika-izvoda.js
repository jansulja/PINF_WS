'use strict';

angular.module('analitika-izvoda',['resource.analitikaIzvoda'])

.controller('analitika-izvodaCtrl', function(AnalitikaIzvoda,$scope, $rootScope, $routeParams, $log, $location, $q, $http){



	if($routeParams.analitikaIzvodaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var analitikaIzvodaId = $routeParams.analitikaIzvodaId;

		if($rootScope.savedObject){

			$scope.analitikaIzvoda = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			AnalitikaIzvoda.get({'analitikaIzvodaId':analitikaIzvodaId}).$promise.then(function (data) {
				$scope.analitikaIzvoda = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.analitikaIzvoda = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.analitikaIzvoda = new AnalitikaIzvoda();
		}


	}


	$scope.save = function () {
		if($scope.analitikaIzvoda.analitikaIzvodaId){
			//zbog cega redirekcija ide na callback?
			$scope.analitikaIzvoda.$update({analitikaIzvodaId:$scope.analitikaIzvoda.analitikaIzvodaId},function () {
				$location.path('/analitikaIzvoda-list');
			});
		}
		else{
			$scope.analitikaIzvoda.$save(function () {

				$location.path('/analitikaIzvoda-list');
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