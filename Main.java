import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager em = new ExpenseManager();
        FileManager fm = new FileManager();
        em.setExpenses(fm.loadExpenses());
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("=======EXPENSE TRACKER=======");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search Expense by ID");
            System.out.println("4. Filter By Category");
            System.out.println("5. Filter By Date");
            System.out.println("6. Update Expense");
            System.out.println("7. Delete Expense");
            System.out.println("8. Sort by Amount");
            System.out.println("9. Calculate Total Expense");
            System.out.println("10. Monthly Expense Report");
            System.err.println("0. Exit");
            System.out.println("Enter you choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Expense ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.println("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Select Category: ");
                    for(Category c : Category.values()){
                        System.out.println(c);
                    }

                    System.out.println("Enter Category: ");
                    Category category = Category.valueOf(sc.nextLine().trim().toUpperCase());

                    System.out.print("Enter Date(YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine().trim());

                    Expense expense = new Expense(id, description, amount, category, date);
                    if(em.addExpense(expense)){
                        System.out.println("Expenses added successfully.");
                    }else{
                        System.out.println("Invalid expense or duplicate ID.");
                    }
                    break;

                case 2:
                    em.viewallExpense();
                    break;
                 
                case 3:
                    System.out.println("Enter Expense ID to search: ");
                    int search = sc.nextInt();
                    Expense fe = em.searchExpense(search);
                    if(fe!=null){
                        System.out.println("Expense found:");
                        System.out.println(fe.getexpenseId()+" | "+
                                           fe.getdescription()+" | "+
                                            fe.getamount()+" | "+
                                            fe.getcategory()+" | "+
                                            fe.getdate());
                    }else{
                        System.out.println("Expense not found");
                    }
                    break;

                case 4:
                    System.out.println("Select Category:");
                    for(Category c:Category.values()){
                        System.out.println(c);
                    }
                    System.out.println("Enter Category: ");
                    Category s = Category.valueOf(sc.nextLine().trim().toUpperCase());
                    em.filterbyCategory(s);
                    break;

                case 5:
                    System.out.println("Enter date (YYYY-MM-DD): ");
                    LocalDate d = LocalDate.parse(sc.nextLine().trim());
                    em.filterbyDate(d);
                    break;

                case 6:
                    System.out.println("Enter Expense ID to update: ");
                    int updated = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter description: ");
                    String newdes = sc.nextLine();

                    System.out.println("Enter new Amount: ");
                    double newamt = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Select new category: ");
                    for(Category c:Category.values()){
                        System.out.println(c);
                    }
                    System.out.println("Enter category: ");
                    Category newcat = Category.valueOf(sc.nextLine().trim().toUpperCase());

                    System.out.println("Enter date(YYYY-MM-DD): ");
                    LocalDate newdate = LocalDate.parse(sc.nextLine().trim());

                    if(em.updateExpense(updated, newdes, newamt, newcat, newdate)){
                        System.out.println("Updated Successfully");
                    }else{
                        System.out.println("Expense id not found");
                    }
                    break;

                case 7:
                    System.out.println("Enter expense id to delete: ");
                    int delete = sc.nextInt();
                    sc.nextLine();

                    if(em.deleteExpense(delete)){
                        System.out.println("Expense deleted successfully");
                    }else{
                        System.out.println("Expense id not found");
                    }
                    break;
                
                case 8:
                    em.sortbyAmount();
                    System.out.println("Expenses sorted by amount");
                    em.viewallExpense();
                    break;

                case 9:
                    double total = em.calculateTotal();
                    System.out.println("Total Expense of the month: "+total);
                    break;
                
                case 10:
                    System.out.println("Enter year: ");
                    int year = sc.nextInt();

                    System.out.println("Enter month: ");
                    int month = sc.nextInt();
                    sc.nextLine();

                    YearMonth sm = YearMonth.of(year,month);
                    double monthly = em.calculateMonthlyExpense(sm);
                    System.out.println("Monthly Expense Report: "+sm);
                    System.out.println("Total Expense: Rs."+monthly);
                    break;

                case 0:
                    fm.saveExpense(em.getExpenses());
                    System.out.println("Exiting Expense Tracker. GoodBye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(choice!=0);
    }    
}