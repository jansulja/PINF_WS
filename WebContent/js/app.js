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
,'racuni-list','resource.racuni','racuni'])



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

