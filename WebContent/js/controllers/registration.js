myApp.controller ('RegistrationController', ['$scope', function($scope, $rootScope, $routeParams, $log, $location, $q, $http){

	//Login funkcija
	$scope.login = function(){

		var deferred = $q.defer();
			
		$http({
			//Ovo mozda treba da se menja u zavisnosti od path-a
			url: "https://localhost:8443/xws/api/gradjanin/login",
			method: "POST",
			data: $scope.user
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.pogresan = true;
			}
			);

		var promise = deferred.promise;


		promise.then(function (data) {

			$rootScope.current.imeiPrezime = data.imeiPrezime;
			$rootScope.current.email = data.email;

		});
	}
	};




	$scope.register = function(){
		var deferred = $q.defer();
			
		$http({
			//Ovo mozda treba da se menja u zavisnosti od path-a
			url: "https://localhost:8443/xws/api/gradjanin/login",
			method: "POST",
			data: $scope.user
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.pogresan = true;
			}
			);

		var promise = deferred.promise;


		promise.then(function (data) {


		});
	};

	
	$scope.openDatepicker1 = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope[opened] = true;
	};

	$scope.registerpravno = function(){
				var deferred = $q.defer();
			
		$http({
			//Ovo mozda treba da se menja u zavisnosti od path-a
			url: "https://localhost:8443/xws/api/gradjanin/login",
			method: "POST",
			data: $scope.user
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.pogresan = true;
			}
			);

		var promise = deferred.promise;


		promise.then(function (data) {


		});
	};
}]);