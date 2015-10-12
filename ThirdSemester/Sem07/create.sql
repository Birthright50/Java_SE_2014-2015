
create table users("id" integer not null primary key, "login" varchar(255) not null, "password" varchar(255) not null, "email" varchar(255) not null, "region" varchar(255), "first_name" varchar(255), "last_name" varchar(255), "date" Date not null, "year_st" integer not null, "gender" varchar(1) not null, "car_mark" varchar(255) not null);


create table auto_brands ("id" integer not null primary key, "name" varchar(255) not null, "url" varchar(255) not null);
create table auto_models ("id" integer not null primary key, "name" varchar(255) not null, "id_brand" integer not null references "auto_brands"("id"), "url" varchar(255) not null);
create table auto_submodels ("id" integer not null primary key, "name" varchar(255), "id_brand" integer not null references "auto_brands"("id"), "id_model" integer not null references "auto_models"("id"), "url" varchar(255) not null);
create table auto_modify ("id" integer not null primary key, "name" varchar(255) not null, "longname" varchar(255) not null, "id_model" integer not null references "auto_models"("id"), "id_submodel" integer not null references "auto_submodels"("id"), "engine_type" varchar(255) not null, "drive_type" varchar(255) not null, "release_from" integer not null, "release_to" integer not null, "url" varchar(255) not null);
create table auto_params ("id" integer not null primary key, "id_param" integer not null references "auto_param_names"("id"), "id_group" integer not null references "auto_params_groups"("id"), "id_modify" integer not null references "auto_modify"("id"), "value" varchar(255) not null);
create table auto_param_names ("id" integer not null primary key, "name" varchar(255) not null, "id_group" integer not null references "auto_params_groups"("id"), "units" varchar(255) not null);
create table auto_params_groups ("id" integer not null primary key, "name" varchar(255) not null);


