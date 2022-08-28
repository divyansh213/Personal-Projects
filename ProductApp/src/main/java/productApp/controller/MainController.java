package productApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import productApp.dao.ProductDAO;
import productApp.dao.ProductDAOImpl;
import productApp.model.Product;

@Controller
public class MainController {
	
	@Autowired()
	private ProductDAO productDAOImpl ;
	
	
	//Handler for home page
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products= productDAOImpl.getProducts();
		m.addAttribute("products", products);
		System.out.println(products);
		return "index";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model m)
	{ m.addAttribute("title","Add Product");
		return "addProduct";
	}
	
	@RequestMapping(value="/handleProduct",method= RequestMethod.POST )
	public String handleProduct(@ModelAttribute Product product,RedirectAttributes m)
	{
		productDAOImpl.createProduct(product);
		m.addFlashAttribute("msg", "Product added succesfully");
		return "redirect:addProduct";
		
	}
	
	@RequestMapping("/updateProduct/{pid}")
	public String updateProduct(@PathVariable("pid") int pid ,Model m)
	{ 
		Product product= productDAOImpl.getProduct(pid);
		System.out.println(product);
		m.addAttribute("title","Update Product");
		m.addAttribute("product", product);
		return "updateProduct";
	}
	
	
	@RequestMapping(value="/handleUpdateProduct",method= RequestMethod.POST )
	public String handleUpdateProduct(@ModelAttribute Product product,RedirectAttributes m)
	{
		productDAOImpl.updateProduct(product);
		m.addFlashAttribute("msg", "Product updated succesfully");
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/deleteProduct/{productId}",method= RequestMethod.GET )
	public String deleteProduct(@PathVariable("productId") int pid ,RedirectAttributes m)
	{
		productDAOImpl.deleteProduct(pid);
		m.addFlashAttribute("msg", "Product deleted succesfully");
		return "redirect:/";
		
	}
	
	
	

}
