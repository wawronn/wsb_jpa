insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values (101,
                    'Jan',
                    'Nowak',
                    '500600101',
                    'jan.nowak@przychodnia.pl',
                    '90101',
                    'SURGEON' );

insert into visit (id, description, time, doctor_id)
            values (1,
                    'Amputacja',
                    '2025-07-01T09:00:00',
                    101);

insert into visit (id, description, time, doctor_id)
            values ( 2,
                     'Oparzenie',
                     '2025-07-01T10:15:00',
                     101);