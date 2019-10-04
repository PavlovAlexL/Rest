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

