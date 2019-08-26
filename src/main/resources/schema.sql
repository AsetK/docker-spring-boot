drop table if exists person;
create table person (
                        person_id integer not null,
                        first_name text not null,
                        last_name text not null,
                        constraint person_pk primary key (person_id)
);

create sequence seq_person
    as integer
	increment by 1
	minvalue 1
	start 1
	cache 1
	owned by person.person_id;