//var myApp = angular.module('myApp', ['ngRoute','drzava-list','resource.drzava']); //angular modul, referencira myApp iz index.html-a


angular
.module('myApp', [
'ngRoute',
'registration',
'success','drzava-list','resource.drzava','drzava-new','resource.valuta','valuta-list','valuta' ])



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
		when('/valuta/:idValute', {
			templateUrl: 'views/valuta.html',
			controller: 'valutaCtrl'
		}).
		otherwise({
			redirectTo: '/login'
		});
});

