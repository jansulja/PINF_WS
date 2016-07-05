'use strict';

angular.module('kursna-lista',['resource.kursnaLista'])

.controller('kursna-listaCtrl', function(KursnaLista,$scope, $rootScope, $routeParams, $log, $location, $q, $http){



	if($routeParams.kursnaListaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var kursnaListaId = $routeParams.kursnaListaId;

		if($rootScope.savedObject){

			$scope.kursnaLista = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			KursnaLista.get({'kursnaListaId':kursnaListaId}).$promise.then(function (data) {
				$scope.kursnaLista = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.kursnaLista = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.kursnaLista = new KursnaLista();
		}


	}


	$scope.save = function () {
		if($scope.kursnaLista.kursnaListaId){
			//zbog cega redirekcija ide na callback?
			$scope.kursnaLista.$update({kursnaListaId:$scope.kursnaLista.kursnaListaId},function () {
				$location.path('/kursnaLista-list');
			});
		}
		else{
			$scope.kursnaLista.$save(function () {

				$location.path('/kursnaLista-list');
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