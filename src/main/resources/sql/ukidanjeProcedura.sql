USE `pinf`;
DROP procedure IF EXISTS `ukidanje`;

DELIMITER $$
USE `pinf`$$
CREATE PROCEDURE `ukidanje` (IN racunId INT(11),IN brojRacunaZaPrenos VARCHAR(255))
BEGIN
DECLARE iznos double;
DECLARE novoStanjePrimalac double;
DECLARE racunPrimalacId int(11);
DECLARE stanjeIdPrimalac int(11);
DECLARE stanjeIdUplatilac int(11);
DECLARE counter int(11);

select novoStanje,dnevno_stanje_racuna_id into iznos,stanjeIdUplatilac from dnevnostanjeracuna AS dsr1 where datumPrometa = ( select max(datumPrometa) from dnevnostanjeracuna AS dsr2  where dsr1.dnevno_stanje_racuna_id = dsr1.dnevno_stanje_racuna_id and dsr1.racuni_id = racunId );

select racuni_id into racunPrimalacId from racuni where brojRacuna = brojRacunaZaPrenos;

select novoStanje into novoStanjePrimalac from dnevnostanjeracuna AS dsr1 where datumPrometa = ( select max(datumPrometa) from dnevnostanjeracuna AS dsr2  where dsr1.dnevno_stanje_racuna_id = dsr1.dnevno_stanje_racuna_id and dsr1.racuni_id = racunPrimalacId );
select dnevno_stanje_racuna_id into stanjeIdPrimalac from dnevnostanjeracuna AS dsr1 where datumPrometa = ( select max(datumPrometa) from dnevnostanjeracuna AS dsr2  where dsr1.dnevno_stanje_racuna_id = dsr1.dnevno_stanje_racuna_id and dsr1.racuni_id = racunPrimalacId );

update dnevnostanjeracuna set prethodnoStanje = novoStanjePrimalac,prometUKorist = prometUKorist+iznos,novoStanje = novoStanjePrimalac + iznos where dnevno_stanje_racuna_id = stanjeIdPrimalac;
update dnevnostanjeracuna set prethodnoStanje = iznos,prometNaTeret = prometNaTeret+iznos,novoStanje = 0 where dnevno_stanje_racuna_id = stanjeIdUplatilac;
update racuni set vazeci = false where racuni_id = racunId;

select count(*) into counter from ukidanje;

insert into ukidanje values(counter+1,NOW(),brojRacunaZaPrenos,racunId);


END$$

DELIMITER ;