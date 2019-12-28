package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://www.cnblogs.com/ysocean/p/6555373.html");
		InputStream is = url.openStream();
		InputStreamReader r = new InputStreamReader(is);
		
		BufferedReader in = new BufferedReader(r);
		String s = in.readLine();
		while (s!= null) {
			System.out.println(s);
			s = in.readLine();
			
		}
		
		in.close();
		
		TreeSet treeSet = new TreeSet();
		treeSet.add(new Emp(1, "d", 30));
		treeSet.add(new Emp(2, "b", 22));
		treeSet.add(new Emp(4, "c", 33));
		treeSet.add(new Emp(3, "a", 44));
		System.out.println(treeSet);
		NameCom com = new NameCom();
		TreeSet<Emp> treeSet1 = new TreeSet(com);
		treeSet1.add(new Emp(1, "d", 30));
		treeSet1.add(new Emp(2, "b", 22));
		treeSet1.add(new Emp(4, "c", 33));
		treeSet1.add(new Emp(3, "a", 44));
		System.out.println(treeSet1);
	}
}

class NameCom implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Emp a = (Emp)o1;
		Emp b = (Emp)o2;
		return a.age.compareTo(b.age);
	}

	
}
class Emp implements Comparable{

	int gh;
	String name;
	Integer age;
	
	public Emp(int gh, String name, int age) {
		this.gh = gh;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		Emp a = (Emp)o;
		return this.gh - a.gh;
	}

	@Override
	public String toString() {
		return "Emp [gh=" + gh + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
