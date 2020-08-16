# 学习笔记



## 位运算

### 位运算符

- & 按位与
- | 按位或
- ^ 按位异或
- ~取反
- <<左移
- \>>右移



## 布隆过滤器、LRU Cache

### 布隆过滤器

是一个很长的[二进制](https://baike.baidu.com/item/二进制/361457)向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。它的优点是空间效率和查询时间都比一般的算法要好的多，缺点是有一定的误识别率和删除困难。



### Cache 缓存

• 两个要素： 大小 、替换策略
• Hash Table + Double LinkedList
• O(1) 查询，O(1) 修改、更新



替换策略

• LFU - least frequently used
• LRU - least recently used



## 排序算法

1. 比较类排序：
通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
2. 非比较类排序：
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。



初级排序 - O(n^2)
1. 选择排序（Selection Sort）
每次找最小值，然后放到待排序数组的起始位置。
2. 插入排序（Insertion Sort）
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
3. 冒泡排序（Bubble Sort）
嵌套循环，每次查看相邻的元素如果逆序，则交换。



高级排序 - O(N*LogN)
• 快速排序（Quick Sort）
	数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。

• 归并排序（Merge Sort）— 分治
1. 把长度为n的输入序列分成两个长度为n/2的子序列；
2. 对这两个子序列分别采用归并排序；
3. 将两个排序好的子序列合并成一个最终的排序序列。



### 快排

```java
private static void quickSort1(int[] nums, int leftIndex, int rightIndex) {
    if (nums == null || nums.length == 0 || leftIndex >= rightIndex) {
        return;
    }
    int pivotIndex = partition(nums, leftIndex, rightIndex);
    //对基准值左边的元素进行递归排序
    quickSort1(nums, leftIndex, pivotIndex - 1);
    //对基准值右边的元素进行递归排序。
    quickSort1(nums, pivotIndex + 1, rightIndex);
}

private static int partition(int[] nums, int leftIndex, int rightIndex) {
    int pivot = nums[rightIndex];
    int pivotIndex = leftIndex;
    for (int i = leftIndex; i <= rightIndex; i++) {
        if (nums[i] < pivot) {
            swap(nums, pivotIndex, i);
            pivotIndex++;
        }
    }
    swap(nums, pivotIndex, rightIndex);
    return pivotIndex;
}

private static void swap(int[] nums, int indexA, int indexB) {
    if (indexA == indexB) {
        return;
    }
    int temp = nums[indexA];
    nums[indexA] = nums[indexB];
    nums[indexB] = temp;
}
```



### 插入排序

```java
private static int[] insertionSort(int[] nums) {
    if (nums == null || nums.length == 0) {
        return nums;
    }
    for (int i = 1; i < nums.length; i++) {
        int value = nums[i];
        int j = i - 1;
        // 查找插入的位置
        for (; j >= 0; --j) {
            if (nums[j] > value) {
                // 数据移动，不是交换数据
                nums[j + 1] = nums[j];
            } else {
                break;
            }
        }
        // 插入数据
        nums[j + 1] = value;
    }
    return nums;
}
```



### 选择排序

```java
private static int[] selectionSort(int[] nums) {
    if (nums == null || nums.length == 0) {
        return nums;
    }
    for (int i = 0; i < nums.length - 1; i++) {
        int minIndex = minIndex(nums, i);
        if (i != minIndex) {
            // 交换数据
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
    return nums;
}

/**
 * 获取最小值
 */
private static int minIndex(int[] nums, int startIndex) {
    int min = startIndex;
    for (int i = startIndex; i < nums.length; i++) {
        if (nums[startIndex] > nums[i]) {
            min = i;
        }
    }
    return min;
}
```



### 冒泡排序

```java
private static int[] bubbleSort(int[] nums) {
    if (nums == null || nums.length == 0) {
        return nums;
    }
    int length = nums.length;
    for (int i = 0; i < length - 1; i++) {
        // 提前退出冒泡循环的标志位
        boolean noSwap = true;
        for (int j = 0; j < length - 1 - i; j++) {
            if (nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
                // 表示有数据交换
                noSwap = false;
            }
        }
        if (noSwap) {
            // 没有数据交换，提前退出
            break;
        }
    }
    return nums;
}
```

