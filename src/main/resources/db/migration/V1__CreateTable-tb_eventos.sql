CREATE TABLE tb_eventos
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nm_evento     VARCHAR(255) NULL,
    ds_evento     VARCHAR(255) NULL,
    dh_evento     datetime NULL,
    ds_local      VARCHAR(255) NULL,
    vl_capacidade INT NULL,
    sn_ativo      BIT(1) NULL,
    CONSTRAINT pk_tb_eventos PRIMARY KEY (id)
);