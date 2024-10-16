/*
You are tasked with building a Person Management System that processes a list 
of Person objects using Java Streams. Each Person object contains the following 
attributes:
	Name: (String) The name of the person
	Age: (int) The age of the person
	Location: (String) The location where the person lives

Your goal is to sort by age, filter who atre above 20, and group by location 
using Java Stream operation.


Sample Input:
-------------
4                   //number of persons
Alice,23,New York   //name, age, location of a person
Bob,34,Los Angeles
Charlie,18,New York
David,29,Los Angeles

Sample Output:
-------------
New York => 
Person{name='Alice', age=23, location='New York'}
Los Angeles => 
Person{name='David', age=29, location='Los Angeles'}
Person{name='Bob', age=34, location='Los Angeles'}

*/
import java.util.*;
import java.util.stream.Collectors;
class Person{
    public String name;
    public int age;
    public String location;
    public Person(String name,int age,String location){
        this.name=name;
        this.age=age;
        this.location=location;
    }
    public String toString(){
        return "Person{name='" + name + "', age=" + age + ", location='" + location + "'}";
    }
}
class Program{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<Person>people=new ArrayList<>();
        for(int i=0;i<n;i++){
            String data[]=sc.nextLine().split(",");
            String name=data[0];
            int age=Integer.parseInt(data[1]);
            String location=data[2];
            people.add(new Person(name,age,location));
        }
        Map<String,List<Person>>LocationFilter=people.stream().filter(p->p.age>20).sorted(Comparator.comparingInt(p->p.age)).collect(Collectors.groupingBy(p->p.location));
        LocationFilter.forEach((location,PList)->{
            System.out.println(location +"=> ");
            PList.forEach(System.out::println);
        });
    
    }
}
