'use strict';

angular.module('kursna-lista-list',['resource.kursnaLista'])

.controller('kursna-lista-listCtrl', function ($scope,$location, KursnaLista){

	$scope.kursneListe = KursnaLista.query();



	$scope.new = function(){

		$location.path('kursnaLista/new');

	}

	$scope.edit = function(kursnaLista){

		$location.path('kursnaLista/' + kursnaLista.kursnaListaId);

	}


	$scope.remove = function(kursnaLista){

		kursnaLista.$remove({kursnaListaId:kursnaLista.kursnaListaId}, function(){

			var idx;
			var kursneListe = $scope.kursneListe;
			// Update scope
			for(var i = 0; i< kursneListe.length;i++){

				if(kursneListe[i].kursnaListaId == kursnaLista.kursnaListaId){
					idx = i;
				}

			}
			$scope.kursneListe.splice(idx, 1);

		});


	}

	

	console.log($scope.kursneListe);

});