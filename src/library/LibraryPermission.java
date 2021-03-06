package library;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

@SuppressWarnings("all")
public class LibraryPermission {
	public static boolean isLogin(HttpServletRequest request,HttpServletResponse response){
		boolean check = true;
		HttpSession session = request.getSession();
		User objUser = (User)session.getAttribute("objUser");
		if(objUser == null){
			try {
				response.sendRedirect(request.getContextPath()+"/admin/dang-nhap");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			check = false;
		}
		return check;
	}	
}
