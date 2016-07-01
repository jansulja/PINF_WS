'use strict';

angular.module('valuta-list',['resource.valuta'])

.controller('valuta-listCtrl', function ($scope,$location, Valuta){

	$scope.valute = Valuta.query();


	$scope.new = function(){

		$location.path('valuta/new');

	}

	$scope.edit = function(valuta){

		$location.path('valuta/' + valuta.idValute);

	}


	$scope.remove = function(valuta){

		valuta.$remove({valutaId:valuta.idValute}, function(){

			var idx;
			var valute = $scope.valute;
			//Update scope
			for(var i = 0; i< valute.length;i++){

				if(valute[i].idValute == valuta.idValute){
					idx = i;
				}

			}
			$scope.valute.splice(idx, 1);

		});


	}





});