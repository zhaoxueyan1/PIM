drop table if exists Todo;
create table Todo(
                id int not null auto_increment primary key,
                date datetime,
                item varchar(20),
                Priority varchar(20),
                owner varchar(20)
);
