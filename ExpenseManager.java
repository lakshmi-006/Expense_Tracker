import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.YearMonth;
public class ExpenseManager {
    private ArrayList<Expense> expenses;
    
    public ExpenseManager(){
        expenses = new ArrayList<>();
    }

    private boolean isIdExists(int id){
        for(Expense e:expenses){
            if(e.getexpenseId()==id){
                return true;
            }
        }
        return false;
    }

    public boolean addExpense(Expense expense){
        if(expense.getamount()<0){
            return false;
        }
        if(isIdExists(expense.getexpenseId())){
            return false;
        }
        if(expense.getdescription()==null||expense.getdescription().trim().isEmpty()){
            return false;
        }
        expenses.add(expense);
        return true;
    }

    public void viewallExpense(){
        if(expenses.isEmpty()){
            System.out.println("No Expenses Found");
            return;
        }
        for(Expense e:expenses){
            System.out.println(e.getexpenseId()+" | "+
                               e.getdescription()+" | "+
                               e.getamount()+" | "+
                               e.getcategory()+" | "+
                               e.getdate());
        }
    }

    public Expense searchExpense(int id){
        for(Expense e:expenses){
            if(e.getexpenseId() == id){
                return e;
            }
        }
        return null;
    }

    public void filterbyCategory(Category category){
        boolean f = false;
        for(Expense e : expenses){
            if(e.getcategory()==category){
                System.out.println(e.getexpenseId()+" | "+
                                   e.getdescription()+" | "+
                                   e.getamount()+" | "+
                                   e.getcategory()+" | "+
                                   e.getdate());
                f = true;
            }
        }
        if(!f){
            System.out.println("No expenses found for this category.");
        }
    }

    public double totalExpense(){
        double t = 0;
        for(Expense e:expenses){
            t = t+e.getamount();
        }
        return t;
    }

    public void filterbyDate(LocalDate date){
        boolean d = false;
        for(Expense e:expenses){
            if(e.getdate().equals(date)){
                System.out.println(e.getexpenseId()+" | "+
                                   e.getdescription()+" | "+
                                   e.getamount()+" | "+
                                   e.getcategory()+" | "+
                                   e.getdate());
                d = true;
            }
        }
        if(!d){
            System.out.println("No Expenses Found For This Date.");
        }
    }

    public void sortbyAmount(){
        expenses.sort(Comparator.comparingDouble(Expense::getamount));
    }

    public void sortByAmountDescending() {
        expenses.sort(Comparator.comparingDouble(Expense::getamount).reversed());
    }

    public boolean deleteExpense(int id){
        Expense e = searchExpense(id);
        if(e!=null){
            expenses.remove(e);
            return true;
        }
        return false;
    }

    public boolean updateExpense(int id,String description, double amount, Category category, LocalDate date){
        Expense e = searchExpense(id);
        if(e!=null){
            e.setDescription(description);
            e.setAmount(amount);
            e.setCategory(category);
            e.setDate(date);
            return true;
        }
        return false;
    }

    public ArrayList<Expense> getExpenses(){
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> loadedExpenses){
        expenses = loadedExpenses;
    }

    public double calculateMonthlyExpense(YearMonth month){
        double total = 0;
        for(Expense expense:expenses){
            YearMonth m = YearMonth.from(expense.getdate());

            if(m.equals(month)){
                total += expense.getamount();
            }
        }
        return total;
    }
    public double calculateTotal(){
        double total = 0;
        for(Expense expense : expenses){
            total+=expense.getamount();
        }
        return total;
    }
}