package MoneyWeb.entity;

import java.sql.Timestamp;

public class MoneyWebValueObject {
	
	String userid;
	Timestamp date;
	String title;
	String task;
	Integer firstmoney;
	Integer inputmoney;
	Integer outputmoney;
	Integer lastmoney;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Timestamp getDate(){
		return date;
	}
	public void setDate(Timestamp date){
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public Integer getFirstMoney(){
		return firstmoney;
	}
	public void setFirstMoney(Integer firstmoney){
		this.firstmoney = firstmoney;
	}
	
	public Integer getInputMoney(){
		return inputmoney;
	}
	public void setInputMoney(Integer inputmoney){
		this.inputmoney = inputmoney;
	}
	
	public Integer getOutputMoney(){
		return outputmoney;
	}
	public void setOutputMoney(Integer outputmoney){
		this.outputmoney = outputmoney;
	}
	
	public Integer getLastMoney(){
		return lastmoney;
	}
	public void setLastMoney(Integer lastmoney){
		this.lastmoney = lastmoney;
	}
}

