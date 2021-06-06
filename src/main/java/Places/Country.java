package Places;

public class Country{
	private String code;
	private String name;

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

	@Override
	public String toString() {
		return "code='" + code +
				", \nname='" + name +
				'}';
	}
}
