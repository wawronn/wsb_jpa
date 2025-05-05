package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class AddressDaoTest
{
    @Autowired
    private AddressDao addressDao;

    @PersistenceContext
    private EntityManager em1;

    @Autowired
    private EntityManagerFactory emf;

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // given
        // when
        AddressEntity addressEntity = addressDao.findOne(101L);
        // then
        assertThat(addressEntity).isNotNull();
        assertThat(addressEntity.getPostalCode()).isEqualTo("55-300");
    }

    @Transactional
    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");
        long entitiesNumBefore = addressDao.count();

        // when
        final AddressEntity saved = addressDao.save(addressEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore+1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");

        // when
        final AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();
        final AddressEntity newSaved = addressDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        addressDao.delete(saved.getId());

        // then
        final AddressEntity removed = addressDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }

    @Test
    public void testShouldThrowOptimisticLockException() {

        Long id = 101L;

        AddressEntity adr1 = addressDao.findOne(id);
        AddressEntity adr2 = addressDao.findOne(id);

        adr1.setCity("Krynica Morska");
        logVersionFromDb(id);
        addressDao.update(adr1);
        logVersionFromDb(id);

        adr2.setCity("Jednak Miedzyzdroje");

        assertThrows(ObjectOptimisticLockingFailureException.class, () -> {
            addressDao.update(adr2);
        });
    }

    private void logVersionFromDb(Long id) {
        Object version = em1
                .createNativeQuery("SELECT version FROM address WHERE id = ?")
                .setParameter(1, id)
                .getSingleResult();
        System.out.println("Wersja w bazie dla id=" + id + ": " + version);
    }

}
