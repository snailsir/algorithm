package algorithm;

import java.util.Arrays;

public class BubbleSort {

	/**
	* 排序算法
	*/
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	/**
	* 随机生成数组
	*/
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	/**
	* 复制数组
	*/
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/**
	* 判断两个数组是否相等
	*/
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	* 单元测试
	*/
	public static boolean unitTest(){
		// 测试次数
		int testTime = 500000;
		// 数组长度
		int maxSize = 100;
		// 数组最大值
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			// 生成随机数组
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			// 复制数组
			int[] arr2 = copyArray(arr1);
			// 冒泡排序
			bubbleSort(arr1);
			// 自带数组排序方法
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				// bubbleSort校验失败
				return false;
			}
		}
		// 校验成功
		return true;
	}


	public static void main(String[] args) {
		// 单元测试
		unitTest();
	}

}
