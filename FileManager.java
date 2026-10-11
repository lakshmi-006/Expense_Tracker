import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
public class FileManager {
    public void saveExpense(ArrayList<Expense> expenses){
        try{
            FileWriter writer = new FileWriter("expenses.txt");
            for(Expense e : expenses){
                writer.write(e.getexpenseId()+ "|"+e.getdescription()+"|"+e.getamount()+"|"+e.getcategory()+"|"+e.getdate()+"\n");
            }
            writer.close();
            System.out.println("Expenses saved successfully.");
        }catch(IOException ex){
            System.out.println("Error while saving expenses.");
        }
    }

    public ArrayList<Expense> loadExpenses(){
        ArrayList<Expense> loadExpenses = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("expenses.txt"));
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0].trim());
                String description = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                Category category = Category.valueOf(parts[3].trim());
                LocalDate date = LocalDate.parse(parts[4].trim());

                Expense expense = new Expense(id, description, amount, category, date);
                loadExpenses.add(expense);
            }
            reader.close();
        }catch(IOException e){
            System.out.println("Error while loading expenses.");
        }
        return loadExpenses;
    }
}
