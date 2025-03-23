insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into doctor (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization)
            values (101,
                    'Jan',
                    'Nowak',
                    '500600101',
                    'jan.nowak@przychodnia.pl',
                    '90101',
                    'SURGEON' );

insert into visit (id, description, time, doctorId)
            values (00001,
                    'Amputacja',
                    '2025-07-01T09:00:00',
                    101),
                    ( 00002,
                     'Oparzenie',
                     '2025-07-01T10:15:00',
                     101);