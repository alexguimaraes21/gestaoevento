CREATE TABLE tb_eventos
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nm_evento     VARCHAR(255),
    ds_evento     VARCHAR(255),
    dh_evento     TIMESTAMP,
    ds_local      VARCHAR(255),
    vl_capacidade INT,
    sn_ativo      BOOLEAN
);
