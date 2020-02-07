DELETE FROM parametr WHERE value IS NULL;
DELETE FROM product_parametr WHERE value IS NULL;

alter table section alter column name set not null;
alter table category alter column name set not null;
alter table product alter column price set not null;
alter table photo alter column link set not null;
alter table parametr alter column value set not null;
alter table photo alter column link set not null;
alter table product_parametr alter column value set not null;