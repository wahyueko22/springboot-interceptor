
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    private String brand = null;
    private int doors = 0;

    public String getBrand() { return this.brand; }
    public void   setBrand(String brand){ this.brand = brand;}

    public int  getDoors() { return this.doors; }
    public void setDoors (int doors) { this.doors = doors; }
}

public class MainRest {
	public static <T> Object stringToObject(String strJson, Class<T> cls) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return objectMapper.readValue(strJson, cls);
	}
	public static void main (String[] args) {
		String carJson =
			    "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
		Car car = new Car();
		try {
			car = (Car) MainRest.stringToObject(carJson, Car.class);
			System.out.println(car.getClass() + car.getBrand());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

