public class Square{ //data class
    private String category;
    private int number;

    public Square(String category, int number){
        this.category = category;
        this.number = number;
    }

    public String getCategory(){
        return category;
    }

    public int getNumber(){
        return number;
    }

    public void setCategory(String newCategory){
        category = newCategory;
    }

    public void setNumber(int newNumber){
        number = newNumber;
    }
}