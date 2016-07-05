angular.module('resource.kursUValuti', ['ngResource'])
	.factory('KursUValuti', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/kursuvaluti/:kursUValutiId',null, {
        'update': { method:'PUT' }
    });
})