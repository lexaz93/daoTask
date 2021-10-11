drop table if exists accounts;

create table accounts
(
    login     varchar primary key,
    password  varchar,
    firstName varchar,
    lastName  varchar,
    age       int
);

insert into accounts (login, password, firstName, lastName, age)
values ('alex', 'qwer', 'алексей', 'путов', 19);
insert into accounts (login, password, firstName, lastName, age)
values ('ann', 'rewq', 'анна', 'кузина', 26);
insert into accounts (login, password, firstName, lastName, age)
values ('oleg', '0000', 'олег', 'летов', 40);
insert into accounts (login, password, firstName, lastName, age)
values ('misha', '1234', 'миша', 'спицын', 20);