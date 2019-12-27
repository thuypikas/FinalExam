package poly.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.BacSi;
import poly.entity.KhamBenh;

@Controller
@Transactional
public class DangNhapController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(method = RequestMethod.GET, value = "/dangnhap")
	public String traVeFormDangNhap() {
		return "dangnhap";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dangxuat")
	public String dangXuat() {
		return "dangnhap";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dangnhap")
	public ModelAndView kiemTraDangNhap(HttpServletRequest request, HttpServletResponse response) {
		String tendangnhap = request.getParameter("tendangnhap");
		String matkhau = request.getParameter("matkhau");
		String message;

		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from BacSi where tendangnhap like :tendangnhap  and matkhau like :matkhau");
		query.setParameter("tendangnhap", tendangnhap);
		query.setParameter("matkhau", matkhau);

		ArrayList<BacSi> khamBenhs = (ArrayList<BacSi>) query.list();
		if (khamBenhs.size() == 1) {
			message = "Welcome " + tendangnhap + ".";
			return new ModelAndView("trangchu", "message", message);
		}
		message = "Wrong username or password.";
		return new ModelAndView("dangnhapthatbai", "message", message);
	}
}
