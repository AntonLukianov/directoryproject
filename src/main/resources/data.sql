INSERT INTO Organization (version, name, full_name, inn, kpp, phone, address, is_active ) VALUES (0, 'ПАО Сбербанк(МСК)',
'Московский банк ПАО Сбербанк', '7707083893', '773643001', '+74955005550', 'г. Москва, ул. Вавилова, д.19', true);

INSERT INTO Organization (version, name, full_name, inn, kpp, phone, address, is_active ) VALUES (0, 'ПАО Сбербанк(ЕКБ)',
'Уральский банк ПАО Сбербанк', '7707083893', '667102008',  '+73432695290', 'г. Екатеринбург, ул. Малышева, 31-в', true);

INSERT INTO Office (version, name, phone, address, is_active, org_id) VALUES (0, 'Офис 1', '+74951111111',
'г. Москва, ул. Пушкина, д.15, оф. 18',  true, 1);

INSERT INTO Office (version, name, phone, address, is_active, org_id) VALUES (0, 'Офис 2', '+73431111111',
'г. Екатеринбург, ул. Ленина, д. 30, оф. 35', true, 2);

INSERT INTO Document (code, name ) VALUES ('21', 'Паспорт гражданина Российской Федерации');

INSERT INTO Country (code, name) VALUES ('643', 'Российская Федерация');

INSERT INTO Position (name) VALUES ( 'менеджер' );

INSERT INTO Employee (version, first_name, second_name, position_id , phone, country_id, office_id)
VALUES (0, 'Иван', 'Фахретдинов', 1, '+79993503512', 1, 1);

INSERT INTO Employee (version, first_name, second_name, position_id , phone, country_id, office_id)
VALUES (0, 'Владимир', 'Лебелев', 1, '+73472564141', 1, 1);

INSERT INTO Document_Employee (doc_id, number, date, empl_id) VALUES (1, '6305 454552', '2007-05-25', 1);

INSERT INTO Document_Employee (doc_id, number, date, empl_id) VALUES (1, '6305 454356', '2017-02-03', 2);