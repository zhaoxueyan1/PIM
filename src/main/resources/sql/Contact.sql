drop table if exists Contact;
create table Contact(
                    id int not null auto_increment primary key,
                    first_name varchar(20), last_name varchar(20),
                    email_address varchar(20),
                    Priority varchar(20),
                    owner varchar(20)
                    );
