angular.module('resource.fizickoLice', ['ngResource'])
	.factory('FizickoLice', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/fizickolice/:fizickoLiceId',null, {
        'update': { method:'PUT' }
    });
})