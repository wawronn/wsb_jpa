insert into address (ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTAL_CODE)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION)
            values (101,
                    'Jan',
                    'Nowak',
                    '500600101',
                    'jan.nowak@przychodnia.pl',
                    '90101',
                    'SURGEON' );

insert into visit (ID, DESCRIPTION, TIME, DOCTOR_ID)
            values (1,
                    'Amputacja',
                    '2025-07-01T09:00:00',
                    101);

insert into visit (ID, DESCRIPTION, TIME, DOCTOR_ID)
            values ( 2,
                     'Oparzenie',
                     '2025-07-01T10:15:00',
                     101);

insert into medical_treatment(ID, DESCRIPTION, TYPE, VISIT_ID)
            values (1,
                    'Badanie USG przed amputacja',
                    'USG',
                    1);

insert into medical_treatment(ID, DESCRIPTION, TYPE, VISIT_ID)
            values (2,
                    'Badanie RTG przed amputacja',
                    'RTG',
                    1);

insert into medical_treatment(ID, DESCRIPTION, TYPE, VISIT_ID)
            values (3,
                    'Badanie EKG pacjenta po oparzeniu',
                    'EKG',
                    2);