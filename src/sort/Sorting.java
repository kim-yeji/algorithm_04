package sort;

public class Sorting {
	private int[] paramArr;
	private int count; // 반복회수

	public Sorting(Integer[] list) {
		paramArr = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			paramArr[i] = list[i].intValue();
		}
	}
	
	
	public void sorting(String sort) {
		if ("maxHeap".equals(sort)) {
			maxHeapSort(paramArr);
		} else if ("minHeap".equals(sort)) {
			// minHeapSort(paramArr);
		} else if ("counting".equals(sort)) {
			// countingSort(paramArr, 0, paramArr.length - 1);
		}
	}
	
	
	//최대힙을 생성하는 부분
	//최댓값 추출 후 맨 뒤로 보내 정렬하고 다시 조정
	public void maxHeapSort(int[] arr) {
		int size = arr.length-1;
		buildMaxHeap(arr);
		for (int i = size-1; i >0; i--) {
			swap(arr, 0, i);
			size -= 1;
			count++;
			max_Heapify(arr, 0);
		}
	}
	//리프노드부터 힙 구조화 시킨다
	//자식을 가지는 마지막 부모노드를 시작점으로 하기 위해 n/2부터 시작한다
	public void buildMaxHeap(int[] arr) {
		int size = arr.length-1;
		for(int i=size/2;i>=0;i--) {
			max_Heapify(arr, i);
		}
	}

	//단순히 일반 배열을 힙으로 구성하는 역할을 한다
	//그 과정에서 자식 노드로부터 부모 노드를 비교한다.
	//코드는 다시 최대 힙을 구성할때까지 부모 노드와 자식 노드를 스왑하면서 재귀적으로 진행
	
	public void max_Heapify(int[] arr, int i) {
		int size = arr.length-1;
		int leftChild = (i*2)+1;
		int rightChild = (i*2)+2;
		int max=0;
		
		
		//비교해서 더 큰 Child를 max에 할당한다.
		if(leftChild<=size && arr[leftChild]>arr[i]) {
			max=leftChild;
		}else {
			max=i;
		}
		
		if(rightChild<=size && arr[rightChild]>arr[max]) {
			max=rightChild;
		}
		if(max!=i) {
			swap(arr,i,max);
			max_Heapify(arr, max);
		}
	
		
	}

	private void swap(int arr[], int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	public void sortingPrint() {
		for (int i = 0; i < paramArr.length; i++) {
			System.out.println((i + 1) + ":" + paramArr[i]);
		}
	}
	
	public void printCount() {
		System.out.println("반복회수: " + count);
	}
	
	
}
