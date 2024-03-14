package ma.zs.univ.unit.service.impl.admin.purchase;

import ma.zs.univ.bean.core.purchase.PurchaseItem;
import ma.zs.univ.dao.facade.core.purchase.PurchaseItemDao;
import ma.zs.univ.service.impl.admin.purchase.PurchaseItemAdminServiceImpl;

import ma.zs.univ.bean.core.purchase.Purchase ;
import ma.zs.univ.bean.core.purchase.Product ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PurchaseItemAdminServiceImplTest {

    @Mock
    private PurchaseItemDao repository;
    private AutoCloseable autoCloseable;
    private PurchaseItemAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PurchaseItemAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPurchaseItem() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePurchaseItem() {
        // Given
        PurchaseItem toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePurchaseItem() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPurchaseItemById() {
        // Given
        Long idToRetrieve = 1L; // Example PurchaseItem ID to retrieve
        PurchaseItem expected = new PurchaseItem(); // You need to replace PurchaseItem with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PurchaseItem result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PurchaseItem constructSample(int i) {
		PurchaseItem given = new PurchaseItem();
        given.setId(id);
        given.setProduct(new Product(1L));
        given.setProduct(product);
        given.setPrice(BigDecimal.TEN);
        given.setPrice(price);
        given.setQuantity(BigDecimal.TEN);
        given.setQuantity(quantity);
        given.setPurchase(new Purchase(1L));
        given.setPurchase(purchase);
        return given;
    }

}
