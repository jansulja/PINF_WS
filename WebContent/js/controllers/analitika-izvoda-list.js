'use strict';

angular.module('analitika-izvoda-list',['resource.analitikaIzvoda'])

.controller('analitika-izvoda-listCtrl', function ($scope,$location, AnalitikaIzvoda){

	$scope.analitikeIzvoda = AnalitikaIzvoda.query();



	$scope.new = function(){

		$location.path('analitikaIzvoda/new');

	}

	$scope.edit = function(analitikaIzvoda){

		$location.path('analitikaIzvoda/' + analitikaIzvoda.analitikaIzvodaId);

	}


	$scope.remove = function(analitikaIzvoda){

		analitikaIzvoda.$remove({analitikaIzvodaId:analitikaIzvoda.analitikaIzvodaId}, function(){

			var idx;
			var analitikeIzvoda = $scope.analitikeIzvoda;
			// Update scope
			for(var i = 0; i< analitikeIzvoda.length;i++){

				if(analitikeIzvoda[i].analitikaIzvodaId == analitikaIzvoda.analitikaIzvodaId){
					idx = i;
				}

			}
			$scope.analitikeIzvoda.splice(idx, 1);

		});


	}

	

	console.log($scope.analitikeIzvoda);

});