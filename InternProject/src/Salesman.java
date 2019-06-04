
public class Salesman {
	private String name;
	private int totalSales;
	private int salesPeriod;
	private float experienceMultiplier;
	private float score;
	
	public Salesman() {
		
	}

	public Salesman(String n, int totalS, int sPeriod, float expM) {
		this.name = n;
		this.totalSales = totalS;
		this.salesPeriod = sPeriod;
		this.experienceMultiplier = expM;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public int getSalesPeriod() {
		return salesPeriod;
	}

	public void setSalesPeriod(int salesPeriod) {
		this.salesPeriod = salesPeriod;
	}

	public float getExperienceMultiplier() {
		return experienceMultiplier;
	}

	public void setExperienceMultiplier(float experienceMultiplier) {
		this.experienceMultiplier = experienceMultiplier;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
}
