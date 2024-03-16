package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import Model.Product;
@WebServlet("/addProduct")
public class ProductController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("productName");
		 double price =  Double.parseDouble(req.getParameter("productPrice"));
		 String category = req.getParameter("productCat");
		 int pQty = Integer.parseInt(req.getParameter("productQty"));
		 
		 Product p =new Product();
		 p.setProductName(name);
		 p.setProductPrice(price);
		p.setProductCategory(category);
		 p.setProductQty(pQty);
		 
		Session session = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();  
		  session.save(p);
		  tx.commit();
		  session.close();
		 

}
}