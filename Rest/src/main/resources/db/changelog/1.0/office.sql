CREATE TABLE IF NOT EXISTS Office (
  id          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version     INTEGER NOT NULL DEFAULT 1,
  org_id      INTEGER NOT NULL REFERENCES Organisation(id),
  name        VARCHAR(50),
  address     VARCHAR(200),
  phone       VARCHAR(20),
  is_Active    BOOLEAN
);