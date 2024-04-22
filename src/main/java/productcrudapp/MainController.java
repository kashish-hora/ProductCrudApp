package productcrudapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
@EnableTransactionManagement
public class MainController {
	@Autowired
	private ProductDao productDao;
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products= productDao.getProducts()	;
		m.addAttribute("product", products);
		return "index";
	}
	//show add product form
	@RequestMapping("/add-product")
	public String addProduct( Model m) {
		m.addAttribute("title","Add Product Form");
		return "add_product_form";
	}
	//handle add product form
	
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView handleProduct( @ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectview =new RedirectView ();
		redirectview.setUrl(request.getContextPath()+"/");
		
		
		
		return redirectview;
	}
	//DELETE HANDLER
	@RequestMapping(value="/delete/{productId}")
	public RedirectView deleteProduct( @PathVariable("productId") int productId,HttpServletRequest request) {
		
		this.productDao.deleteProduct(productId);
		RedirectView redirectview =new RedirectView ();
		redirectview.setUrl(request.getContextPath()+"/");
		
		
		
		return redirectview;
	}
	//update handler
	@RequestMapping("update/{productId}")
	public String updateForm(@PathVariable("productId") int pid,Model model) {
		Product product=this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		return "update_form";
	}
	
	
	
}
