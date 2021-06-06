package Places;

public class ItemsItem{
	private Country country;
	private String code;
	private String name;
	private int id;

	public void setCountry(Country country){
		this.country = country;
	}

	public Country getCountry(){
		return country;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
	public String toString() {
		return "country=" + country +
				", \ncode='" + code +
				", \nname='" + name +
				", \nid=" + id +
				'}';
	}
}
