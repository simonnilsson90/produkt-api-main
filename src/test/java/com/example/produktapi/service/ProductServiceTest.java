package com.example.produktapi.service;

import com.example.produktapi.exception.BadRequestException;
import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;

import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;


import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService underTest;

    @Captor
    ArgumentCaptor<Product> productCaptor;
    @Test
    void givenGetAllProducts_thenExactlyOneInteractionWithRepositoryMethodFindALl() {
        // when
        underTest.getAllProducts();
        // then
        verify(repository, Mockito.times(1)).findAll();

    }
/*

    @Test
    void whenGettAllCategories_thenOnlyOneInteractionWithRepositoryMethodFindALlGetByCategory(){
        // when
        underTest.getAllCategories();
        // then
        verify(repository, Mockito.times(1)).findAllCategories();
        verifyNoMoreInteractions((repository));
    }

    /*



    @Test
    void givenAnExistingCategory_whenGetProductsByCategory_ThenReceivesANonEmptyList (){
        // when
     //  List<Product> underTest.getProductsByCategory("Electronics");
    }


*/

    // Tester till inlämning

    // Metoder att testa:
    // getAllProducts()    Check
    // getAllCategories()  Check
    // getProductsByCategory(String category) check
    // getProductById(Integer id) Check men failar
    // addProduct(Product product) Check men
    // Product updateProduct(Product updatedProduct, Integer id)
    // deleteProduct(Integer id) Check



    // Testar getAllProducts() Kanske bara ta
    // Test Passed
    @Test
    void givenGetAllProducts_thenOnlyOneInteractionWithRepositoryMethodFindALl() {
        // when, När vi ropar på getAllProducts
        underTest.getAllProducts();
        // then, då verifierar vi att vårt repository åberopas med Metoden findAll exakt en gång.
        verify(repository, Mockito.times(1)).findAll();

    }

    @Test
        // Testar getAllCategories() att den nås genom Repository

    void givenGetAllCategories_thenExactlyOneInteractionWithRepositoryMethodFindALlCategories() {
        // Test Passed
        // when
        underTest.getAllCategories();

        // then
        verify(repository, Mockito.times(1)).findAllCategories();
    }


    @Test
        // Testar getProductsByCategory(String category)
    void givenGetProductsByCategory_thenOneInteractionWithRepositoryMethodGetProductsByCategory() {
        // Test passed
        // when
        underTest.getProductsByCategory("jewelery");
        // then
        verify(repository, Mockito.times(1)).findByCategory("jewelery");
    }


    @Test
        // Testar om det går att lägga till ny produkt?
    // Test failed
    void whenCreatingNewProduct_thenOneInteractionWithMethodGetProductsByCategory() {
// given
        Product product = new Product("Lasersvärd", 40.0, "sword", "red", "img");
       // when
        underTest.addProduct(product);

        //then
        BDDMockito.verify(repository).save(product);

    }


    // PROBLEM MED DENNA - FRÅGA MATHILDA
    @Test
    // Testar getProductById(Integer id)
    void whenGettingProductById_thenGetProductByIdShouldBeCalled() {
// given

        Product product = new Product("Adidas 500", 14.5, "shoes", "cool", "img");

       given(repository.findById(1)).willReturn(Optional.of(product));

       //when
        underTest.getProductById(1);

// then
        BDDMockito.verify(repository).getReferenceById(1);


        }

    @Test
    void testingIfProductIsEmptyThenThrowEntityNotFound (){







    }



    @Test// Testar addProduct(Product product)
    // Är den här bara en kopia?
    void whenAddingProduct_thenSaveMethodShouldBeCalled (){
        // given
        Product product = new Product("Holy Graal", 5000.0, "jewelry","The real one, found on the bottom of the ocean ner Island of all places","img_hg" );
        // when
        underTest.addProduct(product);

        // then
        verify(repository).save(product);


    }
/*
    // Testar delete Product
@Test
    void deleteProduct(){
        // when
    repository.deleteById(1);
    // then
    BDDMockito.verify(repository).deleteById(1);
}

*/
 /*

// Testar att updateProduct
    @Test
    void upDateProduct(Product updatedProduct){

        // when
        repository.findById(1);
        BDDMockito.verify(repository).save(updatedProduct);
    }


  */

    @Test
    // Product updateProduct(Product updatedProduct, Integer id)
    void testingUpdateProduct () {
// when


    }

}








