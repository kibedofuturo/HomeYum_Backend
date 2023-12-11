create table ingredients (
    id bigint not null auto_increment,
    name varchar(100) not null,
    value double not null,

    primary key (id)
);

create table recipes (
    id bigint not null auto_increment,
    name varchar(100) not null,
    preparationmethod text not null,
    preparationtime double  not null,
    servingnumber int,
    dificulty varchar(25),
    category varchar(25),
    user_id BIGINT,
    ingredient_id BIGINT,

    primary key (id),
    foreign key (user_id) references users(id),
    foreign key (ingredient_id) references ingredients(id)
);
