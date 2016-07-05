'use strict';

angular.module('vrste-placanja-list',['resource.vrstePlacanja'])

.controller('vrste-placanja-listCtrl', function ($scope,$location, VrstePlacanja){

	$scope.vrstePlacanjaa = VrstePlacanja.query();



	$scope.new = function(){

		$location.path('vrstePlacanja/new');

	}

	$scope.edit = function(vrstePlacanja){

		$location.path('vrstePlacanja/' + vrstePlacanja.vrstaPlacanjaId);

	}


	$scope.remove = function(vrstePlacanja){

		vrstePlacanja.$remove({vrstaPlacanjaId:vrstePlacanja.vrstaPlacanjaId}, function(){

			var idx;
			var vrstePlacanjaa = $scope.vrstePlacanjaa;
			// Update scope
			for(var i = 0; i< vrstePlacanjaa.length;i++){

				if(vrstePlacanjaa[i].vrstaPlacanjaId == vrstePlacanja.vrstaPlacanjaId){
					idx = i;
				}

			}
			$scope.vrstePlacanjaa.splice(idx, 1);

		});


	}



	console.log($scope.vrstePlacanjaa);

});