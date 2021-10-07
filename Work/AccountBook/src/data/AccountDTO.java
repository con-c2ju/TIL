package data;

public class AccountDTO {
	
	String cal;	// 날짜
	String money;		// 금액
	String category;	// 수입/지출 여부
	String title;		// 제목
	String content;		// 내용
	
	public AccountDTO(String cal, String money, String category, String title, String content) {
		this.cal = cal;
		this.money = money;
		this.category = category;
		this.title = title;
		this.content = content;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "[" + cal + "] <" + category + "> 금액: " + money + "원, 제목: " + title
				+ ", 내용: " + content;
	}

}
