
insert into questions_for_donnor(id, adresa, broj_davanja, broj_davaoca, datum, datum_rodjenja, jmbg, kucni_tel, mesto, mobilni_tel, opstina, pol, poslovni_tel, potpis, preduzece_fakultet_skola, prezime_roditelj_ime, q1, q10,q12,q13,q14,q15,q16,q17,q18,q19,q2,q20_a,q20_b,q20_c,q21,q22_a,q22_b,q22_c,q22_d,q22_e,q22_f,q22_g,q23_a,q23_b,q23_c,q23_d,q23_e,q23_f,q24,q25,q26,q3,q4,q5,q6,q7,q8,q9, zanimanje )
values(1,'Topolska 18', 0, 121, '2022-04-26T08:30:00', '1998-04-26T08:30:00', '1234567891234', '381928', 'Kraljevo', '0645051104', 'Kraljevo', 0, '061545454', 'potpis', '/', '/', 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 'student');
insert into questions_for_donnor(id, adresa, broj_davanja, broj_davaoca, datum, datum_rodjenja, jmbg, kucni_tel, mesto, mobilni_tel, opstina, pol, poslovni_tel, potpis, preduzece_fakultet_skola, prezime_roditelj_ime, q1, q10,q12,q13,q14,q15,q16,q17,q18,q19,q2,q20_a,q20_b,q20_c,q21,q22_a,q22_b,q22_c,q22_d,q22_e,q22_f,q22_g,q23_a,q23_b,q23_c,q23_d,q23_e,q23_f,q24,q25,q26,q3,q4,q5,q6,q7,q8,q9, zanimanje )
values(2,'Topolska 18', 0, 121, '2022-10-26T08:30:00', '1998-04-26T08:30:00', '1234567891234', '381928', 'Kraljevo', '0645051104', 'Kraljevo', 0, '061545454', 'potpis', '/', '/', 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 'student');
insert into questions_for_donnor(id, adresa, broj_davanja, broj_davaoca, datum, datum_rodjenja, jmbg, kucni_tel, mesto, mobilni_tel, opstina, pol, poslovni_tel, potpis, preduzece_fakultet_skola, prezime_roditelj_ime, q1, q10,q12,q13,q14,q15,q16,q17,q18,q19,q2,q20_a,q20_b,q20_c,q21,q22_a,q22_b,q22_c,q22_d,q22_e,q22_f,q22_g,q23_a,q23_b,q23_c,q23_d,q23_e,q23_f,q24,q25,q26,q3,q4,q5,q6,q7,q8,q9, zanimanje )
values(3,'Topolska 18', 0, 121, '2022-04-26T08:30:00', '1998-04-26T08:30:00', '1234567891234', '381928', 'Kraljevo', '0645051104', 'Kraljevo', 0, '061545454', 'potpis', '/', '/', 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 'student');


insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role, qfd_id) values (1, 'Jug Bogdanova', 'Novi Sad', 'Srbija', 'miki@gmail.com', true, 'Miki', 0, 'info', '1234567891234', 'job', 'Manojlovic', null, '$2a$12$9ejY2M6aMEOgVtyl1Bu07uGqjqn.dxFrdPzHbRx4IBXeymM3iwhd6', '12345698', 'AdminEmployee', null);
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role, qfd_id) values (2, 'Karadjordjeva', 'Novi Sad', 'Srbija', 'ljubo@gmail.com', true, 'Ljubo', 0, 'info', '1237894561235', 'job', 'Petrovic', null, '$2a$12$YKm/ePypS3QXKER5j2WCcOqVSAKfWDgc.Oemragg4revyrSxyTkJu', '12345698', 'ROLE_PATIENT', 1);
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role, qfd_id) values (3, 'Mihajla Pupina', 'Novi Sad', 'Srbija', 'strajo@gmail.com', true, 'Strahinja', 0, 'info', '4567891234561', 'job', 'Minic', null, '$2a$12$AajkDSULM5ripfJq32ivLOipCclaXJV9El2VCWW0uaIMWFqiBxfZ.', '12345698', 'Patient', 2);
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role, qfd_id) values (4, 'Obiliceva', 'Novi Sad', 'Srbija', 'mihicaleksa036@gmail.com', true, 'Marko', 0, 'info', '7894561234567', 'job', 'Markovic', null, '$2a$12$ULLh8P20tyLRZs6XJDXXJ.QNKvUCbTbzRk.PIMvA/XUkncUjf4NZe', '12345698', 'Patient', 3);
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role, qfd_id) values (5, 'Karadjordjeva', 'Novi Sad', 'Srbija', 'uros@gmail.com', true, 'Uros', 0, 'info', '1591234567894', 'job', 'Lazic', null, '$2a$12$AnpWLFOuTQkt44SMv8F0j.xv4e7Z3qx2soAVoz1R8Q4xxIFJ/L.Vq', '12345698', 'Patient', null);
insert into med_user(id, address, city, country, email, enabled, first_name, gender, info, jmbg, job, last_name, last_password_reset_date, password, phone_number, role, qfd_id) values (6, 'Dositejeva', 'Novi Sad', 'Srbija', 'stefan@gmail.com', true, 'Stefan', 0, 'info', '3692581472583', 'job', 'Petrovic', null, '$2a$12$GGMLwW62NSS1sh7cDn4SdeSorf9EJPZMGyPIV8BnBIbqjR7soB9b6', '12345698', 'Patient', null);


insert into authority(id, name) values (1, 'ROLE_ADMIN_EMPLOYEE');
insert into authority(id, name) values (2, 'ROLE_PATIENT');


insert into med_user_authorities(med_user_id, authorities_id) values (1,1);
insert into med_user_authorities(med_user_id, authorities_id) values (2,2);
insert into med_user_authorities(med_user_id, authorities_id) values (3,2);
insert into med_user_authorities(med_user_id, authorities_id) values (4,2);
insert into med_user_authorities(med_user_id, authorities_id) values (5,2);
insert into med_user_authorities(med_user_id, authorities_id) values (6,2);


insert into patient(blood_type, category, penalties, points, id) values (0, 0, 0, 0, 2);
insert into patient(blood_type, category, penalties, points, id) values (0, 0, 0, 0, 3);
insert into patient(blood_type, category, penalties, points, id) values (0, 0, 0, 0, 4);
insert into patient(blood_type, category, penalties, points, id) values (0, 0, 0, 0, 5);

insert into appointment(id, start, deleted, reserved, duration, patient_id) values (1, '2022-12-26T08:30:00', 'false', 'true', 30, 3);
insert into appointment(id, start, deleted, reserved, duration, patient_id) values (2, '2022-12-26T07:00:00', 'false', 'true', 30, 3);
insert into appointment(id, start, deleted, reserved, duration, patient_id) values (3, '2022-12-26T07:30:00', 'false', 'true', 30, 4);
insert into appointment(id, start, deleted, reserved, duration, patient_id) values (4, '2022-12-26T08:00:00', 'false', 'false', 30, null);

insert into appointment(id, start, deleted, reserved, duration, patient_id) values (5, '2022-12-23T09:00:00', 'false', 'false', 30, null);
insert into appointment(id, start, deleted, reserved, duration, patient_id) values (6, '2022-12-26T09:30:00', 'false', 'false', 30, null);
insert into appointment(id, start, deleted, reserved, duration, patient_id) values (7, '2022-12-26T10:00:00', 'false', 'false', 30, null);




