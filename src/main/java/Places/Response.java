package Places;

import java.util.Arrays;
import java.util.List;

public class Response{
	private int total;
	private List<ItemsItem> items;
	private Error error;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "total=" + total +
				", \nitems=" +  items.toArray().toString() +
				'}';
	}

}