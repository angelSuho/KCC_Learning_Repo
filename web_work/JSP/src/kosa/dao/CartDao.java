package kosa.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.CartMapper;
import kosa.model.Cart;
import kosa.model.CartItem;

public class CartDao {
	private static CartDao dao = new CartDao();

	public static CartDao getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}

	public int insertCart(Cart cart) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(CartMapper.class).insertCart(cart);

			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}

	public Cart selectCartByUserId(String userId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Cart cart = null;

		try {
			cart = sqlSession.getMapper(CartMapper.class).selectCartByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return cart;
	}

	public int insertCartItem(CartItem cartItem) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(CartMapper.class).insertCartItem(cartItem);

			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}

	public List<CartItem> selectCartItems(int cartId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<CartItem> cartItems = null;

		try {
			cartItems = sqlSession.getMapper(CartMapper.class).selectCartItems(cartId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return cartItems;
	}
	
	public int updateCartItemQuantity(int cartItemId, int quantity) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CartMapper.class).updateCartItemQuantity(cartItemId, quantity);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public CartItem selectCartItemByCartIdAndProductId(int cartId, int productId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		CartItem cartItem = null;
		
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("cartId", cartId);
			map.put("productId", productId);
			
			cartItem = sqlSession.getMapper(CartMapper.class).selectCartItemByCartIdAndProductId(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return cartItem;
	}
	
	public int deleteCartItem(int cartItemId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CartMapper.class).deleteCartItem(cartItemId);
			if(re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
}
