package sort;

public class Sorting {
	private int[] paramArr;
	private int[] resultArr;
	private int count; // �ݺ�ȸ��

	public Sorting(Integer[] list) {
		resultArr = new int[list.length];
		paramArr = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			paramArr[i] = list[i].intValue();
		}
	}

	public void sorting(String sort) {
		if ("maxHeap".equals(sort)) {
			maxHeapSort(paramArr);
		} else if ("minHeap".equals(sort)) {
			minHeapSort(paramArr);
		} else if ("counting".equals(sort)) {
			countingSort(paramArr);
		}
	}
	
	//�迭�� �ִ��� �����ϴ� �Լ�
		private int getMax(int[] arr) {

			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= max) {
					max = arr[i];
				}
			}
			return max;
		}

		

	private void countingSort(int[] arr) {

		int max = getMax(arr);

		int[] countArr = new int[max + 1]; // 0 ~ max

		// �迭�� �ִ� ���ڵ��� ������ ��� countArr�� ����
		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i]]++;
		}

		// countArr�� ���� ���� ���� ���� ���ϴ� ����(����)
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
	// countArr[arr[i]]�� ���ڰ� �� n��° �ڸ��̹Ƿ� ���� �迭������ - 1�� �� Index��
			resultArr[--countArr[arr[i]]] = arr[i]; 
			count++;
		}

	}
	
	// �ִ����� �����ϴ� �κ�
	// �ִ� ���� �� �� �ڷ� ���� �����ϰ� �ٽ� ����
	public void maxHeapSort(int[] arr) {
		int size = arr.length - 1;
		buildMaxHeap(arr);
		for (int i = size; i > 0; i--) {
			swap(arr, 0, i);
			size -= 1;
			count++;
			max_Heapify(arr, 0, size);
		}
	}

	// ���������� �� ����ȭ ��Ų��
	// �ڽ��� ������ ������ �θ��带 ���������� �ϱ� ���� n/2���� �����Ѵ�
	public void buildMaxHeap(int[] arr) {
		int size = arr.length - 1;
		for (int i = size / 2; i >= 0; i--) {
			max_Heapify(arr, i, size);
		}
	}

	// �ܼ��� �Ϲ� �迭�� ������ �����ϴ� ������ �Ѵ�
	// �� �������� �ڽ� ���κ��� �θ� ��带 ���Ѵ�.
	// �ڵ�� �ٽ� �ִ� ���� �����Ҷ����� �θ� ���� �ڽ� ��带 �����ϸ鼭 ��������� ����
	public void max_Heapify(int[] arr, int i, int len) {
		int size = len;
		int leftChild = (i * 2) + 1;
		int rightChild = (i * 2) + 2;
		int max = 0;

		// ���ؼ� �� ū Child�� max�� �Ҵ��Ѵ�.
		if (leftChild <= size && arr[leftChild] > arr[i]) {
			max = leftChild;
		} else {
			max = i;
		}

		if (rightChild <= size && arr[rightChild] > arr[max]) {
			max = rightChild;
		}
		if (max != i) {
			swap(arr, i, max);
			max_Heapify(arr, max, len);
		}
	}

	private void minHeapSort(int[] arr) {
		int size = arr.length - 1;
		buildMinHeap(arr);
		for (int i = size; i > 0; i--) {
			swap(arr, 0, i);
			size -= 1;
			count++;
			min_Heapify(arr, 0, size);
		}
	}

	public void buildMinHeap(int[] arr) {
		int size = arr.length - 1;
		for (int i = size / 2; i >= 0; i--) {
			min_Heapify(arr, i, size);
		}
	}

	public void min_Heapify(int[] arr, int i, int len) {
		int size = len;
		int leftChild = (i * 2) + 1;
		int rightChild = (i * 2) + 2;
		int min = 0;

		// ���ؼ� �� ���� Child�� min�� �Ҵ��Ѵ�.
		if (leftChild <= size && arr[leftChild] < arr[i]) {
			min = leftChild;
		} else {
			min = i;
		}

		if (rightChild <= size && arr[rightChild] < arr[min]) {
			min = rightChild;
		}
		if (min != i) {
			swap(arr, i, min);
			min_Heapify(arr, min, len);
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
	
	public void countingPrint() {
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println((i + 1) + ":" + resultArr[i]);
		}
	}

	public void printCount() {
		System.out.println("�ݺ�ȸ��: " + count);
	}

}
