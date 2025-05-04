insert into address (ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTAL_CODE)
            values  (101,'Wilczkow 34','','Sroda Slaska','55-300'),
                    (102,'Wroclaw','Akacjowa 12/3','Wroclaw','53-133'),
                    (103,'Lutynia','Akacjowa 12/3','Wroclaw','53-133'),
                    (104,'Miekinia','Akacjowa 12/3','Wroclaw','53-133'),
                    (105,'Gdynia','Akacjowa 12/3','Wroclaw','53-133'),
                    (106,'Sopot','Molo 15','Sopot','51-132');

insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, ADDRESS_ID)
            values (201,
                    'Maciej',
                    'Kowalski',
                    '123123123',
                    'maciej.kowalski@wp.pl',
                    'P201',
                    '1990-07-01',
                    101),

                    (202,
                    'Igor',
                    'Nowak',
                    '223133123',
                    'Igor.Nowak@wp.pl',
                    'P201',
                    '1994-09-03',
                    102),

                    (203,
                    'Adam',
                    'Drewniany',
                    '333123123',
                    'Adam.Drewniany@wp.pl',
                    'P201',
                    '1991-02-21',
                    103),

                    (204,
                        'Marian',
                        'Kowalski',
                        '923103123',
                        'Marian.kowalski@wp.pl',
                        'P201',
                        '1999-11-01',
                        104);

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION, ADDRESS_ID)
            values (301,'Jan',
                    'Nowak',
                    '500600101',
                    'jan.nowak@przychodnia.pl',
                    '90101',
                    'SURGEON',
                    106);

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION, ADDRESS_ID)
    values (302,'Mariusz',
            'Brzechwa',
            '500600101',
            'mario.brzecha@przychodnia.pl',
            '90102',
            'SURGEON',
            102);

insert into visit (ID, DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID)
            values  (401, 'Amputacja',            '2025-07-01T09:00:00',  301,    201),
                    ( 402,'Oparzenie',            '2025-07-01T10:15:00',  301,    201),
                    ( 403,'Złamana szczęka',      '2025-03-01T10:15:00',  301,    201),
                    ( 404,'Kontuzja nadgarstka',  '2025-03-028T15:45:00', 301,    201),
                    ( 405,'Skręt kiszki (lewy)',  '2025-03-028T15:45:00', 301,    201),
                    ( 406,'Złamana szczęka',      '2025-03-01T10:15:00',  301,    203),
                    ( 407,'Kontuzja nadgarstka',  '2025-03-028T15:45:00', 301,    202),
                    ( 408,'Kontuzja nadgarstka',  '2025-04-028T15:45:00', 301,    202),
                    ( 409,'Skręt kiszki (lewy)',  '2025-04-028T15:30:00', 301,    202),
                    ( 410,'Kontuzja nadgarstka',  '2025-03-028T15:45:00', 301,    204),
                    ( 411,'Kontuzja nadgarstka',  '2025-04-028T15:45:00', 301,    204),
                    ( 412,'Skręt kiszki (lewy)',  '2025-04-028T15:30:00', 301,    204);

insert into medical_treatment(ID, DESCRIPTION, TYPE, VISIT_ID)
            values  (501, 'Badanie USG przed amputacja',          'USG',  401),
                    (502, 'Badanie RTG przed amputacja',          'RTG',  401),
                    (503, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  402),
                    (504, 'Badanie RTG przed amputacja',          'RTG',  403),
                    (505, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  403),
                    (506, 'Badanie RTG przed amputacja',          'RTG',  404),
                    (507, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  405),
                    (508, 'Badanie USG przed amputacja',          'USG',  405);



