package kosa.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kosa.model.Cart;
import kosa.model.CartItem;

public interface CartMapper {
	int insertCart(Cart cart);
	Cart selectCartByUserId(String userId);
	int insertCartItem(CartItem cartItem);
	List<CartItem> selectCartItems(int cartId);
	int updateCartItemQuantity(@Param("cartItemId") int cartItemId, @Param("quantity") int quantity);
	CartItem selectCartItemByCartIdAndProductId(Map<String, Integer> map);
	int deleteCartItem(int cartItemId);
}
