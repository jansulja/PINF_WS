'use strict';

angular.module('drzava-new',['resource.drzava'])

.controller('drzava-newCtrl', function(Drzava,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.sifraDrzave!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var sifraDrzave = $routeParams.sifraDrzave;

		Drzava.get({'drzavaId':sifraDrzave}).$promise.then(function (data) {
			$scope.drzava = data;
		});
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"
		$scope.drzava = new Drzava();

	}


	$scope.save = function () {
		if($scope.drzava.sifraDrzave){
			//zbog cega redirekcija ide na callback?
			$scope.drzava.$update({drzavaId:$scope.drzava.sifraDrzave},function () {
				$location.path('/drzava-list');
			});
		}
		else{
			console.log($scope.drzava.toJSON());

			$scope.drzava.$save(function () {
				$location.path('/drzava-list');
			});
		}

	}
});