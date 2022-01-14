create table disease_type
(
    id   int auto_increment
        primary key,
    name varchar(45) not null
);

create table disease
(
    id              int auto_increment
        primary key,
    disease_type_id int         not null,
    name            varchar(45) not null,
    constraint disease_ibfk_1
        foreign key (disease_type_id) references disease_type (id)
);

create index disease_type_id
    on disease (disease_type_id);

create table region
(
    id   int auto_increment
        primary key,
    name varchar(45) not null
);

create table specialization_of_doctor
(
    id   int auto_increment
        primary key,
    name varchar(255) not null
);

create table street_name
(
    id   int auto_increment
        primary key,
    name varchar(45) not null
);

create table street_type
(
    id   int auto_increment
        primary key,
    name varchar(45) not null
);

create table сity
(
    id   int auto_increment
        primary key,
    name varchar(45) not null
);

create table address
(
    id              int(20) auto_increment
        primary key,
    city_id         int         not null,
    region_id       int         not null,
    street_type_id  int         not null,
    street_name_id  int         not null,
    building_number varchar(45) not null,
    constraint address_ibfk_1
        foreign key (region_id) references region (id),
    constraint address_ibfk_2
        foreign key (city_id) references сity (id),
    constraint address_ibfk_3
        foreign key (street_type_id) references street_type (id),
    constraint address_ibfk_4
        foreign key (street_name_id) references street_name (id)
);

create index city_id
    on address (city_id);

create index region_id
    on address (region_id);

create index street_name_id
    on address (street_name_id);

create index street_type_id
    on address (street_type_id);

create table medical_institution
(
    id         int auto_increment
        primary key,
    name       varchar(45) not null,
    address_id int         not null,
    constraint medical_institution_ibfk_1
        foreign key (address_id) references address (id)
);

create index address_id
    on medical_institution (address_id);

create table personal_information
(
    id            int auto_increment
        primary key,
    phone         varchar(45) not null,
    `e-mail`      varchar(45) not null,
    date_of_birth date        not null,
    address_id    int         not null,
    constraint personal_information_ibfk_1
        foreign key (address_id) references address (id)
);

create table doctor
(
    id                int auto_increment
        primary key,
    full_name         varchar(255) not null,
    personal_info_id  int          not null,
    specialization_id int          not null,
    constraint doctor_ibfk_1
        foreign key (personal_info_id) references personal_information (id),
    constraint doctor_ibfk_2
        foreign key (specialization_id) references specialization_of_doctor (id)
);

create index personal_info_id
    on doctor (personal_info_id);

create index specialization_id
    on doctor (specialization_id);

create table doctor_medical_institution
(
    doctor_id              int not null,
    medical_institution_id int not null,
    constraint doctor_medical_institution_ibfk_1
        foreign key (doctor_id) references doctor (id),
    constraint doctor_medical_institution_ibfk_2
        foreign key (medical_institution_id) references medical_institution (id)
);

create index doctor_id
    on doctor_medical_institution (doctor_id);

create index doctor_id_2
    on doctor_medical_institution (doctor_id);

create index medical_institution_id
    on doctor_medical_institution (medical_institution_id);

create table patient
(
    id               int auto_increment
        primary key,
    full_name        varchar(255) not null,
    personal_info_id int          not null,
    constraint patient_ibfk_1
        foreign key (personal_info_id) references personal_information (id)
);

create table certificate_of_illness
(
    id                                int auto_increment
        primary key,
    patient_id                        int  not null,
    doctor_id                         int  not null,
    address_of_medical_institution_id int  not null,
    date                              date not null,
    disease_id                        int  not null,
    doctor_note                       text not null,
    constraint certificate_of_illness_ibfk_1
        foreign key (patient_id) references patient (id),
    constraint certificate_of_illness_ibfk_2
        foreign key (doctor_id) references doctor (id),
    constraint certificate_of_illness_ibfk_3
        foreign key (address_of_medical_institution_id) references address (id),
    constraint certificate_of_illness_ibfk_4
        foreign key (disease_id) references disease (id)
);

create index `address_ of_medical_institution_id`
    on certificate_of_illness (address_of_medical_institution_id);

create index disease_id
    on certificate_of_illness (disease_id);

create index doctor_id
    on certificate_of_illness (doctor_id);

create index patient_id
    on certificate_of_illness (patient_id);

create table doctor_patient
(
    doctor_id  int not null,
    patient_id int not null,
    constraint doctor_patient_ibfk_1
        foreign key (patient_id) references patient (id),
    constraint doctor_patient_ibfk_2
        foreign key (doctor_id) references doctor (id)
);

create index doctor_id
    on doctor_patient (doctor_id);

create index patient_id
    on doctor_patient (patient_id);

create index personal_info_id
    on patient (personal_info_id);

create index address_id
    on personal_information (address_id);
