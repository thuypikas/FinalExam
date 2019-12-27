package poly.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khambenh")
public class KhamBenh implements Serializable{
	
	@Id
	private int makb;
	
	private String yeucaukham;
	
	private Date ngaykham;
	
	private String ketluan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mabn")
	private BenhNhan benhNhan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mabs")
	private BacSi bacSi;

	public int getMakb() {
		return makb;
	}

	public void setMakb(int makb) {
		this.makb = makb;
	}

	public String getYeucaukham() {
		return yeucaukham;
	}

	public void setYeucaukham(String yeucaukham) {
		this.yeucaukham = yeucaukham;
	}

	public Date getNgaykham() {
		return ngaykham;
	}

	public void setNgaykham(Date ngaykham) {
		this.ngaykham = ngaykham;
	}

	public String getKetluan() {
		return ketluan;
	}

	public void setKetluan(String ketluan) {
		this.ketluan = ketluan;
	}

	public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	public BacSi getBacSi() {
		return bacSi;
	}

	public void setBacSi(BacSi bacSi) {
		this.bacSi = bacSi;
	}

	public KhamBenh(int makb, String yeucaukham, Date ngaykham, String ketluan, BenhNhan benhNhan, BacSi bacSi) {
		super();
		this.makb = makb;
		this.yeucaukham = yeucaukham;
		this.ngaykham = ngaykham;
		this.ketluan = ketluan;
		this.benhNhan = benhNhan;
		this.bacSi = bacSi;
	}

	public KhamBenh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
