package productApp.dao;

import java.util.List;

import productApp.model.Product;

public interface ProductDAO {
	
	
	public  void createProduct(Product product);
	public List<Product> getProducts();
	public void deleteProduct(int pid);
	public void updateProduct(Product p);
	public Product getProduct(int pid);
}
