package cn.net.tongfang.framework.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DemoControl {

	private String id;
	private String textarea;
	private String radio;
	private String checkbox;
	private String select;
	private Timestamp date;

	private static List<DemoControl> controls;
	static {

		Timestamp date1 = new Timestamp( new Date().getTime());
		Timestamp date2 = new Timestamp( new Date().getTime() + 1000 * 60 * 60 * 24);

		controls = new ArrayList<DemoControl>();
		controls.add(new DemoControl(random(), "textarea", "r1", "checkbox1",
				"c_sys_admin", date1));
		controls.add(new DemoControl(random(), "中文区域", "r2", "checkbox1",
				"ff8081812a3b6573012a3b668c430001", date2));
	}

	private static String random() {
		return UUID.randomUUID().toString();
	}

	public static List<DemoControl> get() {
		return controls;
	}

	public static void save(DemoControl control) {
		if (controls.contains(control)) {
			controls.set(controls.indexOf(control), control);
		} else {
			control.setId(random());
			controls.add(control);
		}
	}

	public DemoControl(String id, String textarea, String radio,
			String checkbox, String select, Timestamp date) {
		this.id = id;
		this.textarea = textarea;
		this.radio = radio;
		this.checkbox = checkbox;
		this.select = select;
		this.date = date;
	}

	public DemoControl() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoControl other = (DemoControl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemoControl [id=" + id + ", textarea=" + textarea + ", radio="
				+ radio + ", checkbox=" + checkbox + ", select=" + select
				+ ", date=" + date + "]";
	}

}
