'use strict';

angular.module('valuta-list',['resource.valuta'])

.controller('valuta-listCtrl', function ($scope,$location, Valuta){

	$scope.valute = Valuta.query();


	$scope.new = function(){

		$location.path('valuta/new');

	}

	$scope.edit = function(valuta){

		$location.path('valuta/' + valuta.valutaId);

	}


	$scope.remove = function(valuta){

		valuta.$remove({valutaId:valuta.valutaId}, function(){

			var idx;
			var valute = $scope.valute;
			//Update scope
			for(var i = 0; i< valute.length;i++){

				if(valute[i].valutaId == valuta.valutaId){
					idx = i;
				}

			}
			$scope.valute.splice(idx, 1);

		});


	}





});