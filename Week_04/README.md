学习笔记



##### 深度优先搜索和广度优先搜索

树搜索： 遍历

1. 所有节点都要访问一次
2. 所有节点仅只访问一次

非递归深度优先搜索：使用一个栈来存储结点，将已访问过的结点出栈，记录其值，再将它的孩子结点依次入栈，进行循环，直到栈空。

广度优先遍历，使用队列。



##### 贪心算法 Greedy

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。



##### 二分查找

前提：

1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

代码模版：

```java
int left = 0;
int right = length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] < nums[left]) {
        right = mid - 1;
        ...
    } else if (nums[mid] > nums[right]) {
        left = mid + 1;
        ...
    } else {
        ...
    }
}
```



##### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

思路：

1. 数组长度为0，返回-1；
2. 数组长度为1，不存在旋转，返回元素；
3. 有序数组旋转，则第一元素一定大于最后一个，先判断数组是否旋转；
4. 使用二分法判断无序处：即当前元素小于前一个元素。



```java
public int findMin(int[] nums) {
    int length = nums.length;
    if (length == 0) {
        return -1;
    }
    if (length == 1) {
        return nums[0];
    }
    int left = 0;
    int right = length - 1;
    if (nums[left] < nums[right]) {
        return nums[left];
    }
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if (nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (nums[mid] < nums[left]) {
            right = mid - 1;
        } else if (nums[mid] > nums[right]) {
            left = mid + 1;
        }
    }
    return -1;
}
```

