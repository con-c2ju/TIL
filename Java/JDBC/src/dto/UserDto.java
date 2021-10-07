package dto;

public class UserDto {
	
	private String id;
	private String name;
	private int age;
	private String joindate;	// DATE를 DB에서 불러와 편집할때는 String을 자주 씀
	
	public UserDto() {
	}

	public UserDto(String id, String name, int age, String joindate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.joindate = joindate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", age=" + age + ", joindate=" + joindate + "]";
	}

}
