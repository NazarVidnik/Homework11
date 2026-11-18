package Part1;

public class Geek {
    String name;
    int numQuestions;
    public Geek(String name, int numQuestions){
        this.name = name;
        this.numQuestions = numQuestions;
    }

    public String getName(){
        return name;
    }
    public int getNumberOfQuestions(){
        return numQuestions;
    }
    public boolean isEven(int num1, int num2){
        numQuestions++;
        if ((num1+num2)%2==0){
            return true;
        } else return false;
    }
    public int sum(int num1, int num2) {
        numQuestions++;
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        int count = max - min + 1;
        int total = (min + max) * count / 2;//formula for the sum of an arithmetic progression

        return(total);
    }
    public boolean leapYear(int year){
        numQuestions++;
        if(year%4==0){
            if (year%100==0 && year%400!=0){
                return false;
            }else return true;
        }else return false;
    }

}
