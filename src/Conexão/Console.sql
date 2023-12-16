SELECT * FROM tabeladeusuario;

select * from tabeladedenuncias;

UPDATE tabeladeusuario SET perfil = 'USUARIO' WHERE id = '5';

ALTER TABLE tabeladedenuncias
    ADD data_atualizacao date,
    ADD idAnalista integer;

drop
