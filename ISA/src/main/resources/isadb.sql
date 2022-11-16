insert into med_user (id, address, city, country, email, first_name, gender, info, jmbg, job, last_name, password, phone_number, blood_type, category, penalties, points, med_center_id, work_calendar_id) values (1, 'Dositejeva 100', 'Kraljevo', 'Srbija', 'aleksa@gmail.com', 'Aleksa', 0, 'info', '1234567890123', 'job', 'Mihic', '123', '123456789', 1, 1, 0, 0, 1, 1);





insert into med_center (id, city, country, description, name, street) values (1, 'Beograd', 'Srbija', 'Medicinski centar za davanje krvi', 'MedCenterBG', 'Banjicka 15');



insert into appointment (id, date_time, deleted, duration, start_time) values (1, '2022/12/25', 'false', 30, '17:00:00');
