CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE achive2 (
    id uuid DEFAULT uuid_generate_v4 (),
    number integer,
    message varchar,
    PRIMARY KEY (id)
);