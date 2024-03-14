package ma.zs.univ.unit.service.impl.admin.purchase;

import ma.zs.univ.bean.core.purchase.Product;
import ma.zs.univ.dao.facade.core.purchase.ProductDao;
import ma.zs.univ.service.impl.admin.purchase.ProductAdminServiceImpl;

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
class ProductAdminServiceImplTest {

    @Mock
    private ProductDao repository;
    private AutoCloseable autoCloseable;
    private ProductAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProductAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllProduct() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveProduct() {
        // Given
        Product toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteProduct() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetProductById() {
        // Given
        Long idToRetrieve = 1L; // Example Product ID to retrieve
        Product expected = new Product(); // You need to replace Product with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Product result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Product constructSample(int i) {
		Product given = new Product();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setReference("reference-"+i);
        given.setReference(reference);
        return given;
    }

}
