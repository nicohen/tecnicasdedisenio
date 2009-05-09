import java.util.Date;


public class Auction {
	protected Date startDate;
	protected Date endDate;
	protected String status;
	protected int currentPoints;
	protected Bid lastBid;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCurrentPoints() {
		return currentPoints;
	}
	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}
	public Bid getLastBid() {
		return lastBid;
	}
	public void setLastBid(Bid lastBid) {
		this.lastBid = lastBid;
	}
}
