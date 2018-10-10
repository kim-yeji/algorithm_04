package sort;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Integer[] list= null;
		String cnt="";
		Sorting sort=null;
		try {
			cnt = "20";
			System.out.println("============== maxHeap " + cnt + "개 테스트 ===============");
			list=FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("maxHeap");
			sort.printCount();
			sort.sortingPrint();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
