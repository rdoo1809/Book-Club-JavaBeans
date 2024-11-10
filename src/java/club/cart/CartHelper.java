/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lp_jo
 */
public class CartHelper {
    public static ECart getCart(HttpSession session) {
        final String cartName = "cart";
        ECart cart = (ECart)session.getAttribute(cartName);
        
        if (cart == null) {
            cart = new ECart();
            session.setAttribute(cartName, cart);
        }
        
        return cart;
    }
    
    public static ArrayList<Book> getLoanItems(ServletContext context) {
        return (ArrayList<Book>)context.getAttribute("loanitems");
    }
}
