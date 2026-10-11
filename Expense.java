import java.time.LocalDate;
public class Expense {
    private int expenseId;
    private String description;
    private double amount;
    private Category category;
    private LocalDate date;

    public Expense(int expenseId, String description, double amount, Category category, LocalDate date){
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    
    public int getexpenseId(){
        return expenseId;
    }
    public String getdescription(){
        return description;
    }
    public double getamount(){
        return amount;
    }
    public Category getcategory(){
        return category;
    }
    public LocalDate getdate(){
        return date;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
}
