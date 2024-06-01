CREATE TABLE IF NOT EXISTS usuario (
     cd_ID     serial PRIMARY KEY,
     nm_Nome   varchar(18),
     ds_Senha  varchar(30)
);

CREATE TABLE IF NOT EXISTS pedido (
     cd_IdPedido    serial PRIMARY KEY,
     nm_Cliente     varchar(30),
     ic_Entregar    boolean,
     ds_Endereco    varchar(50),
     ic_Pronto      boolean
);

CREATE TABLE IF NOT EXISTS itemCardapio (
     cd_IdItemCardapio        serial PRIMARY KEY,
     nm_ItemCardapio          varchar(30),
     ds_Componentes           varchar(100),
     vl_Preco                 float
);

CREATE TABLE IF NOT EXISTS itemPedido (
     cd_IdItemPedido     serial PRIMARY KEY,
     cd_IdPedido         integer REFERENCES pedido(cd_IdPedido),
     cd_ItemCardapio     integer REFERENCES itemCardapio(cd_IdItemCardapio),
     ic_Pronto           boolean
);

--ALTER TABLE itemCardapio ADD COLUMN IF NOT EXISTS vl_Preco MONEY;