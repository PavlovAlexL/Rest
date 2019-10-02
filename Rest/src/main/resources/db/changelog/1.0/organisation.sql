CREATE TABLE IF NOT EXISTS Organisation (
  id          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version     INTEGER NOT NULL DEFAULT 1,
  name        VARCHAR(50) NOT NULL,
  full_name   VARCHAR(50) NOT NULL,
  inn         VARCHAR(10) NOT NULL,
  kpp         VARCHAR(9)  NOT NULL,
  address     VARCHAR(200) NOT NULL,
  phone       VARCHAR(20) ,
  is_Active   BOOLEAN
);
COMMENT ON TABLE  Organisation IS 'Организация';
COMMENT ON COLUMN Organisation.id IS 'id';
COMMENT ON COLUMN Organisation.version IS 'Служебное поле hibernate, должно быть NOT NULL';
COMMENT ON COLUMN Organisation.name IS 'Сокращенное наименование';
COMMENT ON COLUMN Organisation.full_name IS 'Полное наименование';
COMMENT ON COLUMN Organisation.inn IS 'ИНН организации';
COMMENT ON COLUMN Organisation.kpp IS 'КПП организации';
COMMENT ON COLUMN Organisation.address IS 'Адрес';
COMMENT ON COLUMN Organisation.phone IS 'Телефон';
COMMENT ON COLUMN Organisation.is_Active IS 'Статус';
