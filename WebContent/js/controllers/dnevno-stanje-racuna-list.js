'use strict';

angular.module('dnevno-stanje-racuna-list',['resource.dnevnoStanjeRacuna'])

.controller('dnevno-stanje-racuna-listCtrl', function ($scope,$location, DnevnoStanjeRacuna){

	$scope.dnevnaStanjaRacuna = DnevnoStanjeRacuna.query();



	$scope.new = function(){

		$location.path('dnevnoStanjeRacuna/new');

	}

	$scope.edit = function(dnevnoStanjeRacuna){

		$location.path('dnevnoStanjeRacuna/' + dnevnoStanjeRacuna.dnevnoStanjeRacunaId);

	}


	$scope.remove = function(dnevnoStanjeRacuna){

		dnevnoStanjeRacuna.$remove({dnevnoStanjeRacunaId:dnevnoStanjeRacuna.dnevnoStanjeRacunaId}, function(){

			var idx;
			var dnevnaStanjaRacuna = $scope.dnevnaStanjaRacuna;
			// Update scope
			for(var i = 0; i< dnevnaStanjaRacuna.length;i++){

				if(dnevnaStanjaRacuna[i].dnevnoStanjeRacunaId == dnevnoStanjeRacuna.dnevnoStanjeRacunaId){
					idx = i;
				}

			}
			$scope.dnevnaStanjaRacuna.splice(idx, 1);

		});


	}

	

	console.log($scope.dnevnaStanjaRacuna);

});