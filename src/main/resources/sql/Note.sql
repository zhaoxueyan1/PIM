drop table if exists Note;
create table Note(
                id int not null auto_increment primary key,
                text VARCHAR(20),
                  Priority varchar(20),
                  owner varchar(20)
                 );
