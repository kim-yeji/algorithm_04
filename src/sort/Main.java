package sort;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Integer[] list= null;
		String cnt="";
		Sorting sort=null;
		try {
			cnt = "100";
			System.out.println("============== maxHeap " + cnt + "개 테스트 ===============");
			list=FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("maxHeap");
			sort.printCount();
//			sort.sortingPrint();
			System.out.println("============== minHeap " + cnt + "개 테스트 ===============");
			sort = new Sorting(list);
			sort.sorting("minHeap");
			sort.printCount();
//			sort.sortingPrint();
			System.out.println("============== counting " + cnt + "개 테스트 ===============");
			sort = new Sorting(list);
			sort.sorting("counting");
			sort.printCount();
//			sort.countingPrint();
			
			cnt = "1000";
			System.out.println("============== maxHeap " + cnt + "개 테스트 ===============");
			list=FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("maxHeap");
			sort.printCount();
//			sort.sortingPrint();
			System.out.println("============== minHeap " + cnt + "개 테스트 ===============");
			sort = new Sorting(list);
			sort.sorting("minHeap");
			sort.printCount();
//			sort.sortingPrint();
			System.out.println("============== counting " + cnt + "개 테스트 ===============");
			sort = new Sorting(list);
			sort.sorting("counting");
			sort.printCount();
//			sort.countingPrint();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
