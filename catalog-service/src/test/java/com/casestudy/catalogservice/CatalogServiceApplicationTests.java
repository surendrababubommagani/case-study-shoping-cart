package com.casestudy.catalogservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.catalogservice.controller.CatalogController;
import com.casestudy.catalogservice.model.Product;
import com.casestudy.catalogservice.repository.ProductRepository;

@SpringBootTest
class CatalogServiceApplicationTests {
	
	@Mock
	private ProductRepository prodRepo;

	@InjectMocks
	private CatalogController contr;
	
	public List<Product> product;
	
	@Test 
	@Order(1)
	void getAllProductsTest() {
		when(prodRepo.findAll()).thenReturn(Stream
				.of(new Product(2, "Realme6", "Electronics",16000, "data.jpg", "Smart phone its can be made in india"),
					new Product(64, "Levi", "Clothing", 3599, "levi.jpg", "Printed Tshirt")).collect(Collectors.toList()));
		assertEquals(2,contr.getAllProducts().size());
	}
	
	@Test 
	@Order(2)
	public void getProductByIdTest(){
		Product product = new Product (2, "Realme6", "Electronics",16000, "data.jpg", "Smart phone its can be made in india");
		Optional<Product> op = Optional.of(product);
		when(prodRepo.findById(2)).thenReturn(op);
		assertEquals(2,op.get().getId());
	}
	@Test 
	@Order(3)
	public void TestFindByName(){
		List<Product> product = new ArrayList<Product>();
		product.add(new Product (2, "Realme6", "Electronics",16000, "data.jpg", "Smart phone its can be made in india"));
		when(prodRepo.findByName("Note 8")).thenReturn(product);
		assertEquals(1, ((List<Product>) prodRepo.findByName("Note 8")).size());
	}
	@Test 
	@Order(4)
	public void addProduct(){

		Product product = new Product (2, "Realme6", "Electronics",16000, "data.jpg", "Smart phone its can be made in india");
		when(( prodRepo).insert(product)).thenReturn(product);
        assertEquals(product, ( prodRepo).insert(product));
	}
	

	
}
