DROP TABLE "Sculptures" CASCADE;

CREATE TABLE "Sculptures" (
  id bigserial NOT NULL,
  name character varying(200),
  author character varying(200),
  year integer,
  material character varying(200),
  height numeric,
  width numeric,
  CONSTRAINT "Sculptures_pk" PRIMARY KEY (id)
);

INSERT INTO Sculptures(name, author, year, material, height, width) values ('Давид', 'Микеланджело', 1501, 'Мрамор', 5.17, 87);
INSERT INTO Sculptures(name, author, year, material, height, width) values ('Мыслитель', 'Огюст Роден', 1882, 'Бронза', 1.89, 98);
INSERT INTO Sculptures(name, author, year, material, height, width) values ('Венера Милосская', 'Агесандр Антиохийский', -130, 'Мрамор', 2.02, 53);

