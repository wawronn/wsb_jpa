insert into address (ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTAL_CODE)
            values  (901,'Wilczkow 34','','Sroda Slaska','55-300'),
                    (902,'Wroclaw','Akacjowa 12/3','Wroclaw','53-133');

insert into patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, ADDRESS_ID)
            values (201,
                    'Maciej',
                    'Kowalski',
                    '123123123',
                    'maciej.kowalski@wp.pl',
                    'P201',
                    '1990-07-01',
                    902);

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION, ADDRESS_ID)
            values (101,'Jan',
                    'Nowak',
                    '500600101',
                    'jan.nowak@przychodnia.pl',
                    '90101',
                    'SURGEON',
                    901);

insert into visit (ID, DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID)
            values  (1, 'Amputacja',            '2025-07-01T09:00:00',  101,    201),
                    ( 2,'Oparzenie',            '2025-07-01T10:15:00',  101,    201),
                    ( 3,'Złamana szczęka',      '2025-03-01T10:15:00',  101,    201),
                    ( 4,'Kontuzja nadgarstka',  '2025-03-028T15:45:00', 101,    201),
                    ( 5,'Skręt kiszki (lewy)',  '2025-03-028T15:45:00', 101,    201);

insert into medical_treatment(ID, DESCRIPTION, TYPE, VISIT_ID)
            values  (1, 'Badanie USG przed amputacja',          'USG',  1),
                    (2, 'Badanie RTG przed amputacja',          'RTG',  1),
                    (3, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  2),
                    (4, 'Badanie RTG przed amputacja',          'RTG',  3),
                    (5, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  3),
                    (6, 'Badanie RTG przed amputacja',          'RTG',  4),
                    (7, 'Badanie EKG pacjenta po oparzeniu',    'EKG',  5),
                    (8, 'Badanie USG przed amputacja',          'USG',  5);



