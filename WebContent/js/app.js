'use strict';

angular
.module('myApp', [
'ngRoute',
'registration',
'success'])


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
		otherwise({
			redirectTo: '/login'
		});
});

