package productApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productApp.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private HibernateTemplate ht;

	@Transactional
	public void createProduct(Product product) {
		this.ht.save(product);
		
	}

	@Transactional
	public List<Product> getProducts() 
	{
		List<Product> products=this.ht.loadAll(Product.class);
		return products;
	}

	@Transactional
	public void deleteProduct(int pid) {
		Product product= this.ht.load(Product.class, pid);
		this.ht.delete(product);
		
	}

	@Transactional
	public void updateProduct(Product p) {
		this.ht.saveOrUpdate(p);
		
	}

	@Transactional
	public Product getProduct(int pid) {
		Product product= this.ht.get(Product.class, pid);
		return product;
	}
	
   

}
