package ma.zs.univ.unit.ws.facade.admin.purchase;

import ma.zs.univ.bean.core.purchase.Product;
import ma.zs.univ.service.impl.admin.purchase.ProductAdminServiceImpl;
import ma.zs.univ.ws.converter.purchase.ProductConverter;
import ma.zs.univ.ws.dto.purchase.ProductDto;
import ma.zs.univ.ws.facade.admin.purchase.ProductRestAdmin;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private ProductAdminServiceImpl service;
    @Mock
    private ProductConverter converter;

    @InjectMocks
    private ProductRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllProductTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ProductDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ProductDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveProductTest() throws Exception {
        // Mock data
        ProductDto requestDto = new ProductDto();
        Product entity = new Product();
        Product saved = new Product();
        ProductDto savedDto = new ProductDto();

        // Mock the converter to return the product object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved product DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ProductDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ProductDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved product DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getReference(), responseBody.getReference());
    }

}
