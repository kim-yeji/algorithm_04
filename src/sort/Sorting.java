package sort;

public class Sorting {
	private int[] paramArr;
	private int[] resultArr;
	private int count; // 반복회수

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
	
	//배열의 최댓값을 추출하는 함수
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

		// 배열에 있는 숫자들의 개수를 세어서 countArr에 저장
		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i]]++;
		}

		// countArr의 이전 값과 현재 값을 더하는 과정(누적)
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
	// countArr[arr[i]]는 인자가 들어갈 n번째 자리이므로 실제 배열에서는 - 1을 한 Index임
			resultArr[--countArr[arr[i]]] = arr[i]; 
			count++;
		}

	}
	
	// 최대힙을 생성하는 부분
	// 최댓값 추출 후 맨 뒤로 보내 정렬하고 다시 조정
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

	// 리프노드부터 힙 구조화 시킨다
	// 자식을 가지는 마지막 부모노드를 시작점으로 하기 위해 n/2부터 시작한다
	public void buildMaxHeap(int[] arr) {
		int size = arr.length - 1;
		for (int i = size / 2; i >= 0; i--) {
			max_Heapify(arr, i, size);
		}
	}

	// 단순히 일반 배열을 힙으로 구성하는 역할을 한다
	// 그 과정에서 자식 노드로부터 부모 노드를 비교한다.
	// 코드는 다시 최대 힙을 구성할때까지 부모 노드와 자식 노드를 스왑하면서 재귀적으로 진행
	public void max_Heapify(int[] arr, int i, int len) {
		int size = len;
		int leftChild = (i * 2) + 1;
		int rightChild = (i * 2) + 2;
		int max = 0;

		// 비교해서 더 큰 Child를 max에 할당한다.
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

		// 비교해서 더 작은 Child를 min에 할당한다.
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
		System.out.println("반복회수: " + count);
	}

}
