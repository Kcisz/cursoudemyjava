package cursoudemyjava.resources.exception;

import java.io.Serializable;

public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer status;
	private String msg;
	private long timeStamp;
	
	
	
	public StandartError(Integer status, String msg, long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public StandartError() {
		// TODO Auto-generated constructor stub
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}



}
