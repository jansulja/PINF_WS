//var myApp = angular.module('myApp', ['ngRoute','drzava-list','resource.drzava']); //angular modul, referencira myApp iz index.html-a


angular
.module('myApp', [
'ngRoute',
'ngResource',
'ui.bootstrap',
'registration', 'jcs-autoValidate',
'success','drzava-list','resource.drzava','drzava-new','resource.valuta','valuta-list','valuta'
,'naseljeno-mesto-list','resource.naseljenoMesto','naseljeno-mesto'
,'analitika-izvoda-list','resource.analitikaIzvoda','analitika-izvoda'
,'kurs-u-valuti-list','resource.kursUValuti','kurs-u-valuti'
,'racuni-list','resource.racuni','racuni'
,'kursna-lista-list','resource.kursnaLista','kursna-lista'
,'resource.banka','banka-list','banka'
,'resource.vrstePlacanja','vrste-placanja-list','vrste-placanja'
,'resource.dnevnoStanjeRacuna','dnevno-stanje-racuna-list','dnevno-stanje-racuna'
,'resource.pravnoLice','pravno-lice-list','pravno-lice'
,'resource.fizickoLice','fizicko-lice-list','fizicko-lice'
,'resource.ukidanje','ukidanje-list','ukidanje'
,'resource.klijent','klijent-list'
,'nalog'
,'modal-klijent-izvestaj'])



.config(function($routeProvider){
	$routeProvider.
		when('/login', {
			templateUrl: 'views/login.html',
			controller: 'RegistrationController'
		}).
		when('/register', {
			templateUrl: 'views/register.html',
			controller: 'RegistrationController'
		}).
		when('/drzava-new/:drzavaId',{
			templateUrl: 'views/drzava-new.html',
			controller: 'drzava-newCtrl'
		}).
		when('/success', {
			templateUrl: 'views/success.html',
			controller: 'SuccessController'
		}).
		when('/analitikaizvoda-new', {
			templateUrl: 'views/analitikaizvoda-new.html',
			controller: 'analitikaizvoda-newCtrl'
		}).
		when('/registerpravno', {
			templateUrl: 'views/registerpravno.html',
			controller: 'RegistrationController'
		}).
		when('/drzava-list', {
			templateUrl: 'views/drzava-list.html',
			controller: 'drzava-listCtrl'
		}).
		when('/valuta-list', {
			templateUrl: 'views/valuta-list.html',
			controller: 'valuta-listCtrl'
		}).
		when('/valuta/:valutaId', {
			templateUrl: 'views/valuta.html',
			controller: 'valutaCtrl'
		}).
		when('/naseljenoMesto-list', {
			templateUrl: 'views/naseljeno-mesto-list.html',
			controller: 'naseljeno-mesto-listCtrl'
		}).
		when('/naseljenoMesto/:naseljenoMestoId', {
			templateUrl: 'views/naseljeno-mesto.html',
			controller: 'naseljeno-mestoCtrl'
		}).
		when('/analitikaIzvoda-list', {
			templateUrl: 'views/analitika-izvoda-list.html',
			controller: 'analitika-izvoda-listCtrl'
		}).
		when('/analitikaIzvoda/:analitikaIzvodaId', {
			templateUrl: 'views/analitika-izvoda.html',
			controller: 'analitika-izvodaCtrl'
		})
		.
		when('/kursUValuti-list', {
			templateUrl: 'views/kurs-u-valuti-list.html',
			controller: 'kurs-u-valuti-listCtrl'
		}).
		when('/kursUValuti/:kursUValutiId', {
			templateUrl: 'views/kurs-u-valuti.html',
			controller: 'kurs-u-valutiCtrl'
		}).
		when('/racuni-list', {
			templateUrl: 'views/racuni-list.html',
			controller: 'racuni-listCtrl'
		}).
		when('/racuni/:racuniId', {
			templateUrl: 'views/racuni.html',
			controller: 'racuniCtrl'
		}).
		when('/kursnaLista-list', {
			templateUrl: 'views/kursna-lista-list.html',
			controller: 'kursna-lista-listCtrl'
		}).
		when('/kursnaLista/:kursnaListaId', {
			templateUrl: 'views/kursna-lista.html',
			controller: 'kursna-listaCtrl'
		}).
		when('/banka-list', {
			templateUrl: 'views/banka-list.html',
			controller: 'banka-listCtrl'
		}).
		when('/banka/:bankaId', {
			templateUrl: 'views/banka.html',
			controller: 'bankaCtrl'
		}).
		when('/vrstePlacanja-list', {
			templateUrl: 'views/vrste-placanja-list.html',
			controller: 'vrste-placanja-listCtrl'
		}).
		when('/vrstePlacanja/:vrstaPlacanjaId', {
			templateUrl: 'views/vrste-placanja.html',
			controller: 'vrste-placanjaCtrl'
		}).
		when('/dnevnoStanjeRacuna-list', {
			templateUrl: 'views/dnevno-stanje-racuna-list.html',
			controller: 'dnevno-stanje-racuna-listCtrl'
		}).
		when('/dnevnoStanjeRacuna/:dnevnoStanjeRacunaId', {
			templateUrl: 'views/dnevno-stanje-racuna.html',
			controller: 'dnevno-stanje-racunaCtrl'
		}).
		when('/pravnoLice-list', {
			templateUrl: 'views/pravno-lice-list.html',
			controller: 'pravno-lice-listCtrl'
		}).
		when('/pravnoLice/:pravnoLiceId', {
			templateUrl: 'views/pravno-lice.html',
			controller: 'pravno-liceCtrl'
		}).
		when('/fizickoLice-list', {
			templateUrl: 'views/fizicko-lice-list.html',
			controller: 'fizicko-lice-listCtrl'
		}).
		when('/fizickoLice/:fizickoLiceId', {
			templateUrl: 'views/fizicko-lice.html',
			controller: 'fizicko-liceCtrl'
		}).
		when('/ukidanje-list', {
			templateUrl: 'views/ukidanje-list.html',
			controller: 'ukidanje-listCtrl'
		}).
		when('/ukidanje/:ukidanjeId', {
			templateUrl: 'views/ukidanje.html',
			controller: 'ukidanjeCtrl'
		}).
		when('/klijent-list', {
			templateUrl: 'views/klijent-list.html',
			controller: 'klijent-listCtrl'
		}).
		when('/nalog/:racuniId', {
			templateUrl: 'views/nalog.html',
			controller: 'nalogCtrl'
		}).
		otherwise({
			redirectTo: '/login'
		});
}).run(function($rootScope,$location,$routeParams) {

	$rootScope.activeZoom = [];

	$rootScope.isZoomActive = function(path){

		var zoom = false;
		var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];

		if(zoomInfo){
			if(zoomInfo.zoom = true && path == zoomInfo.pickUpPath){

				zoom = true;

			}
		}

		return zoom;



	}

	$rootScope.genericPickUp = function(pickUpObject,propertyName){


		var zoomInfo = $rootScope.activeZoom[$rootScope.activeZoom.length-1];

		if(zoomInfo.propertyName){
			propertyName = zoomInfo.propertyName;
		}

		$rootScope.assign($rootScope.activeZoom[$rootScope.activeZoom.length-1].savedObject,propertyName,pickUpObject)

//		$rootScope.savedObjectName.splice(-1,1);
//
//		console.log($routeParams);
//		//$rootScope.zoom[$rootScope.savedObjectName[$rootScope.savedObjectName.length-1]] = false;





		$location.path(zoomInfo.returnPath);
	}

	$rootScope.assign = function (obj, prop, value) {
	    if (typeof prop === "string")
	        prop = prop.split(".");

	    if (prop.length > 1) {
	        var e = prop.shift();
	        assign(obj[e] =
	                 Object.prototype.toString.call(obj[e]) === "[object Object]"
	                 ? obj[e]
	                 : {},
	               prop,
	               value);
	    } else
	        obj[prop[0]] = value;
	}
	//prop name optional
	$rootScope.genericZoom = function(savedObject,savedObjectName,pickUpPath,returnPath,id,propertyName){


			var zoomInfo = { 'propertyName':propertyName,'savedObject':savedObject,
					'savedObjectName':savedObjectName,'pickUpPath':pickUpPath,'returnPath':returnPath+$routeParams[id],
					'id':id,'zoom':true};



			$rootScope.activeZoom.push(zoomInfo);
//			$rootScope.propertyName = propertyName;
//			$rootScope.assign($rootScope.zoom,pickUpPath,true);
//			if($rootScope.savedObjectName == null){
//				$rootScope.savedObjectName = [];
//				$rootScope.savedObjectName.push(savedObjectName);
//			}else{
//				$rootScope.savedObjectName.push(savedObjectName);
//			}
//			//$rootScope.savedObjectName = savedObjectName;
//			$rootScope.assign($rootScope,savedObjectName,savedObject);
//
//			//$rootScope.savedObject = savedObject;
//			$rootScope.returnPath = returnPath + $routeParams[id];
			$location.path(pickUpPath);


	}


	$rootScope.openDatepicker = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$rootScope[opened] = true;
	};

}).controller('myAppCtrl', function ($scope,$location, Drzava, $rootScope,$q,$http){


	$scope.generateMT102 = function(){

		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
		$http({
			url: "http://localhost:8089/PINF_WSProjekat/api/mt102",
			method: "GET",
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {

		});

		var promise = deferred.promise;
		promise.then(function (data) {
			console.log('yeees');
		});


	}

	$scope.logData;
	$scope.first = true;
	$scope.isLog;

	$scope.loggedIn = function(){

		if($rootScope.current == undefined){

			var retVal =false;

			if($scope.first){
				if(!$scope.logData){

					var deferred = $q.defer();
					//user.password = md5.createHash(user.password);
					$http({
						url: "http://localhost:8089/PINF_WSProjekat/api/zaposleni/isLogged",
						method: "GET"
					}).then(function successCallback(data) {
						deferred.resolve(data.data);
					}, function errorCallback(response) {

					});

					var promise = deferred.promise;
					promise.then(function (data) {
						$scope.logData = data;


						if(data!=""){

							$rootScope.current = {};
							$rootScope.current.ime = data.ime;
							$rootScope.current.prezime = data.prezime;
							$rootScope.current.email = data.email;
							$rootScope.current.banka = data.banka.naziv;

							retVal=true;
							$scope.isLog = true;
						}
					});
					$scope.first = false;

				}


			}else{
				if($scope.isLog){
					retVal=true;
				}else{
					retVal=false;
				}
			}






			return retVal;
		}

		var logged;
		if($rootScope.current.ime == null){





			logged = false;
		}else{
			logged = true;
		}
		return logged;
	}

	$scope.logout =function(){

		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
		$http({
			url: "http://localhost:8089/PINF_WSProjekat/api/zaposleni/logout",
			method: "GET",
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {

		});

		var promise = deferred.promise;
		promise.then(function (data) {
			console.log('yeees');
			$location.path("/login");
		});


	}

	$scope.generateReport = function(){

		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
		$http({
			url: "http://localhost:8089/PINF_WSProjekat/api/banka/izvestaj",
			method: "GET"
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {

		});

		var promise = deferred.promise;
		promise.then(function (data) {
			console.log('yeees');
		});


	}


}).run([
        'bootstrap3ElementModifier',
        function (bootstrap3ElementModifier) {
              bootstrap3ElementModifier.enableValidationStateIcons(true);
}])

 .run([
    'defaultErrorMessageResolver',
    function (defaultErrorMessageResolver) {
        // passing a culture into getErrorMessages('fr-fr') will get the culture specific messages
        // otherwise the current default culture is returned.
    	defaultErrorMessageResolver.setCulture('rs-sr');
//        defaultErrorMessageResolver.getErrorMessages().then(function (errorMessages) {
//          errorMessages['requiredMy'] = 'Obavezno polje!';
//
//        });
    }
]);

