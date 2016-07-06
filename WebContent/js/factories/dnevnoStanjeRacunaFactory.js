angular.module('resource.dnevnoStanjeRacuna', ['ngResource'])
	.factory('DnevnoStanjeRacuna', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/dnevnostanjeracuna/:dnevnoStanjeRacunaId',null, {
        'update': { method:'PUT' }
    });
})