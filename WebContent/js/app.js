//var myApp = angular.module('myApp', ['ngRoute','drzava-list','resource.drzava']); //angular modul, referencira myApp iz index.html-a


angular
.module('myApp', [
'ngRoute',
'ngResource',
'ngRoute',
'ui.bootstrap',
'registration',
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
,'resource.fizickoLice','fizicko-lice-list','fizicko-lice'])



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
		when('/drzava-new/:sifraDrzave',{
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
		otherwise({
			redirectTo: '/login'
		});
}).run(function($rootScope,$location,$routeParams) {
	$rootScope.isZoomActive = function(){

		var zoom = false;

		if($rootScope.zoom){
			zoom = true;
		}

		return zoom;

	}

	$rootScope.genericPickUp = function(pickUpObject,propertyName){

		if($rootScope.propertyName){
			propertyName = $rootScope.propertyName;
		}

		$rootScope.assign($rootScope.savedObject,propertyName,pickUpObject)

		$rootScope.zoom = false;



		$location.path($rootScope.returnPath);
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

	$rootScope.genericZoom = function(savedObject,pickUpPath,returnPath,id,propertyName){


			$rootScope.propertyName = propertyName;
			$rootScope.zoom = true;
			$rootScope.savedObject = savedObject;
			$rootScope.returnPath = returnPath + $routeParams[id];
			$location.path(pickUpPath);


	}


	$rootScope.openDatepicker = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$rootScope[opened] = true;
	};

}).controller('myAppCtrl', function ($scope,$location, Drzava, $rootScope){




});

