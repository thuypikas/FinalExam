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
@Table(name = "bacsi")
public class BacSi implements Serializable{
	@Id
	private String mabs;
	
	private String tenbs;
	
	private String tendangnhap;
	
	private String matkhau;
	
	private String chuyenmon;
	
	private String dienthoai;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bacSi")
	private List<KhamBenh> khamBenhs = new ArrayList<>();

	public BacSi(String mabs, String tenbs, String tendangnhap, String matkhau, String chuyenmon, String dienthoai,
			List<KhamBenh> khamBenhs) {
		super();
		this.mabs = mabs;
		this.tenbs = tenbs;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.chuyenmon = chuyenmon;
		this.dienthoai = dienthoai;
		this.khamBenhs = khamBenhs;
	}

	public BacSi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMabs() {
		return mabs;
	}

	public void setMabs(String mabs) {
		this.mabs = mabs;
	}

	public String getTenbs() {
		return tenbs;
	}

	public void setTenbs(String tenbs) {
		this.tenbs = tenbs;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getChuyenmon() {
		return chuyenmon;
	}

	public void setChuyenmon(String chuyenmon) {
		this.chuyenmon = chuyenmon;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public List<KhamBenh> getKhamBenhs() {
		return khamBenhs;
	}

	public void setKhamBenhs(List<KhamBenh> khamBenhs) {
		this.khamBenhs = khamBenhs;
	}
	
	
}
