package com.practice1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice1.entities.CartItem;
import com.practice1.entities.Role;
import com.practice1.entities.SanPham;
import com.practice1.entities.User;
import com.practice1.entities.ShoppingCart;
import com.practice1.repository.RoleRepository;
import com.practice1.repository.SanPhamRepository;
import com.practice1.repository.UserRepository;
import com.practice1.service.CartItemService;
import com.practice1.service.SanPhamService;
import com.practice1.service.ShoppingCartService;
import com.practice1.service.UserService;

@Controller
public class CilentController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	SanPhamService spService;
	
	@Autowired
	UserService userService;

	@Autowired
	SanPhamRepository spRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	ShoppingCartService cartService;
	
	@Autowired
	CartItemService itemService;
	
	

	
// Get danh sach san pham(phan trang)
	@GetMapping("/index")
	public String index(Model model, Principal p, HttpSession session) {
		
		model.addAttribute("SanPhams", spRepo.findAll());
		return findPaginated(1, model);
   }

	@GetMapping("/index/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
	    int pageSize = 5;
	    Page < SanPham> page = spService.findPaginated(pageNo, pageSize);
	    List <SanPham> SanPhams = page.getContent();
	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("SanPhams", SanPhams);
	    return "user/index";
	}
	
	
	
//	@GetMapping("/index/find1")
//	public String findSanPhamById(Model model, @RequestParam(value = "keyWord") String keyWord) {
//		List<SanPham> Product = spService.findSpByText(keyWord);
//		 model.addAttribute("Product", Product);
//		return "index/resultFind";
//	}
	
	@GetMapping("/index/find1")
	public String findSanPhamById(Model model, @RequestParam(value = "keyWord") String keyWord) {
		List<SanPham> Product = spService.findSpByText(keyWord);
		 model.addAttribute("p", Product);
		return "user/resultFind";
	}
	
	@GetMapping("/resultFind1/{type}")
	public String FindType(Model model, @PathVariable(value = "type") String type) {
		List<SanPham> Product = spService.findSpByText(type);
		 model.addAttribute("type", Product);

		return "user/resultFind1";
	}

	
	
	
	@GetMapping(value = "/blog")
	public String Blog() {
		return "user/blog";
	}
	//Check san pham theo id
	@GetMapping("/shop-details/{id}")
	public String GetDetailProduct(Model model, @PathVariable(value = "id") int id) {
		SanPham sp = spService.findSpById(id);
		model.addAttribute("sp", sp);
		return "user/shop-details";
	}
	
	//Get danh sach san pham trong cart
	@GetMapping(value = "/shoping-cart")
	public String ShoppingCart(Model model, Principal principal) {
		 if(principal == null){
	            return "redirect:/login";
	        }
	        String username = principal.getName();
	        User customer = userRepo.findByUsername(username);
	        ShoppingCart shoppingCart = customer.getShoppingCart();
		    model.addAttribute("shoppingCart", shoppingCart);
		return "user/shoping-cart";
	}
	// Add san pham vao cart
	@PostMapping(value = "/addItem")
	public String AddItem(@RequestParam("id") int productId, @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,  Principal principal) {	
		if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();
		SanPham sp = spService.findSpById(productId);
		User customer = userRepo.findByUsername(username);
		ShoppingCart cart =  cartService.addItem(sp, quantity, customer);
		return "redirect:/index";
	}

	@GetMapping(value = "/blog-details")
	public String BlogDetails() {
		return "user/blog-details";
	}

	@GetMapping(value = "/checkout")
	public String Checkout() {
		return "user/checkout";
	}

	@GetMapping(value = "/contact")
	public String contact() {
		return "user/contact";
	}

	@GetMapping(value = "/shop-grid")
	public String ShopGird(Model model) {
		List<SanPham> sanPham = spRepo.findAll();
		model.addAttribute("SpShop", sanPham);
		return "user/shop-grid";
	}

	@GetMapping("/resultFind2/{type}")
	public String FindType2(Model model, @PathVariable(value = "type") String type) {
		List<SanPham> Product = spService.findSpByText(type);
		 model.addAttribute("type2", Product);

		return "user/resultFind2";
	}
	

}
