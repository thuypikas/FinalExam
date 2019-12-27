package poly.controller;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.BacSi;
import poly.entity.BenhNhan;
import poly.entity.KhamBenh;

@Controller
@RequestMapping("khambenh")
@Transactional
public class KhamBenhController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("all")
	public String getAll(ModelMap model) {
		Session session = factory.getCurrentSession();
		ArrayList<KhamBenh> khamBenhs = (ArrayList<KhamBenh>) session.createQuery("from KhamBenh").list();
		model.addAttribute("khamBenhs", khamBenhs);
		return "danhsach";
	}

	@RequestMapping("detail")
	public String getOne(ModelMap model, @RequestParam("makb") int makb) {
		Session session = factory.getCurrentSession();
		KhamBenh khambenh = (KhamBenh) session.get(KhamBenh.class, makb); // Truy vấn theo Id đơn giản nhất
		model.addAttribute("khambenh", khambenh);
		return "chitiet";
	}

	@RequestMapping(method = RequestMethod.GET, value = "create")
	public String showCreate(ModelMap model) {
		Session session = factory.getCurrentSession();
		ArrayList<BenhNhan> benhNhans = (ArrayList<BenhNhan>) session.createQuery("From BenhNhan").list();
		ArrayList<BacSi> bacSis = (ArrayList<BacSi>) session.createQuery("From BacSi").list();

		model.addAttribute("khambenh", new KhamBenh()); // Gán 1 đối tượng KhamBenh rỗng cho view
		model.addAttribute("benhNhans", benhNhans); // Gán danh sách benhNhans cho view
		model.addAttribute("bacSis", bacSis); // Gán danh sách bacSis cho view

		return "formCreate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "create")
	public String createKhamBenh(ModelMap model, KhamBenh khamBenh) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<KhamBenh> khamBenhs = new ArrayList<>();
		try {
			session.save(khamBenh);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

		/*
		 * Lấy lại danh sách book sau khi thêm/sửa/xóa dùng session tạo ra ở trên ko lấy
		 * đc tên danh mục của thằng mới tạo (chưa rõ vì sao) -> đến đây chuyển sang sử
		 * dụng session mặc địch thì được
		 */
		session = factory.getCurrentSession();
		khamBenhs = (ArrayList<KhamBenh>) session.createQuery("from KhamBenh").list();
		model.addAttribute("khamBenhs", khamBenhs);

		return "danhsach";
	}

	@RequestMapping(method = RequestMethod.GET, value = "update")
	public String showUpdate(ModelMap model, @RequestParam("makb") int makb) {
		Session session = factory.getCurrentSession();
		KhamBenh khamBenh = (KhamBenh) session.get(KhamBenh.class, makb);
		ArrayList<BenhNhan> benhNhans = (ArrayList<BenhNhan>) session.createQuery("From BenhNhan").list();
		ArrayList<BacSi> bacSis = (ArrayList<BacSi>) session.createQuery("From BacSi").list();

		model.addAttribute("khambenh", khamBenh); // Gán 1 đối tượng KhamBenh rỗng cho view
		model.addAttribute("benhNhans", benhNhans); // Gán danh sách benhNhans cho view
		model.addAttribute("bacSis", bacSis); // Gán danh sách bacSis cho view
		
		return "formUpdate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "update")
	public String updateBook(ModelMap model, KhamBenh khamBenh) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<KhamBenh> khamBenhs = new ArrayList<>();
		try {
			session.update(khamBenh);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

		session = factory.getCurrentSession();
		khamBenhs = (ArrayList<KhamBenh>) session.createQuery("from KhamBenh").list();
		model.addAttribute("khamBenhs", khamBenhs);
		return "danhsach";
	}

	@RequestMapping("delete")
	public String deleteKhamBenh(ModelMap model, KhamBenh khamBenh) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<KhamBenh> khamBenhs = new ArrayList<>();
		try {
			session.delete(khamBenh);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

		session = factory.getCurrentSession();
		khamBenhs = (ArrayList<KhamBenh>) session.createCriteria(KhamBenh.class).list();
		model.addAttribute("khamBenhs", khamBenhs);
		return "danhsach";
	}

	@RequestMapping("search")
	public String searchKhamBenh(ModelMap model, @RequestParam("tenbn") String tenbn) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from KhamBenh where benhNhan.tenbn like :tenbn");
		query.setParameter("tenbn", "%" + tenbn + "%");
		ArrayList<KhamBenh> khamBenhs = (ArrayList<KhamBenh>) query.list();
		model.addAttribute("khamBenhs", khamBenhs);
		return "danhsach";
	}
}
