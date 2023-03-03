package com.example.produktapi.service;

import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
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

 /*   @Test
    void givenGetAllProducts_thenExactlyOneInteractionWithRepositoryMethodFindALl() {
        // when
        underTest.getAllProducts();
        // then
        verify(repository, Mockito.times(1)).findAll();

    }


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

    // Metoder att testa:
    // getAllProducts()    Check
    // getAllCategories()  Check
    // getProductsByCategory(String category) check
   // getProductById(Integer id)
    // addProduct(Product product)
    // Product updateProduct(Product updatedProduct, Integer id)
    // deleteProduct(Integer id)


/*
    @Test
    // Testar getAllProducts() Kanske bara ta
     @Test
    void givenGetAllProducts_thenExactlyOneInteractionWithRepositoryMethodFindALl() {
        // when
        underTest.getAllProducts();
        // then
        verify(repository, Mockito.times(1)).findAll();

    }
*/


/*
    @Test // Testar getAllCategories() att den nås genom Repository

void givenGetAllCategories_thenExactlyOneInteractionWithRepositoryMethodFindALlCategories  (){
        // when
        underTest.getAllCategories();
        // then
    // then
    verify(repository, Mockito.times(1)).findAllCategories();
}

*/

/*
@Test
    // Testar getProductsByCategory(String category)
    void givenGetProductsByCategory_thenExactlyOneInteractionWithRepositoryMethodGetProductsByCategory (){
        // when
        underTest.getProductsByCategory("jewelery");
        // then
        verify(repository, Mockito.times(1)).findByCategory("jewelery");
    }


 */

    /* PROBLEM MED DENNA
    @Test
    // Testar getProductById(Integer id)
    void givenGetProductById_thenOnlyOneInteractionWithRepositoryMethodgetProductById() {
        // when
        underTest.getProductById();
        // then
        verify(repository, Mockito.times(1)).findById(1);
    }

     */

  /*  @Test// Testar addProduct(Product product)
    void whenAddingProduct_thenSaveMethodShouldBeCalled (){
        // given
        Product product = new Product("Holy Graal", 5000.0, "jewelry","The real one, found on the bottom of the ocean ner Island of all places","img_hg" );
        // when
        underTest.addProduct(product);

        // then
        verify(repository).save(product);


    } */

}








