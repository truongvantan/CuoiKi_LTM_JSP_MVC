package model.Bean;

public class Manufacturer {
	private int mid;
	private String mname;
	
	public Manufacturer() {
		
	}
	
	public Manufacturer(int mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "Manufacturer [mid=" + mid + ", mname=" + mname + "]";
	}
	
	
}
