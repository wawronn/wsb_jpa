insert into address (ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTAL_CODE)
            values  (101,'Wilczkow 34','','Sroda Slaska','55-300'),
                    (102,'Wroclaw','Akacjowa 12/3','Wroclaw','53-133');

insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, ADDRESS_ID)
            values (201,
                    'Maciej',
                    'Kowalski',
                    '123123123',
                    'maciej.kowalski@wp.pl',
                    'P201',
                    '1990-07-01',
                    101);

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION, ADDRESS_ID)
            values (301,'Jan',
                    'Nowak',
                    '500600101',
                    'jan.nowak@przychodnia.pl',
                    '90101',
                    'SURGEON',
                    102);

insert into visit (ID, DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID)
            values  (401, 'Amputacja',            '2025-07-01T09:00:00',  301,    201),
                    ( 402,'Oparzenie',            '2025-07-01T10:15:00',  301,    201),
                    ( 403,'Złamana szczęka',      '2025-03-01T10:15:00',  301,    201),
                    ( 404,'Kontuzja nadgarstka',  '2025-03-028T15:45:00', 301,    201),
                    ( 405,'Skręt kiszki (lewy)',  '2025-03-028T15:45:00', 301,    201);

insert into medical_treatment(ID, DESCRIPTION, TYPE, VISIT_ID)
            values  (501, 'Badanie USG przed amputacja',          'USG',  401),
                    (502, 'Badanie RTG przed amputacja',          'RTG',  401),
                    (503, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  402),
                    (504, 'Badanie RTG przed amputacja',          'RTG',  403),
                    (505, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  403),
                    (506, 'Badanie RTG przed amputacja',          'RTG',  404),
                    (507, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  405),
                    (508, 'Badanie USG przed amputacja',          'USG',  405);



