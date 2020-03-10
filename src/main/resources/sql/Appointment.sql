drop table if exists Appointment;
create table Appointment(id int not null auto_increment primary key ,
                         date DATETIME,
                         description varchar(20),
                         Priority varchar(20),
                         owner varchar(20)
);
