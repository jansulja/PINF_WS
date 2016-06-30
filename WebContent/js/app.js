//var myApp = angular.module('myApp', ['ngRoute','drzava-list','resource.drzava']); //angular modul, referencira myApp iz index.html-a


angular
.module('myApp', [
'ngRoute',
'registration',
'success','drzava-list','resource.drzava'])


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
		when('/success', {
			templateUrl: 'views/success.html',
			controller: 'SuccessController'
		}).
		when('/registerpravno', {
			templateUrl: 'views/registerpravno.html',
			controller: 'RegistrationController'
		}).
		when('/drzava-list', {
			templateUrl: 'views/drzava-list.html',
			controller: 'drzava-listCtrl'
		}).
		otherwise({
			redirectTo: '/login'
		});
});

