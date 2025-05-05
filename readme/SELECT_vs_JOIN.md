# Logi z Hibernate; porównanie SELECT i JOIN dla encji Pacjenta i jego wizyt

## 1. `FetchType.SELECT`

```sql
Hibernate: 
	select 
		pe1_0.id,a1_0.id,a1_0.address_line1,a1_0.address_line2,a1_0.city,a1_0.postal_code,a1_0.version,
		pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.last_name,pe1_0.patient_number,pe1_0.telephone_number 
	from patient pe1_0 
	left join address a1_0 
		on a1_0.id=pe1_0.address_id 
	where pe1_0.id=?
	
Hibernate: 
	select 
		v1_0.patient_id,v1_0.id,v1_0.description,v1_0.doctor_id,v1_0.time 
	from visit v1_0 
	where v1_0.patient_id=?
```

## 2. `FetchType.JOIN`

```sql
Hibernate: 
	select 
		pe1_0.id,a1_0.id,a1_0.address_line1,a1_0.address_line2,a1_0.city,a1_0.postal_code,a1_0.version,
		pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.last_name,pe1_0.patient_number,pe1_0.telephone_number,
		v1_0.patient_id,v1_0.id,v1_0.description,v1_0.doctor_id,v1_0.time 
	from patient pe1_0 
	left join address a1_0 
		on a1_0.id=pe1_0.address_id 
	left join visit v1_0 
		on pe1_0.id=v1_0.patient_id 
	where pe1_0.id=?
```

# Wnioski

Dla `FetchType.SELECT` wykonano osobne zapytanie do tabeli **visit**, natomiast dla `FetchType.JOIN` wszystko
odbyło się w jednym zapytaniu z użyciem polecenia `LEFT JOIN`. Dzięki temu zmniejsza się liczbę połączeń z bazą
oraz osiąga większą wydajność przy pobieraniu danych dla wielu pacjentów. Należy jednak dobrze przemyśleć
wybór pomiędzy SELECT a JOIN. Większa liczba pobieranych danych to większe zużycie pamięci i czas oczekiwania
na odpowiedź aplikacji. Jeśli ZAWSZE przy pobieraniu danych dla pacjenta potrzebujemy WSZYSTKICH jego wizyt, to
warto użyć JOIN. W przeciwnym razie bezpieczniej jest zostać przy SELECT.