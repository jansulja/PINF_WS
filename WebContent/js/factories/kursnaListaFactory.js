angular.module('resource.kursnaLista', ['ngResource'])
	.factory('KursnaLista', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/kursnalista/:kursnaListaId',null, {
        'update': { method:'PUT' }
    });
})