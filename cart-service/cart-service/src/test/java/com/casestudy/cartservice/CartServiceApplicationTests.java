package com.casestudy.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//import java.util.ArrayList;
//import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
//import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.cartservice.controller.CartController;
import com.casestudy.cartservice.model.Cart;
import com.casestudy.cartservice.repository.CartRepository;



//import com.naveenc.cartservice.model.Cart;

@SpringBootTest
class CartServiceApplicationTests {
	
	@MockBean
	private CartRepository cartRepo;

	@Autowired
	private CartController contr;

	
	
	

	/*@Test
	void getAllCartTest() {
		when(cartRepo.findAll()).thenReturn(Stream
				.of(new Cart (64, 2, 2,"cat", "bat",100.0,3)).collect(Collectors.toList()));
		assertEquals(1, contr.getAllCarts().size());
	}*/
	
	
	@Test
	void getAllCartsTest() {
		when(cartRepo.findAll()).thenReturn(Stream.
				of(new Cart (64, 2, 3, "image", "bluetoothspeaker", 23.55, 3 ),
						new Cart (6, 2, 2,"cat", "bat",100.0,3)).collect(Collectors.toList()));
		assertEquals(2, contr.getAllCarts().size());
	}
	
	
	/*@Test
	public void  deleteCart()
	{
		//Cart cart = new Cart(6, 2, 2,"cat", "bat",100.0,3);
		
		CartService  cartService= new CartService(6, 2, 2,"cat", "bat",100.0,3);
		//Cart cart = null;
		cartService.deleteCart(cart);
		verify(cartRepo,times(1)).delete(cart);
	}*/

		
	}


	

