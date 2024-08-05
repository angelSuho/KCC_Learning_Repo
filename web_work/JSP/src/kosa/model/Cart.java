package kosa.model;

import java.io.Serializable;

public class Cart implements Serializable {
	private int cartId;
	private String userId;
	
	public Cart() {}

	public Cart(int cartId, String userId) {
		super();
		this.cartId = cartId;
		this.userId = userId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + "]";
	}
	
}
