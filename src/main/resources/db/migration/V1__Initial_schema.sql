CREATE TABLE game (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  name varchar(255) NOT NULL,
  creator varchar(255) NOT NULL,
  date_of_creation varchar(255) NOT NULL,
  genre varchar(255) NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP NOT NULL,
  version integer NOT NULL
);
