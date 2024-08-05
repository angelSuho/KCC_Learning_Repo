package kosa.model;

import java.io.Serializable;

public class CartItem implements Serializable {
	private int cartItemId;
	private int cartId;
	private int productId;
	private String productName;
	private int productPrice;
	private int quantity;
	
	public CartItem() {}

	public CartItem(int cartItemId, int cartId, int productId, String productName, int productPrice, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartId=" + cartId + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}
}
