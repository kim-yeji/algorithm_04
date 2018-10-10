package sort;

public class Sorting {
	private int[] paramArr;
	private int count; // �ݺ�ȸ��

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
	
	
	//�ִ����� �����ϴ� �κ�
	//�ִ� ���� �� �� �ڷ� ���� �����ϰ� �ٽ� ����
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
	//���������� �� ����ȭ ��Ų��
	//�ڽ��� ������ ������ �θ��带 ���������� �ϱ� ���� n/2���� �����Ѵ�
	public void buildMaxHeap(int[] arr) {
		int size = arr.length-1;
		for(int i=size/2;i>=0;i--) {
			max_Heapify(arr, i);
		}
	}

	//�ܼ��� �Ϲ� �迭�� ������ �����ϴ� ������ �Ѵ�
	//�� �������� �ڽ� ���κ��� �θ� ��带 ���Ѵ�.
	//�ڵ�� �ٽ� �ִ� ���� �����Ҷ����� �θ� ���� �ڽ� ��带 �����ϸ鼭 ��������� ����
	
	public void max_Heapify(int[] arr, int i) {
		int size = arr.length-1;
		int leftChild = (i*2)+1;
		int rightChild = (i*2)+2;
		int max=0;
		
		
		//���ؼ� �� ū Child�� max�� �Ҵ��Ѵ�.
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
		System.out.println("�ݺ�ȸ��: " + count);
	}
	
	
}
