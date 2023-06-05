insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role) values (1, 'Jug Bogdanova', 'Novi Sad', 'Srbija', 'miki@gmail.com', true, 'Miki', 0, 'info', '1234567891234', 'job', 'Manojlovic', null, '$2a$12$9ejY2M6aMEOgVtyl1Bu07uGqjqn.dxFrdPzHbRx4IBXeymM3iwhd6', '12345698', 'AdminEmployee');
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role) values (2, 'Karadjordjeva', 'Novi Sad', 'Srbija', 'ljubo@gmail.com', true, 'Ljubo', 0, 'info', '1237894561235', 'job', 'Petrovic', null, '$2a$12$YKm/ePypS3QXKER5j2WCcOqVSAKfWDgc.Oemragg4revyrSxyTkJu', '12345698', 'Patient');
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role) values (3, 'Mihajla Pupina', 'Novi Sad', 'Srbija', 'strajo@gmail.com', true, 'Strahinja', 0, 'info', '4567891234561', 'job', 'Minic', null, '$2a$12$AajkDSULM5ripfJq32ivLOipCclaXJV9El2VCWW0uaIMWFqiBxfZ.', '12345698', 'Patient');
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role) values (4, 'Obiliceva', 'Novi Sad', 'Srbija', 'mare@gmail.com', true, 'Marko', 0, 'info', '7894561234567', 'job', 'Markovic', null, '$2a$12$ULLh8P20tyLRZs6XJDXXJ.QNKvUCbTbzRk.PIMvA/XUkncUjf4NZe', '12345698', 'Patient');
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role) values (5, 'Karadjordjeva', 'Novi Sad', 'Srbija', 'uros@gmail.com', true, 'Uros', 0, 'info', '1591234567894', 'job', 'Lazic', null, '$2a$12$AnpWLFOuTQkt44SMv8F0j.xv4e7Z3qx2soAVoz1R8Q4xxIFJ/L.Vq', '12345698', 'Patient');
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role) values (6, 'Dositejeva', 'Novi Sad', 'Srbija', 'stefan@gmail.com', true, 'Stefan', 0, 'info', '3692581472583', 'job', 'Petrovic', null, '$2a$12$GGMLwW62NSS1sh7cDn4SdeSorf9EJPZMGyPIV8BnBIbqjR7soB9b6', '12345698', 'Patient');


insert into authority(id, name) values (1, 'ROLE_ADMIN_EMPLOYEE');
insert into authority(id, name) values (2, 'ROLE_PATIENT');


insert into med_user_authorities(med_user_id, authorities_id) values (1,1);
insert into med_user_authorities(med_user_id, authorities_id) values (2,2);
insert into med_user_authorities(med_user_id, authorities_id) values (3,2);
insert into med_user_authorities(med_user_id, authorities_id) values (4,2);
insert into med_user_authorities(med_user_id, authorities_id) values (5,2);
insert into med_user_authorities(med_user_id, authorities_id) values (6,2);