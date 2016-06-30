'use strict';

angular
.module('myApp', [
'ngRoute',
'registration',
'success',
'drzava-new'])


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
		when('/drzava-new',{
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
		otherwise({
			redirectTo: '/login'
		});
});

