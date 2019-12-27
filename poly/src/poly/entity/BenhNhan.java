package poly.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "benhnhan")
public class BenhNhan implements Serializable {
	@Id
	private String mabn;
	
	private String tenbn;
	
	private Date ngaysinh;
	
	private String diachi;
	
	private String dienthoai;
	
	private boolean gioitinh;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "benhNhan")
	private List<KhamBenh> khamBenhs = new ArrayList<>();

	public BenhNhan(String mabn, String tenbn, Date ngaysinh, String diachi, String dienthoai, boolean gioitinh,
			List<KhamBenh> khamBenhs) {
		super();
		this.mabn = mabn;
		this.tenbn = tenbn;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.dienthoai = dienthoai;
		this.gioitinh = gioitinh;
		this.khamBenhs = khamBenhs;
	}

	public BenhNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMabn() {
		return mabn;
	}

	public void setMabn(String mabn) {
		this.mabn = mabn;
	}

	public String getTenbn() {
		return tenbn;
	}

	public void setTenbn(String tenbn) {
		this.tenbn = tenbn;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGiotinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public List<KhamBenh> getKhamBenhs() {
		return khamBenhs;
	}

	public void setKhamBenhs(List<KhamBenh> khamBenhs) {
		this.khamBenhs = khamBenhs;
	}
	
	
	
}
